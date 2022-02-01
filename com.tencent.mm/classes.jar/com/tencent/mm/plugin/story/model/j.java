package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.mmdata.rpt.ox;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryExtInfoStorageLogic;", "", "()V", "TAG", "", "get", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "userName", "getWithNotify", "", "username", "reportWaitPlayList", "", "srcuserList", "", "scene", "", "set", "info", "updateUserReadId", "storyId", "updateUserSyncId", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "syncId", "postTime", "", "thumb", "videoUrl", "duration", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j Skm;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(118723);
    Skm = new j();
    TAG = "MicroMsg.StoryExtInfoStorageLogic";
    AppMethodBeat.o(118723);
  }
  
  public static void a(String paramString1, long paramLong1, int paramInt, String paramString2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(118716);
    s.u(paramString1, "username");
    Object localObject = StoryCore.SjP;
    g localg = StoryCore.b.hvS();
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    s.u(paramString1, "userName");
    s.u(localObject, "thumb");
    s.u(paramString2, "videoUrl");
    paramString3 = localg.bcl(paramString1);
    if (paramString3 == null) {}
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    for (paramString1 = localg.bck(paramString1);; paramString1 = paramString3)
    {
      bool1 = paramString1.hzn();
      bool2 = paramString1.isValid();
      paramString3 = f.SsS;
      if (((Boolean)f.hzo().invoke(Long.valueOf(paramString1.field_syncId), Long.valueOf(paramLong1))).booleanValue()) {
        paramString1.field_updateTime = (paramInt * 1000L);
      }
      paramString1.field_syncId = paramLong1;
      if (paramString1.field_preloadStoryId != paramString1.field_syncId)
      {
        paramString1.field_preloadStoryId = 0L;
        paramString1.bcj("");
        paramString1.field_preLoadResource = 0L;
      }
      paramString1.field_storyPostTime = paramInt;
      s.u(localObject, "value");
      paramString1.field_newThumbUrl = ((String)localObject);
      s.u(paramString2, "value");
      paramString1.field_newVideoUrl = paramString2;
      paramString1.field_duration = paramLong2;
      bool3 = localg.b(paramString1);
      bool4 = paramString1.hzn();
      bool5 = paramString1.isValid();
      if ((!bool3) || (!bool2) || (bool5)) {
        break;
      }
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
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.story.h.j paramj)
  {
    AppMethodBeat.i(118718);
    s.u(paramString, "username");
    if (paramj != null)
    {
      fjj localfjj = paramj.hzt();
      if ((localfjj != null) && (localfjj.abJZ.Zpr.size() > 0) && (((fis)localfjj.abJZ.Zpr.get(0)).aaTl != null) && (((fis)localfjj.abJZ.Zpr.get(0)).Url != null)) {
        a(paramString, paramj.field_storyID, paramj.field_createTime, ((fis)localfjj.abJZ.Zpr.get(0)).aaTl, ((fis)localfjj.abJZ.Zpr.get(0)).Url, (((fis)localfjj.abJZ.Zpr.get(0)).abJB * 1000.0F));
      }
    }
    AppMethodBeat.o(118718);
  }
  
  public static void bbI(String paramString)
  {
    AppMethodBeat.i(118719);
    s.u(paramString, "username");
    Object localObject = StoryCore.SjP;
    localObject = StoryCore.b.hvS();
    s.u(paramString, "username");
    paramString = ((g)localObject).bck(paramString);
    boolean bool1 = paramString.hzn();
    if (paramString.field_readId != paramString.field_syncId)
    {
      paramString.field_readId = paramString.field_syncId;
      paramString.field_readTime = cn.bDv();
      boolean bool2 = ((g)localObject).b(paramString);
      boolean bool3 = paramString.hzn();
      if ((bool2) && (bool1) && (!bool3)) {
        ((g)localObject).doNotify("notify_story_read", 1, paramString);
      }
    }
    AppMethodBeat.o(118719);
  }
  
  public static f bbJ(String paramString)
  {
    AppMethodBeat.i(118720);
    s.u(paramString, "userName");
    StoryCore.b localb = StoryCore.SjP;
    paramString = StoryCore.b.hvS().bbJ(paramString);
    AppMethodBeat.o(118720);
    return paramString;
  }
  
  public static boolean bbK(String paramString)
  {
    AppMethodBeat.i(118721);
    if (paramString != null)
    {
      StoryCore.b localb = StoryCore.SjP;
      paramString = StoryCore.b.hvS().bcm(paramString);
      if ((paramString == null) || (!paramString.hzn())) {}
    }
    for (boolean bool = true;; bool = false)
    {
      Log.d(TAG, s.X("getWithNotify ", Boolean.valueOf(bool)));
      AppMethodBeat.o(118721);
      return bool;
    }
  }
  
  public static void reportWaitPlayList(List<String> arg0, long paramLong)
  {
    AppMethodBeat.i(118722);
    s.u(???, "srcuserList");
    Object localObject1 = h.SqZ;
    long l = h.hxW().iuE;
    localObject1 = new ArrayList();
    synchronized ((Iterable)???)
    {
      localObject2 = ???.iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
      }
    }
    Object localObject2 = ah.aiuX;
    d.d("reportWaitPlayList", (a)new a(l, paramLong, localArrayList));
    AppMethodBeat.o(118722);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(long paramLong1, long paramLong2, ArrayList<String> paramArrayList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.j
 * JD-Core Version:    0.7.0.1
 */