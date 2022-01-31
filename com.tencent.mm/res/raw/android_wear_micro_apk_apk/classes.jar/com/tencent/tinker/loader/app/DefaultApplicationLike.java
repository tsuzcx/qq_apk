package com.tencent.tinker.loader.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;

public class DefaultApplicationLike
  extends ApplicationLike
{
  private static final String TAG = "Tinker.DefaultAppLike";
  
  public DefaultApplicationLike(Application paramApplication, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2, Intent paramIntent)
  {
    super(paramApplication, paramInt, paramBoolean, paramLong1, paramLong2, paramIntent);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    Log.d("Tinker.DefaultAppLike", "onBaseContextAttached:");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Log.d("Tinker.DefaultAppLike", "onConfigurationChanged:" + paramConfiguration.toString());
  }
  
  public void onCreate()
  {
    Log.d("Tinker.DefaultAppLike", "onCreate");
  }
  
  public void onLowMemory()
  {
    Log.d("Tinker.DefaultAppLike", "onLowMemory");
  }
  
  public void onTerminate()
  {
    Log.d("Tinker.DefaultAppLike", "onTerminate");
  }
  
  public void onTrimMemory(int paramInt)
  {
    Log.d("Tinker.DefaultAppLike", "onTrimMemory level:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.app.DefaultApplicationLike
 * JD-Core Version:    0.7.0.1
 */