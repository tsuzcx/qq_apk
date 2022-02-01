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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgrPreLoad;", "", "()V", "TAG", "", "pool", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "kotlin.jvm.PlatformType", "", "clean", "", "get", "preload", "", "username", "plugin-story_release"})
public final class o
{
  private static List<n> FIp;
  public static final o FIq;
  
  static
  {
    AppMethodBeat.i(120668);
    FIq = new o();
    FIp = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(120668);
  }
  
  public static boolean aSH(String paramString)
  {
    AppMethodBeat.i(120665);
    p.h(paramString, "username");
    Log.i("MicroMsg.StoryVideoViewMgrPreLoad", "preLoad " + paramString + " pool " + FIp.size());
    if (FIp.size() > 0)
    {
      localObject1 = k.FmH;
      paramString = k.aRS(paramString);
      if (paramString.isValid())
      {
        localObject1 = h.FoY;
        paramString = h.a.a(paramString);
        localObject1 = FIp;
        p.g(localObject1, "pool");
        localObject1 = (n)j.kt((List)localObject1);
        if (localObject1 != null) {
          ((n)localObject1).a(paramString.FoT, false);
        }
      }
      AppMethodBeat.o(120665);
      return false;
    }
    Object localObject1 = k.FmH;
    paramString = k.aRS(paramString);
    localObject1 = c.Fuf;
    c.Kn(paramString.field_syncId);
    localObject1 = b.FtL;
    b.Kn(paramString.field_syncId);
    if (paramString.fry() > 0L)
    {
      localObject1 = b.FtL;
      b.fpM();
    }
    if (paramString.isValid())
    {
      localObject1 = h.FoY;
      localObject1 = h.a.a(paramString);
      Object localObject2 = b.FtL;
      p.h(localObject1, "galleryItem");
      p.h(paramString, "extinfo");
      b.FtC = (h)localObject1;
      b.Fty = new b.a(paramString.getUserName(), b.b.FtT);
      if (paramString.fry() > 0L)
      {
        b.e(b.oIi, 4L, 1L);
        localObject2 = b.Fty;
        if (localObject2 != null)
        {
          ((b.a)localObject2).qeT = false;
          ((b.a)localObject2).FtQ = Util.nowMilliSecond();
        }
      }
      for (;;)
      {
        if (((h)localObject1).FoT != null)
        {
          if (paramString.frA())
          {
            b.e(b.oIi, 140L, 1L);
            if (paramString.fry() > 0L) {
              b.e(b.oIi, 142L, 1L);
            }
          }
          if (b.d(((h)localObject1).FoT) == 1)
          {
            b.e(b.oIi, 5L, 1L);
            if (paramString.frA()) {
              b.e(b.oIi, 141L, 1L);
            }
          }
        }
        paramString = new n();
        if (paramString.FIc == null)
        {
          localObject2 = MMApplicationContext.getContext();
          p.g(localObject2, "MMApplicationContext.getContext()");
          paramString.hm((Context)localObject2);
        }
        paramString.setMute(true);
        paramString.a(((h)localObject1).FoT, false);
        paramString.PF();
        FIp.add(paramString);
        AppMethodBeat.o(120665);
        return true;
        localObject2 = b.Fty;
        if (localObject2 != null)
        {
          ((b.a)localObject2).qeT = true;
          ((b.a)localObject2).FtQ = Util.nowMilliSecond();
        }
      }
    }
    AppMethodBeat.o(120665);
    return false;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(120667);
    Log.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad clean " + FIp.size());
    Object localObject = FIp;
    p.g(localObject, "pool");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoView localStoryVideoView = ((n)((Iterator)localObject).next()).FIc;
      if (localStoryVideoView != null) {
        localStoryVideoView.stop();
      }
    }
    FIp.clear();
    AppMethodBeat.o(120667);
  }
  
  public static n fsK()
  {
    AppMethodBeat.i(120666);
    Log.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad get " + FIp.size());
    Object localObject = FIp;
    p.g(localObject, "pool");
    localObject = (n)j.kt((List)localObject);
    if (localObject != null) {
      FIp.remove(localObject);
    }
    AppMethodBeat.o(120666);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.o
 * JD-Core Version:    0.7.0.1
 */