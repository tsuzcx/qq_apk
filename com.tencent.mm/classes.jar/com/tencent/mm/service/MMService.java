package com.tencent.mm.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public abstract class MMService
{
  ConcurrentHashMap<String, MMService> acwi = new ConcurrentHashMap();
  protected Service acws;
  private Vector<Integer> acwt = new Vector();
  private byte acwu = 0;
  int eZg = 0;
  protected long mDN;
  
  public IBinder aKF()
  {
    Log.i(getTag(), "%s onBind()", new Object[] { "MicroMsg.MMService" });
    return null;
  }
  
  public final void d(int paramInt, Notification paramNotification)
  {
    this.acws.startForeground(paramInt, paramNotification);
  }
  
  public String getTag()
  {
    return "MicroMsg.MMService";
  }
  
  public final void iUE()
  {
    this.acws.stopForeground(true);
  }
  
  public void onCreate()
  {
    Log.i(getTag(), "%s onCreate()", new Object[] { "MicroMsg.MMService" });
  }
  
  public void onDestroy()
  {
    Log.i(getTag(), "%s onDestroy()", new Object[] { "MicroMsg.MMService" });
  }
  
  @Deprecated
  public void onStart(Intent paramIntent, int paramInt)
  {
    Log.i(getTag(), "%s onStart()", new Object[] { "MicroMsg.MMService" });
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Log.i(getTag(), "%s onStartCommand()", new Object[] { "MicroMsg.MMService" });
    onStart(paramIntent, paramInt2);
    return 0;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Log.i(getTag(), "%s onUnbind()", new Object[] { "MicroMsg.MMService" });
    return false;
  }
  
  public final IBinder r(Intent paramIntent, String paramString)
  {
    int i = 2;
    String str = Integer.toBinaryString(this.acwu);
    Log.i(getTag(), "%s callLifeCycle() callType = %s state = %s", new Object[] { "MicroMsg.MMService", paramString, str });
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
              if ((this.acwu & 0x5) == 0) {
                onCreate();
              }
              i = this.eZg + 1;
              this.eZg = i;
              onStartCommand(paramIntent, 0, i);
              this.acwu = ((byte)(this.acwu | 0x1));
              return null;
              if (this.acwu == 1)
              {
                onDestroy();
                this.acwi.remove(getClass().getName());
                return null;
              }
            } while (this.acwu == 4);
            if (this.acwu == 5)
            {
              this.acwu = 7;
              return null;
            }
          } while (this.acwu != 13);
          onDestroy();
          this.acwi.remove(getClass().getName());
          return null;
          paramIntent = Integer.valueOf(paramIntent.getIntExtra("service_connection", -1));
        } while (this.acwt.contains(paramIntent));
        this.acwt.add(paramIntent);
        if ((this.acwu & 0x5) == 0) {
          onCreate();
        }
        this.acwu = ((byte)(this.acwu | 0x4));
        return aKF();
        i = paramIntent.getIntExtra("service_connection", -1);
        this.acwt.remove(Integer.valueOf(i));
      } while (this.acwu == 1);
      if (this.acwu == 4)
      {
        onUnbind(paramIntent);
        onDestroy();
        this.acwi.remove(getClass().getName());
        return null;
      }
      if (this.acwu == 5)
      {
        this.acwu = 13;
        onUnbind(paramIntent);
        return null;
      }
    } while (this.acwu != 7);
    onUnbind(paramIntent);
    onDestroy();
    this.acwi.remove(getClass().getName());
    return null;
  }
  
  public final void startActivity(Intent paramIntent)
  {
    Service localService = this.acws;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(localService, paramIntent.aYi(), "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localService.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localService, "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public final void stopSelf()
  {
    Log.i(getTag(), "%s stopSelf()", new Object[] { "MicroMsg.MMService" });
    r(new Intent(), "stop");
  }
  
  public final void yC(long paramLong)
  {
    this.mDN = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.service.MMService
 * JD-Core Version:    0.7.0.1
 */