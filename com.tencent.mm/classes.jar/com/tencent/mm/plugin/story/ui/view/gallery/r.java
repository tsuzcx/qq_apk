package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.b;
import com.tencent.mm.plugin.story.g.b.a;
import com.tencent.mm.plugin.story.g.b.b;
import com.tencent.mm.plugin.story.g.c;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.d.g.a;
import com.tencent.mm.plugin.story.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgrPreLoad;", "", "()V", "TAG", "", "pool", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "kotlin.jvm.PlatformType", "", "clean", "", "get", "preload", "", "username", "plugin-story_release"})
public final class r
{
  private static List<q> sVI;
  public static final r sVJ;
  
  static
  {
    AppMethodBeat.i(111005);
    sVJ = new r();
    sVI = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(111005);
  }
  
  public static boolean adM(String paramString)
  {
    AppMethodBeat.i(111002);
    a.f.b.j.q(paramString, "username");
    ab.i("MicroMsg.StoryVideoViewMgrPreLoad", "preLoad " + paramString + " pool " + sVI.size());
    if (sVI.size() > 0)
    {
      localObject1 = k.svr;
      paramString = k.acU(paramString);
      if (paramString.isValid())
      {
        localObject1 = g.syw;
        paramString = g.a.a(paramString);
        localObject1 = sVI;
        a.f.b.j.p(localObject1, "pool");
        localObject1 = (q)a.a.j.fR((List)localObject1);
        if (localObject1 != null) {
          ((q)localObject1).a(paramString.syr, false);
        }
      }
      AppMethodBeat.o(111002);
      return false;
    }
    Object localObject1 = k.svr;
    paramString = k.acU(paramString);
    localObject1 = c.sEl;
    c.mG(paramString.field_syncId);
    localObject1 = b.sDR;
    b.mG(paramString.field_syncId);
    if (paramString.cES() > 0L)
    {
      localObject1 = b.sDR;
      b.cCA();
    }
    if (paramString.isValid())
    {
      localObject1 = g.syw;
      localObject1 = g.a.a(paramString);
      Object localObject2 = b.sDR;
      a.f.b.j.q(localObject1, "galleryItem");
      a.f.b.j.q(paramString, "extinfo");
      b.sDI = (g)localObject1;
      b.sDE = new b.a(paramString.getUserName(), b.b.sDZ);
      if (paramString.cES() > 0L)
      {
        b.k(b.ltw, 4L, 1L);
        localObject2 = b.sDE;
        if (localObject2 != null)
        {
          ((b.a)localObject2).kyS = false;
          ((b.a)localObject2).sDW = bo.aoy();
        }
      }
      for (;;)
      {
        if (((g)localObject1).syr != null)
        {
          if (paramString.cEU())
          {
            b.k(b.ltw, 140L, 1L);
            if (paramString.cES() > 0L) {
              b.k(b.ltw, 142L, 1L);
            }
          }
          if (b.c(((g)localObject1).syr) == 1)
          {
            b.k(b.ltw, 5L, 1L);
            if (paramString.cEU()) {
              b.k(b.ltw, 141L, 1L);
            }
          }
        }
        paramString = new q();
        if (paramString.sVs == null)
        {
          localObject2 = ah.getContext();
          a.f.b.j.p(localObject2, "MMApplicationContext.getContext()");
          paramString.fd((Context)localObject2);
        }
        paramString.setMute(true);
        paramString.a(((g)localObject1).syr, false);
        paramString.cGe();
        sVI.add(paramString);
        AppMethodBeat.o(111002);
        return true;
        localObject2 = b.sDE;
        if (localObject2 != null)
        {
          ((b.a)localObject2).kyS = true;
          ((b.a)localObject2).sDW = bo.aoy();
        }
      }
    }
    AppMethodBeat.o(111002);
    return false;
  }
  
  public static q cGy()
  {
    AppMethodBeat.i(111003);
    ab.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad get " + sVI.size());
    Object localObject = sVI;
    a.f.b.j.p(localObject, "pool");
    localObject = (q)a.a.j.fR((List)localObject);
    if (localObject != null) {
      sVI.remove(localObject);
    }
    AppMethodBeat.o(111003);
    return localObject;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(111004);
    ab.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad clean " + sVI.size());
    Object localObject = sVI;
    a.f.b.j.p(localObject, "pool");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoView localStoryVideoView = ((q)((Iterator)localObject).next()).sVs;
      if (localStoryVideoView != null) {
        localStoryVideoView.stop();
      }
    }
    sVI.clear();
    AppMethodBeat.o(111004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.r
 * JD-Core Version:    0.7.0.1
 */