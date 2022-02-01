package io.flutter.app;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import io.flutter.plugin.a.m.a;
import io.flutter.plugin.a.m.d;

public abstract interface b
  extends ComponentCallbacks2, m.a, m.d
{
  public abstract void giJ();
  
  public abstract boolean onBackPressed();
  
  public abstract void onDestroy();
  
  public abstract void onNewIntent(Intent paramIntent);
  
  public abstract void onPause();
  
  public abstract void onPostResume();
  
  public abstract void onResume();
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract void onUserLeaveHint();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.app.b
 * JD-Core Version:    0.7.0.1
 */