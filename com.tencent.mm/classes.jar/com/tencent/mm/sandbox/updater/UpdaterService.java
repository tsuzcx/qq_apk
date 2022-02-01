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
import com.tencent.mm.pluginsdk.model.w.a;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
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
  private static UpdaterService EPu = null;
  static final long EPw = 1800000L;
  Map<Integer, a> EPv;
  private av EPx;
  private a EPy;
  private boolean ctF;
  
  public UpdaterService()
  {
    AppMethodBeat.i(32801);
    this.EPv = new HashMap();
    this.ctF = false;
    this.EPx = new av(new av.a()
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
    this.EPy = null;
    AppMethodBeat.o(32801);
  }
  
  public static UpdaterService eDZ()
  {
    return EPu;
  }
  
  private boolean eEa()
  {
    AppMethodBeat.i(32808);
    if (this.EPv.size() > 0)
    {
      Iterator localIterator = this.EPv.values().iterator();
      while (localIterator.hasNext()) {
        if (((a)localIterator.next()).isBusy())
        {
          ad.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
          AppMethodBeat.o(32808);
          return false;
        }
      }
    }
    ad.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
    aq.n(new Runnable()
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
              ad.i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
              AppMethodBeat.o(32799);
              return;
            }
          }
        }
        if (!w.a.evv())
        {
          UpdaterService.this.stopSelf();
          AppMethodBeat.o(32799);
          return;
        }
        ad.i("TBSDownloadMgr", "is still busy");
        AppMethodBeat.o(32799);
      }
    }, 10000L);
    AppMethodBeat.o(32808);
    return true;
  }
  
  public static void fe()
  {
    AppMethodBeat.i(32802);
    ad.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
    if (EPu != null) {
      EPu.eEa();
    }
    AppMethodBeat.o(32802);
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
    ad.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", new Object[] { Integer.valueOf(i) });
    a locala = (a)this.EPv.get(Integer.valueOf(i));
    if (locala != null)
    {
      boolean bool = locala.bb(paramIntent);
      ad.i("MicroMsg.UpdaterService", "handleCommand ret = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        eEa();
      }
    }
    AppMethodBeat.o(32807);
  }
  
  public final IBinder TF()
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
    ad.i("MicroMsg.UpdaterService", "onCreate");
    c.o(hashCode(), this);
    EPu = this;
    this.EPv.put(Integer.valueOf(0), k.a.EPt);
    this.EPv.put(Integer.valueOf(1), e.eDG());
    this.EPv.put(Integer.valueOf(2), e.eDG());
    this.EPv.put(Integer.valueOf(4), l.a.EPA);
    this.EPv.put(Integer.valueOf(5), l.a.EPA);
    MMActivity.initLanguage(aj.getContext());
    Object localObject = this.EPx;
    long l = EPw;
    ((av)localObject).av(l, l);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.EPy = new a();
    a locala = this.EPy;
    this.EZM.registerReceiver(locala, (IntentFilter)localObject);
    AppMethodBeat.o(32803);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32806);
    ad.i("MicroMsg.UpdaterService", "onDestroy");
    this.EPx.stopTimer();
    if (this.EPy != null) {}
    try
    {
      Object localObject = this.EPy;
      this.EZM.unregisterReceiver((BroadcastReceiver)localObject);
      if (this.ctF) {
        eHH();
      }
      localObject = this.EPv.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).onDestroy();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.UpdaterService", "unregisterReceiver(UpdaterService.ConnectivityReceiver) exception = %s", new Object[] { localException.getMessage() });
      }
      this.EPv.clear();
      EPu = null;
      c.p(hashCode(), this);
      super.onDestroy();
      AppMethodBeat.o(32806);
    }
  }
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(32804);
    ad.i("MicroMsg.UpdaterService", "onStart intent = %s", new Object[] { paramIntent });
    o(paramIntent);
    AppMethodBeat.o(32804);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32805);
    ad.i("MicroMsg.UpdaterService", "onStartCommand intent = %s", new Object[] { paramIntent });
    if (paramIntent != null)
    {
      if (!paramIntent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
        break label136;
      }
      ad.i("MicroMsg.UpdaterService", "runServiceInForground");
      Object localObject = new Intent();
      localObject = PendingIntent.getService(aj.getContext(), 0, (Intent)localObject, 0);
      s.c localc = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i("updater service running forground").g(System.currentTimeMillis()).f("Updater Service").g("updater service running forground");
      localc.Ew = ((PendingIntent)localObject);
      startForeground(0, localc.build());
    }
    for (this.ctF = true;; this.ctF = true)
    {
      label136:
      do
      {
        o(paramIntent);
        AppMethodBeat.o(32805);
        return 2;
      } while ((Build.VERSION.SDK_INT >= 18) || (this.ctF));
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
      if (UpdaterService.eDZ() != null)
      {
        paramIntent = UpdaterService.eDZ();
        boolean bool = ay.isWifi(paramContext);
        if (paramIntent.EPv.size() > 0)
        {
          paramContext = paramIntent.EPv.values().iterator();
          while (paramContext.hasNext()) {
            ((a)paramContext.next()).uC(bool);
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