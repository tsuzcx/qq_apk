package com.tencent.mm.plugin.story.ui.view.gallery;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.g.a;
import com.tencent.mm.g.g.b;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr;", "", "()V", "MAX_PRELOAD_TASK_LIMIT", "", "TAG", "", "clicfg_story_preload_force_canload", "getClicfg_story_preload_force_canload", "()I", "setClicfg_story_preload_force_canload", "(I)V", "clicfg_story_preload_force_preload", "getClicfg_story_preload_force_preload", "setClicfg_story_preload_force_preload", "clicfg_story_preload_strategy", "getClicfg_story_preload_strategy", "setClicfg_story_preload_strategy", "groupData", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "lastFinishStoryId", "", "getLastFinishStoryId", "()J", "setLastFinishStoryId", "(J)V", "lastStoryId", "getLastStoryId", "setLastStoryId", "playingMediaId", "preLoadConfig", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "getPreLoadConfig", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "setPreLoadConfig", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;)V", "preloadFinishSet", "", "preloadInfoRatioSet", "", "preloadInfoSet", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadRunningSet", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "runningMediaId", "Ljava/lang/Long;", "selectMediaId", "totalPreLoadOneItemSelect", "getTotalPreLoadOneItemSelect", "setTotalPreLoadOneItemSelect", "addPreLoadTask", "", "quota", "fromTag", "connectionCount", "addPreloadVideo", "", "videoItemList", "", "downloadExpect", "calcPreloadPercent", "mediaId", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "cacheSecondsDowngrade", "isGoodNetwork", "cancelAllPreloadTask", "cancelPreloadTask", "videoItem", "checkCanPlay", "item", "checkPreLoad", "checkPreloadOnVideoPlay", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "url", "path", "preloadPercent", "getNetworkSpeed", "isBadNetwork", "isLocalVideo", "makrFinish", "storyId", "markCurrentPlay", "markOnVideoFirstFrameDraw", "needPreLoad", "onVideoSourceChange", "preloadVideoWithPercent", "percent", "taskInfo", "queryQuota", "setPreloadQueueFromGallery", "groupItems", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "positionH", "skipPosition", "startPreLoad", "checkNet", "taskConnectionCount", "index", "upgrades", "GroupData", "MoovReadyInfo", "TaskInfo", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j SCD;
  private static h SCE;
  private static int SCF;
  private static int SCG;
  private static int SCH;
  private static final Map<String, com.tencent.mm.plugin.story.model.d.j> SCI;
  private static final Map<String, Integer> SCJ;
  private static final Set<String> SCK;
  private static final List<c> SCL;
  private static int SCM;
  private static a SCN;
  private static volatile String SCO;
  private static volatile Long SCP;
  private static long SCQ;
  private static long SCR;
  private static long Sqo;
  
  static
  {
    AppMethodBeat.i(120574);
    SCD = new j();
    SCE = new h();
    Object localObject = Collections.synchronizedMap((Map)new HashMap());
    s.s(localObject, "synchronizedMap(HashMap<String, StoryVideoItem>())");
    SCI = (Map)localObject;
    localObject = Collections.synchronizedMap((Map)new HashMap());
    s.s(localObject, "synchronizedMap(HashMap<String, Int>())");
    SCJ = (Map)localObject;
    localObject = Collections.synchronizedSet((Set)new HashSet());
    s.s(localObject, "synchronizedSet(HashSet<String>())");
    SCK = (Set)localObject;
    localObject = Collections.synchronizedList((List)new LinkedList());
    s.s(localObject, "synchronizedList(LinkedList<TaskInfo>())");
    SCL = (List)localObject;
    SCM = 3;
    SCN = new a((List)new ArrayList());
    AppMethodBeat.o(120574);
  }
  
  private final boolean B(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(120558);
    j localj;
    int i;
    kotlin.r localr;
    com.tencent.mm.plugin.story.model.d.j localj1;
    label448:
    label464:
    label635:
    label639:
    do
    {
      for (;;)
      {
        localj = (j)this;
        Object localObject1 = SCN;
        i = 0;
        localr = null;
        while ((i < ((a)localObject1).SDc.size()) && (localr == null))
        {
          localr = ((a)localObject1).hAu();
          Log.i(a.TAG, "produceVideoItem walkVertical:" + ((a)localObject1).SCX + "  walkHorizontal:" + ((a)localObject1).SCY + " positionV:" + ((a)localObject1).SCT + " positionH:" + ((a)localObject1).SCU + ", ret:" + localr);
          i += 1;
        }
        if (localr == null)
        {
          AppMethodBeat.o(120558);
          return false;
        }
        localj1 = (com.tencent.mm.plugin.story.model.d.j)localr.bsC;
        String str = ((c)localr.bsD).oYq;
        localObject1 = new StringBuilder("try preload mediaId ").append(str).append(" videoItem:").append(localj1).append(" pos:").append(localr.bsD).append("  groupinfo ");
        Object localObject2 = SCN;
        Log.i("MicroMsg.StoryVideoPreloadMgr", new StringBuilder("positionV:").append(((a)localObject2).SCT).append(", positionH:").append(((a)localObject2).SCU).append(", walkVertical:").append(((a)localObject2).SCX).append(", walkHorizontal:").append(((a)localObject2).SCY).toString() + " quota:" + paramInt1 + "  fromTag:" + paramString);
        localObject2 = ((Iterable)SCL).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
        } while (!s.p(((c)localObject1).oYq, str));
        for (;;)
        {
          localObject1 = (c)localObject1;
          if ((localObject1 == null) || (paramInt1 > ((c)localObject1).lyM)) {
            break label448;
          }
          Log.i("MicroMsg.StoryVideoPreloadMgr", "no need add quota " + paramInt1 + " cur:" + ((c)localObject1).lyM + " fromTag:" + paramString);
          break;
          localObject1 = null;
        }
        if (((CharSequence)str).length() == 0)
        {
          i = 1;
          if (i != 0) {
            break label635;
          }
        }
        for (localObject1 = str;; localObject1 = null)
        {
          if (localObject1 == null) {
            break label639;
          }
          i = a(str, localj1.Smx, paramInt1, hAo());
          localObject1 = com.tencent.mm.plugin.story.model.r.Slb;
          localObject1 = com.tencent.mm.plugin.story.model.r.a(localj1);
          if ((!((com.tencent.mm.plugin.story.h.n)localObject1).hzD()) && (((com.tencent.mm.plugin.story.h.n)localObject1).field_cacheSize / ((com.tencent.mm.plugin.story.h.n)localObject1).field_totalSize * 100.0F < i)) {
            break label641;
          }
          Log.i("MicroMsg.StoryVideoPreloadMgr", "pull preload video, " + str + ", already reach cache size! cacheSize:" + ((com.tencent.mm.plugin.story.h.n)localObject1).field_cacheSize + ", totalSize:" + ((com.tencent.mm.plugin.story.h.n)localObject1).field_totalSize + ", cachePercent:" + ((com.tencent.mm.plugin.story.h.n)localObject1).field_cacheSize / ((com.tencent.mm.plugin.story.h.n)localObject1).field_totalSize * 100.0F + "  fromTag:" + paramString);
          break;
          i = 0;
          break label464;
        }
      }
    } while (!localj.a(localj1, i, paramInt2, (c)localr.bsD));
    label641:
    ((c)localr.bsD).lyM = paramInt1;
    AppMethodBeat.o(120558);
    return true;
  }
  
  private final void Fa(boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(120557);
    boolean bool1 = hAo();
    boolean bool2 = hAp();
    int i = CdnLogic.getRecentAverageSpeed(2);
    if ((paramBoolean) && (i > 0) && (SCH > 0) && (i < SCH))
    {
      Log.w("MicroMsg.StoryVideoPreloadMgr", "speed too low then pass " + i + " clicfg_story_preload_force_canload: " + SCH + " callerFrom " + MMStack.getCaller());
      AppMethodBeat.o(120557);
      return;
    }
    int j = 0;
    if (bool2) {}
    for (i = 1;; i = 3)
    {
      if (SCF == 1) {
        i = k;
      }
      for (;;)
      {
        Log.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + SCL.size() + " maxTaskNum " + i + " totalPreLoadOneItemSelect " + SCM + " checkNet " + paramBoolean + " callerFrom " + MMStack.getCaller());
        List localList = hAm();
        while ((SCL.size() < i) && (j < localList.size()) && (SCM < 3) && (B(((Number)localList.get(j)).intValue(), "startPreLoad", anD(j))))
        {
          SCM += 1;
          j += 1;
        }
        Log.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue finish loop preload queue, current queue size: " + SCL.size() + ", pullPreloadTaskNum:0, preloadVideoNum:" + j + " preloadRunningSet " + SCL.size() + " totalPreLoadOneItemSelect " + SCM + ' ');
        AppMethodBeat.o(120557);
        return;
      }
    }
  }
  
  private static int a(String paramString, fis paramfis, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(120569);
    float f = paramfis.abJB;
    Log.i("MicroMsg.StoryVideoPreloadMgr", "calcPreloadPercent, cacheSecondsDowngrade:" + paramInt + ", mediaId:" + paramString + ", duration:" + f + ", isGoodNetwork:" + paramBoolean + " media:" + paramfis.abJB);
    int i;
    if (paramBoolean)
    {
      i = 5;
      if (f > 0.0F) {
        break label136;
      }
      paramInt = SCE.SBq;
    }
    for (;;)
    {
      i = paramInt;
      if (paramInt <= SCE.SBq) {
        i = SCE.SBq;
      }
      AppMethodBeat.o(120569);
      return i;
      i = 3;
      break;
      label136:
      if ((f <= i) && (paramInt <= 0)) {
        paramInt = 100;
      } else {
        paramInt = (int)(Math.max(3, paramInt) / f * 100.0D);
      }
    }
  }
  
  private boolean a(com.tencent.mm.plugin.story.model.d.j paramj, int paramInt1, int paramInt2, c paramc)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(120563);
        s.u(paramj, "videoItem");
        s.u(paramc, "taskInfo");
        if ((paramj.hwL()) || (Util.isNullOrNil(paramj.Smx.Url)))
        {
          AppMethodBeat.o(120563);
          bool = false;
          return bool;
        }
        if (i(paramj))
        {
          Log.i("MicroMsg.StoryVideoPreloadMgr", s.X("preloadVideoWithPercent, isLocalVideo: ", paramj.Smx.Url));
          AppMethodBeat.o(120563);
          bool = false;
          continue;
        }
        String str2 = paramj.Smx.Url;
        String str1 = paramc.oYq;
        Object localObject1 = com.tencent.mm.plugin.story.model.r.Slb;
        localObject1 = com.tencent.mm.plugin.story.model.r.a(paramj);
        Log.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, " + str1 + ", " + paramInt1 + ", playingMediaId:" + SCO + ", " + ((com.tencent.mm.plugin.story.h.n)localObject1).field_filePath + ", " + str2 + "  videoCache " + localObject1);
        if ((str1 == null) || (kotlin.n.n.T(SCO, str1, false))) {
          break label649;
        }
        Object localObject2 = com.tencent.mm.plugin.story.model.r.Slb;
        y.bDX(com.tencent.mm.plugin.story.model.r.bbT(paramj.username));
        s.s(str2, "url");
        localObject1 = ((com.tencent.mm.plugin.story.h.n)localObject1).field_filePath;
        s.s(localObject1, "videoCache.field_filePath");
        Log.i("MicroMsg.StoryVideoPreloadMgr", "createVideoPreloadCDNTask, mediaId:" + str1 + ", path:" + (String)localObject1 + ", url:" + str2 + ", preloadPercent:" + paramInt1 + ", connectionCount:" + paramInt2);
        localObject2 = new com.tencent.mm.g.h();
        ((com.tencent.mm.g.h)localObject2).taskName = "task_StoryVideoPreloadMgr";
        ((com.tencent.mm.g.h)localObject2).field_mediaId = str1;
        ((com.tencent.mm.g.h)localObject2).url = str2;
        ((com.tencent.mm.g.h)localObject2).lxb = 2;
        ((com.tencent.mm.g.h)localObject2).lxi = 2;
        ((com.tencent.mm.g.h)localObject2).lxc = 6;
        ((com.tencent.mm.g.h)localObject2).lxn = paramInt1;
        ((com.tencent.mm.g.h)localObject2).field_preloadRatio = paramInt1;
        ((com.tencent.mm.g.h)localObject2).concurrentCount = 4;
        ((com.tencent.mm.g.h)localObject2).field_fullpath = ((String)localObject1);
        ((com.tencent.mm.g.h)localObject2).lwL = ((g.a)new e());
        ((com.tencent.mm.g.h)localObject2).lxd = ((g.b)new d(Util.currentTicks()));
        ((com.tencent.mm.g.h)localObject2).connectionCount = paramInt2;
        ((com.tencent.mm.g.h)localObject2).field_fileType = com.tencent.mm.g.a.lwi;
        ((com.tencent.mm.g.h)localObject2).field_requestVideoFormat = e.S(2, (String)localObject1);
        k.bHW().b((com.tencent.mm.g.g)localObject2, -1);
        Log.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent:" + localObject2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2));
        SCI.put(str1, paramj);
        SCJ.put(str1, Integer.valueOf(paramInt1));
        paramj = SCL.iterator();
        paramInt1 = 0;
        if (!paramj.hasNext()) {
          break label630;
        }
        if (s.p(((c)paramj.next()).oYq, paramc.oYq))
        {
          if (paramInt1 <= 0) {
            break label635;
          }
          SCL.set(paramInt1, paramc);
          SCK.remove(str1);
          bool = true;
          AppMethodBeat.o(120563);
          continue;
        }
        paramInt1 += 1;
      }
      finally {}
      continue;
      label630:
      paramInt1 = -1;
      continue;
      label635:
      SCL.add(paramc);
      continue;
      label649:
      AppMethodBeat.o(120563);
      boolean bool = false;
    }
  }
  
  private static int anD(int paramInt)
  {
    AppMethodBeat.i(120564);
    Log.i("MicroMsg.StoryVideoPreloadMgr", s.X("taskConnectionCount: ", Integer.valueOf(paramInt)));
    List localList = SCE.SBv;
    if (paramInt < SCE.SBv.size()) {}
    for (;;)
    {
      paramInt = ((Number)localList.get(paramInt)).intValue();
      AppMethodBeat.o(120564);
      return paramInt;
      paramInt = SCE.SBv.size() - 1;
    }
  }
  
  private static int c(com.tencent.mm.plugin.story.model.d.j paramj)
  {
    AppMethodBeat.i(120556);
    s.u(paramj, "item");
    Object localObject = com.tencent.mm.plugin.story.model.r.Slb;
    localObject = com.tencent.mm.plugin.story.model.r.a(paramj);
    if (((com.tencent.mm.plugin.story.h.n)localObject).hzD())
    {
      Log.v("MicroMsg.StoryVideoPreloadMgr", s.X("z checkCanPlay downloadFinish ", Long.valueOf(paramj.idH)));
      AppMethodBeat.o(120556);
      return 1;
    }
    if (((com.tencent.mm.plugin.story.h.n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(120556);
      return 0;
    }
    if (((com.tencent.mm.plugin.story.h.n)localObject).field_cacheSize / ((com.tencent.mm.plugin.story.h.n)localObject).field_totalSize * 100.0F >= SCE.SBq)
    {
      Log.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay cachesize " + ((com.tencent.mm.plugin.story.h.n)localObject).field_cacheSize + " totalSize: " + ((com.tencent.mm.plugin.story.h.n)localObject).field_totalSize);
      AppMethodBeat.o(120556);
      return 1;
    }
    AppMethodBeat.o(120556);
    return 0;
  }
  
  public static h hAl()
  {
    return SCE;
  }
  
  private static List<Integer> hAm()
  {
    AppMethodBeat.i(120550);
    if (hAp())
    {
      localList = SCE.SBu;
      AppMethodBeat.o(120550);
      return localList;
    }
    List localList = SCE.SBt;
    AppMethodBeat.o(120550);
    return localList;
  }
  
  public static void hAn()
  {
    AppMethodBeat.i(120568);
    Log.printInfoStack("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask", new Object[0]);
    Iterator localIterator = SCI.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Log.i("MicroMsg.StoryVideoPreloadMgr", s.X("cancelAllPreloadTask ", str));
      k.bHW().Nz(str);
    }
    SCI.clear();
    SCJ.clear();
    SCN = new a((List)new ArrayList());
    SCL.clear();
    AppMethodBeat.o(120568);
  }
  
  private static boolean hAo()
  {
    AppMethodBeat.i(120570);
    if (CdnLogic.getRecentAverageSpeed(2) >= SCE.SBr)
    {
      AppMethodBeat.o(120570);
      return true;
    }
    AppMethodBeat.o(120570);
    return false;
  }
  
  private static boolean hAp()
  {
    AppMethodBeat.i(120571);
    int i = SCE.SBs;
    int j = CdnLogic.getRecentAverageSpeed(2);
    if (j > 0)
    {
      if (j <= i)
      {
        AppMethodBeat.o(120571);
        return true;
      }
      AppMethodBeat.o(120571);
      return false;
    }
    AppMethodBeat.o(120571);
    return false;
  }
  
  public static int hAq()
  {
    AppMethodBeat.i(371911);
    int i = CdnLogic.getRecentAverageSpeed(2);
    AppMethodBeat.o(371911);
    return i;
  }
  
  private static boolean i(com.tencent.mm.plugin.story.model.d.j paramj)
  {
    AppMethodBeat.i(120562);
    if (paramj.hwL())
    {
      AppMethodBeat.o(120562);
      return true;
    }
    com.tencent.mm.plugin.story.model.r localr = com.tencent.mm.plugin.story.model.r.Slb;
    if (y.bEl(com.tencent.mm.plugin.story.model.r.a(paramj.Smx)) > 0L)
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", "isLocalVideo video downloadDone " + paramj.Smx.taskId + " username:" + paramj.username);
      AppMethodBeat.o(120562);
      return true;
    }
    localr = com.tencent.mm.plugin.story.model.r.Slb;
    if (com.tencent.mm.plugin.story.model.r.a(paramj).hzD())
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", " isLocalVideo video download finish " + paramj.Smx.taskId + " username:" + paramj.username);
      AppMethodBeat.o(120562);
      return true;
    }
    AppMethodBeat.o(120562);
    return false;
  }
  
  public static void j(com.tencent.mm.plugin.story.model.d.j paramj)
  {
    AppMethodBeat.i(120565);
    s.u(paramj, "videoItem");
    Object localObject = com.tencent.mm.plugin.story.model.r.Slb;
    localObject = com.tencent.mm.plugin.story.model.r.de(paramj.createTime, paramj.Smx.Url);
    SCO = (String)localObject;
    SCP = Long.valueOf(paramj.idH);
    Log.i("MicroMsg.StoryVideoPreloadMgr", "markCurrentPlay:" + SCO + " then remove it from preload");
    Iterator localIterator = ((Iterable)SCL).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!s.p(localObject, ((c)paramj).oYq));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj != null)
      {
        SCL.remove(paramj);
        l(paramj.SDf);
      }
      AppMethodBeat.o(120565);
      return;
      paramj = null;
    }
  }
  
  public static j.b k(com.tencent.mm.plugin.story.model.d.j paramj)
  {
    AppMethodBeat.i(120566);
    s.u(paramj, "videoItem");
    Object localObject1 = com.tencent.mm.plugin.story.model.r.Slb;
    localObject1 = com.tencent.mm.plugin.story.model.r.de(paramj.createTime, paramj.Smx.Url);
    Log.i("MicroMsg.StoryVideoPreloadMgr", s.X("checkPreloadOnVideoPlay:", localObject1));
    Object localObject2 = com.tencent.mm.plugin.story.model.r.Slb;
    localObject2 = com.tencent.mm.plugin.story.model.r.a(paramj);
    if ((((com.tencent.mm.plugin.story.h.n)localObject2).field_cacheSize > 0) && (((com.tencent.mm.plugin.story.h.n)localObject2).field_totalSize > 0))
    {
      float f = ((com.tencent.mm.plugin.story.h.n)localObject2).field_cacheSize / ((com.tencent.mm.plugin.story.h.n)localObject2).field_totalSize;
      Log.i("MicroMsg.StoryVideoPreloadMgr", "hit cache, mediaId:" + localObject1 + ", cachePercent:" + f + ", filePath:" + ((com.tencent.mm.plugin.story.h.n)localObject2).field_filePath);
      localObject2 = ((com.tencent.mm.plugin.story.h.n)localObject2).field_filePath;
      CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      long[] arrayOfLong = new long[2];
      localC2CDownloadRequest.fileKey = ((String)localObject1);
      localC2CDownloadRequest.fileType = 6;
      localC2CDownloadRequest.url = paramj.Smx.Url;
      localC2CDownloadRequest.setSavePath((String)localObject2);
      localC2CDownloadRequest.requestVideoFormat = e.S(1, (String)localObject2);
      boolean bool = CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong);
      Log.i("MicroMsg.StoryVideoPreloadMgr", localObject1 + " queryMoovReady: " + bool + ", offset:" + arrayOfLong[0] + ", length:" + arrayOfLong[1] + ", preloadFinish:" + p.a((Iterable)SCK, localObject1));
      paramj = new j.b(true, arrayOfLong[0], arrayOfLong[1], p.a((Iterable)SCK, localObject1));
      AppMethodBeat.o(120566);
      return paramj;
    }
    Log.i("MicroMsg.StoryVideoPreloadMgr", s.X((String)localObject1, " not hit cache or moov not ready"));
    paramj = new j.b(false, 0L, 0L, false);
    AppMethodBeat.o(120566);
    return paramj;
  }
  
  private static void l(com.tencent.mm.plugin.story.model.d.j paramj)
  {
    AppMethodBeat.i(120567);
    s.u(paramj, "videoItem");
    Object localObject = com.tencent.mm.plugin.story.model.r.Slb;
    localObject = com.tencent.mm.plugin.story.model.r.de(paramj.createTime, paramj.Smx.Url);
    Log.i("MicroMsg.StoryVideoPreloadMgr", s.X("cancelPreloadTask, videoItem:", localObject));
    k.bHW().Nz((String)localObject);
    Iterator localIterator = ((Iterable)SCL).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramj = localIterator.next();
    } while (!s.p(((c)paramj).oYq, localObject));
    for (;;)
    {
      paramj = (c)paramj;
      if (paramj != null)
      {
        SCL.remove(paramj);
        if (SCM > 0) {
          SCM -= 1;
        }
      }
      AppMethodBeat.o(120567);
      return;
      paramj = null;
    }
  }
  
  private static boolean m(com.tencent.mm.plugin.story.model.d.j paramj)
  {
    AppMethodBeat.i(120573);
    if ((i(paramj)) || (paramj.hwL()))
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo fail, " + paramj + " isLocalVideo or fake video");
      AppMethodBeat.o(120573);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.story.model.r.Slb;
    localObject = com.tencent.mm.plugin.story.model.r.de(paramj.createTime, paramj.Smx.Url);
    if ((!Util.isNullOrNil((String)localObject)) && (!Util.isNullOrNil(paramj.Smx.Url)) && (!kotlin.n.n.T(SCO, (String)localObject, false)))
    {
      AppMethodBeat.o(120573);
      return true;
    }
    Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo:" + localObject + ", already request preload or url " + paramj.Smx.Url);
    AppMethodBeat.o(120573);
    return false;
  }
  
  private static boolean n(List<? extends List<com.tencent.mm.plugin.story.model.d.h>> arg0, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120551);
    s.u(???, "groupItems");
    Log.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery, galleryItems size:" + ???.size() + ", positionV:" + paramInt1 + "  positionH:" + paramInt2 + ", skipPosition:true");
    Object localObject1 = SCN;
    s.u(???, "galleryItems");
    int i;
    if (((a)localObject1).lo(???)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(120551);
      return false;
      if ((((a)localObject1).SCU != paramInt2) || (((a)localObject1).SCT != paramInt1)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 < ???.size()) && (paramInt2 < ((List)???.get(paramInt1)).size()))
    {
      localObject1 = (com.tencent.mm.plugin.story.model.d.h)((List)???.get(paramInt1)).get(paramInt2);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr;
        if (localObject1 != null) {
          SCQ = ((com.tencent.mm.plugin.story.model.d.j)localObject1).idH;
        }
      }
    }
    Sqo = 0L;
    SCM = 0;
    SCN = new a(???, paramInt1, paramInt2, SCN, true);
    localObject1 = new ArrayList();
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        Object localObject4 = ((Iterable)???).iterator();
        i = 0;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = ((Iterator)localObject4).next();
          if (i < 0) {
            p.kkW();
          }
          localObject5 = (List)localObject5;
          if ((i < paramInt1) || (((List)localObject5).size() <= 0)) {
            break label971;
          }
          ((ArrayList)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.story.model.d.h)((List)localObject5).get(0)).Smr.icg));
          break label971;
        }
        localObject4 = ah.aiuX;
        ??? = new ArrayList();
        if ((paramInt1 < ???.size()) && (paramInt2 < ((List)???.get(paramInt1)).size()))
        {
          int j = ((List)???.get(paramInt1)).size();
          if (paramInt2 < j)
          {
            i = paramInt2 + 1;
            ((ArrayList)???).add(Integer.valueOf(((com.tencent.mm.plugin.story.model.d.h)((List)???.get(paramInt1)).get(paramInt2)).Smr.icg));
            if (i < j) {
              break label966;
            }
          }
        }
        localObject4 = (Iterable)SCL;
        ??? = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label584;
        }
        Object localObject5 = ((Iterator)localObject4).next();
        c localc = (c)localObject5;
        if ((!((ArrayList)localObject1).contains(Integer.valueOf(localc.SDf.icg))) && (!((ArrayList)???).contains(Integer.valueOf(localc.SDf.icg))))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            continue;
          }
          ???.add(localObject5);
        }
      }
      paramInt1 = 0;
      continue;
      label584:
      synchronized ((Iterable)???)
      {
        localObject1 = ???.iterator();
        if (((Iterator)localObject1).hasNext()) {
          l(((c)((Iterator)localObject1).next()).SDf);
        }
      }
      ah localah = ah.aiuX;
      SCF = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIA, 1);
      paramInt1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIB, 450);
      paramInt2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIC, 200);
      SCG = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yID, 0);
      SCH = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIH, 100);
      SCE.SBr = paramInt1;
      SCE.SBs = paramInt2;
      i = CdnLogic.getRecentAverageSpeed(2);
      Log.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery clicfg_story_preload_strategy " + SCF + " clicfg_story_preload_speed_good:" + paramInt1 + " clicfg_story_preload_speed_bad:" + paramInt2 + " clicfg_story_preload_force_preload " + SCG + "  clicfg_story_preload_force_canload: " + SCH + " speed:" + i);
      if ((i > 0) && (SCH > 0) && (i < SCH))
      {
        Log.w("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery speed too low then pass " + i + " clicfg_story_preload_force_canload: " + SCH);
        ??? = new LinkedList();
        ???.addAll((Collection)SCL);
        ??? = ???.iterator();
        while (???.hasNext()) {
          l(((c)???.next()).SDf);
        }
      }
      AppMethodBeat.o(120551);
      return false;
      label966:
      paramInt2 = i;
      continue;
      label971:
      i += 1;
    }
  }
  
  public final void V(List<com.tencent.mm.plugin.story.model.d.j> paramList, int paramInt)
  {
    AppMethodBeat.i(120560);
    s.u(paramList, "videoItemList");
    Log.printInfoStack("MicroMsg.StoryVideoPreloadMgr", s.X("addPreloadVideo withList ", Integer.valueOf(paramList.size())), new Object[0]);
    boolean bool1 = hAo();
    boolean bool2 = hAp();
    Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, isGoodNetwork:" + bool1 + ", isBadNetwork:" + bool2 + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + SCL.size() + " downloadExpect " + paramInt);
    List localList = hAm();
    int j = 0;
    for (;;)
    {
      com.tencent.mm.plugin.story.model.d.j localj;
      int i;
      int k;
      String str;
      int m;
      com.tencent.mm.plugin.story.h.n localn;
      synchronized ((Iterable)paramList)
      {
        Iterator localIterator1 = ???.iterator();
        if (!localIterator1.hasNext()) {
          break label536;
        }
        localj = (com.tencent.mm.plugin.story.model.d.j)localIterator1.next();
        if (!m(localj)) {
          continue;
        }
        if (paramInt > 0)
        {
          i = paramInt;
          k = anD(j);
          paramList = com.tencent.mm.plugin.story.model.r.Slb;
          str = com.tencent.mm.plugin.story.model.r.de(localj.createTime, localj.Smx.Url);
          m = a(str, localj.Smx, i, hAo());
          paramList = com.tencent.mm.plugin.story.model.r.Slb;
          localn = com.tencent.mm.plugin.story.model.r.a(localj);
          Iterator localIterator2 = ((Iterable)SCL).iterator();
          if (!localIterator2.hasNext()) {
            break label591;
          }
          paramList = localIterator2.next();
          if (!s.p(((c)paramList).oYq, str)) {
            continue;
          }
          if (paramList == null) {
            break label382;
          }
          Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already prealoding!");
        }
      }
      label536:
      label591:
      if (j < localList.size())
      {
        i = ((Number)localList.get(j)).intValue();
      }
      else
      {
        i = ((Number)p.oM(localList)).intValue();
        continue;
        label382:
        if ((localn.hzD()) || (localn.field_cacheSize / localn.field_totalSize * 100.0F >= m))
        {
          Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + str + ", already reach cache size! cacheSize:" + localn.field_cacheSize + ", totalSize:" + localn.field_totalSize + ", cachePercent:" + localn.field_cacheSize / localn.field_totalSize * 100.0F);
        }
        else
        {
          paramList = new c(0, j, localj, i, k);
          if (SCD.a(localj, m, k, paramList))
          {
            j += 1;
            continue;
            paramList = ah.aiuX;
            Log.i("MicroMsg.StoryVideoPreloadMgr", "finish addPreloadVideo withList, total pull video task:" + j + " preloadRunningSet " + SCL.size());
            AppMethodBeat.o(120560);
            return;
            paramList = null;
          }
        }
      }
    }
  }
  
  public final void h(com.tencent.mm.plugin.story.model.d.j paramj)
  {
    AppMethodBeat.i(120555);
    s.u(paramj, "item");
    Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad " + paramj + ' ' + MMStack.getCaller());
    if (i(paramj))
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay isLocalVideo");
      Fa(false);
      AppMethodBeat.o(120555);
      return;
    }
    if (c(paramj) == 1)
    {
      Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay true");
      Fa(true);
      AppMethodBeat.o(120555);
      return;
    }
    if (SCG == 1) {
      Fa(true);
    }
    Log.i("MicroMsg.StoryVideoPreloadMgr", "nothing can checkPreLoad");
    AppMethodBeat.o(120555);
  }
  
  public final void wg(long paramLong)
  {
    AppMethodBeat.i(120553);
    if (Sqo == paramLong)
    {
      AppMethodBeat.o(120553);
      return;
    }
    Sqo = paramLong;
    if (SCF == 0)
    {
      AppMethodBeat.o(120553);
      return;
    }
    a locala = SCN;
    if (locala != null) {
      locala.hAv();
    }
    Fa(true);
    AppMethodBeat.o(120553);
  }
  
  public final void wh(long paramLong)
  {
    AppMethodBeat.i(120554);
    Object localObject = SCP;
    if (localObject == null) {}
    while (SCR == paramLong)
    {
      AppMethodBeat.o(120554);
      return;
      if (((Long)localObject).longValue() == paramLong) {
        SCP = Long.valueOf(0L);
      }
    }
    SCR = paramLong;
    if (SCF == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (SCH == 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    if (SCL.size() > 0)
    {
      AppMethodBeat.o(120554);
      return;
    }
    localObject = SCN;
    if (localObject != null) {
      ((a)localObject).hAv();
    }
    Fa(false);
    AppMethodBeat.o(120554);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "", "groupItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "", "positionH", "lastGroup", "skipPosition", "", "(Ljava/util/List;IILcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;Z)V", "MAX_PRELOAD_COUNT", "horizontalList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "produceList", "Lkotlin/Function0;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "verticalList", "walkHorizontal", "walkIndex", "walkVertical", "info", "", "isDataChange", "isSame", "galleryItems", "produce", "produceHorizontalVideoItem", "produceVerticalVideoItem", "produceVideoItem", "reset", "", "resetWalk", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final j.a.a SCS;
    static final String TAG;
    int SCT;
    int SCU;
    private final boolean SCV;
    private final int SCW;
    int SCX;
    int SCY;
    private int SCZ;
    private ArrayList<com.tencent.mm.plugin.story.model.d.h> SDa;
    private ArrayList<com.tencent.mm.plugin.story.model.d.h> SDb;
    List<? extends kotlin.g.a.a<kotlin.r<com.tencent.mm.plugin.story.model.d.j, j.c>>> SDc;
    
    static
    {
      AppMethodBeat.i(120542);
      SCS = new j.a.a((byte)0);
      TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
      AppMethodBeat.o(120542);
    }
    
    public a(List<? extends List<com.tencent.mm.plugin.story.model.d.h>> arg1, int paramInt1, int paramInt2, a arg4, boolean paramBoolean)
    {
      AppMethodBeat.i(367609);
      this.SCT = paramInt1;
      this.SCU = paramInt2;
      this.SCV = true;
      this.SCW = 15;
      this.SDa = new ArrayList();
      this.SDb = new ArrayList();
      this.SDc = p.listOf(new kotlin.g.a.a[] { (kotlin.g.a.a)new b(this), (kotlin.g.a.a)new c(this), (kotlin.g.a.a)new d(this) });
      if (((??? != null) && (this.SCT != ???.SCT)) || ((??? != null) && (this.SCU != ???.SCU)) || (lo(???))) {
        reset();
      }
      this.SDa.clear();
      this.SDb.clear();
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
            this.SDb.add(localList.get(0));
          }
        }
        paramInt1 = 0;
      }
      Object localObject = ah.aiuX;
      if (this.SCT < ???.size())
      {
        synchronized ((Iterable)???.get(this.SCT))
        {
          ??? = ???.iterator();
          if (???.hasNext())
          {
            localObject = (com.tencent.mm.plugin.story.model.d.h)???.next();
            this.SDa.add(localObject);
          }
        }
        ??? = ah.aiuX;
        AppMethodBeat.o(367609);
        return;
      }
      AppMethodBeat.o(367609);
    }
    
    private final kotlin.r<com.tencent.mm.plugin.story.model.d.j, j.c> hAw()
    {
      AppMethodBeat.i(120539);
      for (;;)
      {
        if (this.SCV) {
          this.SCX += 1;
        }
        if (this.SCX >= this.SDb.size())
        {
          AppMethodBeat.o(120539);
          return null;
        }
        try
        {
          if (this.SDb.size() > 0)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.model.d.h)this.SDb.get(this.SCX)).Smr;
            j localj = j.SCD;
            if (j.n((com.tencent.mm.plugin.story.model.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new kotlin.r(localObject1, new j.c(this.SCX, 0, (com.tencent.mm.plugin.story.model.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.SCV) {
            continue;
          }
          this.SCX += 1;
        }
        finally
        {
          if (!this.SCV) {
            this.SCX += 1;
          }
          AppMethodBeat.o(120539);
        }
      }
    }
    
    private final kotlin.r<com.tencent.mm.plugin.story.model.d.j, j.c> hAx()
    {
      AppMethodBeat.i(120540);
      for (;;)
      {
        if (this.SCV) {
          this.SCY += 1;
        }
        if (this.SCY >= this.SDa.size())
        {
          AppMethodBeat.o(120540);
          return null;
        }
        try
        {
          if (this.SDa.size() > this.SCY)
          {
            Object localObject1 = ((com.tencent.mm.plugin.story.model.d.h)this.SDa.get(this.SCY)).Smr;
            j localj = j.SCD;
            if (j.n((com.tencent.mm.plugin.story.model.d.j)localObject1)) {}
            while (localObject1 != null)
            {
              localObject1 = new kotlin.r(localObject1, new j.c(this.SCX, this.SCY, (com.tencent.mm.plugin.story.model.d.j)localObject1));
              return localObject1;
              localObject1 = null;
            }
          }
          if (this.SCV) {
            continue;
          }
          this.SCY += 1;
        }
        finally
        {
          if (!this.SCV) {
            this.SCY += 1;
          }
          AppMethodBeat.o(120540);
        }
      }
    }
    
    private final void reset()
    {
      this.SCX = this.SCT;
      this.SCY = this.SCU;
      this.SCZ = 0;
    }
    
    final kotlin.r<com.tencent.mm.plugin.story.model.d.j, j.c> hAu()
    {
      AppMethodBeat.i(120536);
      try
      {
        if (this.SCZ > this.SCW)
        {
          Log.i(TAG, s.X("stop preload now ", Integer.valueOf(this.SCZ)));
          AppMethodBeat.o(120536);
          return null;
        }
        kotlin.r localr = (kotlin.r)((kotlin.g.a.a)this.SDc.get(this.SCZ % this.SDc.size())).invoke();
        this.SCZ += 1;
        AppMethodBeat.o(120536);
        return localr;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException, "error on produce", new Object[0]);
        AppMethodBeat.o(120536);
      }
      return null;
    }
    
    public final void hAv()
    {
      AppMethodBeat.i(120538);
      Log.i(TAG, "resetWalk");
      reset();
      AppMethodBeat.o(120538);
    }
    
    final boolean lo(List<? extends List<com.tencent.mm.plugin.story.model.d.h>> paramList)
    {
      AppMethodBeat.i(120537);
      int k;
      if (paramList.size() == this.SDb.size())
      {
        k = paramList.size();
        if (k <= 0) {}
      }
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 1;
        if (((List)paramList.get(i)).isEmpty())
        {
          AppMethodBeat.o(120537);
          return true;
        }
        if (((com.tencent.mm.plugin.story.model.d.h)this.SDb.get(i)).Smr.icg != ((com.tencent.mm.plugin.story.model.d.h)((List)paramList.get(i)).get(0)).Smr.icg)
        {
          AppMethodBeat.o(120537);
          return true;
        }
        if (j >= k)
        {
          AppMethodBeat.o(120537);
          return false;
          AppMethodBeat.o(120537);
          return true;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<kotlin.r<? extends com.tencent.mm.plugin.story.model.d.j, ? extends j.c>>
    {
      b(j.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<kotlin.r<? extends com.tencent.mm.plugin.story.model.d.j, ? extends j.c>>
    {
      c(j.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.a<kotlin.r<? extends com.tencent.mm.plugin.story.model.d.j, ? extends j.c>>
    {
      d(j.a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "", "positionV", "", "positionH", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "quota", "connectionCount", "(IILcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;II)V", "cdnMediaId", "", "getCdnMediaId", "()Ljava/lang/String;", "setCdnMediaId", "(Ljava/lang/String;)V", "getConnectionCount", "()I", "setConnectionCount", "(I)V", "getItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getPositionH", "getPositionV", "getQuota", "setQuota", "info", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    private final int SCT;
    private final int SCU;
    final com.tencent.mm.plugin.story.model.d.j SDf;
    private int connectionCount;
    int lyM;
    String oYq;
    
    public c(int paramInt1, int paramInt2, com.tencent.mm.plugin.story.model.d.j paramj, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(120546);
      this.SCT = paramInt1;
      this.SCU = paramInt2;
      this.SDf = paramj;
      this.lyM = paramInt3;
      this.connectionCount = paramInt4;
      paramj = com.tencent.mm.plugin.story.model.r.Slb;
      String str = com.tencent.mm.plugin.story.model.r.de(this.SDf.createTime, this.SDf.Smx.Url);
      paramj = str;
      if (str == null) {
        paramj = "";
      }
      this.oYq = paramj;
      AppMethodBeat.o(120546);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "startTick", "", "(J)V", "onPreloadCompleted", "", "mediaId", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class d
    implements g.b
  {
    private final long moe;
    
    public d(long paramLong)
    {
      this.moe = paramLong;
    }
    
    public final void b(String paramString, com.tencent.mm.g.d paramd)
    {
      AppMethodBeat.i(120548);
      Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", sceneResult:" + paramd);
      if ((paramd != null) && (paramd.field_retCode == -21112)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", video source change!");
        paramd = j.SCD;
        j.bcu(paramString);
        AppMethodBeat.o(120548);
        return;
      }
      if ((paramString != null) && (paramd != null) && (j.hAr().containsKey(paramString)))
      {
        Object localObject = (com.tencent.mm.plugin.story.model.d.j)j.hAr().get(paramString);
        if (localObject != null)
        {
          if ((paramd.field_recvedBytes > 0L) && (paramd.field_fileLength > 0L))
          {
            com.tencent.mm.plugin.story.model.r localr = com.tencent.mm.plugin.story.model.r.Slb;
            localObject = com.tencent.mm.plugin.story.model.r.a((com.tencent.mm.plugin.story.model.d.j)localObject);
            ((com.tencent.mm.plugin.story.h.n)localObject).field_cacheSize = ((int)paramd.field_recvedBytes);
            ((com.tencent.mm.plugin.story.h.n)localObject).field_totalSize = ((int)paramd.field_fileLength);
            paramd = StoryCore.SjP;
            StoryCore.b.hvV().b((com.tencent.mm.plugin.story.h.n)localObject);
            j.hAs().add(paramString);
            Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted update cacheSize:" + ((com.tencent.mm.plugin.story.h.n)localObject).field_cacheSize + ", totalSize:" + ((com.tencent.mm.plugin.story.h.n)localObject).field_totalSize + ", preloadCost:" + Util.ticksToNow(this.moe));
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramString));
            AppMethodBeat.o(120548);
            return;
          }
          Log.e("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted error, recvedBytes:" + paramd.field_recvedBytes + ", fileLength:" + paramd.field_fileLength);
        }
      }
      AppMethodBeat.o(120548);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(String paramString)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "()V", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class e
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(120549);
      if ((paramd != null) && (paramd.field_retCode == -21112)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreload, mediaId:" + paramString + ", video source change!");
        paramc = j.SCD;
        j.bcu(paramString);
        AppMethodBeat.o(120549);
        return 0;
      }
      Object localObject1;
      if ((paramc != null) && (paramc.field_toltalLength > 0L))
      {
        localObject1 = (com.tencent.mm.plugin.story.model.d.j)j.hAr().get(paramString);
        paramBoolean = p.a((Iterable)j.hAs(), paramString);
        int j = (int)((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F);
        paramd = (Integer)j.hAt().get(paramString);
        if (paramd != null) {
          break label518;
        }
        i = 0;
        paramd = hashCode() + " onPreload, mediaId:" + paramString + ", startRet:" + paramInt + ", preloadOffset:" + paramc.field_finishedLength + ", totalLength: " + paramc.field_toltalLength + " desiredPreloadPercent:" + i + ", preloadPercent:" + j + " isFinish:" + paramBoolean;
        paramInt = 0;
        if ((i <= 0) || (j < i)) {
          break label534;
        }
        paramd = s.X(paramd, " exceed:true ");
        paramInt = 1;
      }
      label518:
      label534:
      for (;;)
      {
        if (localObject1 != null)
        {
          Object localObject2 = com.tencent.mm.plugin.story.model.r.Slb;
          localObject2 = com.tencent.mm.plugin.story.model.r.a((com.tencent.mm.plugin.story.model.d.j)localObject1);
          ((com.tencent.mm.plugin.story.h.n)localObject2).field_cacheSize = ((int)paramc.field_finishedLength);
          ((com.tencent.mm.plugin.story.h.n)localObject2).field_totalSize = ((int)paramc.field_toltalLength);
          paramc = StoryCore.SjP;
          StoryCore.b.hvV().b((com.tencent.mm.plugin.story.h.n)localObject2);
          paramc = StoryCore.SjP;
          f localf = StoryCore.b.hvS().bbJ(((com.tencent.mm.plugin.story.model.d.j)localObject1).username);
          paramc = paramd;
          if (localf.field_syncId == ((com.tencent.mm.plugin.story.model.d.j)localObject1).idH)
          {
            paramc = paramd;
            if (localf.isValid())
            {
              long l = ((com.tencent.mm.plugin.story.model.d.j)localObject1).idH;
              localObject1 = ((com.tencent.mm.plugin.story.model.d.j)localObject1).Smx.Id;
              s.s(localObject1, "videoItem.media.Id");
              paramc = paramd;
              if (localf.e(l, (String)localObject1, ((com.tencent.mm.plugin.story.h.n)localObject2).field_cacheSize))
              {
                paramc = s.X(paramd, " * ext pre update * ");
                paramd = StoryCore.SjP;
                StoryCore.b.hvS().a((int)localf.systemRowid, localf);
              }
            }
          }
          if ((paramInt != 0) && (paramString != null)) {
            j.hAs().add(paramString);
          }
        }
        for (paramString = s.X(paramc, "update cacheSize done");; paramString = paramd)
        {
          paramString = new StringBuilder().append(paramString).append(", currentSpeed:");
          paramc = j.SCD;
          Log.i("MicroMsg.StoryVideoPreloadMgr", j.hAq());
          AppMethodBeat.o(120549);
          return 0;
          i = paramd.intValue();
          break;
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.j
 * JD-Core Version:    0.7.0.1
 */