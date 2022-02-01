package com.tencent.mm.plugin.story.ui.view.gallery;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.y;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr;", "", "()V", "MAX_PRELOAD_TASK_LIMIT", "", "TAG", "", "clicfg_story_preload_force_canload", "getClicfg_story_preload_force_canload", "()I", "setClicfg_story_preload_force_canload", "(I)V", "clicfg_story_preload_force_preload", "getClicfg_story_preload_force_preload", "setClicfg_story_preload_force_preload", "clicfg_story_preload_strategy", "getClicfg_story_preload_strategy", "setClicfg_story_preload_strategy", "groupData", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "lastFinishStoryId", "", "getLastFinishStoryId", "()J", "setLastFinishStoryId", "(J)V", "lastStoryId", "getLastStoryId", "setLastStoryId", "playingMediaId", "preLoadConfig", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "getPreLoadConfig", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "setPreLoadConfig", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;)V", "preloadFinishSet", "", "preloadInfoRatioSet", "", "preloadInfoSet", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadRunningSet", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "runningMediaId", "Ljava/lang/Long;", "selectMediaId", "totalPreLoadOneItemSelect", "getTotalPreLoadOneItemSelect", "setTotalPreLoadOneItemSelect", "addPreLoadTask", "", "quota", "fromTag", "connectionCount", "addPreloadVideo", "", "videoItemList", "", "downloadExpect", "calcPreloadPercent", "mediaId", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "cacheSecondsDowngrade", "isGoodNetwork", "cancelAllPreloadTask", "cancelPreloadTask", "videoItem", "checkCanPlay", "item", "checkPreLoad", "checkPreloadOnVideoPlay", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "url", "path", "preloadPercent", "getNetworkSpeed", "isBadNetwork", "isLocalVideo", "makrFinish", "storyId", "markCurrentPlay", "markOnVideoFirstFrameDraw", "needPreLoad", "onVideoSourceChange", "preloadVideoWithPercent", "percent", "taskInfo", "queryQuota", "setPreloadQueueFromGallery", "groupItems", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "positionH", "skipPosition", "startPreLoad", "checkNet", "taskConnectionCount", "index", "upgrades", "GroupData", "MoovReadyInfo", "TaskInfo", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-story_release"})
public final class m
{
  private static volatile Long yAA;
  private static long yAB;
  private static long yAC;
  public static final m yAD;
  private static j yAp;
  private static int yAq;
  private static int yAr;
  private static int yAs;
  private static final Map<String, com.tencent.mm.plugin.story.f.d.j> yAt;
  private static final Map<String, Integer> yAu;
  private static final Set<String> yAv;
  private static final List<c> yAw;
  private static int yAx;
  private static a yAy;
  private static volatile String yAz;
  private static long ymk;
  
  static
  {
    AppMethodBeat.i(120574);
    yAD = new m();
    yAp = new j();
    Object localObject = Collections.synchronizedMap((Map)new HashMap());
    k.g(localObject, "Collections.synchronized…tring, StoryVideoItem>())");
    yAt = (Map)localObject;
    localObject = Collections.synchronizedMap((Map)new HashMap());
    k.g(localObject, "Collections.synchronized…p(HashMap<String, Int>())");
    yAu = (Map)localObject;
    localObject = Collections.synchronizedSet((Set)new HashSet());
    k.g(localObject, "Collections.synchronizedSet(HashSet<String>())");
    yAv = (Set)localObject;
    localObject = Collections.synchronizedList((List)new LinkedList());
    k.g(localObject, "Collections.synchronized…t(LinkedList<TaskInfo>())");
    yAw = (List)localObject;
    yAx = 3;
    yAy = new a((List)new ArrayList());
    AppMethodBeat.o(120574);
  }
  
  private static int OP(int paramInt)
  {
    AppMethodBeat.i(120564);
    ad.i("MicroMsg.StoryVideoPreloadMgr", "taskConnectionCount: ".concat(String.valueOf(paramInt)));
    List localList = yAp.yzb;
    if (paramInt < yAp.yzb.size()) {}
    for (;;)
    {
      paramInt = ((Number)localList.get(paramInt)).intValue();
      AppMethodBeat.o(120564);
      return paramInt;
      paramInt = yAp.yzb.size() - 1;
    }
  }
  
  private static int a(String paramString, cym paramcym, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(120569);
    float f = paramcym.EqD;
    ad.i("MicroMsg.StoryVideoPreloadMgr", "calcPreloadPercent, cacheSecondsDowngrade:" + paramInt + ", mediaId:" + paramString + ", duration:" + f + ", isGoodNetwork:" + paramBoolean + " media:" + paramcym.EqD);
    int i;
    if (paramBoolean)
    {
      i = 5;
      if (f > 0.0F) {
        break label135;
      }
      paramInt = yAp.yyW;
    }
    for (;;)
    {
      i = paramInt;
      if (paramInt <= yAp.yyW) {
        i = yAp.yyW;
      }
      AppMethodBeat.o(120569);
      return i;
      i = 3;
      break;
      label135:
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
        k.h(paramj, "videoItem");
        k.h(paramc, "taskInfo");
        if ((paramj.dHW()) || (bt.isNullOrNil(paramj.yhP.Url)))
        {
          AppMethodBeat.o(120563);
          bool = false;
          return bool;
        }
        if (i(paramj))
        {
          ad.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, isLocalVideo: " + paramj.yhP.Url);
          AppMethodBeat.o(120563);
          bool = false;
          continue;
        }
        String str2 = paramj.yhP.Url;
        String str1 = paramc.hxP;
        Object localObject1 = s.ygj;
        localObject1 = s.a(paramj);
        ad.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, " + str1 + ", " + paramInt1 + ", playingMediaId:" + yAz + ", " + ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath + ", " + str2 + "  videoCache " + localObject1);
        if ((str1 == null) || (d.n.n.I(yAz, str1, false))) {
          break label646;
        }
        Object localObject2 = s.ygj;
        i.aMF(s.arB(paramj.username));
        k.g(str2, "url");
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
        k.g(localObject1, "videoCache.field_filePath");
        ad.i("MicroMsg.StoryVideoPreloadMgr", "createVideoPreloadCDNTask, mediaId:" + str1 + ", path:" + (String)localObject1 + ", url:" + str2 + ", preloadPercent:" + paramInt1 + ", connectionCount:" + paramInt2);
        localObject2 = new com.tencent.mm.i.h();
        ((com.tencent.mm.i.h)localObject2).field_mediaId = str1;
        ((com.tencent.mm.i.h)localObject2).url = str2;
        ((com.tencent.mm.i.h)localObject2).fnW = 2;
        ((com.tencent.mm.i.h)localObject2).foc = 2;
        ((com.tencent.mm.i.h)localObject2).fnX = 6;
        ((com.tencent.mm.i.h)localObject2).foh = paramInt1;
        ((com.tencent.mm.i.h)localObject2).field_preloadRatio = paramInt1;
        ((com.tencent.mm.i.h)localObject2).concurrentCount = 4;
        ((com.tencent.mm.i.h)localObject2).field_fullpath = ((String)localObject1);
        ((com.tencent.mm.i.h)localObject2).fnH = ((g.a)new e());
        ((com.tencent.mm.i.h)localObject2).fnY = ((g.b)new d(bt.GC()));
        ((com.tencent.mm.i.h)localObject2).connectionCount = paramInt2;
        ((com.tencent.mm.i.h)localObject2).field_fileType = com.tencent.mm.i.a.fne;
        ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.H(2, (String)localObject1);
        com.tencent.mm.ao.f.awL().d((com.tencent.mm.i.g)localObject2);
        ad.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent:" + localObject2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2));
        yAt.put(str1, paramj);
        yAu.put(str1, Integer.valueOf(paramInt1));
        paramj = yAw.iterator();
        paramInt1 = 0;
        if (!paramj.hasNext()) {
          break label627;
        }
        if (k.g(((c)paramj.next()).hxP, paramc.hxP))
        {
          if (paramInt1 <= 0) {
            break label632;
          }
          yAw.set(paramInt1, paramc);
          yAv.remove(str1);
          bool = true;
          AppMethodBeat.o(120563);
          continue;
        }
        paramInt1 += 1;
      }
      finally {}
      continue;
      label627:
      paramInt1 = -1;
      continue;
      label632:
      yAw.add(paramc);
      continue;
      label646:
      AppMethodBeat.o(120563);
      boolean bool = false;
    }
  }
  
  private static int c(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120556);
    k.h(paramj, "item");
    Object localObject = s.ygj;
    localObject = s.a(paramj);
    if (((com.tencent.mm.plugin.story.i.n)localObject).dKR())
    {
      ad.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay downloadFinish " + paramj.dAu);
      AppMethodBeat.o(120556);
      return 1;
    }
    if (((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(120556);
      return 0;
    }
    if (((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize * 100.0F >= yAp.yyW)
    {
      ad.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay cachesize " + ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize + " totalSize: " + ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize);
      AppMethodBeat.o(120556);
      return 1;
    }
    AppMethodBeat.o(120556);
    return 0;
  }
  
  private static boolean d(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> arg0, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120551);
    k.h(???, "groupItems");
    ad.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery, galleryItems size:" + ???.size() + ", positionV:" + paramInt1 + "  positionH:" + paramInt2 + ", skipPosition:true");
    Object localObject1 = yAy;
    k.h(???, "galleryItems");
    int i;
    if (((a)localObject1).gf(???)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(120551);
      return false;
      if ((((a)localObject1).yAM != paramInt2) || (((a)localObject1).yAL != paramInt1)) {
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
        localObject1 = ((com.tencent.mm.plugin.story.f.d.h)localObject1).yhF;
        if (localObject1 != null) {
          yAB = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dAu;
        }
      }
    }
    ymk = 0L;
    yAx = 0;
    yAy = new a(???, paramInt1, paramInt2, yAy);
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
            d.a.j.fvx();
          }
          localObject5 = (List)localObject5;
          if ((i < paramInt1) || (((List)localObject5).size() <= 0)) {
            break label957;
          }
          ((ArrayList)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.story.f.d.h)((List)localObject5).get(0)).yhF.dzf));
          break label957;
        }
        localObject4 = y.JfV;
        ??? = new ArrayList();
        if ((paramInt1 < ???.size()) && (paramInt2 < ((List)???.get(paramInt1)).size()))
        {
          i = ((List)???.get(paramInt1)).size();
          if (paramInt2 < i)
          {
            ((ArrayList)???).add(Integer.valueOf(((com.tencent.mm.plugin.story.f.d.h)((List)???.get(paramInt1)).get(paramInt2)).yhF.dzf));
            paramInt2 += 1;
          }
        }
      }
      Object localObject4 = (Iterable)yAw;
      ??? = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      label575:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        c localc = (c)localObject5;
        if ((!((ArrayList)localObject1).contains(Integer.valueOf(localc.yAR.dzf))) && (!((ArrayList)???).contains(Integer.valueOf(localc.yAR.dzf)))) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label575;
          }
          ???.add(localObject5);
          break;
        }
      }
      synchronized ((Iterable)???)
      {
        localObject1 = ???.iterator();
        if (((Iterator)localObject1).hasNext()) {
          l(((c)((Iterator)localObject1).next()).yAR);
        }
      }
      y localy = y.JfV;
      yAq = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjt, 1);
      paramInt1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pju, 450);
      paramInt2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjv, 200);
      yAr = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjw, 0);
      yAs = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjA, 100);
      yAp.yyX = paramInt1;
      yAp.yyY = paramInt2;
      i = CdnLogic.getRecentAverageSpeed(2);
      ad.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery clicfg_story_preload_strategy " + yAq + " clicfg_story_preload_speed_good:" + paramInt1 + " clicfg_story_preload_speed_bad:" + paramInt2 + " clicfg_story_preload_force_preload " + yAr + "  clicfg_story_preload_force_canload: " + yAs + " speed:" + i);
      if ((i > 0) && (yAs > 0) && (i < yAs))
      {
        ad.w("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery speed too low then pass " + i + " clicfg_story_preload_force_canload: " + yAs);
        ??? = new LinkedList();
        ???.addAll((Collection)yAw);
        ??? = ???.iterator();
        while (???.hasNext()) {
          l(((c)???.next()).yAR);
        }
      }
      AppMethodBeat.o(120551);
      return false;
      label957:
      i += 1;
    }
  }
  
  private static boolean dLA()
  {
    AppMethodBeat.i(120570);
    if (CdnLogic.getRecentAverageSpeed(2) >= yAp.yyX)
    {
      AppMethodBeat.o(120570);
      return true;
    }
    AppMethodBeat.o(120570);
    return false;
  }
  
  private static boolean dLB()
  {
    AppMethodBeat.i(120571);
    int i = yAp.yyY;
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
  
  public static int dLC()
  {
    AppMethodBeat.i(204836);
    int i = CdnLogic.getRecentAverageSpeed(2);
    AppMethodBeat.o(204836);
    return i;
  }
  
  public static j dLx()
  {
    return yAp;
  }
  
  private static List<Integer> dLy()
  {
    AppMethodBeat.i(120550);
    if (dLB())
    {
      localList = yAp.yza;
      AppMethodBeat.o(120550);
      return localList;
    }
    List localList = yAp.yyZ;
    AppMethodBeat.o(120550);
    return localList;
  }
  
  public static void dLz()
  {
    AppMethodBeat.i(120568);
    ad.m("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask", new Object[0]);
    Iterator localIterator = yAt.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ad.i("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask ".concat(String.valueOf(str)));
      com.tencent.mm.ao.f.awL().xL(str);
    }
    yAt.clear();
    yAu.clear();
    yAy = new a((List)new ArrayList());
    yAw.clear();
    AppMethodBeat.o(120568);
  }
  
  private static boolean i(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120562);
    if (paramj.dHW())
    {
      AppMethodBeat.o(120562);
      return true;
    }
    s locals = s.ygj;
    if (i.aMN(s.a(paramj.yhP)) > 0L)
    {
      ad.i("MicroMsg.StoryVideoPreloadMgr", "isLocalVideo video downloadDone " + paramj.yhP.taskId + " username:" + paramj.username);
      AppMethodBeat.o(120562);
      return true;
    }
    locals = s.ygj;
    if (s.a(paramj).dKR())
    {
      ad.i("MicroMsg.StoryVideoPreloadMgr", " isLocalVideo video download finish " + paramj.yhP.taskId + " username:" + paramj.username);
      AppMethodBeat.o(120562);
      return true;
    }
    AppMethodBeat.o(120562);
    return false;
  }
  
  public static void j(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120565);
    k.h(paramj, "videoItem");
    Object localObject = s.ygj;
    localObject = s.bQ(paramj.hgr, paramj.yhP.Url);
    yAz = (String)localObject;
    yAA = Long.valueOf(paramj.dAu);
    ad.i("MicroMsg.StoryVideoPreloadMgr", "markCurrentPlay:" + yAz + " then remove it from preload");
    Iterator localIterator = ((Iterable)yAw).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!k.g(localObject, ((c)paramj).hxP));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj == null) {
        break;
      }
      yAw.remove(paramj);
      l(paramj.yAR);
      AppMethodBeat.o(120565);
      return;
      paramj = null;
    }
    AppMethodBeat.o(120565);
  }
  
  public static b k(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120566);
    k.h(paramj, "videoItem");
    Object localObject1 = s.ygj;
    localObject1 = s.bQ(paramj.hgr, paramj.yhP.Url);
    ad.i("MicroMsg.StoryVideoPreloadMgr", "checkPreloadOnVideoPlay:".concat(String.valueOf(localObject1)));
    Object localObject2 = s.ygj;
    localObject2 = s.a(paramj);
    if ((((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize > 0) && (((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize > 0))
    {
      float f = ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize;
      ad.i("MicroMsg.StoryVideoPreloadMgr", "hit cache, mediaId:" + (String)localObject1 + ", cachePercent:" + f + ", filePath:" + ((com.tencent.mm.plugin.story.i.n)localObject2).field_filePath);
      localObject2 = ((com.tencent.mm.plugin.story.i.n)localObject2).field_filePath;
      CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      long[] arrayOfLong = new long[2];
      localC2CDownloadRequest.fileKey = ((String)localObject1);
      localC2CDownloadRequest.fileType = 6;
      localC2CDownloadRequest.url = paramj.yhP.Url;
      localC2CDownloadRequest.setSavePath((String)localObject2);
      localC2CDownloadRequest.requestVideoFormat = com.tencent.mm.modelcontrol.d.H(1, (String)localObject2);
      boolean bool = CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong);
      ad.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " queryMoovReady: " + bool + ", offset:" + arrayOfLong[0] + ", length:" + arrayOfLong[1] + ", preloadFinish:" + d.a.j.a((Iterable)yAv, localObject1));
      paramj = new b(true, arrayOfLong[0], arrayOfLong[1], d.a.j.a((Iterable)yAv, localObject1));
      AppMethodBeat.o(120566);
      return paramj;
    }
    ad.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " not hit cache or moov not ready");
    paramj = new b(false, 0L, 0L, false);
    AppMethodBeat.o(120566);
    return paramj;
  }
  
  private static void l(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120567);
    k.h(paramj, "videoItem");
    Object localObject = s.ygj;
    localObject = s.bQ(paramj.hgr, paramj.yhP.Url);
    ad.i("MicroMsg.StoryVideoPreloadMgr", "cancelPreloadTask, videoItem:".concat(String.valueOf(localObject)));
    com.tencent.mm.ao.f.awL().xL((String)localObject);
    Iterator localIterator = ((Iterable)yAw).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!k.g(((c)paramj).hxP, localObject));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj == null) {
        break;
      }
      yAw.remove(paramj);
      if (yAx > 0) {
        yAx -= 1;
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
    if ((i(paramj)) || (paramj.dHW()))
    {
      ad.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo fail, " + paramj + " isLocalVideo or fake video");
      AppMethodBeat.o(120573);
      return false;
    }
    Object localObject = s.ygj;
    localObject = s.bQ(paramj.hgr, paramj.yhP.Url);
    if ((!bt.isNullOrNil((String)localObject)) && (!bt.isNullOrNil(paramj.yhP.Url)) && (!d.n.n.I(yAz, (String)localObject, false)))
    {
      AppMethodBeat.o(120573);
      return true;
    }
    ad.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo:" + (String)localObject + ", already request preload or url " + paramj.yhP.Url);
    AppMethodBeat.o(120573);
    return false;
  }
  
  private final void qX(boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(120557);
    boolean bool1 = dLA();
    boolean bool2 = dLB();
    int i = CdnLogic.getRecentAverageSpeed(2);
    if ((paramBoolean) && (i > 0) && (yAs > 0) && (i < yAs))
    {
      ad.w("MicroMsg.StoryVideoPreloadMgr", "speed too low then pass " + i + " clicfg_story_preload_force_canload: " + yAs + " callerFrom " + at.eFT());
      AppMethodBeat.o(120557);
      return;
    }
    int j = 0;
    if (bool2) {}
    for (i = 1;; i = 3)
    {
      if (yAq == 1) {
        i = k;
      }
      for (;;)
      {
        ad.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + yAw.size() + " maxTaskNum " + i + " totalPreLoadOneItemSelect " + yAx + " checkNet " + paramBoolean + " callerFrom " + at.eFT());
        List localList = dLy();
        while ((yAw.size() < i) && (j < localList.size()) && (yAx < 3) && (r(((Number)localList.get(j)).intValue(), "startPreLoad", OP(j))))
        {
          yAx += 1;
          j += 1;
        }
        ad.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue finish loop preload queue, current queue size: " + yAw.size() + ", pullPreloadTaskNum:0, preloadVideoNum:" + j + " preloadRunningSet " + yAw.size() + " totalPreLoadOneItemSelect " + yAx + ' ');
        AppMethodBeat.o(120557);
        return;
      }
    }
  }
  
  private final boolean r(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(120558);
    m localm;
    int i;
    d.o localo;
    com.tencent.mm.plugin.story.f.d.j localj;
    label451:
    label467:
    label637:
    do
    {
      for (;;)
      {
        localm = (m)this;
        Object localObject1 = yAy;
        i = 0;
        localo = null;
        while ((i < ((a)localObject1).yAK.size()) && (localo == null))
        {
          localo = ((a)localObject1).dLG();
          ad.i(a.TAG, "produceVideoItem walkVertical:" + ((a)localObject1).yAF + "  walkHorizontal:" + ((a)localObject1).yAG + " positionV:" + ((a)localObject1).yAL + " positionH:" + ((a)localObject1).yAM + ", ret:" + localo);
          i += 1;
        }
        if (localo == null)
        {
          AppMethodBeat.o(120558);
          return false;
        }
        localj = (com.tencent.mm.plugin.story.f.d.j)localo.first;
        String str = ((c)localo.second).hxP;
        localObject1 = new StringBuilder("try preload mediaId ").append(str).append(" videoItem:").append(localj).append(" pos:").append((c)localo.second).append("  groupinfo ");
        Object localObject2 = yAy;
        ad.i("MicroMsg.StoryVideoPreloadMgr", new StringBuilder("positionV:").append(((a)localObject2).yAL).append(", positionH:").append(((a)localObject2).yAM).append(", walkVertical:").append(((a)localObject2).yAF).append(", walkHorizontal:").append(((a)localObject2).yAG).toString() + " quota:" + paramInt1 + "  fromTag:" + paramString);
        localObject2 = ((Iterable)yAw).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
        } while (!k.g(((c)localObject1).hxP, str));
        for (;;)
        {
          localObject1 = (c)localObject1;
          if ((localObject1 == null) || (paramInt1 > ((c)localObject1).fph)) {
            break label451;
          }
          ad.i("MicroMsg.StoryVideoPreloadMgr", "no need add quota " + paramInt1 + " cur:" + ((c)localObject1).fph + " fromTag:" + paramString);
          break;
          localObject1 = null;
        }
        if (((CharSequence)str).length() == 0)
        {
          i = 1;
          if (i != 0) {
            break label637;
          }
        }
        for (localObject1 = str;; localObject1 = null)
        {
          if (localObject1 == null) {
            break label641;
          }
          i = a(str, localj.yhP, paramInt1, dLA());
          localObject1 = s.ygj;
          localObject1 = s.a(localj);
          if ((!((com.tencent.mm.plugin.story.i.n)localObject1).dKR()) && (((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize * 100.0F < i)) {
            break label643;
          }
          ad.i("MicroMsg.StoryVideoPreloadMgr", "pull preload video, " + str + ", already reach cache size! cacheSize:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize + ", totalSize:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize + ", cachePercent:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize * 100.0F + "  fromTag:" + paramString);
          break;
          i = 0;
          break label467;
        }
      }
    } while (!localm.a(localj, i, paramInt2, (c)localo.second));
    label641:
    label643:
    ((c)localo.second).fph = paramInt1;
    AppMethodBeat.o(120558);
    return true;
  }
  
  public static void u(List<com.tencent.mm.plugin.story.f.d.j> paramList, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(120560);
    k.h(paramList, "videoItemList");
    ad.m("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList " + paramList.size(), new Object[0]);
    boolean bool1 = dLA();
    boolean bool2 = dLB();
    ad.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + yAw.size() + " downloadExpect " + paramInt);
    List localList = dLy();
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
          break label532;
        }
        localj = (com.tencent.mm.plugin.story.f.d.j)localIterator1.next();
        if (!m(localj)) {
          continue;
        }
        if (paramInt > 0)
        {
          i = paramInt;
          k = OP(j);
          paramList = s.ygj;
          str = s.bQ(localj.hgr, localj.yhP.Url);
          m = a(str, localj.yhP, i, dLA());
          paramList = s.ygj;
          localn = s.a(localj);
          Iterator localIterator2 = ((Iterable)yAw).iterator();
          if (!localIterator2.hasNext()) {
            break label585;
          }
          paramList = localIterator2.next();
          if (!k.g(((c)paramList).hxP, str)) {
            continue;
          }
          if (paramList == null) {
            break label382;
          }
          ad.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already prealoding!");
        }
      }
      label532:
      label585:
      if (j < localList.size())
      {
        i = ((Number)localList.get(j)).intValue();
      }
      else
      {
        i = ((Number)d.a.j.iA(localList)).intValue();
        continue;
        label382:
        if ((localn.dKR()) || (localn.field_cacheSize / localn.field_totalSize * 100.0F >= m))
        {
          ad.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already reach cache size! cacheSize:" + localn.field_cacheSize + ", totalSize:" + localn.field_totalSize + ", cachePercent:" + localn.field_cacheSize / localn.field_totalSize * 100.0F);
        }
        else
        {
          paramList = new c(0, j, localj, i, k);
          if (yAD.a(localj, m, k, paramList))
          {
            j += 1;
            continue;
            paramList = y.JfV;
            ad.i("MicroMsg.StoryVideoPreloadMgr", "finish addPreloadVideo withList, total pull video task:" + j + " preloadRunningSet " + yAw.size());
            AppMethodBeat.o(120560);
            return;
            paramList = null;
          }
        }
      }
    }
  }
  
  public final void h(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120555);
    k.h(paramj, "item");
    ad.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad " + paramj + ' ' + at.eFT());
    if (i(paramj))
    {
      ad.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay isLocalVideo");
      qX(false);
      AppMethodBeat.o(120555);
      return;
    }
    if (c(paramj) == 1)
    {
      ad.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay true");
      qX(true);
      AppMethodBeat.o(120555);
      return;
    }
    if (yAr == 1) {
      qX(true);
    }
    ad.i("MicroMsg.StoryVideoPreloadMgr", "nothing can checkPreLoad");
    AppMethodBeat.o(120555);
  }
  
  public final void tZ(long paramLong)
  {
    AppMethodBeat.i(120553);
    if (ymk == paramLong)
    {
      AppMethodBeat.o(120553);
      return;
    }
    ymk = paramLong;
    if (yAq == 0)
    {
      AppMethodBeat.o(120553);
      return;
    }
    a locala = yAy;
    if (locala != null) {
      locala.dLH();
    }
    qX(true);
    AppMethodBeat.o(120553);
  }
  
  public final void ua(long paramLong)
  {
    AppMethodBeat.i(120554);
    Object localObject = yAA;
    if (localObject == null) {}
    while (yAC == paramLong)
    {
      AppMethodBeat.o(120554);
      return;
      if (((Long)localObject).longValue() == paramLong) {
        yAA = Long.valueOf(0L);
      }
    }
    yAC = paramLong;
    if (yAq == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (yAs == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (yAw.size() > 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    localObject = yAy;
    if (localObject != null) {
      ((a)localObject).dLH();
    }
    qX(false);
    AppMethodBeat.o(120554);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "", "groupItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "", "positionH", "lastGroup", "skipPosition", "", "(Ljava/util/List;IILcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;Z)V", "MAX_PRELOAD_COUNT", "horizontalList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "produceList", "Lkotlin/Function0;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "verticalList", "walkHorizontal", "walkIndex", "walkVertical", "info", "", "isDataChange", "isSame", "galleryItems", "produce", "produceHorizontalVideoItem", "produceVerticalVideoItem", "produceVideoItem", "reset", "", "resetWalk", "Companion", "plugin-story_release"})
  public static final class a
  {
    static final String TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
    public static final a yAO;
    private final int yAE;
    int yAF;
    int yAG;
    private int yAH;
    private ArrayList<com.tencent.mm.plugin.story.f.d.h> yAI;
    private ArrayList<com.tencent.mm.plugin.story.f.d.h> yAJ;
    List<? extends d.g.a.a<d.o<com.tencent.mm.plugin.story.f.d.j, m.c>>> yAK;
    int yAL;
    int yAM;
    private final boolean yAN;
    
    static
    {
      AppMethodBeat.i(120542);
      yAO = new a((byte)0);
      TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
      AppMethodBeat.o(120542);
    }
    
    public a(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> arg1, int paramInt1, int paramInt2, a arg4)
    {
      AppMethodBeat.i(120541);
      this.yAL = paramInt1;
      this.yAM = paramInt2;
      this.yAN = true;
      this.yAE = 15;
      this.yAI = new ArrayList();
      this.yAJ = new ArrayList();
      this.yAK = d.a.j.listOf(new d.g.a.a[] { (d.g.a.a)new b(this), (d.g.a.a)new c(this), (d.g.a.a)new d(this) });
      if (((??? != null) && (this.yAL != ???.yAL)) || ((??? != null) && (this.yAM != ???.yAM)) || (gf(???))) {
        reset();
      }
      this.yAI.clear();
      this.yAJ.clear();
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
            this.yAJ.add(localList.get(0));
          }
        }
        paramInt1 = 0;
      }
      Object localObject = y.JfV;
      if (this.yAL < ???.size())
      {
        synchronized ((Iterable)???.get(this.yAL))
        {
          ??? = ???.iterator();
          if (???.hasNext())
          {
            localObject = (com.tencent.mm.plugin.story.f.d.h)???.next();
            this.yAI.add(localObject);
          }
        }
        ??? = y.JfV;
        AppMethodBeat.o(120541);
        return;
      }
      AppMethodBeat.o(120541);
    }
    
    private final d.o<com.tencent.mm.plugin.story.f.d.j, m.c> dLI()
    {
      AppMethodBeat.i(120539);
      for (;;)
      {
        if (this.yAN) {
          this.yAF += 1;
        }
        if (this.yAF >= this.yAJ.size())
        {
          AppMethodBeat.o(120539);
          return null;
        }
        try
        {
          if (this.yAJ.size() > 0)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)this.yAJ.get(this.yAF)).yhF;
            m localm = m.yAD;
            if (m.n((com.tencent.mm.plugin.story.f.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new d.o(localObject1, new m.c(this.yAF, 0, (com.tencent.mm.plugin.story.f.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.yAN) {
            continue;
          }
          this.yAF += 1;
        }
        finally
        {
          if (!this.yAN) {
            this.yAF += 1;
          }
          AppMethodBeat.o(120539);
        }
      }
    }
    
    private final d.o<com.tencent.mm.plugin.story.f.d.j, m.c> dLJ()
    {
      AppMethodBeat.i(120540);
      for (;;)
      {
        if (this.yAN) {
          this.yAG += 1;
        }
        if (this.yAG >= this.yAI.size())
        {
          AppMethodBeat.o(120540);
          return null;
        }
        try
        {
          if (this.yAI.size() > this.yAG)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)this.yAI.get(this.yAG)).yhF;
            m localm = m.yAD;
            if (m.n((com.tencent.mm.plugin.story.f.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new d.o(localObject1, new m.c(this.yAF, this.yAG, (com.tencent.mm.plugin.story.f.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.yAN) {
            continue;
          }
          this.yAG += 1;
        }
        finally
        {
          if (!this.yAN) {
            this.yAG += 1;
          }
          AppMethodBeat.o(120540);
        }
      }
    }
    
    private final void reset()
    {
      this.yAF = this.yAL;
      this.yAG = this.yAM;
      this.yAH = 0;
    }
    
    final d.o<com.tencent.mm.plugin.story.f.d.j, m.c> dLG()
    {
      AppMethodBeat.i(120536);
      try
      {
        if (this.yAH > this.yAE)
        {
          ad.i(TAG, "stop preload now " + this.yAH);
          AppMethodBeat.o(120536);
          return null;
        }
        d.o localo = (d.o)((d.g.a.a)this.yAK.get(this.yAH % this.yAK.size())).invoke();
        this.yAH += 1;
        AppMethodBeat.o(120536);
        return localo;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace(TAG, (Throwable)localException, "error on produce", new Object[0]);
        AppMethodBeat.o(120536);
      }
      return null;
    }
    
    public final void dLH()
    {
      AppMethodBeat.i(120538);
      ad.i(TAG, "resetWalk");
      reset();
      AppMethodBeat.o(120538);
    }
    
    final boolean gf(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> paramList)
    {
      AppMethodBeat.i(120537);
      if (paramList.size() == this.yAJ.size())
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
          if (((com.tencent.mm.plugin.story.f.d.h)this.yAJ.get(i)).yhF.dzf != ((com.tencent.mm.plugin.story.f.d.h)((List)paramList.get(i)).get(0)).yhF.dzf)
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
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {}
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<d.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      b(m.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<d.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      c(m.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<d.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      d(m.a parama)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "", "isMoovReady", "", "offset", "", "length", "preloadFinish", "(ZJJZ)V", "()Z", "getLength", "()J", "getOffset", "getPreloadFinish", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-story_release"})
  public static final class b
  {
    final long length;
    final long offset;
    final boolean qEp;
    final boolean yAQ;
    
    public b(boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
    {
      this.qEp = paramBoolean1;
      this.offset = paramLong1;
      this.length = paramLong2;
      this.yAQ = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.qEp != paramObject.qEp) || (this.offset != paramObject.offset) || (this.length != paramObject.length) || (this.yAQ != paramObject.yAQ)) {}
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
      String str = "MoovReadyInfo(isMoovReady=" + this.qEp + ", offset=" + this.offset + ", length=" + this.length + ", preloadFinish=" + this.yAQ + ")";
      AppMethodBeat.o(120545);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "", "positionV", "", "positionH", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "quota", "connectionCount", "(IILcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;II)V", "cdnMediaId", "", "getCdnMediaId", "()Ljava/lang/String;", "setCdnMediaId", "(Ljava/lang/String;)V", "getConnectionCount", "()I", "setConnectionCount", "(I)V", "getItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getPositionH", "getPositionV", "getQuota", "setQuota", "info", "plugin-story_release"})
  public static final class c
  {
    private int connectionCount;
    int fph;
    String hxP;
    private final int yAL;
    private final int yAM;
    final com.tencent.mm.plugin.story.f.d.j yAR;
    
    public c(int paramInt1, int paramInt2, com.tencent.mm.plugin.story.f.d.j paramj, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(120546);
      this.yAL = paramInt1;
      this.yAM = paramInt2;
      this.yAR = paramj;
      this.fph = paramInt3;
      this.connectionCount = paramInt4;
      paramj = s.ygj;
      String str = s.bQ(this.yAR.hgr, this.yAR.yhP.Url);
      paramj = str;
      if (str == null) {
        paramj = "";
      }
      this.hxP = paramj;
      AppMethodBeat.o(120546);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "startTick", "", "(J)V", "onPreloadCompleted", "", "mediaId", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-story_release"})
  static final class d
    implements g.b
  {
    private final long fNi;
    
    public d(long paramLong)
    {
      this.fNi = paramLong;
    }
    
    public final void a(String paramString, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(120548);
      ad.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", sceneResult:" + paramd);
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        ad.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", video source change!");
        paramd = m.yAD;
        m.asd(paramString);
        AppMethodBeat.o(120548);
        return;
      }
      if ((paramString != null) && (paramd != null))
      {
        Object localObject = m.yAD;
        if (m.dLD().containsKey(paramString))
        {
          localObject = m.yAD;
          localObject = (com.tencent.mm.plugin.story.f.d.j)m.dLD().get(paramString);
          if (localObject != null)
          {
            if ((paramd.field_recvedBytes > 0L) && (paramd.field_fileLength > 0L))
            {
              s locals = s.ygj;
              localObject = s.a((com.tencent.mm.plugin.story.f.d.j)localObject);
              ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize = ((int)paramd.field_recvedBytes);
              ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize = ((int)paramd.field_fileLength);
              paramd = com.tencent.mm.plugin.story.f.j.yfh;
              j.b.dHh().b((com.tencent.mm.plugin.story.i.n)localObject);
              paramd = m.yAD;
              m.dLE().add(paramString);
              ad.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted update cacheSize:" + ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize + ", totalSize:" + ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize + ", preloadCost:" + bt.aS(this.fNi));
              com.tencent.mm.ad.c.g((d.g.a.a)new a(paramString));
              AppMethodBeat.o(120548);
              return;
            }
            ad.e("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted error, recvedBytes:" + paramd.field_recvedBytes + ", fileLength:" + paramd.field_fileLength);
          }
        }
      }
      AppMethodBeat.o(120548);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(String paramString)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "()V", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  static final class e
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(120549);
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        ad.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreload, mediaId:" + paramString + ", video source change!");
        paramc = m.yAD;
        m.asd(paramString);
        AppMethodBeat.o(120549);
        return 0;
      }
      Object localObject1;
      int i;
      if ((paramc != null) && (paramc.field_toltalLength > 0L))
      {
        paramd = m.yAD;
        localObject1 = (com.tencent.mm.plugin.story.f.d.j)m.dLD().get(paramString);
        paramd = m.yAD;
        paramBoolean = d.a.j.a((Iterable)m.dLE(), paramString);
        int j = (int)((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F);
        paramd = m.yAD;
        paramd = (Integer)m.dLF().get(paramString);
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
          Object localObject2 = s.ygj;
          localObject2 = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
          ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize = ((int)paramc.field_finishedLength);
          ((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize = ((int)paramc.field_toltalLength);
          paramc = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dHh().b((com.tencent.mm.plugin.story.i.n)localObject2);
          paramc = com.tencent.mm.plugin.story.f.j.yfh;
          com.tencent.mm.plugin.story.i.f localf = j.b.dHe().arp(((com.tencent.mm.plugin.story.f.d.j)localObject1).username);
          paramc = paramd;
          if (localf.field_syncId == ((com.tencent.mm.plugin.story.f.d.j)localObject1).dAu)
          {
            paramc = paramd;
            if (localf.isValid())
            {
              long l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dAu;
              localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).yhP.Id;
              k.g(localObject1, "videoItem.media.Id");
              paramc = paramd;
              if (localf.c(l, (String)localObject1, ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize))
              {
                paramc = paramd + " * ext pre update * ";
                paramd = com.tencent.mm.plugin.story.f.j.yfh;
                j.b.dHe().a((int)localf.systemRowid, localf);
              }
            }
          }
          if ((paramInt != 0) && (paramString != null))
          {
            paramd = m.yAD;
            m.dLE().add(paramString);
          }
        }
        for (paramString = paramc + "update cacheSize done";; paramString = paramd)
        {
          paramString = new StringBuilder().append(paramString).append(", currentSpeed:");
          paramc = m.yAD;
          ad.i("MicroMsg.StoryVideoPreloadMgr", m.dLC());
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