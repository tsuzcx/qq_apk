package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/CompositionTrack$Companion;", "", "()V", "TAG", "", "TypeAudio", "", "TypeImage", "TypeUnknown", "TypeVideo", "makeChain", "", "trackList", "", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "video_composition_release"})
public final class b$a
{
  public static void iM(List<b> paramList)
  {
    AppMethodBeat.i(220813);
    p.h(paramList, "trackList");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(220813);
      return;
    }
    long l2 = 0L;
    Object localObject = null;
    Iterator localIterator = ((Iterable)paramList).iterator();
    long l1 = 0L;
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      long l4 = ((float)(localb.HCV - localb.HCU) / localb.llC);
      if (localb.LmB.isValid()) {}
      for (long l3 = localb.LmB.duration;; l3 = 0L)
      {
        l2 = Math.min(l3, Math.min(l2, l4));
        if (localObject != null) {
          localObject.LmD = (l1 - l2 / 2L);
        }
        localb.LmC = (l1 - l2 / 2L);
        localb.Bi(l1 - l2);
        localb.Bj(localb.startTimeMs + l4);
        l1 = localb.hiy;
        localObject = localb;
        l2 = l4;
        break;
      }
    }
    paramList = (b)j.je(paramList);
    paramList.LmD = paramList.hiy;
    AppMethodBeat.o(220813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.a
 * JD-Core Version:    0.7.0.1
 */