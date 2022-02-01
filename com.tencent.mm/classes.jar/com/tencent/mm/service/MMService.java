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
  protected Service UXA;
  private Vector<Integer> UXB = new Vector();
  private byte UXC = 0;
  ConcurrentHashMap<String, MMService> UXq = new ConcurrentHashMap();
  int daG = 0;
  protected long kdD;
  
  public final void Uq(long paramLong)
  {
    this.kdD = paramLong;
  }
  
  public IBinder aqH()
  {
    Log.i(getTag(), "%s onBind()", new Object[] { "MicroMsg.MMService" });
    return null;
  }
  
  public final void d(int paramInt, Notification paramNotification)
  {
    this.UXA.startForeground(paramInt, paramNotification);
  }
  
  public String getTag()
  {
    return "MicroMsg.MMService";
  }
  
  public final void htD()
  {
    this.UXA.stopForeground(true);
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
  
  public final IBinder p(Intent paramIntent, String paramString)
  {
    int i = 2;
    String str = Integer.toBinaryString(this.UXC);
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
              if ((this.UXC & 0x5) == 0) {
                onCreate();
              }
              i = this.daG + 1;
              this.daG = i;
              onStartCommand(paramIntent, 0, i);
              this.UXC = ((byte)(this.UXC | 0x1));
              return null;
              if (this.UXC == 1)
              {
                onDestroy();
                this.UXq.remove(getClass().getName());
                return null;
              }
            } while (this.UXC == 4);
            if (this.UXC == 5)
            {
              this.UXC = 7;
              return null;
            }
          } while (this.UXC != 13);
          onDestroy();
          this.UXq.remove(getClass().getName());
          return null;
          paramIntent = Integer.valueOf(paramIntent.getIntExtra("service_connection", -1));
        } while (this.UXB.contains(paramIntent));
        this.UXB.add(paramIntent);
        if ((this.UXC & 0x5) == 0) {
          onCreate();
        }
        this.UXC = ((byte)(this.UXC | 0x4));
        return aqH();
        i = paramIntent.getIntExtra("service_connection", -1);
        this.UXB.remove(Integer.valueOf(i));
      } while (this.UXC == 1);
      if (this.UXC == 4)
      {
        onUnbind(paramIntent);
        onDestroy();
        this.UXq.remove(getClass().getName());
        return null;
      }
      if (this.UXC == 5)
      {
        this.UXC = 13;
        onUnbind(paramIntent);
        return null;
      }
    } while (this.UXC != 7);
    onUnbind(paramIntent);
    onDestroy();
    this.UXq.remove(getClass().getName());
    return null;
  }
  
  public final void startActivity(Intent paramIntent)
  {
    Service localService = this.UXA;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(localService, paramIntent.aFh(), "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localService.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localService, "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public final void stopSelf()
  {
    Log.i(getTag(), "%s stopSelf()", new Object[] { "MicroMsg.MMService" });
    p(new Intent(), "stop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.service.MMService
 * JD-Core Version:    0.7.0.1
 */