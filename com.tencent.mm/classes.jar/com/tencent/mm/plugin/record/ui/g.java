package com.tencent.mm.plugin.record.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.model.o;

public final class g
  extends o
  implements h.a
{
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(27867);
    paramb = super.a(paramb.hIy, paramb.NBD, paramb.hIB, paramb.maxWidth);
    AppMethodBeat.o(27867);
    return paramb;
  }
  
  public final Bitmap a(h.a.c paramc)
  {
    AppMethodBeat.i(27866);
    paramc = super.b(paramc.hIy, paramc.NBD);
    AppMethodBeat.o(27866);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    AppMethodBeat.i(27865);
    super.a(parama.hIz, parama.hIy, parama.NBD, parama.hIA, parama.width, parama.height);
    AppMethodBeat.o(27865);
  }
  
  public final void gGl()
  {
    AppMethodBeat.i(27868);
    super.destory();
    AppMethodBeat.o(27868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.g
 * JD-Core Version:    0.7.0.1
 */