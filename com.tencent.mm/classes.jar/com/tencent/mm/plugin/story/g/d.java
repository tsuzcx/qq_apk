package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.api.p;
import com.tencent.mm.plugin.story.f.d.a;
import com.tencent.mm.plugin.story.f.j.b;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/presenter/GalleryPresenterFactory;", "", "()V", "QUERY_CONDITION_ALL_UNREAD", "", "getQUERY_CONDITION_ALL_UNREAD", "()I", "QUERY_CONDITION_BIG_MOUTH", "getQUERY_CONDITION_BIG_MOUTH", "QUERY_CONDITION_DEFAULT", "getQUERY_CONDITION_DEFAULT", "QUERY_CONDITION_WITH_FILTER", "getQUERY_CONDITION_WITH_FILTER", "getPresenter", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "dataSeed", "groupCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "", "plugin-story_release"})
public final class d
{
  private static final int zxo = 0;
  private static final int zxp = 1;
  private static final int zxq = 2;
  private static final int zxr = 4;
  public static final d zxs;
  
  static
  {
    AppMethodBeat.i(119194);
    zxs = new d();
    zxp = 1;
    zxq = 2;
    zxr = 4;
    AppMethodBeat.o(119194);
  }
  
  public static f a(Object paramObject, c paramc, n.a parama, String paramString)
  {
    AppMethodBeat.i(119193);
    k.h(paramc, "groupCallback");
    k.h(parama, "galleryType");
    Object localObject;
    if ((paramObject instanceof p))
    {
      paramString = com.tencent.mm.plugin.story.f.d.f.a((p)paramObject);
      parama = (p)paramObject;
      k.h(parama, "dataSeed");
      if ((parama instanceof a)) {
        parama = ((a)parama).zuu;
      }
      int i;
      for (;;)
      {
        i = ((p)paramObject).zqn;
        localObject = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.dXK().jx(paramString.size());
        if (!(paramObject instanceof com.tencent.mm.plugin.story.f.d.c)) {
          break label192;
        }
        if (!((com.tencent.mm.plugin.story.f.d.c)paramObject).xvs) {
          break;
        }
        paramObject = (f)new i(((com.tencent.mm.plugin.story.f.d.c)paramObject).username, paramString, paramc, parama, i);
        AppMethodBeat.o(119193);
        return paramObject;
        if ((parama instanceof com.tencent.mm.plugin.story.f.d.c)) {
          parama = ((com.tencent.mm.plugin.story.f.d.c)parama).zuu;
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
    if (d.a.j.listOf(new n.a[] { n.a.zqd, n.a.zqc }).contains(parama))
    {
      if ((paramObject instanceof String))
      {
        parama = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.dXK().jx(1L);
        paramObject = (f)new h((String)paramObject, paramc, (byte)0);
        AppMethodBeat.o(119193);
        return paramObject;
      }
    }
    else if ((parama == n.a.zqf) || (parama == n.a.zqe))
    {
      if ((paramObject instanceof String))
      {
        parama = new ArrayList();
        parama.add(paramObject);
        paramObject = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.dXK().jx(parama.size());
        paramObject = (f)new g((List)parama, paramString, paramc);
        AppMethodBeat.o(119193);
        return paramObject;
      }
    }
    else if (parama == n.a.zqg)
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
        paramObject = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.dXK().jx(parama.size());
        paramObject = (f)new g((List)parama, paramString, paramc);
        AppMethodBeat.o(119193);
        return paramObject;
      }
    }
    else if (parama == n.a.zqh)
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
        paramObject = com.tencent.mm.plugin.story.f.j.zsh;
        paramObject = (f)new i(j.b.dHx(), (List)parama, paramc);
        AppMethodBeat.o(119193);
        return paramObject;
      }
    }
    paramObject = (Throwable)new RuntimeException("Cannot handler dataSeed ".concat(String.valueOf(paramObject)));
    AppMethodBeat.o(119193);
    throw paramObject;
  }
  
  public static int dXd()
  {
    return zxo;
  }
  
  public static int dXe()
  {
    return zxp;
  }
  
  public static int dXf()
  {
    return zxq;
  }
  
  public static int dXg()
  {
    return zxr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.d
 * JD-Core Version:    0.7.0.1
 */