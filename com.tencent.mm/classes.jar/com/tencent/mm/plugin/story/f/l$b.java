package com.tencent.mm.plugin.story.f;

import a.f.a.a;
import a.f.b.u.d;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class l$b
  implements Runnable
{
  l$b(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(138818);
    final ArrayList localArrayList = new ArrayList();
    final u.d locald = new u.d();
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    localObject = j.b.cAB();
    String str1 = l.a(this.sCB);
    String str2 = l.a(this.sCB);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    locald.BNq = com.tencent.mm.plugin.story.h.k.a((com.tencent.mm.plugin.story.h.k)localObject, str1, bo.isEqual(str2, j.b.coK()), l.b(this.sCB));
    int i;
    if (!((Collection)locald.BNq).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label222;
      }
      l.a(this.sCB, ((com.tencent.mm.plugin.story.h.j)a.a.j.fS((List)locald.BNq)).field_storyID);
    }
    for (;;)
    {
      localObject = l.sCA;
      ab.d(l.access$getTAG$cp(), "localCachedMinId=" + l.c(this.sCB) + " infos.size=" + ((List)locald.BNq).size() + " localMinId=" + l.b(this.sCB));
      b.b((a)new a.f.b.k(locald) {});
      AppMethodBeat.o(138818);
      return;
      i = 0;
      break;
      label222:
      localObject = com.tencent.mm.plugin.story.model.j.svi;
      localObject = j.b.cAB();
      str1 = l.a(this.sCB);
      str2 = l.a(this.sCB);
      localb = com.tencent.mm.plugin.story.model.j.svi;
      localArrayList.addAll((Collection)((com.tencent.mm.plugin.story.h.k)localObject).bC(str1, bo.isEqual(str2, j.b.coK())));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.l.b
 * JD-Core Version:    0.7.0.1
 */