package com.tencent.mm.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public abstract class MMService
{
  ConcurrentHashMap<String, MMService> IiP = new ConcurrentHashMap();
  protected Service IiX;
  private Vector<Integer> IiY = new Vector();
  private byte IiZ = 0;
  int cFz = 0;
  
  public IBinder WQ()
  {
    ad.i(getTag(), "%s onBind()", new Object[] { "MicroMsg.MMService" });
    return null;
  }
  
  public final void fmN()
  {
    this.IiX.stopForeground(true);
  }
  
  public String getTag()
  {
    return "MicroMsg.MMService";
  }
  
  public void onCreate()
  {
    ad.i(getTag(), "%s onCreate()", new Object[] { "MicroMsg.MMService" });
  }
  
  public void onDestroy()
  {
    ad.i(getTag(), "%s onDestroy()", new Object[] { "MicroMsg.MMService" });
  }
  
  @Deprecated
  public void onStart(Intent paramIntent, int paramInt)
  {
    ad.i(getTag(), "%s onStart()", new Object[] { "MicroMsg.MMService" });
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    ad.i(getTag(), "%s onStartCommand()", new Object[] { "MicroMsg.MMService" });
    onStart(paramIntent, paramInt2);
    return 0;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    ad.i(getTag(), "%s onUnbind()", new Object[] { "MicroMsg.MMService" });
    return false;
  }
  
  public final IBinder s(Intent paramIntent, String paramString)
  {
    int i = 2;
    String str = Integer.toBinaryString(this.IiZ);
    ad.i(getTag(), "%s callLifeCycle() callType = %s state = %s", new Object[] { "MicroMsg.MMService", paramString, str });
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
      label86:
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
              break label86;
              if (!paramString.equals("stop")) {
                break;
              }
              i = 1;
              break label86;
              if (!paramString.equals("bind")) {
                break;
              }
              break label86;
              if (!paramString.equals("unbind")) {
                break;
              }
              i = 3;
              break label86;
              if ((this.IiZ & 0x5) == 0) {
                onCreate();
              }
              i = this.cFz + 1;
              this.cFz = i;
              onStartCommand(paramIntent, 0, i);
              this.IiZ = ((byte)(this.IiZ | 0x1));
              return null;
              if (this.IiZ == 1)
              {
                onDestroy();
                this.IiP.remove(getClass().getName());
                return null;
              }
            } while (this.IiZ == 4);
            if (this.IiZ == 5)
            {
              this.IiZ = 7;
              return null;
            }
          } while (this.IiZ != 13);
          onDestroy();
          this.IiP.remove(getClass().getName());
          return null;
          paramIntent = Integer.valueOf(paramIntent.getIntExtra("service_connection", -1));
        } while (this.IiY.contains(paramIntent));
        this.IiY.add(paramIntent);
        if ((this.IiZ & 0x5) == 0) {
          onCreate();
        }
        this.IiZ = ((byte)(this.IiZ | 0x4));
        return WQ();
        i = paramIntent.getIntExtra("service_connection", -1);
        this.IiY.remove(Integer.valueOf(i));
      } while (this.IiZ == 1);
      if (this.IiZ == 4)
      {
        onUnbind(paramIntent);
        onDestroy();
        this.IiP.remove(getClass().getName());
        return null;
      }
      if (this.IiZ == 5)
      {
        this.IiZ = 13;
        onUnbind(paramIntent);
        return null;
      }
    } while (this.IiZ != 7);
    onUnbind(paramIntent);
    onDestroy();
    this.IiP.remove(getClass().getName());
    return null;
  }
  
  public final void startActivity(Intent paramIntent)
  {
    Service localService = this.IiX;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localService, paramIntent.ahp(), "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localService.startActivity((Intent)paramIntent.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localService, "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public final void startForeground(int paramInt, Notification paramNotification)
  {
    this.IiX.startForeground(paramInt, paramNotification);
  }
  
  public final void stopSelf()
  {
    ad.i(getTag(), "%s stopSelf()", new Object[] { "MicroMsg.MMService" });
    s(new Intent(), "stop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.service.MMService
 * JD-Core Version:    0.7.0.1
 */