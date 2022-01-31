package com.tencent.mm.plugin.wepkg.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

final class i$a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(63453);
    if ((!com.tencent.mm.kernel.g.RG()) || (com.tencent.mm.kernel.a.QP()))
    {
      ab.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
      AppMethodBeat.o(63453);
      return;
    }
    int i = at.getNetType(ah.getContext());
    if (i == i.access$100())
    {
      AppMethodBeat.o(63453);
      return;
    }
    i.ua(i);
    ab.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = ".concat(String.valueOf(i)));
    boolean bool;
    if (i == 0)
    {
      bool = com.tencent.mm.m.g.Nr().Nd();
      if (bo.gz(bo.c((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yHm, Long.valueOf(0L)))) <= 1800L) {
        break label336;
      }
    }
    label336:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        ab.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", new Object[] { Long.valueOf(1800L) });
      }
      if ((!bool) && (i != 0))
      {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHm, Long.valueOf(bo.aox()));
        paramContext = new wi();
        paramContext.cNO.coO = 0;
        com.tencent.mm.sdk.b.a.ymk.l(paramContext);
      }
      AppMethodBeat.o(63453);
      return;
      paramContext = d.dkx();
      if ((paramContext.vFb == null) || (paramContext.vFb.size() == 0))
      {
        AppMethodBeat.o(63453);
        return;
      }
      Object localObject = paramContext.vFb.values();
      paramIntent = new ArrayList();
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramIntent.add((c)((Iterator)localObject).next());
      }
      localObject = paramIntent.iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (localc.vER.vFw) {
          paramContext.a(localc);
        }
      }
      paramIntent.clear();
      AppMethodBeat.o(63453);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.i.a
 * JD-Core Version:    0.7.0.1
 */