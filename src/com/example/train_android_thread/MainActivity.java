package com.example.train_android_thread;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ProgressBar progressBar;
	TextView textView;
	ProgressBar progressBar1;
	TextView textView1;
	Button button;
	Handler handler = new Handler();
	Integer progress = 0;
	Thread thread;
	Thread thread1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		progressBar = (ProgressBar) findViewById(R.id.progress);
		textView = (TextView) findViewById(R.id.tv_test);
		progressBar1 = (ProgressBar) findViewById(R.id.progress1);
		textView1 = (TextView) findViewById(R.id.tv_test1);
		button = (Button) findViewById(R.id.btn_start);
		thread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					progress += 1;
					handler.post(new Runnable() {

						@Override
						public void run() {
							textView.setText(progress.toString());
							progressBar.setProgress(progress);
						}
					});
					try {
						Thread.sleep(1000);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					progress += 1;
					handler.post(new Runnable() {

						@Override
						public void run() {
							textView1.setText(progress.toString());
							progressBar1.setProgress(progress);
						}
					});
					try {
						Thread.sleep(1000);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				thread.start();
				thread1.start();

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
