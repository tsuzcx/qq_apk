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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
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
  private static UpdaterService GmH = null;
  static final long GmJ = 1800000L;
  Map<Integer, a> GmI;
  private au GmK;
  private a GmL;
  private boolean cqM;
  
  public UpdaterService()
  {
    AppMethodBeat.i(32801);
    this.GmI = new HashMap();
    this.cqM = false;
    this.GmK = new au(new au.a()
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
    this.GmL = null;
    AppMethodBeat.o(32801);
  }
  
  public static UpdaterService eTt()
  {
    return GmH;
  }
  
  private boolean eTu()
  {
    AppMethodBeat.i(32808);
    if (this.GmI.size() > 0)
    {
      Iterator localIterator = this.GmI.values().iterator();
      while (localIterator.hasNext()) {
        if (((a)localIterator.next()).isBusy())
        {
          ac.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
          AppMethodBeat.o(32808);
          return false;
        }
      }
    }
    ac.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
    ap.n(new Runnable()
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
              ac.i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
              AppMethodBeat.o(32799);
              return;
            }
          }
        }
        if (!w.a.eKP())
        {
          UpdaterService.this.stopSelf();
          AppMethodBeat.o(32799);
          return;
        }
        ac.i("TBSDownloadMgr", "is still busy");
        AppMethodBeat.o(32799);
      }
    }, 10000L);
    AppMethodBeat.o(32808);
    return true;
  }
  
  public static void fm()
  {
    AppMethodBeat.i(32802);
    ac.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
    if (GmH != null) {
      GmH.eTu();
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
    ac.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", new Object[] { Integer.valueOf(i) });
    a locala = (a)this.GmI.get(Integer.valueOf(i));
    if (locala != null)
    {
      boolean bool = locala.bc(paramIntent);
      ac.i("MicroMsg.UpdaterService", "handleCommand ret = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        eTu();
      }
    }
    AppMethodBeat.o(32807);
  }
  
  public final IBinder Uz()
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
    ac.i("MicroMsg.UpdaterService", "onCreate");
    c.o(hashCode(), this);
    GmH = this;
    this.GmI.put(Integer.valueOf(0), k.a.GmG);
    this.GmI.put(Integer.valueOf(1), e.eTa());
    this.GmI.put(Integer.valueOf(2), e.eTa());
    this.GmI.put(Integer.valueOf(4), l.a.GmN);
    this.GmI.put(Integer.valueOf(5), l.a.GmN);
    MMActivity.initLanguage(ai.getContext());
    Object localObject = this.GmK;
    long l = GmJ;
    ((au)localObject).au(l, l);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.GmL = new a();
    a locala = this.GmL;
    this.Gxd.registerReceiver(locala, (IntentFilter)localObject);
    AppMethodBeat.o(32803);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32806);
    ac.i("MicroMsg.UpdaterService", "onDestroy");
    this.GmK.stopTimer();
    if (this.GmL != null) {}
    try
    {
      Object localObject = this.GmL;
      this.Gxd.unregisterReceiver((BroadcastReceiver)localObject);
      if (this.cqM) {
        eXd();
      }
      localObject = this.GmI.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).onDestroy();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.UpdaterService", "unregisterReceiver(UpdaterService.ConnectivityReceiver) exception = %s", new Object[] { localException.getMessage() });
      }
      this.GmI.clear();
      GmH = null;
      c.p(hashCode(), this);
      super.onDestroy();
      AppMethodBeat.o(32806);
    }
  }
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(32804);
    ac.i("MicroMsg.UpdaterService", "onStart intent = %s", new Object[] { paramIntent });
    o(paramIntent);
    AppMethodBeat.o(32804);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32805);
    ac.i("MicroMsg.UpdaterService", "onStartCommand intent = %s", new Object[] { paramIntent });
    if (paramIntent != null)
    {
      if (!paramIntent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
        break label136;
      }
      ac.i("MicroMsg.UpdaterService", "runServiceInForground");
      Object localObject = new Intent();
      localObject = PendingIntent.getService(ai.getContext(), 0, (Intent)localObject, 0);
      s.c localc = com.tencent.mm.bq.a.bE(ai.getContext(), "reminder_channel_id").i("updater service running forground").i(System.currentTimeMillis()).f("Updater Service").g("updater service running forground");
      localc.Fu = ((PendingIntent)localObject);
      startForeground(0, localc.build());
    }
    for (this.cqM = true;; this.cqM = true)
    {
      label136:
      do
      {
        o(paramIntent);
        AppMethodBeat.o(32805);
        return 2;
      } while ((Build.VERSION.SDK_INT >= 18) || (this.cqM));
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
      if (UpdaterService.eTt() != null)
      {
        paramIntent = UpdaterService.eTt();
        boolean bool = ax.isWifi(paramContext);
        if (paramIntent.GmI.size() > 0)
        {
          paramContext = paramIntent.GmI.values().iterator();
          while (paramContext.hasNext()) {
            ((a)paramContext.next()).vE(bool);
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