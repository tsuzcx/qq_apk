package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryExtInfoStorageLogic;", "", "()V", "TAG", "", "get", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "userName", "getWithNotify", "", "username", "reportWaitPlayList", "", "srcuserList", "", "scene", "", "set", "info", "updateUserReadId", "storyId", "updateUserSyncId", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "syncId", "postTime", "", "thumb", "videoUrl", "duration", "plugin-story_release"})
public final class k
{
  public static final k FmH;
  private static final String TAG = "MicroMsg.StoryExtInfoStorageLogic";
  
  static
  {
    AppMethodBeat.i(118723);
    FmH = new k();
    TAG = "MicroMsg.StoryExtInfoStorageLogic";
    AppMethodBeat.o(118723);
  }
  
  public static void a(String paramString1, long paramLong1, int paramInt, String paramString2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(118716);
    p.h(paramString1, "username");
    Object localObject = j.Fmy;
    g localg = j.b.fod();
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    p.h(paramString1, "userName");
    p.h(localObject, "thumb");
    p.h(paramString2, "videoUrl");
    paramString3 = localg.aSv(paramString1);
    if (paramString3 == null) {}
    for (paramString1 = localg.aSt(paramString1);; paramString1 = paramString3)
    {
      boolean bool1 = paramString1.frA();
      boolean bool2 = paramString1.isValid();
      paramString3 = f.Fwe;
      if (((Boolean)f.frB().invoke(Long.valueOf(paramString1.field_syncId), Long.valueOf(paramLong1))).booleanValue()) {
        paramString1.field_updateTime = (paramInt * 1000L);
      }
      paramString1.field_syncId = paramLong1;
      if (paramString1.field_preloadStoryId != paramString1.field_syncId)
      {
        paramString1.field_preloadStoryId = 0L;
        paramString1.aSs("");
        paramString1.field_preLoadResource = 0L;
      }
      paramString1.field_storyPostTime = paramInt;
      p.h(localObject, "value");
      paramString1.field_newThumbUrl = ((String)localObject);
      p.h(paramString2, "value");
      paramString1.field_newVideoUrl = paramString2;
      paramString1.field_duration = paramLong2;
      boolean bool3 = localg.b(paramString1);
      boolean bool4 = paramString1.frA();
      boolean bool5 = paramString1.isValid();
      if ((bool3) && (bool2) && (!bool5))
      {
        localg.doNotify("notify_story_invalid", 4, paramString1);
        AppMethodBeat.o(118716);
        return;
      }
      if ((bool3) && (!bool1) && (bool4))
      {
        localg.doNotify("notify_story_unread", 2, paramString1);
        AppMethodBeat.o(118716);
        return;
      }
      if ((bool3) && (bool1) && (!bool4))
      {
        localg.doNotify("notify_story_read", 1, paramString1);
        AppMethodBeat.o(118716);
        return;
      }
      if ((bool3) && (!bool2) && (bool5))
      {
        localg.doNotify("notify_story_valid", 5, paramString1);
        AppMethodBeat.o(118716);
        return;
      }
      if ((bool3) && (bool1) && (bool4)) {
        localg.doNotify("notify_story_unread", 2, paramString1);
      }
      AppMethodBeat.o(118716);
      return;
    }
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.story.i.j paramj)
  {
    AppMethodBeat.i(118718);
    p.h(paramString, "username");
    if (paramj != null)
    {
      eek localeek = paramj.frG();
      if ((localeek != null) && (localeek.NeB.LoV.size() > 0) && (((edt)localeek.NeB.LoV.get(0)).Msz != null) && (((edt)localeek.NeB.LoV.get(0)).Url != null)) {
        a(paramString, paramj.field_storyID, paramj.field_createTime, ((edt)localeek.NeB.LoV.get(0)).Msz, ((edt)localeek.NeB.LoV.get(0)).Url, (((edt)localeek.NeB.LoV.get(0)).Ned * 1000.0F));
      }
      AppMethodBeat.o(118718);
      return;
    }
    AppMethodBeat.o(118718);
  }
  
  public static void aRR(String paramString)
  {
    AppMethodBeat.i(118719);
    p.h(paramString, "username");
    Object localObject = j.Fmy;
    localObject = j.b.fod();
    p.h(paramString, "username");
    paramString = ((g)localObject).aSt(paramString);
    boolean bool1 = paramString.frA();
    if (paramString.field_readId != paramString.field_syncId)
    {
      paramString.field_readId = paramString.field_syncId;
      paramString.field_readTime = cl.aWz();
      boolean bool2 = ((g)localObject).b(paramString);
      boolean bool3 = paramString.frA();
      if ((bool2) && (bool1) && (!bool3)) {
        ((g)localObject).doNotify("notify_story_read", 1, paramString);
      }
    }
    AppMethodBeat.o(118719);
  }
  
  public static f aRS(String paramString)
  {
    AppMethodBeat.i(118720);
    p.h(paramString, "userName");
    j.b localb = j.Fmy;
    paramString = j.b.fod().aRS(paramString);
    AppMethodBeat.o(118720);
    return paramString;
  }
  
  public static boolean aRT(String paramString)
  {
    AppMethodBeat.i(118721);
    if (paramString != null)
    {
      j.b localb = j.Fmy;
      paramString = j.b.fod().aSw(paramString);
      if ((paramString == null) || (!paramString.frA())) {}
    }
    for (boolean bool = true;; bool = false)
    {
      Log.d(TAG, "getWithNotify ".concat(String.valueOf(bool)));
      AppMethodBeat.o(118721);
      return bool;
    }
  }
  
  public static void reportWaitPlayList(List<String> arg0, long paramLong)
  {
    AppMethodBeat.i(118722);
    p.h(???, "srcuserList");
    Object localObject1 = h.FuH;
    long l = h.fqi().ahy();
    localObject1 = new ArrayList();
    synchronized ((Iterable)???)
    {
      localObject2 = ???.iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
      }
    }
    Object localObject2 = x.SXb;
    d.b("reportWaitPlayList", (a)new a(l, paramLong, localArrayList));
    AppMethodBeat.o(118722);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(long paramLong1, long paramLong2, ArrayList paramArrayList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.k
 * JD-Core Version:    0.7.0.1
 */