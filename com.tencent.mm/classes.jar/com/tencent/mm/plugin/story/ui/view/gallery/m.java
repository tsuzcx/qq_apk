package com.tencent.mm.plugin.story.ui.view.gallery;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr;", "", "()V", "MAX_PRELOAD_TASK_LIMIT", "", "TAG", "", "clicfg_story_preload_force_canload", "getClicfg_story_preload_force_canload", "()I", "setClicfg_story_preload_force_canload", "(I)V", "clicfg_story_preload_force_preload", "getClicfg_story_preload_force_preload", "setClicfg_story_preload_force_preload", "clicfg_story_preload_strategy", "getClicfg_story_preload_strategy", "setClicfg_story_preload_strategy", "groupData", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "lastFinishStoryId", "", "getLastFinishStoryId", "()J", "setLastFinishStoryId", "(J)V", "lastStoryId", "getLastStoryId", "setLastStoryId", "playingMediaId", "preLoadConfig", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "getPreLoadConfig", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "setPreLoadConfig", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;)V", "preloadFinishSet", "", "preloadInfoRatioSet", "", "preloadInfoSet", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadRunningSet", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "runningMediaId", "Ljava/lang/Long;", "selectMediaId", "totalPreLoadOneItemSelect", "getTotalPreLoadOneItemSelect", "setTotalPreLoadOneItemSelect", "addPreLoadTask", "", "quota", "fromTag", "connectionCount", "addPreloadVideo", "", "videoItemList", "", "downloadExpect", "calcPreloadPercent", "mediaId", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "cacheSecondsDowngrade", "isGoodNetwork", "cancelAllPreloadTask", "cancelPreloadTask", "videoItem", "checkCanPlay", "item", "checkPreLoad", "checkPreloadOnVideoPlay", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "url", "path", "preloadPercent", "getNetworkSpeed", "isBadNetwork", "isLocalVideo", "makrFinish", "storyId", "markCurrentPlay", "markOnVideoFirstFrameDraw", "needPreLoad", "onVideoSourceChange", "preloadVideoWithPercent", "percent", "taskInfo", "queryQuota", "setPreloadQueueFromGallery", "groupItems", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "positionH", "skipPosition", "startPreLoad", "checkNet", "taskConnectionCount", "index", "upgrades", "GroupData", "MoovReadyInfo", "TaskInfo", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-story_release"})
public final class m
{
  private static long BiG;
  private static j BwC;
  private static int BwD;
  private static int BwE;
  private static int BwF;
  private static final Map<String, com.tencent.mm.plugin.story.f.d.j> BwG;
  private static final Map<String, Integer> BwH;
  private static final Set<String> BwI;
  private static final List<c> BwJ;
  private static int BwK;
  private static a BwL;
  private static volatile String BwM;
  private static volatile Long BwN;
  private static long BwO;
  private static long BwP;
  public static final m BwQ;
  
  static
  {
    AppMethodBeat.i(120574);
    BwQ = new m();
    BwC = new j();
    Object localObject = Collections.synchronizedMap((Map)new HashMap());
    p.g(localObject, "Collections.synchronized…tring, StoryVideoItem>())");
    BwG = (Map)localObject;
    localObject = Collections.synchronizedMap((Map)new HashMap());
    p.g(localObject, "Collections.synchronized…p(HashMap<String, Int>())");
    BwH = (Map)localObject;
    localObject = Collections.synchronizedSet((Set)new HashSet());
    p.g(localObject, "Collections.synchronizedSet(HashSet<String>())");
    BwI = (Set)localObject;
    localObject = Collections.synchronizedList((List)new LinkedList());
    p.g(localObject, "Collections.synchronized…t(LinkedList<TaskInfo>())");
    BwJ = (List)localObject;
    BwK = 3;
    BwL = new a((List)new ArrayList());
    AppMethodBeat.o(120574);
  }
  
  private static int Tl(int paramInt)
  {
    AppMethodBeat.i(120564);
    ae.i("MicroMsg.StoryVideoPreloadMgr", "taskConnectionCount: ".concat(String.valueOf(paramInt)));
    List localList = BwC.Bvo;
    if (paramInt < BwC.Bvo.size()) {}
    for (;;)
    {
      paramInt = ((Number)localList.get(paramInt)).intValue();
      AppMethodBeat.o(120564);
      return paramInt;
      paramInt = BwC.Bvo.size() - 1;
    }
  }
  
  private static int a(String paramString, dkg paramdkg, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(120569);
    float f = paramdkg.HSb;
    ae.i("MicroMsg.StoryVideoPreloadMgr", "calcPreloadPercent, cacheSecondsDowngrade:" + paramInt + ", mediaId:" + paramString + ", duration:" + f + ", isGoodNetwork:" + paramBoolean + " media:" + paramdkg.HSb);
    int i;
    if (paramBoolean)
    {
      i = 5;
      if (f > 0.0F) {
        break label135;
      }
      paramInt = BwC.Bvj;
    }
    for (;;)
    {
      i = paramInt;
      if (paramInt <= BwC.Bvj) {
        i = BwC.Bvj;
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
        if ((paramj.emu()) || (bu.isNullOrNil(paramj.Bem.Url)))
        {
          AppMethodBeat.o(120563);
          bool = false;
          return bool;
        }
        if (i(paramj))
        {
          ae.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, isLocalVideo: " + paramj.Bem.Url);
          AppMethodBeat.o(120563);
          bool = false;
          continue;
        }
        String str2 = paramj.Bem.Url;
        String str1 = paramc.iuG;
        Object localObject1 = s.BcG;
        localObject1 = s.a(paramj);
        ae.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, " + str1 + ", " + paramInt1 + ", playingMediaId:" + BwM + ", " + ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath + ", " + str2 + "  videoCache " + localObject1);
        if ((str1 == null) || (d.n.n.H(BwM, str1, false))) {
          break label654;
        }
        Object localObject2 = s.BcG;
        com.tencent.mm.vfs.o.aZI(s.aDh(paramj.username));
        p.g(str2, "url");
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
        p.g(localObject1, "videoCache.field_filePath");
        ae.i("MicroMsg.StoryVideoPreloadMgr", "createVideoPreloadCDNTask, mediaId:" + str1 + ", path:" + (String)localObject1 + ", url:" + str2 + ", preloadPercent:" + paramInt1 + ", connectionCount:" + paramInt2);
        localObject2 = new com.tencent.mm.i.h();
        ((com.tencent.mm.i.h)localObject2).fLl = "task_StoryVideoPreloadMgr";
        ((com.tencent.mm.i.h)localObject2).field_mediaId = str1;
        ((com.tencent.mm.i.h)localObject2).url = str2;
        ((com.tencent.mm.i.h)localObject2).fLC = 2;
        ((com.tencent.mm.i.h)localObject2).fLI = 2;
        ((com.tencent.mm.i.h)localObject2).fLD = 6;
        ((com.tencent.mm.i.h)localObject2).fLN = paramInt1;
        ((com.tencent.mm.i.h)localObject2).field_preloadRatio = paramInt1;
        ((com.tencent.mm.i.h)localObject2).concurrentCount = 4;
        ((com.tencent.mm.i.h)localObject2).field_fullpath = ((String)localObject1);
        ((com.tencent.mm.i.h)localObject2).fLm = ((g.a)new e());
        ((com.tencent.mm.i.h)localObject2).fLE = ((g.b)new d(bu.HQ()));
        ((com.tencent.mm.i.h)localObject2).connectionCount = paramInt2;
        ((com.tencent.mm.i.h)localObject2).field_fileType = com.tencent.mm.i.a.fKJ;
        ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.I(2, (String)localObject1);
        com.tencent.mm.an.f.aGZ().e((com.tencent.mm.i.g)localObject2);
        ae.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent:" + localObject2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2));
        BwG.put(str1, paramj);
        BwH.put(str1, Integer.valueOf(paramInt1));
        paramj = BwJ.iterator();
        paramInt1 = 0;
        if (!paramj.hasNext()) {
          break label635;
        }
        if (p.i(((c)paramj.next()).iuG, paramc.iuG))
        {
          if (paramInt1 <= 0) {
            break label640;
          }
          BwJ.set(paramInt1, paramc);
          BwI.remove(str1);
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
      BwJ.add(paramc);
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
    Object localObject = s.BcG;
    localObject = s.a(paramj);
    if (((com.tencent.mm.plugin.story.i.n)localObject).epq())
    {
      ae.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay downloadFinish " + paramj.dLI);
      AppMethodBeat.o(120556);
      return 1;
    }
    if (((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(120556);
      return 0;
    }
    if (((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize * 100.0F >= BwC.Bvj)
    {
      ae.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay cachesize " + ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize + " totalSize: " + ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize);
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
    ae.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery, galleryItems size:" + ???.size() + ", positionV:" + paramInt1 + "  positionH:" + paramInt2 + ", skipPosition:true");
    Object localObject1 = BwL;
    p.h(???, "galleryItems");
    int i;
    if (((a)localObject1).gG(???)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(120551);
      return false;
      if ((((a)localObject1).BwZ != paramInt2) || (((a)localObject1).BwY != paramInt1)) {
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
        localObject1 = ((com.tencent.mm.plugin.story.f.d.h)localObject1).Bec;
        if (localObject1 != null) {
          BwO = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dLI;
        }
      }
    }
    BiG = 0L;
    BwK = 0;
    BwL = new a(???, paramInt1, paramInt2, BwL);
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
            d.a.j.gkd();
          }
          localObject5 = (List)localObject5;
          if ((i < paramInt1) || (((List)localObject5).size() <= 0)) {
            break label957;
          }
          ((ArrayList)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.story.f.d.h)((List)localObject5).get(0)).Bec.dKr));
          break label957;
        }
        localObject4 = z.Nhr;
        ??? = new ArrayList();
        if ((paramInt1 < ???.size()) && (paramInt2 < ((List)???.get(paramInt1)).size()))
        {
          i = ((List)???.get(paramInt1)).size();
          if (paramInt2 < i)
          {
            ((ArrayList)???).add(Integer.valueOf(((com.tencent.mm.plugin.story.f.d.h)((List)???.get(paramInt1)).get(paramInt2)).Bec.dKr));
            paramInt2 += 1;
          }
        }
      }
      Object localObject4 = (Iterable)BwJ;
      ??? = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      label575:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        c localc = (c)localObject5;
        if ((!((ArrayList)localObject1).contains(Integer.valueOf(localc.Bxe.dKr))) && (!((ArrayList)???).contains(Integer.valueOf(localc.Bxe.dKr)))) {}
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
          l(((c)((Iterator)localObject1).next()).Bxe);
        }
      }
      z localz = z.Nhr;
      BwD = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxu, 1);
      paramInt1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxv, 450);
      paramInt2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxw, 200);
      BwE = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxx, 0);
      BwF = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxB, 100);
      BwC.Bvk = paramInt1;
      BwC.Bvl = paramInt2;
      i = CdnLogic.getRecentAverageSpeed(2);
      ae.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery clicfg_story_preload_strategy " + BwD + " clicfg_story_preload_speed_good:" + paramInt1 + " clicfg_story_preload_speed_bad:" + paramInt2 + " clicfg_story_preload_force_preload " + BwE + "  clicfg_story_preload_force_canload: " + BwF + " speed:" + i);
      if ((i > 0) && (BwF > 0) && (i < BwF))
      {
        ae.w("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery speed too low then pass " + i + " clicfg_story_preload_force_canload: " + BwF);
        ??? = new LinkedList();
        ???.addAll((Collection)BwJ);
        ??? = ???.iterator();
        while (???.hasNext()) {
          l(((c)???.next()).Bxe);
        }
      }
      AppMethodBeat.o(120551);
      return false;
      label957:
      i += 1;
    }
  }
  
  public static j epV()
  {
    return BwC;
  }
  
  private static List<Integer> epW()
  {
    AppMethodBeat.i(120550);
    if (epZ())
    {
      localList = BwC.Bvn;
      AppMethodBeat.o(120550);
      return localList;
    }
    List localList = BwC.Bvm;
    AppMethodBeat.o(120550);
    return localList;
  }
  
  public static void epX()
  {
    AppMethodBeat.i(120568);
    ae.m("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask", new Object[0]);
    Iterator localIterator = BwG.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ae.i("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask ".concat(String.valueOf(str)));
      com.tencent.mm.an.f.aGZ().Fs(str);
    }
    BwG.clear();
    BwH.clear();
    BwL = new a((List)new ArrayList());
    BwJ.clear();
    AppMethodBeat.o(120568);
  }
  
  private static boolean epY()
  {
    AppMethodBeat.i(120570);
    if (CdnLogic.getRecentAverageSpeed(2) >= BwC.Bvk)
    {
      AppMethodBeat.o(120570);
      return true;
    }
    AppMethodBeat.o(120570);
    return false;
  }
  
  private static boolean epZ()
  {
    AppMethodBeat.i(120571);
    int i = BwC.Bvl;
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
  
  public static int eqa()
  {
    AppMethodBeat.i(224266);
    int i = CdnLogic.getRecentAverageSpeed(2);
    AppMethodBeat.o(224266);
    return i;
  }
  
  private static boolean i(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120562);
    if (paramj.emu())
    {
      AppMethodBeat.o(120562);
      return true;
    }
    s locals = s.BcG;
    if (com.tencent.mm.vfs.o.aZR(s.a(paramj.Bem)) > 0L)
    {
      ae.i("MicroMsg.StoryVideoPreloadMgr", "isLocalVideo video downloadDone " + paramj.Bem.taskId + " username:" + paramj.username);
      AppMethodBeat.o(120562);
      return true;
    }
    locals = s.BcG;
    if (s.a(paramj).epq())
    {
      ae.i("MicroMsg.StoryVideoPreloadMgr", " isLocalVideo video download finish " + paramj.Bem.taskId + " username:" + paramj.username);
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
    Object localObject = s.BcG;
    localObject = s.cb(paramj.icw, paramj.Bem.Url);
    BwM = (String)localObject;
    BwN = Long.valueOf(paramj.dLI);
    ae.i("MicroMsg.StoryVideoPreloadMgr", "markCurrentPlay:" + BwM + " then remove it from preload");
    Iterator localIterator = ((Iterable)BwJ).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!p.i(localObject, ((c)paramj).iuG));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj == null) {
        break;
      }
      BwJ.remove(paramj);
      l(paramj.Bxe);
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
    Object localObject1 = s.BcG;
    localObject1 = s.cb(paramj.icw, paramj.Bem.Url);
    ae.i("MicroMsg.StoryVideoPreloadMgr", "checkPreloadOnVideoPlay:".concat(String.valueOf(localObject1)));
    Object localObject2 = s.BcG;
    localObject2 = s.a(paramj);
    if ((((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize > 0) && (((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize > 0))
    {
      float f = ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize;
      ae.i("MicroMsg.StoryVideoPreloadMgr", "hit cache, mediaId:" + (String)localObject1 + ", cachePercent:" + f + ", filePath:" + ((com.tencent.mm.plugin.story.i.n)localObject2).field_filePath);
      localObject2 = ((com.tencent.mm.plugin.story.i.n)localObject2).field_filePath;
      CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      long[] arrayOfLong = new long[2];
      localC2CDownloadRequest.fileKey = ((String)localObject1);
      localC2CDownloadRequest.fileType = 6;
      localC2CDownloadRequest.url = paramj.Bem.Url;
      localC2CDownloadRequest.setSavePath((String)localObject2);
      localC2CDownloadRequest.requestVideoFormat = com.tencent.mm.modelcontrol.d.I(1, (String)localObject2);
      boolean bool = CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong);
      ae.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " queryMoovReady: " + bool + ", offset:" + arrayOfLong[0] + ", length:" + arrayOfLong[1] + ", preloadFinish:" + d.a.j.a((Iterable)BwI, localObject1));
      paramj = new m.b(true, arrayOfLong[0], arrayOfLong[1], d.a.j.a((Iterable)BwI, localObject1));
      AppMethodBeat.o(120566);
      return paramj;
    }
    ae.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " not hit cache or moov not ready");
    paramj = new m.b(false, 0L, 0L, false);
    AppMethodBeat.o(120566);
    return paramj;
  }
  
  private static void l(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120567);
    p.h(paramj, "videoItem");
    Object localObject = s.BcG;
    localObject = s.cb(paramj.icw, paramj.Bem.Url);
    ae.i("MicroMsg.StoryVideoPreloadMgr", "cancelPreloadTask, videoItem:".concat(String.valueOf(localObject)));
    com.tencent.mm.an.f.aGZ().Fs((String)localObject);
    Iterator localIterator = ((Iterable)BwJ).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!p.i(((c)paramj).iuG, localObject));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj == null) {
        break;
      }
      BwJ.remove(paramj);
      if (BwK > 0) {
        BwK -= 1;
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
    if ((i(paramj)) || (paramj.emu()))
    {
      ae.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo fail, " + paramj + " isLocalVideo or fake video");
      AppMethodBeat.o(120573);
      return false;
    }
    Object localObject = s.BcG;
    localObject = s.cb(paramj.icw, paramj.Bem.Url);
    if ((!bu.isNullOrNil((String)localObject)) && (!bu.isNullOrNil(paramj.Bem.Url)) && (!d.n.n.H(BwM, (String)localObject, false)))
    {
      AppMethodBeat.o(120573);
      return true;
    }
    ae.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo:" + (String)localObject + ", already request preload or url " + paramj.Bem.Url);
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
        Object localObject1 = BwL;
        i = 0;
        localo = null;
        while ((i < ((a)localObject1).BwX.size()) && (localo == null))
        {
          localo = ((a)localObject1).eqe();
          ae.i(a.TAG, "produceVideoItem walkVertical:" + ((a)localObject1).BwS + "  walkHorizontal:" + ((a)localObject1).BwT + " positionV:" + ((a)localObject1).BwY + " positionH:" + ((a)localObject1).BwZ + ", ret:" + localo);
          i += 1;
        }
        if (localo == null)
        {
          AppMethodBeat.o(120558);
          return false;
        }
        localj = (com.tencent.mm.plugin.story.f.d.j)localo.first;
        String str = ((c)localo.second).iuG;
        localObject1 = new StringBuilder("try preload mediaId ").append(str).append(" videoItem:").append(localj).append(" pos:").append((c)localo.second).append("  groupinfo ");
        Object localObject2 = BwL;
        ae.i("MicroMsg.StoryVideoPreloadMgr", new StringBuilder("positionV:").append(((a)localObject2).BwY).append(", positionH:").append(((a)localObject2).BwZ).append(", walkVertical:").append(((a)localObject2).BwS).append(", walkHorizontal:").append(((a)localObject2).BwT).toString() + " quota:" + paramInt1 + "  fromTag:" + paramString);
        localObject2 = ((Iterable)BwJ).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
        } while (!p.i(((c)localObject1).iuG, str));
        for (;;)
        {
          localObject1 = (c)localObject1;
          if ((localObject1 == null) || (paramInt1 > ((c)localObject1).fNl)) {
            break label451;
          }
          ae.i("MicroMsg.StoryVideoPreloadMgr", "no need add quota " + paramInt1 + " cur:" + ((c)localObject1).fNl + " fromTag:" + paramString);
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
          i = a(str, localj.Bem, paramInt1, epY());
          localObject1 = s.BcG;
          localObject1 = s.a(localj);
          if ((!((com.tencent.mm.plugin.story.i.n)localObject1).epq()) && (((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize * 100.0F < i)) {
            break label643;
          }
          ae.i("MicroMsg.StoryVideoPreloadMgr", "pull preload video, " + str + ", already reach cache size! cacheSize:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize + ", totalSize:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize + ", cachePercent:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize * 100.0F + "  fromTag:" + paramString);
          break;
          i = 0;
          break label467;
        }
      }
    } while (!localm.a(localj, i, paramInt2, (c)localo.second));
    label641:
    label643:
    ((c)localo.second).fNl = paramInt1;
    AppMethodBeat.o(120558);
    return true;
  }
  
  private final void sI(boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(120557);
    boolean bool1 = epY();
    boolean bool2 = epZ();
    int i = CdnLogic.getRecentAverageSpeed(2);
    if ((paramBoolean) && (i > 0) && (BwF > 0) && (i < BwF))
    {
      ae.w("MicroMsg.StoryVideoPreloadMgr", "speed too low then pass " + i + " clicfg_story_preload_force_canload: " + BwF + " callerFrom " + au.foQ());
      AppMethodBeat.o(120557);
      return;
    }
    int j = 0;
    if (bool2) {}
    for (i = 1;; i = 3)
    {
      if (BwD == 1) {
        i = k;
      }
      for (;;)
      {
        ae.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + BwJ.size() + " maxTaskNum " + i + " totalPreLoadOneItemSelect " + BwK + " checkNet " + paramBoolean + " callerFrom " + au.foQ());
        List localList = epW();
        while ((BwJ.size() < i) && (j < localList.size()) && (BwK < 3) && (s(((Number)localList.get(j)).intValue(), "startPreLoad", Tl(j))))
        {
          BwK += 1;
          j += 1;
        }
        ae.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue finish loop preload queue, current queue size: " + BwJ.size() + ", pullPreloadTaskNum:0, preloadVideoNum:" + j + " preloadRunningSet " + BwJ.size() + " totalPreLoadOneItemSelect " + BwK + ' ');
        AppMethodBeat.o(120557);
        return;
      }
    }
  }
  
  public static void x(List<com.tencent.mm.plugin.story.f.d.j> paramList, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(120560);
    p.h(paramList, "videoItemList");
    ae.m("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList " + paramList.size(), new Object[0]);
    boolean bool1 = epY();
    boolean bool2 = epZ();
    ae.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + BwJ.size() + " downloadExpect " + paramInt);
    List localList = epW();
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
          k = Tl(j);
          paramList = s.BcG;
          str = s.cb(localj.icw, localj.Bem.Url);
          m = a(str, localj.Bem, i, epY());
          paramList = s.BcG;
          localn = s.a(localj);
          Iterator localIterator2 = ((Iterable)BwJ).iterator();
          if (!localIterator2.hasNext()) {
            break label585;
          }
          paramList = localIterator2.next();
          if (!p.i(((c)paramList).iuG, str)) {
            continue;
          }
          if (paramList == null) {
            break label382;
          }
          ae.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already prealoding!");
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
        i = ((Number)d.a.j.jn(localList)).intValue();
        continue;
        label382:
        if ((localn.epq()) || (localn.field_cacheSize / localn.field_totalSize * 100.0F >= m))
        {
          ae.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already reach cache size! cacheSize:" + localn.field_cacheSize + ", totalSize:" + localn.field_totalSize + ", cachePercent:" + localn.field_cacheSize / localn.field_totalSize * 100.0F);
        }
        else
        {
          paramList = new c(0, j, localj, i, k);
          if (BwQ.a(localj, m, k, paramList))
          {
            j += 1;
            continue;
            paramList = z.Nhr;
            ae.i("MicroMsg.StoryVideoPreloadMgr", "finish addPreloadVideo withList, total pull video task:" + j + " preloadRunningSet " + BwJ.size());
            AppMethodBeat.o(120560);
            return;
            paramList = null;
          }
        }
      }
    }
  }
  
  public final void By(long paramLong)
  {
    AppMethodBeat.i(120553);
    if (BiG == paramLong)
    {
      AppMethodBeat.o(120553);
      return;
    }
    BiG = paramLong;
    if (BwD == 0)
    {
      AppMethodBeat.o(120553);
      return;
    }
    a locala = BwL;
    if (locala != null) {
      locala.eqf();
    }
    sI(true);
    AppMethodBeat.o(120553);
  }
  
  public final void Bz(long paramLong)
  {
    AppMethodBeat.i(120554);
    Object localObject = BwN;
    if (localObject == null) {}
    while (BwP == paramLong)
    {
      AppMethodBeat.o(120554);
      return;
      if (((Long)localObject).longValue() == paramLong) {
        BwN = Long.valueOf(0L);
      }
    }
    BwP = paramLong;
    if (BwD == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (BwF == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (BwJ.size() > 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    localObject = BwL;
    if (localObject != null) {
      ((a)localObject).eqf();
    }
    sI(false);
    AppMethodBeat.o(120554);
  }
  
  public final void h(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120555);
    p.h(paramj, "item");
    ae.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad " + paramj + ' ' + au.foQ());
    if (i(paramj))
    {
      ae.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay isLocalVideo");
      sI(false);
      AppMethodBeat.o(120555);
      return;
    }
    if (c(paramj) == 1)
    {
      ae.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay true");
      sI(true);
      AppMethodBeat.o(120555);
      return;
    }
    if (BwE == 1) {
      sI(true);
    }
    ae.i("MicroMsg.StoryVideoPreloadMgr", "nothing can checkPreLoad");
    AppMethodBeat.o(120555);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "", "groupItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "", "positionH", "lastGroup", "skipPosition", "", "(Ljava/util/List;IILcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;Z)V", "MAX_PRELOAD_COUNT", "horizontalList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "produceList", "Lkotlin/Function0;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "verticalList", "walkHorizontal", "walkIndex", "walkVertical", "info", "", "isDataChange", "isSame", "galleryItems", "produce", "produceHorizontalVideoItem", "produceVerticalVideoItem", "produceVideoItem", "reset", "", "resetWalk", "Companion", "plugin-story_release"})
  public static final class a
  {
    public static final m.a.a Bxb;
    static final String TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
    private final int BwR;
    int BwS;
    int BwT;
    private int BwU;
    private ArrayList<com.tencent.mm.plugin.story.f.d.h> BwV;
    private ArrayList<com.tencent.mm.plugin.story.f.d.h> BwW;
    List<? extends d.g.a.a<d.o<com.tencent.mm.plugin.story.f.d.j, m.c>>> BwX;
    int BwY;
    int BwZ;
    private final boolean Bxa;
    
    static
    {
      AppMethodBeat.i(120542);
      Bxb = new m.a.a((byte)0);
      TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
      AppMethodBeat.o(120542);
    }
    
    public a(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> arg1, int paramInt1, int paramInt2, a arg4)
    {
      AppMethodBeat.i(120541);
      this.BwY = paramInt1;
      this.BwZ = paramInt2;
      this.Bxa = true;
      this.BwR = 15;
      this.BwV = new ArrayList();
      this.BwW = new ArrayList();
      this.BwX = d.a.j.listOf(new d.g.a.a[] { (d.g.a.a)new b(this), (d.g.a.a)new c(this), (d.g.a.a)new d(this) });
      if (((??? != null) && (this.BwY != ???.BwY)) || ((??? != null) && (this.BwZ != ???.BwZ)) || (gG(???))) {
        reset();
      }
      this.BwV.clear();
      this.BwW.clear();
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
            this.BwW.add(localList.get(0));
          }
        }
        paramInt1 = 0;
      }
      Object localObject = z.Nhr;
      if (this.BwY < ???.size())
      {
        synchronized ((Iterable)???.get(this.BwY))
        {
          ??? = ???.iterator();
          if (???.hasNext())
          {
            localObject = (com.tencent.mm.plugin.story.f.d.h)???.next();
            this.BwV.add(localObject);
          }
        }
        ??? = z.Nhr;
        AppMethodBeat.o(120541);
        return;
      }
      AppMethodBeat.o(120541);
    }
    
    private final d.o<com.tencent.mm.plugin.story.f.d.j, m.c> eqg()
    {
      AppMethodBeat.i(120539);
      for (;;)
      {
        if (this.Bxa) {
          this.BwS += 1;
        }
        if (this.BwS >= this.BwW.size())
        {
          AppMethodBeat.o(120539);
          return null;
        }
        try
        {
          if (this.BwW.size() > 0)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)this.BwW.get(this.BwS)).Bec;
            m localm = m.BwQ;
            if (m.n((com.tencent.mm.plugin.story.f.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new d.o(localObject1, new m.c(this.BwS, 0, (com.tencent.mm.plugin.story.f.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.Bxa) {
            continue;
          }
          this.BwS += 1;
        }
        finally
        {
          if (!this.Bxa) {
            this.BwS += 1;
          }
          AppMethodBeat.o(120539);
        }
      }
    }
    
    private final d.o<com.tencent.mm.plugin.story.f.d.j, m.c> eqh()
    {
      AppMethodBeat.i(120540);
      for (;;)
      {
        if (this.Bxa) {
          this.BwT += 1;
        }
        if (this.BwT >= this.BwV.size())
        {
          AppMethodBeat.o(120540);
          return null;
        }
        try
        {
          if (this.BwV.size() > this.BwT)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)this.BwV.get(this.BwT)).Bec;
            m localm = m.BwQ;
            if (m.n((com.tencent.mm.plugin.story.f.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new d.o(localObject1, new m.c(this.BwS, this.BwT, (com.tencent.mm.plugin.story.f.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.Bxa) {
            continue;
          }
          this.BwT += 1;
        }
        finally
        {
          if (!this.Bxa) {
            this.BwT += 1;
          }
          AppMethodBeat.o(120540);
        }
      }
    }
    
    private final void reset()
    {
      this.BwS = this.BwY;
      this.BwT = this.BwZ;
      this.BwU = 0;
    }
    
    final d.o<com.tencent.mm.plugin.story.f.d.j, m.c> eqe()
    {
      AppMethodBeat.i(120536);
      try
      {
        if (this.BwU > this.BwR)
        {
          ae.i(TAG, "stop preload now " + this.BwU);
          AppMethodBeat.o(120536);
          return null;
        }
        d.o localo = (d.o)((d.g.a.a)this.BwX.get(this.BwU % this.BwX.size())).invoke();
        this.BwU += 1;
        AppMethodBeat.o(120536);
        return localo;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace(TAG, (Throwable)localException, "error on produce", new Object[0]);
        AppMethodBeat.o(120536);
      }
      return null;
    }
    
    public final void eqf()
    {
      AppMethodBeat.i(120538);
      ae.i(TAG, "resetWalk");
      reset();
      AppMethodBeat.o(120538);
    }
    
    final boolean gG(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> paramList)
    {
      AppMethodBeat.i(120537);
      if (paramList.size() == this.BwW.size())
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
          if (((com.tencent.mm.plugin.story.f.d.h)this.BwW.get(i)).Bec.dKr != ((com.tencent.mm.plugin.story.f.d.h)((List)paramList.get(i)).get(0)).Bec.dKr)
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<d.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      b(m.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<d.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      c(m.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "", "positionV", "", "positionH", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "quota", "connectionCount", "(IILcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;II)V", "cdnMediaId", "", "getCdnMediaId", "()Ljava/lang/String;", "setCdnMediaId", "(Ljava/lang/String;)V", "getConnectionCount", "()I", "setConnectionCount", "(I)V", "getItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getPositionH", "getPositionV", "getQuota", "setQuota", "info", "plugin-story_release"})
  public static final class c
  {
    private final int BwY;
    private final int BwZ;
    final com.tencent.mm.plugin.story.f.d.j Bxe;
    private int connectionCount;
    int fNl;
    String iuG;
    
    public c(int paramInt1, int paramInt2, com.tencent.mm.plugin.story.f.d.j paramj, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(120546);
      this.BwY = paramInt1;
      this.BwZ = paramInt2;
      this.Bxe = paramj;
      this.fNl = paramInt3;
      this.connectionCount = paramInt4;
      paramj = s.BcG;
      String str = s.cb(this.Bxe.icw, this.Bxe.Bem.Url);
      paramj = str;
      if (str == null) {
        paramj = "";
      }
      this.iuG = paramj;
      AppMethodBeat.o(120546);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "startTick", "", "(J)V", "onPreloadCompleted", "", "mediaId", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-story_release"})
  static final class d
    implements g.b
  {
    private final long gmN;
    
    public d(long paramLong)
    {
      this.gmN = paramLong;
    }
    
    public final void b(String paramString, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(120548);
      ae.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", sceneResult:" + paramd);
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        ae.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", video source change!");
        paramd = m.BwQ;
        m.aDJ(paramString);
        AppMethodBeat.o(120548);
        return;
      }
      if ((paramString != null) && (paramd != null))
      {
        Object localObject = m.BwQ;
        if (m.eqb().containsKey(paramString))
        {
          localObject = m.BwQ;
          localObject = (com.tencent.mm.plugin.story.f.d.j)m.eqb().get(paramString);
          if (localObject != null)
          {
            if ((paramd.field_recvedBytes > 0L) && (paramd.field_fileLength > 0L))
            {
              s locals = s.BcG;
              localObject = s.a((com.tencent.mm.plugin.story.f.d.j)localObject);
              ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize = ((int)paramd.field_recvedBytes);
              ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize = ((int)paramd.field_fileLength);
              paramd = com.tencent.mm.plugin.story.f.j.BbE;
              j.b.elF().b((com.tencent.mm.plugin.story.i.n)localObject);
              paramd = m.BwQ;
              m.eqc().add(paramString);
              ae.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted update cacheSize:" + ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize + ", totalSize:" + ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize + ", preloadCost:" + bu.aO(this.gmN));
              com.tencent.mm.ac.c.h((d.g.a.a)new a(paramString));
              AppMethodBeat.o(120548);
              return;
            }
            ae.e("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted error, recvedBytes:" + paramd.field_recvedBytes + ", fileLength:" + paramd.field_fileLength);
          }
        }
      }
      AppMethodBeat.o(120548);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "()V", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  static final class e
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(120549);
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        ae.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreload, mediaId:" + paramString + ", video source change!");
        paramc = m.BwQ;
        m.aDJ(paramString);
        AppMethodBeat.o(120549);
        return 0;
      }
      Object localObject1;
      int i;
      if ((paramc != null) && (paramc.field_toltalLength > 0L))
      {
        paramd = m.BwQ;
        localObject1 = (com.tencent.mm.plugin.story.f.d.j)m.eqb().get(paramString);
        paramd = m.BwQ;
        paramBoolean = d.a.j.a((Iterable)m.eqc(), paramString);
        int j = (int)((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F);
        paramd = m.BwQ;
        paramd = (Integer)m.eqd().get(paramString);
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
          Object localObject2 = s.BcG;
          localObject2 = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
          ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize = ((int)paramc.field_finishedLength);
          ((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize = ((int)paramc.field_toltalLength);
          paramc = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.elF().b((com.tencent.mm.plugin.story.i.n)localObject2);
          paramc = com.tencent.mm.plugin.story.f.j.BbE;
          com.tencent.mm.plugin.story.i.f localf = j.b.elC().aCW(((com.tencent.mm.plugin.story.f.d.j)localObject1).username);
          paramc = paramd;
          if (localf.field_syncId == ((com.tencent.mm.plugin.story.f.d.j)localObject1).dLI)
          {
            paramc = paramd;
            if (localf.isValid())
            {
              long l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dLI;
              localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).Bem.Id;
              p.g(localObject1, "videoItem.media.Id");
              paramc = paramd;
              if (localf.a(l, (String)localObject1, ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize))
              {
                paramc = paramd + " * ext pre update * ";
                paramd = com.tencent.mm.plugin.story.f.j.BbE;
                j.b.elC().a((int)localf.systemRowid, localf);
              }
            }
          }
          if ((paramInt != 0) && (paramString != null))
          {
            paramd = m.BwQ;
            m.eqc().add(paramString);
          }
        }
        for (paramString = paramc + "update cacheSize done";; paramString = paramd)
        {
          paramString = new StringBuilder().append(paramString).append(", currentSpeed:");
          paramc = m.BwQ;
          ae.i("MicroMsg.StoryVideoPreloadMgr", m.eqa());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.m
 * JD-Core Version:    0.7.0.1
 */