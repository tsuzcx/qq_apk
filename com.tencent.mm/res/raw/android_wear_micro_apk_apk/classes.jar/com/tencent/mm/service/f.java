package com.tencent.mm.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public abstract class f
{
  private ConcurrentHashMap<String, f> abG = new ConcurrentHashMap();
  private int abM = 0;
  private Service abN;
  private Vector<Integer> abO = new Vector();
  private byte abP = 0;
  
  private static boolean lZ()
  {
    com.tencent.mm.sdk.platformtools.f.c("MicroMsg.MMService", "%s onUnbind()", new Object[] { "MicroMsg.MMService" });
    return false;
  }
  
  private static void onCreate()
  {
    com.tencent.mm.sdk.platformtools.f.c("MicroMsg.MMService", "%s onCreate()", new Object[] { "MicroMsg.MMService" });
  }
  
  private static void onDestroy()
  {
    com.tencent.mm.sdk.platformtools.f.c("MicroMsg.MMService", "%s onDestroy()", new Object[] { "MicroMsg.MMService" });
  }
  
  public final IBinder a(Intent paramIntent, String paramString)
  {
    int i = 2;
    com.tencent.mm.sdk.platformtools.f.c("MicroMsg.MMService", "%s callLifeCycle() callType = %s state = %s", new Object[] { "MicroMsg.MMService", paramString, Integer.toBinaryString(this.abP) });
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
      label82:
      switch (i)
      {
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
              if (!paramString.equals("start")) {
                break;
              }
              i = 0;
              break label82;
              if (!paramString.equals("stop")) {
                break;
              }
              i = 1;
              break label82;
              if (!paramString.equals("bind")) {
                break;
              }
              break label82;
              if (!paramString.equals("unbind")) {
                break;
              }
              i = 3;
              break label82;
              if ((this.abP & 0x5) == 0) {
                onCreate();
              }
              this.abM += 1;
              com.tencent.mm.sdk.platformtools.f.c("MicroMsg.MMService", "%s onStartCommand()", new Object[] { "MicroMsg.MMService" });
              com.tencent.mm.sdk.platformtools.f.c("MicroMsg.MMService", "%s onStart()", new Object[] { "MicroMsg.MMService" });
              this.abP = ((byte)(this.abP | 0x1));
              return null;
              if (this.abP == 1)
              {
                onDestroy();
                this.abG.remove(getClass().getName());
                return null;
              }
            } while (this.abP == 4);
            if (this.abP == 5)
            {
              this.abP = 7;
              return null;
            }
          } while (this.abP != 13);
          onDestroy();
          this.abG.remove(getClass().getName());
          return null;
          paramIntent = Integer.valueOf(paramIntent.getIntExtra("service_connection", -1));
        } while (this.abO.contains(paramIntent));
        this.abO.add(paramIntent);
        if ((this.abP & 0x5) == 0) {
          onCreate();
        }
        this.abP = ((byte)(this.abP | 0x4));
        com.tencent.mm.sdk.platformtools.f.c("MicroMsg.MMService", "%s onBind()", new Object[] { "MicroMsg.MMService" });
        return null;
        i = paramIntent.getIntExtra("service_connection", -1);
        this.abO.remove(Integer.valueOf(i));
      } while (this.abP == 1);
      if (this.abP == 4)
      {
        lZ();
        onDestroy();
        this.abG.remove(getClass().getName());
        return null;
      }
      if (this.abP == 5)
      {
        this.abP = 13;
        lZ();
        return null;
      }
    } while (this.abP != 7);
    lZ();
    onDestroy();
    this.abG.remove(getClass().getName());
    return null;
  }
  
  public final void a(Service paramService)
  {
    this.abN = paramService;
  }
  
  public final void a(ConcurrentHashMap<String, f> paramConcurrentHashMap)
  {
    this.abG = paramConcurrentHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.service.f
 * JD-Core Version:    0.7.0.1
 */