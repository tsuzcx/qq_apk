package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ho;
import com.tencent.mm.autogen.a.ho.a;
import com.tencent.mm.autogen.a.ho.b;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements h.a
{
  public c(Context paramContext)
  {
    AppMethodBeat.i(27831);
    ho localho = new ho();
    localho.hIw.opType = 3;
    localho.hIw.context = paramContext;
    localho.publish();
    AppMethodBeat.o(27831);
  }
  
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(27834);
    ho localho = new ho();
    localho.hIw.opType = 2;
    localho.hIw.hID = false;
    if (paramb.hIB)
    {
      localho.hIw.hIy = paramb.hIy;
      localho.hIw.hIB = paramb.hIB;
    }
    for (;;)
    {
      localho.publish();
      Log.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", new Object[] { Long.valueOf(paramb.NBD), paramb.hIy.hIQ, localho.hIx.hIE, Boolean.valueOf(localho.hIw.hIB) });
      paramb = localho.hIx.hIE;
      AppMethodBeat.o(27834);
      return paramb;
      localho.hIw.hIy = paramb.hIy;
      localho.hIw.hDn = paramb.NBD;
      localho.hIw.maxWidth = paramb.maxWidth;
      localho.hIw.hIC = paramb.hIC;
    }
  }
  
  public final Bitmap a(h.a.c paramc)
  {
    AppMethodBeat.i(27833);
    ho localho = new ho();
    localho.hIw.opType = 0;
    localho.hIw.hIy = paramc.hIy;
    localho.hIw.hDn = paramc.NBD;
    localho.publish();
    Log.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", new Object[] { Long.valueOf(paramc.NBD), localho.hIx.hIE });
    paramc = localho.hIx.hIE;
    AppMethodBeat.o(27833);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    AppMethodBeat.i(27832);
    Log.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", new Object[] { Long.valueOf(parama.NBD) });
    ho localho = new ho();
    localho.hIw.opType = 1;
    localho.hIw.hIz = parama.hIz;
    localho.hIw.hIy = parama.hIy;
    localho.hIw.hDn = parama.NBD;
    localho.hIw.hIA = parama.hIA;
    localho.hIw.width = parama.width;
    localho.hIw.height = parama.height;
    localho.publish();
    AppMethodBeat.o(27832);
  }
  
  public final void gGl()
  {
    AppMethodBeat.i(27835);
    ho localho = new ho();
    localho.hIw.opType = 4;
    localho.publish();
    AppMethodBeat.o(27835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.c
 * JD-Core Version:    0.7.0.1
 */