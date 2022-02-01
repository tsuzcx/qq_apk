package com.tencent.mm.plugin.story.ui.view.gallery;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr;", "", "()V", "MAX_PRELOAD_TASK_LIMIT", "", "TAG", "", "clicfg_story_preload_force_canload", "getClicfg_story_preload_force_canload", "()I", "setClicfg_story_preload_force_canload", "(I)V", "clicfg_story_preload_force_preload", "getClicfg_story_preload_force_preload", "setClicfg_story_preload_force_preload", "clicfg_story_preload_strategy", "getClicfg_story_preload_strategy", "setClicfg_story_preload_strategy", "groupData", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "lastFinishStoryId", "", "getLastFinishStoryId", "()J", "setLastFinishStoryId", "(J)V", "lastStoryId", "getLastStoryId", "setLastStoryId", "playingMediaId", "preLoadConfig", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "getPreLoadConfig", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "setPreLoadConfig", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;)V", "preloadFinishSet", "", "preloadInfoRatioSet", "", "preloadInfoSet", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadRunningSet", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "runningMediaId", "Ljava/lang/Long;", "selectMediaId", "totalPreLoadOneItemSelect", "getTotalPreLoadOneItemSelect", "setTotalPreLoadOneItemSelect", "addPreLoadTask", "", "quota", "fromTag", "connectionCount", "addPreloadVideo", "", "videoItemList", "", "downloadExpect", "calcPreloadPercent", "mediaId", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "cacheSecondsDowngrade", "isGoodNetwork", "cancelAllPreloadTask", "cancelPreloadTask", "videoItem", "checkCanPlay", "item", "checkPreLoad", "checkPreloadOnVideoPlay", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "url", "path", "preloadPercent", "getNetworkSpeed", "isBadNetwork", "isLocalVideo", "makrFinish", "storyId", "markCurrentPlay", "markOnVideoFirstFrameDraw", "needPreLoad", "onVideoSourceChange", "preloadVideoWithPercent", "percent", "taskInfo", "queryQuota", "setPreloadQueueFromGallery", "groupItems", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "positionH", "skipPosition", "startPreLoad", "checkNet", "taskConnectionCount", "index", "upgrades", "GroupData", "MoovReadyInfo", "TaskInfo", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-story_release"})
public final class m
{
  private static j zND;
  private static int zNE;
  private static int zNF;
  private static int zNG;
  private static final Map<String, com.tencent.mm.plugin.story.f.d.j> zNH;
  private static final Map<String, Integer> zNI;
  private static final Set<String> zNJ;
  private static final List<c> zNK;
  private static int zNL;
  private static a zNM;
  private static volatile String zNN;
  private static volatile Long zNO;
  private static long zNP;
  private static long zNQ;
  public static final m zNR;
  private static long zzJ;
  
  static
  {
    AppMethodBeat.i(120574);
    zNR = new m();
    zND = new j();
    Object localObject = Collections.synchronizedMap((Map)new HashMap());
    k.g(localObject, "Collections.synchronized…tring, StoryVideoItem>())");
    zNH = (Map)localObject;
    localObject = Collections.synchronizedMap((Map)new HashMap());
    k.g(localObject, "Collections.synchronized…p(HashMap<String, Int>())");
    zNI = (Map)localObject;
    localObject = Collections.synchronizedSet((Set)new HashSet());
    k.g(localObject, "Collections.synchronizedSet(HashSet<String>())");
    zNJ = (Set)localObject;
    localObject = Collections.synchronizedList((List)new LinkedList());
    k.g(localObject, "Collections.synchronized…t(LinkedList<TaskInfo>())");
    zNK = (List)localObject;
    zNL = 3;
    zNM = new a((List)new ArrayList());
    AppMethodBeat.o(120574);
  }
  
  private static int QV(int paramInt)
  {
    AppMethodBeat.i(120564);
    ac.i("MicroMsg.StoryVideoPreloadMgr", "taskConnectionCount: ".concat(String.valueOf(paramInt)));
    List localList = zND.zMp;
    if (paramInt < zND.zMp.size()) {}
    for (;;)
    {
      paramInt = ((Number)localList.get(paramInt)).intValue();
      AppMethodBeat.o(120564);
      return paramInt;
      paramInt = zND.zMp.size() - 1;
    }
  }
  
  private static int a(String paramString, ddy paramddy, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(120569);
    float f = paramddy.FNF;
    ac.i("MicroMsg.StoryVideoPreloadMgr", "calcPreloadPercent, cacheSecondsDowngrade:" + paramInt + ", mediaId:" + paramString + ", duration:" + f + ", isGoodNetwork:" + paramBoolean + " media:" + paramddy.FNF);
    int i;
    if (paramBoolean)
    {
      i = 5;
      if (f > 0.0F) {
        break label135;
      }
      paramInt = zND.zMk;
    }
    for (;;)
    {
      i = paramInt;
      if (paramInt <= zND.zMk) {
        i = zND.zMk;
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
        if ((paramj.dWx()) || (bs.isNullOrNil(paramj.zuP.Url)))
        {
          AppMethodBeat.o(120563);
          bool = false;
          return bool;
        }
        if (i(paramj))
        {
          ac.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, isLocalVideo: " + paramj.zuP.Url);
          AppMethodBeat.o(120563);
          bool = false;
          continue;
        }
        String str2 = paramj.zuP.Url;
        String str1 = paramc.hYq;
        Object localObject1 = s.ztj;
        localObject1 = s.a(paramj);
        ac.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, " + str1 + ", " + paramInt1 + ", playingMediaId:" + zNN + ", " + ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath + ", " + str2 + "  videoCache " + localObject1);
        if ((str1 == null) || (d.n.n.I(zNN, str1, false))) {
          break label646;
        }
        Object localObject2 = s.ztj;
        i.aSh(s.awK(paramj.username));
        k.g(str2, "url");
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
        k.g(localObject1, "videoCache.field_filePath");
        ac.i("MicroMsg.StoryVideoPreloadMgr", "createVideoPreloadCDNTask, mediaId:" + str1 + ", path:" + (String)localObject1 + ", url:" + str2 + ", preloadPercent:" + paramInt1 + ", connectionCount:" + paramInt2);
        localObject2 = new com.tencent.mm.i.h();
        ((com.tencent.mm.i.h)localObject2).field_mediaId = str1;
        ((com.tencent.mm.i.h)localObject2).url = str2;
        ((com.tencent.mm.i.h)localObject2).frq = 2;
        ((com.tencent.mm.i.h)localObject2).frw = 2;
        ((com.tencent.mm.i.h)localObject2).frr = 6;
        ((com.tencent.mm.i.h)localObject2).frB = paramInt1;
        ((com.tencent.mm.i.h)localObject2).field_preloadRatio = paramInt1;
        ((com.tencent.mm.i.h)localObject2).concurrentCount = 4;
        ((com.tencent.mm.i.h)localObject2).field_fullpath = ((String)localObject1);
        ((com.tencent.mm.i.h)localObject2).frb = ((g.a)new e());
        ((com.tencent.mm.i.h)localObject2).frs = ((g.b)new d(bs.Gn()));
        ((com.tencent.mm.i.h)localObject2).connectionCount = paramInt2;
        ((com.tencent.mm.i.h)localObject2).field_fileType = com.tencent.mm.i.a.fqy;
        ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.I(2, (String)localObject1);
        com.tencent.mm.an.f.aDD().e((com.tencent.mm.i.g)localObject2);
        ac.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent:" + localObject2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2));
        zNH.put(str1, paramj);
        zNI.put(str1, Integer.valueOf(paramInt1));
        paramj = zNK.iterator();
        paramInt1 = 0;
        if (!paramj.hasNext()) {
          break label627;
        }
        if (k.g(((c)paramj.next()).hYq, paramc.hYq))
        {
          if (paramInt1 <= 0) {
            break label632;
          }
          zNK.set(paramInt1, paramc);
          zNJ.remove(str1);
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
      zNK.add(paramc);
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
    Object localObject = s.ztj;
    localObject = s.a(paramj);
    if (((com.tencent.mm.plugin.story.i.n)localObject).dZs())
    {
      ac.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay downloadFinish " + paramj.dyg);
      AppMethodBeat.o(120556);
      return 1;
    }
    if (((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(120556);
      return 0;
    }
    if (((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize * 100.0F >= zND.zMk)
    {
      ac.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay cachesize " + ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize + " totalSize: " + ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize);
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
    ac.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery, galleryItems size:" + ???.size() + ", positionV:" + paramInt1 + "  positionH:" + paramInt2 + ", skipPosition:true");
    Object localObject1 = zNM;
    k.h(???, "galleryItems");
    int i;
    if (((a)localObject1).gm(???)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(120551);
      return false;
      if ((((a)localObject1).zOa != paramInt2) || (((a)localObject1).zNZ != paramInt1)) {
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
        localObject1 = ((com.tencent.mm.plugin.story.f.d.h)localObject1).zuF;
        if (localObject1 != null) {
          zNP = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dyg;
        }
      }
    }
    zzJ = 0L;
    zNL = 0;
    zNM = new a(???, paramInt1, paramInt2, zNM);
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
            d.a.j.fOc();
          }
          localObject5 = (List)localObject5;
          if ((i < paramInt1) || (((List)localObject5).size() <= 0)) {
            break label957;
          }
          ((ArrayList)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.story.f.d.h)((List)localObject5).get(0)).zuF.dwR));
          break label957;
        }
        localObject4 = y.KTp;
        ??? = new ArrayList();
        if ((paramInt1 < ???.size()) && (paramInt2 < ((List)???.get(paramInt1)).size()))
        {
          i = ((List)???.get(paramInt1)).size();
          if (paramInt2 < i)
          {
            ((ArrayList)???).add(Integer.valueOf(((com.tencent.mm.plugin.story.f.d.h)((List)???.get(paramInt1)).get(paramInt2)).zuF.dwR));
            paramInt2 += 1;
          }
        }
      }
      Object localObject4 = (Iterable)zNK;
      ??? = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      label575:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        c localc = (c)localObject5;
        if ((!((ArrayList)localObject1).contains(Integer.valueOf(localc.zOf.dwR))) && (!((ArrayList)???).contains(Integer.valueOf(localc.zOf.dwR)))) {}
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
          l(((c)((Iterator)localObject1).next()).zOf);
        }
      }
      y localy = y.KTp;
      zNE = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMK, 1);
      paramInt1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pML, 450);
      paramInt2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMM, 200);
      zNF = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMN, 0);
      zNG = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMR, 100);
      zND.zMl = paramInt1;
      zND.zMm = paramInt2;
      i = CdnLogic.getRecentAverageSpeed(2);
      ac.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery clicfg_story_preload_strategy " + zNE + " clicfg_story_preload_speed_good:" + paramInt1 + " clicfg_story_preload_speed_bad:" + paramInt2 + " clicfg_story_preload_force_preload " + zNF + "  clicfg_story_preload_force_canload: " + zNG + " speed:" + i);
      if ((i > 0) && (zNG > 0) && (i < zNG))
      {
        ac.w("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery speed too low then pass " + i + " clicfg_story_preload_force_canload: " + zNG);
        ??? = new LinkedList();
        ???.addAll((Collection)zNK);
        ??? = ???.iterator();
        while (???.hasNext()) {
          l(((c)???.next()).zOf);
        }
      }
      AppMethodBeat.o(120551);
      return false;
      label957:
      i += 1;
    }
  }
  
  public static j dZX()
  {
    return zND;
  }
  
  private static List<Integer> dZY()
  {
    AppMethodBeat.i(120550);
    if (eab())
    {
      localList = zND.zMo;
      AppMethodBeat.o(120550);
      return localList;
    }
    List localList = zND.zMn;
    AppMethodBeat.o(120550);
    return localList;
  }
  
  public static void dZZ()
  {
    AppMethodBeat.i(120568);
    ac.m("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask", new Object[0]);
    Iterator localIterator = zNH.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ac.i("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask ".concat(String.valueOf(str)));
      com.tencent.mm.an.f.aDD().BR(str);
    }
    zNH.clear();
    zNI.clear();
    zNM = new a((List)new ArrayList());
    zNK.clear();
    AppMethodBeat.o(120568);
  }
  
  private static boolean eaa()
  {
    AppMethodBeat.i(120570);
    if (CdnLogic.getRecentAverageSpeed(2) >= zND.zMl)
    {
      AppMethodBeat.o(120570);
      return true;
    }
    AppMethodBeat.o(120570);
    return false;
  }
  
  private static boolean eab()
  {
    AppMethodBeat.i(120571);
    int i = zND.zMm;
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
  
  public static int eac()
  {
    AppMethodBeat.i(210147);
    int i = CdnLogic.getRecentAverageSpeed(2);
    AppMethodBeat.o(210147);
    return i;
  }
  
  private static boolean i(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120562);
    if (paramj.dWx())
    {
      AppMethodBeat.o(120562);
      return true;
    }
    s locals = s.ztj;
    if (i.aSp(s.a(paramj.zuP)) > 0L)
    {
      ac.i("MicroMsg.StoryVideoPreloadMgr", "isLocalVideo video downloadDone " + paramj.zuP.taskId + " username:" + paramj.username);
      AppMethodBeat.o(120562);
      return true;
    }
    locals = s.ztj;
    if (s.a(paramj).dZs())
    {
      ac.i("MicroMsg.StoryVideoPreloadMgr", " isLocalVideo video download finish " + paramj.zuP.taskId + " username:" + paramj.username);
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
    Object localObject = s.ztj;
    localObject = s.bU(paramj.hGU, paramj.zuP.Url);
    zNN = (String)localObject;
    zNO = Long.valueOf(paramj.dyg);
    ac.i("MicroMsg.StoryVideoPreloadMgr", "markCurrentPlay:" + zNN + " then remove it from preload");
    Iterator localIterator = ((Iterable)zNK).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!k.g(localObject, ((c)paramj).hYq));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj == null) {
        break;
      }
      zNK.remove(paramj);
      l(paramj.zOf);
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
    Object localObject1 = s.ztj;
    localObject1 = s.bU(paramj.hGU, paramj.zuP.Url);
    ac.i("MicroMsg.StoryVideoPreloadMgr", "checkPreloadOnVideoPlay:".concat(String.valueOf(localObject1)));
    Object localObject2 = s.ztj;
    localObject2 = s.a(paramj);
    if ((((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize > 0) && (((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize > 0))
    {
      float f = ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize;
      ac.i("MicroMsg.StoryVideoPreloadMgr", "hit cache, mediaId:" + (String)localObject1 + ", cachePercent:" + f + ", filePath:" + ((com.tencent.mm.plugin.story.i.n)localObject2).field_filePath);
      localObject2 = ((com.tencent.mm.plugin.story.i.n)localObject2).field_filePath;
      CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      long[] arrayOfLong = new long[2];
      localC2CDownloadRequest.fileKey = ((String)localObject1);
      localC2CDownloadRequest.fileType = 6;
      localC2CDownloadRequest.url = paramj.zuP.Url;
      localC2CDownloadRequest.setSavePath((String)localObject2);
      localC2CDownloadRequest.requestVideoFormat = com.tencent.mm.modelcontrol.d.I(1, (String)localObject2);
      boolean bool = CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong);
      ac.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " queryMoovReady: " + bool + ", offset:" + arrayOfLong[0] + ", length:" + arrayOfLong[1] + ", preloadFinish:" + d.a.j.a((Iterable)zNJ, localObject1));
      paramj = new b(true, arrayOfLong[0], arrayOfLong[1], d.a.j.a((Iterable)zNJ, localObject1));
      AppMethodBeat.o(120566);
      return paramj;
    }
    ac.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " not hit cache or moov not ready");
    paramj = new b(false, 0L, 0L, false);
    AppMethodBeat.o(120566);
    return paramj;
  }
  
  private static void l(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(120567);
    k.h(paramj, "videoItem");
    Object localObject = s.ztj;
    localObject = s.bU(paramj.hGU, paramj.zuP.Url);
    ac.i("MicroMsg.StoryVideoPreloadMgr", "cancelPreloadTask, videoItem:".concat(String.valueOf(localObject)));
    com.tencent.mm.an.f.aDD().BR((String)localObject);
    Iterator localIterator = ((Iterable)zNK).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!k.g(((c)paramj).hYq, localObject));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj == null) {
        break;
      }
      zNK.remove(paramj);
      if (zNL > 0) {
        zNL -= 1;
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
    if ((i(paramj)) || (paramj.dWx()))
    {
      ac.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo fail, " + paramj + " isLocalVideo or fake video");
      AppMethodBeat.o(120573);
      return false;
    }
    Object localObject = s.ztj;
    localObject = s.bU(paramj.hGU, paramj.zuP.Url);
    if ((!bs.isNullOrNil((String)localObject)) && (!bs.isNullOrNil(paramj.zuP.Url)) && (!d.n.n.I(zNN, (String)localObject, false)))
    {
      AppMethodBeat.o(120573);
      return true;
    }
    ac.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo:" + (String)localObject + ", already request preload or url " + paramj.zuP.Url);
    AppMethodBeat.o(120573);
    return false;
  }
  
  private final void rV(boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(120557);
    boolean bool1 = eaa();
    boolean bool2 = eab();
    int i = CdnLogic.getRecentAverageSpeed(2);
    if ((paramBoolean) && (i > 0) && (zNG > 0) && (i < zNG))
    {
      ac.w("MicroMsg.StoryVideoPreloadMgr", "speed too low then pass " + i + " clicfg_story_preload_force_canload: " + zNG + " callerFrom " + as.eVo());
      AppMethodBeat.o(120557);
      return;
    }
    int j = 0;
    if (bool2) {}
    for (i = 1;; i = 3)
    {
      if (zNE == 1) {
        i = k;
      }
      for (;;)
      {
        ac.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + zNK.size() + " maxTaskNum " + i + " totalPreLoadOneItemSelect " + zNL + " checkNet " + paramBoolean + " callerFrom " + as.eVo());
        List localList = dZY();
        while ((zNK.size() < i) && (j < localList.size()) && (zNL < 3) && (t(((Number)localList.get(j)).intValue(), "startPreLoad", QV(j))))
        {
          zNL += 1;
          j += 1;
        }
        ac.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue finish loop preload queue, current queue size: " + zNK.size() + ", pullPreloadTaskNum:0, preloadVideoNum:" + j + " preloadRunningSet " + zNK.size() + " totalPreLoadOneItemSelect " + zNL + ' ');
        AppMethodBeat.o(120557);
        return;
      }
    }
  }
  
  private final boolean t(int paramInt1, String paramString, int paramInt2)
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
        Object localObject1 = zNM;
        i = 0;
        localo = null;
        while ((i < ((a)localObject1).zNY.size()) && (localo == null))
        {
          localo = ((a)localObject1).eag();
          ac.i(a.TAG, "produceVideoItem walkVertical:" + ((a)localObject1).zNT + "  walkHorizontal:" + ((a)localObject1).zNU + " positionV:" + ((a)localObject1).zNZ + " positionH:" + ((a)localObject1).zOa + ", ret:" + localo);
          i += 1;
        }
        if (localo == null)
        {
          AppMethodBeat.o(120558);
          return false;
        }
        localj = (com.tencent.mm.plugin.story.f.d.j)localo.first;
        String str = ((c)localo.second).hYq;
        localObject1 = new StringBuilder("try preload mediaId ").append(str).append(" videoItem:").append(localj).append(" pos:").append((c)localo.second).append("  groupinfo ");
        Object localObject2 = zNM;
        ac.i("MicroMsg.StoryVideoPreloadMgr", new StringBuilder("positionV:").append(((a)localObject2).zNZ).append(", positionH:").append(((a)localObject2).zOa).append(", walkVertical:").append(((a)localObject2).zNT).append(", walkHorizontal:").append(((a)localObject2).zNU).toString() + " quota:" + paramInt1 + "  fromTag:" + paramString);
        localObject2 = ((Iterable)zNK).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
        } while (!k.g(((c)localObject1).hYq, str));
        for (;;)
        {
          localObject1 = (c)localObject1;
          if ((localObject1 == null) || (paramInt1 > ((c)localObject1).fsH)) {
            break label451;
          }
          ac.i("MicroMsg.StoryVideoPreloadMgr", "no need add quota " + paramInt1 + " cur:" + ((c)localObject1).fsH + " fromTag:" + paramString);
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
          i = a(str, localj.zuP, paramInt1, eaa());
          localObject1 = s.ztj;
          localObject1 = s.a(localj);
          if ((!((com.tencent.mm.plugin.story.i.n)localObject1).dZs()) && (((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize * 100.0F < i)) {
            break label643;
          }
          ac.i("MicroMsg.StoryVideoPreloadMgr", "pull preload video, " + str + ", already reach cache size! cacheSize:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize + ", totalSize:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize + ", cachePercent:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_cacheSize / ((com.tencent.mm.plugin.story.i.n)localObject1).field_totalSize * 100.0F + "  fromTag:" + paramString);
          break;
          i = 0;
          break label467;
        }
      }
    } while (!localm.a(localj, i, paramInt2, (c)localo.second));
    label641:
    label643:
    ((c)localo.second).fsH = paramInt1;
    AppMethodBeat.o(120558);
    return true;
  }
  
  public static void u(List<com.tencent.mm.plugin.story.f.d.j> paramList, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(120560);
    k.h(paramList, "videoItemList");
    ac.m("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList " + paramList.size(), new Object[0]);
    boolean bool1 = eaa();
    boolean bool2 = eab();
    ac.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + zNK.size() + " downloadExpect " + paramInt);
    List localList = dZY();
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
          k = QV(j);
          paramList = s.ztj;
          str = s.bU(localj.hGU, localj.zuP.Url);
          m = a(str, localj.zuP, i, eaa());
          paramList = s.ztj;
          localn = s.a(localj);
          Iterator localIterator2 = ((Iterable)zNK).iterator();
          if (!localIterator2.hasNext()) {
            break label585;
          }
          paramList = localIterator2.next();
          if (!k.g(((c)paramList).hYq, str)) {
            continue;
          }
          if (paramList == null) {
            break label382;
          }
          ac.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already prealoding!");
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
        i = ((Number)d.a.j.iQ(localList)).intValue();
        continue;
        label382:
        if ((localn.dZs()) || (localn.field_cacheSize / localn.field_totalSize * 100.0F >= m))
        {
          ac.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already reach cache size! cacheSize:" + localn.field_cacheSize + ", totalSize:" + localn.field_totalSize + ", cachePercent:" + localn.field_cacheSize / localn.field_totalSize * 100.0F);
        }
        else
        {
          paramList = new c(0, j, localj, i, k);
          if (zNR.a(localj, m, k, paramList))
          {
            j += 1;
            continue;
            paramList = y.KTp;
            ac.i("MicroMsg.StoryVideoPreloadMgr", "finish addPreloadVideo withList, total pull video task:" + j + " preloadRunningSet " + zNK.size());
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
    ac.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad " + paramj + ' ' + as.eVo());
    if (i(paramj))
    {
      ac.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay isLocalVideo");
      rV(false);
      AppMethodBeat.o(120555);
      return;
    }
    if (c(paramj) == 1)
    {
      ac.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay true");
      rV(true);
      AppMethodBeat.o(120555);
      return;
    }
    if (zNF == 1) {
      rV(true);
    }
    ac.i("MicroMsg.StoryVideoPreloadMgr", "nothing can checkPreLoad");
    AppMethodBeat.o(120555);
  }
  
  public final void yC(long paramLong)
  {
    AppMethodBeat.i(120553);
    if (zzJ == paramLong)
    {
      AppMethodBeat.o(120553);
      return;
    }
    zzJ = paramLong;
    if (zNE == 0)
    {
      AppMethodBeat.o(120553);
      return;
    }
    a locala = zNM;
    if (locala != null) {
      locala.eah();
    }
    rV(true);
    AppMethodBeat.o(120553);
  }
  
  public final void yD(long paramLong)
  {
    AppMethodBeat.i(120554);
    Object localObject = zNO;
    if (localObject == null) {}
    while (zNQ == paramLong)
    {
      AppMethodBeat.o(120554);
      return;
      if (((Long)localObject).longValue() == paramLong) {
        zNO = Long.valueOf(0L);
      }
    }
    zNQ = paramLong;
    if (zNE == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (zNG == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (zNK.size() > 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    localObject = zNM;
    if (localObject != null) {
      ((a)localObject).eah();
    }
    rV(false);
    AppMethodBeat.o(120554);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "", "groupItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "", "positionH", "lastGroup", "skipPosition", "", "(Ljava/util/List;IILcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;Z)V", "MAX_PRELOAD_COUNT", "horizontalList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "produceList", "Lkotlin/Function0;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "verticalList", "walkHorizontal", "walkIndex", "walkVertical", "info", "", "isDataChange", "isSame", "galleryItems", "produce", "produceHorizontalVideoItem", "produceVerticalVideoItem", "produceVideoItem", "reset", "", "resetWalk", "Companion", "plugin-story_release"})
  public static final class a
  {
    static final String TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
    public static final m.a.a zOc;
    private final int zNS;
    int zNT;
    int zNU;
    private int zNV;
    private ArrayList<com.tencent.mm.plugin.story.f.d.h> zNW;
    private ArrayList<com.tencent.mm.plugin.story.f.d.h> zNX;
    List<? extends d.g.a.a<d.o<com.tencent.mm.plugin.story.f.d.j, m.c>>> zNY;
    int zNZ;
    int zOa;
    private final boolean zOb;
    
    static
    {
      AppMethodBeat.i(120542);
      zOc = new m.a.a((byte)0);
      TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
      AppMethodBeat.o(120542);
    }
    
    public a(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> arg1, int paramInt1, int paramInt2, a arg4)
    {
      AppMethodBeat.i(120541);
      this.zNZ = paramInt1;
      this.zOa = paramInt2;
      this.zOb = true;
      this.zNS = 15;
      this.zNW = new ArrayList();
      this.zNX = new ArrayList();
      this.zNY = d.a.j.listOf(new d.g.a.a[] { (d.g.a.a)new b(this), (d.g.a.a)new c(this), (d.g.a.a)new d(this) });
      if (((??? != null) && (this.zNZ != ???.zNZ)) || ((??? != null) && (this.zOa != ???.zOa)) || (gm(???))) {
        reset();
      }
      this.zNW.clear();
      this.zNX.clear();
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
            this.zNX.add(localList.get(0));
          }
        }
        paramInt1 = 0;
      }
      Object localObject = y.KTp;
      if (this.zNZ < ???.size())
      {
        synchronized ((Iterable)???.get(this.zNZ))
        {
          ??? = ???.iterator();
          if (???.hasNext())
          {
            localObject = (com.tencent.mm.plugin.story.f.d.h)???.next();
            this.zNW.add(localObject);
          }
        }
        ??? = y.KTp;
        AppMethodBeat.o(120541);
        return;
      }
      AppMethodBeat.o(120541);
    }
    
    private final d.o<com.tencent.mm.plugin.story.f.d.j, m.c> eai()
    {
      AppMethodBeat.i(120539);
      for (;;)
      {
        if (this.zOb) {
          this.zNT += 1;
        }
        if (this.zNT >= this.zNX.size())
        {
          AppMethodBeat.o(120539);
          return null;
        }
        try
        {
          if (this.zNX.size() > 0)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)this.zNX.get(this.zNT)).zuF;
            m localm = m.zNR;
            if (m.n((com.tencent.mm.plugin.story.f.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new d.o(localObject1, new m.c(this.zNT, 0, (com.tencent.mm.plugin.story.f.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.zOb) {
            continue;
          }
          this.zNT += 1;
        }
        finally
        {
          if (!this.zOb) {
            this.zNT += 1;
          }
          AppMethodBeat.o(120539);
        }
      }
    }
    
    private final d.o<com.tencent.mm.plugin.story.f.d.j, m.c> eaj()
    {
      AppMethodBeat.i(120540);
      for (;;)
      {
        if (this.zOb) {
          this.zNU += 1;
        }
        if (this.zNU >= this.zNW.size())
        {
          AppMethodBeat.o(120540);
          return null;
        }
        try
        {
          if (this.zNW.size() > this.zNU)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)this.zNW.get(this.zNU)).zuF;
            m localm = m.zNR;
            if (m.n((com.tencent.mm.plugin.story.f.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new d.o(localObject1, new m.c(this.zNT, this.zNU, (com.tencent.mm.plugin.story.f.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.zOb) {
            continue;
          }
          this.zNU += 1;
        }
        finally
        {
          if (!this.zOb) {
            this.zNU += 1;
          }
          AppMethodBeat.o(120540);
        }
      }
    }
    
    private final void reset()
    {
      this.zNT = this.zNZ;
      this.zNU = this.zOa;
      this.zNV = 0;
    }
    
    final d.o<com.tencent.mm.plugin.story.f.d.j, m.c> eag()
    {
      AppMethodBeat.i(120536);
      try
      {
        if (this.zNV > this.zNS)
        {
          ac.i(TAG, "stop preload now " + this.zNV);
          AppMethodBeat.o(120536);
          return null;
        }
        d.o localo = (d.o)((d.g.a.a)this.zNY.get(this.zNV % this.zNY.size())).invoke();
        this.zNV += 1;
        AppMethodBeat.o(120536);
        return localo;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace(TAG, (Throwable)localException, "error on produce", new Object[0]);
        AppMethodBeat.o(120536);
      }
      return null;
    }
    
    public final void eah()
    {
      AppMethodBeat.i(120538);
      ac.i(TAG, "resetWalk");
      reset();
      AppMethodBeat.o(120538);
    }
    
    final boolean gm(List<? extends List<com.tencent.mm.plugin.story.f.d.h>> paramList)
    {
      AppMethodBeat.i(120537);
      if (paramList.size() == this.zNX.size())
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
          if (((com.tencent.mm.plugin.story.f.d.h)this.zNX.get(i)).zuF.dwR != ((com.tencent.mm.plugin.story.f.d.h)((List)paramList.get(i)).get(0)).zuF.dwR)
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
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<d.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      b(m.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<d.o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends m.c>>
    {
      c(m.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "", "isMoovReady", "", "offset", "", "length", "preloadFinish", "(ZJJZ)V", "()Z", "getLength", "()J", "getOffset", "getPreloadFinish", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-story_release"})
  public static final class b
  {
    final long length;
    final long offset;
    final boolean rvp;
    final boolean zOe;
    
    public b(boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
    {
      this.rvp = paramBoolean1;
      this.offset = paramLong1;
      this.length = paramLong2;
      this.zOe = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.rvp != paramObject.rvp) || (this.offset != paramObject.offset) || (this.length != paramObject.length) || (this.zOe != paramObject.zOe)) {}
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
      String str = "MoovReadyInfo(isMoovReady=" + this.rvp + ", offset=" + this.offset + ", length=" + this.length + ", preloadFinish=" + this.zOe + ")";
      AppMethodBeat.o(120545);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "", "positionV", "", "positionH", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "quota", "connectionCount", "(IILcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;II)V", "cdnMediaId", "", "getCdnMediaId", "()Ljava/lang/String;", "setCdnMediaId", "(Ljava/lang/String;)V", "getConnectionCount", "()I", "setConnectionCount", "(I)V", "getItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getPositionH", "getPositionV", "getQuota", "setQuota", "info", "plugin-story_release"})
  public static final class c
  {
    private int connectionCount;
    int fsH;
    String hYq;
    private final int zNZ;
    private final int zOa;
    final com.tencent.mm.plugin.story.f.d.j zOf;
    
    public c(int paramInt1, int paramInt2, com.tencent.mm.plugin.story.f.d.j paramj, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(120546);
      this.zNZ = paramInt1;
      this.zOa = paramInt2;
      this.zOf = paramj;
      this.fsH = paramInt3;
      this.connectionCount = paramInt4;
      paramj = s.ztj;
      String str = s.bU(this.zOf.hGU, this.zOf.zuP.Url);
      paramj = str;
      if (str == null) {
        paramj = "";
      }
      this.hYq = paramj;
      AppMethodBeat.o(120546);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "startTick", "", "(J)V", "onPreloadCompleted", "", "mediaId", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-story_release"})
  static final class d
    implements g.b
  {
    private final long fQT;
    
    public d(long paramLong)
    {
      this.fQT = paramLong;
    }
    
    public final void b(String paramString, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(120548);
      ac.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", sceneResult:" + paramd);
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        ac.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", video source change!");
        paramd = m.zNR;
        m.axm(paramString);
        AppMethodBeat.o(120548);
        return;
      }
      if ((paramString != null) && (paramd != null))
      {
        Object localObject = m.zNR;
        if (m.ead().containsKey(paramString))
        {
          localObject = m.zNR;
          localObject = (com.tencent.mm.plugin.story.f.d.j)m.ead().get(paramString);
          if (localObject != null)
          {
            if ((paramd.field_recvedBytes > 0L) && (paramd.field_fileLength > 0L))
            {
              s locals = s.ztj;
              localObject = s.a((com.tencent.mm.plugin.story.f.d.j)localObject);
              ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize = ((int)paramd.field_recvedBytes);
              ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize = ((int)paramd.field_fileLength);
              paramd = com.tencent.mm.plugin.story.f.j.zsh;
              j.b.dVI().b((com.tencent.mm.plugin.story.i.n)localObject);
              paramd = m.zNR;
              m.eae().add(paramString);
              ac.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted update cacheSize:" + ((com.tencent.mm.plugin.story.i.n)localObject).field_cacheSize + ", totalSize:" + ((com.tencent.mm.plugin.story.i.n)localObject).field_totalSize + ", preloadCost:" + bs.aO(this.fQT));
              com.tencent.mm.ac.c.g((d.g.a.a)new a(paramString));
              AppMethodBeat.o(120548);
              return;
            }
            ac.e("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted error, recvedBytes:" + paramd.field_recvedBytes + ", fileLength:" + paramd.field_fileLength);
          }
        }
      }
      AppMethodBeat.o(120548);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "()V", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  static final class e
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(120549);
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        ac.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreload, mediaId:" + paramString + ", video source change!");
        paramc = m.zNR;
        m.axm(paramString);
        AppMethodBeat.o(120549);
        return 0;
      }
      Object localObject1;
      int i;
      if ((paramc != null) && (paramc.field_toltalLength > 0L))
      {
        paramd = m.zNR;
        localObject1 = (com.tencent.mm.plugin.story.f.d.j)m.ead().get(paramString);
        paramd = m.zNR;
        paramBoolean = d.a.j.a((Iterable)m.eae(), paramString);
        int j = (int)((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F);
        paramd = m.zNR;
        paramd = (Integer)m.eaf().get(paramString);
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
          Object localObject2 = s.ztj;
          localObject2 = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
          ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize = ((int)paramc.field_finishedLength);
          ((com.tencent.mm.plugin.story.i.n)localObject2).field_totalSize = ((int)paramc.field_toltalLength);
          paramc = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dVI().b((com.tencent.mm.plugin.story.i.n)localObject2);
          paramc = com.tencent.mm.plugin.story.f.j.zsh;
          com.tencent.mm.plugin.story.i.f localf = j.b.dVF().awy(((com.tencent.mm.plugin.story.f.d.j)localObject1).username);
          paramc = paramd;
          if (localf.field_syncId == ((com.tencent.mm.plugin.story.f.d.j)localObject1).dyg)
          {
            paramc = paramd;
            if (localf.isValid())
            {
              long l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dyg;
              localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).zuP.Id;
              k.g(localObject1, "videoItem.media.Id");
              paramc = paramd;
              if (localf.a(l, (String)localObject1, ((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize))
              {
                paramc = paramd + " * ext pre update * ";
                paramd = com.tencent.mm.plugin.story.f.j.zsh;
                j.b.dVF().a((int)localf.systemRowid, localf);
              }
            }
          }
          if ((paramInt != 0) && (paramString != null))
          {
            paramd = m.zNR;
            m.eae().add(paramString);
          }
        }
        for (paramString = paramc + "update cacheSize done";; paramString = paramd)
        {
          paramString = new StringBuilder().append(paramString).append(", currentSpeed:");
          paramc = m.zNR;
          ac.i("MicroMsg.StoryVideoPreloadMgr", m.eac());
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