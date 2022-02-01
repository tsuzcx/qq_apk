package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.d.h.a;
import com.tencent.mm.plugin.story.h.b;
import com.tencent.mm.plugin.story.h.b.a;
import com.tencent.mm.plugin.story.h.b.b;
import com.tencent.mm.plugin.story.h.c;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgrPreLoad;", "", "()V", "TAG", "", "pool", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "kotlin.jvm.PlatformType", "", "clean", "", "get", "preload", "", "username", "plugin-story_release"})
public final class o
{
  private static List<n> zOG;
  public static final o zOH;
  
  static
  {
    AppMethodBeat.i(120668);
    zOH = new o();
    zOG = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(120668);
  }
  
  public static boolean axp(String paramString)
  {
    AppMethodBeat.i(120665);
    d.g.b.k.h(paramString, "username");
    ac.i("MicroMsg.StoryVideoViewMgrPreLoad", "preLoad " + paramString + " pool " + zOG.size());
    if (zOG.size() > 0)
    {
      localObject1 = com.tencent.mm.plugin.story.f.k.zsq;
      paramString = com.tencent.mm.plugin.story.f.k.awy(paramString);
      if (paramString.isValid())
      {
        localObject1 = h.zuK;
        paramString = h.a.a(paramString);
        localObject1 = zOG;
        d.g.b.k.g(localObject1, "pool");
        localObject1 = (n)j.iP((List)localObject1);
        if (localObject1 != null) {
          ((n)localObject1).a(paramString.zuF, false);
        }
      }
      AppMethodBeat.o(120665);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.story.f.k.zsq;
    paramString = com.tencent.mm.plugin.story.f.k.awy(paramString);
    localObject1 = c.zAs;
    c.ym(paramString.field_syncId);
    localObject1 = b.zzY;
    b.ym(paramString.field_syncId);
    if (paramString.dZa() > 0L)
    {
      localObject1 = b.zzY;
      b.dXo();
    }
    if (paramString.isValid())
    {
      localObject1 = h.zuK;
      localObject1 = h.a.a(paramString);
      Object localObject2 = b.zzY;
      d.g.b.k.h(localObject1, "galleryItem");
      d.g.b.k.h(paramString, "extinfo");
      b.zzP = (h)localObject1;
      b.zzL = new b.a(paramString.getUserName(), b.b.zAg);
      if (paramString.dZa() > 0L)
      {
        b.e(b.pnx, 4L, 1L);
        localObject2 = b.zzL;
        if (localObject2 != null)
        {
          ((b.a)localObject2).ohk = false;
          ((b.a)localObject2).zAd = bs.eWj();
        }
      }
      for (;;)
      {
        if (((h)localObject1).zuF != null)
        {
          if (paramString.dZc())
          {
            b.e(b.pnx, 140L, 1L);
            if (paramString.dZa() > 0L) {
              b.e(b.pnx, 142L, 1L);
            }
          }
          if (b.d(((h)localObject1).zuF) == 1)
          {
            b.e(b.pnx, 5L, 1L);
            if (paramString.dZc()) {
              b.e(b.pnx, 141L, 1L);
            }
          }
        }
        paramString = new n();
        if (paramString.zOs == null)
        {
          localObject2 = ai.getContext();
          d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
          paramString.gt((Context)localObject2);
        }
        paramString.setMute(true);
        paramString.a(((h)localObject1).zuF, false);
        paramString.Er();
        zOG.add(paramString);
        AppMethodBeat.o(120665);
        return true;
        localObject2 = b.zzL;
        if (localObject2 != null)
        {
          ((b.a)localObject2).ohk = true;
          ((b.a)localObject2).zAd = bs.eWj();
        }
      }
    }
    AppMethodBeat.o(120665);
    return false;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(120667);
    ac.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad clean " + zOG.size());
    Object localObject = zOG;
    d.g.b.k.g(localObject, "pool");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoView localStoryVideoView = ((n)((Iterator)localObject).next()).zOs;
      if (localStoryVideoView != null) {
        localStoryVideoView.stop();
      }
    }
    zOG.clear();
    AppMethodBeat.o(120667);
  }
  
  public static n ean()
  {
    AppMethodBeat.i(120666);
    ac.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad get " + zOG.size());
    Object localObject = zOG;
    d.g.b.k.g(localObject, "pool");
    localObject = (n)j.iP((List)localObject);
    if (localObject != null) {
      zOG.remove(localObject);
    }
    AppMethodBeat.o(120666);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.o
 * JD-Core Version:    0.7.0.1
 */