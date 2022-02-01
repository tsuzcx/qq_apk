package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.d.h.a;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.h.b;
import com.tencent.mm.plugin.story.h.b.a;
import com.tencent.mm.plugin.story.h.b.b;
import com.tencent.mm.plugin.story.h.c;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgrPreLoad;", "", "()V", "TAG", "", "pool", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "kotlin.jvm.PlatformType", "", "clean", "", "get", "preload", "", "username", "plugin-story_release"})
public final class o
{
  private static List<n> Mco;
  public static final o Mcp;
  
  static
  {
    AppMethodBeat.i(120668);
    Mcp = new o();
    Mco = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(120668);
  }
  
  public static boolean bdL(String paramString)
  {
    AppMethodBeat.i(120665);
    p.k(paramString, "username");
    Log.i("MicroMsg.StoryVideoViewMgrPreLoad", "preLoad " + paramString + " pool " + Mco.size());
    if (Mco.size() > 0)
    {
      localObject1 = k.LGJ;
      paramString = k.bcW(paramString);
      if (paramString.isValid())
      {
        localObject1 = h.LJa;
        paramString = h.a.a(paramString);
        localObject1 = Mco;
        p.j(localObject1, "pool");
        localObject1 = (n)j.lp((List)localObject1);
        if (localObject1 != null) {
          ((n)localObject1).a(paramString.LIV, false);
        }
      }
      AppMethodBeat.o(120665);
      return false;
    }
    Object localObject1 = k.LGJ;
    paramString = k.bcW(paramString);
    localObject1 = c.LOg;
    c.RH(paramString.field_syncId);
    localObject1 = b.LNM;
    b.RH(paramString.field_syncId);
    if (paramString.gfU() > 0L)
    {
      localObject1 = b.LNM;
      b.geg();
    }
    if (paramString.isValid())
    {
      localObject1 = h.LJa;
      localObject1 = h.a.a(paramString);
      Object localObject2 = b.LNM;
      p.k(localObject1, "galleryItem");
      p.k(paramString, "extinfo");
      b.LNE = (h)localObject1;
      b.LNB = new b.a(paramString.getUserName(), b.b.LNU);
      if (paramString.gfU() > 0L)
      {
        b.f(b.rJY, 4L, 1L);
        localObject2 = b.LNB;
        if (localObject2 != null)
        {
          ((b.a)localObject2).tAQ = false;
          ((b.a)localObject2).LNR = Util.nowMilliSecond();
        }
      }
      for (;;)
      {
        if (((h)localObject1).LIV != null)
        {
          if (paramString.gfW())
          {
            b.f(b.rJY, 140L, 1L);
            if (paramString.gfU() > 0L) {
              b.f(b.rJY, 142L, 1L);
            }
          }
          if (b.d(((h)localObject1).LIV) == 1)
          {
            b.f(b.rJY, 5L, 1L);
            if (paramString.gfW()) {
              b.f(b.rJY, 141L, 1L);
            }
          }
        }
        paramString = new n();
        if (paramString.Mcc == null)
        {
          localObject2 = MMApplicationContext.getContext();
          p.j(localObject2, "MMApplicationContext.getContext()");
          paramString.in((Context)localObject2);
        }
        paramString.setMute(true);
        paramString.a(((h)localObject1).LIV, false);
        paramString.Tf();
        Mco.add(paramString);
        AppMethodBeat.o(120665);
        return true;
        localObject2 = b.LNB;
        if (localObject2 != null)
        {
          ((b.a)localObject2).tAQ = true;
          ((b.a)localObject2).LNR = Util.nowMilliSecond();
        }
      }
    }
    AppMethodBeat.o(120665);
    return false;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(120667);
    Log.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad clean " + Mco.size());
    Object localObject = Mco;
    p.j(localObject, "pool");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoView localStoryVideoView = ((n)((Iterator)localObject).next()).Mcc;
      if (localStoryVideoView != null) {
        localStoryVideoView.stop();
      }
    }
    Mco.clear();
    AppMethodBeat.o(120667);
  }
  
  public static n ghi()
  {
    AppMethodBeat.i(120666);
    Log.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad get " + Mco.size());
    Object localObject = Mco;
    p.j(localObject, "pool");
    localObject = (n)j.lp((List)localObject);
    if (localObject != null) {
      Mco.remove(localObject);
    }
    AppMethodBeat.o(120666);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.o
 * JD-Core Version:    0.7.0.1
 */