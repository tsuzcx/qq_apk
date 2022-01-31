package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.s.c;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
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
  private static UpdaterService ylR = null;
  static final long ylT = 1800000L;
  private boolean bSe;
  Map<Integer, a> ylS;
  private ap ylU;
  private UpdaterService.a ylV;
  
  public UpdaterService()
  {
    AppMethodBeat.i(28987);
    this.ylS = new HashMap();
    this.bSe = false;
    this.ylU = new ap(new UpdaterService.1(this), true);
    this.ylV = null;
    AppMethodBeat.o(28987);
  }
  
  public static void dM()
  {
    AppMethodBeat.i(28988);
    ab.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
    if (ylR != null) {
      ylR.drY();
    }
    AppMethodBeat.o(28988);
  }
  
  public static UpdaterService drX()
  {
    return ylR;
  }
  
  private boolean drY()
  {
    AppMethodBeat.i(28994);
    if (this.ylS.size() > 0)
    {
      Iterator localIterator = this.ylS.values().iterator();
      while (localIterator.hasNext()) {
        if (((a)localIterator.next()).isBusy())
        {
          ab.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
          AppMethodBeat.o(28994);
          return false;
        }
      }
    }
    ab.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
    al.p(new UpdaterService.2(this), 10000L);
    AppMethodBeat.o(28994);
    return true;
  }
  
  private void o(Intent paramIntent)
  {
    AppMethodBeat.i(28993);
    if (paramIntent == null)
    {
      AppMethodBeat.o(28993);
      return;
    }
    int i = paramIntent.getIntExtra("intent_extra_download_type", 0);
    ab.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", new Object[] { Integer.valueOf(i) });
    a locala = (a)this.ylS.get(Integer.valueOf(i));
    if (locala != null)
    {
      boolean bool = locala.aI(paramIntent);
      ab.i("MicroMsg.UpdaterService", "handleCommand ret = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        drY();
      }
    }
    AppMethodBeat.o(28993);
  }
  
  public final IBinder It()
  {
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.UpdaterService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(28989);
    super.onCreate();
    ab.i("MicroMsg.UpdaterService", "onCreate");
    c.m(hashCode(), this);
    ylR = this;
    this.ylS.put(Integer.valueOf(0), j.a.ylQ);
    this.ylS.put(Integer.valueOf(1), d.drD());
    this.ylS.put(Integer.valueOf(2), d.drD());
    this.ylS.put(Integer.valueOf(4), k.a.ylX);
    this.ylS.put(Integer.valueOf(5), k.a.ylX);
    MMActivity.initLanguage(ah.getContext());
    Object localObject = this.ylU;
    long l = ylT;
    ((ap)localObject).ag(l, l);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.ylV = new UpdaterService.a();
    UpdaterService.a locala = this.ylV;
    this.ytK.registerReceiver(locala, (IntentFilter)localObject);
    AppMethodBeat.o(28989);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(28992);
    ab.i("MicroMsg.UpdaterService", "onDestroy");
    this.ylU.stopTimer();
    if (this.ylV != null) {}
    try
    {
      Object localObject = this.ylV;
      this.ytK.unregisterReceiver((BroadcastReceiver)localObject);
      if (this.bSe) {
        duS();
      }
      localObject = this.ylS.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).onDestroy();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.UpdaterService", "unregisterReceiver(UpdaterService.ConnectivityReceiver) exception = %s", new Object[] { localException.getMessage() });
      }
      this.ylS.clear();
      ylR = null;
      c.n(hashCode(), this);
      super.onDestroy();
      AppMethodBeat.o(28992);
    }
  }
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(28990);
    ab.i("MicroMsg.UpdaterService", "onStart intent = %s", new Object[] { paramIntent });
    o(paramIntent);
    AppMethodBeat.o(28990);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28991);
    ab.i("MicroMsg.UpdaterService", "onStartCommand intent = %s", new Object[] { paramIntent });
    if (paramIntent != null)
    {
      if (!paramIntent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
        break label136;
      }
      ab.i("MicroMsg.UpdaterService", "runServiceInForground");
      Object localObject = new Intent();
      localObject = PendingIntent.getService(ah.getContext(), 0, (Intent)localObject, 0);
      s.c localc = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id").h("updater service running forground").g(System.currentTimeMillis()).e("Updater Service").f("updater service running forground");
      localc.ya = ((PendingIntent)localObject);
      startForeground(0, localc.build());
    }
    for (this.bSe = true;; this.bSe = true)
    {
      label136:
      do
      {
        o(paramIntent);
        AppMethodBeat.o(28991);
        return 2;
      } while ((Build.VERSION.SDK_INT >= 18) || (this.bSe));
      startForeground(-1314, new Notification());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.UpdaterService
 * JD-Core Version:    0.7.0.1
 */