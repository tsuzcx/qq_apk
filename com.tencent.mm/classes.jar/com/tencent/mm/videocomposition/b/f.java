package com.tencent.mm.videocomposition.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/render/RenderProcessCallbackList;", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "()V", "callbackList", "Ljava/util/LinkedList;", "addCallback", "", "callback", "onFrameStart", "pts", "", "onRelease", "removeCallback", "video_composition_release"})
public final class f
  implements e
{
  private final LinkedList<e> NNT;
  
  public f()
  {
    AppMethodBeat.i(216851);
    this.NNT = new LinkedList();
    AppMethodBeat.o(216851);
  }
  
  public final void KM(long paramLong)
  {
    AppMethodBeat.i(216849);
    synchronized (this.NNT)
    {
      Iterator localIterator = ((Iterable)this.NNT).iterator();
      if (localIterator.hasNext()) {
        ((e)localIterator.next()).KM(paramLong);
      }
    }
    x localx = x.SXb;
    AppMethodBeat.o(216849);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(216848);
    p.h(parame, "callback");
    synchronized (this.NNT)
    {
      if (!this.NNT.contains(parame)) {
        this.NNT.add(parame);
      }
      parame = x.SXb;
      AppMethodBeat.o(216848);
      return;
    }
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(216850);
    synchronized (this.NNT)
    {
      Iterator localIterator = ((Iterable)this.NNT).iterator();
      if (localIterator.hasNext()) {
        ((e)localIterator.next()).onRelease();
      }
    }
    x localx = x.SXb;
    AppMethodBeat.o(216850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.f
 * JD-Core Version:    0.7.0.1
 */