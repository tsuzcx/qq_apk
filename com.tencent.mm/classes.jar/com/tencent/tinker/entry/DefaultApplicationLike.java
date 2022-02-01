package com.tencent.tinker.entry;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;

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
    ShareTinkerLog.d("Tinker.DefaultAppLike", "onBaseContextAttached:", new Object[0]);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    ShareTinkerLog.d("Tinker.DefaultAppLike", "onConfigurationChanged:" + paramConfiguration.toString(), new Object[0]);
  }
  
  public void onCreate()
  {
    ShareTinkerLog.d("Tinker.DefaultAppLike", "onCreate", new Object[0]);
  }
  
  public void onLowMemory()
  {
    ShareTinkerLog.d("Tinker.DefaultAppLike", "onLowMemory", new Object[0]);
  }
  
  public void onTerminate()
  {
    ShareTinkerLog.d("Tinker.DefaultAppLike", "onTerminate", new Object[0]);
  }
  
  public void onTrimMemory(int paramInt)
  {
    ShareTinkerLog.d("Tinker.DefaultAppLike", "onTrimMemory level:".concat(String.valueOf(paramInt)), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.entry.DefaultApplicationLike
 * JD-Core Version:    0.7.0.1
 */