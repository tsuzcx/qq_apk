package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
final class q$a
  implements MTimerHandler.CallBack
{
  q$a(q paramq) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(203780);
    this.FDN.eZx();
    AppMethodBeat.o(203780);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.q.a
 * JD-Core Version:    0.7.0.1
 */