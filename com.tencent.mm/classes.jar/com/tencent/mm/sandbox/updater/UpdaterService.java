package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.IBinder;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.m;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.model.ad.a;
import com.tencent.mm.sandbox.monitor.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.service.MMService;
import com.tencent.mm.ui.MMActivity;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@m
public class UpdaterService
  extends MMService
{
  private static UpdaterService acoK = null;
  static long acoM = 1800000L;
  Map<Integer, a> acoL;
  private MTimerHandler acoN;
  private a acoO;
  private boolean ffv;
  
  public UpdaterService()
  {
    AppMethodBeat.i(32801);
    this.acoL = new HashMap();
    this.ffv = false;
    this.acoN = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(32798);
        if (!UpdaterService.a(UpdaterService.this))
        {
          AppMethodBeat.o(32798);
          return true;
        }
        AppMethodBeat.o(32798);
        return false;
      }
    }, true);
    this.acoO = null;
    AppMethodBeat.o(32801);
  }
  
  public static void Fc()
  {
    AppMethodBeat.i(32802);
    Log.i("MicroMsg.XWeb.MM.UpdaterService", "UpdaterService stopInstance()");
    if (acoK != null) {
      acoK.iSF();
    }
    AppMethodBeat.o(32802);
  }
  
  public static UpdaterService iSE()
  {
    return acoK;
  }
  
  private boolean iSF()
  {
    AppMethodBeat.i(32808);
    if (this.acoL.size() > 0)
    {
      Iterator localIterator = this.acoL.values().iterator();
      while (localIterator.hasNext()) {
        if (((a)localIterator.next()).isBusy())
        {
          Log.i("MicroMsg.XWeb.MM.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
          AppMethodBeat.o(32808);
          return false;
        }
      }
    }
    Log.i("MicroMsg.XWeb.MM.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32799);
        if (UpdaterService.b(UpdaterService.this).size() > 0)
        {
          Iterator localIterator = UpdaterService.b(UpdaterService.this).values().iterator();
          while (localIterator.hasNext()) {
            if (((a)localIterator.next()).isBusy())
            {
              Log.i("MicroMsg.XWeb.MM.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
              AppMethodBeat.o(32799);
              return;
            }
          }
        }
        if (!ad.a.iIj())
        {
          if (!b.iSb())
          {
            UpdaterService.this.stopSelf();
            AppMethodBeat.o(32799);
          }
        }
        else {
          Log.i("TBSDownloadMgr", "is still busy");
        }
        AppMethodBeat.o(32799);
      }
    }, 10000L);
    AppMethodBeat.o(32808);
    return true;
  }
  
  private void r(Intent paramIntent)
  {
    AppMethodBeat.i(32807);
    if (paramIntent == null)
    {
      AppMethodBeat.o(32807);
      return;
    }
    int i = paramIntent.getIntExtra("intent_extra_download_type", 0);
    Log.i("MicroMsg.XWeb.MM.UpdaterService", "handleCommand, downloadType = %d", new Object[] { Integer.valueOf(i) });
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yFV, 0) == 1) {
      if ((i != 1) && (i != 4)) {
        break label166;
      }
    }
    label166:
    for (acoM = 300000L;; acoM = 1800000L)
    {
      this.acoN.stopTimer();
      this.acoN.startTimer(acoM);
      acoM = 1800000L;
      a locala = (a)this.acoL.get(Integer.valueOf(i));
      if (locala != null)
      {
        boolean bool = locala.bX(paramIntent);
        Log.i("MicroMsg.XWeb.MM.UpdaterService", "handleCommand ret = %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          iSF();
        }
      }
      AppMethodBeat.o(32807);
      return;
    }
  }
  
  public final IBinder aKF()
  {
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.XWeb.MM.UpdaterService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(32803);
    super.onCreate();
    Log.i("MicroMsg.XWeb.MM.UpdaterService", "onCreate");
    com.tencent.mm.sandbox.c.O(hashCode(), this);
    acoK = this;
    this.acoL.put(Integer.valueOf(0), j.a.acoJ);
    this.acoL.put(Integer.valueOf(1), e.iSl());
    this.acoL.put(Integer.valueOf(2), e.iSl());
    this.acoL.put(Integer.valueOf(4), k.a.acoQ);
    this.acoL.put(Integer.valueOf(5), k.a.acoQ);
    this.acoL.put(Integer.valueOf(6), k.a.acoQ);
    MMActivity.initLanguage(MMApplicationContext.getContext());
    this.acoN.startTimer(acoM);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.acoO = new a();
    a locala = this.acoO;
    this.acws.registerReceiver(locala, localIntentFilter);
    AppMethodBeat.o(32803);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32806);
    Log.i("MicroMsg.XWeb.MM.UpdaterService", "onDestroy");
    this.acoN.stopTimer();
    if (this.acoO != null) {}
    try
    {
      Object localObject = this.acoO;
      this.acws.unregisterReceiver((BroadcastReceiver)localObject);
      if (this.ffv) {
        iUE();
      }
      localObject = this.acoL.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).onDestroy();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.XWeb.MM.UpdaterService", "unregisterReceiver(UpdaterService.ConnectivityReceiver) exception = %s", new Object[] { localException.getMessage() });
      }
      this.acoL.clear();
      acoK = null;
      com.tencent.mm.sandbox.c.P(hashCode(), this);
      super.onDestroy();
      AppMethodBeat.o(32806);
    }
  }
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(32804);
    Log.i("MicroMsg.XWeb.MM.UpdaterService", "onStart intent = %s", new Object[] { paramIntent });
    r(paramIntent);
    AppMethodBeat.o(32804);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32805);
    Log.i("MicroMsg.XWeb.MM.UpdaterService", "onStartCommand intent = %s", new Object[] { paramIntent });
    if (paramIntent != null)
    {
      if (!paramIntent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
        break label136;
      }
      Log.i("MicroMsg.XWeb.MM.UpdaterService", "runServiceInForground");
      Object localObject = new Intent();
      localObject = PendingIntent.getService(MMApplicationContext.getContext(), 0, (Intent)localObject, 0);
      f.d locald = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o("updater service running forground").bt(System.currentTimeMillis()).l("Updater Service").m("updater service running forground");
      locald.bor = ((PendingIntent)localObject);
      d(0, locald.DA());
    }
    for (this.ffv = true;; this.ffv = true)
    {
      label136:
      do
      {
        r(paramIntent);
        AppMethodBeat.o(32805);
        return 2;
      } while ((Build.VERSION.SDK_INT >= 18) || (this.ffv));
      d(-1314, new Notification());
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(32800);
      if (UpdaterService.iSE() != null)
      {
        paramIntent = UpdaterService.iSE();
        boolean bool = NetStatusUtil.isWifi(paramContext);
        if (paramIntent.acoL.size() > 0)
        {
          paramContext = paramIntent.acoL.values().iterator();
          while (paramContext.hasNext()) {
            ((a)paramContext.next()).Kr(bool);
          }
        }
      }
      AppMethodBeat.o(32800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.UpdaterService
 * JD-Core Version:    0.7.0.1
 */