package com.tencent.mm.ui.chatting.viewitems.a;

import com.tencent.c.a.a.a.b;
import com.tencent.c.a.a.a.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.ca;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class a$f
  implements Runnable
{
  a$f(ca paramca) {}
  
  public final void run()
  {
    AppMethodBeat.i(291249);
    f localf = ((b)h.ag(b.class)).getFinderLiveNotifyExposureInfoStorage();
    ca localca = this.lEd;
    if (localca != null) {}
    for (long l = localca.apG();; l = -1L)
    {
      localf.Lt(l);
      AppMethodBeat.o(291249);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.a.a.f
 * JD-Core Version:    0.7.0.1
 */