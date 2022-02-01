package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.b.a.lx;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.eol;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryExtInfoStorageLogic;", "", "()V", "TAG", "", "get", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "userName", "getWithNotify", "", "username", "reportWaitPlayList", "", "srcuserList", "", "scene", "", "set", "info", "updateUserReadId", "storyId", "updateUserSyncId", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "syncId", "postTime", "", "thumb", "videoUrl", "duration", "plugin-story_release"})
public final class k
{
  public static final k LGJ;
  private static final String TAG = "MicroMsg.StoryExtInfoStorageLogic";
  
  static
  {
    AppMethodBeat.i(118723);
    LGJ = new k();
    TAG = "MicroMsg.StoryExtInfoStorageLogic";
    AppMethodBeat.o(118723);
  }
  
  public static void a(String paramString1, long paramLong1, int paramInt, String paramString2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(118716);
    p.k(paramString1, "username");
    Object localObject = j.LGA;
    g localg = j.b.gcx();
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    p.k(paramString1, "userName");
    p.k(localObject, "thumb");
    p.k(paramString2, "videoUrl");
    paramString3 = localg.bdz(paramString1);
    if (paramString3 == null) {}
    for (paramString1 = localg.bdx(paramString1);; paramString1 = paramString3)
    {
      boolean bool1 = paramString1.gfW();
      boolean bool2 = paramString1.isValid();
      paramString3 = f.LQh;
      if (((Boolean)f.gfX().invoke(Long.valueOf(paramString1.field_syncId), Long.valueOf(paramLong1))).booleanValue()) {
        paramString1.field_updateTime = (paramInt * 1000L);
      }
      paramString1.field_syncId = paramLong1;
      if (paramString1.field_preloadStoryId != paramString1.field_syncId)
      {
        paramString1.field_preloadStoryId = 0L;
        paramString1.bdw("");
        paramString1.field_preLoadResource = 0L;
      }
      paramString1.field_storyPostTime = paramInt;
      p.k(localObject, "value");
      paramString1.field_newThumbUrl = ((String)localObject);
      p.k(paramString2, "value");
      paramString1.field_newVideoUrl = paramString2;
      paramString1.field_duration = paramLong2;
      boolean bool3 = localg.b(paramString1);
      boolean bool4 = paramString1.gfW();
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
    p.k(paramString, "username");
    if (paramj != null)
    {
      eol localeol = paramj.ggc();
      if ((localeol != null) && (localeol.Ura.Sqr.size() > 0) && (((enu)localeol.Ura.Sqr.get(0)).TDF != null) && (((enu)localeol.Ura.Sqr.get(0)).Url != null)) {
        a(paramString, paramj.field_storyID, paramj.field_createTime, ((enu)localeol.Ura.Sqr.get(0)).TDF, ((enu)localeol.Ura.Sqr.get(0)).Url, (((enu)localeol.Ura.Sqr.get(0)).UqC * 1000.0F));
      }
      AppMethodBeat.o(118718);
      return;
    }
    AppMethodBeat.o(118718);
  }
  
  public static void bcV(String paramString)
  {
    AppMethodBeat.i(118719);
    p.k(paramString, "username");
    Object localObject = j.LGA;
    localObject = j.b.gcx();
    p.k(paramString, "username");
    paramString = ((g)localObject).bdx(paramString);
    boolean bool1 = paramString.gfW();
    if (paramString.field_readId != paramString.field_syncId)
    {
      paramString.field_readId = paramString.field_syncId;
      paramString.field_readTime = cm.bfD();
      boolean bool2 = ((g)localObject).b(paramString);
      boolean bool3 = paramString.gfW();
      if ((bool2) && (bool1) && (!bool3)) {
        ((g)localObject).doNotify("notify_story_read", 1, paramString);
      }
    }
    AppMethodBeat.o(118719);
  }
  
  public static f bcW(String paramString)
  {
    AppMethodBeat.i(118720);
    p.k(paramString, "userName");
    j.b localb = j.LGA;
    paramString = j.b.gcx().bcW(paramString);
    AppMethodBeat.o(118720);
    return paramString;
  }
  
  public static boolean bcX(String paramString)
  {
    AppMethodBeat.i(118721);
    if (paramString != null)
    {
      j.b localb = j.LGA;
      paramString = j.b.gcx().bdA(paramString);
      if ((paramString == null) || (!paramString.gfW())) {}
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
    p.k(???, "srcuserList");
    Object localObject1 = h.LOJ;
    long l = h.geE().amU();
    localObject1 = new ArrayList();
    synchronized ((Iterable)???)
    {
      localObject2 = ???.iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
      }
    }
    Object localObject2 = x.aazN;
    d.b("reportWaitPlayList", (a)new a(l, paramLong, localArrayList));
    AppMethodBeat.o(118722);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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