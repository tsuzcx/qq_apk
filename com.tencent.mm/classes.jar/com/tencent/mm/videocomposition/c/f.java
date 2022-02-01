package com.tencent.mm.videocomposition.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/render/RenderProcessCallbackList;", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "()V", "callbackList", "Ljava/util/LinkedList;", "addCallback", "", "callback", "onFrameStart", "pts", "", "onRelease", "removeCallback", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class f
  implements e
{
  private final LinkedList<e> acCV;
  
  public f()
  {
    AppMethodBeat.i(233519);
    this.acCV = new LinkedList();
    AppMethodBeat.o(233519);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(233528);
    s.t(parame, "callback");
    synchronized (this.acCV)
    {
      if (!this.acCV.contains(parame)) {
        this.acCV.add(parame);
      }
      parame = ah.aiuX;
      AppMethodBeat.o(233528);
      return;
    }
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(233546);
    synchronized (this.acCV)
    {
      Iterator localIterator = ((Iterable)this.acCV).iterator();
      if (localIterator.hasNext()) {
        ((e)localIterator.next()).onRelease();
      }
    }
    ah localah = ah.aiuX;
    AppMethodBeat.o(233546);
  }
  
  public final void wx(long paramLong)
  {
    AppMethodBeat.i(233537);
    synchronized (this.acCV)
    {
      Iterator localIterator = ((Iterable)this.acCV).iterator();
      if (localIterator.hasNext()) {
        ((e)localIterator.next()).wx(paramLong);
      }
    }
    ah localah = ah.aiuX;
    AppMethodBeat.o(233537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c.f
 * JD-Core Version:    0.7.0.1
 */