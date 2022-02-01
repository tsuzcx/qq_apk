package com.tencent.mm.plugin.wepkg.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class i
{
  private static a Dax;
  private static int oJD = -1;
  
  public static void bXA()
  {
    AppMethodBeat.i(110625);
    if (Dax == null) {
      Dax = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      ai.getContext().registerReceiver(Dax, localIntentFilter);
      label59:
      ac.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader startListen");
      AppMethodBeat.o(110625);
      return;
    }
    catch (Exception localException)
    {
      break label59;
    }
  }
  
  public static void bXB()
  {
    AppMethodBeat.i(110626);
    if (Dax != null) {}
    try
    {
      ai.getContext().unregisterReceiver(Dax);
      label20:
      Dax = null;
      ac.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
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
      h.JZN.aS(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199871);
          for (;;)
          {
            Object localObject3;
            ArrayList localArrayList;
            try
            {
              if ((!com.tencent.mm.kernel.g.agM()) || (com.tencent.mm.kernel.a.afS()))
              {
                ac.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
                return;
              }
              i = ax.getNetType(ai.getContext());
              if (i == i.oJD) {
                return;
              }
              i.AL(i);
              ac.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = ".concat(String.valueOf(i)));
              if (i == 0)
              {
                boolean bool = com.tencent.mm.m.g.ZZ().ZN();
                if (bs.pN(bs.g((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GNN, Long.valueOf(0L)))) <= 1800L) {
                  break label352;
                }
                i = 1;
                if (i == 0) {
                  ac.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", new Object[] { Long.valueOf(1800L) });
                }
                if ((!bool) && (i != 0))
                {
                  com.tencent.mm.kernel.g.agR().agA().set(ah.a.GNN, Long.valueOf(bs.aNx()));
                  localObject1 = new ys();
                  ((ys)localObject1).dCz.cZu = 0;
                  com.tencent.mm.sdk.b.a.GpY.l((b)localObject1);
                }
                return;
              }
              Object localObject1 = d.eIZ();
              if ((((d)localObject1).CZV == null) || (((d)localObject1).CZV.size() == 0)) {
                continue;
              }
              localObject3 = ((d)localObject1).CZV.values();
              localArrayList = new ArrayList();
              localObject3 = ((Collection)localObject3).iterator();
              if (((Iterator)localObject3).hasNext())
              {
                localArrayList.add((c)((Iterator)localObject3).next());
                continue;
              }
              localObject3 = localArrayList.iterator();
            }
            finally
            {
              AppMethodBeat.o(199871);
            }
            while (((Iterator)localObject3).hasNext())
            {
              c localc = (c)((Iterator)localObject3).next();
              if (localc.CZL.Daq) {
                localObject2.a(localc);
              }
            }
            localArrayList.clear();
            continue;
            label352:
            int i = 0;
          }
        }
      });
      AppMethodBeat.o(110624);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.i
 * JD-Core Version:    0.7.0.1
 */