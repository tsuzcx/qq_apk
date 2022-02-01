package com.tencent.mm.pluginsdk.res.downloader.model;

import com.tencent.matrix.a.b.b;
import com.tencent.matrix.c.a;
import com.tencent.matrix.report.e.a;
import com.tencent.matrix.report.e.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.Log;

final class n$1
  extends p.a
{
  n$1(n paramn) {}
  
  public final void onNetworkChange(int paramInt)
  {
    paramInt = 1;
    AppMethodBeat.i(152047);
    b.b localb;
    if (a.ni(84))
    {
      localb = com.tencent.matrix.a.b.awt().awu();
      e.b.b.a(60001, localb);
      if (!com.tencent.matrix.c.b.ayx()) {
        break label59;
      }
      Log.w("MicroMsg.PinResDownloaderCore", "skip resume onNetworkChange for low energy: doze mode on!");
    }
    for (;;)
    {
      if (paramInt != 0) {
        e.a.ns(84);
      }
      o.iJJ();
      AppMethodBeat.o(152047);
      return;
      label59:
      if ((com.tencent.matrix.a.b.isInit()) && (!localb.isForeground()) && (!com.tencent.matrix.a.b.b.bZ(localb.mContext))) {
        Log.w("MicroMsg.PinResDownloaderCore", "skip resume onNetworkChange for low energy: bg & non-charging!");
      } else {
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.model.n.1
 * JD-Core Version:    0.7.0.1
 */