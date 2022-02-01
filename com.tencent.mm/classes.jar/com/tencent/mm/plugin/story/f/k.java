package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.a;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryExtInfoStorageLogic;", "", "()V", "TAG", "", "get", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "userName", "getWithNotify", "", "username", "reportWaitPlayList", "", "srcuserList", "", "scene", "", "set", "info", "updateUserReadId", "storyId", "updateUserSyncId", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "syncId", "postTime", "", "thumb", "videoUrl", "duration", "plugin-story_release"})
public final class k
{
  public static final k BbN;
  private static final String TAG = "MicroMsg.StoryExtInfoStorageLogic";
  
  static
  {
    AppMethodBeat.i(118723);
    BbN = new k();
    TAG = "MicroMsg.StoryExtInfoStorageLogic";
    AppMethodBeat.o(118723);
  }
  
  public static void a(String paramString1, long paramLong1, int paramInt, String paramString2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(118716);
    p.h(paramString1, "username");
    Object localObject = j.BbE;
    g localg = j.b.elC();
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
    paramString3 = localg.aDA(paramString1);
    if (paramString3 == null) {}
    for (paramString1 = localg.aDy(paramString1);; paramString1 = paramString3)
    {
      boolean bool1 = paramString1.epa();
      boolean bool2 = paramString1.isValid();
      paramString3 = f.Blo;
      if (((Boolean)f.epb().p(Long.valueOf(paramString1.field_syncId), Long.valueOf(paramLong1))).booleanValue()) {
        paramString1.field_updateTime = (paramInt * 1000L);
      }
      paramString1.field_syncId = paramLong1;
      if (paramString1.field_preloadStoryId != paramString1.field_syncId)
      {
        paramString1.field_preloadStoryId = 0L;
        paramString1.aDx("");
        paramString1.field_preLoadResource = 0L;
      }
      paramString1.field_storyPostTime = paramInt;
      p.h(localObject, "value");
      paramString1.field_newThumbUrl = ((String)localObject);
      p.h(paramString2, "value");
      paramString1.field_newVideoUrl = paramString2;
      paramString1.field_duration = paramLong2;
      boolean bool3 = localg.b(paramString1);
      boolean bool4 = paramString1.epa();
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
      dkx localdkx = paramj.epg();
      if ((localdkx != null) && (localdkx.HSy.Gtx.size() > 0) && (((dkg)localdkx.HSy.Gtx.get(0)).Hmj != null) && (((dkg)localdkx.HSy.Gtx.get(0)).Url != null)) {
        a(paramString, paramj.field_storyID, paramj.field_createTime, ((dkg)localdkx.HSy.Gtx.get(0)).Hmj, ((dkg)localdkx.HSy.Gtx.get(0)).Url, (((dkg)localdkx.HSy.Gtx.get(0)).HSb * 1000.0F));
      }
      AppMethodBeat.o(118718);
      return;
    }
    AppMethodBeat.o(118718);
  }
  
  public static void aCV(String paramString)
  {
    AppMethodBeat.i(118719);
    p.h(paramString, "username");
    Object localObject = j.BbE;
    localObject = j.b.elC();
    p.h(paramString, "username");
    paramString = ((g)localObject).aDy(paramString);
    boolean bool1 = paramString.epa();
    if (paramString.field_readId != paramString.field_syncId)
    {
      paramString.field_readId = paramString.field_syncId;
      paramString.field_readTime = ch.aDb();
      boolean bool2 = ((g)localObject).b(paramString);
      boolean bool3 = paramString.epa();
      if ((bool2) && (bool1) && (!bool3)) {
        ((g)localObject).doNotify("notify_story_read", 1, paramString);
      }
    }
    AppMethodBeat.o(118719);
  }
  
  public static f aCW(String paramString)
  {
    AppMethodBeat.i(118720);
    p.h(paramString, "userName");
    j.b localb = j.BbE;
    paramString = j.b.elC().aCW(paramString);
    AppMethodBeat.o(118720);
    return paramString;
  }
  
  public static boolean aCX(String paramString)
  {
    AppMethodBeat.i(118721);
    if (paramString != null)
    {
      j.b localb = j.BbE;
      paramString = j.b.elC().aDB(paramString);
      if ((paramString == null) || (!paramString.epa())) {}
    }
    for (boolean bool = true;; bool = false)
    {
      ae.d(TAG, "getWithNotify ".concat(String.valueOf(bool)));
      AppMethodBeat.o(118721);
      return bool;
    }
  }
  
  public static void reportWaitPlayList(List<String> arg0, long paramLong)
  {
    AppMethodBeat.i(118722);
    p.h(???, "srcuserList");
    Object localObject1 = h.BjR;
    long l = h.enI().TJ();
    localObject1 = new ArrayList();
    synchronized ((Iterable)???)
    {
      localObject2 = ???.iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
      }
    }
    Object localObject2 = z.Nhr;
    c.b("reportWaitPlayList", (a)new a(l, paramLong, localArrayList));
    AppMethodBeat.o(118722);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    a(long paramLong1, long paramLong2, ArrayList paramArrayList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.k
 * JD-Core Version:    0.7.0.1
 */