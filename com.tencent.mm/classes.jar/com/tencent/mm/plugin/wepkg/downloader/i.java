package com.tencent.mm.plugin.wepkg.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class i
{
  private static a EEw;
  private static int pnk = -1;
  
  public static void ccd()
  {
    AppMethodBeat.i(110625);
    if (EEw == null) {
      EEw = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      aj.getContext().registerReceiver(EEw, localIntentFilter);
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
  
  public static void cce()
  {
    AppMethodBeat.i(110626);
    if (EEw != null) {}
    try
    {
      aj.getContext().unregisterReceiver(EEw);
      label20:
      EEw = null;
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
      h.LTJ.aR(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214458);
          for (;;)
          {
            Object localObject3;
            ArrayList localArrayList;
            try
            {
              if ((!com.tencent.mm.kernel.g.ajx()) || (com.tencent.mm.kernel.a.aiE()))
              {
                ad.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
                return;
              }
              i = ay.getNetType(aj.getContext());
              if (i == i.pnk) {
                return;
              }
              i.access$102(i);
              ad.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = ".concat(String.valueOf(i)));
              if (i == 0)
              {
                boolean bool = com.tencent.mm.n.g.acB().aco();
                if (bt.rM(bt.g((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAe, Long.valueOf(0L)))) <= 1800L) {
                  break label352;
                }
                i = 1;
                if (i == 0) {
                  ad.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", new Object[] { Long.valueOf(1800L) });
                }
                if ((!bool) && (i != 0))
                {
                  com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAe, Long.valueOf(bt.aQJ()));
                  localObject1 = new zm();
                  ((zm)localObject1).dOM.dkM = 0;
                  com.tencent.mm.sdk.b.a.IbL.l((b)localObject1);
                }
                return;
              }
              Object localObject1 = d.eXT();
              if ((((d)localObject1).EDU == null) || (((d)localObject1).EDU.size() == 0)) {
                continue;
              }
              localObject3 = ((d)localObject1).EDU.values();
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
              AppMethodBeat.o(214458);
            }
            while (((Iterator)localObject3).hasNext())
            {
              c localc = (c)((Iterator)localObject3).next();
              if (localc.EDK.EEp) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.i
 * JD-Core Version:    0.7.0.1
 */