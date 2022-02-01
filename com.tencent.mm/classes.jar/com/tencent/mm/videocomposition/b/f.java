package com.tencent.mm.videocomposition.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/render/RenderProcessCallbackList;", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "()V", "callbackList", "Ljava/util/LinkedList;", "addCallback", "", "callback", "onFrameStart", "pts", "", "onRelease", "removeCallback", "video_composition_release"})
public final class f
  implements e
{
  private final LinkedList<e> VbD;
  
  public f()
  {
    AppMethodBeat.i(248555);
    this.VbD = new LinkedList();
    AppMethodBeat.o(248555);
  }
  
  public final void Sj(long paramLong)
  {
    AppMethodBeat.i(248550);
    synchronized (this.VbD)
    {
      Iterator localIterator = ((Iterable)this.VbD).iterator();
      if (localIterator.hasNext()) {
        ((e)localIterator.next()).Sj(paramLong);
      }
    }
    x localx = x.aazN;
    AppMethodBeat.o(248550);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(248549);
    p.k(parame, "callback");
    synchronized (this.VbD)
    {
      if (!this.VbD.contains(parame)) {
        this.VbD.add(parame);
      }
      parame = x.aazN;
      AppMethodBeat.o(248549);
      return;
    }
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(248552);
    synchronized (this.VbD)
    {
      Iterator localIterator = ((Iterable)this.VbD).iterator();
      if (localIterator.hasNext()) {
        ((e)localIterator.next()).onRelease();
      }
    }
    x localx = x.aazN;
    AppMethodBeat.o(248552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.f
 * JD-Core Version:    0.7.0.1
 */