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
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr;", "", "()V", "MAX_PRELOAD_TASK_LIMIT", "", "TAG", "", "clicfg_story_preload_force_canload", "getClicfg_story_preload_force_canload", "()I", "setClicfg_story_preload_force_canload", "(I)V", "clicfg_story_preload_force_preload", "getClicfg_story_preload_force_preload", "setClicfg_story_preload_force_preload", "clicfg_story_preload_strategy", "getClicfg_story_preload_strategy", "setClicfg_story_preload_strategy", "groupData", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "lastFinishStoryId", "", "getLastFinishStoryId", "()J", "setLastFinishStoryId", "(J)V", "lastStoryId", "getLastStoryId", "setLastStoryId", "playingMediaId", "preLoadConfig", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "getPreLoadConfig", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "setPreLoadConfig", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;)V", "preloadFinishSet", "", "preloadInfoRatioSet", "", "preloadInfoSet", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadRunningSet", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "runningMediaId", "Ljava/lang/Long;", "selectMediaId", "totalPreLoadOneItemSelect", "getTotalPreLoadOneItemSelect", "setTotalPreLoadOneItemSelect", "addPreLoadTask", "", "quota", "fromTag", "connectionCount", "addPreloadVideo", "", "videoItemList", "", "downloadExpect", "calcPreloadPercent", "mediaId", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "cacheSecondsDowngrade", "isGoodNetwork", "cancelAllPreloadTask", "cancelPreloadTask", "videoItem", "checkCanPlay", "item", "checkPreLoad", "checkPreloadOnVideoPlay", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "url", "path", "preloadPercent", "getNetworkSpeed", "isBadNetwork", "isLocalVideo", "makrFinish", "storyId", "markCurrentPlay", "markOnVideoFirstFrameDraw", "needPreLoad", "onVideoSourceChange", "preloadVideoWithPercent", "percent", "taskInfo", "queryQuota", "setPreloadQueueFromGallery", "groupItems", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "positionH", "skipPosition", "startPreLoad", "checkNet", "taskConnectionCount", "index", "upgrades", "GroupData", "MoovReadyInfo", "TaskInfo", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-story_release"})
public final class m
{
  private static long LNz;
  private static long MbA;
  public static final m MbB;
  private static j Mbn;
  private static int Mbo;
  private static int Mbp;
  private static int Mbq;
  private static final Map<String, com.tencent.mm.plugin.story.f.d.j> Mbr;
  private static final Map<String, Integer> Mbs;
  private static final Set<String> Mbt;
  private static final List<c> Mbu;
  private static int Mbv;
  private static a Mbw;
  private static volatile String Mbx;
  private static volatile Long Mby;
  private static long Mbz;
  
  static
  {
    AppMethodBeat.i(120574);
    MbB = new m();
    Mbn = new j();
    Object localObject = Collections.synchronizedMap((Map)new HashMap());
    p.j(localObject, "Collections.synchronized…tring, StoryVideoItem>())");
    Mbr = (Map)localObject;
    localObject = Collections.synchronizedMap((Map)new HashMap());
    p.j(localObject, "Collections.synchronized…p(HashMap<String, Int>())");
    Mbs = (Map)localObject;
    localObject = Collections.synchronizedSet((Set)new HashSet());
    p.j(localObject, "Collections.synchronizedSet(HashSet<String>())");
    Mbt = (Set)localObject;
    localObject = Collections.synchronizedList((List)new LinkedList());
    p.j(localObject, "Collections.synchronized…t(LinkedList<TaskInfo>())");
    Mbu = (List)localObject;
    Mbv = 3;
    Mbw = new a((List)new ArrayList());
    AppMethodBeat.o(120574);
  }
  
  private static int a(String paramString, enu paramenu, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(120569);
    float f = paramenu.UqC;
    Log.i("MicroMsg.StoryVideoPreloadMgr", "calcPreloadPercent, cacheSecondsDowngrade:" + paramInt + ", mediaId:" + paramString + ", duration:" + f + ", isGoodNetwork:" + paramBoolean + " media:" + paramenu.UqC);
    int i;
    if (paramBoolean)
    {
      i = 5;
      if (f > 0.0F) {
        break label134;
      }
      paramInt = Mbn.LZU;
    }
    for (;;)
    {
      i = paramInt;
      if (paramInt <= Mbn.LZU) {
        i = Mbn.LZU;
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
        p.k(paramj, "videoItem");
        p.k(paramc, "taskInfo");
        if ((paramj.gdp()) || (Util.isNullOrNil(paramj.LJf.Url)))
        {
          AppMethodBeat.o(120563);
          bool = false;
          return bool;
        }
        if (i(paramj))
        {
          Log.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, isLocalVideo: " + paramj.LJf.Url);
          AppMethodBeat.o(120563);
          bool = false;
          continue;
        }
        String str2 = paramj.LJf.Url;
        String str1 = paramc.mfu;
        Object localObject1 = s.LHA;
        localObject1 = s.a(paramj);
        Log.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, " + str1 + ", " + paramInt1 + ", playingMediaId:" + Mbx + ", " + ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath + ", " + str2 + "  videoCache " + localObject1);
        if ((str1 == null) || (kotlin.n.n.L(Mbx, str1, false))) {
          break label658;
        }
        Object localObject2 = s.LHA;
        u.bBD(s.bdg(paramj.username));
        p.j(str2, "url");
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
        p.j(localObject1, "videoCache.field_filePath");
        Log.i("MicroMsg.StoryVideoPreloadMgr", "createVideoPreloadCDNTask, mediaId:" + str1 + ", path:" + (String)localObject1 + ", url:" + str2 + ", preloadPercent:" + paramInt1 + ", connectionCount:" + paramInt2);
        localObject2 = new com.tencent.mm.i.h();
        ((com.tencent.mm.i.h)localObject2).taskName = "task_StoryVideoPreloadMgr";
        ((com.tencent.mm.i.h)localObject2).field_mediaId = str1;
        ((com.tencent.mm.i.h)localObject2).url = str2;
        ((com.tencent.mm.i.h)localObject2).iUW = 2;
        ((com.tencent.mm.i.h)localObject2).iVd = 2;
        ((com.tencent.mm.i.h)localObject2).iUX = 6;
        ((com.tencent.mm.i.h)localObject2).iVi = paramInt1;
        ((com.tencent.mm.i.h)localObject2).field_preloadRatio = paramInt1;
        ((com.tencent.mm.i.h)localObject2).concurrentCount = 4;
        ((com.tencent.mm.i.h)localObject2).field_fullpath = ((String)localObject1);
        ((com.tencent.mm.i.h)localObject2).iUG = ((g.a)new e());
        ((com.tencent.mm.i.h)localObject2).iUY = ((g.b)new d(Util.currentTicks()));
        ((com.tencent.mm.i.h)localObject2).connectionCount = paramInt2;
        ((com.tencent.mm.i.h)localObject2).field_fileType = com.tencent.mm.i.a.iUd;
        ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat = e.N(2, (String)localObject1);
        com.tencent.mm.aq.f.bkg().e((com.tencent.mm.i.g)localObject2);
        Log.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent:" + localObject2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2));
        Mbr.put(str1, paramj);
        Mbs.put(str1, Integer.valueOf(paramInt1));
        paramj = Mbu.iterator();
        paramInt1 = 0;
        if (!paramj.hasNext()) {
          break label639;
        }
        if (p.h(((c)paramj.next()).mfu, paramc.mfu))
        {
          if (paramInt1 <= 0) {
            break label644;
          }
          Mbu.set(paramInt1, paramc);
          Mbt.remove(str1);
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
      Mbu.add(paramc);
      continue;
      label658:
      AppMethodBeat.o(120563);
      boolean bool = false;
    }
  }
  
  private static int aiC(int paramInt)
  {
    AppMethodBeat.i(120564);
    Log.i("MicroMsg.StoryVideoPreloadMgr", "taskConnectionCount: ".concat(String.valueOf(paramInt)));
    List localList = Mbn.LZZ;
    if (paramInt < Mbn.LZZ.size()) {}
    for (;;)
    {
      paramInt = ((Number)localList.get(paramInt)).intValue();
      AppMethodBeat.o(120564);
      return paramInt;
      paramInt = Mbn.LZZ.size() - 1;
    }
  }
  
  private static int c(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120556);
    p.k(paramj, "item");
    Object localObject = s.LHA;
    localObject = s.a(paramj);
    if (((com.tencent.mm.plugin.story.i.n)localObject).ggm())
    {
      Log.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay downloadFinish " + paramj.fXG);
      AppMethodBeat.o(120556);
      return 1;
    }
    if (((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(120556);
      return 0;
    }
    if (((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize * 100.0F >= Mbn.LZU)
    {
      Log.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay cachesize " + ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize + " totalSize: " + ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize);
      AppMethodBeat.o(120556);
      return 1;
    }
    AppMethodBeat.o(120556);
    return 0;
  }
  
  private static boolean f(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> arg0, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120551);
    p.k(???, "groupItems");
    Log.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery, galleryItems size:" + ???.size() + ", positionV:" + paramInt1 + "  positionH:" + paramInt2 + ", skipPosition:true");
    Object localObject1 = Mbw;
    p.k(???, "galleryItems");
    int i;
    if (((a)localObject1).ik(???)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(120551);
      return false;
      if ((((a)localObject1).MbK != paramInt2) || (((a)localObject1).MbJ != paramInt1)) {
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
        localObject1 = ((com.tencent.mm.plugin.story.f.d.h)localObject1).LIV;
        if (localObject1 != null) {
          Mbz = ((com.tencent.mm.plugin.story.f.d.j)localObject1).fXG;
        }
      }
    }
    LNz = 0L;
    Mbv = 0;
    Mbw = new a(???, paramInt1, paramInt2, Mbw, true);
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
            kotlin.a.j.iBO();
          }
          localObject5 = (List)localObject5;
          if ((i < paramInt1) || (((List)localObject5).size() <= 0)) {
            break label961;
          }
          ((ArrayList)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.story.f.d.h)((List)localObject5).get(0)).LIV.fWh));
          break label961;
        }
        localObject4 = x.aazN;
        ??? = new ArrayList();
        if ((paramInt1 < ???.size()) && (paramInt2 < ((List)???.get(paramInt1)).size()))
        {
          i = ((List)???.get(paramInt1)).size();
          if (paramInt2 < i)
          {
            ((ArrayList)???).add(Integer.valueOf(((com.tencent.mm.plugin.story.f.d.h)((List)???.get(paramInt1)).get(paramInt2)).LIV.fWh));
            paramInt2 += 1;
          }
        }
      }
      Object localObject4 = (Iterable)Mbu;
      ??? = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      label577:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        c localc = (c)localObject5;
        if ((!((ArrayList)localObject1).contains(Integer.valueOf(localc.MbP.fWh))) && (!((ArrayList)???).contains(Integer.valueOf(localc.MbP.fWh)))) {}
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
          l(((c)((Iterator)localObject1).next()).MbP);
        }
      }
      x localx = x.aazN;
      Mbo = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvx, 1);
      paramInt1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvy, 450);
      paramInt2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvz, 200);
      Mbp = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvA, 0);
      Mbq = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvE, 100);
      Mbn.LZV = paramInt1;
      Mbn.LZW = paramInt2;
      i = CdnLogic.getRecentAverageSpeed(2);
      Log.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery clicfg_story_preload_strategy " + Mbo + " clicfg_story_preload_speed_good:" + paramInt1 + " clicfg_story_preload_speed_bad:" + paramInt2 + " clicfg_story_preload_force_preload " + Mbp + "  clicfg_story_preload_force_canload: " + Mbq + " speed:" + i);
      if ((i > 0) && (Mbq > 0) && (i < Mbq))
      {
        Log.w("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery speed too low then pass " + i + " clicfg_story_preload_force_canload: " + Mbq);
        ??? = new LinkedList();
        ???.addAll((Collection)Mbu);
        ??? = ???.iterator();
        while (???.hasNext()) {
          l(((c)???.next()).MbP);
        }
      }
      AppMethodBeat.o(120551);
      return false;
      label961:
      i += 1;
    }
  }
  
  public static j ggS()
  {
    return Mbn;
  }
  
  private static List<Integer> ggT()
  {
    AppMethodBeat.i(120550);
    if (ggW())
    {
      localList = Mbn.LZY;
      AppMethodBeat.o(120550);
      return localList;
    }
    List localList = Mbn.LZX;
    AppMethodBeat.o(120550);
    return localList;
  }
  
  public static void ggU()
  {
    AppMethodBeat.i(120568);
    Log.printInfoStack("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask", new Object[0]);
    Iterator localIterator = Mbr.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Log.i("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask ".concat(String.valueOf(str)));
      com.tencent.mm.aq.f.bkg().Vz(str);
    }
    Mbr.clear();
    Mbs.clear();
    Mbw = new a((List)new ArrayList());
    Mbu.clear();
    AppMethodBeat.o(120568);
  }
  
  private static boolean ggV()
  {
    AppMethodBeat.i(120570);
    if (CdnLogic.getRecentAverageSpeed(2) >= Mbn.LZV)
    {
      AppMethodBeat.o(120570);
      return true;
    }
    AppMethodBeat.o(120570);
    return false;
  }
  
  private static boolean ggW()
  {
    AppMethodBeat.i(120571);
    int i = Mbn.LZW;
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
  
  public static int ggX()
  {
    AppMethodBeat.i(292867);
    int i = CdnLogic.getRecentAverageSpeed(2);
    AppMethodBeat.o(292867);
    return i;
  }
  
  private static boolean i(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120562);
    if (paramj.gdp())
    {
      AppMethodBeat.o(120562);
      return true;
    }
    s locals = s.LHA;
    if (u.bBQ(s.a(paramj.LJf)) > 0L)
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", "isLocalVideo video downloadDone " + paramj.LJf.taskId + " username:" + paramj.username);
      AppMethodBeat.o(120562);
      return true;
    }
    locals = s.LHA;
    if (s.a(paramj).ggm())
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", " isLocalVideo video download finish " + paramj.LJf.taskId + " username:" + paramj.username);
      AppMethodBeat.o(120562);
      return true;
    }
    AppMethodBeat.o(120562);
    return false;
  }
  
  public static void j(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120565);
    p.k(paramj, "videoItem");
    Object localObject = s.LHA;
    localObject = s.cs(paramj.createTime, paramj.LJf.Url);
    Mbx = (String)localObject;
    Mby = Long.valueOf(paramj.fXG);
    Log.i("MicroMsg.StoryVideoPreloadMgr", "markCurrentPlay:" + Mbx + " then remove it from preload");
    Iterator localIterator = ((Iterable)Mbu).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!p.h(localObject, ((c)paramj).mfu));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj == null) {
        break;
      }
      Mbu.remove(paramj);
      l(paramj.MbP);
      AppMethodBeat.o(120565);
      return;
      paramj = null;
    }
    AppMethodBeat.o(120565);
  }
  
  public static b k(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120566);
    p.k(paramj, "videoItem");
    Object localObject1 = s.LHA;
    localObject1 = s.cs(paramj.createTime, paramj.LJf.Url);
    Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreloadOnVideoPlay:".concat(String.valueOf(localObject1)));
    Object localObject2 = s.LHA;
    localObject2 = s.a(paramj);
    if ((((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize > 0) && (((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize > 0))
    {
      float f = ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize;
      Log.i("MicroMsg.StoryVideoPreloadMgr", "hit cache, mediaId:" + (String)localObject1 + ", cachePercent:" + f + ", filePath:" + ((com.tencent.mm.plugin.story.i.n)localObject2).field_filePath);
      localObject2 = ((com.tencent.mm.plugin.story.i.n)localObject2).field_filePath;
      CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      long[] arrayOfLong = new long[2];
      localC2CDownloadRequest.fileKey = ((String)localObject1);
      localC2CDownloadRequest.fileType = 6;
      localC2CDownloadRequest.url = paramj.LJf.Url;
      localC2CDownloadRequest.setSavePath((String)localObject2);
      localC2CDownloadRequest.requestVideoFormat = e.N(1, (String)localObject2);
      boolean bool = CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong);
      Log.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " queryMoovReady: " + bool + ", offset:" + arrayOfLong[0] + ", length:" + arrayOfLong[1] + ", preloadFinish:" + kotlin.a.j.a((Iterable)Mbt, localObject1));
      paramj = new b(true, arrayOfLong[0], arrayOfLong[1], kotlin.a.j.a((Iterable)Mbt, localObject1));
      AppMethodBeat.o(120566);
      return paramj;
    }
    Log.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " not hit cache or moov not ready");
    paramj = new b(false, 0L, 0L, false);
    AppMethodBeat.o(120566);
    return paramj;
  }
  
  private static void l(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120567);
    p.k(paramj, "videoItem");
    Object localObject = s.LHA;
    localObject = s.cs(paramj.createTime, paramj.LJf.Url);
    Log.i("MicroMsg.StoryVideoPreloadMgr", "cancelPreloadTask, videoItem:".concat(String.valueOf(localObject)));
    com.tencent.mm.aq.f.bkg().Vz((String)localObject);
    Iterator localIterator = ((Iterable)Mbu).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!p.h(((c)paramj).mfu, localObject));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj == null) {
        break;
      }
      Mbu.remove(paramj);
      if (Mbv > 0) {
        Mbv -= 1;
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
    if ((i(paramj)) || (paramj.gdp()))
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo fail, " + paramj + " isLocalVideo or fake video");
      AppMethodBeat.o(120573);
      return false;
    }
    Object localObject = s.LHA;
    localObject = s.cs(paramj.createTime, paramj.LJf.Url);
    if ((!Util.isNullOrNil((String)localObject)) && (!Util.isNullOrNil(paramj.LJf.Url)) && (!kotlin.n.n.L(Mbx, (String)localObject, false)))
    {
      AppMethodBeat.o(120573);
      return true;
    }
    Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo:" + (String)localObject + ", already request preload or url " + paramj.LJf.Url);
    AppMethodBeat.o(120573);
    return false;
  }
  
  private final boolean w(int paramInt1, String paramString, int paramInt2)
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
        Object localObject1 = Mbw;
        i = 0;
        localo = null;
        while ((i < ((a)localObject1).MbI.size()) && (localo == null))
        {
          localo = ((a)localObject1).ghb();
          Log.i(a.TAG, "produceVideoItem walkVertical:" + ((a)localObject1).MbD + "  walkHorizontal:" + ((a)localObject1).MbE + " positionV:" + ((a)localObject1).MbJ + " positionH:" + ((a)localObject1).MbK + ", ret:" + localo);
          i += 1;
        }
        if (localo == null)
        {
          AppMethodBeat.o(120558);
          return false;
        }
        localj = (com.tencent.mm.plugin.story.f.d.j)localo.Mx;
        String str = ((c)localo.My).mfu;
        localObject1 = new StringBuilder("try preload mediaId ").append(str).append(" videoItem:").append(localj).append(" pos:").append((c)localo.My).append("  groupinfo ");
        Object localObject2 = Mbw;
        Log.i("MicroMsg.StoryVideoPreloadMgr", new StringBuilder("positionV:").append(((a)localObject2).MbJ).append(", positionH:").append(((a)localObject2).MbK).append(", walkVertical:").append(((a)localObject2).MbD).append(", walkHorizontal:").append(((a)localObject2).MbE).toString() + " quota:" + paramInt1 + "  fromTag:" + paramString);
        localObject2 = ((Iterable)Mbu).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
        } while (!p.h(((c)localObject1).mfu, str));
        for (;;)
        {
          localObject1 = (c)localObject1;
          if ((localObject1 == null) || (paramInt1 > ((c)localObject1).iWI)) {
            break label453;
          }
          Log.i("MicroMsg.StoryVideoPreloadMgr", "no need add quota " + paramInt1 + " cur:" + ((c)localObject1).iWI + " fromTag:" + paramString);
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
          i = a(str, localj.LJf, paramInt1, ggV());
          localObject1 = s.LHA;
          localObject1 = s.a(localj);
          if ((!((com.tencent.mm.plugin.story.i.n)localObject1).ggm()) && (((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize * 100.0F < i)) {
            break label646;
          }
          Log.i("MicroMsg.StoryVideoPreloadMgr", "pull preload video, " + str + ", already reach cache size! cacheSize:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize + ", totalSize:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize + ", cachePercent:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize * 100.0F + "  fromTag:" + paramString);
          break;
          i = 0;
          break label469;
        }
      }
    } while (!localm.a(localj, i, paramInt2, (c)localo.My));
    label640:
    label644:
    label646:
    ((c)localo.My).iWI = paramInt1;
    AppMethodBeat.o(120558);
    return true;
  }
  
  private final void zI(boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(120557);
    boolean bool1 = ggV();
    boolean bool2 = ggW();
    int i = CdnLogic.getRecentAverageSpeed(2);
    if ((paramBoolean) && (i > 0) && (Mbq > 0) && (i < Mbq))
    {
      Log.w("MicroMsg.StoryVideoPreloadMgr", "speed too low then pass " + i + " clicfg_story_preload_force_canload: " + Mbq + " callerFrom " + MMStack.getCaller());
      AppMethodBeat.o(120557);
      return;
    }
    int j = 0;
    if (bool2) {}
    for (i = 1;; i = 3)
    {
      if (Mbo == 1) {
        i = k;
      }
      for (;;)
      {
        Log.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + Mbu.size() + " maxTaskNum " + i + " totalPreLoadOneItemSelect " + Mbv + " checkNet " + paramBoolean + " callerFrom " + MMStack.getCaller());
        List localList = ggT();
        while ((Mbu.size() < i) && (j < localList.size()) && (Mbv < 3) && (w(((Number)localList.get(j)).intValue(), "startPreLoad", aiC(j))))
        {
          Mbv += 1;
          j += 1;
        }
        Log.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue finish loop preload queue, current queue size: " + Mbu.size() + ", pullPreloadTaskNum:0, preloadVideoNum:" + j + " preloadRunningSet " + Mbu.size() + " totalPreLoadOneItemSelect " + Mbv + ' ');
        AppMethodBeat.o(120557);
        return;
      }
    }
  }
  
  public final void D(List<com.tencent.mm.plugin.story.f.d.j> paramList, int paramInt)
  {
    AppMethodBeat.i(120560);
    p.k(paramList, "videoItemList");
    Log.printInfoStack("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList " + paramList.size(), new Object[0]);
    boolean bool1 = ggV();
    boolean bool2 = ggW();
    Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + Mbu.size() + " downloadExpect " + paramInt);
    List localList = ggT();
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
          k = aiC(j);
          paramList = s.LHA;
          str = s.cs(localj.createTime, localj.LJf.Url);
          m = a(str, localj.LJf, i, ggV());
          paramList = s.LHA;
          localn = s.a(localj);
          Iterator localIterator2 = ((Iterable)Mbu).iterator();
          if (!localIterator2.hasNext()) {
            break label598;
          }
          paramList = localIterator2.next();
          if (!p.h(((c)paramList).mfu, str)) {
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
        i = ((Number)kotlin.a.j.lq(localList)).intValue();
        continue;
        label389:
        if ((localn.ggm()) || (localn.field_cacheSize / localn.field_totalSize * 100.0F >= m))
        {
          Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already reach cache size! cacheSize:" + localn.field_cacheSize + ", totalSize:" + localn.field_totalSize + ", cachePercent:" + localn.field_cacheSize / localn.field_totalSize * 100.0F);
        }
        else
        {
          paramList = new c(0, j, localj, i, k);
          if (MbB.a(localj, m, k, paramList))
          {
            j += 1;
            continue;
            label543:
            paramList = x.aazN;
            Log.i("MicroMsg.StoryVideoPreloadMgr", "finish addPreloadVideo withList, total pull video task:" + j + " preloadRunningSet " + Mbu.size());
            AppMethodBeat.o(120560);
            return;
            label598:
            paramList = null;
          }
        }
      }
    }
  }
  
  public final void RX(long paramLong)
  {
    AppMethodBeat.i(120553);
    if (LNz == paramLong)
    {
      AppMethodBeat.o(120553);
      return;
    }
    LNz = paramLong;
    if (Mbo == 0)
    {
      AppMethodBeat.o(120553);
      return;
    }
    a locala = Mbw;
    if (locala != null) {
      locala.ghc();
    }
    zI(true);
    AppMethodBeat.o(120553);
  }
  
  public final void RY(long paramLong)
  {
    AppMethodBeat.i(120554);
    Object localObject = Mby;
    if (localObject == null) {}
    while (MbA == paramLong)
    {
      AppMethodBeat.o(120554);
      return;
      if (((Long)localObject).longValue() == paramLong) {
        Mby = Long.valueOf(0L);
      }
    }
    MbA = paramLong;
    if (Mbo == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (Mbq == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (Mbu.size() > 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    localObject = Mbw;
    if (localObject != null) {
      ((a)localObject).ghc();
    }
    zI(false);
    AppMethodBeat.o(120554);
  }
  
  public final void h(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120555);
    p.k(paramj, "item");
    Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad " + paramj + ' ' + MMStack.getCaller());
    if (i(paramj))
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay isLocalVideo");
      zI(false);
      AppMethodBeat.o(120555);
      return;
    }
    if (c(paramj) == 1)
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay true");
      zI(true);
      AppMethodBeat.o(120555);
      return;
    }
    if (Mbp == 1) {
      zI(true);
    }
    Log.i("MicroMsg.StoryVideoPreloadMgr", "nothing can checkPreLoad");
    AppMethodBeat.o(120555);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "", "groupItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "", "positionH", "lastGroup", "skipPosition", "", "(Ljava/util/List;IILcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;Z)V", "MAX_PRELOAD_COUNT", "horizontalList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "produceList", "Lkotlin/Function0;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "verticalList", "walkHorizontal", "walkIndex", "walkVertical", "info", "", "isDataChange", "isSame", "galleryItems", "produce", "produceHorizontalVideoItem", "produceVerticalVideoItem", "produceVideoItem", "reset", "", "resetWalk", "Companion", "plugin-story_release"})
  public static final class a
  {
    public static final a MbM;
    static final String TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
    private final int MbC;
    int MbD;
    int MbE;
    private int MbF;
    private ArrayList<com.tencent.mm.plugin.story.f.d.h> MbG;
    private ArrayList<com.tencent.mm.plugin.story.f.d.h> MbH;
    List<? extends kotlin.g.a.a<kotlin.o<com.tencent.mm.plugin.story.f.d.j, m.c>>> MbI;
    int MbJ;
    int MbK;
    private final boolean MbL;
    
    static
    {
      AppMethodBeat.i(120542);
      MbM = new a((byte)0);
      TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
      AppMethodBeat.o(120542);
    }
    
    public a(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> arg1, int paramInt1, int paramInt2, a arg4, boolean paramBoolean)
    {
      AppMethodBeat.i(212971);
      this.MbJ = paramInt1;
      this.MbK = paramInt2;
      this.MbL = true;
      this.MbC = 15;
      this.MbG = new ArrayList();
      this.MbH = new ArrayList();
      this.MbI = kotlin.a.j.listOf(new kotlin.g.a.a[] { (kotlin.g.a.a)new b(this), (kotlin.g.a.a)new c(this), (kotlin.g.a.a)new d(this) });
      if (((??? != null) && (this.MbJ != ???.MbJ)) || ((??? != null) && (this.MbK != ???.MbK)) || (ik(???))) {
        reset();
      }
      this.MbG.clear();
      this.MbH.clear();
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
            this.MbH.add(localList.get(0));
          }
        }
        paramInt1 = 0;
      }
      Object localObject = x.aazN;
      if (this.MbJ < ???.size())
      {
        synchronized ((Iterable)???.get(this.MbJ))
        {
          ??? = ???.iterator();
          if (???.hasNext())
          {
            localObject = (com.tencent.mm.plugin.story.f.d.h)???.next();
            this.MbG.add(localObject);
          }
        }
        ??? = x.aazN;
        AppMethodBeat.o(212971);
        return;
      }
      AppMethodBeat.o(212971);
    }
    
    private final kotlin.o<com.tencent.mm.plugin.story.f.d.j, m.c> ghd()
    {
      AppMethodBeat.i(120539);
      for (;;)
      {
        if (this.MbL) {
          this.MbD += 1;
        }
        if (this.MbD >= this.MbH.size())
        {
          AppMethodBeat.o(120539);
          return null;
        }
        try
        {
          if (this.MbH.size() > 0)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)this.MbH.get(this.MbD)).LIV;
            m localm = m.MbB;
            if (m.n((com.tencent.mm.plugin.story.f.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new kotlin.o(localObject1, new m.c(this.MbD, 0, (com.tencent.mm.plugin.story.f.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.MbL) {
            continue;
          }
          this.MbD += 1;
        }
        finally
        {
          if (!this.MbL) {
            this.MbD += 1;
          }
          AppMethodBeat.o(120539);
        }
      }
    }
    
    private final kotlin.o<com.tencent.mm.plugin.story.f.d.j, m.c> ghe()
    {
      AppMethodBeat.i(120540);
      for (;;)
      {
        if (this.MbL) {
          this.MbE += 1;
        }
        if (this.MbE >= this.MbG.size())
        {
          AppMethodBeat.o(120540);
          return null;
        }
        try
        {
          if (this.MbG.size() > this.MbE)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)this.MbG.get(this.MbE)).LIV;
            m localm = m.MbB;
            if (m.n((com.tencent.mm.plugin.story.f.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new kotlin.o(localObject1, new m.c(this.MbD, this.MbE, (com.tencent.mm.plugin.story.f.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.MbL) {
            continue;
          }
          this.MbE += 1;
        }
        finally
        {
          if (!this.MbL) {
            this.MbE += 1;
          }
          AppMethodBeat.o(120540);
        }
      }
    }
    
    private final void reset()
    {
      this.MbD = this.MbJ;
      this.MbE = this.MbK;
      this.MbF = 0;
    }
    
    final kotlin.o<com.tencent.mm.plugin.story.f.d.j, m.c> ghb()
    {
      AppMethodBeat.i(120536);
      try
      {
        if (this.MbF > this.MbC)
        {
          Log.i(TAG, "stop preload now " + this.MbF);
          AppMethodBeat.o(120536);
          return null;
        }
        kotlin.o localo = (kotlin.o)((kotlin.g.a.a)this.MbI.get(this.MbF % this.MbI.size())).invoke();
        this.MbF += 1;
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
    
    public final void ghc()
    {
      AppMethodBeat.i(120538);
      Log.i(TAG, "resetWalk");
      reset();
      AppMethodBeat.o(120538);
    }
    
    final boolean ik(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> paramList)
    {
      AppMethodBeat.i(120537);
      if (paramList.size() == this.MbH.size())
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
          if (((com.tencent.mm.plugin.story.f.d.h)this.MbH.get(i)).LIV.fWh != ((com.tencent.mm.plugin.story.f.d.h)((List)paramList.get(i)).get(0)).LIV.fWh)
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
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<kotlin.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      b(m.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<kotlin.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      c(m.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "", "isMoovReady", "", "offset", "", "length", "preloadFinish", "(ZJJZ)V", "()Z", "getLength", "()J", "getOffset", "getPreloadFinish", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-story_release"})
  public static final class b
  {
    final boolean MbO;
    final long aFL;
    final long offset;
    final boolean zKm;
    
    public b(boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
    {
      this.zKm = paramBoolean1;
      this.offset = paramLong1;
      this.aFL = paramLong2;
      this.MbO = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.zKm != paramObject.zKm) || (this.offset != paramObject.offset) || (this.aFL != paramObject.aFL) || (this.MbO != paramObject.MbO)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(120545);
      String str = "MoovReadyInfo(isMoovReady=" + this.zKm + ", offset=" + this.offset + ", length=" + this.aFL + ", preloadFinish=" + this.MbO + ")";
      AppMethodBeat.o(120545);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "", "positionV", "", "positionH", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "quota", "connectionCount", "(IILcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;II)V", "cdnMediaId", "", "getCdnMediaId", "()Ljava/lang/String;", "setCdnMediaId", "(Ljava/lang/String;)V", "getConnectionCount", "()I", "setConnectionCount", "(I)V", "getItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getPositionH", "getPositionV", "getQuota", "setQuota", "info", "plugin-story_release"})
  public static final class c
  {
    private final int MbJ;
    private final int MbK;
    final com.tencent.mm.plugin.story.f.d.j MbP;
    private int connectionCount;
    int iWI;
    String mfu;
    
    public c(int paramInt1, int paramInt2, com.tencent.mm.plugin.story.f.d.j paramj, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(120546);
      this.MbJ = paramInt1;
      this.MbK = paramInt2;
      this.MbP = paramj;
      this.iWI = paramInt3;
      this.connectionCount = paramInt4;
      paramj = s.LHA;
      String str = s.cs(this.MbP.createTime, this.MbP.LJf.Url);
      paramj = str;
      if (str == null) {
        paramj = "";
      }
      this.mfu = paramj;
      AppMethodBeat.o(120546);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "startTick", "", "(J)V", "onPreloadCompleted", "", "mediaId", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-story_release"})
  static final class d
    implements g.b
  {
    private final long jID;
    
    public d(long paramLong)
    {
      this.jID = paramLong;
    }
    
    public final void b(String paramString, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(120548);
      Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", sceneResult:" + paramd);
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", video source change!");
        paramd = m.MbB;
        m.bdI(paramString);
        AppMethodBeat.o(120548);
        return;
      }
      if ((paramString != null) && (paramd != null))
      {
        Object localObject = m.MbB;
        if (m.ggY().containsKey(paramString))
        {
          localObject = m.MbB;
          localObject = (com.tencent.mm.plugin.story.f.d.j)m.ggY().get(paramString);
          if (localObject != null)
          {
            if ((paramd.field_recvedBytes > 0L) && (paramd.field_fileLength > 0L))
            {
              s locals = s.LHA;
              localObject = s.a((com.tencent.mm.plugin.story.f.d.j)localObject);
              ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize = ((int)paramd.field_recvedBytes);
              ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize = ((int)paramd.field_fileLength);
              paramd = com.tencent.mm.plugin.story.f.j.LGA;
              j.b.gcA().b((com.tencent.mm.plugin.story.i.n)localObject);
              paramd = m.MbB;
              m.ggZ().add(paramString);
              Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted update cacheSize:" + ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize + ", totalSize:" + ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize + ", preloadCost:" + Util.ticksToNow(this.jID));
              com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramString));
              AppMethodBeat.o(120548);
              return;
            }
            Log.e("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted error, recvedBytes:" + paramd.field_recvedBytes + ", fileLength:" + paramd.field_fileLength);
          }
        }
      }
      AppMethodBeat.o(120548);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "()V", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  static final class e
    implements g.a
  {
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(120549);
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreload, mediaId:" + paramString + ", video source change!");
        paramc = m.MbB;
        m.bdI(paramString);
        AppMethodBeat.o(120549);
        return 0;
      }
      Object localObject1;
      int i;
      if ((paramc != null) && (paramc.field_toltalLength > 0L))
      {
        paramd = m.MbB;
        localObject1 = (com.tencent.mm.plugin.story.f.d.j)m.ggY().get(paramString);
        paramd = m.MbB;
        paramBoolean = kotlin.a.j.a((Iterable)m.ggZ(), paramString);
        int j = (int)((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F);
        paramd = m.MbB;
        paramd = (Integer)m.gha().get(paramString);
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
          Object localObject2 = s.LHA;
          localObject2 = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
          ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize = ((int)paramc.field_finishedLength);
          ((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize = ((int)paramc.field_toltalLength);
          paramc = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.gcA().b((com.tencent.mm.plugin.story.i.n)localObject2);
          paramc = com.tencent.mm.plugin.story.f.j.LGA;
          com.tencent.mm.plugin.story.i.f localf = j.b.gcx().bcW(((com.tencent.mm.plugin.story.f.d.j)localObject1).username);
          paramc = paramd;
          if (localf.field_syncId == ((com.tencent.mm.plugin.story.f.d.j)localObject1).fXG)
          {
            paramc = paramd;
            if (localf.isValid())
            {
              long l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).fXG;
              localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).LJf.Id;
              p.j(localObject1, "videoItem.media.Id");
              paramc = paramd;
              if (localf.c(l, (String)localObject1, ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize))
              {
                paramc = paramd + " * ext pre update * ";
                paramd = com.tencent.mm.plugin.story.f.j.LGA;
                j.b.gcx().a((int)localf.systemRowid, localf);
              }
            }
          }
          if ((paramInt != 0) && (paramString != null))
          {
            paramd = m.MbB;
            m.ggZ().add(paramString);
          }
        }
        for (paramString = paramc + "update cacheSize done";; paramString = paramd)
        {
          paramString = new StringBuilder().append(paramString).append(", currentSpeed:");
          paramc = m.MbB;
          Log.i("MicroMsg.StoryVideoPreloadMgr", m.ggX());
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