package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.gr.a;
import com.tencent.mm.g.a.gr.b;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  implements h.a
{
  public c(Context paramContext)
  {
    AppMethodBeat.i(27831);
    gr localgr = new gr();
    localgr.dsA.opType = 3;
    localgr.dsA.context = paramContext;
    a.IbL.l(localgr);
    AppMethodBeat.o(27831);
  }
  
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(27834);
    gr localgr = new gr();
    localgr.dsA.opType = 2;
    localgr.dsA.dsH = false;
    if (paramb.dsF)
    {
      localgr.dsA.dsC = paramb.dsC;
      localgr.dsA.dsF = paramb.dsF;
    }
    for (;;)
    {
      a.IbL.l(localgr);
      ad.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", new Object[] { Long.valueOf(paramb.xrW), paramb.dsC.dsU, localgr.dsB.dsI, Boolean.valueOf(localgr.dsA.dsF) });
      paramb = localgr.dsB.dsI;
      AppMethodBeat.o(27834);
      return paramb;
      localgr.dsA.dsC = paramb.dsC;
      localgr.dsA.dnC = paramb.xrW;
      localgr.dsA.maxWidth = paramb.maxWidth;
      localgr.dsA.dsG = paramb.dsG;
    }
  }
  
  public final Bitmap a(h.a.c paramc)
  {
    AppMethodBeat.i(27833);
    gr localgr = new gr();
    localgr.dsA.opType = 0;
    localgr.dsA.dsC = paramc.dsC;
    localgr.dsA.dnC = paramc.xrW;
    a.IbL.l(localgr);
    ad.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", new Object[] { Long.valueOf(paramc.xrW), localgr.dsB.dsI });
    paramc = localgr.dsB.dsI;
    AppMethodBeat.o(27833);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    AppMethodBeat.i(27832);
    ad.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", new Object[] { Long.valueOf(parama.xrW) });
    gr localgr = new gr();
    localgr.dsA.opType = 1;
    localgr.dsA.dsD = parama.dsD;
    localgr.dsA.dsC = parama.dsC;
    localgr.dsA.dnC = parama.xrW;
    localgr.dsA.dsE = parama.dsE;
    localgr.dsA.width = parama.width;
    localgr.dsA.height = parama.height;
    a.IbL.l(localgr);
    AppMethodBeat.o(27832);
  }
  
  public final void dEn()
  {
    AppMethodBeat.i(27835);
    gr localgr = new gr();
    localgr.dsA.opType = 4;
    a.IbL.l(localgr);
    AppMethodBeat.o(27835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.c
 * JD-Core Version:    0.7.0.1
 */