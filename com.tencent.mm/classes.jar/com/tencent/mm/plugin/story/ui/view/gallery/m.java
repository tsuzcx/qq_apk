package com.tencent.mm.plugin.story.ui.view.gallery;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr;", "", "()V", "MAX_PRELOAD_TASK_LIMIT", "", "TAG", "", "clicfg_story_preload_force_canload", "getClicfg_story_preload_force_canload", "()I", "setClicfg_story_preload_force_canload", "(I)V", "clicfg_story_preload_force_preload", "getClicfg_story_preload_force_preload", "setClicfg_story_preload_force_preload", "clicfg_story_preload_strategy", "getClicfg_story_preload_strategy", "setClicfg_story_preload_strategy", "groupData", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "lastFinishStoryId", "", "getLastFinishStoryId", "()J", "setLastFinishStoryId", "(J)V", "lastStoryId", "getLastStoryId", "setLastStoryId", "playingMediaId", "preLoadConfig", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "getPreLoadConfig", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "setPreLoadConfig", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;)V", "preloadFinishSet", "", "preloadInfoRatioSet", "", "preloadInfoSet", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadRunningSet", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "runningMediaId", "Ljava/lang/Long;", "selectMediaId", "totalPreLoadOneItemSelect", "getTotalPreLoadOneItemSelect", "setTotalPreLoadOneItemSelect", "addPreLoadTask", "", "quota", "fromTag", "connectionCount", "addPreloadVideo", "", "videoItemList", "", "downloadExpect", "calcPreloadPercent", "mediaId", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "cacheSecondsDowngrade", "isGoodNetwork", "cancelAllPreloadTask", "cancelPreloadTask", "videoItem", "checkCanPlay", "item", "checkPreLoad", "checkPreloadOnVideoPlay", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "url", "path", "preloadPercent", "getNetworkSpeed", "isBadNetwork", "isLocalVideo", "makrFinish", "storyId", "markCurrentPlay", "markOnVideoFirstFrameDraw", "needPreLoad", "onVideoSourceChange", "preloadVideoWithPercent", "percent", "taskInfo", "queryQuota", "setPreloadQueueFromGallery", "groupItems", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "positionH", "skipPosition", "startPreLoad", "checkNet", "taskConnectionCount", "index", "upgrades", "GroupData", "MoovReadyInfo", "TaskInfo", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-story_release"})
public final class m
{
  private static long ARi;
  private static j Bfe;
  private static int Bff;
  private static int Bfg;
  private static int Bfh;
  private static final Map<String, com.tencent.mm.plugin.story.f.d.j> Bfi;
  private static final Map<String, Integer> Bfj;
  private static final Set<String> Bfk;
  private static final List<c> Bfl;
  private static int Bfm;
  private static a Bfn;
  private static volatile String Bfo;
  private static volatile Long Bfp;
  private static long Bfq;
  private static long Bfr;
  public static final m Bfs;
  
  static
  {
    AppMethodBeat.i(120574);
    Bfs = new m();
    Bfe = new j();
    Object localObject = Collections.synchronizedMap((Map)new HashMap());
    p.g(localObject, "Collections.synchronized…tring, StoryVideoItem>())");
    Bfi = (Map)localObject;
    localObject = Collections.synchronizedMap((Map)new HashMap());
    p.g(localObject, "Collections.synchronized…p(HashMap<String, Int>())");
    Bfj = (Map)localObject;
    localObject = Collections.synchronizedSet((Set)new HashSet());
    p.g(localObject, "Collections.synchronizedSet(HashSet<String>())");
    Bfk = (Set)localObject;
    localObject = Collections.synchronizedList((List)new LinkedList());
    p.g(localObject, "Collections.synchronized…t(LinkedList<TaskInfo>())");
    Bfl = (List)localObject;
    Bfm = 3;
    Bfn = new a((List)new ArrayList());
    AppMethodBeat.o(120574);
  }
  
  private static int SE(int paramInt)
  {
    AppMethodBeat.i(120564);
    ad.i("MicroMsg.StoryVideoPreloadMgr", "taskConnectionCount: ".concat(String.valueOf(paramInt)));
    List localList = Bfe.BdQ;
    if (paramInt < Bfe.BdQ.size()) {}
    for (;;)
    {
      paramInt = ((Number)localList.get(paramInt)).intValue();
      AppMethodBeat.o(120564);
      return paramInt;
      paramInt = Bfe.BdQ.size() - 1;
    }
  }
  
  private static int a(String paramString, djl paramdjl, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(120569);
    float f = paramdjl.Hyq;
    ad.i("MicroMsg.StoryVideoPreloadMgr", "calcPreloadPercent, cacheSecondsDowngrade:" + paramInt + ", mediaId:" + paramString + ", duration:" + f + ", isGoodNetwork:" + paramBoolean + " media:" + paramdjl.Hyq);
    int i;
    if (paramBoolean)
    {
      i = 5;
      if (f > 0.0F) {
        break label135;
      }
      paramInt = Bfe.BdL;
    }
    for (;;)
    {
      i = paramInt;
      if (paramInt <= Bfe.BdL) {
        i = Bfe.BdL;
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
        p.h(paramj, "videoItem");
        p.h(paramc, "taskInfo");
        if ((paramj.eiM()) || (bt.isNullOrNil(paramj.AMK.Url)))
        {
          AppMethodBeat.o(120563);
          bool = false;
          return bool;
        }
        if (i(paramj))
        {
          ad.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, isLocalVideo: " + paramj.AMK.Url);
          AppMethodBeat.o(120563);
          bool = false;
          continue;
        }
        String str2 = paramj.AMK.Url;
        String str1 = paramc.irM;
        Object localObject1 = s.ALd;
        localObject1 = s.a(paramj);
        ad.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, " + str1 + ", " + paramInt1 + ", playingMediaId:" + Bfo + ", " + ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath + ", " + str2 + "  videoCache " + localObject1);
        if ((str1 == null) || (d.n.n.H(Bfo, str1, false))) {
          break label654;
        }
        Object localObject2 = s.ALd;
        i.aYg(s.aBO(paramj.username));
        p.g(str2, "url");
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
        p.g(localObject1, "videoCache.field_filePath");
        ad.i("MicroMsg.StoryVideoPreloadMgr", "createVideoPreloadCDNTask, mediaId:" + str1 + ", path:" + (String)localObject1 + ", url:" + str2 + ", preloadPercent:" + paramInt1 + ", connectionCount:" + paramInt2);
        localObject2 = new com.tencent.mm.i.h();
        ((com.tencent.mm.i.h)localObject2).fJi = "task_StoryVideoPreloadMgr";
        ((com.tencent.mm.i.h)localObject2).field_mediaId = str1;
        ((com.tencent.mm.i.h)localObject2).url = str2;
        ((com.tencent.mm.i.h)localObject2).fJz = 2;
        ((com.tencent.mm.i.h)localObject2).fJF = 2;
        ((com.tencent.mm.i.h)localObject2).fJA = 6;
        ((com.tencent.mm.i.h)localObject2).fJK = paramInt1;
        ((com.tencent.mm.i.h)localObject2).field_preloadRatio = paramInt1;
        ((com.tencent.mm.i.h)localObject2).concurrentCount = 4;
        ((com.tencent.mm.i.h)localObject2).field_fullpath = ((String)localObject1);
        ((com.tencent.mm.i.h)localObject2).fJj = ((g.a)new e());
        ((com.tencent.mm.i.h)localObject2).fJB = ((g.b)new d(bt.HI()));
        ((com.tencent.mm.i.h)localObject2).connectionCount = paramInt2;
        ((com.tencent.mm.i.h)localObject2).field_fileType = com.tencent.mm.i.a.fIF;
        ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.I(2, (String)localObject1);
        com.tencent.mm.ao.f.aGI().e((com.tencent.mm.i.g)localObject2);
        ad.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent:" + localObject2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2));
        Bfi.put(str1, paramj);
        Bfj.put(str1, Integer.valueOf(paramInt1));
        paramj = Bfl.iterator();
        paramInt1 = 0;
        if (!paramj.hasNext()) {
          break label635;
        }
        if (p.i(((c)paramj.next()).irM, paramc.irM))
        {
          if (paramInt1 <= 0) {
            break label640;
          }
          Bfl.set(paramInt1, paramc);
          Bfk.remove(str1);
          bool = true;
          AppMethodBeat.o(120563);
          continue;
        }
        paramInt1 += 1;
      }
      finally {}
      continue;
      label635:
      paramInt1 = -1;
      continue;
      label640:
      Bfl.add(paramc);
      continue;
      label654:
      AppMethodBeat.o(120563);
      boolean bool = false;
    }
  }
  
  private static int c(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120556);
    p.h(paramj, "item");
    Object localObject = s.ALd;
    localObject = s.a(paramj);
    if (((com.tencent.mm.plugin.story.i.n)localObject).elH())
    {
      ad.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay downloadFinish " + paramj.dKt);
      AppMethodBeat.o(120556);
      return 1;
    }
    if (((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(120556);
      return 0;
    }
    if (((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize * 100.0F >= Bfe.BdL)
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
    p.h(???, "groupItems");
    ad.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery, galleryItems size:" + ???.size() + ", positionV:" + paramInt1 + "  positionH:" + paramInt2 + ", skipPosition:true");
    Object localObject1 = Bfn;
    p.h(???, "galleryItems");
    int i;
    if (((a)localObject1).gx(???)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(120551);
      return false;
      if ((((a)localObject1).BfB != paramInt2) || (((a)localObject1).BfA != paramInt1)) {
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
        localObject1 = ((com.tencent.mm.plugin.story.f.d.h)localObject1).AMA;
        if (localObject1 != null) {
          Bfq = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dKt;
        }
      }
    }
    ARi = 0L;
    Bfm = 0;
    Bfn = new a(???, paramInt1, paramInt2, Bfn);
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
            d.a.j.gfB();
          }
          localObject5 = (List)localObject5;
          if ((i < paramInt1) || (((List)localObject5).size() <= 0)) {
            break label957;
          }
          ((ArrayList)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.story.f.d.h)((List)localObject5).get(0)).AMA.dJd));
          break label957;
        }
        localObject4 = z.MKo;
        ??? = new ArrayList();
        if ((paramInt1 < ???.size()) && (paramInt2 < ((List)???.get(paramInt1)).size()))
        {
          i = ((List)???.get(paramInt1)).size();
          if (paramInt2 < i)
          {
            ((ArrayList)???).add(Integer.valueOf(((com.tencent.mm.plugin.story.f.d.h)((List)???.get(paramInt1)).get(paramInt2)).AMA.dJd));
            paramInt2 += 1;
          }
        }
      }
      Object localObject4 = (Iterable)Bfl;
      ??? = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      label575:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        c localc = (c)localObject5;
        if ((!((ArrayList)localObject1).contains(Integer.valueOf(localc.BfG.dJd))) && (!((ArrayList)???).contains(Integer.valueOf(localc.BfG.dJd)))) {}
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
          l(((c)((Iterator)localObject1).next()).BfG);
        }
      }
      z localz = z.MKo;
      Bff = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqH, 1);
      paramInt1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqI, 450);
      paramInt2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqJ, 200);
      Bfg = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqK, 0);
      Bfh = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqO, 100);
      Bfe.BdM = paramInt1;
      Bfe.BdN = paramInt2;
      i = CdnLogic.getRecentAverageSpeed(2);
      ad.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery clicfg_story_preload_strategy " + Bff + " clicfg_story_preload_speed_good:" + paramInt1 + " clicfg_story_preload_speed_bad:" + paramInt2 + " clicfg_story_preload_force_preload " + Bfg + "  clicfg_story_preload_force_canload: " + Bfh + " speed:" + i);
      if ((i > 0) && (Bfh > 0) && (i < Bfh))
      {
        ad.w("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery speed too low then pass " + i + " clicfg_story_preload_force_canload: " + Bfh);
        ??? = new LinkedList();
        ???.addAll((Collection)Bfl);
        ??? = ???.iterator();
        while (???.hasNext()) {
          l(((c)???.next()).BfG);
        }
      }
      AppMethodBeat.o(120551);
      return false;
      label957:
      i += 1;
    }
  }
  
  public static j emm()
  {
    return Bfe;
  }
  
  private static List<Integer> emn()
  {
    AppMethodBeat.i(120550);
    if (emq())
    {
      localList = Bfe.BdP;
      AppMethodBeat.o(120550);
      return localList;
    }
    List localList = Bfe.BdO;
    AppMethodBeat.o(120550);
    return localList;
  }
  
  public static void emo()
  {
    AppMethodBeat.i(120568);
    ad.m("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask", new Object[0]);
    Iterator localIterator = Bfi.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ad.i("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask ".concat(String.valueOf(str)));
      com.tencent.mm.ao.f.aGI().EQ(str);
    }
    Bfi.clear();
    Bfj.clear();
    Bfn = new a((List)new ArrayList());
    Bfl.clear();
    AppMethodBeat.o(120568);
  }
  
  private static boolean emp()
  {
    AppMethodBeat.i(120570);
    if (CdnLogic.getRecentAverageSpeed(2) >= Bfe.BdM)
    {
      AppMethodBeat.o(120570);
      return true;
    }
    AppMethodBeat.o(120570);
    return false;
  }
  
  private static boolean emq()
  {
    AppMethodBeat.i(120571);
    int i = Bfe.BdN;
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
  
  public static int emr()
  {
    AppMethodBeat.i(221434);
    int i = CdnLogic.getRecentAverageSpeed(2);
    AppMethodBeat.o(221434);
    return i;
  }
  
  private static boolean i(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120562);
    if (paramj.eiM())
    {
      AppMethodBeat.o(120562);
      return true;
    }
    s locals = s.ALd;
    if (i.aYo(s.a(paramj.AMK)) > 0L)
    {
      ad.i("MicroMsg.StoryVideoPreloadMgr", "isLocalVideo video downloadDone " + paramj.AMK.taskId + " username:" + paramj.username);
      AppMethodBeat.o(120562);
      return true;
    }
    locals = s.ALd;
    if (s.a(paramj).elH())
    {
      ad.i("MicroMsg.StoryVideoPreloadMgr", " isLocalVideo video download finish " + paramj.AMK.taskId + " username:" + paramj.username);
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
    Object localObject = s.ALd;
    localObject = s.cb(paramj.hZE, paramj.AMK.Url);
    Bfo = (String)localObject;
    Bfp = Long.valueOf(paramj.dKt);
    ad.i("MicroMsg.StoryVideoPreloadMgr", "markCurrentPlay:" + Bfo + " then remove it from preload");
    Iterator localIterator = ((Iterable)Bfl).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!p.i(localObject, ((c)paramj).irM));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj == null) {
        break;
      }
      Bfl.remove(paramj);
      l(paramj.BfG);
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
    Object localObject1 = s.ALd;
    localObject1 = s.cb(paramj.hZE, paramj.AMK.Url);
    ad.i("MicroMsg.StoryVideoPreloadMgr", "checkPreloadOnVideoPlay:".concat(String.valueOf(localObject1)));
    Object localObject2 = s.ALd;
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
      localC2CDownloadRequest.url = paramj.AMK.Url;
      localC2CDownloadRequest.setSavePath((String)localObject2);
      localC2CDownloadRequest.requestVideoFormat = com.tencent.mm.modelcontrol.d.I(1, (String)localObject2);
      boolean bool = CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong);
      ad.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " queryMoovReady: " + bool + ", offset:" + arrayOfLong[0] + ", length:" + arrayOfLong[1] + ", preloadFinish:" + d.a.j.a((Iterable)Bfk, localObject1));
      paramj = new m.b(true, arrayOfLong[0], arrayOfLong[1], d.a.j.a((Iterable)Bfk, localObject1));
      AppMethodBeat.o(120566);
      return paramj;
    }
    ad.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " not hit cache or moov not ready");
    paramj = new m.b(false, 0L, 0L, false);
    AppMethodBeat.o(120566);
    return paramj;
  }
  
  private static void l(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120567);
    p.h(paramj, "videoItem");
    Object localObject = s.ALd;
    localObject = s.cb(paramj.hZE, paramj.AMK.Url);
    ad.i("MicroMsg.StoryVideoPreloadMgr", "cancelPreloadTask, videoItem:".concat(String.valueOf(localObject)));
    com.tencent.mm.ao.f.aGI().EQ((String)localObject);
    Iterator localIterator = ((Iterable)Bfl).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!p.i(((c)paramj).irM, localObject));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj == null) {
        break;
      }
      Bfl.remove(paramj);
      if (Bfm > 0) {
        Bfm -= 1;
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
    if ((i(paramj)) || (paramj.eiM()))
    {
      ad.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo fail, " + paramj + " isLocalVideo or fake video");
      AppMethodBeat.o(120573);
      return false;
    }
    Object localObject = s.ALd;
    localObject = s.cb(paramj.hZE, paramj.AMK.Url);
    if ((!bt.isNullOrNil((String)localObject)) && (!bt.isNullOrNil(paramj.AMK.Url)) && (!d.n.n.H(Bfo, (String)localObject, false)))
    {
      AppMethodBeat.o(120573);
      return true;
    }
    ad.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo:" + (String)localObject + ", already request preload or url " + paramj.AMK.Url);
    AppMethodBeat.o(120573);
    return false;
  }
  
  private final boolean s(int paramInt1, String paramString, int paramInt2)
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
        Object localObject1 = Bfn;
        i = 0;
        localo = null;
        while ((i < ((a)localObject1).Bfz.size()) && (localo == null))
        {
          localo = ((a)localObject1).emv();
          ad.i(a.TAG, "produceVideoItem walkVertical:" + ((a)localObject1).Bfu + "  walkHorizontal:" + ((a)localObject1).Bfv + " positionV:" + ((a)localObject1).BfA + " positionH:" + ((a)localObject1).BfB + ", ret:" + localo);
          i += 1;
        }
        if (localo == null)
        {
          AppMethodBeat.o(120558);
          return false;
        }
        localj = (com.tencent.mm.plugin.story.f.d.j)localo.first;
        String str = ((c)localo.second).irM;
        localObject1 = new StringBuilder("try preload mediaId ").append(str).append(" videoItem:").append(localj).append(" pos:").append((c)localo.second).append("  groupinfo ");
        Object localObject2 = Bfn;
        ad.i("MicroMsg.StoryVideoPreloadMgr", new StringBuilder("positionV:").append(((a)localObject2).BfA).append(", positionH:").append(((a)localObject2).BfB).append(", walkVertical:").append(((a)localObject2).Bfu).append(", walkHorizontal:").append(((a)localObject2).Bfv).toString() + " quota:" + paramInt1 + "  fromTag:" + paramString);
        localObject2 = ((Iterable)Bfl).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
        } while (!p.i(((c)localObject1).irM, str));
        for (;;)
        {
          localObject1 = (c)localObject1;
          if ((localObject1 == null) || (paramInt1 > ((c)localObject1).fLh)) {
            break label451;
          }
          ad.i("MicroMsg.StoryVideoPreloadMgr", "no need add quota " + paramInt1 + " cur:" + ((c)localObject1).fLh + " fromTag:" + paramString);
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
          i = a(str, localj.AMK, paramInt1, emp());
          localObject1 = s.ALd;
          localObject1 = s.a(localj);
          if ((!((com.tencent.mm.plugin.story.i.n)localObject1).elH()) && (((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize * 100.0F < i)) {
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
    ((c)localo.second).fLh = paramInt1;
    AppMethodBeat.o(120558);
    return true;
  }
  
  private final void sB(boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(120557);
    boolean bool1 = emp();
    boolean bool2 = emq();
    int i = CdnLogic.getRecentAverageSpeed(2);
    if ((paramBoolean) && (i > 0) && (Bfh > 0) && (i < Bfh))
    {
      ad.w("MicroMsg.StoryVideoPreloadMgr", "speed too low then pass " + i + " clicfg_story_preload_force_canload: " + Bfh + " callerFrom " + at.fkV());
      AppMethodBeat.o(120557);
      return;
    }
    int j = 0;
    if (bool2) {}
    for (i = 1;; i = 3)
    {
      if (Bff == 1) {
        i = k;
      }
      for (;;)
      {
        ad.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + Bfl.size() + " maxTaskNum " + i + " totalPreLoadOneItemSelect " + Bfm + " checkNet " + paramBoolean + " callerFrom " + at.fkV());
        List localList = emn();
        while ((Bfl.size() < i) && (j < localList.size()) && (Bfm < 3) && (s(((Number)localList.get(j)).intValue(), "startPreLoad", SE(j))))
        {
          Bfm += 1;
          j += 1;
        }
        ad.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue finish loop preload queue, current queue size: " + Bfl.size() + ", pullPreloadTaskNum:0, preloadVideoNum:" + j + " preloadRunningSet " + Bfl.size() + " totalPreLoadOneItemSelect " + Bfm + ' ');
        AppMethodBeat.o(120557);
        return;
      }
    }
  }
  
  public static void w(List<com.tencent.mm.plugin.story.f.d.j> paramList, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(120560);
    p.h(paramList, "videoItemList");
    ad.m("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList " + paramList.size(), new Object[0]);
    boolean bool1 = emp();
    boolean bool2 = emq();
    ad.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + Bfl.size() + " downloadExpect " + paramInt);
    List localList = emn();
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
          k = SE(j);
          paramList = s.ALd;
          str = s.cb(localj.hZE, localj.AMK.Url);
          m = a(str, localj.AMK, i, emp());
          paramList = s.ALd;
          localn = s.a(localj);
          Iterator localIterator2 = ((Iterable)Bfl).iterator();
          if (!localIterator2.hasNext()) {
            break label585;
          }
          paramList = localIterator2.next();
          if (!p.i(((c)paramList).irM, str)) {
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
        i = ((Number)d.a.j.je(localList)).intValue();
        continue;
        label382:
        if ((localn.elH()) || (localn.field_cacheSize / localn.field_totalSize * 100.0F >= m))
        {
          ad.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already reach cache size! cacheSize:" + localn.field_cacheSize + ", totalSize:" + localn.field_totalSize + ", cachePercent:" + localn.field_cacheSize / localn.field_totalSize * 100.0F);
        }
        else
        {
          paramList = new c(0, j, localj, i, k);
          if (Bfs.a(localj, m, k, paramList))
          {
            j += 1;
            continue;
            paramList = z.MKo;
            ad.i("MicroMsg.StoryVideoPreloadMgr", "finish addPreloadVideo withList, total pull video task:" + j + " preloadRunningSet " + Bfl.size());
            AppMethodBeat.o(120560);
            return;
            paramList = null;
          }
        }
      }
    }
  }
  
  public final void Ba(long paramLong)
  {
    AppMethodBeat.i(120553);
    if (ARi == paramLong)
    {
      AppMethodBeat.o(120553);
      return;
    }
    ARi = paramLong;
    if (Bff == 0)
    {
      AppMethodBeat.o(120553);
      return;
    }
    a locala = Bfn;
    if (locala != null) {
      locala.emw();
    }
    sB(true);
    AppMethodBeat.o(120553);
  }
  
  public final void Bb(long paramLong)
  {
    AppMethodBeat.i(120554);
    Object localObject = Bfp;
    if (localObject == null) {}
    while (Bfr == paramLong)
    {
      AppMethodBeat.o(120554);
      return;
      if (((Long)localObject).longValue() == paramLong) {
        Bfp = Long.valueOf(0L);
      }
    }
    Bfr = paramLong;
    if (Bff == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (Bfh == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (Bfl.size() > 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    localObject = Bfn;
    if (localObject != null) {
      ((a)localObject).emw();
    }
    sB(false);
    AppMethodBeat.o(120554);
  }
  
  public final void h(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120555);
    p.h(paramj, "item");
    ad.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad " + paramj + ' ' + at.fkV());
    if (i(paramj))
    {
      ad.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay isLocalVideo");
      sB(false);
      AppMethodBeat.o(120555);
      return;
    }
    if (c(paramj) == 1)
    {
      ad.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay true");
      sB(true);
      AppMethodBeat.o(120555);
      return;
    }
    if (Bfg == 1) {
      sB(true);
    }
    ad.i("MicroMsg.StoryVideoPreloadMgr", "nothing can checkPreLoad");
    AppMethodBeat.o(120555);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "", "groupItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "", "positionH", "lastGroup", "skipPosition", "", "(Ljava/util/List;IILcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;Z)V", "MAX_PRELOAD_COUNT", "horizontalList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "produceList", "Lkotlin/Function0;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "verticalList", "walkHorizontal", "walkIndex", "walkVertical", "info", "", "isDataChange", "isSame", "galleryItems", "produce", "produceHorizontalVideoItem", "produceVerticalVideoItem", "produceVideoItem", "reset", "", "resetWalk", "Companion", "plugin-story_release"})
  public static final class a
  {
    public static final m.a.a BfD;
    static final String TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
    int BfA;
    int BfB;
    private final boolean BfC;
    private final int Bft;
    int Bfu;
    int Bfv;
    private int Bfw;
    private ArrayList<com.tencent.mm.plugin.story.f.d.h> Bfx;
    private ArrayList<com.tencent.mm.plugin.story.f.d.h> Bfy;
    List<? extends d.g.a.a<d.o<com.tencent.mm.plugin.story.f.d.j, m.c>>> Bfz;
    
    static
    {
      AppMethodBeat.i(120542);
      BfD = new m.a.a((byte)0);
      TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
      AppMethodBeat.o(120542);
    }
    
    public a(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> arg1, int paramInt1, int paramInt2, a arg4)
    {
      AppMethodBeat.i(120541);
      this.BfA = paramInt1;
      this.BfB = paramInt2;
      this.BfC = true;
      this.Bft = 15;
      this.Bfx = new ArrayList();
      this.Bfy = new ArrayList();
      this.Bfz = d.a.j.listOf(new d.g.a.a[] { (d.g.a.a)new b(this), (d.g.a.a)new c(this), (d.g.a.a)new d(this) });
      if (((??? != null) && (this.BfA != ???.BfA)) || ((??? != null) && (this.BfB != ???.BfB)) || (gx(???))) {
        reset();
      }
      this.Bfx.clear();
      this.Bfy.clear();
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
            this.Bfy.add(localList.get(0));
          }
        }
        paramInt1 = 0;
      }
      Object localObject = z.MKo;
      if (this.BfA < ???.size())
      {
        synchronized ((Iterable)???.get(this.BfA))
        {
          ??? = ???.iterator();
          if (???.hasNext())
          {
            localObject = (com.tencent.mm.plugin.story.f.d.h)???.next();
            this.Bfx.add(localObject);
          }
        }
        ??? = z.MKo;
        AppMethodBeat.o(120541);
        return;
      }
      AppMethodBeat.o(120541);
    }
    
    private final d.o<com.tencent.mm.plugin.story.f.d.j, m.c> emx()
    {
      AppMethodBeat.i(120539);
      for (;;)
      {
        if (this.BfC) {
          this.Bfu += 1;
        }
        if (this.Bfu >= this.Bfy.size())
        {
          AppMethodBeat.o(120539);
          return null;
        }
        try
        {
          if (this.Bfy.size() > 0)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)this.Bfy.get(this.Bfu)).AMA;
            m localm = m.Bfs;
            if (m.n((com.tencent.mm.plugin.story.f.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new d.o(localObject1, new m.c(this.Bfu, 0, (com.tencent.mm.plugin.story.f.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.BfC) {
            continue;
          }
          this.Bfu += 1;
        }
        finally
        {
          if (!this.BfC) {
            this.Bfu += 1;
          }
          AppMethodBeat.o(120539);
        }
      }
    }
    
    private final d.o<com.tencent.mm.plugin.story.f.d.j, m.c> emy()
    {
      AppMethodBeat.i(120540);
      for (;;)
      {
        if (this.BfC) {
          this.Bfv += 1;
        }
        if (this.Bfv >= this.Bfx.size())
        {
          AppMethodBeat.o(120540);
          return null;
        }
        try
        {
          if (this.Bfx.size() > this.Bfv)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)this.Bfx.get(this.Bfv)).AMA;
            m localm = m.Bfs;
            if (m.n((com.tencent.mm.plugin.story.f.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new d.o(localObject1, new m.c(this.Bfu, this.Bfv, (com.tencent.mm.plugin.story.f.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.BfC) {
            continue;
          }
          this.Bfv += 1;
        }
        finally
        {
          if (!this.BfC) {
            this.Bfv += 1;
          }
          AppMethodBeat.o(120540);
        }
      }
    }
    
    private final void reset()
    {
      this.Bfu = this.BfA;
      this.Bfv = this.BfB;
      this.Bfw = 0;
    }
    
    final d.o<com.tencent.mm.plugin.story.f.d.j, m.c> emv()
    {
      AppMethodBeat.i(120536);
      try
      {
        if (this.Bfw > this.Bft)
        {
          ad.i(TAG, "stop preload now " + this.Bfw);
          AppMethodBeat.o(120536);
          return null;
        }
        d.o localo = (d.o)((d.g.a.a)this.Bfz.get(this.Bfw % this.Bfz.size())).invoke();
        this.Bfw += 1;
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
    
    public final void emw()
    {
      AppMethodBeat.i(120538);
      ad.i(TAG, "resetWalk");
      reset();
      AppMethodBeat.o(120538);
    }
    
    final boolean gx(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> paramList)
    {
      AppMethodBeat.i(120537);
      if (paramList.size() == this.Bfy.size())
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
          if (((com.tencent.mm.plugin.story.f.d.h)this.Bfy.get(i)).AMA.dJd != ((com.tencent.mm.plugin.story.f.d.h)((List)paramList.get(i)).get(0)).AMA.dJd)
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
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<d.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      b(m.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<d.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      c(m.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class d
      extends q
      implements d.g.a.a<d.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      d(m.a parama)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "", "positionV", "", "positionH", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "quota", "connectionCount", "(IILcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;II)V", "cdnMediaId", "", "getCdnMediaId", "()Ljava/lang/String;", "setCdnMediaId", "(Ljava/lang/String;)V", "getConnectionCount", "()I", "setConnectionCount", "(I)V", "getItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getPositionH", "getPositionV", "getQuota", "setQuota", "info", "plugin-story_release"})
  public static final class c
  {
    private final int BfA;
    private final int BfB;
    final com.tencent.mm.plugin.story.f.d.j BfG;
    private int connectionCount;
    int fLh;
    String irM;
    
    public c(int paramInt1, int paramInt2, com.tencent.mm.plugin.story.f.d.j paramj, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(120546);
      this.BfA = paramInt1;
      this.BfB = paramInt2;
      this.BfG = paramj;
      this.fLh = paramInt3;
      this.connectionCount = paramInt4;
      paramj = s.ALd;
      String str = s.cb(this.BfG.hZE, this.BfG.AMK.Url);
      paramj = str;
      if (str == null) {
        paramj = "";
      }
      this.irM = paramj;
      AppMethodBeat.o(120546);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "startTick", "", "(J)V", "onPreloadCompleted", "", "mediaId", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-story_release"})
  static final class d
    implements g.b
  {
    private final long gkt;
    
    public d(long paramLong)
    {
      this.gkt = paramLong;
    }
    
    public final void b(String paramString, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(120548);
      ad.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", sceneResult:" + paramd);
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        ad.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", video source change!");
        paramd = m.Bfs;
        m.aCq(paramString);
        AppMethodBeat.o(120548);
        return;
      }
      if ((paramString != null) && (paramd != null))
      {
        Object localObject = m.Bfs;
        if (m.ems().containsKey(paramString))
        {
          localObject = m.Bfs;
          localObject = (com.tencent.mm.plugin.story.f.d.j)m.ems().get(paramString);
          if (localObject != null)
          {
            if ((paramd.field_recvedBytes > 0L) && (paramd.field_fileLength > 0L))
            {
              s locals = s.ALd;
              localObject = s.a((com.tencent.mm.plugin.story.f.d.j)localObject);
              ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize = ((int)paramd.field_recvedBytes);
              ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize = ((int)paramd.field_fileLength);
              paramd = com.tencent.mm.plugin.story.f.j.AKb;
              j.b.ehX().b((com.tencent.mm.plugin.story.i.n)localObject);
              paramd = m.Bfs;
              m.emt().add(paramString);
              ad.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted update cacheSize:" + ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize + ", totalSize:" + ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize + ", preloadCost:" + bt.aO(this.gkt));
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
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(String paramString)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "()V", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  static final class e
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(120549);
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        ad.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreload, mediaId:" + paramString + ", video source change!");
        paramc = m.Bfs;
        m.aCq(paramString);
        AppMethodBeat.o(120549);
        return 0;
      }
      Object localObject1;
      int i;
      if ((paramc != null) && (paramc.field_toltalLength > 0L))
      {
        paramd = m.Bfs;
        localObject1 = (com.tencent.mm.plugin.story.f.d.j)m.ems().get(paramString);
        paramd = m.Bfs;
        paramBoolean = d.a.j.a((Iterable)m.emt(), paramString);
        int j = (int)((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F);
        paramd = m.Bfs;
        paramd = (Integer)m.emu().get(paramString);
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
          Object localObject2 = s.ALd;
          localObject2 = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
          ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize = ((int)paramc.field_finishedLength);
          ((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize = ((int)paramc.field_toltalLength);
          paramc = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.ehX().b((com.tencent.mm.plugin.story.i.n)localObject2);
          paramc = com.tencent.mm.plugin.story.f.j.AKb;
          com.tencent.mm.plugin.story.i.f localf = j.b.ehU().aBD(((com.tencent.mm.plugin.story.f.d.j)localObject1).username);
          paramc = paramd;
          if (localf.field_syncId == ((com.tencent.mm.plugin.story.f.d.j)localObject1).dKt)
          {
            paramc = paramd;
            if (localf.isValid())
            {
              long l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dKt;
              localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).AMK.Id;
              p.g(localObject1, "videoItem.media.Id");
              paramc = paramd;
              if (localf.a(l, (String)localObject1, ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize))
              {
                paramc = paramd + " * ext pre update * ";
                paramd = com.tencent.mm.plugin.story.f.j.AKb;
                j.b.ehU().a((int)localf.systemRowid, localf);
              }
            }
          }
          if ((paramInt != 0) && (paramString != null))
          {
            paramd = m.Bfs;
            m.emt().add(paramString);
          }
        }
        for (paramString = paramc + "update cacheSize done";; paramString = paramd)
        {
          paramString = new StringBuilder().append(paramString).append(", currentSpeed:");
          paramc = m.Bfs;
          ad.i("MicroMsg.StoryVideoPreloadMgr", m.emr());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.m
 * JD-Core Version:    0.7.0.1
 */