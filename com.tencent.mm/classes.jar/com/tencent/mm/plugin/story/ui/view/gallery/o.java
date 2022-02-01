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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgrPreLoad;", "", "()V", "TAG", "", "pool", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "kotlin.jvm.PlatformType", "", "clean", "", "get", "preload", "", "username", "plugin-story_release"})
public final class o
{
  private static List<n> yBs;
  public static final o yBt;
  
  static
  {
    AppMethodBeat.i(120668);
    yBt = new o();
    yBs = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(120668);
  }
  
  public static boolean asg(String paramString)
  {
    AppMethodBeat.i(120665);
    d.g.b.k.h(paramString, "username");
    ad.i("MicroMsg.StoryVideoViewMgrPreLoad", "preLoad " + paramString + " pool " + yBs.size());
    if (yBs.size() > 0)
    {
      localObject1 = com.tencent.mm.plugin.story.f.k.yfq;
      paramString = com.tencent.mm.plugin.story.f.k.arp(paramString);
      if (paramString.isValid())
      {
        localObject1 = h.yhK;
        paramString = h.a.a(paramString);
        localObject1 = yBs;
        d.g.b.k.g(localObject1, "pool");
        localObject1 = (n)j.iz((List)localObject1);
        if (localObject1 != null) {
          ((n)localObject1).a(paramString.yhF, false);
        }
      }
      AppMethodBeat.o(120665);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.story.f.k.yfq;
    paramString = com.tencent.mm.plugin.story.f.k.arp(paramString);
    localObject1 = c.ymT;
    c.tJ(paramString.field_syncId);
    localObject1 = b.ymz;
    b.tJ(paramString.field_syncId);
    if (paramString.dKz() > 0L)
    {
      localObject1 = b.ymz;
      b.dIN();
    }
    if (paramString.isValid())
    {
      localObject1 = h.yhK;
      localObject1 = h.a.a(paramString);
      Object localObject2 = b.ymz;
      d.g.b.k.h(localObject1, "galleryItem");
      d.g.b.k.h(paramString, "extinfo");
      b.ymq = (h)localObject1;
      b.ymm = new b.a(paramString.getUserName(), b.b.ymH);
      if (paramString.dKz() > 0L)
      {
        b.n(b.oJZ, 4L, 1L);
        localObject2 = b.ymm;
        if (localObject2 != null)
        {
          ((b.a)localObject2).nEj = false;
          ((b.a)localObject2).ymE = bt.eGO();
        }
      }
      for (;;)
      {
        if (((h)localObject1).yhF != null)
        {
          if (paramString.dKB())
          {
            b.n(b.oJZ, 140L, 1L);
            if (paramString.dKz() > 0L) {
              b.n(b.oJZ, 142L, 1L);
            }
          }
          if (b.d(((h)localObject1).yhF) == 1)
          {
            b.n(b.oJZ, 5L, 1L);
            if (paramString.dKB()) {
              b.n(b.oJZ, 141L, 1L);
            }
          }
        }
        paramString = new n();
        if (paramString.yBe == null)
        {
          localObject2 = aj.getContext();
          d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
          paramString.gh((Context)localObject2);
        }
        paramString.setMute(true);
        paramString.a(((h)localObject1).yhF, false);
        paramString.EN();
        yBs.add(paramString);
        AppMethodBeat.o(120665);
        return true;
        localObject2 = b.ymm;
        if (localObject2 != null)
        {
          ((b.a)localObject2).nEj = true;
          ((b.a)localObject2).ymE = bt.eGO();
        }
      }
    }
    AppMethodBeat.o(120665);
    return false;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(120667);
    ad.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad clean " + yBs.size());
    Object localObject = yBs;
    d.g.b.k.g(localObject, "pool");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoView localStoryVideoView = ((n)((Iterator)localObject).next()).yBe;
      if (localStoryVideoView != null) {
        localStoryVideoView.stop();
      }
    }
    yBs.clear();
    AppMethodBeat.o(120667);
  }
  
  public static n dLN()
  {
    AppMethodBeat.i(120666);
    ad.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad get " + yBs.size());
    Object localObject = yBs;
    d.g.b.k.g(localObject, "pool");
    localObject = (n)j.iz((List)localObject);
    if (localObject != null) {
      yBs.remove(localObject);
    }
    AppMethodBeat.o(120666);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.o
 * JD-Core Version:    0.7.0.1
 */