package com.tencent.mm.plugin.story.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.d.f;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class h$f
  implements Runnable
{
  h$f(h paramh) {}
  
  public final void run()
  {
    Object localObject2 = null;
    AppMethodBeat.i(138808);
    int i;
    if ((h.c(this.sBV) >= 0) && (h.c(this.sBV) < h.d(this.sBV).size()) && ((h.c(this.sBV) == h.e(this.sBV)) || (h.e(this.sBV) == -1)))
    {
      i = 1;
      if (i != 0)
      {
        localObject1 = (g)a.a.j.w((List)((h.a)h.d(this.sBV).get(h.c(this.sBV))).cBy, h.g(this.sBV));
        if (localObject1 == null) {
          break label284;
        }
      }
    }
    label284:
    for (Object localObject1 = ((g)localObject1).sys;; localObject1 = null)
    {
      String str = h.h(this.sBV);
      StringBuilder localStringBuilder = new StringBuilder("setSelectedRead ").append(h.g(this.sBV)).append(", ");
      if (localObject1 != null) {
        localObject2 = Boolean.valueOf(((f)localObject1).sxy);
      }
      ab.i(str, localObject2);
      if ((localObject1 != null) && (((f)localObject1).rPQ.size() > 0))
      {
        localObject2 = com.tencent.mm.plugin.story.model.b.b.sxN;
        long l = ((f)localObject1).cJA;
        localObject2 = ((f)localObject1).rPQ.getLast();
        a.f.b.j.p(localObject2, "comment.commentList.last");
        if (com.tencent.mm.plugin.story.model.b.b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject2)) {
          com.tencent.mm.ab.b.b((a.f.a.a)new h.f.1(this, (f)localObject1));
        }
      }
      h.f(this.sBV);
      AppMethodBeat.o(138808);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.h.f
 * JD-Core Version:    0.7.0.1
 */