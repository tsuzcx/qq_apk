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
import androidx.core.app.e.d;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.m;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.model.ab.a;
import com.tencent.mm.sandbox.c;
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
@JgClassChecked(author=20, fComment="checked", lastDate="20141015", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class UpdaterService
  extends MMService
{
  private static UpdaterService UTA = null;
  static long UTC = 1800000L;
  Map<Integer, a> UTB;
  private MTimerHandler UTD;
  private a UTE;
  private boolean dgo;
  
  public UpdaterService()
  {
    AppMethodBeat.i(32801);
    this.UTB = new HashMap();
    this.dgo = false;
    this.UTD = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.UTE = null;
    AppMethodBeat.o(32801);
  }
  
  private boolean hsA()
  {
    AppMethodBeat.i(32808);
    if (this.UTB.size() > 0)
    {
      Iterator localIterator = this.UTB.values().iterator();
      while (localIterator.hasNext()) {
        if (((a)localIterator.next()).isBusy())
        {
          Log.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
          AppMethodBeat.o(32808);
          return false;
        }
      }
    }
    Log.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
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
              Log.i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
              AppMethodBeat.o(32799);
              return;
            }
          }
        }
        if (!ab.a.hhj())
        {
          if (!com.tencent.mm.sandbox.monitor.b.hrV())
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
  
  public static UpdaterService hsz()
  {
    return UTA;
  }
  
  public static void hz()
  {
    AppMethodBeat.i(32802);
    Log.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
    if (UTA != null) {
      UTA.hsA();
    }
    AppMethodBeat.o(32802);
  }
  
  private void q(Intent paramIntent)
  {
    AppMethodBeat.i(32807);
    if (paramIntent == null)
    {
      AppMethodBeat.o(32807);
      return;
    }
    int i = paramIntent.getIntExtra("intent_extra_download_type", 0);
    Log.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", new Object[] { Integer.valueOf(i) });
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtx, 0) == 1) {
      if ((i != 1) && (i != 4)) {
        break label166;
      }
    }
    label166:
    for (UTC = 300000L;; UTC = 1800000L)
    {
      this.UTD.stopTimer();
      this.UTD.startTimer(UTC);
      UTC = 1800000L;
      a locala = (a)this.UTB.get(Integer.valueOf(i));
      if (locala != null)
      {
        boolean bool = locala.bu(paramIntent);
        Log.i("MicroMsg.UpdaterService", "handleCommand ret = %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          hsA();
        }
      }
      AppMethodBeat.o(32807);
      return;
    }
  }
  
  public final IBinder aqH()
  {
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.UpdaterService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(32803);
    super.onCreate();
    Log.i("MicroMsg.UpdaterService", "onCreate");
    c.u(hashCode(), this);
    UTA = this;
    this.UTB.put(Integer.valueOf(0), k.a.UTz);
    this.UTB.put(Integer.valueOf(1), e.hsg());
    this.UTB.put(Integer.valueOf(2), e.hsg());
    this.UTB.put(Integer.valueOf(4), l.a.UTG);
    this.UTB.put(Integer.valueOf(5), l.a.UTG);
    MMActivity.initLanguage(MMApplicationContext.getContext());
    this.UTD.startTimer(UTC);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.UTE = new a();
    a locala = this.UTE;
    this.UXA.registerReceiver(locala, localIntentFilter);
    AppMethodBeat.o(32803);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32806);
    Log.i("MicroMsg.UpdaterService", "onDestroy");
    this.UTD.stopTimer();
    if (this.UTE != null) {}
    try
    {
      Object localObject = this.UTE;
      this.UXA.unregisterReceiver((BroadcastReceiver)localObject);
      if (this.dgo) {
        htD();
      }
      localObject = this.UTB.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).onDestroy();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.UpdaterService", "unregisterReceiver(UpdaterService.ConnectivityReceiver) exception = %s", new Object[] { localException.getMessage() });
      }
      this.UTB.clear();
      UTA = null;
      c.v(hashCode(), this);
      super.onDestroy();
      AppMethodBeat.o(32806);
    }
  }
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(32804);
    Log.i("MicroMsg.UpdaterService", "onStart intent = %s", new Object[] { paramIntent });
    q(paramIntent);
    AppMethodBeat.o(32804);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32805);
    Log.i("MicroMsg.UpdaterService", "onStartCommand intent = %s", new Object[] { paramIntent });
    if (paramIntent != null)
    {
      if (!paramIntent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
        break label136;
      }
      Log.i("MicroMsg.UpdaterService", "runServiceInForground");
      Object localObject = new Intent();
      localObject = PendingIntent.getService(MMApplicationContext.getContext(), 0, (Intent)localObject, 0);
      e.d locald = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n("updater service running forground").e(System.currentTimeMillis()).k("Updater Service").l("updater service running forground");
      locald.Ip = ((PendingIntent)localObject);
      d(0, locald.gr());
    }
    for (this.dgo = true;; this.dgo = true)
    {
      label136:
      do
      {
        q(paramIntent);
        AppMethodBeat.o(32805);
        return 2;
      } while ((Build.VERSION.SDK_INT >= 18) || (this.dgo));
      d(-1314, new Notification());
    }
  }
  
  @JgClassChecked(author=20, fComment="checked", lastDate="20141015", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(32800);
      if (UpdaterService.hsz() != null)
      {
        paramIntent = UpdaterService.hsz();
        boolean bool = NetStatusUtil.isWifi(paramContext);
        if (paramIntent.UTB.size() > 0)
        {
          paramContext = paramIntent.UTB.values().iterator();
          while (paramContext.hasNext()) {
            ((a)paramContext.next()).EF(bool);
          }
        }
      }
      AppMethodBeat.o(32800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.UpdaterService
 * JD-Core Version:    0.7.0.1
 */