package com.tencent.shadow.dynamic.loader;

import android.content.ComponentName;
import android.os.IBinder;

public abstract interface PluginServiceConnection
{
  public static final String DESCRIPTOR = "com.tencent.shadow.dynamic.loader.PluginServiceConnection";
  public static final int TRANSACTION_onServiceConnected = 1;
  public static final int TRANSACTION_onServiceDisconnected = 2;
  
  public abstract void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder);
  
  public abstract void onServiceDisconnected(ComponentName paramComponentName);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.dynamic.loader.PluginServiceConnection
 * JD-Core Version:    0.7.0.1
 */