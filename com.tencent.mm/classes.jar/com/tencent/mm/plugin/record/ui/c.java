package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.g.a.gf.a;
import com.tencent.mm.g.a.gf.b;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  implements h.a
{
  public c(Context paramContext)
  {
    AppMethodBeat.i(24190);
    gf localgf = new gf();
    localgf.cuJ.opType = 3;
    localgf.cuJ.context = paramContext;
    a.ymk.l(localgf);
    AppMethodBeat.o(24190);
  }
  
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(24193);
    gf localgf = new gf();
    localgf.cuJ.opType = 2;
    localgf.cuJ.cuQ = false;
    if (paramb.cuO)
    {
      localgf.cuJ.cuL = paramb.cuL;
      localgf.cuJ.cuO = paramb.cuO;
    }
    for (;;)
    {
      a.ymk.l(localgf);
      ab.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", new Object[] { Long.valueOf(paramb.pZy), paramb.cuL.mBq, localgf.cuK.cuR, Boolean.valueOf(localgf.cuJ.cuO) });
      paramb = localgf.cuK.cuR;
      AppMethodBeat.o(24193);
      return paramb;
      localgf.cuJ.cuL = paramb.cuL;
      localgf.cuJ.cpM = paramb.pZy;
      localgf.cuJ.maxWidth = paramb.maxWidth;
      localgf.cuJ.cuP = paramb.cuP;
    }
  }
  
  public final Bitmap a(h.a.c paramc)
  {
    AppMethodBeat.i(24192);
    gf localgf = new gf();
    localgf.cuJ.opType = 0;
    localgf.cuJ.cuL = paramc.cuL;
    localgf.cuJ.cpM = paramc.pZy;
    a.ymk.l(localgf);
    ab.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", new Object[] { Long.valueOf(paramc.pZy), localgf.cuK.cuR });
    paramc = localgf.cuK.cuR;
    AppMethodBeat.o(24192);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    AppMethodBeat.i(24191);
    ab.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", new Object[] { Long.valueOf(parama.pZy) });
    gf localgf = new gf();
    localgf.cuJ.opType = 1;
    localgf.cuJ.cuM = parama.cuM;
    localgf.cuJ.cuL = parama.cuL;
    localgf.cuJ.cpM = parama.pZy;
    localgf.cuJ.cuN = parama.cuN;
    localgf.cuJ.width = parama.width;
    localgf.cuJ.height = parama.height;
    a.ymk.l(localgf);
    AppMethodBeat.o(24191);
  }
  
  public final void cfT()
  {
    AppMethodBeat.i(24194);
    gf localgf = new gf();
    localgf.cuJ.opType = 4;
    a.ymk.l(localgf);
    AppMethodBeat.o(24194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.c
 * JD-Core Version:    0.7.0.1
 */