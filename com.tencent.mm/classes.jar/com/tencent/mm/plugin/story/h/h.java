package com.tencent.mm.plugin.story.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.da;
import com.tencent.mm.g.b.a.db;
import com.tencent.mm.g.b.a.dd;
import com.tencent.mm.g.b.a.de;
import com.tencent.mm.g.b.a.df;
import com.tencent.mm.g.b.a.dg;
import com.tencent.mm.g.b.a.dh;
import com.tencent.mm.g.b.a.di;
import com.tencent.mm.g.b.a.dj;
import com.tencent.mm.g.b.a.dk;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.g.b.a.dm;
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.g.b.a.dr;
import com.tencent.mm.g.b.a.ds;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/report/StoryReporter;", "", "()V", "cameraDot", "", "getCameraDot", "()J", "setCameraDot", "(J)V", "currentEntranceExposeTime", "", "getCurrentEntranceExposeTime", "()I", "setCurrentEntranceExposeTime", "(I)V", "currentProfileTabVideoObjectId", "getCurrentProfileTabVideoObjectId", "setCurrentProfileTabVideoObjectId", "lastTrace", "getLastTrace", "setLastTrace", "moreTabDot", "getMoreTabDot", "setMoreTabDot", "nameSet", "", "", "kotlin.jvm.PlatformType", "", "needCommentRpt", "", "getNeedCommentRpt", "()Z", "setNeedCommentRpt", "(Z)V", "needVisitorRpt", "getNeedVisitorRpt", "setNeedVisitorRpt", "storyChatTopBarEntranceExpose", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryChatTopBarEntranceExposeStruct;", "storyCommentDot", "getStoryCommentDot", "setStoryCommentDot", "storyDoubleTapHeadView", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoubleTapHeadViewStruct;", "storyDownloadReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDownloadReportStruct;", "storyEntranceExposeReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeReportStruct;", "storyImageVideoRemux", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoRemuxStruct;", "storyImageVideoZip", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoZipStruct;", "storyPageExposeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPageExposeStruct;", "storyPreviewReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPreviewReportStruct;", "storyPreviewTraceStruct", "Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "storyProfileTabExposeReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryProfileTabExposeStruct;", "storySinglePreviewReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StorySinglePreviewReportStruct;", "storyStatusChangeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "getStoryStatusChangeStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "setStoryStatusChangeStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;)V", "storyUploadMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryUploadReportStruct;", "storyVideoPublish", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryComposeReportStruct;", "tag", "videoIdSet", "addPreviewTrace", "", "aid", "checkRepeatUser", "name", "checkRepeatVideo", "doCommentPageExposeReport", "storyId", "doEntranceClearReport", "delete", "doStoryChatTopBarEntranceExposeReport", "doStoryDoubleTapHeadViewReport", "doStoryDownloadReport", "doStoryEntranceReport", "doStoryImageVideoRemuxReport", "doStoryImageVideoZipReport", "doStoryPageReport", "doStoryPreviewReport", "doStoryProfileTabExposeReport", "doStorySinglePreviewReport", "doStoryStatusChangeReport", "doStoryUploadReport", "storyLocalId", "doStoryVideoPublishReport", "doVisiteReport", "visitorCount", "commentCount", "doVisitorPageExposeReport", "getLastStoryUploadReporter", "getStoryChatTopBarEntranceExposeReporter", "getStoryDoubleTapHeadViewReporter", "getStoryDownloadReporter", "getStoryEntranceReport", "getStoryImageVideoRemuxReporter", "getStoryImageVideoZipReporter", "getStoryPageExposeReporter", "getStoryPreviewReporter", "getStoryProfileTabExposeReport", "getStorySinglePreviewReporter", "getStoryVideoPublishReporter", "reportStoryStatusChange", "status", "previewEnterScene", "profileSource", "isAlbumStarButton", "resetStoryPreviewReporter", "resetStoryPreviewTraceData", "resetStoryProfileTabExposeReport", "storyUploadReportCPMediaInfo", "path", "storyUploadReportOriMediaInfo", "isCaptureVideo", "plugin-story_release"})
public final class h
{
  private static int vpm;
  private static dk ymY;
  private static dl ymZ;
  private static a yna;
  private static Set<String> ynb;
  private static Set<String> ync;
  private static boolean ynd;
  private static boolean yne;
  private static da ynf;
  private static dd yng;
  private static db ynh;
  private static di yni;
  private static dj ynj;
  private static de ynk;
  private static final HashMap<Integer, ds> ynl;
  private static do ynm;
  private static dm ynn;
  private static long yno;
  private static long ynp;
  private static long ynq;
  private static long ynr;
  private static int yns;
  private static dg ynt;
  private static dr ynu;
  public static final h ynv;
  
  static
  {
    AppMethodBeat.i(119464);
    ynv = new h();
    ymY = new dk();
    vpm = -1;
    ymZ = new dl();
    yna = new a();
    ynb = Collections.synchronizedSet((Set)new HashSet());
    ync = Collections.synchronizedSet((Set)new HashSet());
    ynd = true;
    yne = true;
    ynf = new da();
    yng = new dd();
    ynh = new db();
    yni = new di();
    ynj = new dj();
    ynk = new de();
    ynl = new HashMap();
    ynm = new do();
    ynn = new dm();
    ynt = new dg();
    ynu = new dr();
    AppMethodBeat.o(119464);
  }
  
  public static void OB(int paramInt)
  {
    AppMethodBeat.i(119443);
    if ((vpm == -1) && (paramInt == 4))
    {
      vpm = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    if ((vpm == 10) && (paramInt == 11))
    {
      vpm = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    vpm = paramInt;
    a locala = yna;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("aid", paramInt);
    localJSONObject.put("td", locala.vph.length() + 1);
    if (locala.vph.toString().length() + localJSONObject.toString().length() > 1000) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0) {}
      synchronized (locala.lock)
      {
        locala.vph.put(localJSONObject);
        AppMethodBeat.o(119443);
        return;
        paramInt = 1;
      }
    }
  }
  
  public static ds OC(int paramInt)
  {
    AppMethodBeat.i(119455);
    ds localds2 = (ds)ynl.get(Integer.valueOf(paramInt));
    ds localds1 = localds2;
    if (localds2 == null)
    {
      localds1 = new ds();
      ((Map)ynl).put(Integer.valueOf(paramInt), localds1);
    }
    AppMethodBeat.o(119455);
    return localds1;
  }
  
  public static void OD(int paramInt)
  {
    AppMethodBeat.i(119456);
    ds localds = (ds)ynl.get(Integer.valueOf(paramInt));
    if (localds != null)
    {
      ad.d("MicroMsg.StoryReporter", "basic:\n" + localds.RI() + ' ' + localds.Rs() + ' ' + localds.Rt() + ' ' + localds.RG() + ' ' + localds.Rr() + ' ' + localds.Rp() + ' ' + localds.Rq());
      ad.d("MicroMsg.StoryReporter", "origin:\n" + localds.Rw() + ' ' + localds.Ru() + ' ' + localds.RH() + ' ' + localds.Rz() + ' ' + localds.Ry() + ' ' + localds.Rx() + ' ' + localds.Rv());
      ad.d("MicroMsg.StoryReporter", "cp:\n" + localds.RC() + ' ' + localds.RA() + ' ' + localds.RF() + ' ' + localds.RE() + ' ' + localds.RD() + ' ' + localds.RB());
      localds.aBj();
      ynl.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(119456);
  }
  
  public static void OE(int paramInt)
  {
    yns = paramInt;
  }
  
  public static void a(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(119460);
    k.h(paramString, "storyId");
    ynu.jY(paramString);
    ynu.gG(paramLong1);
    ynu.gJ(paramLong4);
    ynu.gH(paramLong2);
    ynu.gI(paramLong3);
    ynu.aBj();
    ynu = new dr();
    AppMethodBeat.o(119460);
  }
  
  public static boolean arL(String paramString)
  {
    AppMethodBeat.i(119441);
    if (paramString == null)
    {
      AppMethodBeat.o(119441);
      return true;
    }
    if (ynb.contains(paramString))
    {
      AppMethodBeat.o(119441);
      return true;
    }
    ynb.add(paramString);
    AppMethodBeat.o(119441);
    return false;
  }
  
  public static boolean arM(String paramString)
  {
    AppMethodBeat.i(119442);
    if (paramString == null)
    {
      AppMethodBeat.o(119442);
      return true;
    }
    if (ync.contains(paramString))
    {
      AppMethodBeat.o(119442);
      return true;
    }
    ync.add(paramString);
    AppMethodBeat.o(119442);
    return false;
  }
  
  public static void arN(String paramString)
  {
    AppMethodBeat.i(119448);
    k.h(paramString, "storyId");
    if (ynd)
    {
      ymY.fX(8L);
      ymY.jK(paramString);
      dJo();
    }
    AppMethodBeat.o(119448);
  }
  
  public static void arO(String paramString)
  {
    AppMethodBeat.i(119449);
    k.h(paramString, "storyId");
    if (yne)
    {
      ymY.fX(5L);
      ymY.jK(paramString);
      dJo();
    }
    AppMethodBeat.o(119449);
  }
  
  public static void aw(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119462);
    k.h(paramString, "storyId");
    dh localdh = new dh();
    localdh.jJ(paramString);
    localdh.fS(paramInt1);
    localdh.fT(paramInt2);
    localdh.aBj();
    AppMethodBeat.o(119462);
  }
  
  public static void dJA()
  {
    AppMethodBeat.i(119457);
    if (ynm.QU() == 0L)
    {
      ynm = new do();
      AppMethodBeat.o(119457);
      return;
    }
    ynm.aBj();
    ynm = new do();
    AppMethodBeat.o(119457);
  }
  
  public static long dJB()
  {
    return ynr;
  }
  
  public static dm dJC()
  {
    return ynn;
  }
  
  public static void dJD()
  {
    AppMethodBeat.i(119458);
    if (ynn.Rg() != 0L)
    {
      ynn.aBj();
      ynn.Rf();
      ynn.Rd();
      ynn.Rc();
      ynn.Re();
      ynn.gm(yno);
      ynn.gn(ynp);
      ynn.go(ynq);
    }
    AppMethodBeat.o(119458);
  }
  
  public static int dJE()
  {
    return yns;
  }
  
  public static dg dJF()
  {
    return ynt;
  }
  
  public static void dJG()
  {
    AppMethodBeat.i(119459);
    ynt.aBj();
    ynt = new dg();
    AppMethodBeat.o(119459);
  }
  
  public static void dJi()
  {
    vpm = 1;
  }
  
  public static dl dJj()
  {
    return ymZ;
  }
  
  public static void dJk()
  {
    AppMethodBeat.i(119444);
    if (0L == ymZ.QX())
    {
      dJm();
      AppMethodBeat.o(119444);
      return;
    }
    ymZ.jM(yna.diw());
    dl localdl = ymZ;
    localdl.gj(localdl.Rb() + ymZ.QZ());
    ymZ.aBj();
    ymZ.gd(0L);
    ymZ.gh(0L);
    ymZ.gg(0L);
    ymZ.ge(0L);
    ymZ.gi(0L);
    ymZ.ga(0L);
    ymZ.gj(0L);
    ymZ.gl(0L);
    ymZ.jN("");
    dJm();
    AppMethodBeat.o(119444);
  }
  
  public static void dJl()
  {
    AppMethodBeat.i(119445);
    ymZ = new dl();
    dJm();
    AppMethodBeat.o(119445);
  }
  
  public static void dJm()
  {
    AppMethodBeat.i(119446);
    yna = new a();
    vpm = -1;
    ynb.clear();
    ync.clear();
    AppMethodBeat.o(119446);
  }
  
  public static dk dJn()
  {
    return ymY;
  }
  
  public static void dJo()
  {
    AppMethodBeat.i(119447);
    ymY.aBj();
    ymY = new dk();
    AppMethodBeat.o(119447);
  }
  
  public static da dJp()
  {
    return ynf;
  }
  
  public static void dJq()
  {
    AppMethodBeat.i(119450);
    if (TextUtils.isEmpty((CharSequence)ynf.getUserName()))
    {
      AppMethodBeat.o(119450);
      return;
    }
    ynf.aBj();
    AppMethodBeat.o(119450);
  }
  
  public static dd dJr()
  {
    return yng;
  }
  
  public static void dJs()
  {
    AppMethodBeat.i(119451);
    yng.aBj();
    AppMethodBeat.o(119451);
  }
  
  public static db dJt()
  {
    return ynh;
  }
  
  public static void dJu()
  {
    AppMethodBeat.i(119452);
    ynh.aBj();
    ynh = new db();
    AppMethodBeat.o(119452);
  }
  
  public static dj dJv()
  {
    return ynj;
  }
  
  public static void dJw()
  {
    AppMethodBeat.i(119453);
    ynj.aBj();
    ynj = new dj();
    AppMethodBeat.o(119453);
  }
  
  public static de dJx()
  {
    return ynk;
  }
  
  public static void dJy()
  {
    AppMethodBeat.i(119454);
    ynk.aBj();
    ynk = new de();
    AppMethodBeat.o(119454);
  }
  
  public static do dJz()
  {
    return ynm;
  }
  
  public static void qO(boolean paramBoolean)
  {
    ynd = paramBoolean;
  }
  
  public static void qP(boolean paramBoolean)
  {
    yne = paramBoolean;
  }
  
  public static void qQ(boolean paramBoolean)
  {
    long l = 1L;
    AppMethodBeat.i(119463);
    df localdf = new df();
    localdf.fO(1L);
    if (paramBoolean) {}
    for (;;)
    {
      localdf.fQ(l);
      localdf.aBj();
      AppMethodBeat.o(119463);
      return;
      l = 0L;
    }
  }
  
  public static void tO(long paramLong)
  {
    yno = paramLong;
  }
  
  public static void tP(long paramLong)
  {
    ynp = paramLong;
  }
  
  public static void tQ(long paramLong)
  {
    ynq = paramLong;
  }
  
  public static void tR(long paramLong)
  {
    ynr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.h
 * JD-Core Version:    0.7.0.1
 */