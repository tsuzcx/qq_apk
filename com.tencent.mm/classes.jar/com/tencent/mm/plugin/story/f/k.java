package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.a;
import d.g.a.m;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryExtInfoStorageLogic;", "", "()V", "TAG", "", "get", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "userName", "getWithNotify", "", "username", "reportWaitPlayList", "", "srcuserList", "", "scene", "", "set", "info", "updateUserReadId", "storyId", "updateUserSyncId", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "syncId", "postTime", "", "thumb", "videoUrl", "duration", "plugin-story_release"})
public final class k
{
  private static final String TAG = "MicroMsg.StoryExtInfoStorageLogic";
  public static final k zsq;
  
  static
  {
    AppMethodBeat.i(118723);
    zsq = new k();
    TAG = "MicroMsg.StoryExtInfoStorageLogic";
    AppMethodBeat.o(118723);
  }
  
  public static void a(String paramString1, long paramLong1, int paramInt, String paramString2, String paramString3, long paramLong2)
  {
    AppMethodBeat.i(118716);
    d.g.b.k.h(paramString1, "username");
    Object localObject = j.zsh;
    g localg = j.b.dVF();
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
    paramString3 = localg.axd(paramString1);
    if (paramString3 == null) {}
    for (paramString1 = localg.axb(paramString1);; paramString1 = paramString3)
    {
      boolean bool1 = paramString1.dZc();
      boolean bool2 = paramString1.isValid();
      paramString3 = f.zCr;
      if (((Boolean)f.dZd().n(Long.valueOf(paramString1.field_syncId), Long.valueOf(paramLong1))).booleanValue()) {
        paramString1.field_updateTime = (paramInt * 1000L);
      }
      paramString1.field_syncId = paramLong1;
      if (paramString1.field_preloadStoryId != paramString1.field_syncId)
      {
        paramString1.field_preloadStoryId = 0L;
        paramString1.axa("");
        paramString1.field_preLoadResource = 0L;
      }
      paramString1.field_storyPostTime = paramInt;
      d.g.b.k.h(localObject, "value");
      paramString1.field_newThumbUrl = ((String)localObject);
      d.g.b.k.h(paramString2, "value");
      paramString1.field_newVideoUrl = paramString2;
      paramString1.field_duration = paramLong2;
      boolean bool3 = localg.b(paramString1);
      boolean bool4 = paramString1.dZc();
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
      dep localdep = paramj.dZi();
      if ((localdep != null) && (localdep.FOc.Etz.size() > 0) && (((ddy)localdep.FOc.Etz.get(0)).Fjh != null) && (((ddy)localdep.FOc.Etz.get(0)).Url != null)) {
        a(paramString, paramj.field_storyID, paramj.field_createTime, ((ddy)localdep.FOc.Etz.get(0)).Fjh, ((ddy)localdep.FOc.Etz.get(0)).Url, (((ddy)localdep.FOc.Etz.get(0)).FNF * 1000.0F));
      }
      AppMethodBeat.o(118718);
      return;
    }
    AppMethodBeat.o(118718);
  }
  
  public static void awx(String paramString)
  {
    AppMethodBeat.i(118719);
    d.g.b.k.h(paramString, "username");
    Object localObject = j.zsh;
    localObject = j.b.dVF();
    d.g.b.k.h(paramString, "username");
    paramString = ((g)localObject).axb(paramString);
    boolean bool1 = paramString.dZc();
    if (paramString.field_readId != paramString.field_syncId)
    {
      paramString.field_readId = paramString.field_syncId;
      paramString.field_readTime = ce.azI();
      boolean bool2 = ((g)localObject).b(paramString);
      boolean bool3 = paramString.dZc();
      if ((bool2) && (bool1) && (!bool3)) {
        ((g)localObject).doNotify("notify_story_read", 1, paramString);
      }
    }
    AppMethodBeat.o(118719);
  }
  
  public static f awy(String paramString)
  {
    AppMethodBeat.i(118720);
    d.g.b.k.h(paramString, "userName");
    j.b localb = j.zsh;
    paramString = j.b.dVF().awy(paramString);
    AppMethodBeat.o(118720);
    return paramString;
  }
  
  public static boolean awz(String paramString)
  {
    AppMethodBeat.i(118721);
    if (paramString != null)
    {
      j.b localb = j.zsh;
      paramString = j.b.dVF().axe(paramString);
      if ((paramString == null) || (!paramString.dZc())) {}
    }
    for (boolean bool = true;; bool = false)
    {
      ac.d(TAG, "getWithNotify ".concat(String.valueOf(bool)));
      AppMethodBeat.o(118721);
      return bool;
    }
  }
  
  public static void reportWaitPlayList(List<String> arg0, long paramLong)
  {
    AppMethodBeat.i(118722);
    d.g.b.k.h(???, "srcuserList");
    Object localObject1 = h.zAU;
    long l = h.dXK().Rw();
    localObject1 = new ArrayList();
    synchronized ((Iterable)???)
    {
      localObject2 = ???.iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
      }
    }
    Object localObject2 = y.KTp;
    c.b("reportWaitPlayList", (a)new a(l, paramLong, localArrayList));
    AppMethodBeat.o(118722);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.k
 * JD-Core Version:    0.7.0.1
 */