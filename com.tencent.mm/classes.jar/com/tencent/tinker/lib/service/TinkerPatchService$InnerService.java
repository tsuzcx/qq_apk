package com.tencent.tinker.lib.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.tinker.lib.f.a;

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
      startForeground(TinkerPatchService.access$000(), new Notification());
      stopSelf();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a.e("Tinker.TinkerPatchService", "InnerService set service for push exception:%s.", new Object[] { localThrowable });
      }
    }
  }
  
  public void onDestroy()
  {
    stopForeground(true);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService.InnerService
 * JD-Core Version:    0.7.0.1
 */