package com.tencent.mm.plugin.wepkg.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aee;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class i
{
  private static a XFA;
  private static int xoE = -1;
  
  public static void cuD()
  {
    AppMethodBeat.i(110626);
    if (XFA != null) {}
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(XFA);
      label20:
      XFA = null;
      Log.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
      AppMethodBeat.o(110626);
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
  
  public static void duo()
  {
    AppMethodBeat.i(110625);
    if (XFA == null) {
      XFA = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      MMApplicationContext.getContext().registerReceiver(XFA, localIntentFilter);
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
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(110624);
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(278672);
          for (;;)
          {
            Object localObject3;
            ArrayList localArrayList;
            try
            {
              if ((!com.tencent.mm.kernel.h.baz()) || (b.aZG()))
              {
                Log.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
                return;
              }
              i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
              if (i == i.xoE) {
                return;
              }
              i.access$102(i);
              Log.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = ".concat(String.valueOf(i)));
              if (i == 0)
              {
                boolean bool = a.fDT();
                if (Util.secondsToNow(Util.nullAsNil((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSA, Long.valueOf(0L)))) <= 1800L) {
                  break label346;
                }
                i = 1;
                if (i == 0) {
                  Log.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", new Object[] { Long.valueOf(1800L) });
                }
                if ((!bool) && (i != 0))
                {
                  com.tencent.mm.kernel.h.baE().ban().set(at.a.acSA, Long.valueOf(Util.nowSecond()));
                  localObject1 = new aee();
                  ((aee)localObject1).iiI.hAf = 0;
                  ((aee)localObject1).publish();
                }
                return;
              }
              Object localObject1 = d.iFk();
              if ((((d)localObject1).XFa == null) || (((d)localObject1).XFa.size() == 0)) {
                continue;
              }
              localObject3 = ((d)localObject1).XFa.values();
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
              AppMethodBeat.o(278672);
            }
            while (((Iterator)localObject3).hasNext())
            {
              c localc = (c)((Iterator)localObject3).next();
              if (localc.XER.XFt) {
                localObject2.a(localc);
              }
            }
            localArrayList.clear();
            continue;
            label346:
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