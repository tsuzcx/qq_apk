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
  ConcurrentHashMap<String, MMService> NJP = new ConcurrentHashMap();
  protected Service NJZ;
  private Vector<Integer> NKa = new Vector();
  private byte NKb = 0;
  int cWG = 0;
  
  public IBinder akL()
  {
    Log.i(getTag(), "%s onBind()", new Object[] { "MicroMsg.MMService" });
    return null;
  }
  
  public String getTag()
  {
    return "MicroMsg.MMService";
  }
  
  public final void gxF()
  {
    this.NJZ.stopForeground(true);
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
  
  public final IBinder q(Intent paramIntent, String paramString)
  {
    int i = 2;
    String str = Integer.toBinaryString(this.NKb);
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
              if ((this.NKb & 0x5) == 0) {
                onCreate();
              }
              i = this.cWG + 1;
              this.cWG = i;
              onStartCommand(paramIntent, 0, i);
              this.NKb = ((byte)(this.NKb | 0x1));
              return null;
              if (this.NKb == 1)
              {
                onDestroy();
                this.NJP.remove(getClass().getName());
                return null;
              }
            } while (this.NKb == 4);
            if (this.NKb == 5)
            {
              this.NKb = 7;
              return null;
            }
          } while (this.NKb != 13);
          onDestroy();
          this.NJP.remove(getClass().getName());
          return null;
          paramIntent = Integer.valueOf(paramIntent.getIntExtra("service_connection", -1));
        } while (this.NKa.contains(paramIntent));
        this.NKa.add(paramIntent);
        if ((this.NKb & 0x5) == 0) {
          onCreate();
        }
        this.NKb = ((byte)(this.NKb | 0x4));
        return akL();
        i = paramIntent.getIntExtra("service_connection", -1);
        this.NKa.remove(Integer.valueOf(i));
      } while (this.NKb == 1);
      if (this.NKb == 4)
      {
        onUnbind(paramIntent);
        onDestroy();
        this.NJP.remove(getClass().getName());
        return null;
      }
      if (this.NKb == 5)
      {
        this.NKb = 13;
        onUnbind(paramIntent);
        return null;
      }
    } while (this.NKb != 7);
    onUnbind(paramIntent);
    onDestroy();
    this.NJP.remove(getClass().getName());
    return null;
  }
  
  public final void startActivity(Intent paramIntent)
  {
    Service localService = this.NJZ;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localService, paramIntent.axQ(), "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localService.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localService, "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public final void startForeground(int paramInt, Notification paramNotification)
  {
    this.NJZ.startForeground(paramInt, paramNotification);
  }
  
  public final void stopSelf()
  {
    Log.i(getTag(), "%s stopSelf()", new Object[] { "MicroMsg.MMService" });
    q(new Intent(), "stop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.service.MMService
 * JD-Core Version:    0.7.0.1
 */