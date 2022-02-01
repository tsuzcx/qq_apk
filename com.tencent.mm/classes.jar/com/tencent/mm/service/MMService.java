package com.tencent.mm.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public abstract class MMService
{
  ConcurrentHashMap<String, MMService> GwV = new ConcurrentHashMap();
  protected Service Gxd;
  private Vector<Integer> Gxe = new Vector();
  private byte Gxf = 0;
  int cuE = 0;
  
  public IBinder Uz()
  {
    ac.i(getTag(), "%s onBind()", new Object[] { "MicroMsg.MMService" });
    return null;
  }
  
  public final void eXd()
  {
    this.Gxd.stopForeground(true);
  }
  
  public String getTag()
  {
    return "MicroMsg.MMService";
  }
  
  public void onCreate()
  {
    ac.i(getTag(), "%s onCreate()", new Object[] { "MicroMsg.MMService" });
  }
  
  public void onDestroy()
  {
    ac.i(getTag(), "%s onDestroy()", new Object[] { "MicroMsg.MMService" });
  }
  
  @Deprecated
  public void onStart(Intent paramIntent, int paramInt)
  {
    ac.i(getTag(), "%s onStart()", new Object[] { "MicroMsg.MMService" });
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    ac.i(getTag(), "%s onStartCommand()", new Object[] { "MicroMsg.MMService" });
    onStart(paramIntent, paramInt2);
    return 0;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    ac.i(getTag(), "%s onUnbind()", new Object[] { "MicroMsg.MMService" });
    return false;
  }
  
  public final IBinder s(Intent paramIntent, String paramString)
  {
    int i = 2;
    String str = Integer.toBinaryString(this.Gxf);
    ac.i(getTag(), "%s callLifeCycle() callType = %s state = %s", new Object[] { "MicroMsg.MMService", paramString, str });
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
              if ((this.Gxf & 0x5) == 0) {
                onCreate();
              }
              i = this.cuE + 1;
              this.cuE = i;
              onStartCommand(paramIntent, 0, i);
              this.Gxf = ((byte)(this.Gxf | 0x1));
              return null;
              if (this.Gxf == 1)
              {
                onDestroy();
                this.GwV.remove(getClass().getName());
                return null;
              }
            } while (this.Gxf == 4);
            if (this.Gxf == 5)
            {
              this.Gxf = 7;
              return null;
            }
          } while (this.Gxf != 13);
          onDestroy();
          this.GwV.remove(getClass().getName());
          return null;
          paramIntent = Integer.valueOf(paramIntent.getIntExtra("service_connection", -1));
        } while (this.Gxe.contains(paramIntent));
        this.Gxe.add(paramIntent);
        if ((this.Gxf & 0x5) == 0) {
          onCreate();
        }
        this.Gxf = ((byte)(this.Gxf | 0x4));
        return Uz();
        i = paramIntent.getIntExtra("service_connection", -1);
        this.Gxe.remove(Integer.valueOf(i));
      } while (this.Gxf == 1);
      if (this.Gxf == 4)
      {
        onUnbind(paramIntent);
        onDestroy();
        this.GwV.remove(getClass().getName());
        return null;
      }
      if (this.Gxf == 5)
      {
        this.Gxf = 13;
        onUnbind(paramIntent);
        return null;
      }
    } while (this.Gxf != 7);
    onUnbind(paramIntent);
    onDestroy();
    this.GwV.remove(getClass().getName());
    return null;
  }
  
  public final void startActivity(Intent paramIntent)
  {
    Service localService = this.Gxd;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localService, paramIntent.aeD(), "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localService.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localService, "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public final void startForeground(int paramInt, Notification paramNotification)
  {
    this.Gxd.startForeground(paramInt, paramNotification);
  }
  
  public final void stopSelf()
  {
    ac.i(getTag(), "%s stopSelf()", new Object[] { "MicroMsg.MMService" });
    s(new Intent(), "stop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.service.MMService
 * JD-Core Version:    0.7.0.1
 */