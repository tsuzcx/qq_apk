package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.e;
import com.tencent.mm.plugin.newtips.a.i.a;

final class ah$a
  implements i.a
{
  d adHj;
  
  public ah$a(d paramd)
  {
    this.adHj = paramd;
  }
  
  public final void e(com.tencent.mm.plugin.newtips.b.a parama)
  {
    AppMethodBeat.i(33505);
    if ((parama != null) && (parama.field_tipId == com.tencent.mm.plugin.newtips.a.d.Mse))
    {
      com.tencent.mm.plugin.newtips.a.gti();
      if (e.aeE(com.tencent.mm.plugin.newtips.a.d.Mse)) {
        this.adHj.KU(true);
      }
    }
    AppMethodBeat.o(33505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ah.a
 * JD-Core Version:    0.7.0.1
 */