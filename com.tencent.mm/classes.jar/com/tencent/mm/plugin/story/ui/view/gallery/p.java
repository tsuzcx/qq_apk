package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.k;
import a.l.m;
import a.o;
import a.y;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
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

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr;", "", "()V", "MAX_PRELOAD_TASK_LIMIT", "", "TAG", "", "clicfg_story_preload_force_canload", "getClicfg_story_preload_force_canload", "()I", "setClicfg_story_preload_force_canload", "(I)V", "clicfg_story_preload_force_preload", "getClicfg_story_preload_force_preload", "setClicfg_story_preload_force_preload", "clicfg_story_preload_strategy", "getClicfg_story_preload_strategy", "setClicfg_story_preload_strategy", "groupData", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "lastFinishStoryId", "", "getLastFinishStoryId", "()J", "setLastFinishStoryId", "(J)V", "lastStoryId", "getLastStoryId", "setLastStoryId", "playingMediaId", "preLoadConfig", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "getPreLoadConfig", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "setPreLoadConfig", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;)V", "preloadFinishSet", "", "preloadInfoRatioSet", "", "preloadInfoSet", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadRunningSet", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "runningMediaId", "Ljava/lang/Long;", "selectMediaId", "totalPreLoadOneItemSelect", "getTotalPreLoadOneItemSelect", "setTotalPreLoadOneItemSelect", "addPreLoadTask", "", "quota", "fromTag", "connectionCount", "addPreloadVideo", "", "videoItemList", "", "downloadExpect", "calcPreloadPercent", "mediaId", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "cacheSecondsDowngrade", "isGoodNetwork", "cancelAllPreloadTask", "cancelPreloadTask", "videoItem", "checkCanPlay", "item", "checkPreLoad", "checkPreloadOnVideoPlay", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "url", "path", "preloadPercent", "getNetworkSpeed", "isBadNetwork", "isLocalVideo", "makrFinish", "storyId", "markCurrentPlay", "markOnVideoFirstFrameDraw", "needPreLoad", "onVideoSourceChange", "preloadVideoWithPercent", "percent", "taskInfo", "queryQuota", "setPreloadQueueFromGallery", "groupItems", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "positionH", "skipPosition", "startPreLoad", "checkNet", "taskConnectionCount", "index", "upgrades", "GroupData", "MoovReadyInfo", "TaskInfo", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-story_release"})
public final class p
{
  private static long sDC;
  private static final List<p.c> sUA;
  private static int sUB;
  private static p.a sUC;
  private static volatile String sUD;
  private static volatile Long sUE;
  private static long sUF;
  private static long sUG;
  public static final p sUH;
  private static l sUt;
  private static int sUu;
  private static int sUv;
  private static int sUw;
  private static final Map<String, i> sUx;
  private static final Map<String, Integer> sUy;
  private static final Set<String> sUz;
  
  static
  {
    AppMethodBeat.i(110904);
    sUH = new p();
    sUt = new l();
    Object localObject = Collections.synchronizedMap((Map)new HashMap());
    a.f.b.j.p(localObject, "Collections.synchronized…tring, StoryVideoItem>())");
    sUx = (Map)localObject;
    localObject = Collections.synchronizedMap((Map)new HashMap());
    a.f.b.j.p(localObject, "Collections.synchronized…p(HashMap<String, Int>())");
    sUy = (Map)localObject;
    localObject = Collections.synchronizedSet((Set)new HashSet());
    a.f.b.j.p(localObject, "Collections.synchronizedSet(HashSet<String>())");
    sUz = (Set)localObject;
    localObject = Collections.synchronizedList((List)new LinkedList());
    a.f.b.j.p(localObject, "Collections.synchronized…t(LinkedList<TaskInfo>())");
    sUA = (List)localObject;
    sUB = 3;
    sUC = new p.a((List)new ArrayList());
    AppMethodBeat.o(110904);
  }
  
  private static int Gi(int paramInt)
  {
    AppMethodBeat.i(110894);
    ab.i("MicroMsg.StoryVideoPreloadMgr", "taskConnectionCount: ".concat(String.valueOf(paramInt)));
    List localList = sUt.sTh;
    if (paramInt < sUt.sTh.size()) {}
    for (;;)
    {
      paramInt = ((Number)localList.get(paramInt)).intValue();
      AppMethodBeat.o(110894);
      return paramInt;
      paramInt = sUt.sTh.size() - 1;
    }
  }
  
  private static int a(String paramString, chl paramchl, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(110899);
    float f = paramchl.duration;
    ab.i("MicroMsg.StoryVideoPreloadMgr", "calcPreloadPercent, cacheSecondsDowngrade:" + paramInt + ", mediaId:" + paramString + ", duration:" + f + ", isGoodNetwork:" + paramBoolean + " media:" + paramchl.duration);
    int i;
    if (paramBoolean)
    {
      i = 5;
      if (f > 0.0F) {
        break label135;
      }
      paramInt = sUt.sTc;
    }
    for (;;)
    {
      i = paramInt;
      if (paramInt <= sUt.sTc) {
        i = sUt.sTc;
      }
      AppMethodBeat.o(110899);
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
  
  private boolean a(i parami, int paramInt1, int paramInt2, p.c paramc)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(110893);
        a.f.b.j.q(parami, "videoItem");
        a.f.b.j.q(paramc, "taskInfo");
        if ((parami.cBM()) || (bo.isNullOrNil(parami.syB.Url)))
        {
          AppMethodBeat.o(110893);
          bool = false;
          return bool;
        }
        if (j(parami))
        {
          ab.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, isLocalVideo: " + parami.syB.Url);
          AppMethodBeat.o(110893);
          bool = false;
          continue;
        }
        String str2 = parami.syB.Url;
        String str1 = paramc.fVf;
        Object localObject1 = s.swk;
        localObject1 = s.a(parami);
        ab.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, " + str1 + ", " + paramInt1 + ", playingMediaId:" + sUD + ", " + ((n)localObject1).field_filePath + ", " + str2 + "  videoCache " + localObject1);
        if ((str1 == null) || (m.I(sUD, str1, false))) {
          break label646;
        }
        Object localObject2 = s.swk;
        e.um(s.adj(parami.username));
        a.f.b.j.p(str2, "url");
        localObject1 = ((n)localObject1).field_filePath;
        a.f.b.j.p(localObject1, "videoCache.field_filePath");
        ab.i("MicroMsg.StoryVideoPreloadMgr", "createVideoPreloadCDNTask, mediaId:" + str1 + ", path:" + (String)localObject1 + ", url:" + str2 + ", preloadPercent:" + paramInt1 + ", connectionCount:" + paramInt2);
        localObject2 = new h();
        ((h)localObject2).field_mediaId = str1;
        ((h)localObject2).url = str2;
        ((h)localObject2).edD = 2;
        ((h)localObject2).edJ = 2;
        ((h)localObject2).edE = 6;
        ((h)localObject2).edO = paramInt1;
        ((h)localObject2).field_preloadRatio = paramInt1;
        ((h)localObject2).concurrentCount = 4;
        ((h)localObject2).field_fullpath = ((String)localObject1);
        ((h)localObject2).edp = ((g.a)new p.e());
        ((h)localObject2).edF = ((g.b)new p.d(bo.yB()));
        ((h)localObject2).connectionCount = paramInt2;
        ((h)localObject2).field_fileType = com.tencent.mm.i.a.ecN;
        ((h)localObject2).field_requestVideoFormat = d.y(2, (String)localObject1);
        f.afO().d((com.tencent.mm.i.g)localObject2);
        ab.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent:" + localObject2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2));
        sUx.put(str1, parami);
        sUy.put(str1, Integer.valueOf(paramInt1));
        parami = sUA.iterator();
        paramInt1 = 0;
        if (!parami.hasNext()) {
          break label627;
        }
        if (a.f.b.j.e(((p.c)parami.next()).fVf, paramc.fVf))
        {
          if (paramInt1 <= 0) {
            break label632;
          }
          sUA.set(paramInt1, paramc);
          sUz.remove(str1);
          bool = true;
          AppMethodBeat.o(110893);
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
      sUA.add(paramc);
      continue;
      label646:
      AppMethodBeat.o(110893);
      boolean bool = false;
    }
  }
  
  private static int b(i parami)
  {
    AppMethodBeat.i(110886);
    a.f.b.j.q(parami, "item");
    Object localObject = s.swk;
    localObject = s.a(parami);
    if (((n)localObject).cFk())
    {
      ab.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay downloadFinish " + parami.cJA);
      AppMethodBeat.o(110886);
      return 1;
    }
    if (((n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(110886);
      return 0;
    }
    if (((n)localObject).field_cacheSize / ((n)localObject).field_totalSize * 100.0F >= sUt.sTc)
    {
      ab.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay cachesize " + ((n)localObject).field_cacheSize + " totalSize: " + ((n)localObject).field_totalSize);
      AppMethodBeat.o(110886);
      return 1;
    }
    AppMethodBeat.o(110886);
    return 0;
  }
  
  private static boolean c(List<? extends List<com.tencent.mm.plugin.story.model.d.g>> arg0, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110881);
    a.f.b.j.q(???, "groupItems");
    ab.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery, galleryItems size:" + ???.size() + ", positionV:" + paramInt1 + "  positionH:" + paramInt2 + ", skipPosition:true");
    Object localObject1 = sUC;
    a.f.b.j.q(???, "galleryItems");
    int i;
    if (((p.a)localObject1).dP(???)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(110881);
      return false;
      if ((((p.a)localObject1).sUQ != paramInt2) || (((p.a)localObject1).sUP != paramInt1)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 < ???.size()) && (paramInt2 < ((List)???.get(paramInt1)).size()))
    {
      localObject1 = (com.tencent.mm.plugin.story.model.d.g)((List)???.get(paramInt1)).get(paramInt2);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.story.model.d.g)localObject1).syr;
        if (localObject1 != null) {
          sUF = ((i)localObject1).cJA;
        }
      }
    }
    sDC = 0L;
    sUB = 0;
    sUC = new p.a(???, paramInt1, paramInt2, sUC);
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
            a.a.j.eaS();
          }
          localObject5 = (List)localObject5;
          if ((i < paramInt1) || (((List)localObject5).size() <= 0)) {
            break label957;
          }
          ((ArrayList)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.story.model.d.g)((List)localObject5).get(0)).syr.cIp));
          break label957;
        }
        localObject4 = y.BMg;
        ??? = new ArrayList();
        if ((paramInt1 < ???.size()) && (paramInt2 < ((List)???.get(paramInt1)).size()))
        {
          i = ((List)???.get(paramInt1)).size();
          if (paramInt2 < i)
          {
            ((ArrayList)???).add(Integer.valueOf(((com.tencent.mm.plugin.story.model.d.g)((List)???.get(paramInt1)).get(paramInt2)).syr.cIp));
            paramInt2 += 1;
          }
        }
      }
      Object localObject4 = (Iterable)sUA;
      ??? = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      label575:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        p.c localc = (p.c)localObject5;
        if ((!((ArrayList)localObject1).contains(Integer.valueOf(localc.sUW.cIp))) && (!((ArrayList)???).contains(Integer.valueOf(localc.sUW.cIp)))) {}
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
          m(((p.c)((Iterator)localObject1).next()).sUW);
        }
      }
      y localy = y.BMg;
      sUu = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRZ, 1);
      paramInt1 = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSa, 450);
      paramInt2 = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSb, 200);
      sUv = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSc, 0);
      sUw = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSg, 100);
      sUt.sTd = paramInt1;
      sUt.sTe = paramInt2;
      i = CdnLogic.getRecentAverageSpeed(2);
      ab.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery clicfg_story_preload_strategy " + sUu + " clicfg_story_preload_speed_good:" + paramInt1 + " clicfg_story_preload_speed_bad:" + paramInt2 + " clicfg_story_preload_force_preload " + sUv + "  clicfg_story_preload_force_canload: " + sUw + " speed:" + i);
      if ((i > 0) && (sUw > 0) && (i < sUw))
      {
        ab.w("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery speed too low then pass " + i + " clicfg_story_preload_force_canload: " + sUw);
        ??? = new LinkedList();
        ???.addAll((Collection)sUA);
        ??? = ???.iterator();
        while (???.hasNext()) {
          m(((p.c)???.next()).sUW);
        }
      }
      AppMethodBeat.o(110881);
      return false;
      label957:
      i += 1;
    }
  }
  
  public static l cGg()
  {
    return sUt;
  }
  
  private static List<Integer> cGh()
  {
    AppMethodBeat.i(110880);
    if (cGk())
    {
      localList = sUt.sTg;
      AppMethodBeat.o(110880);
      return localList;
    }
    List localList = sUt.sTf;
    AppMethodBeat.o(110880);
    return localList;
  }
  
  public static void cGi()
  {
    AppMethodBeat.i(110898);
    ab.b("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask", new Object[0]);
    Iterator localIterator = sUx.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ab.i("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask ".concat(String.valueOf(str)));
      f.afO().sJ(str);
    }
    sUx.clear();
    sUy.clear();
    sUC = new p.a((List)new ArrayList());
    sUA.clear();
    AppMethodBeat.o(110898);
  }
  
  private static boolean cGj()
  {
    AppMethodBeat.i(110900);
    if (CdnLogic.getRecentAverageSpeed(2) >= sUt.sTd)
    {
      AppMethodBeat.o(110900);
      return true;
    }
    AppMethodBeat.o(110900);
    return false;
  }
  
  private static boolean cGk()
  {
    AppMethodBeat.i(110901);
    int i = sUt.sTe;
    int j = CdnLogic.getRecentAverageSpeed(2);
    if (1 > j) {}
    while (i < j)
    {
      AppMethodBeat.o(110901);
      return false;
    }
    AppMethodBeat.o(110901);
    return true;
  }
  
  public static int cGl()
  {
    AppMethodBeat.i(156827);
    int i = CdnLogic.getRecentAverageSpeed(2);
    AppMethodBeat.o(156827);
    return i;
  }
  
  private static boolean j(i parami)
  {
    AppMethodBeat.i(110892);
    if (parami.cBM())
    {
      AppMethodBeat.o(110892);
      return true;
    }
    s locals = s.swk;
    if (e.avI(s.a(parami.syB)) > 0L)
    {
      ab.i("MicroMsg.StoryVideoPreloadMgr", "isLocalVideo video downloadDone " + parami.syB.cIp + " username:" + parami.username);
      AppMethodBeat.o(110892);
      return true;
    }
    locals = s.swk;
    if (s.a(parami).cFk())
    {
      ab.i("MicroMsg.StoryVideoPreloadMgr", " isLocalVideo video download finish " + parami.syB.cIp + " username:" + parami.username);
      AppMethodBeat.o(110892);
      return true;
    }
    AppMethodBeat.o(110892);
    return false;
  }
  
  public static void k(i parami)
  {
    AppMethodBeat.i(110895);
    a.f.b.j.q(parami, "videoItem");
    Object localObject = s.swk;
    localObject = s.be(parami.fDT, parami.syB.Url);
    sUD = (String)localObject;
    sUE = Long.valueOf(parami.cJA);
    ab.i("MicroMsg.StoryVideoPreloadMgr", "markCurrentPlay:" + sUD + " then remove it from preload");
    Iterator localIterator = ((Iterable)sUA).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      parami = localIterator.next();
    } while (!a.f.b.j.e(localObject, ((p.c)parami).fVf));
    for (;;)
    {
      parami = (p.c)parami;
      if (parami == null) {
        break;
      }
      sUA.remove(parami);
      m(parami.sUW);
      AppMethodBeat.o(110895);
      return;
      parami = null;
    }
    AppMethodBeat.o(110895);
  }
  
  public static p.b l(i parami)
  {
    AppMethodBeat.i(110896);
    a.f.b.j.q(parami, "videoItem");
    Object localObject1 = s.swk;
    localObject1 = s.be(parami.fDT, parami.syB.Url);
    ab.i("MicroMsg.StoryVideoPreloadMgr", "checkPreloadOnVideoPlay:".concat(String.valueOf(localObject1)));
    Object localObject2 = s.swk;
    localObject2 = s.a(parami);
    if ((((n)localObject2).field_cacheSize > 0) && (((n)localObject2).field_totalSize > 0))
    {
      float f = ((n)localObject2).field_cacheSize / ((n)localObject2).field_totalSize;
      ab.i("MicroMsg.StoryVideoPreloadMgr", "hit cache, mediaId:" + (String)localObject1 + ", cachePercent:" + f + ", filePath:" + ((n)localObject2).field_filePath);
      localObject2 = ((n)localObject2).field_filePath;
      CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      long[] arrayOfLong = new long[2];
      localC2CDownloadRequest.fileKey = ((String)localObject1);
      localC2CDownloadRequest.fileType = 6;
      localC2CDownloadRequest.url = parami.syB.Url;
      localC2CDownloadRequest.savePath = ((String)localObject2);
      localC2CDownloadRequest.requestVideoFormat = d.y(1, (String)localObject2);
      boolean bool = CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong);
      ab.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " queryMoovReady: " + bool + ", offset:" + arrayOfLong[0] + ", length:" + arrayOfLong[1] + ", preloadFinish:" + a.a.j.a((Iterable)sUz, localObject1));
      parami = new p.b(true, arrayOfLong[0], arrayOfLong[1], a.a.j.a((Iterable)sUz, localObject1));
      AppMethodBeat.o(110896);
      return parami;
    }
    ab.i("MicroMsg.StoryVideoPreloadMgr", (String)localObject1 + " not hit cache or moov not ready");
    parami = new p.b(false, 0L, 0L, false);
    AppMethodBeat.o(110896);
    return parami;
  }
  
  private static void m(i parami)
  {
    AppMethodBeat.i(110897);
    a.f.b.j.q(parami, "videoItem");
    Object localObject = s.swk;
    localObject = s.be(parami.fDT, parami.syB.Url);
    ab.i("MicroMsg.StoryVideoPreloadMgr", "cancelPreloadTask, videoItem:".concat(String.valueOf(localObject)));
    f.afO().sJ((String)localObject);
    Iterator localIterator = ((Iterable)sUA).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      parami = localIterator.next();
    } while (!a.f.b.j.e(((p.c)parami).fVf, localObject));
    for (;;)
    {
      parami = (p.c)parami;
      if (parami == null) {
        break;
      }
      sUA.remove(parami);
      if (sUB > 0) {
        sUB -= 1;
      }
      AppMethodBeat.o(110897);
      return;
      parami = null;
    }
    AppMethodBeat.o(110897);
  }
  
  private final boolean m(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(110888);
    p localp;
    int i;
    o localo;
    i locali;
    label451:
    label467:
    label637:
    do
    {
      for (;;)
      {
        localp = (p)this;
        Object localObject1 = sUC;
        i = 0;
        localo = null;
        while ((i < ((p.a)localObject1).sUO.size()) && (localo == null))
        {
          localo = ((p.a)localObject1).cGp();
          ab.i(p.a.TAG, "produceVideoItem walkVertical:" + ((p.a)localObject1).sUJ + "  walkHorizontal:" + ((p.a)localObject1).sUK + " positionV:" + ((p.a)localObject1).sUP + " positionH:" + ((p.a)localObject1).sUQ + ", ret:" + localo);
          i += 1;
        }
        if (localo == null)
        {
          AppMethodBeat.o(110888);
          return false;
        }
        locali = (i)localo.first;
        String str = ((p.c)localo.second).fVf;
        localObject1 = new StringBuilder("try preload mediaId ").append(str).append(" videoItem:").append(locali).append(" pos:").append((p.c)localo.second).append("  groupinfo ");
        Object localObject2 = sUC;
        ab.i("MicroMsg.StoryVideoPreloadMgr", new StringBuilder("positionV:").append(((p.a)localObject2).sUP).append(", positionH:").append(((p.a)localObject2).sUQ).append(", walkVertical:").append(((p.a)localObject2).sUJ).append(", walkHorizontal:").append(((p.a)localObject2).sUK).toString() + " quota:" + paramInt1 + "  fromTag:" + paramString);
        localObject2 = ((Iterable)sUA).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
        } while (!a.f.b.j.e(((p.c)localObject1).fVf, str));
        for (;;)
        {
          localObject1 = (p.c)localObject1;
          if ((localObject1 == null) || (paramInt1 > ((p.c)localObject1).eeI)) {
            break label451;
          }
          ab.i("MicroMsg.StoryVideoPreloadMgr", "no need add quota " + paramInt1 + " cur:" + ((p.c)localObject1).eeI + " fromTag:" + paramString);
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
          i = a(str, locali.syB, paramInt1, cGj());
          localObject1 = s.swk;
          localObject1 = s.a(locali);
          if ((!((n)localObject1).cFk()) && (((n)localObject1).field_cacheSize / ((n)localObject1).field_totalSize * 100.0F < i)) {
            break label643;
          }
          ab.i("MicroMsg.StoryVideoPreloadMgr", "pull preload video, " + str + ", already reach cache size! cacheSize:" + ((n)localObject1).field_cacheSize + ", totalSize:" + ((n)localObject1).field_totalSize + ", cachePercent:" + ((n)localObject1).field_cacheSize / ((n)localObject1).field_totalSize * 100.0F + "  fromTag:" + paramString);
          break;
          i = 0;
          break label467;
        }
      }
    } while (!localp.a(locali, i, paramInt2, (p.c)localo.second));
    label641:
    label643:
    ((p.c)localo.second).eeI = paramInt1;
    AppMethodBeat.o(110888);
    return true;
  }
  
  private final void mt(boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(110887);
    boolean bool1 = cGj();
    boolean bool2 = cGk();
    int i = CdnLogic.getRecentAverageSpeed(2);
    if ((paramBoolean) && (i > 0) && (sUw > 0) && (i < sUw))
    {
      ab.w("MicroMsg.StoryVideoPreloadMgr", "speed too low then pass " + i + " clicfg_story_preload_force_canload: " + sUw + " callerFrom " + an.dtg());
      AppMethodBeat.o(110887);
      return;
    }
    int j = 0;
    if (bool2) {}
    for (i = 1;; i = 3)
    {
      if (sUu == 1) {
        i = k;
      }
      for (;;)
      {
        ab.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + sUA.size() + " maxTaskNum " + i + " totalPreLoadOneItemSelect " + sUB + " checkNet " + paramBoolean + " callerFrom " + an.dtg());
        List localList = cGh();
        while ((sUA.size() < i) && (j < localList.size()) && (sUB < 3) && (m(((Number)localList.get(j)).intValue(), "startPreLoad", Gi(j))))
        {
          sUB += 1;
          j += 1;
        }
        ab.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue finish loop preload queue, current queue size: " + sUA.size() + ", pullPreloadTaskNum:0, preloadVideoNum:" + j + " preloadRunningSet " + sUA.size() + " totalPreLoadOneItemSelect " + sUB + ' ');
        AppMethodBeat.o(110887);
        return;
      }
    }
  }
  
  private static boolean n(i parami)
  {
    AppMethodBeat.i(110903);
    if ((j(parami)) || (parami.cBM()))
    {
      ab.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo fail, " + parami + " isLocalVideo or fake video");
      AppMethodBeat.o(110903);
      return false;
    }
    Object localObject = s.swk;
    localObject = s.be(parami.fDT, parami.syB.Url);
    if ((!bo.isNullOrNil((String)localObject)) && (!bo.isNullOrNil(parami.syB.Url)) && (!m.I(sUD, (String)localObject, false)))
    {
      AppMethodBeat.o(110903);
      return true;
    }
    ab.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo:" + (String)localObject + ", already request preload or url " + parami.syB.Url);
    AppMethodBeat.o(110903);
    return false;
  }
  
  public static void p(List<i> paramList, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(110890);
    a.f.b.j.q(paramList, "videoItemList");
    ab.b("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList " + paramList.size(), new Object[0]);
    boolean bool1 = cGj();
    boolean bool2 = cGk();
    ab.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + sUA.size() + " downloadExpect " + paramInt);
    List localList = cGh();
    for (;;)
    {
      i locali;
      int i;
      int k;
      String str;
      int m;
      n localn;
      synchronized ((Iterable)paramList)
      {
        Iterator localIterator1 = ???.iterator();
        if (!localIterator1.hasNext()) {
          break label532;
        }
        locali = (i)localIterator1.next();
        if (!n(locali)) {
          continue;
        }
        if (paramInt > 0)
        {
          i = paramInt;
          k = Gi(j);
          paramList = s.swk;
          str = s.be(locali.fDT, locali.syB.Url);
          m = a(str, locali.syB, i, cGj());
          paramList = s.swk;
          localn = s.a(locali);
          Iterator localIterator2 = ((Iterable)sUA).iterator();
          if (!localIterator2.hasNext()) {
            break label585;
          }
          paramList = localIterator2.next();
          if (!a.f.b.j.e(((p.c)paramList).fVf, str)) {
            continue;
          }
          if (paramList == null) {
            break label382;
          }
          ab.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already prealoding!");
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
        i = ((Number)a.a.j.fS(localList)).intValue();
        continue;
        label382:
        if ((localn.cFk()) || (localn.field_cacheSize / localn.field_totalSize * 100.0F >= m))
        {
          ab.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already reach cache size! cacheSize:" + localn.field_cacheSize + ", totalSize:" + localn.field_totalSize + ", cachePercent:" + localn.field_cacheSize / localn.field_totalSize * 100.0F);
        }
        else
        {
          paramList = new p.c(0, j, locali, i, k);
          if (sUH.a(locali, m, k, paramList))
          {
            j += 1;
            continue;
            paramList = y.BMg;
            ab.i("MicroMsg.StoryVideoPreloadMgr", "finish addPreloadVideo withList, total pull video task:" + j + " preloadRunningSet " + sUA.size());
            AppMethodBeat.o(110890);
            return;
            paramList = null;
          }
        }
      }
    }
  }
  
  public final void i(i parami)
  {
    AppMethodBeat.i(110885);
    a.f.b.j.q(parami, "item");
    ab.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad " + parami + ' ' + an.dtg());
    if (j(parami))
    {
      ab.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay isLocalVideo");
      mt(false);
      AppMethodBeat.o(110885);
      return;
    }
    if (b(parami) == 1)
    {
      ab.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay true");
      mt(true);
      AppMethodBeat.o(110885);
      return;
    }
    if (sUv == 1) {
      mt(true);
    }
    ab.i("MicroMsg.StoryVideoPreloadMgr", "nothing can checkPreLoad");
    AppMethodBeat.o(110885);
  }
  
  public final void mY(long paramLong)
  {
    AppMethodBeat.i(110883);
    if (sDC == paramLong)
    {
      AppMethodBeat.o(110883);
      return;
    }
    sDC = paramLong;
    if (sUu == 0)
    {
      AppMethodBeat.o(110883);
      return;
    }
    p.a locala = sUC;
    if (locala != null) {
      locala.cGq();
    }
    mt(true);
    AppMethodBeat.o(110883);
  }
  
  public final void mZ(long paramLong)
  {
    AppMethodBeat.i(110884);
    Object localObject = sUE;
    if (localObject == null) {}
    while (sUG == paramLong)
    {
      AppMethodBeat.o(110884);
      return;
      if (((Long)localObject).longValue() == paramLong) {
        sUE = Long.valueOf(0L);
      }
    }
    sUG = paramLong;
    if (sUu == 0)
    {
      AppMethodBeat.o(110884);
      return;
    }
    if (sUw == 0)
    {
      AppMethodBeat.o(110884);
      return;
    }
    if (sUA.size() > 0)
    {
      AppMethodBeat.o(110884);
      return;
    }
    localObject = sUC;
    if (localObject != null) {
      ((p.a)localObject).cGq();
    }
    mt(false);
    AppMethodBeat.o(110884);
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a$a {}
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
  static final class a$b
    extends k
    implements a.f.a.a<o<? extends i, ? extends p.c>>
  {
    a$b(p.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.p
 * JD-Core Version:    0.7.0.1
 */