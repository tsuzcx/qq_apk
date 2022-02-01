package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.b;
import com.tencent.mm.plugin.story.g.b.a;
import com.tencent.mm.plugin.story.g.b.b;
import com.tencent.mm.plugin.story.g.c;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.model.d.h;
import com.tencent.mm.plugin.story.model.d.h.a;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgrPreLoad;", "", "()V", "TAG", "", "pool", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "kotlin.jvm.PlatformType", "", "clean", "", "get", "preload", "", "username", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l SDE;
  private static List<k> SDF;
  
  static
  {
    AppMethodBeat.i(120668);
    SDE = new l();
    SDF = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(120668);
  }
  
  public static boolean bcx(String paramString)
  {
    AppMethodBeat.i(120665);
    s.u(paramString, "username");
    Log.i("MicroMsg.StoryVideoViewMgrPreLoad", "preLoad " + paramString + " pool " + SDF.size());
    if (SDF.size() > 0)
    {
      localObject1 = j.Skm;
      paramString = j.bbJ(paramString);
      if (paramString.isValid())
      {
        localObject1 = h.Smn;
        paramString = h.a.a(paramString);
        localObject1 = SDF;
        s.s(localObject1, "pool");
        localObject1 = (k)p.oL((List)localObject1);
        if (localObject1 != null) {
          ((k)localObject1).a(paramString.Smr, false);
        }
      }
      AppMethodBeat.o(120665);
      return false;
    }
    Object localObject1 = j.Skm;
    paramString = j.bbJ(paramString);
    localObject1 = c.SqL;
    c.vQ(paramString.field_syncId);
    localObject1 = b.Sqn;
    b.vQ(paramString.field_syncId);
    if (paramString.hzl() > 0L)
    {
      localObject1 = b.Sqn;
      b.hxz();
    }
    if (paramString.isValid())
    {
      localObject1 = h.Smn;
      localObject1 = h.a.a(paramString);
      Object localObject2 = b.Sqn;
      s.u(localObject1, "galleryItem");
      s.u(paramString, "extinfo");
      b.Sqt = (h)localObject1;
      b.Sqq = new b.a(paramString.getUserName(), b.b.SqI);
      if (paramString.hzl() > 0L)
      {
        b.q(b.ID, 4L, 1L);
        localObject2 = b.Sqq;
        if (localObject2 != null)
        {
          ((b.a)localObject2).wFp = false;
          ((b.a)localObject2).SqG = Util.nowMilliSecond();
        }
      }
      for (;;)
      {
        if (((h)localObject1).Smr != null)
        {
          if (paramString.hzn())
          {
            b.q(b.ID, 140L, 1L);
            if (paramString.hzl() > 0L) {
              b.q(b.ID, 142L, 1L);
            }
          }
          if (b.d(((h)localObject1).Smr) == 1)
          {
            b.q(b.ID, 5L, 1L);
            if (paramString.hzn()) {
              b.q(b.ID, 141L, 1L);
            }
          }
        }
        paramString = new k();
        if (paramString.SDp == null)
        {
          localObject2 = MMApplicationContext.getContext();
          s.s(localObject2, "getContext()");
          paramString.kd((Context)localObject2);
        }
        paramString.setMute(true);
        paramString.a(((h)localObject1).Smr, false);
        paramString.atK();
        SDF.add(paramString);
        AppMethodBeat.o(120665);
        return true;
        localObject2 = b.Sqq;
        if (localObject2 != null)
        {
          ((b.a)localObject2).wFp = true;
          ((b.a)localObject2).SqG = Util.nowMilliSecond();
        }
      }
    }
    AppMethodBeat.o(120665);
    return false;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(120667);
    Log.i("MicroMsg.StoryVideoViewMgrPreLoad", s.X("StoryVideoViewMgrPreLoad clean ", Integer.valueOf(SDF.size())));
    Object localObject = SDF;
    s.s(localObject, "pool");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoView localStoryVideoView = ((k)((Iterator)localObject).next()).SDp;
      if (localStoryVideoView != null) {
        localStoryVideoView.stop();
      }
    }
    SDF.clear();
    AppMethodBeat.o(120667);
  }
  
  public static k hAB()
  {
    AppMethodBeat.i(120666);
    Log.i("MicroMsg.StoryVideoViewMgrPreLoad", s.X("StoryVideoViewMgrPreLoad get ", Integer.valueOf(SDF.size())));
    Object localObject = SDF;
    s.s(localObject, "pool");
    localObject = (k)p.oL((List)localObject);
    if (localObject != null) {
      SDF.remove(localObject);
    }
    AppMethodBeat.o(120666);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.l
 * JD-Core Version:    0.7.0.1
 */