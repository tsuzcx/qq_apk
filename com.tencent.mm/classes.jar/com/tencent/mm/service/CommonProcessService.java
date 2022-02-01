package com.tencent.mm.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.concurrent.ConcurrentHashMap;

public class CommonProcessService
  extends Service
{
  private static ConcurrentHashMap<String, MMService> GwV;
  private b.a GwW;
  private Handler handler;
  
  static
  {
    AppMethodBeat.i(125303);
    GwV = new ConcurrentHashMap();
    AppMethodBeat.o(125303);
  }
  
  public CommonProcessService()
  {
    AppMethodBeat.i(125295);
    this.GwW = new b.a()
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
                MMService localMMService = (MMService)CommonProcessService.aNj().get(str);
                Object localObject = localMMService;
                if (localMMService == null)
                {
                  localObject = (MMService)Class.forName(str).newInstance();
                  ((MMService)localObject).GwV = CommonProcessService.aNj();
                  ((MMService)localObject).Gxd = CommonProcessService.this;
                  CommonProcessService.aNj().put(str, localObject);
                }
                localObject = ((MMService)localObject).s(paramAnonymousIntent, "bind");
                try
                {
                  if (paramAnonymousa != null) {
                    paramAnonymousa.N((IBinder)localObject);
                  }
                  e.wTc.idkeyStat(963L, 39L, 1L, false);
                  ac.i(CommonProcessService.this.getTag(), "bindService() class_name = %s", new Object[] { str });
                  AppMethodBeat.o(125287);
                  return;
                }
                catch (RemoteException localRemoteException)
                {
                  for (;;)
                  {
                    ac.i(CommonProcessService.this.getTag(), "bindService() immserviceConnectionStubAIDL RemoteException: %s", new Object[] { localRemoteException.getMessage() });
                  }
                }
                return;
              }
              catch (Exception localException)
              {
                ac.i(CommonProcessService.this.getTag(), "bindService()  Class.forName(%s) Exception: %s", new Object[] { str, localException.getMessage() });
                AppMethodBeat.o(125287);
              }
            }
          });
        }
        for (;;)
        {
          e.wTc.idkeyStat(963L, 38L, 1L, false);
          AppMethodBeat.o(125291);
          return;
          ac.i(CommonProcessService.this.getTag(), "bindService() intent == null");
        }
      }
      
      public final void aZ(final Intent paramAnonymousIntent)
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
                MMService localMMService2 = (MMService)CommonProcessService.aNj().get(str);
                MMService localMMService1 = localMMService2;
                if (localMMService2 == null)
                {
                  localMMService1 = (MMService)Class.forName(str).newInstance();
                  localMMService1.GwV = CommonProcessService.aNj();
                  localMMService1.Gxd = CommonProcessService.this;
                  CommonProcessService.aNj().put(str, localMMService1);
                }
                localMMService1.s(paramAnonymousIntent, "start");
                e.wTc.idkeyStat(963L, 8L, 1L, false);
                ac.i(CommonProcessService.this.getTag(), "startService() class_name = %s", new Object[] { str });
                AppMethodBeat.o(125289);
                return;
              }
              catch (Exception localException)
              {
                ac.i(CommonProcessService.this.getTag(), "startService()  Class.forName(%s) Exception: %s", new Object[] { str, localException.getMessage() });
                AppMethodBeat.o(125289);
              }
            }
          });
        }
        for (;;)
        {
          e.wTc.idkeyStat(963L, 7L, 1L, false);
          AppMethodBeat.o(125293);
          return;
          ac.i(CommonProcessService.this.getTag(), "startService() intent == null");
        }
      }
      
      public final void ba(final Intent paramAnonymousIntent)
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
              MMService localMMService = (MMService)CommonProcessService.aNj().get(str);
              if (localMMService != null)
              {
                localMMService.s(paramAnonymousIntent, "stop");
                e.wTc.idkeyStat(963L, 24L, 1L, false);
              }
              ac.i(CommonProcessService.this.getTag(), "stopService() class_name = %s", new Object[] { str });
              AppMethodBeat.o(125290);
            }
          });
        }
        for (;;)
        {
          e.wTc.idkeyStat(963L, 23L, 1L, false);
          AppMethodBeat.o(125294);
          return;
          ac.i(CommonProcessService.this.getTag(), "stopService() intent == null");
        }
      }
      
      public final void bg(final Intent paramAnonymousIntent)
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
              MMService localMMService = (MMService)CommonProcessService.aNj().get(str);
              if (localMMService != null)
              {
                localMMService.s(paramAnonymousIntent, "unbind");
                e.wTc.idkeyStat(963L, 54L, 1L, false);
              }
              ac.i(CommonProcessService.this.getTag(), "unbindService() class_name = %s", new Object[] { str });
              AppMethodBeat.o(125288);
            }
          });
        }
        for (;;)
        {
          e.wTc.idkeyStat(963L, 53L, 1L, false);
          AppMethodBeat.o(125292);
          return;
          ac.i(CommonProcessService.this.getTag(), "unbindService() intent == null");
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
    ac.i(getTag(), "onBind()");
    paramIntent = this.GwW;
    AppMethodBeat.o(125302);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(125296);
    ac.i(getTag(), "onCreate()");
    this.handler = new Handler();
    super.onCreate();
    AppMethodBeat.o(125296);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125299);
    ac.i(getTag(), "onDestroy()");
    super.onDestroy();
    AppMethodBeat.o(125299);
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(125301);
    ac.i(getTag(), "onRebind()");
    super.onRebind(paramIntent);
    AppMethodBeat.o(125301);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(125297);
    ac.i(getTag(), "onStart()");
    super.onStart(paramIntent, paramInt);
    AppMethodBeat.o(125297);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125298);
    ac.i(getTag(), "onStartCommand()");
    AppMethodBeat.o(125298);
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(125300);
    ac.i(getTag(), "onUnbind()");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(125300);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.service.CommonProcessService
 * JD-Core Version:    0.7.0.1
 */