package com.tencent.shadow.dynamic.loader;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Map;

public abstract interface PluginLoader
{
  public static final String DESCRIPTOR = "com.tencent.shadow.dynamic.loader.PluginLoader";
  public static final int TRANSACTION_bindPluginService = 7;
  public static final int TRANSACTION_callApplicationOnCreate = 3;
  public static final int TRANSACTION_convertActivityIntent = 4;
  public static final int TRANSACTION_getLoadedPlugin = 2;
  public static final int TRANSACTION_loadPlugin = 1;
  public static final int TRANSACTION_startPluginService = 5;
  public static final int TRANSACTION_stopPluginService = 6;
  public static final int TRANSACTION_unbindService = 8;
  
  public abstract boolean bindPluginService(Intent paramIntent, PluginServiceConnection paramPluginServiceConnection, int paramInt);
  
  public abstract void callApplicationOnCreate(String paramString);
  
  public abstract Intent convertActivityIntent(Intent paramIntent);
  
  public abstract Map getLoadedPlugin();
  
  public abstract void loadPlugin(String paramString);
  
  public abstract ComponentName startPluginService(Intent paramIntent);
  
  public abstract boolean stopPluginService(Intent paramIntent);
  
  public abstract void unbindService(PluginServiceConnection paramPluginServiceConnection);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.dynamic.loader.PluginLoader
 * JD-Core Version:    0.7.0.1
 */