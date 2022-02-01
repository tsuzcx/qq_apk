package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class h$m
  implements Runnable
{
  h$m(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(293173);
    b localb = h.b(this.OeF);
    if (localb != null)
    {
      localb.invoke(this.OeF);
      AppMethodBeat.o(293173);
      return;
    }
    AppMethodBeat.o(293173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.h.m
 * JD-Core Version:    0.7.0.1
 */