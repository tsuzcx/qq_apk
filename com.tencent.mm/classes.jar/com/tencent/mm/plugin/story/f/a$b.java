package com.tencent.mm.plugin.story.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.e.b.a;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class a$b
  implements Runnable
{
  a$b(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(109499);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    localObject1 = k.a(j.b.cAB(), a.a(this.sAx), a.b(this.sAx));
    if (!((List)localObject1).isEmpty()) {
      a.a(this.sAx, ((com.tencent.mm.plugin.story.h.j)a.a.j.fS((List)localObject1)).field_storyID);
    }
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      com.tencent.mm.plugin.story.h.j localj = (com.tencent.mm.plugin.story.h.j)localIterator.next();
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = j.b.cAH();
      Object localObject2 = com.tencent.mm.plugin.story.e.b.ssx;
      localObject2 = ((i)localObject1).adE(b.a.i(Integer.valueOf(localj.field_createTime)));
      localObject1 = a.sAw;
      String str = a.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("loadDBData rawLocalId=").append((int)localj.systemRowid).append(" rawStoryId=").append(localj.field_storyID).append(" date=");
      if (localObject2 != null)
      {
        localObject1 = ((h)localObject2).cEX();
        label190:
        localStringBuilder = localStringBuilder.append((String)localObject1).append(" count=");
        if (localObject2 == null) {
          break label317;
        }
      }
      label317:
      for (localObject1 = Integer.valueOf(((h)localObject2).field_count);; localObject1 = null)
      {
        ab.d(str, localObject1);
        if (localObject2 == null) {
          break;
        }
        localObject1 = com.tencent.mm.plugin.story.model.j.svi;
        localj = j.b.cAB().Gb((int)localj.systemRowid);
        localObject1 = localj;
        if (localj == null) {
          localObject1 = new com.tencent.mm.plugin.story.h.j();
        }
        a.f.b.j.q(localObject1, "<set-?>");
        ((h)localObject2).szQ = ((com.tencent.mm.plugin.story.h.j)localObject1);
        if (localArrayList2.contains(((h)localObject2).cEX())) {
          break;
        }
        localArrayList1.add(localObject2);
        localArrayList2.add(((h)localObject2).cEX());
        break;
        localObject1 = null;
        break label190;
      }
    }
    localObject1 = a.sAw;
    ab.d(a.access$getTAG$cp(), "localCachedMinId=" + a.c(this.sAx) + " infos.size=" + localArrayList1.size() + " localMinId=" + a.b(this.sAx));
    com.tencent.mm.ab.b.b((a.f.a.a)new a.b.1(this, a.a(this.sAx, (List)localArrayList1)));
    AppMethodBeat.o(109499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.b
 * JD-Core Version:    0.7.0.1
 */