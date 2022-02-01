package com.tencent.mm.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mm.c.a.b;
import java.util.concurrent.ConcurrentHashMap;

public class CommonProcessService
  extends Service
{
  private static ConcurrentHashMap<String, f> abG = new ConcurrentHashMap();
  private e abH = new e()
  {
    public final void a(final Intent paramAnonymousIntent)
    {
      b.Xb.a(963L, 53L, 1L, false);
      if (paramAnonymousIntent != null)
      {
        CommonProcessService.a(CommonProcessService.this).post(new Runnable()
        {
          public final void run()
          {
            paramAnonymousIntent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
            Object localObject = paramAnonymousIntent.getStringExtra("class_name");
            com.tencent.mm.sdk.platformtools.f.c(CommonProcessService.getTag(), "unbindService() class_name = %s", new Object[] { localObject });
            localObject = (f)CommonProcessService.lY().get(localObject);
            if (localObject == null) {
              return;
            }
            b.Xb.a(963L, 54L, 1L, false);
            ((f)localObject).a(paramAnonymousIntent, "unbind");
          }
        });
        return;
      }
      com.tencent.mm.sdk.platformtools.f.e(CommonProcessService.getTag(), "unbindService() intent == null");
    }
    
    public final void a(final Intent paramAnonymousIntent, final a paramAnonymousa)
    {
      b.Xb.a(963L, 38L, 1L, false);
      if (paramAnonymousIntent != null)
      {
        CommonProcessService.a(CommonProcessService.this).post(new Runnable()
        {
          public final void run()
          {
            paramAnonymousIntent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
            String str = paramAnonymousIntent.getStringExtra("class_name");
            try
            {
              com.tencent.mm.sdk.platformtools.f.c(CommonProcessService.getTag(), "bindService() class_name = %s", new Object[] { str });
              f localf2 = (f)CommonProcessService.lY().get(str);
              f localf1 = localf2;
              if (localf2 == null)
              {
                localf1 = (f)Class.forName(str).newInstance();
                localf1.a(CommonProcessService.lY());
                localf1.a(CommonProcessService.this);
                CommonProcessService.lY().put(str, localf1);
              }
              b.Xb.a(963L, 39L, 1L, false);
              localf1.a(paramAnonymousIntent, "bind");
              try
              {
                if (paramAnonymousa != null) {
                  paramAnonymousa.s(null);
                }
                return;
              }
              catch (RemoteException localRemoteException)
              {
                com.tencent.mm.sdk.platformtools.f.c(CommonProcessService.getTag(), "bindService() immserviceConnectionStubAIDL RemoteException: %s", new Object[] { localRemoteException.getMessage() });
                return;
              }
              return;
            }
            catch (Exception localException)
            {
              com.tencent.mm.sdk.platformtools.f.c(CommonProcessService.getTag(), "bindService()  Class.forName(%s) Exception: %s", new Object[] { str, localException.getMessage() });
            }
          }
        });
        return;
      }
      com.tencent.mm.sdk.platformtools.f.e(CommonProcessService.getTag(), "bindService() intent == null");
    }
    
    public final void b(final Intent paramAnonymousIntent)
    {
      b.Xb.a(963L, 23L, 1L, false);
      if (paramAnonymousIntent != null)
      {
        CommonProcessService.a(CommonProcessService.this).post(new Runnable()
        {
          public final void run()
          {
            paramAnonymousIntent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
            Object localObject = paramAnonymousIntent.getStringExtra("class_name");
            com.tencent.mm.sdk.platformtools.f.c(CommonProcessService.getTag(), "stopService() class_name = %s", new Object[] { localObject });
            localObject = (f)CommonProcessService.lY().get(localObject);
            if (localObject == null) {
              return;
            }
            b.Xb.a(963L, 24L, 1L, false);
            ((f)localObject).a(paramAnonymousIntent, "stop");
          }
        });
        return;
      }
      com.tencent.mm.sdk.platformtools.f.e(CommonProcessService.getTag(), "stopService() intent == null");
    }
    
    public final void startService(final Intent paramAnonymousIntent)
    {
      b.Xb.a(963L, 7L, 1L, false);
      if (paramAnonymousIntent != null)
      {
        CommonProcessService.a(CommonProcessService.this).post(new Runnable()
        {
          public final void run()
          {
            paramAnonymousIntent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
            String str = paramAnonymousIntent.getStringExtra("class_name");
            try
            {
              com.tencent.mm.sdk.platformtools.f.c(CommonProcessService.getTag(), "startService() class_name = %s", new Object[] { str });
              f localf2 = (f)CommonProcessService.lY().get(str);
              f localf1 = localf2;
              if (localf2 == null)
              {
                localf1 = (f)Class.forName(str).newInstance();
                localf1.a(CommonProcessService.lY());
                localf1.a(CommonProcessService.this);
                CommonProcessService.lY().put(str, localf1);
              }
              b.Xb.a(963L, 8L, 1L, false);
              localf1.a(paramAnonymousIntent, "start");
              return;
            }
            catch (Exception localException)
            {
              com.tencent.mm.sdk.platformtools.f.c(CommonProcessService.getTag(), "startService()  Class.forName(%s) Exception: %s", new Object[] { str, localException.getMessage() });
            }
          }
        });
        return;
      }
      com.tencent.mm.sdk.platformtools.f.e(CommonProcessService.getTag(), "startService() intent == null");
    }
  };
  private Handler handler;
  
  public static String getTag()
  {
    return "MicroMsg.MMProcessService";
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.f.e("MicroMsg.MMProcessService", "onBind()");
    return this.abH;
  }
  
  public void onCreate()
  {
    com.tencent.mm.sdk.platformtools.f.e("MicroMsg.MMProcessService", "onCreate()");
    this.handler = new Handler();
    super.onCreate();
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.platformtools.f.e("MicroMsg.MMProcessService", "onDestroy()");
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.f.e("MicroMsg.MMProcessService", "onRebind()");
    super.onRebind(paramIntent);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    com.tencent.mm.sdk.platformtools.f.e("MicroMsg.MMProcessService", "onStart()");
    super.onStart(paramIntent, paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    com.tencent.mm.sdk.platformtools.f.e("MicroMsg.MMProcessService", "onStartCommand()");
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.f.e("MicroMsg.MMProcessService", "onUnbind()");
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.service.CommonProcessService
 * JD-Core Version:    0.7.0.1
 */