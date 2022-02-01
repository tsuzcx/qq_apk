package io.flutter.embedding.engine.plugins.a;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Intent;

public abstract interface b
{
  public abstract void a(Activity paramActivity, Lifecycle paramLifecycle);
  
  public abstract boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void hwJ();
  
  public abstract void hwK();
  
  public abstract void hwL();
  
  public abstract void hwM();
  
  public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onNewIntent(Intent paramIntent);
  
  public abstract void onUserLeaveHint();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.a.b
 * JD-Core Version:    0.7.0.1
 */