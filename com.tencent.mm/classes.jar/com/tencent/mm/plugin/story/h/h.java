package com.tencent.mm.plugin.story.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.g.b.a.fq;
import com.tencent.mm.g.b.a.fs;
import com.tencent.mm.g.b.a.ft;
import com.tencent.mm.g.b.a.fu;
import com.tencent.mm.g.b.a.fv;
import com.tencent.mm.g.b.a.fw;
import com.tencent.mm.g.b.a.fx;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.g.b.a.fz;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.g.b.a.gb;
import com.tencent.mm.g.b.a.gd;
import com.tencent.mm.g.b.a.gg;
import com.tencent.mm.g.b.a.gh;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/report/StoryReporter;", "", "()V", "cameraDot", "", "getCameraDot", "()J", "setCameraDot", "(J)V", "currentEntranceExposeTime", "", "getCurrentEntranceExposeTime", "()I", "setCurrentEntranceExposeTime", "(I)V", "currentProfileTabVideoObjectId", "getCurrentProfileTabVideoObjectId", "setCurrentProfileTabVideoObjectId", "lastTrace", "getLastTrace", "setLastTrace", "moreTabDot", "getMoreTabDot", "setMoreTabDot", "nameSet", "", "", "kotlin.jvm.PlatformType", "", "needCommentRpt", "", "getNeedCommentRpt", "()Z", "setNeedCommentRpt", "(Z)V", "needVisitorRpt", "getNeedVisitorRpt", "setNeedVisitorRpt", "storyChatTopBarEntranceExpose", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryChatTopBarEntranceExposeStruct;", "storyCommentDot", "getStoryCommentDot", "setStoryCommentDot", "storyDoubleTapHeadView", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoubleTapHeadViewStruct;", "storyDownloadReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDownloadReportStruct;", "storyEntranceExposeReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeReportStruct;", "storyImageVideoRemux", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoRemuxStruct;", "storyImageVideoZip", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoZipStruct;", "storyPageExposeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPageExposeStruct;", "storyPreviewReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPreviewReportStruct;", "storyPreviewTraceStruct", "Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "storyProfileTabExposeReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryProfileTabExposeStruct;", "storySinglePreviewReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StorySinglePreviewReportStruct;", "storyStatusChangeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "getStoryStatusChangeStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "setStoryStatusChangeStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;)V", "storyUploadMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryUploadReportStruct;", "storyVideoPublish", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryComposeReportStruct;", "tag", "videoIdSet", "addPreviewTrace", "", "aid", "checkRepeatUser", "name", "checkRepeatVideo", "doCommentPageExposeReport", "storyId", "doEntranceClearReport", "delete", "doStoryChatTopBarEntranceExposeReport", "doStoryDoubleTapHeadViewReport", "doStoryDownloadReport", "doStoryEntranceReport", "doStoryImageVideoRemuxReport", "doStoryImageVideoZipReport", "doStoryPageReport", "doStoryPreviewReport", "doStoryProfileTabExposeReport", "doStorySinglePreviewReport", "doStoryStatusChangeReport", "doStoryUploadReport", "storyLocalId", "doStoryVideoPublishReport", "doVisiteReport", "visitorCount", "commentCount", "doVisitorPageExposeReport", "getLastStoryUploadReporter", "getStoryChatTopBarEntranceExposeReporter", "getStoryDoubleTapHeadViewReporter", "getStoryDownloadReporter", "getStoryEntranceReport", "getStoryImageVideoRemuxReporter", "getStoryImageVideoZipReporter", "getStoryPageExposeReporter", "getStoryPreviewReporter", "getStoryProfileTabExposeReport", "getStorySinglePreviewReporter", "getStoryVideoPublishReporter", "reportStoryStatusChange", "status", "previewEnterScene", "profileSource", "isAlbumStarButton", "resetStoryPreviewReporter", "resetStoryPreviewTraceData", "resetStoryProfileTabExposeReport", "storyUploadReportCPMediaInfo", "path", "storyUploadReportOriMediaInfo", "isCaptureVideo", "plugin-story_release"})
public final class h
{
  private static boolean BjA;
  private static fp BjB;
  private static fs BjC;
  private static fq BjD;
  private static fx BjE;
  private static fy BjF;
  private static ft BjG;
  private static final HashMap<Integer, gh> BjH;
  private static gd BjI;
  private static gb BjJ;
  private static long BjK;
  private static long BjL;
  private static long BjM;
  private static long BjN;
  private static int BjO;
  private static fv BjP;
  private static gg BjQ;
  public static final h BjR;
  private static fz Bju;
  private static ga Bjv;
  private static a Bjw;
  private static Set<String> Bjx;
  private static Set<String> Bjy;
  private static boolean Bjz;
  private static int xWS;
  
  static
  {
    AppMethodBeat.i(119464);
    BjR = new h();
    Bju = new fz();
    xWS = -1;
    Bjv = new ga();
    Bjw = new a();
    Bjx = Collections.synchronizedSet((Set)new HashSet());
    Bjy = Collections.synchronizedSet((Set)new HashSet());
    Bjz = true;
    BjA = true;
    BjB = new fp();
    BjC = new fs();
    BjD = new fq();
    BjE = new fx();
    BjF = new fy();
    BjG = new ft();
    BjH = new HashMap();
    BjI = new gd();
    BjJ = new gb();
    BjP = new fv();
    BjQ = new gg();
    AppMethodBeat.o(119464);
  }
  
  public static void Bn(long paramLong)
  {
    BjK = paramLong;
  }
  
  public static void Bo(long paramLong)
  {
    BjL = paramLong;
  }
  
  public static void Bp(long paramLong)
  {
    BjM = paramLong;
  }
  
  public static void Bq(long paramLong)
  {
    BjN = paramLong;
  }
  
  public static void SX(int paramInt)
  {
    AppMethodBeat.i(119443);
    if ((xWS == -1) && (paramInt == 4))
    {
      xWS = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    if ((xWS == 10) && (paramInt == 11))
    {
      xWS = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    xWS = paramInt;
    a locala = Bjw;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("aid", paramInt);
    localJSONObject.put("td", locala.xWL.length() + 1);
    if (locala.xWL.toString().length() + localJSONObject.toString().length() > 1000) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0) {}
      synchronized (locala.lock)
      {
        locala.xWL.put(localJSONObject);
        AppMethodBeat.o(119443);
        return;
        paramInt = 1;
      }
    }
  }
  
  public static gh SY(int paramInt)
  {
    AppMethodBeat.i(119455);
    gh localgh2 = (gh)BjH.get(Integer.valueOf(paramInt));
    gh localgh1 = localgh2;
    if (localgh2 == null)
    {
      localgh1 = new gh();
      ((Map)BjH).put(Integer.valueOf(paramInt), localgh1);
    }
    AppMethodBeat.o(119455);
    return localgh1;
  }
  
  public static void SZ(int paramInt)
  {
    AppMethodBeat.i(119456);
    gh localgh = (gh)BjH.get(Integer.valueOf(paramInt));
    if (localgh != null)
    {
      ae.d("MicroMsg.StoryReporter", "basic:\n" + localgh.Ux() + ' ' + localgh.Uh() + ' ' + localgh.Ui() + ' ' + localgh.Uv() + ' ' + localgh.Ug() + ' ' + localgh.Ue() + ' ' + localgh.Uf());
      ae.d("MicroMsg.StoryReporter", "origin:\n" + localgh.Ul() + ' ' + localgh.Uj() + ' ' + localgh.Uw() + ' ' + localgh.Uo() + ' ' + localgh.Un() + ' ' + localgh.Um() + ' ' + localgh.Uk());
      ae.d("MicroMsg.StoryReporter", "cp:\n" + localgh.Ur() + ' ' + localgh.Up() + ' ' + localgh.Uu() + ' ' + localgh.Ut() + ' ' + localgh.Us() + ' ' + localgh.Uq());
      localgh.aLH();
      BjH.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(119456);
  }
  
  public static void Ta(int paramInt)
  {
    BjO = paramInt;
  }
  
  public static void a(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(119460);
    p.h(paramString, "storyId");
    BjQ.px(paramString);
    BjQ.lQ(paramLong1);
    BjQ.lT(paramLong4);
    BjQ.lR(paramLong2);
    BjQ.lS(paramLong3);
    BjQ.aLH();
    BjQ = new gg();
    AppMethodBeat.o(119460);
  }
  
  public static boolean aDr(String paramString)
  {
    AppMethodBeat.i(119441);
    if (paramString == null)
    {
      AppMethodBeat.o(119441);
      return true;
    }
    if (Bjx.contains(paramString))
    {
      AppMethodBeat.o(119441);
      return true;
    }
    Bjx.add(paramString);
    AppMethodBeat.o(119441);
    return false;
  }
  
  public static boolean aDs(String paramString)
  {
    AppMethodBeat.i(119442);
    if (paramString == null)
    {
      AppMethodBeat.o(119442);
      return true;
    }
    if (Bjy.contains(paramString))
    {
      AppMethodBeat.o(119442);
      return true;
    }
    Bjy.add(paramString);
    AppMethodBeat.o(119442);
    return false;
  }
  
  public static void aDt(String paramString)
  {
    AppMethodBeat.i(119448);
    p.h(paramString, "storyId");
    if (Bjz)
    {
      Bju.lh(8L);
      Bju.pi(paramString);
      enN();
    }
    AppMethodBeat.o(119448);
  }
  
  public static void aDu(String paramString)
  {
    AppMethodBeat.i(119449);
    p.h(paramString, "storyId");
    if (BjA)
    {
      Bju.lh(5L);
      Bju.pi(paramString);
      enN();
    }
    AppMethodBeat.o(119449);
  }
  
  public static void az(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119462);
    p.h(paramString, "storyId");
    fw localfw = new fw();
    localfw.ph(paramString);
    localfw.lc(paramInt1);
    localfw.ld(paramInt2);
    localfw.aLH();
    AppMethodBeat.o(119462);
  }
  
  public static void enH()
  {
    xWS = 1;
  }
  
  public static ga enI()
  {
    return Bjv;
  }
  
  public static void enJ()
  {
    AppMethodBeat.i(119444);
    if (0L == Bjv.TM())
    {
      enL();
      AppMethodBeat.o(119444);
      return;
    }
    Bjv.pk(Bjw.dKa());
    ga localga = Bjv;
    localga.lt(localga.TQ() + Bjv.TO());
    Bjv.aLH();
    Bjv.ln(0L);
    Bjv.lr(0L);
    Bjv.lq(0L);
    Bjv.lo(0L);
    Bjv.ls(0L);
    Bjv.lk(0L);
    Bjv.lt(0L);
    Bjv.lv(0L);
    Bjv.pl("");
    enL();
    AppMethodBeat.o(119444);
  }
  
  public static void enK()
  {
    AppMethodBeat.i(119445);
    Bjv = new ga();
    enL();
    AppMethodBeat.o(119445);
  }
  
  public static void enL()
  {
    AppMethodBeat.i(119446);
    Bjw = new a();
    xWS = -1;
    Bjx.clear();
    Bjy.clear();
    AppMethodBeat.o(119446);
  }
  
  public static fz enM()
  {
    return Bju;
  }
  
  public static void enN()
  {
    AppMethodBeat.i(119447);
    Bju.aLH();
    Bju = new fz();
    AppMethodBeat.o(119447);
  }
  
  public static fp enO()
  {
    return BjB;
  }
  
  public static void enP()
  {
    AppMethodBeat.i(119450);
    if (TextUtils.isEmpty((CharSequence)BjB.getUserName()))
    {
      AppMethodBeat.o(119450);
      return;
    }
    BjB.aLH();
    AppMethodBeat.o(119450);
  }
  
  public static fs enQ()
  {
    return BjC;
  }
  
  public static void enR()
  {
    AppMethodBeat.i(119451);
    BjC.aLH();
    AppMethodBeat.o(119451);
  }
  
  public static fq enS()
  {
    return BjD;
  }
  
  public static void enT()
  {
    AppMethodBeat.i(119452);
    BjD.aLH();
    BjD = new fq();
    AppMethodBeat.o(119452);
  }
  
  public static fy enU()
  {
    return BjF;
  }
  
  public static void enV()
  {
    AppMethodBeat.i(119453);
    BjF.aLH();
    BjF = new fy();
    AppMethodBeat.o(119453);
  }
  
  public static ft enW()
  {
    return BjG;
  }
  
  public static void enX()
  {
    AppMethodBeat.i(119454);
    BjG.aLH();
    BjG = new ft();
    AppMethodBeat.o(119454);
  }
  
  public static gd enY()
  {
    return BjI;
  }
  
  public static void enZ()
  {
    AppMethodBeat.i(119457);
    if (BjI.TJ() == 0L)
    {
      BjI = new gd();
      AppMethodBeat.o(119457);
      return;
    }
    BjI.aLH();
    BjI = new gd();
    AppMethodBeat.o(119457);
  }
  
  public static long eoa()
  {
    return BjN;
  }
  
  public static gb eob()
  {
    return BjJ;
  }
  
  public static void eoc()
  {
    AppMethodBeat.i(119458);
    if (BjJ.TV() != 0L)
    {
      BjJ.aLH();
      BjJ.TU();
      BjJ.TS();
      BjJ.TR();
      BjJ.TT();
      BjJ.lw(BjK);
      BjJ.lx(BjL);
      BjJ.ly(BjM);
    }
    AppMethodBeat.o(119458);
  }
  
  public static int eod()
  {
    return BjO;
  }
  
  public static fv eoe()
  {
    return BjP;
  }
  
  public static void eof()
  {
    AppMethodBeat.i(119459);
    BjP.aLH();
    BjP = new fv();
    AppMethodBeat.o(119459);
  }
  
  public static void sA(boolean paramBoolean)
  {
    BjA = paramBoolean;
  }
  
  public static void sB(boolean paramBoolean)
  {
    long l = 1L;
    AppMethodBeat.i(119463);
    fu localfu = new fu();
    localfu.kY(1L);
    if (paramBoolean) {}
    for (;;)
    {
      localfu.la(l);
      localfu.aLH();
      AppMethodBeat.o(119463);
      return;
      l = 0L;
    }
  }
  
  public static void sz(boolean paramBoolean)
  {
    Bjz = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.h
 * JD-Core Version:    0.7.0.1
 */