package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.d.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/GalleryPresenterFactory;", "", "()V", "QUERY_CONDITION_ALL_UNREAD", "", "getQUERY_CONDITION_ALL_UNREAD", "()I", "QUERY_CONDITION_BIG_MOUTH", "getQUERY_CONDITION_BIG_MOUTH", "QUERY_CONDITION_DEFAULT", "getQUERY_CONDITION_DEFAULT", "QUERY_CONDITION_WITH_FILTER", "getQUERY_CONDITION_WITH_FILTER", "getPresenter", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "dataSeed", "groupCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d SoN;
  private static final int SoO = 0;
  private static final int SoP;
  private static final int SoQ;
  private static final int SoR;
  
  static
  {
    AppMethodBeat.i(119194);
    SoN = new d();
    SoP = 1;
    SoQ = 2;
    SoR = 4;
    AppMethodBeat.o(119194);
  }
  
  public static f a(Object paramObject, c paramc, n.a parama, String paramString)
  {
    AppMethodBeat.i(119193);
    s.u(paramc, "groupCallback");
    s.u(parama, "galleryType");
    int i;
    Object localObject;
    if ((paramObject instanceof com.tencent.mm.plugin.story.api.p))
    {
      paramString = com.tencent.mm.plugin.story.model.d.f.a((com.tencent.mm.plugin.story.api.p)paramObject);
      parama = (com.tencent.mm.plugin.story.api.p)paramObject;
      s.u(parama, "dataSeed");
      if ((parama instanceof a))
      {
        parama = ((a)parama).Smd;
        i = ((com.tencent.mm.plugin.story.api.p)paramObject).Siv;
        localObject = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.hxW().jkL = paramString.size();
        localObject = (com.tencent.mm.plugin.story.api.p)paramObject;
        if (!(localObject instanceof com.tencent.mm.plugin.story.model.d.c)) {
          break label193;
        }
        if (!((com.tencent.mm.plugin.story.model.d.c)paramObject).Pxk) {
          break label173;
        }
      }
      label173:
      for (paramObject = new i(((com.tencent.mm.plugin.story.model.d.c)paramObject).username, paramString, paramc, parama, i);; paramObject = new b(((com.tencent.mm.plugin.story.model.d.c)paramObject).username, paramString, paramc))
      {
        paramObject = (f)paramObject;
        AppMethodBeat.o(119193);
        return paramObject;
        if ((parama instanceof com.tencent.mm.plugin.story.model.d.c))
        {
          parama = ((com.tencent.mm.plugin.story.model.d.c)parama).Smd;
          break;
        }
        parama = (Map)new HashMap();
        break;
      }
      label193:
      if ((localObject instanceof com.tencent.mm.plugin.story.model.d.d))
      {
        paramObject = (f)new g(paramString, null, paramc, parama, i);
        AppMethodBeat.o(119193);
        return paramObject;
      }
      paramObject = (f)new g(paramString, null, paramc, parama, i);
      AppMethodBeat.o(119193);
      return paramObject;
    }
    int j = a.$EnumSwitchMapping$0[parama.ordinal()];
    if (kotlin.a.p.listOf(new n.a[] { n.a.Sil, n.a.Sik }).contains(parama))
    {
      if ((paramObject instanceof String))
      {
        parama = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.hxW().jkL = 1L;
        paramObject = (f)new h((String)paramObject, paramc, (byte)0);
        AppMethodBeat.o(119193);
        return paramObject;
      }
    }
    else
    {
      if (j == 1) {
        i = 1;
      }
      while (i != 0)
      {
        if (!(paramObject instanceof String)) {
          break label619;
        }
        parama = new ArrayList();
        parama.add(paramObject);
        paramObject = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.hxW().jkL = parama.size();
        paramObject = (f)new g((List)parama, paramString, paramc);
        AppMethodBeat.o(119193);
        return paramObject;
        if (j == 2) {
          i = 1;
        } else {
          i = 0;
        }
      }
      if (j == 3)
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
          paramObject = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hxW().jkL = parama.size();
          paramObject = (f)new g((List)parama, paramString, paramc);
          AppMethodBeat.o(119193);
          return paramObject;
        }
      }
      else if (j == 4)
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
          paramObject = StoryCore.SjP;
          paramObject = (f)new i(StoryCore.b.hgg(), (List)parama, paramc);
          AppMethodBeat.o(119193);
          return paramObject;
        }
      }
    }
    label619:
    paramObject = new RuntimeException(s.X("Cannot handler dataSeed ", paramObject));
    AppMethodBeat.o(119193);
    throw paramObject;
  }
  
  public static int hxp()
  {
    return SoO;
  }
  
  public static int hxq()
  {
    return SoP;
  }
  
  public static int hxr()
  {
    return SoQ;
  }
  
  public static int hxs()
  {
    return SoR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d
 * JD-Core Version:    0.7.0.1
 */