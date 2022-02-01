package com.tencent.mm.plugin.wepkg.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ach;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.game.commlib.a;
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
  private static a QMc;
  private static int uiB = -1;
  
  public static void cPR()
  {
    AppMethodBeat.i(110625);
    if (QMc == null) {
      QMc = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      MMApplicationContext.getContext().registerReceiver(QMc, localIntentFilter);
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
  
  public static void cPS()
  {
    AppMethodBeat.i(110626);
    if (QMc != null) {}
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(QMc);
      label20:
      QMc = null;
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
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194977);
          for (;;)
          {
            Object localObject3;
            ArrayList localArrayList;
            try
            {
              if ((!com.tencent.mm.kernel.h.aHB()) || (b.aGE()))
              {
                Log.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
                return;
              }
              i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
              if (i == i.uiB) {
                return;
              }
              i.access$102(i);
              Log.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = ".concat(String.valueOf(i)));
              if (i == 0)
              {
                boolean bool = a.ewd();
                if (Util.secondsToNow(Util.nullAsNil((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VqY, Long.valueOf(0L)))) <= 1800L) {
                  break label349;
                }
                i = 1;
                if (i == 0) {
                  Log.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", new Object[] { Long.valueOf(1800L) });
                }
                if ((!bool) && (i != 0))
                {
                  com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VqY, Long.valueOf(Util.nowSecond()));
                  localObject1 = new ach();
                  ((ach)localObject1).gcw.fvK = 0;
                  EventCenter.instance.publish((IEvent)localObject1);
                }
                return;
              }
              Object localObject1 = d.heC();
              if ((((d)localObject1).QLB == null) || (((d)localObject1).QLB.size() == 0)) {
                continue;
              }
              localObject3 = ((d)localObject1).QLB.values();
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
              AppMethodBeat.o(194977);
            }
            while (((Iterator)localObject3).hasNext())
            {
              c localc = (c)((Iterator)localObject3).next();
              if (localc.QLs.QLV) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.i
 * JD-Core Version:    0.7.0.1
 */