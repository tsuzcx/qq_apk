package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.j;
import io.flutter.embedding.android.ExclusiveAppComponent;

public abstract interface ActivityControlSurface
{
  @Deprecated
  public abstract void attachToActivity(Activity paramActivity, j paramj);
  
  public abstract void attachToActivity(ExclusiveAppComponent<Activity> paramExclusiveAppComponent, j paramj);
  
  public abstract void detachFromActivity();
  
  public abstract void detachFromActivityForConfigChanges();
  
  public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onNewIntent(Intent paramIntent);
  
  public abstract boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onRestoreInstanceState(Bundle paramBundle);
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
  
  public abstract void onUserLeaveHint();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
 * JD-Core Version:    0.7.0.1
 */