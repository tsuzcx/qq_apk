package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.go.a;
import com.tencent.mm.g.a.go.b;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  implements h.a
{
  public c(Context paramContext)
  {
    AppMethodBeat.i(27831);
    go localgo = new go();
    localgo.dhc.opType = 3;
    localgo.dhc.context = paramContext;
    a.GpY.l(localgo);
    AppMethodBeat.o(27831);
  }
  
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(27834);
    go localgo = new go();
    localgo.dhc.opType = 2;
    localgo.dhc.dhj = false;
    if (paramb.dhh)
    {
      localgo.dhc.dhe = paramb.dhe;
      localgo.dhc.dhh = paramb.dhh;
    }
    for (;;)
    {
      a.GpY.l(localgo);
      ac.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", new Object[] { Long.valueOf(paramb.wkf), paramb.dhe.dhw, localgo.dhd.dhk, Boolean.valueOf(localgo.dhc.dhh) });
      paramb = localgo.dhd.dhk;
      AppMethodBeat.o(27834);
      return paramb;
      localgo.dhc.dhe = paramb.dhe;
      localgo.dhc.dcg = paramb.wkf;
      localgo.dhc.maxWidth = paramb.maxWidth;
      localgo.dhc.dhi = paramb.dhi;
    }
  }
  
  public final Bitmap a(h.a.c paramc)
  {
    AppMethodBeat.i(27833);
    go localgo = new go();
    localgo.dhc.opType = 0;
    localgo.dhc.dhe = paramc.dhe;
    localgo.dhc.dcg = paramc.wkf;
    a.GpY.l(localgo);
    ac.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", new Object[] { Long.valueOf(paramc.wkf), localgo.dhd.dhk });
    paramc = localgo.dhd.dhk;
    AppMethodBeat.o(27833);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    AppMethodBeat.i(27832);
    ac.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", new Object[] { Long.valueOf(parama.wkf) });
    go localgo = new go();
    localgo.dhc.opType = 1;
    localgo.dhc.dhf = parama.dhf;
    localgo.dhc.dhe = parama.dhe;
    localgo.dhc.dcg = parama.wkf;
    localgo.dhc.dhg = parama.dhg;
    localgo.dhc.width = parama.width;
    localgo.dhc.height = parama.height;
    a.GpY.l(localgo);
    AppMethodBeat.o(27832);
  }
  
  public final void dtQ()
  {
    AppMethodBeat.i(27835);
    go localgo = new go();
    localgo.dhc.opType = 4;
    a.GpY.l(localgo);
    AppMethodBeat.o(27835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.c
 * JD-Core Version:    0.7.0.1
 */