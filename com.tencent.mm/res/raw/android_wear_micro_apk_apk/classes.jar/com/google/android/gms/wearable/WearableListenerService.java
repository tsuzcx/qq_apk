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
  private IBinder KI;
  private Looper UA;
  private final Object UB = new Object();
  private boolean UC;
  private ComponentName Ux;
  private ad Uy;
  private Intent Uz;
  
  public void a(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void a(k paramk) {}
  
  public void a(s params) {}
  
  public void kJ() {}
  
  public void kK() {}
  
  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction())) {
      return this.KI;
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.Ux = new ComponentName(this, getClass().getName());
    Object localObject;
    if (Log.isLoggable("WearableLS", 3))
    {
      localObject = String.valueOf(this.Ux);
      Log.d("WearableLS", String.valueOf(localObject).length() + 10 + "onCreate: " + (String)localObject);
    }
    if (this.UA == null)
    {
      localObject = new HandlerThread("WearableListenerService");
      ((HandlerThread)localObject).start();
      this.UA = ((HandlerThread)localObject).getLooper();
    }
    this.Uy = new ad(this, this.UA);
    this.Uz = new Intent("com.google.android.gms.wearable.BIND_LISTENER");
    this.Uz.setComponent(this.Ux);
    this.KI = new ae(this, (byte)0);
  }
  
  public void onDestroy()
  {
    if (Log.isLoggable("WearableLS", 3))
    {
      ??? = String.valueOf(this.Ux);
      Log.d("WearableLS", String.valueOf(???).length() + 11 + "onDestroy: " + (String)???);
    }
    synchronized (this.UB)
    {
      this.UC = true;
      if (this.Uy == null)
      {
        String str = String.valueOf(this.Ux);
        throw new IllegalStateException(String.valueOf(str).length() + 111 + "onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=" + str);
      }
    }
    this.Uy.quit();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService
 * JD-Core Version:    0.7.0.1
 */