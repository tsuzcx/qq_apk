package com.tencent.tinker.entry;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Keep;

@Keep
public class DefaultApplicationLike
  extends ApplicationLike
{
  private static final String TAG = "Tinker.DefaultAppLike";
  
  public DefaultApplicationLike(Application paramApplication, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2, Intent paramIntent)
  {
    super(paramApplication, paramInt, paramBoolean, paramLong1, paramLong2, paramIntent);
  }
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    new StringBuilder("onConfigurationChanged:").append(paramConfiguration.toString());
  }
  
  public void onCreate() {}
  
  public void onLowMemory() {}
  
  public void onTerminate() {}
  
  public void onTrimMemory(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.entry.DefaultApplicationLike
 * JD-Core Version:    0.7.0.1
 */