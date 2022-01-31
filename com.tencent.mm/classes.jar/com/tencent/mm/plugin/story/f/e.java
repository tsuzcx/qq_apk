package com.tencent.mm.plugin.story.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.plugin.story.api.m.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.model.d.a;
import com.tencent.mm.plugin.story.model.j.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/GalleryPresenterFactory;", "", "()V", "getPresenter", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "dataSeed", "groupCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "", "isForSns", "", "plugin-story_release"})
public final class e
{
  public static final e sBF;
  
  static
  {
    AppMethodBeat.i(109577);
    sBF = new e();
    AppMethodBeat.o(109577);
  }
  
  public static g a(Object paramObject, d paramd, m.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109576);
    a.f.b.j.q(paramd, "groupCallback");
    a.f.b.j.q(parama, "galleryType");
    Object localObject;
    if ((paramObject instanceof o))
    {
      paramString = com.tencent.mm.plugin.story.model.d.e.a((o)paramObject);
      parama = (o)paramObject;
      a.f.b.j.q(parama, "dataSeed");
      if ((parama instanceof a)) {
        parama = ((a)parama).sym;
      }
      for (;;)
      {
        localObject = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDo().cP(paramString.size());
        if (!(paramObject instanceof com.tencent.mm.plugin.story.model.d.c)) {
          break label181;
        }
        if (!((com.tencent.mm.plugin.story.model.d.c)paramObject).qLh) {
          break;
        }
        paramObject = (g)new j(((com.tencent.mm.plugin.story.model.d.c)paramObject).username, paramString, paramd, parama);
        AppMethodBeat.o(109576);
        return paramObject;
        if ((parama instanceof com.tencent.mm.plugin.story.model.d.c)) {
          parama = ((com.tencent.mm.plugin.story.model.d.c)parama).sym;
        } else {
          parama = (Map)new HashMap();
        }
      }
      paramObject = (g)new c(((com.tencent.mm.plugin.story.model.d.c)paramObject).username, paramString, paramd);
      AppMethodBeat.o(109576);
      return paramObject;
      label181:
      paramObject = (g)new h(paramString, null, paramd, paramBoolean, parama);
      AppMethodBeat.o(109576);
      return paramObject;
    }
    if (a.a.j.listOf(new m.a[] { m.a.sqQ, m.a.sqP }).contains(parama))
    {
      if ((paramObject instanceof String))
      {
        parama = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDo().cP(1L);
        paramObject = (g)new i((String)paramObject, paramd);
        AppMethodBeat.o(109576);
        return paramObject;
      }
    }
    else if ((parama == m.a.sqS) || (parama == m.a.sqR))
    {
      if ((paramObject instanceof String))
      {
        parama = new ArrayList();
        parama.add(paramObject);
        paramObject = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDo().cP(parama.size());
        paramObject = (g)new h((List)parama, paramString, paramd, paramBoolean);
        AppMethodBeat.o(109576);
        return paramObject;
      }
    }
    else if (parama == m.a.sqT)
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
        paramObject = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDo().cP(parama.size());
        paramObject = (g)new h((List)parama, paramString, paramd, paramBoolean);
        AppMethodBeat.o(109576);
        return paramObject;
      }
    }
    else if (parama == m.a.sqU)
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
        paramObject = com.tencent.mm.plugin.story.model.j.svi;
        paramObject = (g)new j(j.b.coK(), (List)parama, paramd);
        AppMethodBeat.o(109576);
        return paramObject;
      }
    }
    paramObject = (Throwable)new RuntimeException("Cannot handler dataSeed ".concat(String.valueOf(paramObject)));
    AppMethodBeat.o(109576);
    throw paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.e
 * JD-Core Version:    0.7.0.1
 */