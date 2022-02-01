package com.tencent.mm.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.ConcurrentHashMap;

public class CommonProcessService
  extends Service
{
  private static ConcurrentHashMap<String, MMService> EZE;
  private b.a EZF;
  private Handler handler;
  
  static
  {
    AppMethodBeat.i(125303);
    EZE = new ConcurrentHashMap();
    AppMethodBeat.o(125303);
  }
  
  public CommonProcessService()
  {
    AppMethodBeat.i(125295);
    this.EZF = new b.a()
    {
      public final void a(final Intent paramAnonymousIntent, final a paramAnonymousa)
      {
        AppMethodBeat.i(125291);
        if (paramAnonymousIntent != null) {
          CommonProcessService.a(CommonProcessService.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(125287);
              paramAnonymousIntent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
              String str = paramAnonymousIntent.getStringExtra("class_name");
              try
              {
                MMService localMMService = (MMService)CommonProcessService.aGw().get(str);
                Object localObject = localMMService;
                if (localMMService == null)
                {
                  localObject = (MMService)Class.forName(str).newInstance();
                  ((MMService)localObject).EZE = CommonProcessService.aGw();
                  ((MMService)localObject).EZM = CommonProcessService.this;
                  CommonProcessService.aGw().put(str, localObject);
                }
                localObject = ((MMService)localObject).s(paramAnonymousIntent, "bind");
                try
                {
                  if (paramAnonymousa != null) {
                    paramAnonymousa.N((IBinder)localObject);
                  }
                  e.vIY.idkeyStat(963L, 39L, 1L, false);
                  ad.i(CommonProcessService.this.getTag(), "bindService() class_name = %s", new Object[] { str });
                  AppMethodBeat.o(125287);
                  return;
                }
                catch (RemoteException localRemoteException)
                {
                  for (;;)
                  {
                    ad.i(CommonProcessService.this.getTag(), "bindService() immserviceConnectionStubAIDL RemoteException: %s", new Object[] { localRemoteException.getMessage() });
                  }
                }
                return;
              }
              catch (Exception localException)
              {
                ad.i(CommonProcessService.this.getTag(), "bindService()  Class.forName(%s) Exception: %s", new Object[] { str, localException.getMessage() });
                AppMethodBeat.o(125287);
              }
            }
          });
        }
        for (;;)
        {
          e.vIY.idkeyStat(963L, 38L, 1L, false);
          AppMethodBeat.o(125291);
          return;
          ad.i(CommonProcessService.this.getTag(), "bindService() intent == null");
        }
      }
      
      public final void aY(final Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(125293);
        if (paramAnonymousIntent != null) {
          CommonProcessService.a(CommonProcessService.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(125289);
              paramAnonymousIntent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
              String str = paramAnonymousIntent.getStringExtra("class_name");
              try
              {
                MMService localMMService2 = (MMService)CommonProcessService.aGw().get(str);
                MMService localMMService1 = localMMService2;
                if (localMMService2 == null)
                {
                  localMMService1 = (MMService)Class.forName(str).newInstance();
                  localMMService1.EZE = CommonProcessService.aGw();
                  localMMService1.EZM = CommonProcessService.this;
                  CommonProcessService.aGw().put(str, localMMService1);
                }
                localMMService1.s(paramAnonymousIntent, "start");
                e.vIY.idkeyStat(963L, 8L, 1L, false);
                ad.i(CommonProcessService.this.getTag(), "startService() class_name = %s", new Object[] { str });
                AppMethodBeat.o(125289);
                return;
              }
              catch (Exception localException)
              {
                ad.i(CommonProcessService.this.getTag(), "startService()  Class.forName(%s) Exception: %s", new Object[] { str, localException.getMessage() });
                AppMethodBeat.o(125289);
              }
            }
          });
        }
        for (;;)
        {
          e.vIY.idkeyStat(963L, 7L, 1L, false);
          AppMethodBeat.o(125293);
          return;
          ad.i(CommonProcessService.this.getTag(), "startService() intent == null");
        }
      }
      
      public final void aZ(final Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(125294);
        if (paramAnonymousIntent != null) {
          CommonProcessService.a(CommonProcessService.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(125290);
              paramAnonymousIntent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
              String str = paramAnonymousIntent.getStringExtra("class_name");
              MMService localMMService = (MMService)CommonProcessService.aGw().get(str);
              if (localMMService != null)
              {
                localMMService.s(paramAnonymousIntent, "stop");
                e.vIY.idkeyStat(963L, 24L, 1L, false);
              }
              ad.i(CommonProcessService.this.getTag(), "stopService() class_name = %s", new Object[] { str });
              AppMethodBeat.o(125290);
            }
          });
        }
        for (;;)
        {
          e.vIY.idkeyStat(963L, 23L, 1L, false);
          AppMethodBeat.o(125294);
          return;
          ad.i(CommonProcessService.this.getTag(), "stopService() intent == null");
        }
      }
      
      public final void bf(final Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(125292);
        if (paramAnonymousIntent != null) {
          CommonProcessService.a(CommonProcessService.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(125288);
              paramAnonymousIntent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
              String str = paramAnonymousIntent.getStringExtra("class_name");
              MMService localMMService = (MMService)CommonProcessService.aGw().get(str);
              if (localMMService != null)
              {
                localMMService.s(paramAnonymousIntent, "unbind");
                e.vIY.idkeyStat(963L, 54L, 1L, false);
              }
              ad.i(CommonProcessService.this.getTag(), "unbindService() class_name = %s", new Object[] { str });
              AppMethodBeat.o(125288);
            }
          });
        }
        for (;;)
        {
          e.vIY.idkeyStat(963L, 53L, 1L, false);
          AppMethodBeat.o(125292);
          return;
          ad.i(CommonProcessService.this.getTag(), "unbindService() intent == null");
        }
      }
    };
    AppMethodBeat.o(125295);
  }
  
  public String getTag()
  {
    return "MicroMsg.MMProcessService";
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(125302);
    ad.i(getTag(), "onBind()");
    paramIntent = this.EZF;
    AppMethodBeat.o(125302);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(125296);
    ad.i(getTag(), "onCreate()");
    this.handler = new Handler();
    super.onCreate();
    AppMethodBeat.o(125296);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125299);
    ad.i(getTag(), "onDestroy()");
    super.onDestroy();
    AppMethodBeat.o(125299);
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(125301);
    ad.i(getTag(), "onRebind()");
    super.onRebind(paramIntent);
    AppMethodBeat.o(125301);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(125297);
    ad.i(getTag(), "onStart()");
    super.onStart(paramIntent, paramInt);
    AppMethodBeat.o(125297);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125298);
    ad.i(getTag(), "onStartCommand()");
    AppMethodBeat.o(125298);
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(125300);
    ad.i(getTag(), "onUnbind()");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(125300);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.service.CommonProcessService
 * JD-Core Version:    0.7.0.1
 */