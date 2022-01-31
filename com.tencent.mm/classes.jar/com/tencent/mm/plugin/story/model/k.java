package com.tencent.mm.plugin.story.model;

import a.f.a.a;
import a.f.a.m;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryExtInfoStorageLogic;", "", "()V", "TAG", "", "get", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "userName", "getWithNotify", "", "username", "reportWaitPlayList", "", "srcuserList", "", "scene", "", "set", "info", "updateUserReadId", "updateUserReadIds", "usernames", "updateUserSyncId", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "syncId", "postTime", "", "thumb", "videoUrl", "duration", "plugin-story_release"})
public final class k
{
  private static final String TAG = "MicroMsg.StoryExtInfoStorageLogic";
  public static final k svr;
  
  static
  {
    AppMethodBeat.i(109096);
    svr = new k();
    TAG = "MicroMsg.StoryExtInfoStorageLogic";
    AppMethodBeat.o(109096);
  }
  
  public static void a(String paramString1, long paramLong1, int paramInt, String paramString2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(109089);
    a.f.b.j.q(paramString1, "username");
    Object localObject = j.svi;
    g localg = j.b.cAC();
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    a.f.b.j.q(paramString1, "userName");
    a.f.b.j.q(localObject, "thumb");
    a.f.b.j.q(paramString2, "videoUrl");
    paramString3 = localg.adB(paramString1);
    if (paramString3 == null) {}
    for (paramString1 = localg.adz(paramString1);; paramString1 = paramString3)
    {
      boolean bool1 = paramString1.cEU();
      boolean bool2 = paramString1.isValid();
      paramString3 = f.sGy;
      if (((Boolean)f.cEV().h(Long.valueOf(paramString1.field_syncId), Long.valueOf(paramLong1))).booleanValue()) {
        paramString1.field_updateTime = (paramInt * 1000L);
      }
      paramString1.field_syncId = paramLong1;
      if (paramString1.field_preloadStoryId != paramString1.field_syncId)
      {
        paramString1.field_preloadStoryId = 0L;
        paramString1.ady("");
        paramString1.field_preLoadResource = 0L;
      }
      paramString1.field_storyPostTime = paramInt;
      a.f.b.j.q(localObject, "value");
      paramString1.field_newThumbUrl = ((String)localObject);
      a.f.b.j.q(paramString2, "value");
      paramString1.field_newVideoUrl = paramString2;
      paramString1.field_duration = paramLong2;
      boolean bool3 = localg.b(paramString1);
      boolean bool4 = paramString1.cEU();
      boolean bool5 = paramString1.isValid();
      if ((bool3) && (bool2) && (!bool5))
      {
        localg.doNotify("notify_story_invalid", 4, paramString1);
        AppMethodBeat.o(109089);
        return;
      }
      if ((bool3) && (!bool1) && (bool4))
      {
        localg.doNotify("notify_story_unread", 2, paramString1);
        AppMethodBeat.o(109089);
        return;
      }
      if ((bool3) && (bool1) && (!bool4))
      {
        localg.doNotify("notify_story_unread", 1, paramString1);
        AppMethodBeat.o(109089);
        return;
      }
      if ((bool3) && (!bool2) && (bool5)) {
        localg.doNotify("notify_story_valid", 5, paramString1);
      }
      AppMethodBeat.o(109089);
      return;
    }
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.story.h.j paramj)
  {
    AppMethodBeat.i(109091);
    a.f.b.j.q(paramString, "username");
    if (paramj != null)
    {
      cic localcic = paramj.cEY();
      if ((localcic != null) && (localcic.xSK.wOa.size() > 0) && (((chl)localcic.xSK.wOa.get(0)).xrS != null) && (((chl)localcic.xSK.wOa.get(0)).Url != null)) {
        a(paramString, paramj.field_storyID, paramj.field_createTime, ((chl)localcic.xSK.wOa.get(0)).xrS, ((chl)localcic.xSK.wOa.get(0)).Url, (((chl)localcic.xSK.wOa.get(0)).duration * 1000.0F));
      }
      AppMethodBeat.o(109091);
      return;
    }
    AppMethodBeat.o(109091);
  }
  
  public static void acT(String paramString)
  {
    AppMethodBeat.i(109092);
    a.f.b.j.q(paramString, "username");
    Object localObject = j.svi;
    localObject = j.b.cAC();
    a.f.b.j.q(paramString, "username");
    paramString = ((g)localObject).adz(paramString);
    boolean bool1 = paramString.cEU();
    if (paramString.field_readId != paramString.field_syncId)
    {
      paramString.field_readId = paramString.field_syncId;
      paramString.field_readTime = cb.abq();
      boolean bool2 = ((g)localObject).b(paramString);
      boolean bool3 = paramString.cEU();
      if ((bool2) && (bool1) && (!bool3)) {
        ((g)localObject).doNotify("notify_story_read", 1, paramString);
      }
    }
    AppMethodBeat.o(109092);
  }
  
  public static f acU(String paramString)
  {
    AppMethodBeat.i(109093);
    a.f.b.j.q(paramString, "userName");
    j.b localb = j.svi;
    paramString = j.b.cAC().acU(paramString);
    AppMethodBeat.o(109093);
    return paramString;
  }
  
  public static boolean acV(String paramString)
  {
    AppMethodBeat.i(109094);
    if (paramString != null)
    {
      j.b localb = j.svi;
      paramString = j.b.cAC().adC(paramString);
      if ((paramString == null) || (!paramString.cEU())) {}
    }
    for (boolean bool = true;; bool = false)
    {
      ab.d(TAG, "getWithNotify ".concat(String.valueOf(bool)));
      AppMethodBeat.o(109094);
      return bool;
    }
  }
  
  public static void reportWaitPlayList(List<String> arg0, long paramLong)
  {
    AppMethodBeat.i(109095);
    a.f.b.j.q(???, "srcuserList");
    Object localObject1 = i.sFa;
    long l = i.cDo().FH();
    localObject1 = new ArrayList();
    synchronized ((Iterable)???)
    {
      localObject2 = ???.iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
      }
    }
    Object localObject2 = y.BMg;
    b.a("reportWaitPlayList", (a)new k.a(l, paramLong, localArrayList));
    AppMethodBeat.o(109095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.k
 * JD-Core Version:    0.7.0.1
 */