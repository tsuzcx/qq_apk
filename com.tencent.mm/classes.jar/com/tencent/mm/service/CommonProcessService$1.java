package com.tencent.mm.service;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

final class CommonProcessService$1
  extends b.a
{
  CommonProcessService$1(CommonProcessService paramCommonProcessService) {}
  
  public final void a(final Intent paramIntent, final a parama)
  {
    AppMethodBeat.i(125291);
    if (paramIntent != null) {
      CommonProcessService.b(this.acwk).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125287);
          paramIntent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
          String str = paramIntent.getStringExtra("class_name");
          try
          {
            MMService localMMService = (MMService)CommonProcessService.bTA().get(str);
            Object localObject = localMMService;
            if (localMMService == null)
            {
              localObject = (MMService)Class.forName(str).newInstance();
              ((MMService)localObject).acwi = CommonProcessService.bTA();
              ((MMService)localObject).acws = CommonProcessService.1.this.acwk;
              ((MMService)localObject).yC(CommonProcessService.a(CommonProcessService.1.this.acwk));
              CommonProcessService.bTA().put(str, localObject);
            }
            localObject = ((MMService)localObject).r(paramIntent, "bind");
            try
            {
              if (parama != null) {
                parama.X((IBinder)localObject);
              }
              f.Ozc.idkeyStat(963L, 39L, 1L, false);
              Log.i(CommonProcessService.1.this.acwk.getTag(), "bindService() class_name = %s", new Object[] { str });
              AppMethodBeat.o(125287);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              for (;;)
              {
                Log.i(CommonProcessService.1.this.acwk.getTag(), "bindService() immserviceConnectionStubAIDL RemoteException: %s", new Object[] { localRemoteException.getMessage() });
              }
            }
            return;
          }
          catch (Exception localException)
          {
            Log.i(CommonProcessService.1.this.acwk.getTag(), "bindService()  Class.forName(%s) Exception: %s", new Object[] { str, localException.getMessage() });
            AppMethodBeat.o(125287);
          }
        }
      });
    }
    for (;;)
    {
      f.Ozc.idkeyStat(963L, 38L, 1L, false);
      AppMethodBeat.o(125291);
      return;
      Log.i(this.acwk.getTag(), "bindService() intent == null");
    }
  }
  
  public final void bV(final Intent paramIntent)
  {
    AppMethodBeat.i(125294);
    if (paramIntent != null) {
      CommonProcessService.b(this.acwk).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125290);
          paramIntent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
          String str = paramIntent.getStringExtra("class_name");
          MMService localMMService = (MMService)CommonProcessService.bTA().get(str);
          if (localMMService != null)
          {
            localMMService.r(paramIntent, "stop");
            f.Ozc.idkeyStat(963L, 24L, 1L, false);
          }
          Log.i(CommonProcessService.1.this.acwk.getTag(), "stopService() class_name = %s", new Object[] { str });
          AppMethodBeat.o(125290);
        }
      });
    }
    for (;;)
    {
      f.Ozc.idkeyStat(963L, 23L, 1L, false);
      AppMethodBeat.o(125294);
      return;
      Log.i(this.acwk.getTag(), "stopService() intent == null");
    }
  }
  
  public final void ca(final Intent paramIntent)
  {
    AppMethodBeat.i(125292);
    if (paramIntent != null) {
      CommonProcessService.b(this.acwk).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125288);
          paramIntent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
          String str = paramIntent.getStringExtra("class_name");
          MMService localMMService = (MMService)CommonProcessService.bTA().get(str);
          if (localMMService != null)
          {
            localMMService.r(paramIntent, "unbind");
            f.Ozc.idkeyStat(963L, 54L, 1L, false);
          }
          Log.i(CommonProcessService.1.this.acwk.getTag(), "unbindService() class_name = %s", new Object[] { str });
          AppMethodBeat.o(125288);
        }
      });
    }
    for (;;)
    {
      f.Ozc.idkeyStat(963L, 53L, 1L, false);
      AppMethodBeat.o(125292);
      return;
      Log.i(this.acwk.getTag(), "unbindService() intent == null");
    }
  }
  
  public final void startService(final Intent paramIntent)
  {
    AppMethodBeat.i(125293);
    if (paramIntent != null) {
      CommonProcessService.b(this.acwk).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125289);
          paramIntent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
          String str = paramIntent.getStringExtra("class_name");
          try
          {
            MMService localMMService2 = (MMService)CommonProcessService.bTA().get(str);
            MMService localMMService1 = localMMService2;
            if (localMMService2 == null)
            {
              localMMService1 = (MMService)Class.forName(str).newInstance();
              localMMService1.acwi = CommonProcessService.bTA();
              localMMService1.acws = CommonProcessService.1.this.acwk;
              localMMService1.yC(CommonProcessService.a(CommonProcessService.1.this.acwk));
              CommonProcessService.bTA().put(str, localMMService1);
            }
            localMMService1.r(paramIntent, "start");
            f.Ozc.idkeyStat(963L, 8L, 1L, false);
            Log.i(CommonProcessService.1.this.acwk.getTag(), "startService() class_name = %s", new Object[] { str });
            AppMethodBeat.o(125289);
            return;
          }
          catch (Exception localException)
          {
            Log.i(CommonProcessService.1.this.acwk.getTag(), "startService()  Class.forName(%s) Exception: %s", new Object[] { str, localException.getMessage() });
            AppMethodBeat.o(125289);
          }
        }
      });
    }
    for (;;)
    {
      f.Ozc.idkeyStat(963L, 7L, 1L, false);
      AppMethodBeat.o(125293);
      return;
      Log.i(this.acwk.getTag(), "startService() intent == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.service.CommonProcessService.1
 * JD-Core Version:    0.7.0.1
 */