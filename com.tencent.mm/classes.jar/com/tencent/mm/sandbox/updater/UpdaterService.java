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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
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
  private static UpdaterService IsB = null;
  static final long IsD = 1800000L;
  Map<Integer, a> IsC;
  private aw IsE;
  private a IsF;
  private boolean cCq;
  
  public UpdaterService()
  {
    AppMethodBeat.i(32801);
    this.IsC = new HashMap();
    this.cCq = false;
    this.IsE = new aw(new aw.a()
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
    this.IsF = null;
    AppMethodBeat.o(32801);
  }
  
  public static void fD()
  {
    AppMethodBeat.i(32802);
    ae.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
    if (IsB != null) {
      IsB.fmO();
    }
    AppMethodBeat.o(32802);
  }
  
  public static UpdaterService fmN()
  {
    return IsB;
  }
  
  private boolean fmO()
  {
    AppMethodBeat.i(32808);
    if (this.IsC.size() > 0)
    {
      Iterator localIterator = this.IsC.values().iterator();
      while (localIterator.hasNext()) {
        if (((a)localIterator.next()).isBusy())
        {
          ae.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
          AppMethodBeat.o(32808);
          return false;
        }
      }
    }
    ae.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
    ar.o(new Runnable()
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
              ae.i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
              AppMethodBeat.o(32799);
              return;
            }
          }
        }
        if (!w.a.fdx())
        {
          UpdaterService.this.stopSelf();
          AppMethodBeat.o(32799);
          return;
        }
        ae.i("TBSDownloadMgr", "is still busy");
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
    ae.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", new Object[] { Integer.valueOf(i) });
    a locala = (a)this.IsC.get(Integer.valueOf(i));
    if (locala != null)
    {
      boolean bool = locala.bi(paramIntent);
      ae.i("MicroMsg.UpdaterService", "handleCommand ret = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        fmO();
      }
    }
    AppMethodBeat.o(32807);
  }
  
  public final IBinder WY()
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
    ae.i("MicroMsg.UpdaterService", "onCreate");
    c.n(hashCode(), this);
    IsB = this;
    this.IsC.put(Integer.valueOf(0), k.a.IsA);
    this.IsC.put(Integer.valueOf(1), e.fmu());
    this.IsC.put(Integer.valueOf(2), e.fmu());
    this.IsC.put(Integer.valueOf(4), l.a.IsH);
    this.IsC.put(Integer.valueOf(5), l.a.IsH);
    MMActivity.initLanguage(ak.getContext());
    Object localObject = this.IsE;
    long l = IsD;
    ((aw)localObject).ay(l, l);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.IsF = new a();
    a locala = this.IsF;
    this.IDi.registerReceiver(locala, (IntentFilter)localObject);
    AppMethodBeat.o(32803);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32806);
    ae.i("MicroMsg.UpdaterService", "onDestroy");
    this.IsE.stopTimer();
    if (this.IsF != null) {}
    try
    {
      Object localObject = this.IsF;
      this.IDi.unregisterReceiver((BroadcastReceiver)localObject);
      if (this.cCq) {
        fqI();
      }
      localObject = this.IsC.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).onDestroy();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.UpdaterService", "unregisterReceiver(UpdaterService.ConnectivityReceiver) exception = %s", new Object[] { localException.getMessage() });
      }
      this.IsC.clear();
      IsB = null;
      c.o(hashCode(), this);
      super.onDestroy();
      AppMethodBeat.o(32806);
    }
  }
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(32804);
    ae.i("MicroMsg.UpdaterService", "onStart intent = %s", new Object[] { paramIntent });
    o(paramIntent);
    AppMethodBeat.o(32804);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32805);
    ae.i("MicroMsg.UpdaterService", "onStartCommand intent = %s", new Object[] { paramIntent });
    if (paramIntent != null)
    {
      if (!paramIntent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
        break label136;
      }
      ae.i("MicroMsg.UpdaterService", "runServiceInForground");
      Object localObject = new Intent();
      localObject = PendingIntent.getService(ak.getContext(), 0, (Intent)localObject, 0);
      s.c localc = com.tencent.mm.bq.a.bJ(ak.getContext(), "reminder_channel_id").i("updater service running forground").i(System.currentTimeMillis()).f("Updater Service").g("updater service running forground");
      localc.Hl = ((PendingIntent)localObject);
      startForeground(0, localc.build());
    }
    for (this.cCq = true;; this.cCq = true)
    {
      label136:
      do
      {
        o(paramIntent);
        AppMethodBeat.o(32805);
        return 2;
      } while ((Build.VERSION.SDK_INT >= 18) || (this.cCq));
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
      if (UpdaterService.fmN() != null)
      {
        paramIntent = UpdaterService.fmN();
        boolean bool = az.isWifi(paramContext);
        if (paramIntent.IsC.size() > 0)
        {
          paramContext = paramIntent.IsC.values().iterator();
          while (paramContext.hasNext()) {
            ((a)paramContext.next()).wy(bool);
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