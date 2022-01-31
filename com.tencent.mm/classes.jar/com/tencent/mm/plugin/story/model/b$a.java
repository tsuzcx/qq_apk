package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class b$a
  implements Runnable
{
  public static final a suo;
  
  static
  {
    AppMethodBeat.i(109002);
    suo = new a();
    AppMethodBeat.o(109002);
  }
  
  public final void run()
  {
    AppMethodBeat.i(109001);
    Object localObject1 = b.sun;
    if (b.cAa())
    {
      AppMethodBeat.o(109001);
      return;
    }
    localObject1 = b.sun;
    b.lT(true);
    localObject1 = b.sun;
    b.cAb().clear();
    localObject1 = new ArrayList();
    ??? = new ArrayList();
    ??? = b.sun;
    ??? = b.cAc();
    j.p(???, "mFavourUserList");
    for (;;)
    {
      Object localObject7;
      Object localObject8;
      synchronized ((Iterable)???)
      {
        localObject7 = ((Iterable)???).iterator();
        i = 0;
        if (!((Iterator)localObject7).hasNext()) {
          break label237;
        }
        localObject8 = (String)((Iterator)localObject7).next();
        localObject9 = f.suC;
        if (f.a.isStoryUnread((String)localObject8))
        {
          localObject9 = b.sun;
          ab.d(b.cAd(), "%s has new story", new Object[] { localObject8 });
          i |= 0x1;
          ((ArrayList)???).add(localObject8);
        }
      }
      Object localObject9 = b.sun;
      j.p(localObject8, "username");
      int j = i;
      if (b.acQ((String)localObject8))
      {
        localObject9 = b.sun;
        ab.d(b.cAd(), "%s has story", new Object[] { localObject8 });
        j = i | 0x2;
        localObject2.add(localObject8);
        break label513;
        label237:
        localObject7 = y.BMg;
        ??? = b.sun;
        if (b.cAe() != i)
        {
          ??? = b.sun;
          b.FF(i);
        }
        ??? = b.sun;
        b.cAb().addAll((Collection)???);
        ??? = b.sun;
        b.cAb().addAll((Collection)localObject2);
        ArrayList localArrayList = new ArrayList();
        ??? = b.sun;
        ??? = b.cAf();
        j.p(???, "mListeners");
        for (;;)
        {
          synchronized ((Iterable)???)
          {
            ??? = ((Iterable)???).iterator();
            if (!((Iterator)???).hasNext()) {
              break;
            }
            localObject7 = (WeakReference)((Iterator)???).next();
            if ((c)((WeakReference)localObject7).get() == null) {
              localArrayList.add(localObject7);
            }
          }
          localObject7 = (c)((WeakReference)localObject7).get();
          if (localObject7 != null)
          {
            localObject8 = b.sun;
            ((c)localObject7).FA(b.cAe());
          }
        }
        ??? = y.BMg;
        ??? = b.sun;
        b.cAf().removeAll((Collection)localObject3);
        Object localObject4 = b.sun;
        b.lT(false);
        localObject4 = b.sun;
        localObject4 = b.cAd();
        ??? = b.sun;
        ab.i((String)localObject4, "checkStoryStatus:%s nowState:%s", new Object[] { Integer.valueOf(b.cAe()), Integer.valueOf(i) });
        AppMethodBeat.o(109001);
        return;
      }
      label513:
      int i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.b.a
 * JD-Core Version:    0.7.0.1
 */