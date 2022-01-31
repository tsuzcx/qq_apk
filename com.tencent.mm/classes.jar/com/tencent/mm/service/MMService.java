package com.tencent.mm.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public abstract class MMService
{
  int bOJ = 0;
  ConcurrentHashMap<String, MMService> ytB = new ConcurrentHashMap();
  protected Service ytK;
  private Vector<Integer> ytL = new Vector();
  private byte ytM = 0;
  
  public IBinder It()
  {
    ab.i(getTag(), "%s onBind()", new Object[] { "MicroMsg.MMService" });
    return null;
  }
  
  public final void duS()
  {
    this.ytK.stopForeground(true);
  }
  
  public String getTag()
  {
    return "MicroMsg.MMService";
  }
  
  public void onCreate()
  {
    ab.i(getTag(), "%s onCreate()", new Object[] { "MicroMsg.MMService" });
  }
  
  public void onDestroy()
  {
    ab.i(getTag(), "%s onDestroy()", new Object[] { "MicroMsg.MMService" });
  }
  
  @Deprecated
  public void onStart(Intent paramIntent, int paramInt)
  {
    ab.i(getTag(), "%s onStart()", new Object[] { "MicroMsg.MMService" });
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    ab.i(getTag(), "%s onStartCommand()", new Object[] { "MicroMsg.MMService" });
    onStart(paramIntent, paramInt2);
    return 0;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    ab.i(getTag(), "%s onUnbind()", new Object[] { "MicroMsg.MMService" });
    return false;
  }
  
  public final IBinder q(Intent paramIntent, String paramString)
  {
    int i = 2;
    String str = Integer.toBinaryString(this.ytM);
    ab.i(getTag(), "%s callLifeCycle() callType = %s state = %s", new Object[] { "MicroMsg.MMService", paramString, str });
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
              if ((this.ytM & 0x5) == 0) {
                onCreate();
              }
              i = this.bOJ + 1;
              this.bOJ = i;
              onStartCommand(paramIntent, 0, i);
              this.ytM = ((byte)(this.ytM | 0x1));
              return null;
              if (this.ytM == 1)
              {
                onDestroy();
                this.ytB.remove(getClass().getName());
                return null;
              }
            } while (this.ytM == 4);
            if (this.ytM == 5)
            {
              this.ytM = 7;
              return null;
            }
          } while (this.ytM != 13);
          onDestroy();
          this.ytB.remove(getClass().getName());
          return null;
          paramIntent = Integer.valueOf(paramIntent.getIntExtra("service_connection", -1));
        } while (this.ytL.contains(paramIntent));
        this.ytL.add(paramIntent);
        if ((this.ytM & 0x5) == 0) {
          onCreate();
        }
        this.ytM = ((byte)(this.ytM | 0x4));
        return It();
        i = paramIntent.getIntExtra("service_connection", -1);
        this.ytL.remove(Integer.valueOf(i));
      } while (this.ytM == 1);
      if (this.ytM == 4)
      {
        onUnbind(paramIntent);
        onDestroy();
        this.ytB.remove(getClass().getName());
        return null;
      }
      if (this.ytM == 5)
      {
        this.ytM = 13;
        onUnbind(paramIntent);
        return null;
      }
    } while (this.ytM != 7);
    onUnbind(paramIntent);
    onDestroy();
    this.ytB.remove(getClass().getName());
    return null;
  }
  
  public final void startActivity(Intent paramIntent)
  {
    this.ytK.startActivity(paramIntent);
  }
  
  public final void startForeground(int paramInt, Notification paramNotification)
  {
    this.ytK.startForeground(paramInt, paramNotification);
  }
  
  public final void stopSelf()
  {
    ab.i(getTag(), "%s stopSelf()", new Object[] { "MicroMsg.MMService" });
    q(new Intent(), "stop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.service.MMService
 * JD-Core Version:    0.7.0.1
 */