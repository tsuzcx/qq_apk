package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import android.os.Bundle;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import io.flutter.plugin.common.PluginRegistry.NewIntentListener;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;
import io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener;

public abstract interface ActivityPluginBinding
{
  public abstract void addActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener);
  
  public abstract void addOnNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener);
  
  public abstract void addOnSaveStateListener(OnSaveInstanceStateListener paramOnSaveInstanceStateListener);
  
  public abstract void addOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener);
  
  public abstract void addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener);
  
  public abstract Activity getActivity();
  
  public abstract Object getLifecycle();
  
  public abstract void removeActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener);
  
  public abstract void removeOnNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener);
  
  public abstract void removeOnSaveStateListener(OnSaveInstanceStateListener paramOnSaveInstanceStateListener);
  
  public abstract void removeOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener);
  
  public abstract void removeRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener);
  
  public static abstract interface OnSaveInstanceStateListener
  {
    public abstract void onRestoreInstanceState(Bundle paramBundle);
    
    public abstract void onSaveInstanceState(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
 * JD-Core Version:    0.7.0.1
 */