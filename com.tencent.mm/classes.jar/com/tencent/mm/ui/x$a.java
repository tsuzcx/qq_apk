package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.b;
import com.tencent.mm.ax.d.a;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.storage.bm;

final class x$a
  implements d.a
{
  c zcL;
  
  public x$a(c paramc)
  {
    this.zcL = paramc;
  }
  
  public final void e(bm parambm)
  {
    AppMethodBeat.i(29671);
    if (parambm.field_tipId == b.fKS)
    {
      a.bWU();
      if (com.tencent.mm.ax.c.lO(b.fKS)) {
        this.zcL.qb(true);
      }
    }
    AppMethodBeat.o(29671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.x.a
 * JD-Core Version:    0.7.0.1
 */