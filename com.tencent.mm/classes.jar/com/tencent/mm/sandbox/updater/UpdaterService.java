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
import android.support.v4.app.s.c;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.pluginsdk.model.x.a;
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

@k
@JgClassChecked(author=20, fComment="checked", lastDate="20141015", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class UpdaterService
  extends MMService
{
  private static UpdaterService NGa = null;
  static final long NGc = 1800000L;
  Map<Integer, a> NGb;
  private MTimerHandler NGd;
  private a NGe;
  private boolean cQp;
  
  public UpdaterService()
  {
    AppMethodBeat.i(32801);
    this.NGb = new HashMap();
    this.cQp = false;
    this.NGd = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.NGe = null;
    AppMethodBeat.o(32801);
  }
  
  public static void fK()
  {
    AppMethodBeat.i(32802);
    Log.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
    if (NGa != null) {
      NGa.gwB();
    }
    AppMethodBeat.o(32802);
  }
  
  public static UpdaterService gwA()
  {
    return NGa;
  }
  
  private boolean gwB()
  {
    AppMethodBeat.i(32808);
    if (this.NGb.size() > 0)
    {
      Iterator localIterator = this.NGb.values().iterator();
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
        if (!x.a.gmI())
        {
          UpdaterService.this.stopSelf();
          AppMethodBeat.o(32799);
          return;
        }
        Log.i("TBSDownloadMgr", "is still busy");
        AppMethodBeat.o(32799);
      }
    }, 10000L);
    AppMethodBeat.o(32808);
    return true;
  }
  
  private void o(Intent paramIntent)
  {
    AppMethodBeat.i(32807);
    if (paramIntent == null)
    {
      AppMethodBeat.o(32807);
      return;
    }
    int i = paramIntent.getIntExtra("intent_extra_download_type", 0);
    Log.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", new Object[] { Integer.valueOf(i) });
    a locala = (a)this.NGb.get(Integer.valueOf(i));
    if (locala != null)
    {
      boolean bool = locala.bu(paramIntent);
      Log.i("MicroMsg.UpdaterService", "handleCommand ret = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        gwB();
      }
    }
    AppMethodBeat.o(32807);
  }
  
  public final IBinder akL()
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
    c.q(hashCode(), this);
    NGa = this;
    this.NGb.put(Integer.valueOf(0), k.a.NFZ);
    this.NGb.put(Integer.valueOf(1), e.gwh());
    this.NGb.put(Integer.valueOf(2), e.gwh());
    this.NGb.put(Integer.valueOf(4), l.a.NGg);
    this.NGb.put(Integer.valueOf(5), l.a.NGg);
    MMActivity.initLanguage(MMApplicationContext.getContext());
    this.NGd.startTimer(NGc);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.NGe = new a();
    a locala = this.NGe;
    this.NJZ.registerReceiver(locala, localIntentFilter);
    AppMethodBeat.o(32803);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32806);
    Log.i("MicroMsg.UpdaterService", "onDestroy");
    this.NGd.stopTimer();
    if (this.NGe != null) {}
    try
    {
      Object localObject = this.NGe;
      this.NJZ.unregisterReceiver((BroadcastReceiver)localObject);
      if (this.cQp) {
        gxF();
      }
      localObject = this.NGb.values().iterator();
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
      this.NGb.clear();
      NGa = null;
      c.r(hashCode(), this);
      super.onDestroy();
      AppMethodBeat.o(32806);
    }
  }
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(32804);
    Log.i("MicroMsg.UpdaterService", "onStart intent = %s", new Object[] { paramIntent });
    o(paramIntent);
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
      s.c localc = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i("updater service running forground").i(System.currentTimeMillis()).f("Updater Service").g("updater service running forground");
      localc.Hv = ((PendingIntent)localObject);
      startForeground(0, localc.build());
    }
    for (this.cQp = true;; this.cQp = true)
    {
      label136:
      do
      {
        o(paramIntent);
        AppMethodBeat.o(32805);
        return 2;
      } while ((Build.VERSION.SDK_INT >= 18) || (this.cQp));
      startForeground(-1314, new Notification());
    }
  }
  
  @JgClassChecked(author=20, fComment="checked", lastDate="20141015", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(32800);
      if (UpdaterService.gwA() != null)
      {
        paramIntent = UpdaterService.gwA();
        boolean bool = NetStatusUtil.isWifi(paramContext);
        if (paramIntent.NGb.size() > 0)
        {
          paramContext = paramIntent.NGb.values().iterator();
          while (paramContext.hasNext()) {
            ((a)paramContext.next()).Ay(bool);
          }
        }
      }
      AppMethodBeat.o(32800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.UpdaterService
 * JD-Core Version:    0.7.0.1
 */