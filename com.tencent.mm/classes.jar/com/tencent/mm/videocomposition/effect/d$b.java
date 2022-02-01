package com.tencent.mm.videocomposition.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.xeffect.VLogDirector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.a;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class d$b
  implements Runnable
{
  d$b(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(248199);
    d.a(this.YIU);
    ??? = this.YIU;
    ((d)???).GhL.init();
    ((d)???).GhL.c(((d)???).ANo);
    this.YIU.YIK = new f();
    this.YIU.YIM = true;
    synchronized (this.YIU.YIP)
    {
      Iterator localIterator = ((Iterable)this.YIU.YIP).iterator();
      if (localIterator.hasNext()) {
        ((a)localIterator.next()).invoke();
      }
    }
    this.YIU.YIP.clear();
    x localx = x.aazN;
    b.i(this.YIU.getTAG(), "initEGL finished", new Object[0]);
    AppMethodBeat.o(248199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.d.b
 * JD-Core Version:    0.7.0.1
 */