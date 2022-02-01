package com.tencent.mm.plugin.story.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eo;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.g.b.a.er;
import com.tencent.mm.g.b.a.es;
import com.tencent.mm.g.b.a.et;
import com.tencent.mm.g.b.a.eu;
import com.tencent.mm.g.b.a.ev;
import com.tencent.mm.g.b.a.ew;
import com.tencent.mm.g.b.a.ex;
import com.tencent.mm.g.b.a.ey;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.g.b.a.fa;
import com.tencent.mm.g.b.a.fc;
import com.tencent.mm.g.b.a.ff;
import com.tencent.mm.g.b.a.fg;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/report/StoryReporter;", "", "()V", "cameraDot", "", "getCameraDot", "()J", "setCameraDot", "(J)V", "currentEntranceExposeTime", "", "getCurrentEntranceExposeTime", "()I", "setCurrentEntranceExposeTime", "(I)V", "currentProfileTabVideoObjectId", "getCurrentProfileTabVideoObjectId", "setCurrentProfileTabVideoObjectId", "lastTrace", "getLastTrace", "setLastTrace", "moreTabDot", "getMoreTabDot", "setMoreTabDot", "nameSet", "", "", "kotlin.jvm.PlatformType", "", "needCommentRpt", "", "getNeedCommentRpt", "()Z", "setNeedCommentRpt", "(Z)V", "needVisitorRpt", "getNeedVisitorRpt", "setNeedVisitorRpt", "storyChatTopBarEntranceExpose", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryChatTopBarEntranceExposeStruct;", "storyCommentDot", "getStoryCommentDot", "setStoryCommentDot", "storyDoubleTapHeadView", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoubleTapHeadViewStruct;", "storyDownloadReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDownloadReportStruct;", "storyEntranceExposeReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeReportStruct;", "storyImageVideoRemux", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoRemuxStruct;", "storyImageVideoZip", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoZipStruct;", "storyPageExposeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPageExposeStruct;", "storyPreviewReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPreviewReportStruct;", "storyPreviewTraceStruct", "Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "storyProfileTabExposeReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryProfileTabExposeStruct;", "storySinglePreviewReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StorySinglePreviewReportStruct;", "storyStatusChangeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "getStoryStatusChangeStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "setStoryStatusChangeStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;)V", "storyUploadMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryUploadReportStruct;", "storyVideoPublish", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryComposeReportStruct;", "tag", "videoIdSet", "addPreviewTrace", "", "aid", "checkRepeatUser", "name", "checkRepeatVideo", "doCommentPageExposeReport", "storyId", "doEntranceClearReport", "delete", "doStoryChatTopBarEntranceExposeReport", "doStoryDoubleTapHeadViewReport", "doStoryDownloadReport", "doStoryEntranceReport", "doStoryImageVideoRemuxReport", "doStoryImageVideoZipReport", "doStoryPageReport", "doStoryPreviewReport", "doStoryProfileTabExposeReport", "doStorySinglePreviewReport", "doStoryStatusChangeReport", "doStoryUploadReport", "storyLocalId", "doStoryVideoPublishReport", "doVisiteReport", "visitorCount", "commentCount", "doVisitorPageExposeReport", "getLastStoryUploadReporter", "getStoryChatTopBarEntranceExposeReporter", "getStoryDoubleTapHeadViewReporter", "getStoryDownloadReporter", "getStoryEntranceReport", "getStoryImageVideoRemuxReporter", "getStoryImageVideoZipReporter", "getStoryPageExposeReporter", "getStoryPreviewReporter", "getStoryProfileTabExposeReport", "getStorySinglePreviewReporter", "getStoryVideoPublishReporter", "reportStoryStatusChange", "status", "previewEnterScene", "profileSource", "isAlbumStarButton", "resetStoryPreviewReporter", "resetStoryPreviewTraceData", "resetStoryProfileTabExposeReport", "storyUploadReportCPMediaInfo", "path", "storyUploadReportOriMediaInfo", "isCaptureVideo", "plugin-story_release"})
public final class h
{
  private static int wyd;
  private static Set<String> zAA;
  private static Set<String> zAB;
  private static boolean zAC;
  private static boolean zAD;
  private static eo zAE;
  private static er zAF;
  private static ep zAG;
  private static ew zAH;
  private static ex zAI;
  private static es zAJ;
  private static final HashMap<Integer, fg> zAK;
  private static fc zAL;
  private static fa zAM;
  private static long zAN;
  private static long zAO;
  private static long zAP;
  private static long zAQ;
  private static int zAR;
  private static eu zAS;
  private static ff zAT;
  public static final h zAU;
  private static ey zAx;
  private static ez zAy;
  private static a zAz;
  
  static
  {
    AppMethodBeat.i(119464);
    zAU = new h();
    zAx = new ey();
    wyd = -1;
    zAy = new ez();
    zAz = new a();
    zAA = Collections.synchronizedSet((Set)new HashSet());
    zAB = Collections.synchronizedSet((Set)new HashSet());
    zAC = true;
    zAD = true;
    zAE = new eo();
    zAF = new er();
    zAG = new ep();
    zAH = new ew();
    zAI = new ex();
    zAJ = new es();
    zAK = new HashMap();
    zAL = new fc();
    zAM = new fa();
    zAS = new eu();
    zAT = new ff();
    AppMethodBeat.o(119464);
  }
  
  public static void QH(int paramInt)
  {
    AppMethodBeat.i(119443);
    if ((wyd == -1) && (paramInt == 4))
    {
      wyd = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    if ((wyd == 10) && (paramInt == 11))
    {
      wyd = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    wyd = paramInt;
    a locala = zAz;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("aid", paramInt);
    localJSONObject.put("td", locala.wxW.length() + 1);
    if (locala.wxW.toString().length() + localJSONObject.toString().length() > 1000) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0) {}
      synchronized (locala.lock)
      {
        locala.wxW.put(localJSONObject);
        AppMethodBeat.o(119443);
        return;
        paramInt = 1;
      }
    }
  }
  
  public static fg QI(int paramInt)
  {
    AppMethodBeat.i(119455);
    fg localfg2 = (fg)zAK.get(Integer.valueOf(paramInt));
    fg localfg1 = localfg2;
    if (localfg2 == null)
    {
      localfg1 = new fg();
      ((Map)zAK).put(Integer.valueOf(paramInt), localfg1);
    }
    AppMethodBeat.o(119455);
    return localfg1;
  }
  
  public static void QJ(int paramInt)
  {
    AppMethodBeat.i(119456);
    fg localfg = (fg)zAK.get(Integer.valueOf(paramInt));
    if (localfg != null)
    {
      ac.d("MicroMsg.StoryReporter", "basic:\n" + localfg.Sk() + ' ' + localfg.RU() + ' ' + localfg.RV() + ' ' + localfg.Si() + ' ' + localfg.RT() + ' ' + localfg.RR() + ' ' + localfg.RS());
      ac.d("MicroMsg.StoryReporter", "origin:\n" + localfg.RY() + ' ' + localfg.RW() + ' ' + localfg.Sj() + ' ' + localfg.Sb() + ' ' + localfg.Sa() + ' ' + localfg.RZ() + ' ' + localfg.RX());
      ac.d("MicroMsg.StoryReporter", "cp:\n" + localfg.Se() + ' ' + localfg.Sc() + ' ' + localfg.Sh() + ' ' + localfg.Sg() + ' ' + localfg.Sf() + ' ' + localfg.Sd());
      localfg.aHZ();
      zAK.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(119456);
  }
  
  public static void QK(int paramInt)
  {
    zAR = paramInt;
  }
  
  public static void a(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(119460);
    k.h(paramString, "storyId");
    zAT.mO(paramString);
    zAT.jT(paramLong1);
    zAT.jW(paramLong4);
    zAT.jU(paramLong2);
    zAT.jV(paramLong3);
    zAT.aHZ();
    zAT = new ff();
    AppMethodBeat.o(119460);
  }
  
  public static void av(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119462);
    k.h(paramString, "storyId");
    ev localev = new ev();
    localev.mz(paramString);
    localev.jf(paramInt1);
    localev.jg(paramInt2);
    localev.aHZ();
    AppMethodBeat.o(119462);
  }
  
  public static boolean awU(String paramString)
  {
    AppMethodBeat.i(119441);
    if (paramString == null)
    {
      AppMethodBeat.o(119441);
      return true;
    }
    if (zAA.contains(paramString))
    {
      AppMethodBeat.o(119441);
      return true;
    }
    zAA.add(paramString);
    AppMethodBeat.o(119441);
    return false;
  }
  
  public static boolean awV(String paramString)
  {
    AppMethodBeat.i(119442);
    if (paramString == null)
    {
      AppMethodBeat.o(119442);
      return true;
    }
    if (zAB.contains(paramString))
    {
      AppMethodBeat.o(119442);
      return true;
    }
    zAB.add(paramString);
    AppMethodBeat.o(119442);
    return false;
  }
  
  public static void awW(String paramString)
  {
    AppMethodBeat.i(119448);
    k.h(paramString, "storyId");
    if (zAC)
    {
      zAx.jk(8L);
      zAx.mA(paramString);
      dXP();
    }
    AppMethodBeat.o(119448);
  }
  
  public static void awX(String paramString)
  {
    AppMethodBeat.i(119449);
    k.h(paramString, "storyId");
    if (zAD)
    {
      zAx.jk(5L);
      zAx.mA(paramString);
      dXP();
    }
    AppMethodBeat.o(119449);
  }
  
  public static void dXJ()
  {
    wyd = 1;
  }
  
  public static ez dXK()
  {
    return zAy;
  }
  
  public static void dXL()
  {
    AppMethodBeat.i(119444);
    if (0L == zAy.Rz())
    {
      dXN();
      AppMethodBeat.o(119444);
      return;
    }
    zAy.mC(zAz.dwp());
    ez localez = zAy;
    localez.jw(localez.RD() + zAy.RB());
    zAy.aHZ();
    zAy.jq(0L);
    zAy.ju(0L);
    zAy.jt(0L);
    zAy.jr(0L);
    zAy.jv(0L);
    zAy.jn(0L);
    zAy.jw(0L);
    zAy.jy(0L);
    zAy.mD("");
    dXN();
    AppMethodBeat.o(119444);
  }
  
  public static void dXM()
  {
    AppMethodBeat.i(119445);
    zAy = new ez();
    dXN();
    AppMethodBeat.o(119445);
  }
  
  public static void dXN()
  {
    AppMethodBeat.i(119446);
    zAz = new a();
    wyd = -1;
    zAA.clear();
    zAB.clear();
    AppMethodBeat.o(119446);
  }
  
  public static ey dXO()
  {
    return zAx;
  }
  
  public static void dXP()
  {
    AppMethodBeat.i(119447);
    zAx.aHZ();
    zAx = new ey();
    AppMethodBeat.o(119447);
  }
  
  public static eo dXQ()
  {
    return zAE;
  }
  
  public static void dXR()
  {
    AppMethodBeat.i(119450);
    if (TextUtils.isEmpty((CharSequence)zAE.getUserName()))
    {
      AppMethodBeat.o(119450);
      return;
    }
    zAE.aHZ();
    AppMethodBeat.o(119450);
  }
  
  public static er dXS()
  {
    return zAF;
  }
  
  public static void dXT()
  {
    AppMethodBeat.i(119451);
    zAF.aHZ();
    AppMethodBeat.o(119451);
  }
  
  public static ep dXU()
  {
    return zAG;
  }
  
  public static void dXV()
  {
    AppMethodBeat.i(119452);
    zAG.aHZ();
    zAG = new ep();
    AppMethodBeat.o(119452);
  }
  
  public static ex dXW()
  {
    return zAI;
  }
  
  public static void dXX()
  {
    AppMethodBeat.i(119453);
    zAI.aHZ();
    zAI = new ex();
    AppMethodBeat.o(119453);
  }
  
  public static es dXY()
  {
    return zAJ;
  }
  
  public static void dXZ()
  {
    AppMethodBeat.i(119454);
    zAJ.aHZ();
    zAJ = new es();
    AppMethodBeat.o(119454);
  }
  
  public static fc dYa()
  {
    return zAL;
  }
  
  public static void dYb()
  {
    AppMethodBeat.i(119457);
    if (zAL.Rw() == 0L)
    {
      zAL = new fc();
      AppMethodBeat.o(119457);
      return;
    }
    zAL.aHZ();
    zAL = new fc();
    AppMethodBeat.o(119457);
  }
  
  public static long dYc()
  {
    return zAQ;
  }
  
  public static fa dYd()
  {
    return zAM;
  }
  
  public static void dYe()
  {
    AppMethodBeat.i(119458);
    if (zAM.RI() != 0L)
    {
      zAM.aHZ();
      zAM.RH();
      zAM.RF();
      zAM.RE();
      zAM.RG();
      zAM.jz(zAN);
      zAM.jA(zAO);
      zAM.jB(zAP);
    }
    AppMethodBeat.o(119458);
  }
  
  public static int dYf()
  {
    return zAR;
  }
  
  public static eu dYg()
  {
    return zAS;
  }
  
  public static void dYh()
  {
    AppMethodBeat.i(119459);
    zAS.aHZ();
    zAS = new eu();
    AppMethodBeat.o(119459);
  }
  
  public static void rM(boolean paramBoolean)
  {
    zAC = paramBoolean;
  }
  
  public static void rN(boolean paramBoolean)
  {
    zAD = paramBoolean;
  }
  
  public static void rO(boolean paramBoolean)
  {
    long l = 1L;
    AppMethodBeat.i(119463);
    et localet = new et();
    localet.jb(1L);
    if (paramBoolean) {}
    for (;;)
    {
      localet.jd(l);
      localet.aHZ();
      AppMethodBeat.o(119463);
      return;
      l = 0L;
    }
  }
  
  public static void yr(long paramLong)
  {
    zAN = paramLong;
  }
  
  public static void ys(long paramLong)
  {
    zAO = paramLong;
  }
  
  public static void yt(long paramLong)
  {
    zAP = paramLong;
  }
  
  public static void yu(long paramLong)
  {
    zAQ = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.h
 * JD-Core Version:    0.7.0.1
 */