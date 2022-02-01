package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.a;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  implements h.a
{
  public c(Context paramContext)
  {
    AppMethodBeat.i(27831);
    gs localgs = new gs();
    localgs.dtG.opType = 3;
    localgs.dtG.context = paramContext;
    a.IvT.l(localgs);
    AppMethodBeat.o(27831);
  }
  
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(27834);
    gs localgs = new gs();
    localgs.dtG.opType = 2;
    localgs.dtG.dtN = false;
    if (paramb.dtL)
    {
      localgs.dtG.dtI = paramb.dtI;
      localgs.dtG.dtL = paramb.dtL;
    }
    for (;;)
    {
      a.IvT.l(localgs);
      ae.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", new Object[] { Long.valueOf(paramb.xHT), paramb.dtI.dua, localgs.dtH.dtO, Boolean.valueOf(localgs.dtG.dtL) });
      paramb = localgs.dtH.dtO;
      AppMethodBeat.o(27834);
      return paramb;
      localgs.dtG.dtI = paramb.dtI;
      localgs.dtG.doH = paramb.xHT;
      localgs.dtG.maxWidth = paramb.maxWidth;
      localgs.dtG.dtM = paramb.dtM;
    }
  }
  
  public final Bitmap a(h.a.c paramc)
  {
    AppMethodBeat.i(27833);
    gs localgs = new gs();
    localgs.dtG.opType = 0;
    localgs.dtG.dtI = paramc.dtI;
    localgs.dtG.doH = paramc.xHT;
    a.IvT.l(localgs);
    ae.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", new Object[] { Long.valueOf(paramc.xHT), localgs.dtH.dtO });
    paramc = localgs.dtH.dtO;
    AppMethodBeat.o(27833);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    AppMethodBeat.i(27832);
    ae.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", new Object[] { Long.valueOf(parama.xHT) });
    gs localgs = new gs();
    localgs.dtG.opType = 1;
    localgs.dtG.dtJ = parama.dtJ;
    localgs.dtG.dtI = parama.dtI;
    localgs.dtG.doH = parama.xHT;
    localgs.dtG.dtK = parama.dtK;
    localgs.dtG.width = parama.width;
    localgs.dtG.height = parama.height;
    a.IvT.l(localgs);
    AppMethodBeat.o(27832);
  }
  
  public final void dHE()
  {
    AppMethodBeat.i(27835);
    gs localgs = new gs();
    localgs.dtG.opType = 4;
    a.IvT.l(localgs);
    AppMethodBeat.o(27835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.c
 * JD-Core Version:    0.7.0.1
 */