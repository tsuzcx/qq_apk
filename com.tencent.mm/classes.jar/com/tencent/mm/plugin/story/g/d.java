package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.f.d.a;
import com.tencent.mm.plugin.story.f.j.b;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/presenter/GalleryPresenterFactory;", "", "()V", "QUERY_CONDITION_ALL_UNREAD", "", "getQUERY_CONDITION_ALL_UNREAD", "()I", "QUERY_CONDITION_BIG_MOUTH", "getQUERY_CONDITION_BIG_MOUTH", "QUERY_CONDITION_DEFAULT", "getQUERY_CONDITION_DEFAULT", "QUERY_CONDITION_WITH_FILTER", "getQUERY_CONDITION_WITH_FILTER", "getPresenter", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "dataSeed", "groupCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "", "plugin-story_release"})
public final class d
{
  private static final int BgL = 0;
  private static final int BgM = 1;
  private static final int BgN = 2;
  private static final int BgO = 4;
  public static final d BgP;
  
  static
  {
    AppMethodBeat.i(119194);
    BgP = new d();
    BgM = 1;
    BgN = 2;
    BgO = 4;
    AppMethodBeat.o(119194);
  }
  
  public static f a(Object paramObject, c paramc, n.a parama, String paramString)
  {
    AppMethodBeat.i(119193);
    d.g.b.p.h(paramc, "groupCallback");
    d.g.b.p.h(parama, "galleryType");
    Object localObject;
    if ((paramObject instanceof com.tencent.mm.plugin.story.api.p))
    {
      paramString = com.tencent.mm.plugin.story.f.d.f.a((com.tencent.mm.plugin.story.api.p)paramObject);
      parama = (com.tencent.mm.plugin.story.api.p)paramObject;
      d.g.b.p.h(parama, "dataSeed");
      if ((parama instanceof a)) {
        parama = ((a)parama).BdR;
      }
      int i;
      for (;;)
      {
        i = ((com.tencent.mm.plugin.story.api.p)paramObject).AZK;
        localObject = com.tencent.mm.plugin.story.h.h.BjR;
        com.tencent.mm.plugin.story.h.h.enI().lu(paramString.size());
        if (!(paramObject instanceof com.tencent.mm.plugin.story.f.d.c)) {
          break label192;
        }
        if (!((com.tencent.mm.plugin.story.f.d.c)paramObject).zan) {
          break;
        }
        paramObject = (f)new i(((com.tencent.mm.plugin.story.f.d.c)paramObject).username, paramString, paramc, parama, i);
        AppMethodBeat.o(119193);
        return paramObject;
        if ((parama instanceof com.tencent.mm.plugin.story.f.d.c)) {
          parama = ((com.tencent.mm.plugin.story.f.d.c)parama).BdR;
        } else {
          parama = (Map)new HashMap();
        }
      }
      paramObject = (f)new b(((com.tencent.mm.plugin.story.f.d.c)paramObject).username, paramString, paramc);
      AppMethodBeat.o(119193);
      return paramObject;
      label192:
      if ((paramObject instanceof com.tencent.mm.plugin.story.f.d.d))
      {
        paramObject = (f)new g(paramString, null, paramc, parama, i);
        AppMethodBeat.o(119193);
        return paramObject;
      }
      paramObject = (f)new g(paramString, null, paramc, parama, i);
      AppMethodBeat.o(119193);
      return paramObject;
    }
    if (d.a.j.listOf(new n.a[] { n.a.AZA, n.a.AZz }).contains(parama))
    {
      if ((paramObject instanceof String))
      {
        parama = com.tencent.mm.plugin.story.h.h.BjR;
        com.tencent.mm.plugin.story.h.h.enI().lu(1L);
        paramObject = (f)new h((String)paramObject, paramc, (byte)0);
        AppMethodBeat.o(119193);
        return paramObject;
      }
    }
    else if ((parama == n.a.AZC) || (parama == n.a.AZB))
    {
      if ((paramObject instanceof String))
      {
        parama = new ArrayList();
        parama.add(paramObject);
        paramObject = com.tencent.mm.plugin.story.h.h.BjR;
        com.tencent.mm.plugin.story.h.h.enI().lu(parama.size());
        paramObject = (f)new g((List)parama, paramString, paramc);
        AppMethodBeat.o(119193);
        return paramObject;
      }
    }
    else if (parama == n.a.AZD)
    {
      parama = new ArrayList();
      if ((paramObject instanceof Collection))
      {
        paramObject = ((Iterable)paramObject).iterator();
        while (paramObject.hasNext())
        {
          localObject = paramObject.next();
          if ((localObject instanceof String)) {
            parama.add(localObject);
          }
        }
        paramObject = com.tencent.mm.plugin.story.h.h.BjR;
        com.tencent.mm.plugin.story.h.h.enI().lu(parama.size());
        paramObject = (f)new g((List)parama, paramString, paramc);
        AppMethodBeat.o(119193);
        return paramObject;
      }
    }
    else if (parama == n.a.AZE)
    {
      parama = new ArrayList();
      if ((paramObject instanceof Collection))
      {
        paramObject = ((Iterable)paramObject).iterator();
        while (paramObject.hasNext())
        {
          paramString = paramObject.next();
          if ((paramString instanceof String)) {
            parama.add(paramString);
          }
        }
        paramObject = com.tencent.mm.plugin.story.f.j.BbE;
        paramObject = (f)new i(j.b.dXj(), (List)parama, paramc);
        AppMethodBeat.o(119193);
        return paramObject;
      }
    }
    paramObject = (Throwable)new RuntimeException("Cannot handler dataSeed ".concat(String.valueOf(paramObject)));
    AppMethodBeat.o(119193);
    throw paramObject;
  }
  
  public static int ena()
  {
    return BgL;
  }
  
  public static int enb()
  {
    return BgM;
  }
  
  public static int enc()
  {
    return BgN;
  }
  
  public static int ene()
  {
    return BgO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.d
 * JD-Core Version:    0.7.0.1
 */