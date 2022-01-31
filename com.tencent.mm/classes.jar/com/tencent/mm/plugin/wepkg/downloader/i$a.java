package com.tencent.mm.plugin.wepkg.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.h.a.un;
import com.tencent.mm.kernel.e;
import com.tencent.mm.m.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class i$a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!com.tencent.mm.kernel.g.DK()) || (com.tencent.mm.kernel.a.CW())) {
      y.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
    }
    do
    {
      return;
      i = aq.getNetType(ae.getContext());
    } while (i == i.access$100());
    i.pF(i);
    y.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = " + i);
    boolean bool;
    if (i == 0)
    {
      bool = com.tencent.mm.m.g.AB().An();
      if (bk.cn(Long.valueOf(bk.c((Long)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxd, Long.valueOf(0L)))).longValue()) <= 1800L) {
        break label196;
      }
    }
    label196:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        y.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", new Object[] { Long.valueOf(1800L) });
      }
      if ((bool) || (i == 0)) {
        break;
      }
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxd, Long.valueOf(bk.UX()));
      paramContext = new un();
      paramContext.cfh.bHz = 0;
      com.tencent.mm.sdk.b.a.udP.m(paramContext);
      return;
      d.cjS().cjT();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.i.a
 * JD-Core Version:    0.7.0.1
 */