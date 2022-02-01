package com.tencent.mm.plugin.wepkg.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class i
{
  private static a BIp;
  private static int ogc = -1;
  
  public static void bQj()
  {
    AppMethodBeat.i(110625);
    if (BIp == null) {
      BIp = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      aj.getContext().registerReceiver(BIp, localIntentFilter);
      label59:
      ad.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader startListen");
      AppMethodBeat.o(110625);
      return;
    }
    catch (Exception localException)
    {
      break label59;
    }
  }
  
  public static void bQk()
  {
    AppMethodBeat.i(110626);
    if (BIp != null) {}
    try
    {
      aj.getContext().unregisterReceiver(BIp);
      label20:
      BIp = null;
      ad.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
      AppMethodBeat.o(110626);
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(110624);
      if ((!com.tencent.mm.kernel.g.afw()) || (com.tencent.mm.kernel.a.aeC()))
      {
        ad.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
        AppMethodBeat.o(110624);
        return;
      }
      int i = ay.getNetType(aj.getContext());
      if (i == i.ogc)
      {
        AppMethodBeat.o(110624);
        return;
      }
      i.zT(i);
      ad.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = ".concat(String.valueOf(i)));
      boolean bool;
      if (i == 0)
      {
        bool = com.tencent.mm.m.g.Ze().YQ();
        if (bt.lZ(bt.f((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FpX, Long.valueOf(0L)))) <= 1800L) {
          break label336;
        }
      }
      label336:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          ad.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", new Object[] { Long.valueOf(1800L) });
        }
        if ((!bool) && (i != 0))
        {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FpX, Long.valueOf(bt.aGK()));
          paramContext = new yh();
          paramContext.dEN.dbV = 0;
          com.tencent.mm.sdk.b.a.ESL.l(paramContext);
        }
        AppMethodBeat.o(110624);
        return;
        paramContext = d.etG();
        if ((paramContext.BHN == null) || (paramContext.BHN.size() == 0))
        {
          AppMethodBeat.o(110624);
          return;
        }
        Object localObject = paramContext.BHN.values();
        paramIntent = new ArrayList();
        localObject = ((Collection)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramIntent.add((c)((Iterator)localObject).next());
        }
        localObject = paramIntent.iterator();
        while (((Iterator)localObject).hasNext())
        {
          c localc = (c)((Iterator)localObject).next();
          if (localc.BHD.BIi) {
            paramContext.a(localc);
          }
        }
        paramIntent.clear();
        AppMethodBeat.o(110624);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.i
 * JD-Core Version:    0.7.0.1
 */