package com.tencent.mm.plugin.story.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.lm;
import com.tencent.mm.f.b.a.ln;
import com.tencent.mm.f.b.a.lp;
import com.tencent.mm.f.b.a.lq;
import com.tencent.mm.f.b.a.lr;
import com.tencent.mm.f.b.a.ls;
import com.tencent.mm.f.b.a.lt;
import com.tencent.mm.f.b.a.lu;
import com.tencent.mm.f.b.a.lv;
import com.tencent.mm.f.b.a.lw;
import com.tencent.mm.f.b.a.lx;
import com.tencent.mm.f.b.a.ly;
import com.tencent.mm.f.b.a.ma;
import com.tencent.mm.f.b.a.md;
import com.tencent.mm.f.b.a.me;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/report/StoryReporter;", "", "()V", "cameraDot", "", "getCameraDot", "()J", "setCameraDot", "(J)V", "currentEntranceExposeTime", "", "getCurrentEntranceExposeTime", "()I", "setCurrentEntranceExposeTime", "(I)V", "currentProfileTabVideoObjectId", "getCurrentProfileTabVideoObjectId", "setCurrentProfileTabVideoObjectId", "lastTrace", "getLastTrace", "setLastTrace", "moreTabDot", "getMoreTabDot", "setMoreTabDot", "nameSet", "", "", "kotlin.jvm.PlatformType", "", "needCommentRpt", "", "getNeedCommentRpt", "()Z", "setNeedCommentRpt", "(Z)V", "needVisitorRpt", "getNeedVisitorRpt", "setNeedVisitorRpt", "storyChatTopBarEntranceExpose", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryChatTopBarEntranceExposeStruct;", "storyCommentDot", "getStoryCommentDot", "setStoryCommentDot", "storyDoubleTapHeadView", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoubleTapHeadViewStruct;", "storyDownloadReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDownloadReportStruct;", "storyEntranceExposeReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeReportStruct;", "storyImageVideoRemux", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoRemuxStruct;", "storyImageVideoZip", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoZipStruct;", "storyPageExposeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPageExposeStruct;", "storyPreviewReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPreviewReportStruct;", "storyPreviewTraceStruct", "Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "storyProfileTabExposeReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryProfileTabExposeStruct;", "storySinglePreviewReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StorySinglePreviewReportStruct;", "storyStatusChangeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "getStoryStatusChangeStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "setStoryStatusChangeStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;)V", "storyUploadMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryUploadReportStruct;", "storyVideoPublish", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryComposeReportStruct;", "tag", "videoIdSet", "addPreviewTrace", "", "aid", "checkRepeatUser", "name", "checkRepeatVideo", "doCommentPageExposeReport", "storyId", "doEntranceClearReport", "delete", "doStoryChatTopBarEntranceExposeReport", "doStoryDoubleTapHeadViewReport", "doStoryDownloadReport", "doStoryEntranceReport", "doStoryImageVideoRemuxReport", "doStoryImageVideoZipReport", "doStoryPageReport", "doStoryPreviewReport", "doStoryProfileTabExposeReport", "doStorySinglePreviewReport", "doStoryStatusChangeReport", "doStoryUploadReport", "storyLocalId", "doStoryVideoPublishReport", "doVisiteReport", "visitorCount", "commentCount", "doVisitorPageExposeReport", "getLastStoryUploadReporter", "getStoryChatTopBarEntranceExposeReporter", "getStoryDoubleTapHeadViewReporter", "getStoryDownloadReporter", "getStoryEntranceReport", "getStoryImageVideoRemuxReporter", "getStoryImageVideoZipReporter", "getStoryPageExposeReporter", "getStoryPreviewReporter", "getStoryProfileTabExposeReport", "getStorySinglePreviewReporter", "getStoryVideoPublishReporter", "reportStoryStatusChange", "status", "previewEnterScene", "profileSource", "isAlbumStarButton", "resetStoryPreviewReporter", "resetStoryPreviewTraceData", "resetStoryProfileTabExposeReport", "storyUploadReportCPMediaInfo", "path", "storyUploadReportOriMediaInfo", "isCaptureVideo", "plugin-story_release"})
public final class h
{
  private static int HUr;
  private static ly LOA;
  private static long LOB;
  private static long LOC;
  private static long LOD;
  private static long LOE;
  private static int LOF;
  private static ls LOH;
  private static md LOI;
  public static final h LOJ;
  private static lw LOl;
  private static lx LOm;
  private static a LOn;
  private static Set<String> LOo;
  private static Set<String> LOp;
  private static boolean LOq;
  private static boolean LOr;
  private static lm LOs;
  private static lp LOt;
  private static ln LOu;
  private static lu LOv;
  private static lv LOw;
  private static lq LOx;
  private static final HashMap<Integer, me> LOy;
  private static ma LOz;
  
  static
  {
    AppMethodBeat.i(119464);
    LOJ = new h();
    LOl = new lw();
    HUr = -1;
    LOm = new lx();
    LOn = new a();
    LOo = Collections.synchronizedSet((Set)new HashSet());
    LOp = Collections.synchronizedSet((Set)new HashSet());
    LOq = true;
    LOr = true;
    LOs = new lm();
    LOt = new lp();
    LOu = new ln();
    LOv = new lu();
    LOw = new lv();
    LOx = new lq();
    LOy = new HashMap();
    LOz = new ma();
    LOA = new ly();
    LOH = new ls();
    LOI = new md();
    AppMethodBeat.o(119464);
  }
  
  public static void RM(long paramLong)
  {
    LOB = paramLong;
  }
  
  public static void RN(long paramLong)
  {
    LOC = paramLong;
  }
  
  public static void RO(long paramLong)
  {
    LOD = paramLong;
  }
  
  public static void RP(long paramLong)
  {
    LOE = paramLong;
  }
  
  public static void a(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(119460);
    p.k(paramString, "storyId");
    LOI.CG(paramString);
    LOI.wT(paramLong1);
    LOI.wW(paramLong4);
    LOI.wU(paramLong2);
    LOI.wV(paramLong3);
    LOI.bpa();
    LOI = new md();
    AppMethodBeat.o(119460);
  }
  
  public static void aF(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119462);
    p.k(paramString, "storyId");
    lt locallt = new lt();
    locallt.Cr(paramString);
    locallt.wg(paramInt1);
    locallt.wh(paramInt2);
    locallt.bpa();
    AppMethodBeat.o(119462);
  }
  
  public static void aio(int paramInt)
  {
    AppMethodBeat.i(119443);
    if ((HUr == -1) && (paramInt == 4))
    {
      HUr = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    if ((HUr == 10) && (paramInt == 11))
    {
      HUr = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    HUr = paramInt;
    a locala = LOn;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("aid", paramInt);
    localJSONObject.put("td", locala.HUk.length() + 1);
    if (locala.HUk.toString().length() + localJSONObject.toString().length() > 1000) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0) {}
      synchronized (locala.lock)
      {
        locala.HUk.put(localJSONObject);
        AppMethodBeat.o(119443);
        return;
        paramInt = 1;
      }
    }
  }
  
  public static me aip(int paramInt)
  {
    AppMethodBeat.i(119455);
    me localme2 = (me)LOy.get(Integer.valueOf(paramInt));
    me localme1 = localme2;
    if (localme2 == null)
    {
      localme1 = new me();
      ((Map)LOy).put(Integer.valueOf(paramInt), localme1);
    }
    AppMethodBeat.o(119455);
    return localme1;
  }
  
  public static void aiq(int paramInt)
  {
    AppMethodBeat.i(119456);
    me localme = (me)LOy.get(Integer.valueOf(paramInt));
    if (localme != null)
    {
      Log.d("MicroMsg.StoryReporter", "basic:\n" + localme.anK() + ' ' + localme.anu() + ' ' + localme.anv() + ' ' + localme.anI() + ' ' + localme.ant() + ' ' + localme.anq() + ' ' + localme.ans());
      Log.d("MicroMsg.StoryReporter", "origin:\n" + localme.any() + ' ' + localme.anw() + ' ' + localme.anJ() + ' ' + localme.anB() + ' ' + localme.anA() + ' ' + localme.anz() + ' ' + localme.anx());
      Log.d("MicroMsg.StoryReporter", "cp:\n" + localme.anE() + ' ' + localme.anC() + ' ' + localme.anH() + ' ' + localme.anG() + ' ' + localme.anF() + ' ' + localme.anD());
      localme.bpa();
      LOy.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(119456);
  }
  
  public static void air(int paramInt)
  {
    LOF = paramInt;
  }
  
  public static boolean bdq(String paramString)
  {
    AppMethodBeat.i(119441);
    if (paramString == null)
    {
      AppMethodBeat.o(119441);
      return true;
    }
    if (LOo.contains(paramString))
    {
      AppMethodBeat.o(119441);
      return true;
    }
    LOo.add(paramString);
    AppMethodBeat.o(119441);
    return false;
  }
  
  public static boolean bdr(String paramString)
  {
    AppMethodBeat.i(119442);
    if (paramString == null)
    {
      AppMethodBeat.o(119442);
      return true;
    }
    if (LOp.contains(paramString))
    {
      AppMethodBeat.o(119442);
      return true;
    }
    LOp.add(paramString);
    AppMethodBeat.o(119442);
    return false;
  }
  
  public static void bds(String paramString)
  {
    AppMethodBeat.i(119448);
    p.k(paramString, "storyId");
    if (LOq)
    {
      LOl.wl(8L);
      LOl.Cs(paramString);
      geJ();
    }
    AppMethodBeat.o(119448);
  }
  
  public static void bdt(String paramString)
  {
    AppMethodBeat.i(119449);
    p.k(paramString, "storyId");
    if (LOr)
    {
      LOl.wl(5L);
      LOl.Cs(paramString);
      geJ();
    }
    AppMethodBeat.o(119449);
  }
  
  public static void geD()
  {
    HUr = 1;
  }
  
  public static lx geE()
  {
    return LOm;
  }
  
  public static void geF()
  {
    AppMethodBeat.i(119444);
    if (0L == LOm.amX())
    {
      geH();
      AppMethodBeat.o(119444);
      return;
    }
    LOm.Cu(LOn.fxo());
    lx locallx = LOm;
    locallx.wx(locallx.anb() + LOm.amZ());
    LOm.bpa();
    LOm.wr(0L);
    LOm.wv(0L);
    LOm.wu(0L);
    LOm.ws(0L);
    LOm.ww(0L);
    LOm.wo(0L);
    LOm.wx(0L);
    LOm.wz(0L);
    LOm.Cv("");
    geH();
    AppMethodBeat.o(119444);
  }
  
  public static void geG()
  {
    AppMethodBeat.i(119445);
    LOm = new lx();
    geH();
    AppMethodBeat.o(119445);
  }
  
  public static void geH()
  {
    AppMethodBeat.i(119446);
    LOn = new a();
    HUr = -1;
    LOo.clear();
    LOp.clear();
    AppMethodBeat.o(119446);
  }
  
  public static lw geI()
  {
    return LOl;
  }
  
  public static void geJ()
  {
    AppMethodBeat.i(119447);
    LOl.bpa();
    LOl = new lw();
    AppMethodBeat.o(119447);
  }
  
  public static lm geK()
  {
    return LOs;
  }
  
  public static void geL()
  {
    AppMethodBeat.i(119450);
    if (TextUtils.isEmpty((CharSequence)LOs.getUserName()))
    {
      AppMethodBeat.o(119450);
      return;
    }
    LOs.bpa();
    AppMethodBeat.o(119450);
  }
  
  public static lp geM()
  {
    return LOt;
  }
  
  public static void geN()
  {
    AppMethodBeat.i(119451);
    LOt.bpa();
    AppMethodBeat.o(119451);
  }
  
  public static ln geO()
  {
    return LOu;
  }
  
  public static void geP()
  {
    AppMethodBeat.i(119452);
    LOu.bpa();
    LOu = new ln();
    AppMethodBeat.o(119452);
  }
  
  public static lv geQ()
  {
    return LOw;
  }
  
  public static void geR()
  {
    AppMethodBeat.i(119453);
    LOw.bpa();
    LOw = new lv();
    AppMethodBeat.o(119453);
  }
  
  public static lq geS()
  {
    return LOx;
  }
  
  public static void geT()
  {
    AppMethodBeat.i(119454);
    LOx.bpa();
    LOx = new lq();
    AppMethodBeat.o(119454);
  }
  
  public static ma geU()
  {
    return LOz;
  }
  
  public static void geV()
  {
    AppMethodBeat.i(119457);
    if (LOz.amU() == 0L)
    {
      LOz = new ma();
      AppMethodBeat.o(119457);
      return;
    }
    LOz.bpa();
    LOz = new ma();
    AppMethodBeat.o(119457);
  }
  
  public static long geW()
  {
    return LOE;
  }
  
  public static ly geX()
  {
    return LOA;
  }
  
  public static void geY()
  {
    AppMethodBeat.i(119458);
    if (LOA.ang() != 0L)
    {
      LOA.bpa();
      LOA.anf();
      LOA.and();
      LOA.anc();
      LOA.ane();
      LOA.wA(LOB);
      LOA.wB(LOC);
      LOA.wC(LOD);
    }
    AppMethodBeat.o(119458);
  }
  
  public static int geZ()
  {
    return LOF;
  }
  
  public static ls gfa()
  {
    return LOH;
  }
  
  public static void gfb()
  {
    AppMethodBeat.i(119459);
    LOH.bpa();
    LOH = new ls();
    AppMethodBeat.o(119459);
  }
  
  public static void zA(boolean paramBoolean)
  {
    long l = 1L;
    AppMethodBeat.i(119463);
    lr locallr = new lr();
    locallr.wc(1L);
    if (paramBoolean) {}
    for (;;)
    {
      locallr.we(l);
      locallr.bpa();
      AppMethodBeat.o(119463);
      return;
      l = 0L;
    }
  }
  
  public static void zy(boolean paramBoolean)
  {
    LOq = paramBoolean;
  }
  
  public static void zz(boolean paramBoolean)
  {
    LOr = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.h
 * JD-Core Version:    0.7.0.1
 */