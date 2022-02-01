package com.tencent.mm.plugin.multitask.ui.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.ui.panel.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$hideSnapshotUIC$1$1"})
final class MultiTaskUIC$d
  implements Runnable
{
  MultiTaskUIC$d(MultiTaskUIC paramMultiTaskUIC, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(236646);
    b localb = this.Agq.AfE;
    if (localb != null)
    {
      g localg = g.zZj;
      localb.aGO(g.eqx());
    }
    this.Agq.hx(true);
    AppMethodBeat.o(236646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC.d
 * JD-Core Version:    0.7.0.1
 */