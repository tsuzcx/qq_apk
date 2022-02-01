package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.g.a.m;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryExtInfoStorageLogic;", "", "()V", "TAG", "", "get", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "userName", "getWithNotify", "", "username", "reportWaitPlayList", "", "srcuserList", "", "scene", "", "set", "info", "updateUserReadId", "storyId", "updateUserSyncId", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "syncId", "postTime", "", "thumb", "videoUrl", "duration", "plugin-story_release"})
public final class k
{
  private static final String TAG = "MicroMsg.StoryExtInfoStorageLogic";
  public static final k yfq;
  
  static
  {
    AppMethodBeat.i(118723);
    yfq = new k();
    TAG = "MicroMsg.StoryExtInfoStorageLogic";
    AppMethodBeat.o(118723);
  }
  
  public static void a(String paramString1, long paramLong1, int paramInt, String paramString2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(118716);
    d.g.b.k.h(paramString1, "username");
    Object localObject = j.yfh;
    g localg = j.b.dHe();
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    d.g.b.k.h(paramString1, "userName");
    d.g.b.k.h(localObject, "thumb");
    d.g.b.k.h(paramString2, "videoUrl");
    paramString3 = localg.arU(paramString1);
    if (paramString3 == null) {}
    for (paramString1 = localg.arS(paramString1);; paramString1 = paramString3)
    {
      boolean bool1 = paramString1.dKB();
      boolean bool2 = paramString1.isValid();
      paramString3 = f.yoS;
      if (((Boolean)f.dKC().n(Long.valueOf(paramString1.field_syncId), Long.valueOf(paramLong1))).booleanValue()) {
        paramString1.field_updateTime = (paramInt * 1000L);
      }
      paramString1.field_syncId = paramLong1;
      if (paramString1.field_preloadStoryId != paramString1.field_syncId)
      {
        paramString1.field_preloadStoryId = 0L;
        paramString1.arR("");
        paramString1.field_preLoadResource = 0L;
      }
      paramString1.field_storyPostTime = paramInt;
      d.g.b.k.h(localObject, "value");
      paramString1.field_newThumbUrl = ((String)localObject);
      d.g.b.k.h(paramString2, "value");
      paramString1.field_newVideoUrl = paramString2;
      paramString1.field_duration = paramLong2;
      boolean bool3 = localg.b(paramString1);
      boolean bool4 = paramString1.dKB();
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
    d.g.b.k.h(paramString, "username");
    if (paramj != null)
    {
      czd localczd = paramj.dKH();
      if ((localczd != null) && (localczd.Era.DaC.size() > 0) && (((cym)localczd.Era.DaC.get(0)).DMQ != null) && (((cym)localczd.Era.DaC.get(0)).Url != null)) {
        a(paramString, paramj.field_storyID, paramj.field_createTime, ((cym)localczd.Era.DaC.get(0)).DMQ, ((cym)localczd.Era.DaC.get(0)).Url, (((cym)localczd.Era.DaC.get(0)).EqD * 1000.0F));
      }
      AppMethodBeat.o(118718);
      return;
    }
    AppMethodBeat.o(118718);
  }
  
  public static void aro(String paramString)
  {
    AppMethodBeat.i(118719);
    d.g.b.k.h(paramString, "username");
    Object localObject = j.yfh;
    localObject = j.b.dHe();
    d.g.b.k.h(paramString, "username");
    paramString = ((g)localObject).arS(paramString);
    boolean bool1 = paramString.dKB();
    if (paramString.field_readId != paramString.field_syncId)
    {
      paramString.field_readId = paramString.field_syncId;
      paramString.field_readTime = ce.asR();
      boolean bool2 = ((g)localObject).b(paramString);
      boolean bool3 = paramString.dKB();
      if ((bool2) && (bool1) && (!bool3)) {
        ((g)localObject).doNotify("notify_story_read", 1, paramString);
      }
    }
    AppMethodBeat.o(118719);
  }
  
  public static f arp(String paramString)
  {
    AppMethodBeat.i(118720);
    d.g.b.k.h(paramString, "userName");
    j.b localb = j.yfh;
    paramString = j.b.dHe().arp(paramString);
    AppMethodBeat.o(118720);
    return paramString;
  }
  
  public static boolean arq(String paramString)
  {
    AppMethodBeat.i(118721);
    if (paramString != null)
    {
      j.b localb = j.yfh;
      paramString = j.b.dHe().arV(paramString);
      if ((paramString == null) || (!paramString.dKB())) {}
    }
    for (boolean bool = true;; bool = false)
    {
      ad.d(TAG, "getWithNotify ".concat(String.valueOf(bool)));
      AppMethodBeat.o(118721);
      return bool;
    }
  }
  
  public static void reportWaitPlayList(List<String> arg0, long paramLong)
  {
    AppMethodBeat.i(118722);
    d.g.b.k.h(???, "srcuserList");
    Object localObject1 = h.ynv;
    long l = h.dJj().QU();
    localObject1 = new ArrayList();
    synchronized ((Iterable)???)
    {
      localObject2 = ???.iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
      }
    }
    Object localObject2 = y.JfV;
    c.b("reportWaitPlayList", (a)new a(l, paramLong, localArrayList));
    AppMethodBeat.o(118722);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
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