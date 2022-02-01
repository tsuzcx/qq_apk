package com.tencent.tinker.lib.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.tinker.lib.e.a;

public class TinkerPatchService$InnerService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    try
    {
      startForeground(TinkerPatchService.lA(), new Notification());
      stopSelf();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a.a("Tinker.TinkerPatchService", "InnerService set service for push exception:%s.", new Object[] { localThrowable });
      }
    }
  }
  
  public void onDestroy()
  {
    stopForeground(true);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService.InnerService
 * JD-Core Version:    0.7.0.1
 */