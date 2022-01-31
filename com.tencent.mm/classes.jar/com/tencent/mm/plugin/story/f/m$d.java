package com.tencent.mm.plugin.story.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class m$d
  implements Runnable
{
  m$d(m paramm, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(151107);
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    Object localObject3 = j.b.cAB().bD(this.sCG.ikj, true);
    Object localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject4 = ((Iterable)this.sCL).iterator();
    Object localObject5;
    Object localObject6;
    label106:
    int i;
    label140:
    label163:
    label168:
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (com.tencent.mm.plugin.story.h.j)((Iterator)localObject4).next();
      localObject6 = (Iterable)localObject3;
      if (!((Collection)localObject6).isEmpty())
      {
        localObject6 = ((Iterable)localObject6).iterator();
        if (((Iterator)localObject6).hasNext()) {
          if (((com.tencent.mm.plugin.story.h.j)((Iterator)localObject6).next()).field_storyID == ((com.tencent.mm.plugin.story.h.j)localObject5).field_storyID)
          {
            i = 1;
            if (i == 0) {
              break label163;
            }
          }
        }
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label168;
        }
        ((ArrayList)localObject2).add(localObject5);
        break;
        i = 0;
        break label140;
        break label106;
      }
    }
    localObject3 = ((Iterable)localObject3).iterator();
    label277:
    label300:
    label305:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (com.tencent.mm.plugin.story.h.j)((Iterator)localObject3).next();
      localObject5 = (Iterable)this.sCL;
      if ((!(localObject5 instanceof Collection)) || (!((Collection)localObject5).isEmpty()))
      {
        localObject5 = ((Iterable)localObject5).iterator();
        label243:
        if (((Iterator)localObject5).hasNext()) {
          if (((com.tencent.mm.plugin.story.h.j)((Iterator)localObject5).next()).field_storyID == ((com.tencent.mm.plugin.story.h.j)localObject4).field_storyID)
          {
            i = 1;
            if (i == 0) {
              break label300;
            }
          }
        }
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label305;
        }
        ((ArrayList)localObject1).add(localObject4);
        break;
        i = 0;
        break label277;
        break label243;
      }
    }
    ab.i(this.sCG.TAG, "LogStory: setFavorite " + ((ArrayList)localObject2).size() + ' ' + ((ArrayList)localObject1).size());
    localObject3 = new ArrayList();
    localObject4 = new ArrayList();
    if (!((Collection)localObject2).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.story.h.j)((Iterator)localObject2).next();
          ((ArrayList)localObject3).add(Long.valueOf(((com.tencent.mm.plugin.story.h.j)localObject5).field_storyID));
          ((ArrayList)localObject4).add(Integer.valueOf((int)((com.tencent.mm.plugin.story.h.j)localObject5).systemRowid));
          localObject6 = i.sFa;
          i.a(1L, ((com.tencent.mm.plugin.story.h.j)localObject5).toString(), 0L, 0L, 1L);
          continue;
          i = 0;
          break;
        }
      }
      localObject2 = n.svx;
      n.a.a((List)localObject3, (List)localObject4, true);
    }
    ((ArrayList)localObject3).clear();
    ((ArrayList)localObject4).clear();
    if (!((Collection)localObject1).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.story.h.j)((Iterator)localObject1).next();
          ((ArrayList)localObject3).add(Long.valueOf(((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID));
          ((ArrayList)localObject4).add(Integer.valueOf((int)((com.tencent.mm.plugin.story.h.j)localObject2).systemRowid));
          localObject5 = i.sFa;
          i.a(2L, ((com.tencent.mm.plugin.story.h.j)localObject2).toString(), 0L, 0L, 1L);
          continue;
          i = 0;
          break;
        }
      }
      localObject1 = n.svx;
      n.a.a((List)localObject3, (List)localObject4, false);
    }
    AppMethodBeat.o(151107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.m.d
 * JD-Core Version:    0.7.0.1
 */