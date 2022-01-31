package com.tencent.tinker.loader.app;

import android.content.Context;
import android.content.res.Configuration;

public abstract interface ApplicationLifeCycle
{
  public abstract void onBaseContextAttached(Context paramContext);
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void onCreate();
  
  public abstract void onLowMemory();
  
  public abstract void onTerminate();
  
  public abstract void onTrimMemory(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.app.ApplicationLifeCycle
 * JD-Core Version:    0.7.0.1
 */