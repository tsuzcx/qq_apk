package io.flutter.embedding.engine.plugins.a;

import android.app.Activity;
import android.content.Intent;
import androidx.lifecycle.h;
import io.flutter.embedding.android.c;

public abstract interface b
{
  @Deprecated
  public abstract void a(Activity paramActivity, h paramh);
  
  public abstract void a(c<Activity> paramc, h paramh);
  
  public abstract boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void iAN();
  
  public abstract void iAO();
  
  public abstract void iAQ();
  
  public abstract void iAR();
  
  public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onNewIntent(Intent paramIntent);
  
  public abstract void onUserLeaveHint();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.a.b
 * JD-Core Version:    0.7.0.1
 */