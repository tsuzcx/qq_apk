package com.tencent.mm.plugin.wepkg.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaz;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class i
{
  private static a JMJ;
  private static int qJw = -1;
  
  public static void cBn()
  {
    AppMethodBeat.i(110625);
    if (JMJ == null) {
      JMJ = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      MMApplicationContext.getContext().registerReceiver(JMJ, localIntentFilter);
      label59:
      Log.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader startListen");
      AppMethodBeat.o(110625);
      return;
    }
    catch (Exception localException)
    {
      break label59;
    }
  }
  
  public static void cBo()
  {
    AppMethodBeat.i(110626);
    if (JMJ != null) {}
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(JMJ);
      label20:
      JMJ = null;
      Log.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
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
      h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200159);
          for (;;)
          {
            Object localObject3;
            ArrayList localArrayList;
            try
            {
              if ((!g.aAc()) || (com.tencent.mm.kernel.a.azj()))
              {
                Log.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
                return;
              }
              i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
              if (i == i.qJw) {
                return;
              }
              i.access$102(i);
              Log.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = ".concat(String.valueOf(i)));
              if (i == 0)
              {
                boolean bool = com.tencent.mm.plugin.game.commlib.a.dSV();
                if (Util.secondsToNow(Util.nullAsNil((Long)g.aAh().azQ().get(ar.a.OcR, Long.valueOf(0L)))) <= 1800L) {
                  break label349;
                }
                i = 1;
                if (i == 0) {
                  Log.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", new Object[] { Long.valueOf(1800L) });
                }
                if ((!bool) && (i != 0))
                {
                  g.aAh().azQ().set(ar.a.OcR, Long.valueOf(Util.nowSecond()));
                  localObject1 = new aaz();
                  ((aaz)localObject1).eif.dDe = 0;
                  EventCenter.instance.publish((IEvent)localObject1);
                }
                return;
              }
              Object localObject1 = d.gkL();
              if ((((d)localObject1).JMi == null) || (((d)localObject1).JMi.size() == 0)) {
                continue;
              }
              localObject3 = ((d)localObject1).JMi.values();
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
              AppMethodBeat.o(200159);
            }
            while (((Iterator)localObject3).hasNext())
            {
              c localc = (c)((Iterator)localObject3).next();
              if (localc.JLZ.JMC) {
                localObject2.a(localc);
              }
            }
            localArrayList.clear();
            continue;
            label349:
            int i = 0;
          }
        }
      });
      AppMethodBeat.o(110624);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.i
 * JD-Core Version:    0.7.0.1
 */