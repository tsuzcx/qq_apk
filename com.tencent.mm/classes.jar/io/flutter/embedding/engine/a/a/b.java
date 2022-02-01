package io.flutter.embedding.engine.a.a;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Intent;

public abstract interface b
{
  public abstract void a(Activity paramActivity, Lifecycle paramLifecycle);
  
  public abstract boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void fuH();
  
  public abstract void fuI();
  
  public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onNewIntent(Intent paramIntent);
  
  public abstract void onUserLeaveHint();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.a.a.b
 * JD-Core Version:    0.7.0.1
 */