package com.tencent.mm.plugin.story.f;

import a.f.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class m$a
  implements Runnable
{
  m$a(m paramm, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(151104);
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    Object localObject2 = k.a(j.b.cAB(), this.sCG.sAt);
    if (!((List)localObject2).isEmpty()) {
      this.sCG.sAs = ((com.tencent.mm.plugin.story.h.j)a.a.j.fS((List)localObject2)).field_storyID;
    }
    ab.d(this.sCG.TAG, "localCachedMinId=" + this.sCG.sAs + " infos.size=" + ((List)localObject2).size() + " localMinId=" + this.sCG.sAt);
    localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    if (this.sCH)
    {
      localObject3 = com.tencent.mm.plugin.story.model.j.svi;
      localObject3 = j.b.cAB();
      j.b localb = com.tencent.mm.plugin.story.model.j.svi;
      localArrayList.addAll((Collection)((k)localObject3).bD(j.b.coK(), true));
    }
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.story.h.j)((Iterator)localObject2).next();
      if ((((com.tencent.mm.plugin.story.h.j)localObject3).field_storyID != 0L) && (!((com.tencent.mm.plugin.story.h.j)localObject3).cFc())) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    b.b((a)new m.a.1(this, (ArrayList)localObject1, localArrayList));
    AppMethodBeat.o(151104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.m.a
 * JD-Core Version:    0.7.0.1
 */