package com.tencent.mm.plugin.record.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.b.n;

public final class g
  extends n
  implements h.a
{
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(27867);
    paramb = super.a(paramb.fDI, paramb.HEb, paramb.fDL, paramb.maxWidth);
    AppMethodBeat.o(27867);
    return paramb;
  }
  
  public final Bitmap a(h.a.c paramc)
  {
    AppMethodBeat.i(27866);
    paramc = super.b(paramc.fDI, paramc.HEb);
    AppMethodBeat.o(27866);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    AppMethodBeat.i(27865);
    super.a(parama.fDJ, parama.fDI, parama.HEb, parama.fDK, parama.width, parama.height);
    AppMethodBeat.o(27865);
  }
  
  public final void fuw()
  {
    AppMethodBeat.i(27868);
    super.destory();
    AppMethodBeat.o(27868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.g
 * JD-Core Version:    0.7.0.1
 */