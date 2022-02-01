package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.g.a.gn.a;
import com.tencent.mm.g.a.gn.b;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  implements h.a
{
  public c(Context paramContext)
  {
    AppMethodBeat.i(27831);
    gn localgn = new gn();
    localgn.djH.opType = 3;
    localgn.djH.context = paramContext;
    a.ESL.l(localgn);
    AppMethodBeat.o(27831);
  }
  
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(27834);
    gn localgn = new gn();
    localgn.djH.opType = 2;
    localgn.djH.djO = false;
    if (paramb.djM)
    {
      localgn.djH.djJ = paramb.djJ;
      localgn.djH.djM = paramb.djM;
    }
    for (;;)
    {
      a.ESL.l(localgn);
      ad.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", new Object[] { Long.valueOf(paramb.vbr), paramb.djJ.dkb, localgn.djI.djP, Boolean.valueOf(localgn.djH.djM) });
      paramb = localgn.djI.djP;
      AppMethodBeat.o(27834);
      return paramb;
      localgn.djH.djJ = paramb.djJ;
      localgn.djH.deL = paramb.vbr;
      localgn.djH.maxWidth = paramb.maxWidth;
      localgn.djH.djN = paramb.djN;
    }
  }
  
  public final Bitmap a(h.a.c paramc)
  {
    AppMethodBeat.i(27833);
    gn localgn = new gn();
    localgn.djH.opType = 0;
    localgn.djH.djJ = paramc.djJ;
    localgn.djH.deL = paramc.vbr;
    a.ESL.l(localgn);
    ad.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", new Object[] { Long.valueOf(paramc.vbr), localgn.djI.djP });
    paramc = localgn.djI.djP;
    AppMethodBeat.o(27833);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    AppMethodBeat.i(27832);
    ad.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", new Object[] { Long.valueOf(parama.vbr) });
    gn localgn = new gn();
    localgn.djH.opType = 1;
    localgn.djH.djK = parama.djK;
    localgn.djH.djJ = parama.djJ;
    localgn.djH.deL = parama.vbr;
    localgn.djH.djL = parama.djL;
    localgn.djH.width = parama.width;
    localgn.djH.height = parama.height;
    a.ESL.l(localgn);
    AppMethodBeat.o(27832);
  }
  
  public final void dgj()
  {
    AppMethodBeat.i(27835);
    gn localgn = new gn();
    localgn.djH.opType = 4;
    a.ESL.l(localgn);
    AppMethodBeat.o(27835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.c
 * JD-Core Version:    0.7.0.1
 */