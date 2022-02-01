package com.tencent.mm.plugin.wepkg.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zs;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class i
{
  private static a EWS;
  private static int ptR = -1;
  
  public static void cds()
  {
    AppMethodBeat.i(110625);
    if (EWS == null) {
      EWS = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      ak.getContext().registerReceiver(EWS, localIntentFilter);
      label59:
      ae.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader startListen");
      AppMethodBeat.o(110625);
      return;
    }
    catch (Exception localException)
    {
      break label59;
    }
  }
  
  public static void cdt()
  {
    AppMethodBeat.i(110626);
    if (EWS != null) {}
    try
    {
      ak.getContext().unregisterReceiver(EWS);
      label20:
      EWS = null;
      ae.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
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
      h.MqF.aO(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209386);
          for (;;)
          {
            Object localObject3;
            ArrayList localArrayList;
            try
            {
              if ((!com.tencent.mm.kernel.g.ajM()) || (com.tencent.mm.kernel.a.aiT()))
              {
                ae.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
                return;
              }
              i = az.getNetType(ak.getContext());
              if (i == i.ptR) {
                return;
              }
              i.access$102(i);
              ae.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = ".concat(String.valueOf(i)));
              if (i == 0)
              {
                boolean bool = com.tencent.mm.n.g.acM().acz();
                if (bu.rZ(bu.i((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUD, Long.valueOf(0L)))) <= 1800L) {
                  break label352;
                }
                i = 1;
                if (i == 0) {
                  ae.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", new Object[] { Long.valueOf(1800L) });
                }
                if ((!bool) && (i != 0))
                {
                  com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUD, Long.valueOf(bu.aRi()));
                  localObject1 = new zs();
                  ((zs)localObject1).dQc.dlO = 0;
                  com.tencent.mm.sdk.b.a.IvT.l((b)localObject1);
                }
                return;
              }
              Object localObject1 = d.fbF();
              if ((((d)localObject1).EWq == null) || (((d)localObject1).EWq.size() == 0)) {
                continue;
              }
              localObject3 = ((d)localObject1).EWq.values();
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
              AppMethodBeat.o(209386);
            }
            while (((Iterator)localObject3).hasNext())
            {
              c localc = (c)((Iterator)localObject3).next();
              if (localc.EWg.EWL) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.i
 * JD-Core Version:    0.7.0.1
 */