package com.tencent.mm.plugin.story.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fn;
import com.tencent.mm.g.b.a.fo;
import com.tencent.mm.g.b.a.fq;
import com.tencent.mm.g.b.a.fr;
import com.tencent.mm.g.b.a.fs;
import com.tencent.mm.g.b.a.ft;
import com.tencent.mm.g.b.a.fu;
import com.tencent.mm.g.b.a.fv;
import com.tencent.mm.g.b.a.fw;
import com.tencent.mm.g.b.a.fx;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.g.b.a.fz;
import com.tencent.mm.g.b.a.gb;
import com.tencent.mm.g.b.a.ge;
import com.tencent.mm.g.b.a.gf;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/report/StoryReporter;", "", "()V", "cameraDot", "", "getCameraDot", "()J", "setCameraDot", "(J)V", "currentEntranceExposeTime", "", "getCurrentEntranceExposeTime", "()I", "setCurrentEntranceExposeTime", "(I)V", "currentProfileTabVideoObjectId", "getCurrentProfileTabVideoObjectId", "setCurrentProfileTabVideoObjectId", "lastTrace", "getLastTrace", "setLastTrace", "moreTabDot", "getMoreTabDot", "setMoreTabDot", "nameSet", "", "", "kotlin.jvm.PlatformType", "", "needCommentRpt", "", "getNeedCommentRpt", "()Z", "setNeedCommentRpt", "(Z)V", "needVisitorRpt", "getNeedVisitorRpt", "setNeedVisitorRpt", "storyChatTopBarEntranceExpose", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryChatTopBarEntranceExposeStruct;", "storyCommentDot", "getStoryCommentDot", "setStoryCommentDot", "storyDoubleTapHeadView", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoubleTapHeadViewStruct;", "storyDownloadReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDownloadReportStruct;", "storyEntranceExposeReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeReportStruct;", "storyImageVideoRemux", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoRemuxStruct;", "storyImageVideoZip", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoZipStruct;", "storyPageExposeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPageExposeStruct;", "storyPreviewReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPreviewReportStruct;", "storyPreviewTraceStruct", "Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "storyProfileTabExposeReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryProfileTabExposeStruct;", "storySinglePreviewReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StorySinglePreviewReportStruct;", "storyStatusChangeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "getStoryStatusChangeStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "setStoryStatusChangeStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;)V", "storyUploadMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryUploadReportStruct;", "storyVideoPublish", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryComposeReportStruct;", "tag", "videoIdSet", "addPreviewTrace", "", "aid", "checkRepeatUser", "name", "checkRepeatVideo", "doCommentPageExposeReport", "storyId", "doEntranceClearReport", "delete", "doStoryChatTopBarEntranceExposeReport", "doStoryDoubleTapHeadViewReport", "doStoryDownloadReport", "doStoryEntranceReport", "doStoryImageVideoRemuxReport", "doStoryImageVideoZipReport", "doStoryPageReport", "doStoryPreviewReport", "doStoryProfileTabExposeReport", "doStorySinglePreviewReport", "doStoryStatusChangeReport", "doStoryUploadReport", "storyLocalId", "doStoryVideoPublishReport", "doVisiteReport", "visitorCount", "commentCount", "doVisitorPageExposeReport", "getLastStoryUploadReporter", "getStoryChatTopBarEntranceExposeReporter", "getStoryDoubleTapHeadViewReporter", "getStoryDownloadReporter", "getStoryEntranceReport", "getStoryImageVideoRemuxReporter", "getStoryImageVideoZipReporter", "getStoryPageExposeReporter", "getStoryPreviewReporter", "getStoryProfileTabExposeReport", "getStorySinglePreviewReporter", "getStoryVideoPublishReporter", "reportStoryStatusChange", "status", "previewEnterScene", "profileSource", "isAlbumStarButton", "resetStoryPreviewReporter", "resetStoryPreviewTraceData", "resetStoryProfileTabExposeReport", "storyUploadReportCPMediaInfo", "path", "storyUploadReportOriMediaInfo", "isCaptureVideo", "plugin-story_release"})
public final class h
{
  private static fx ARW;
  private static fy ARX;
  private static a ARY;
  private static Set<String> ARZ;
  private static Set<String> ASa;
  private static boolean ASb;
  private static boolean ASc;
  private static fn ASd;
  private static fq ASe;
  private static fo ASf;
  private static fv ASg;
  private static fw ASh;
  private static fr ASi;
  private static final HashMap<Integer, gf> ASj;
  private static gb ASk;
  private static fz ASl;
  private static long ASm;
  private static long ASn;
  private static long ASo;
  private static long ASp;
  private static int ASq;
  private static ft ASr;
  private static ge ASs;
  public static final h ASt;
  private static int xGX;
  
  static
  {
    AppMethodBeat.i(119464);
    ASt = new h();
    ARW = new fx();
    xGX = -1;
    ARX = new fy();
    ARY = new a();
    ARZ = Collections.synchronizedSet((Set)new HashSet());
    ASa = Collections.synchronizedSet((Set)new HashSet());
    ASb = true;
    ASc = true;
    ASd = new fn();
    ASe = new fq();
    ASf = new fo();
    ASg = new fv();
    ASh = new fw();
    ASi = new fr();
    ASj = new HashMap();
    ASk = new gb();
    ASl = new fz();
    ASr = new ft();
    ASs = new ge();
    AppMethodBeat.o(119464);
  }
  
  public static void AP(long paramLong)
  {
    ASm = paramLong;
  }
  
  public static void AQ(long paramLong)
  {
    ASn = paramLong;
  }
  
  public static void AR(long paramLong)
  {
    ASo = paramLong;
  }
  
  public static void AS(long paramLong)
  {
    ASp = paramLong;
  }
  
  public static void Sq(int paramInt)
  {
    AppMethodBeat.i(119443);
    if ((xGX == -1) && (paramInt == 4))
    {
      xGX = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    if ((xGX == 10) && (paramInt == 11))
    {
      xGX = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    xGX = paramInt;
    a locala = ARY;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("aid", paramInt);
    localJSONObject.put("td", locala.xGQ.length() + 1);
    if (locala.xGQ.toString().length() + localJSONObject.toString().length() > 1000) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0) {}
      synchronized (locala.lock)
      {
        locala.xGQ.put(localJSONObject);
        AppMethodBeat.o(119443);
        return;
        paramInt = 1;
      }
    }
  }
  
  public static gf Sr(int paramInt)
  {
    AppMethodBeat.i(119455);
    gf localgf2 = (gf)ASj.get(Integer.valueOf(paramInt));
    gf localgf1 = localgf2;
    if (localgf2 == null)
    {
      localgf1 = new gf();
      ((Map)ASj).put(Integer.valueOf(paramInt), localgf1);
    }
    AppMethodBeat.o(119455);
    return localgf1;
  }
  
  public static void Ss(int paramInt)
  {
    AppMethodBeat.i(119456);
    gf localgf = (gf)ASj.get(Integer.valueOf(paramInt));
    if (localgf != null)
    {
      ad.d("MicroMsg.StoryReporter", "basic:\n" + localgf.Ur() + ' ' + localgf.Ub() + ' ' + localgf.Uc() + ' ' + localgf.Up() + ' ' + localgf.Ua() + ' ' + localgf.TY() + ' ' + localgf.TZ());
      ad.d("MicroMsg.StoryReporter", "origin:\n" + localgf.Uf() + ' ' + localgf.Ud() + ' ' + localgf.Uq() + ' ' + localgf.Ui() + ' ' + localgf.Uh() + ' ' + localgf.Ug() + ' ' + localgf.Ue());
      ad.d("MicroMsg.StoryReporter", "cp:\n" + localgf.Ul() + ' ' + localgf.Uj() + ' ' + localgf.Uo() + ' ' + localgf.Un() + ' ' + localgf.Um() + ' ' + localgf.Uk());
      localgf.aLk();
      ASj.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(119456);
  }
  
  public static void St(int paramInt)
  {
    ASq = paramInt;
  }
  
  public static void a(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(119460);
    p.h(paramString, "storyId");
    ASs.pb(paramString);
    ASs.lF(paramLong1);
    ASs.lI(paramLong4);
    ASs.lG(paramLong2);
    ASs.lH(paramLong3);
    ASs.aLk();
    ASs = new ge();
    AppMethodBeat.o(119460);
  }
  
  public static boolean aBY(String paramString)
  {
    AppMethodBeat.i(119441);
    if (paramString == null)
    {
      AppMethodBeat.o(119441);
      return true;
    }
    if (ARZ.contains(paramString))
    {
      AppMethodBeat.o(119441);
      return true;
    }
    ARZ.add(paramString);
    AppMethodBeat.o(119441);
    return false;
  }
  
  public static boolean aBZ(String paramString)
  {
    AppMethodBeat.i(119442);
    if (paramString == null)
    {
      AppMethodBeat.o(119442);
      return true;
    }
    if (ASa.contains(paramString))
    {
      AppMethodBeat.o(119442);
      return true;
    }
    ASa.add(paramString);
    AppMethodBeat.o(119442);
    return false;
  }
  
  public static void aCa(String paramString)
  {
    AppMethodBeat.i(119448);
    p.h(paramString, "storyId");
    if (ASb)
    {
      ARW.kW(8L);
      ARW.oN(paramString);
      eke();
    }
    AppMethodBeat.o(119448);
  }
  
  public static void aCb(String paramString)
  {
    AppMethodBeat.i(119449);
    p.h(paramString, "storyId");
    if (ASc)
    {
      ARW.kW(5L);
      ARW.oN(paramString);
      eke();
    }
    AppMethodBeat.o(119449);
  }
  
  public static void ay(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119462);
    p.h(paramString, "storyId");
    fu localfu = new fu();
    localfu.oM(paramString);
    localfu.kR(paramInt1);
    localfu.kS(paramInt2);
    localfu.aLk();
    AppMethodBeat.o(119462);
  }
  
  public static void ejY()
  {
    xGX = 1;
  }
  
  public static fy ejZ()
  {
    return ARX;
  }
  
  public static void eka()
  {
    AppMethodBeat.i(119444);
    if (0L == ARX.TG())
    {
      ekc();
      AppMethodBeat.o(119444);
      return;
    }
    ARX.oP(ARY.dGJ());
    fy localfy = ARX;
    localfy.li(localfy.TK() + ARX.TI());
    ARX.aLk();
    ARX.lc(0L);
    ARX.lg(0L);
    ARX.lf(0L);
    ARX.ld(0L);
    ARX.lh(0L);
    ARX.kZ(0L);
    ARX.li(0L);
    ARX.lk(0L);
    ARX.oQ("");
    ekc();
    AppMethodBeat.o(119444);
  }
  
  public static void ekb()
  {
    AppMethodBeat.i(119445);
    ARX = new fy();
    ekc();
    AppMethodBeat.o(119445);
  }
  
  public static void ekc()
  {
    AppMethodBeat.i(119446);
    ARY = new a();
    xGX = -1;
    ARZ.clear();
    ASa.clear();
    AppMethodBeat.o(119446);
  }
  
  public static fx ekd()
  {
    return ARW;
  }
  
  public static void eke()
  {
    AppMethodBeat.i(119447);
    ARW.aLk();
    ARW = new fx();
    AppMethodBeat.o(119447);
  }
  
  public static fn ekf()
  {
    return ASd;
  }
  
  public static void ekg()
  {
    AppMethodBeat.i(119450);
    if (TextUtils.isEmpty((CharSequence)ASd.getUserName()))
    {
      AppMethodBeat.o(119450);
      return;
    }
    ASd.aLk();
    AppMethodBeat.o(119450);
  }
  
  public static fq ekh()
  {
    return ASe;
  }
  
  public static void eki()
  {
    AppMethodBeat.i(119451);
    ASe.aLk();
    AppMethodBeat.o(119451);
  }
  
  public static fo ekj()
  {
    return ASf;
  }
  
  public static void ekk()
  {
    AppMethodBeat.i(119452);
    ASf.aLk();
    ASf = new fo();
    AppMethodBeat.o(119452);
  }
  
  public static fw ekl()
  {
    return ASh;
  }
  
  public static void ekm()
  {
    AppMethodBeat.i(119453);
    ASh.aLk();
    ASh = new fw();
    AppMethodBeat.o(119453);
  }
  
  public static fr ekn()
  {
    return ASi;
  }
  
  public static void eko()
  {
    AppMethodBeat.i(119454);
    ASi.aLk();
    ASi = new fr();
    AppMethodBeat.o(119454);
  }
  
  public static gb ekp()
  {
    return ASk;
  }
  
  public static void ekq()
  {
    AppMethodBeat.i(119457);
    if (ASk.TD() == 0L)
    {
      ASk = new gb();
      AppMethodBeat.o(119457);
      return;
    }
    ASk.aLk();
    ASk = new gb();
    AppMethodBeat.o(119457);
  }
  
  public static long ekr()
  {
    return ASp;
  }
  
  public static fz eks()
  {
    return ASl;
  }
  
  public static void ekt()
  {
    AppMethodBeat.i(119458);
    if (ASl.TP() != 0L)
    {
      ASl.aLk();
      ASl.TO();
      ASl.TM();
      ASl.TL();
      ASl.TN();
      ASl.ll(ASm);
      ASl.lm(ASn);
      ASl.ln(ASo);
    }
    AppMethodBeat.o(119458);
  }
  
  public static int eku()
  {
    return ASq;
  }
  
  public static ft ekv()
  {
    return ASr;
  }
  
  public static void ekw()
  {
    AppMethodBeat.i(119459);
    ASr.aLk();
    ASr = new ft();
    AppMethodBeat.o(119459);
  }
  
  public static void ss(boolean paramBoolean)
  {
    ASb = paramBoolean;
  }
  
  public static void st(boolean paramBoolean)
  {
    ASc = paramBoolean;
  }
  
  public static void su(boolean paramBoolean)
  {
    long l = 1L;
    AppMethodBeat.i(119463);
    fs localfs = new fs();
    localfs.kN(1L);
    if (paramBoolean) {}
    for (;;)
    {
      localfs.kP(l);
      localfs.aLk();
      AppMethodBeat.o(119463);
      return;
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.h
 * JD-Core Version:    0.7.0.1
 */