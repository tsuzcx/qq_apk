package com.tencent.mm.plugin.story.ui.view.gallery;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr;", "", "()V", "MAX_PRELOAD_TASK_LIMIT", "", "TAG", "", "clicfg_story_preload_force_canload", "getClicfg_story_preload_force_canload", "()I", "setClicfg_story_preload_force_canload", "(I)V", "clicfg_story_preload_force_preload", "getClicfg_story_preload_force_preload", "setClicfg_story_preload_force_preload", "clicfg_story_preload_strategy", "getClicfg_story_preload_strategy", "setClicfg_story_preload_strategy", "groupData", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "lastFinishStoryId", "", "getLastFinishStoryId", "()J", "setLastFinishStoryId", "(J)V", "lastStoryId", "getLastStoryId", "setLastStoryId", "playingMediaId", "preLoadConfig", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "getPreLoadConfig", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "setPreLoadConfig", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;)V", "preloadFinishSet", "", "preloadInfoRatioSet", "", "preloadInfoSet", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadRunningSet", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "runningMediaId", "Ljava/lang/Long;", "selectMediaId", "totalPreLoadOneItemSelect", "getTotalPreLoadOneItemSelect", "setTotalPreLoadOneItemSelect", "addPreLoadTask", "", "quota", "fromTag", "connectionCount", "addPreloadVideo", "", "videoItemList", "", "downloadExpect", "calcPreloadPercent", "mediaId", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "cacheSecondsDowngrade", "isGoodNetwork", "cancelAllPreloadTask", "cancelPreloadTask", "videoItem", "checkCanPlay", "item", "checkPreLoad", "checkPreloadOnVideoPlay", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "url", "path", "preloadPercent", "getNetworkSpeed", "isBadNetwork", "isLocalVideo", "makrFinish", "storyId", "markCurrentPlay", "markOnVideoFirstFrameDraw", "needPreLoad", "onVideoSourceChange", "preloadVideoWithPercent", "percent", "taskInfo", "queryQuota", "setPreloadQueueFromGallery", "groupItems", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "positionH", "skipPosition", "startPreLoad", "checkNet", "taskConnectionCount", "index", "upgrades", "GroupData", "MoovReadyInfo", "TaskInfo", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-story_release"})
public final class m
{
  private static long FHA;
  public static final m FHB;
  private static j FHn;
  private static int FHo;
  private static int FHp;
  private static int FHq;
  private static final Map<String, com.tencent.mm.plugin.story.f.d.j> FHr;
  private static final Map<String, Integer> FHs;
  private static final Set<String> FHt;
  private static final List<c> FHu;
  private static int FHv;
  private static a FHw;
  private static volatile String FHx;
  private static volatile Long FHy;
  private static long FHz;
  private static long Ftw;
  
  static
  {
    AppMethodBeat.i(120574);
    FHB = new m();
    FHn = new j();
    Object localObject = Collections.synchronizedMap((Map)new HashMap());
    p.g(localObject, "Collections.synchronized…tring, StoryVideoItem>())");
    FHr = (Map)localObject;
    localObject = Collections.synchronizedMap((Map)new HashMap());
    p.g(localObject, "Collections.synchronized…p(HashMap<String, Int>())");
    FHs = (Map)localObject;
    localObject = Collections.synchronizedSet((Set)new HashSet());
    p.g(localObject, "Collections.synchronizedSet(HashSet<String>())");
    FHt = (Set)localObject;
    localObject = Collections.synchronizedList((List)new LinkedList());
    p.g(localObject, "Collections.synchronized…t(LinkedList<TaskInfo>())");
    FHu = (List)localObject;
    FHv = 3;
    FHw = new a((List)new ArrayList());
    AppMethodBeat.o(120574);
  }
  
  private static int a(String paramString, edt paramedt, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(120569);
    float f = paramedt.Ned;
    Log.i("MicroMsg.StoryVideoPreloadMgr", "calcPreloadPercent, cacheSecondsDowngrade:" + paramInt + ", mediaId:" + paramString + ", duration:" + f + ", isGoodNetwork:" + paramBoolean + " media:" + paramedt.Ned);
    int i;
    if (paramBoolean)
    {
      i = 5;
      if (f > 0.0F) {
        break label134;
      }
      paramInt = FHn.FFU;
    }
    for (;;)
    {
      i = paramInt;
      if (paramInt <= FHn.FFU) {
        i = FHn.FFU;
      }
      AppMethodBeat.o(120569);
      return i;
      i = 3;
      break;
      label134:
      if ((f <= i) && (paramInt <= 0)) {
        paramInt = 100;
      } else {
        paramInt = (int)(Math.max(3, paramInt) / f * 100.0D);
      }
    }
  }
  
  private boolean a(com.tencent.mm.plugin.story.f.d.j paramj, int paramInt1, int paramInt2, c paramc)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(120563);
        p.h(paramj, "videoItem");
        p.h(paramc, "taskInfo");
        if ((paramj.foV()) || (Util.isNullOrNil(paramj.Fpd.Url)))
        {
          AppMethodBeat.o(120563);
          bool = false;
          return bool;
        }
        if (i(paramj))
        {
          Log.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, isLocalVideo: " + paramj.Fpd.Url);
          AppMethodBeat.o(120563);
          bool = false;
          continue;
        }
        String str2 = paramj.Fpd.Url;
        String str1 = paramc.jpT;
        Object localObject1 = com.tencent.mm.plugin.story.f.s.Fny;
        localObject1 = com.tencent.mm.plugin.story.f.s.a(paramj);
        Log.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, " + str1 + ", " + paramInt1 + ", playingMediaId:" + FHx + ", " + ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath + ", " + str2 + "  videoCache " + localObject1);
        if ((str1 == null) || (kotlin.n.n.I(FHx, str1, false))) {
          break label658;
        }
        Object localObject2 = com.tencent.mm.plugin.story.f.s.Fny;
        com.tencent.mm.vfs.s.boN(com.tencent.mm.plugin.story.f.s.aSc(paramj.username));
        p.g(str2, "url");
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
        p.g(localObject1, "videoCache.field_filePath");
        Log.i("MicroMsg.StoryVideoPreloadMgr", "createVideoPreloadCDNTask, mediaId:" + str1 + ", path:" + (String)localObject1 + ", url:" + str2 + ", preloadPercent:" + paramInt1 + ", connectionCount:" + paramInt2);
        localObject2 = new com.tencent.mm.i.h();
        ((com.tencent.mm.i.h)localObject2).taskName = "task_StoryVideoPreloadMgr";
        ((com.tencent.mm.i.h)localObject2).field_mediaId = str1;
        ((com.tencent.mm.i.h)localObject2).url = str2;
        ((com.tencent.mm.i.h)localObject2).gqO = 2;
        ((com.tencent.mm.i.h)localObject2).gqU = 2;
        ((com.tencent.mm.i.h)localObject2).gqP = 6;
        ((com.tencent.mm.i.h)localObject2).gqZ = paramInt1;
        ((com.tencent.mm.i.h)localObject2).field_preloadRatio = paramInt1;
        ((com.tencent.mm.i.h)localObject2).concurrentCount = 4;
        ((com.tencent.mm.i.h)localObject2).field_fullpath = ((String)localObject1);
        ((com.tencent.mm.i.h)localObject2).gqy = ((g.a)new e());
        ((com.tencent.mm.i.h)localObject2).gqQ = ((g.b)new d(Util.currentTicks()));
        ((com.tencent.mm.i.h)localObject2).connectionCount = paramInt2;
        ((com.tencent.mm.i.h)localObject2).field_fileType = com.tencent.mm.i.a.gpV;
        ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat = e.L(2, (String)localObject1);
        com.tencent.mm.an.f.baQ().e((com.tencent.mm.i.g)localObject2);
        Log.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent:" + localObject2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2));
        FHr.put(str1, paramj);
        FHs.put(str1, Integer.valueOf(paramInt1));
        paramj = FHu.iterator();
        paramInt1 = 0;
        if (!paramj.hasNext()) {
          break label639;
        }
        if (p.j(((c)paramj.next()).jpT, paramc.jpT))
        {
          if (paramInt1 <= 0) {
            break label644;
          }
          FHu.set(paramInt1, paramc);
          FHt.remove(str1);
          bool = true;
          AppMethodBeat.o(120563);
          continue;
        }
        paramInt1 += 1;
      }
      finally {}
      continue;
      label639:
      paramInt1 = -1;
      continue;
      label644:
      FHu.add(paramc);
      continue;
      label658:
      AppMethodBeat.o(120563);
      boolean bool = false;
    }
  }
  
  private static int abh(int paramInt)
  {
    AppMethodBeat.i(120564);
    Log.i("MicroMsg.StoryVideoPreloadMgr", "taskConnectionCount: ".concat(String.valueOf(paramInt)));
    List localList = FHn.FFZ;
    if (paramInt < FHn.FFZ.size()) {}
    for (;;)
    {
      paramInt = ((Number)localList.get(paramInt)).intValue();
      AppMethodBeat.o(120564);
      return paramInt;
      paramInt = FHn.FFZ.size() - 1;
    }
  }
  
  private static int c(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120556);
    p.h(paramj, "item");
    Object localObject = com.tencent.mm.plugin.story.f.s.Fny;
    localObject = com.tencent.mm.plugin.story.f.s.a(paramj);
    if (((com.tencent.mm.plugin.story.i.n)localObject).frQ())
    {
      Log.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay downloadFinish " + paramj.edx);
      AppMethodBeat.o(120556);
      return 1;
    }
    if (((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(120556);
      return 0;
    }
    if (((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize * 100.0F >= FHn.FFU)
    {
      Log.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay cachesize " + ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize + " totalSize: " + ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize);
      AppMethodBeat.o(120556);
      return 1;
    }
    AppMethodBeat.o(120556);
    return 0;
  }
  
  private static boolean d(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> arg0, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120551);
    p.h(???, "groupItems");
    Log.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery, galleryItems size:" + ???.size() + ", positionV:" + paramInt1 + "  positionH:" + paramInt2 + ", skipPosition:true");
    Object localObject1 = FHw;
    p.h(???, "galleryItems");
    int i;
    if (((a)localObject1).hC(???)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(120551);
      return false;
      if ((((a)localObject1).FHK != paramInt2) || (((a)localObject1).FHJ != paramInt1)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 < ???.size()) && (paramInt2 < ((List)???.get(paramInt1)).size()))
    {
      localObject1 = (com.tencent.mm.plugin.story.f.d.h)((List)???.get(paramInt1)).get(paramInt2);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.story.f.d.h)localObject1).FoT;
        if (localObject1 != null) {
          FHz = ((com.tencent.mm.plugin.story.f.d.j)localObject1).edx;
        }
      }
    }
    Ftw = 0L;
    FHv = 0;
    FHw = new a(???, paramInt1, paramInt2, FHw, true);
    localObject1 = new ArrayList();
    for (;;)
    {
      Object localObject5;
      synchronized ((Iterable)???)
      {
        localObject4 = ((Iterable)???).iterator();
        i = 0;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = ((Iterator)localObject4).next();
          if (i < 0) {
            kotlin.a.j.hxH();
          }
          localObject5 = (List)localObject5;
          if ((i < paramInt1) || (((List)localObject5).size() <= 0)) {
            break label961;
          }
          ((ArrayList)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.story.f.d.h)((List)localObject5).get(0)).FoT.ecf));
          break label961;
        }
        localObject4 = x.SXb;
        ??? = new ArrayList();
        if ((paramInt1 < ???.size()) && (paramInt2 < ((List)???.get(paramInt1)).size()))
        {
          i = ((List)???.get(paramInt1)).size();
          if (paramInt2 < i)
          {
            ((ArrayList)???).add(Integer.valueOf(((com.tencent.mm.plugin.story.f.d.h)((List)???.get(paramInt1)).get(paramInt2)).FoT.ecf));
            paramInt2 += 1;
          }
        }
      }
      Object localObject4 = (Iterable)FHu;
      ??? = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      label577:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        c localc = (c)localObject5;
        if ((!((ArrayList)localObject1).contains(Integer.valueOf(localc.FHP.ecf))) && (!((ArrayList)???).contains(Integer.valueOf(localc.FHP.ecf)))) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label577;
          }
          ???.add(localObject5);
          break;
        }
      }
      synchronized ((Iterable)???)
      {
        localObject1 = ???.iterator();
        if (((Iterator)localObject1).hasNext()) {
          l(((c)((Iterator)localObject1).next()).FHP);
        }
      }
      x localx = x.SXb;
      FHo = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPm, 1);
      paramInt1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPn, 450);
      paramInt2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPo, 200);
      FHp = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPp, 0);
      FHq = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPt, 100);
      FHn.FFV = paramInt1;
      FHn.FFW = paramInt2;
      i = CdnLogic.getRecentAverageSpeed(2);
      Log.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery clicfg_story_preload_strategy " + FHo + " clicfg_story_preload_speed_good:" + paramInt1 + " clicfg_story_preload_speed_bad:" + paramInt2 + " clicfg_story_preload_force_preload " + FHp + "  clicfg_story_preload_force_canload: " + FHq + " speed:" + i);
      if ((i > 0) && (FHq > 0) && (i < FHq))
      {
        Log.w("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery speed too low then pass " + i + " clicfg_story_preload_force_canload: " + FHq);
        ??? = new LinkedList();
        ???.addAll((Collection)FHu);
        ??? = ???.iterator();
        while (???.hasNext()) {
          l(((c)???.next()).FHP);
        }
      }
      AppMethodBeat.o(120551);
      return false;
      label961:
      i += 1;
    }
  }
  
  public static j fsu()
  {
    return FHn;
  }
  
  private static List<Integer> fsv()
  {
    AppMethodBeat.i(120550);
    if (fsy())
    {
      localList = FHn.FFY;
      AppMethodBeat.o(120550);
      return localList;
    }
    List localList = FHn.FFX;
    AppMethodBeat.o(120550);
    return localList;
  }
  
  public static void fsw()
  {
    AppMethodBeat.i(120568);
    Log.printInfoStack("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask", new Object[0]);
    Iterator localIterator = FHr.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Log.i("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask ".concat(String.valueOf(str)));
      com.tencent.mm.an.f.baQ().Oc(str);
    }
    FHr.clear();
    FHs.clear();
    FHw = new a((List)new ArrayList());
    FHu.clear();
    AppMethodBeat.o(120568);
  }
  
  private static boolean fsx()
  {
    AppMethodBeat.i(120570);
    if (CdnLogic.getRecentAverageSpeed(2) >= FHn.FFV)
    {
      AppMethodBeat.o(120570);
      return true;
    }
    AppMethodBeat.o(120570);
    return false;
  }
  
  private static boolean fsy()
  {
    AppMethodBeat.i(120571);
    int i = FHn.FFW;
    int j = CdnLogic.getRecentAverageSpeed(2);
    if (1 > j) {}
    while (i < j)
    {
      AppMethodBeat.o(120571);
      return false;
    }
    AppMethodBeat.o(120571);
    return true;
  }
  
  public static int fsz()
  {
    AppMethodBeat.i(258526);
    int i = CdnLogic.getRecentAverageSpeed(2);
    AppMethodBeat.o(258526);
    return i;
  }
  
  private static boolean i(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120562);
    if (paramj.foV())
    {
      AppMethodBeat.o(120562);
      return true;
    }
    com.tencent.mm.plugin.story.f.s locals = com.tencent.mm.plugin.story.f.s.Fny;
    if (com.tencent.mm.vfs.s.boW(com.tencent.mm.plugin.story.f.s.a(paramj.Fpd)) > 0L)
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", "isLocalVideo video downloadDone " + paramj.Fpd.taskId + " username:" + paramj.username);
      AppMethodBeat.o(120562);
      return true;
    }
    locals = com.tencent.mm.plugin.story.f.s.Fny;
    if (com.tencent.mm.plugin.story.f.s.a(paramj).frQ())
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", " isLocalVideo video download finish " + paramj.Fpd.taskId + " username:" + paramj.username);
      AppMethodBeat.o(120562);
      return true;
    }
    AppMethodBeat.o(120562);
    return false;
  }
  
  public static void j(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120565);
    p.h(paramj, "videoItem");
    Object localObject = com.tencent.mm.plugin.story.f.s.Fny;
    localObject = com.tencent.mm.plugin.story.f.s.cs(paramj.iXu, paramj.Fpd.Url);
    FHx = (String)localObject;
    FHy = Long.valueOf(paramj.edx);
    Log.i("MicroMsg.StoryVideoPreloadMgr", "markCurrentPlay:" + FHx + " then remove it from preload");
    Iterator localIterator = ((Iterable)FHu).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!p.j(localObject, ((c)paramj).jpT));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj == null) {
        break;
      }
      FHu.remove(paramj);
      l(paramj.FHP);
      AppMethodBeat.o(120565);
      return;
      paramj = null;
    }
    AppMethodBeat.o(120565);
  }
  
  public static m.b k(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120566);
    p.h(paramj, "videoItem");
    Object localObject1 = com.tencent.mm.plugin.story.f.s.Fny;
    localObject1 = com.tencent.mm.plugin.story.f.s.cs(paramj.iXu, paramj.Fpd.Url);
    Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreloadOnVideoPlay:".concat(String.valueOf(localObject1)));
    Object localObject2 = com.tencent.mm.plugin.story.f.s.Fny;
    localObject2 = com.tencent.mm.plugin.story.f.s.a(paramj);
    if ((((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize > 0) && (((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize > 0))
    {
      float f = ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize;
      Log.i("MicroMsg.StoryVideoPreloadMgr", "hit cache, mediaId:" + (String)localObject1 + ", cachePercent:" + f + ", filePath:" + ((com.tencent.mm.plugin.story.i.n)localObject2).field_filePath);
      localObject2 = ((com.tencent.mm.plugin.story.i.n)localObject2).field_filePath;
      CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      long[] arrayOfLong = new long[2];
      localC2CDownloadRequest.fileKey = ((String)localObject1);
      localC2CDownloadRequest.fileType = 6;
      localC2CDownloadRequest.url = paramj.Fpd.Url;
      localC2CDownloadRequest.setSavePath((String)localObject2);
      localC2CDownloadRequest.requestVideoFormat = e.L(1, (String)localObject2);
      boolean bool = CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong);
      Log.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " queryMoovReady: " + bool + ", offset:" + arrayOfLong[0] + ", length:" + arrayOfLong[1] + ", preloadFinish:" + kotlin.a.j.a((Iterable)FHt, localObject1));
      paramj = new m.b(true, arrayOfLong[0], arrayOfLong[1], kotlin.a.j.a((Iterable)FHt, localObject1));
      AppMethodBeat.o(120566);
      return paramj;
    }
    Log.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " not hit cache or moov not ready");
    paramj = new m.b(false, 0L, 0L, false);
    AppMethodBeat.o(120566);
    return paramj;
  }
  
  private static void l(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120567);
    p.h(paramj, "videoItem");
    Object localObject = com.tencent.mm.plugin.story.f.s.Fny;
    localObject = com.tencent.mm.plugin.story.f.s.cs(paramj.iXu, paramj.Fpd.Url);
    Log.i("MicroMsg.StoryVideoPreloadMgr", "cancelPreloadTask, videoItem:".concat(String.valueOf(localObject)));
    com.tencent.mm.an.f.baQ().Oc((String)localObject);
    Iterator localIterator = ((Iterable)FHu).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!p.j(((c)paramj).jpT, localObject));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj == null) {
        break;
      }
      FHu.remove(paramj);
      if (FHv > 0) {
        FHv -= 1;
      }
      AppMethodBeat.o(120567);
      return;
      paramj = null;
    }
    AppMethodBeat.o(120567);
  }
  
  private static boolean m(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120573);
    if ((i(paramj)) || (paramj.foV()))
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo fail, " + paramj + " isLocalVideo or fake video");
      AppMethodBeat.o(120573);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.story.f.s.Fny;
    localObject = com.tencent.mm.plugin.story.f.s.cs(paramj.iXu, paramj.Fpd.Url);
    if ((!Util.isNullOrNil((String)localObject)) && (!Util.isNullOrNil(paramj.Fpd.Url)) && (!kotlin.n.n.I(FHx, (String)localObject, false)))
    {
      AppMethodBeat.o(120573);
      return true;
    }
    Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo:" + (String)localObject + ", already request preload or url " + paramj.Fpd.Url);
    AppMethodBeat.o(120573);
    return false;
  }
  
  private final boolean u(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(120558);
    m localm;
    int i;
    kotlin.o localo;
    com.tencent.mm.plugin.story.f.d.j localj;
    label453:
    label469:
    do
    {
      for (;;)
      {
        localm = (m)this;
        Object localObject1 = FHw;
        i = 0;
        localo = null;
        while ((i < ((a)localObject1).FHI.size()) && (localo == null))
        {
          localo = ((a)localObject1).fsD();
          Log.i(a.TAG, "produceVideoItem walkVertical:" + ((a)localObject1).FHD + "  walkHorizontal:" + ((a)localObject1).FHE + " positionV:" + ((a)localObject1).FHJ + " positionH:" + ((a)localObject1).FHK + ", ret:" + localo);
          i += 1;
        }
        if (localo == null)
        {
          AppMethodBeat.o(120558);
          return false;
        }
        localj = (com.tencent.mm.plugin.story.f.d.j)localo.first;
        String str = ((c)localo.second).jpT;
        localObject1 = new StringBuilder("try preload mediaId ").append(str).append(" videoItem:").append(localj).append(" pos:").append((c)localo.second).append("  groupinfo ");
        Object localObject2 = FHw;
        Log.i("MicroMsg.StoryVideoPreloadMgr", new StringBuilder("positionV:").append(((a)localObject2).FHJ).append(", positionH:").append(((a)localObject2).FHK).append(", walkVertical:").append(((a)localObject2).FHD).append(", walkHorizontal:").append(((a)localObject2).FHE).toString() + " quota:" + paramInt1 + "  fromTag:" + paramString);
        localObject2 = ((Iterable)FHu).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
        } while (!p.j(((c)localObject1).jpT, str));
        for (;;)
        {
          localObject1 = (c)localObject1;
          if ((localObject1 == null) || (paramInt1 > ((c)localObject1).gsw)) {
            break label453;
          }
          Log.i("MicroMsg.StoryVideoPreloadMgr", "no need add quota " + paramInt1 + " cur:" + ((c)localObject1).gsw + " fromTag:" + paramString);
          break;
          localObject1 = null;
        }
        if (((CharSequence)str).length() == 0)
        {
          i = 1;
          if (i != 0) {
            break label640;
          }
        }
        for (localObject1 = str;; localObject1 = null)
        {
          if (localObject1 == null) {
            break label644;
          }
          i = a(str, localj.Fpd, paramInt1, fsx());
          localObject1 = com.tencent.mm.plugin.story.f.s.Fny;
          localObject1 = com.tencent.mm.plugin.story.f.s.a(localj);
          if ((!((com.tencent.mm.plugin.story.i.n)localObject1).frQ()) && (((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize * 100.0F < i)) {
            break label646;
          }
          Log.i("MicroMsg.StoryVideoPreloadMgr", "pull preload video, " + str + ", already reach cache size! cacheSize:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize + ", totalSize:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize + ", cachePercent:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize * 100.0F + "  fromTag:" + paramString);
          break;
          i = 0;
          break label469;
        }
      }
    } while (!localm.a(localj, i, paramInt2, (c)localo.second));
    label640:
    label644:
    label646:
    ((c)localo.second).gsw = paramInt1;
    AppMethodBeat.o(120558);
    return true;
  }
  
  private final void wc(boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(120557);
    boolean bool1 = fsx();
    boolean bool2 = fsy();
    int i = CdnLogic.getRecentAverageSpeed(2);
    if ((paramBoolean) && (i > 0) && (FHq > 0) && (i < FHq))
    {
      Log.w("MicroMsg.StoryVideoPreloadMgr", "speed too low then pass " + i + " clicfg_story_preload_force_canload: " + FHq + " callerFrom " + MMStack.getCaller());
      AppMethodBeat.o(120557);
      return;
    }
    int j = 0;
    if (bool2) {}
    for (i = 1;; i = 3)
    {
      if (FHo == 1) {
        i = k;
      }
      for (;;)
      {
        Log.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + FHu.size() + " maxTaskNum " + i + " totalPreLoadOneItemSelect " + FHv + " checkNet " + paramBoolean + " callerFrom " + MMStack.getCaller());
        List localList = fsv();
        while ((FHu.size() < i) && (j < localList.size()) && (FHv < 3) && (u(((Number)localList.get(j)).intValue(), "startPreLoad", abh(j))))
        {
          FHv += 1;
          j += 1;
        }
        Log.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue finish loop preload queue, current queue size: " + FHu.size() + ", pullPreloadTaskNum:0, preloadVideoNum:" + j + " preloadRunningSet " + FHu.size() + " totalPreLoadOneItemSelect " + FHv + ' ');
        AppMethodBeat.o(120557);
        return;
      }
    }
  }
  
  public final void C(List<com.tencent.mm.plugin.story.f.d.j> paramList, int paramInt)
  {
    AppMethodBeat.i(120560);
    p.h(paramList, "videoItemList");
    Log.printInfoStack("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList " + paramList.size(), new Object[0]);
    boolean bool1 = fsx();
    boolean bool2 = fsy();
    Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + FHu.size() + " downloadExpect " + paramInt);
    List localList = fsv();
    int j = 0;
    for (;;)
    {
      com.tencent.mm.plugin.story.f.d.j localj;
      int i;
      int k;
      String str;
      int m;
      com.tencent.mm.plugin.story.i.n localn;
      synchronized ((Iterable)paramList)
      {
        Iterator localIterator1 = ???.iterator();
        if (!localIterator1.hasNext()) {
          break label543;
        }
        localj = (com.tencent.mm.plugin.story.f.d.j)localIterator1.next();
        if (!m(localj)) {
          continue;
        }
        if (paramInt > 0)
        {
          i = paramInt;
          k = abh(j);
          paramList = com.tencent.mm.plugin.story.f.s.Fny;
          str = com.tencent.mm.plugin.story.f.s.cs(localj.iXu, localj.Fpd.Url);
          m = a(str, localj.Fpd, i, fsx());
          paramList = com.tencent.mm.plugin.story.f.s.Fny;
          localn = com.tencent.mm.plugin.story.f.s.a(localj);
          Iterator localIterator2 = ((Iterable)FHu).iterator();
          if (!localIterator2.hasNext()) {
            break label598;
          }
          paramList = localIterator2.next();
          if (!p.j(((c)paramList).jpT, str)) {
            continue;
          }
          if (paramList == null) {
            break label389;
          }
          Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already prealoding!");
        }
      }
      if (j < localList.size())
      {
        i = ((Number)localList.get(j)).intValue();
      }
      else
      {
        i = ((Number)kotlin.a.j.ku(localList)).intValue();
        continue;
        label389:
        if ((localn.frQ()) || (localn.field_cacheSize / localn.field_totalSize * 100.0F >= m))
        {
          Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already reach cache size! cacheSize:" + localn.field_cacheSize + ", totalSize:" + localn.field_totalSize + ", cachePercent:" + localn.field_cacheSize / localn.field_totalSize * 100.0F);
        }
        else
        {
          paramList = new c(0, j, localj, i, k);
          if (FHB.a(localj, m, k, paramList))
          {
            j += 1;
            continue;
            label543:
            paramList = x.SXb;
            Log.i("MicroMsg.StoryVideoPreloadMgr", "finish addPreloadVideo withList, total pull video task:" + j + " preloadRunningSet " + FHu.size());
            AppMethodBeat.o(120560);
            return;
            label598:
            paramList = null;
          }
        }
      }
    }
  }
  
  public final void KD(long paramLong)
  {
    AppMethodBeat.i(120553);
    if (Ftw == paramLong)
    {
      AppMethodBeat.o(120553);
      return;
    }
    Ftw = paramLong;
    if (FHo == 0)
    {
      AppMethodBeat.o(120553);
      return;
    }
    a locala = FHw;
    if (locala != null) {
      locala.fsE();
    }
    wc(true);
    AppMethodBeat.o(120553);
  }
  
  public final void KE(long paramLong)
  {
    AppMethodBeat.i(120554);
    Object localObject = FHy;
    if (localObject == null) {}
    while (FHA == paramLong)
    {
      AppMethodBeat.o(120554);
      return;
      if (((Long)localObject).longValue() == paramLong) {
        FHy = Long.valueOf(0L);
      }
    }
    FHA = paramLong;
    if (FHo == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (FHq == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (FHu.size() > 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    localObject = FHw;
    if (localObject != null) {
      ((a)localObject).fsE();
    }
    wc(false);
    AppMethodBeat.o(120554);
  }
  
  public final void h(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120555);
    p.h(paramj, "item");
    Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad " + paramj + ' ' + MMStack.getCaller());
    if (i(paramj))
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay isLocalVideo");
      wc(false);
      AppMethodBeat.o(120555);
      return;
    }
    if (c(paramj) == 1)
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay true");
      wc(true);
      AppMethodBeat.o(120555);
      return;
    }
    if (FHp == 1) {
      wc(true);
    }
    Log.i("MicroMsg.StoryVideoPreloadMgr", "nothing can checkPreLoad");
    AppMethodBeat.o(120555);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "", "groupItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "", "positionH", "lastGroup", "skipPosition", "", "(Ljava/util/List;IILcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;Z)V", "MAX_PRELOAD_COUNT", "horizontalList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "produceList", "Lkotlin/Function0;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "verticalList", "walkHorizontal", "walkIndex", "walkVertical", "info", "", "isDataChange", "isSame", "galleryItems", "produce", "produceHorizontalVideoItem", "produceVerticalVideoItem", "produceVideoItem", "reset", "", "resetWalk", "Companion", "plugin-story_release"})
  public static final class a
  {
    public static final a FHM;
    static final String TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
    private final int FHC;
    int FHD;
    int FHE;
    private int FHF;
    private ArrayList<com.tencent.mm.plugin.story.f.d.h> FHG;
    private ArrayList<com.tencent.mm.plugin.story.f.d.h> FHH;
    List<? extends kotlin.g.a.a<kotlin.o<com.tencent.mm.plugin.story.f.d.j, m.c>>> FHI;
    int FHJ;
    int FHK;
    private final boolean FHL;
    
    static
    {
      AppMethodBeat.i(120542);
      FHM = new a((byte)0);
      TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
      AppMethodBeat.o(120542);
    }
    
    public a(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> arg1, int paramInt1, int paramInt2, a arg4, boolean paramBoolean)
    {
      AppMethodBeat.i(222927);
      this.FHJ = paramInt1;
      this.FHK = paramInt2;
      this.FHL = true;
      this.FHC = 15;
      this.FHG = new ArrayList();
      this.FHH = new ArrayList();
      this.FHI = kotlin.a.j.listOf(new kotlin.g.a.a[] { (kotlin.g.a.a)new b(this), (kotlin.g.a.a)new c(this), (kotlin.g.a.a)new d(this) });
      if (((??? != null) && (this.FHJ != ???.FHJ)) || ((??? != null) && (this.FHK != ???.FHK)) || (hC(???))) {
        reset();
      }
      this.FHG.clear();
      this.FHH.clear();
      for (;;)
      {
        synchronized ((Iterable)???)
        {
          localObject = ???.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          List localList = (List)((Iterator)localObject).next();
          if (!((Collection)localList).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              continue;
            }
            this.FHH.add(localList.get(0));
          }
        }
        paramInt1 = 0;
      }
      Object localObject = x.SXb;
      if (this.FHJ < ???.size())
      {
        synchronized ((Iterable)???.get(this.FHJ))
        {
          ??? = ???.iterator();
          if (???.hasNext())
          {
            localObject = (com.tencent.mm.plugin.story.f.d.h)???.next();
            this.FHG.add(localObject);
          }
        }
        ??? = x.SXb;
        AppMethodBeat.o(222927);
        return;
      }
      AppMethodBeat.o(222927);
    }
    
    private final kotlin.o<com.tencent.mm.plugin.story.f.d.j, m.c> fsF()
    {
      AppMethodBeat.i(120539);
      for (;;)
      {
        if (this.FHL) {
          this.FHD += 1;
        }
        if (this.FHD >= this.FHH.size())
        {
          AppMethodBeat.o(120539);
          return null;
        }
        try
        {
          if (this.FHH.size() > 0)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)this.FHH.get(this.FHD)).FoT;
            m localm = m.FHB;
            if (m.n((com.tencent.mm.plugin.story.f.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new kotlin.o(localObject1, new m.c(this.FHD, 0, (com.tencent.mm.plugin.story.f.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.FHL) {
            continue;
          }
          this.FHD += 1;
        }
        finally
        {
          if (!this.FHL) {
            this.FHD += 1;
          }
          AppMethodBeat.o(120539);
        }
      }
    }
    
    private final kotlin.o<com.tencent.mm.plugin.story.f.d.j, m.c> fsG()
    {
      AppMethodBeat.i(120540);
      for (;;)
      {
        if (this.FHL) {
          this.FHE += 1;
        }
        if (this.FHE >= this.FHG.size())
        {
          AppMethodBeat.o(120540);
          return null;
        }
        try
        {
          if (this.FHG.size() > this.FHE)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)this.FHG.get(this.FHE)).FoT;
            m localm = m.FHB;
            if (m.n((com.tencent.mm.plugin.story.f.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new kotlin.o(localObject1, new m.c(this.FHD, this.FHE, (com.tencent.mm.plugin.story.f.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.FHL) {
            continue;
          }
          this.FHE += 1;
        }
        finally
        {
          if (!this.FHL) {
            this.FHE += 1;
          }
          AppMethodBeat.o(120540);
        }
      }
    }
    
    private final void reset()
    {
      this.FHD = this.FHJ;
      this.FHE = this.FHK;
      this.FHF = 0;
    }
    
    final kotlin.o<com.tencent.mm.plugin.story.f.d.j, m.c> fsD()
    {
      AppMethodBeat.i(120536);
      try
      {
        if (this.FHF > this.FHC)
        {
          Log.i(TAG, "stop preload now " + this.FHF);
          AppMethodBeat.o(120536);
          return null;
        }
        kotlin.o localo = (kotlin.o)((kotlin.g.a.a)this.FHI.get(this.FHF % this.FHI.size())).invoke();
        this.FHF += 1;
        AppMethodBeat.o(120536);
        return localo;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException, "error on produce", new Object[0]);
        AppMethodBeat.o(120536);
      }
      return null;
    }
    
    public final void fsE()
    {
      AppMethodBeat.i(120538);
      Log.i(TAG, "resetWalk");
      reset();
      AppMethodBeat.o(120538);
    }
    
    final boolean hC(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> paramList)
    {
      AppMethodBeat.i(120537);
      if (paramList.size() == this.FHH.size())
      {
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
          if (((List)paramList.get(i)).isEmpty())
          {
            AppMethodBeat.o(120537);
            return true;
          }
          if (((com.tencent.mm.plugin.story.f.d.h)this.FHH.get(i)).FoT.ecf != ((com.tencent.mm.plugin.story.f.d.h)((List)paramList.get(i)).get(0)).FoT.ecf)
          {
            AppMethodBeat.o(120537);
            return true;
          }
          i += 1;
        }
        AppMethodBeat.o(120537);
        return false;
      }
      AppMethodBeat.o(120537);
      return true;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<kotlin.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      b(m.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<kotlin.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      c(m.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<kotlin.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      d(m.a parama)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "", "positionV", "", "positionH", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "quota", "connectionCount", "(IILcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;II)V", "cdnMediaId", "", "getCdnMediaId", "()Ljava/lang/String;", "setCdnMediaId", "(Ljava/lang/String;)V", "getConnectionCount", "()I", "setConnectionCount", "(I)V", "getItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getPositionH", "getPositionV", "getQuota", "setQuota", "info", "plugin-story_release"})
  public static final class c
  {
    private final int FHJ;
    private final int FHK;
    final com.tencent.mm.plugin.story.f.d.j FHP;
    private int connectionCount;
    int gsw;
    String jpT;
    
    public c(int paramInt1, int paramInt2, com.tencent.mm.plugin.story.f.d.j paramj, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(120546);
      this.FHJ = paramInt1;
      this.FHK = paramInt2;
      this.FHP = paramj;
      this.gsw = paramInt3;
      this.connectionCount = paramInt4;
      paramj = com.tencent.mm.plugin.story.f.s.Fny;
      String str = com.tencent.mm.plugin.story.f.s.cs(this.FHP.iXu, this.FHP.Fpd.Url);
      paramj = str;
      if (str == null) {
        paramj = "";
      }
      this.jpT = paramj;
      AppMethodBeat.o(120546);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "startTick", "", "(J)V", "onPreloadCompleted", "", "mediaId", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-story_release"})
  static final class d
    implements g.b
  {
    private final long gXF;
    
    public d(long paramLong)
    {
      this.gXF = paramLong;
    }
    
    public final void b(String paramString, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(120548);
      Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", sceneResult:" + paramd);
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", video source change!");
        paramd = m.FHB;
        m.aSE(paramString);
        AppMethodBeat.o(120548);
        return;
      }
      if ((paramString != null) && (paramd != null))
      {
        Object localObject = m.FHB;
        if (m.fsA().containsKey(paramString))
        {
          localObject = m.FHB;
          localObject = (com.tencent.mm.plugin.story.f.d.j)m.fsA().get(paramString);
          if (localObject != null)
          {
            if ((paramd.field_recvedBytes > 0L) && (paramd.field_fileLength > 0L))
            {
              com.tencent.mm.plugin.story.f.s locals = com.tencent.mm.plugin.story.f.s.Fny;
              localObject = com.tencent.mm.plugin.story.f.s.a((com.tencent.mm.plugin.story.f.d.j)localObject);
              ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize = ((int)paramd.field_recvedBytes);
              ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize = ((int)paramd.field_fileLength);
              paramd = com.tencent.mm.plugin.story.f.j.Fmy;
              j.b.fog().b((com.tencent.mm.plugin.story.i.n)localObject);
              paramd = m.FHB;
              m.fsB().add(paramString);
              Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted update cacheSize:" + ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize + ", totalSize:" + ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize + ", preloadCost:" + Util.ticksToNow(this.gXF));
              com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(paramString));
              AppMethodBeat.o(120548);
              return;
            }
            Log.e("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted error, recvedBytes:" + paramd.field_recvedBytes + ", fileLength:" + paramd.field_fileLength);
          }
        }
      }
      AppMethodBeat.o(120548);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(String paramString)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "()V", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  static final class e
    implements g.a
  {
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(120549);
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreload, mediaId:" + paramString + ", video source change!");
        paramc = m.FHB;
        m.aSE(paramString);
        AppMethodBeat.o(120549);
        return 0;
      }
      Object localObject1;
      int i;
      if ((paramc != null) && (paramc.field_toltalLength > 0L))
      {
        paramd = m.FHB;
        localObject1 = (com.tencent.mm.plugin.story.f.d.j)m.fsA().get(paramString);
        paramd = m.FHB;
        paramBoolean = kotlin.a.j.a((Iterable)m.fsB(), paramString);
        int j = (int)((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F);
        paramd = m.FHB;
        paramd = (Integer)m.fsC().get(paramString);
        if (paramd == null) {
          break label565;
        }
        i = paramd.intValue();
        paramd = hashCode() + " onPreload, mediaId:" + paramString + ", startRet:" + paramInt + ", preloadOffset:" + paramc.field_finishedLength + ", totalLength: " + paramc.field_toltalLength + " desiredPreloadPercent:" + i + ", preloadPercent:" + j + " isFinish:" + paramBoolean;
        paramInt = 0;
        if ((i <= 0) || (j < i)) {
          break label577;
        }
        paramd = paramd + " exceed:true ";
        paramInt = 1;
      }
      label565:
      label577:
      for (;;)
      {
        if (localObject1 != null)
        {
          Object localObject2 = com.tencent.mm.plugin.story.f.s.Fny;
          localObject2 = com.tencent.mm.plugin.story.f.s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
          ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize = ((int)paramc.field_finishedLength);
          ((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize = ((int)paramc.field_toltalLength);
          paramc = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.fog().b((com.tencent.mm.plugin.story.i.n)localObject2);
          paramc = com.tencent.mm.plugin.story.f.j.Fmy;
          com.tencent.mm.plugin.story.i.f localf = j.b.fod().aRS(((com.tencent.mm.plugin.story.f.d.j)localObject1).username);
          paramc = paramd;
          if (localf.field_syncId == ((com.tencent.mm.plugin.story.f.d.j)localObject1).edx)
          {
            paramc = paramd;
            if (localf.isValid())
            {
              long l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).edx;
              localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).Fpd.Id;
              p.g(localObject1, "videoItem.media.Id");
              paramc = paramd;
              if (localf.b(l, (String)localObject1, ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize))
              {
                paramc = paramd + " * ext pre update * ";
                paramd = com.tencent.mm.plugin.story.f.j.Fmy;
                j.b.fod().a((int)localf.systemRowid, localf);
              }
            }
          }
          if ((paramInt != 0) && (paramString != null))
          {
            paramd = m.FHB;
            m.fsB().add(paramString);
          }
        }
        for (paramString = paramc + "update cacheSize done";; paramString = paramd)
        {
          paramString = new StringBuilder().append(paramString).append(", currentSpeed:");
          paramc = m.FHB;
          Log.i("MicroMsg.StoryVideoPreloadMgr", m.fsz());
          AppMethodBeat.o(120549);
          return 0;
          i = 0;
          break;
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.m
 * JD-Core Version:    0.7.0.1
 */