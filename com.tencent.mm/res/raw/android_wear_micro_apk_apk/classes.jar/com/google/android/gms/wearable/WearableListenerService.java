package com.google.android.gms.wearable;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

public abstract class WearableListenerService
  extends Service
  implements c, g, q, x
{
  private IBinder IT;
  private ComponentName SI;
  private ad SJ;
  private Intent SK;
  private Looper SL;
  private final Object SM = new Object();
  private boolean SN;
  
  public void a(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void a(k paramk) {}
  
  public void a(s params) {}
  
  public void kA() {}
  
  public void kB() {}
  
  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction())) {
      return this.IT;
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.SI = new ComponentName(this, getClass().getName());
    Object localObject;
    if (Log.isLoggable("WearableLS", 3))
    {
      localObject = String.valueOf(this.SI);
      Log.d("WearableLS", String.valueOf(localObject).length() + 10 + "onCreate: " + (String)localObject);
    }
    if (this.SL == null)
    {
      localObject = new HandlerThread("WearableListenerService");
      ((HandlerThread)localObject).start();
      this.SL = ((HandlerThread)localObject).getLooper();
    }
    this.SJ = new ad(this, this.SL);
    this.SK = new Intent("com.google.android.gms.wearable.BIND_LISTENER");
    this.SK.setComponent(this.SI);
    this.IT = new ae(this, (byte)0);
  }
  
  public void onDestroy()
  {
    if (Log.isLoggable("WearableLS", 3))
    {
      ??? = String.valueOf(this.SI);
      Log.d("WearableLS", String.valueOf(???).length() + 11 + "onDestroy: " + (String)???);
    }
    synchronized (this.SM)
    {
      this.SN = true;
      if (this.SJ == null)
      {
        String str = String.valueOf(this.SI);
        throw new IllegalStateException(String.valueOf(str).length() + 111 + "onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=" + str);
      }
    }
    this.SJ.quit();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService
 * JD-Core Version:    0.7.0.1
 */