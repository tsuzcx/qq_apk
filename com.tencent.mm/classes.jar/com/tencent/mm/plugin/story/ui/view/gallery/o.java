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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgrPreLoad;", "", "()V", "TAG", "", "pool", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "kotlin.jvm.PlatformType", "", "clean", "", "get", "preload", "", "username", "plugin-story_release"})
public final class o
{
  private static List<n> Bgh;
  public static final o Bgi;
  
  static
  {
    AppMethodBeat.i(120668);
    Bgi = new o();
    Bgh = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(120668);
  }
  
  public static boolean aCt(String paramString)
  {
    AppMethodBeat.i(120665);
    p.h(paramString, "username");
    ad.i("MicroMsg.StoryVideoViewMgrPreLoad", "preLoad " + paramString + " pool " + Bgh.size());
    if (Bgh.size() > 0)
    {
      localObject1 = k.AKk;
      paramString = k.aBD(paramString);
      if (paramString.isValid())
      {
        localObject1 = h.AMF;
        paramString = h.a.a(paramString);
        localObject1 = Bgh;
        p.g(localObject1, "pool");
        localObject1 = (n)j.jd((List)localObject1);
        if (localObject1 != null) {
          ((n)localObject1).a(paramString.AMA, false);
        }
      }
      AppMethodBeat.o(120665);
      return false;
    }
    Object localObject1 = k.AKk;
    paramString = k.aBD(paramString);
    localObject1 = c.ARR;
    c.AK(paramString.field_syncId);
    localObject1 = b.ARx;
    b.AK(paramString.field_syncId);
    if (paramString.elp() > 0L)
    {
      localObject1 = b.ARx;
      b.ejD();
    }
    if (paramString.isValid())
    {
      localObject1 = h.AMF;
      localObject1 = h.a.a(paramString);
      Object localObject2 = b.ARx;
      p.h(localObject1, "galleryItem");
      p.h(paramString, "extinfo");
      b.ARo = (h)localObject1;
      b.ARk = new b.a(paramString.getUserName(), b.b.ARF);
      if (paramString.elp() > 0L)
      {
        b.e(b.pQX, 4L, 1L);
        localObject2 = b.ARk;
        if (localObject2 != null)
        {
          ((b.a)localObject2).oKD = false;
          ((b.a)localObject2).ARC = bt.flT();
        }
      }
      for (;;)
      {
        if (((h)localObject1).AMA != null)
        {
          if (paramString.elr())
          {
            b.e(b.pQX, 140L, 1L);
            if (paramString.elp() > 0L) {
              b.e(b.pQX, 142L, 1L);
            }
          }
          if (b.d(((h)localObject1).AMA) == 1)
          {
            b.e(b.pQX, 5L, 1L);
            if (paramString.elr()) {
              b.e(b.pQX, 141L, 1L);
            }
          }
        }
        paramString = new n();
        if (paramString.BfT == null)
        {
          localObject2 = aj.getContext();
          p.g(localObject2, "MMApplicationContext.getContext()");
          paramString.gw((Context)localObject2);
        }
        paramString.setMute(true);
        paramString.a(((h)localObject1).AMA, false);
        paramString.FQ();
        Bgh.add(paramString);
        AppMethodBeat.o(120665);
        return true;
        localObject2 = b.ARk;
        if (localObject2 != null)
        {
          ((b.a)localObject2).oKD = true;
          ((b.a)localObject2).ARC = bt.flT();
        }
      }
    }
    AppMethodBeat.o(120665);
    return false;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(120667);
    ad.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad clean " + Bgh.size());
    Object localObject = Bgh;
    p.g(localObject, "pool");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoView localStoryVideoView = ((n)((Iterator)localObject).next()).BfT;
      if (localStoryVideoView != null) {
        localStoryVideoView.stop();
      }
    }
    Bgh.clear();
    AppMethodBeat.o(120667);
  }
  
  public static n emC()
  {
    AppMethodBeat.i(120666);
    ad.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad get " + Bgh.size());
    Object localObject = Bgh;
    p.g(localObject, "pool");
    localObject = (n)j.jd((List)localObject);
    if (localObject != null) {
      Bgh.remove(localObject);
    }
    AppMethodBeat.o(120666);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.o
 * JD-Core Version:    0.7.0.1
 */