package com.tencent.mm.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public abstract class MMService
{
  ConcurrentHashMap<String, MMService> IDa = new ConcurrentHashMap();
  protected Service IDi;
  private Vector<Integer> IDj = new Vector();
  private byte IDk = 0;
  int cGi = 0;
  
  public IBinder WY()
  {
    ae.i(getTag(), "%s onBind()", new Object[] { "MicroMsg.MMService" });
    return null;
  }
  
  public final void fqI()
  {
    this.IDi.stopForeground(true);
  }
  
  public String getTag()
  {
    return "MicroMsg.MMService";
  }
  
  public void onCreate()
  {
    ae.i(getTag(), "%s onCreate()", new Object[] { "MicroMsg.MMService" });
  }
  
  public void onDestroy()
  {
    ae.i(getTag(), "%s onDestroy()", new Object[] { "MicroMsg.MMService" });
  }
  
  @Deprecated
  public void onStart(Intent paramIntent, int paramInt)
  {
    ae.i(getTag(), "%s onStart()", new Object[] { "MicroMsg.MMService" });
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    ae.i(getTag(), "%s onStartCommand()", new Object[] { "MicroMsg.MMService" });
    onStart(paramIntent, paramInt2);
    return 0;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    ae.i(getTag(), "%s onUnbind()", new Object[] { "MicroMsg.MMService" });
    return false;
  }
  
  public final IBinder s(Intent paramIntent, String paramString)
  {
    int i = 2;
    String str = Integer.toBinaryString(this.IDk);
    ae.i(getTag(), "%s callLifeCycle() callType = %s state = %s", new Object[] { "MicroMsg.MMService", paramString, str });
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
              if ((this.IDk & 0x5) == 0) {
                onCreate();
              }
              i = this.cGi + 1;
              this.cGi = i;
              onStartCommand(paramIntent, 0, i);
              this.IDk = ((byte)(this.IDk | 0x1));
              return null;
              if (this.IDk == 1)
              {
                onDestroy();
                this.IDa.remove(getClass().getName());
                return null;
              }
            } while (this.IDk == 4);
            if (this.IDk == 5)
            {
              this.IDk = 7;
              return null;
            }
          } while (this.IDk != 13);
          onDestroy();
          this.IDa.remove(getClass().getName());
          return null;
          paramIntent = Integer.valueOf(paramIntent.getIntExtra("service_connection", -1));
        } while (this.IDj.contains(paramIntent));
        this.IDj.add(paramIntent);
        if ((this.IDk & 0x5) == 0) {
          onCreate();
        }
        this.IDk = ((byte)(this.IDk | 0x4));
        return WY();
        i = paramIntent.getIntExtra("service_connection", -1);
        this.IDj.remove(Integer.valueOf(i));
      } while (this.IDk == 1);
      if (this.IDk == 4)
      {
        onUnbind(paramIntent);
        onDestroy();
        this.IDa.remove(getClass().getName());
        return null;
      }
      if (this.IDk == 5)
      {
        this.IDk = 13;
        onUnbind(paramIntent);
        return null;
      }
    } while (this.IDk != 7);
    onUnbind(paramIntent);
    onDestroy();
    this.IDa.remove(getClass().getName());
    return null;
  }
  
  public final void startActivity(Intent paramIntent)
  {
    Service localService = this.IDi;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localService, paramIntent.ahE(), "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localService.startActivity((Intent)paramIntent.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localService, "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public final void startForeground(int paramInt, Notification paramNotification)
  {
    this.IDi.startForeground(paramInt, paramNotification);
  }
  
  public final void stopSelf()
  {
    ae.i(getTag(), "%s stopSelf()", new Object[] { "MicroMsg.MMService" });
    s(new Intent(), "stop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.service.MMService
 * JD-Core Version:    0.7.0.1
 */