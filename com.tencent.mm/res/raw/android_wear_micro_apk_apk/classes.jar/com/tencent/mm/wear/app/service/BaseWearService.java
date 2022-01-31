package com.tencent.mm.wear.app.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.wear.a.c.d;

public abstract class BaseWearService
  extends Service
{
  protected abstract void c(Intent paramIntent);
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    d.c("MicroMsg.BaseWearService", "onCreate", new Object[0]);
  }
  
  public void onDestroy()
  {
    d.c("MicroMsg.BaseWearService", "onDestroy", new Object[0]);
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    d.c("MicroMsg.BaseWearService", "onStartCommand", new Object[0]);
    c(paramIntent);
    stopSelf();
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.service.BaseWearService
 * JD-Core Version:    0.7.0.1
 */