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
  ConcurrentHashMap<String, MMService> EZE = new ConcurrentHashMap();
  protected Service EZM;
  private Vector<Integer> EZN = new Vector();
  private byte EZO = 0;
  int cxv = 0;
  
  public IBinder TF()
  {
    ad.i(getTag(), "%s onBind()", new Object[] { "MicroMsg.MMService" });
    return null;
  }
  
  public final void eHH()
  {
    this.EZM.stopForeground(true);
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
    String str = Integer.toBinaryString(this.EZO);
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
              if ((this.EZO & 0x5) == 0) {
                onCreate();
              }
              i = this.cxv + 1;
              this.cxv = i;
              onStartCommand(paramIntent, 0, i);
              this.EZO = ((byte)(this.EZO | 0x1));
              return null;
              if (this.EZO == 1)
              {
                onDestroy();
                this.EZE.remove(getClass().getName());
                return null;
              }
            } while (this.EZO == 4);
            if (this.EZO == 5)
            {
              this.EZO = 7;
              return null;
            }
          } while (this.EZO != 13);
          onDestroy();
          this.EZE.remove(getClass().getName());
          return null;
          paramIntent = Integer.valueOf(paramIntent.getIntExtra("service_connection", -1));
        } while (this.EZN.contains(paramIntent));
        this.EZN.add(paramIntent);
        if ((this.EZO & 0x5) == 0) {
          onCreate();
        }
        this.EZO = ((byte)(this.EZO | 0x4));
        return TF();
        i = paramIntent.getIntExtra("service_connection", -1);
        this.EZN.remove(Integer.valueOf(i));
      } while (this.EZO == 1);
      if (this.EZO == 4)
      {
        onUnbind(paramIntent);
        onDestroy();
        this.EZE.remove(getClass().getName());
        return null;
      }
      if (this.EZO == 5)
      {
        this.EZO = 13;
        onUnbind(paramIntent);
        return null;
      }
    } while (this.EZO != 7);
    onUnbind(paramIntent);
    onDestroy();
    this.EZE.remove(getClass().getName());
    return null;
  }
  
  public final void startActivity(Intent paramIntent)
  {
    Service localService = this.EZM;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localService, paramIntent.adn(), "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localService.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localService, "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public final void startForeground(int paramInt, Notification paramNotification)
  {
    this.EZM.startForeground(paramInt, paramNotification);
  }
  
  public final void stopSelf()
  {
    ad.i(getTag(), "%s stopSelf()", new Object[] { "MicroMsg.MMService" });
    s(new Intent(), "stop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.service.MMService
 * JD-Core Version:    0.7.0.1
 */