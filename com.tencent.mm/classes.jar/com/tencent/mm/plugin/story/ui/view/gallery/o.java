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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgrPreLoad;", "", "()V", "TAG", "", "pool", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "kotlin.jvm.PlatformType", "", "clean", "", "get", "preload", "", "username", "plugin-story_release"})
public final class o
{
  private static List<n> BxF;
  public static final o BxG;
  
  static
  {
    AppMethodBeat.i(120668);
    BxG = new o();
    BxF = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(120668);
  }
  
  public static boolean aDM(String paramString)
  {
    AppMethodBeat.i(120665);
    p.h(paramString, "username");
    ae.i("MicroMsg.StoryVideoViewMgrPreLoad", "preLoad " + paramString + " pool " + BxF.size());
    if (BxF.size() > 0)
    {
      localObject1 = k.BbN;
      paramString = k.aCW(paramString);
      if (paramString.isValid())
      {
        localObject1 = h.Beh;
        paramString = h.a.a(paramString);
        localObject1 = BxF;
        p.g(localObject1, "pool");
        localObject1 = (n)j.jm((List)localObject1);
        if (localObject1 != null) {
          ((n)localObject1).a(paramString.Bec, false);
        }
      }
      AppMethodBeat.o(120665);
      return false;
    }
    Object localObject1 = k.BbN;
    paramString = k.aCW(paramString);
    localObject1 = c.Bjp;
    c.Bi(paramString.field_syncId);
    localObject1 = b.BiV;
    b.Bi(paramString.field_syncId);
    if (paramString.eoY() > 0L)
    {
      localObject1 = b.BiV;
      b.enm();
    }
    if (paramString.isValid())
    {
      localObject1 = h.Beh;
      localObject1 = h.a.a(paramString);
      Object localObject2 = b.BiV;
      p.h(localObject1, "galleryItem");
      p.h(paramString, "extinfo");
      b.BiM = (h)localObject1;
      b.BiI = new b.a(paramString.getUserName(), b.b.Bjd);
      if (paramString.eoY() > 0L)
      {
        b.e(b.pXC, 4L, 1L);
        localObject2 = b.BiI;
        if (localObject2 != null)
        {
          ((b.a)localObject2).oRf = false;
          ((b.a)localObject2).Bja = bu.fpO();
        }
      }
      for (;;)
      {
        if (((h)localObject1).Bec != null)
        {
          if (paramString.epa())
          {
            b.e(b.pXC, 140L, 1L);
            if (paramString.eoY() > 0L) {
              b.e(b.pXC, 142L, 1L);
            }
          }
          if (b.d(((h)localObject1).Bec) == 1)
          {
            b.e(b.pXC, 5L, 1L);
            if (paramString.epa()) {
              b.e(b.pXC, 141L, 1L);
            }
          }
        }
        paramString = new n();
        if (paramString.Bxr == null)
        {
          localObject2 = ak.getContext();
          p.g(localObject2, "MMApplicationContext.getContext()");
          paramString.gB((Context)localObject2);
        }
        paramString.setMute(true);
        paramString.a(((h)localObject1).Bec, false);
        paramString.FW();
        BxF.add(paramString);
        AppMethodBeat.o(120665);
        return true;
        localObject2 = b.BiI;
        if (localObject2 != null)
        {
          ((b.a)localObject2).oRf = true;
          ((b.a)localObject2).Bja = bu.fpO();
        }
      }
    }
    AppMethodBeat.o(120665);
    return false;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(120667);
    ae.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad clean " + BxF.size());
    Object localObject = BxF;
    p.g(localObject, "pool");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoView localStoryVideoView = ((n)((Iterator)localObject).next()).Bxr;
      if (localStoryVideoView != null) {
        localStoryVideoView.stop();
      }
    }
    BxF.clear();
    AppMethodBeat.o(120667);
  }
  
  public static n eql()
  {
    AppMethodBeat.i(120666);
    ae.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad get " + BxF.size());
    Object localObject = BxF;
    p.g(localObject, "pool");
    localObject = (n)j.jm((List)localObject);
    if (localObject != null) {
      BxF.remove(localObject);
    }
    AppMethodBeat.o(120666);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.o
 * JD-Core Version:    0.7.0.1
 */