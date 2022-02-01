package com.tencent.mm.plugin.story.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.om;
import com.tencent.mm.autogen.mmdata.rpt.on;
import com.tencent.mm.autogen.mmdata.rpt.op;
import com.tencent.mm.autogen.mmdata.rpt.oq;
import com.tencent.mm.autogen.mmdata.rpt.or;
import com.tencent.mm.autogen.mmdata.rpt.os;
import com.tencent.mm.autogen.mmdata.rpt.ot;
import com.tencent.mm.autogen.mmdata.rpt.ou;
import com.tencent.mm.autogen.mmdata.rpt.ov;
import com.tencent.mm.autogen.mmdata.rpt.ow;
import com.tencent.mm.autogen.mmdata.rpt.ox;
import com.tencent.mm.autogen.mmdata.rpt.oy;
import com.tencent.mm.autogen.mmdata.rpt.pa;
import com.tencent.mm.autogen.mmdata.rpt.pd;
import com.tencent.mm.autogen.mmdata.rpt.pe;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/report/StoryReporter;", "", "()V", "cameraDot", "", "getCameraDot", "()J", "setCameraDot", "(J)V", "currentEntranceExposeTime", "", "getCurrentEntranceExposeTime", "()I", "setCurrentEntranceExposeTime", "(I)V", "currentProfileTabVideoObjectId", "getCurrentProfileTabVideoObjectId", "setCurrentProfileTabVideoObjectId", "lastTrace", "getLastTrace", "setLastTrace", "moreTabDot", "getMoreTabDot", "setMoreTabDot", "nameSet", "", "", "kotlin.jvm.PlatformType", "", "needCommentRpt", "", "getNeedCommentRpt", "()Z", "setNeedCommentRpt", "(Z)V", "needVisitorRpt", "getNeedVisitorRpt", "setNeedVisitorRpt", "storyChatTopBarEntranceExpose", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryChatTopBarEntranceExposeStruct;", "storyCommentDot", "getStoryCommentDot", "setStoryCommentDot", "storyDoubleTapHeadView", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoubleTapHeadViewStruct;", "storyDownloadReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDownloadReportStruct;", "storyEntranceExposeReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeReportStruct;", "storyImageVideoRemux", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoRemuxStruct;", "storyImageVideoZip", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoZipStruct;", "storyPageExposeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPageExposeStruct;", "storyPreviewReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPreviewReportStruct;", "storyPreviewTraceStruct", "Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "storyProfileTabExposeReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryProfileTabExposeStruct;", "storySinglePreviewReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StorySinglePreviewReportStruct;", "storyStatusChangeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "getStoryStatusChangeStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "setStoryStatusChangeStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;)V", "storyUploadMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryUploadReportStruct;", "storyVideoPublish", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryComposeReportStruct;", "tag", "videoIdSet", "addPreviewTrace", "", "aid", "checkRepeatUser", "name", "checkRepeatVideo", "doCommentPageExposeReport", "storyId", "doEntranceClearReport", "delete", "doStoryChatTopBarEntranceExposeReport", "doStoryDoubleTapHeadViewReport", "doStoryDownloadReport", "doStoryEntranceReport", "doStoryImageVideoRemuxReport", "doStoryImageVideoZipReport", "doStoryPageReport", "doStoryPreviewReport", "doStoryProfileTabExposeReport", "doStorySinglePreviewReport", "doStoryStatusChangeReport", "doStoryUploadReport", "storyLocalId", "doStoryVideoPublishReport", "doVisiteReport", "visitorCount", "commentCount", "doVisitorPageExposeReport", "getLastStoryUploadReporter", "getStoryChatTopBarEntranceExposeReporter", "getStoryDoubleTapHeadViewReporter", "getStoryDownloadReporter", "getStoryEntranceReport", "getStoryImageVideoRemuxReporter", "getStoryImageVideoZipReporter", "getStoryPageExposeReporter", "getStoryPreviewReporter", "getStoryProfileTabExposeReport", "getStorySinglePreviewReporter", "getStoryVideoPublishReporter", "reportStoryStatusChange", "status", "previewEnterScene", "profileSource", "isAlbumStarButton", "resetStoryPreviewReporter", "resetStoryPreviewTraceData", "resetStoryProfileTabExposeReport", "storyUploadReportCPMediaInfo", "path", "storyUploadReportOriMediaInfo", "isCaptureVideo", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private static int NRk;
  public static final h SqZ;
  private static ow Sra;
  private static ox Srb;
  private static a Src;
  private static Set<String> Srd;
  private static Set<String> Sre;
  private static boolean Srf;
  private static boolean Srg;
  private static om Srh;
  private static op Sri;
  private static on Srj;
  private static ou Srk;
  private static ov Srl;
  private static oq Srm;
  private static final HashMap<Integer, pe> Srn;
  private static pa Sro;
  private static oy Srp;
  private static long Srq;
  private static long Srr;
  private static long Srs;
  private static long Srt;
  private static int Sru;
  private static os Srv;
  private static pd Srw;
  
  static
  {
    AppMethodBeat.i(119464);
    SqZ = new h();
    Sra = new ow();
    NRk = -1;
    Srb = new ox();
    Src = new a();
    Srd = Collections.synchronizedSet((Set)new HashSet());
    Sre = Collections.synchronizedSet((Set)new HashSet());
    Srf = true;
    Srg = true;
    Srh = new om();
    Sri = new op();
    Srj = new on();
    Srk = new ou();
    Srl = new ov();
    Srm = new oq();
    Srn = new HashMap();
    Sro = new pa();
    Srp = new oy();
    Srv = new os();
    Srw = new pd();
    AppMethodBeat.o(119464);
  }
  
  public static void EO(boolean paramBoolean)
  {
    Srf = paramBoolean;
  }
  
  public static void EP(boolean paramBoolean)
  {
    Srg = paramBoolean;
  }
  
  public static void EQ(boolean paramBoolean)
  {
    long l = 1L;
    AppMethodBeat.i(119463);
    or localor = new or();
    localor.jdp = 1L;
    if (paramBoolean) {}
    for (;;)
    {
      localor.jjX = l;
      localor.bMH();
      AppMethodBeat.o(119463);
      return;
      l = 0L;
    }
  }
  
  public static void a(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(119460);
    s.u(paramString, "storyId");
    pd localpd = Srw;
    localpd.jkB = localpd.F("StoryId", paramString, true);
    Srw.iIf = paramLong1;
    Srw.jll = paramLong4;
    Srw.jjn = paramLong2;
    Srw.jkC = paramLong3;
    Srw.bMH();
    Srw = new pd();
    AppMethodBeat.o(119460);
  }
  
  public static void aN(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119462);
    s.u(paramString, "storyId");
    ot localot = new ot();
    localot.jkk = localot.F("StoryidStr", paramString, true);
    localot.jki = paramInt1;
    localot.jkj = paramInt2;
    localot.bMH();
    AppMethodBeat.o(119462);
  }
  
  public static void ano(int paramInt)
  {
    AppMethodBeat.i(119443);
    if ((NRk == -1) && (paramInt == 4))
    {
      NRk = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    if ((NRk == 10) && (paramInt == 11))
    {
      NRk = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    NRk = paramInt;
    a locala = Src;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("aid", paramInt);
    localJSONObject.put("td", locala.NRc.length() + 1);
    if (locala.NRc.toString().length() + localJSONObject.toString().length() > 1000) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0) {}
      synchronized (locala.lock)
      {
        locala.NRc.put(localJSONObject);
        AppMethodBeat.o(119443);
        return;
        paramInt = 1;
      }
    }
  }
  
  public static pe anp(int paramInt)
  {
    AppMethodBeat.i(119455);
    pe localpe2 = (pe)Srn.get(Integer.valueOf(paramInt));
    pe localpe1 = localpe2;
    if (localpe2 == null)
    {
      localpe1 = new pe();
      ((Map)Srn).put(Integer.valueOf(paramInt), localpe1);
    }
    AppMethodBeat.o(119455);
    return localpe1;
  }
  
  public static void anq(int paramInt)
  {
    AppMethodBeat.i(119456);
    pe localpe = (pe)Srn.get(Integer.valueOf(paramInt));
    if (localpe != null)
    {
      Log.d("MicroMsg.StoryReporter", "basic:\n" + localpe.jlD + ' ' + localpe.jlo + ' ' + localpe.jlp + ' ' + localpe.jlB + ' ' + localpe.jjT + ' ' + localpe.jlm + ' ' + localpe.jln);
      Log.d("MicroMsg.StoryReporter", "origin:\n" + localpe.jlr + ' ' + localpe.iSD + ' ' + localpe.jlC + ' ' + localpe.iSA + ' ' + localpe.iSz + ' ' + localpe.jlt + ' ' + localpe.jlq);
      Log.d("MicroMsg.StoryReporter", "cp:\n" + localpe.jlw + ' ' + localpe.jlu + ' ' + localpe.jlA + ' ' + localpe.jlz + ' ' + localpe.jly + ' ' + localpe.jlv);
      localpe.bMH();
      Srn.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(119456);
  }
  
  public static void anr(int paramInt)
  {
    Sru = paramInt;
  }
  
  public static boolean bcd(String paramString)
  {
    AppMethodBeat.i(119441);
    if (paramString == null)
    {
      AppMethodBeat.o(119441);
      return true;
    }
    if (Srd.contains(paramString))
    {
      AppMethodBeat.o(119441);
      return true;
    }
    Srd.add(paramString);
    AppMethodBeat.o(119441);
    return false;
  }
  
  public static boolean bce(String paramString)
  {
    AppMethodBeat.i(119442);
    if (paramString == null)
    {
      AppMethodBeat.o(119442);
      return true;
    }
    if (Sre.contains(paramString))
    {
      AppMethodBeat.o(119442);
      return true;
    }
    Sre.add(paramString);
    AppMethodBeat.o(119442);
    return false;
  }
  
  public static void bcf(String paramString)
  {
    AppMethodBeat.i(119448);
    s.u(paramString, "storyId");
    if (Srf)
    {
      Sra.iwZ = 8L;
      Sra.wy(paramString);
      hyb();
    }
    AppMethodBeat.o(119448);
  }
  
  public static void bcg(String paramString)
  {
    AppMethodBeat.i(119449);
    s.u(paramString, "storyId");
    if (Srg)
    {
      Sra.iwZ = 5L;
      Sra.wy(paramString);
      hyb();
    }
    AppMethodBeat.o(119449);
  }
  
  public static void hxV()
  {
    NRk = 1;
  }
  
  public static ox hxW()
  {
    return Srb;
  }
  
  public static void hxX()
  {
    AppMethodBeat.i(119444);
    if (0L == Srb.jkG)
    {
      hxZ();
      AppMethodBeat.o(119444);
      return;
    }
    ox localox = Srb;
    localox.itP = localox.F("ActionTrace", Src.gJd(), true);
    localox = Srb;
    localox.jkK += Srb.jkI;
    Srb.bMH();
    Srb.jkE = 0L;
    Srb.jkI = 0L;
    Srb.jkH = 0L;
    Srb.jkF = 0L;
    Srb.jkJ = 0L;
    Srb.jjo = 0L;
    Srb.jkK = 0L;
    Srb.jkM = 0L;
    Srb.wA("");
    hxZ();
    AppMethodBeat.o(119444);
  }
  
  public static void hxY()
  {
    AppMethodBeat.i(119445);
    Srb = new ox();
    hxZ();
    AppMethodBeat.o(119445);
  }
  
  public static void hxZ()
  {
    AppMethodBeat.i(119446);
    Src = new a();
    NRk = -1;
    Srd.clear();
    Sre.clear();
    AppMethodBeat.o(119446);
  }
  
  public static ow hya()
  {
    return Sra;
  }
  
  public static void hyb()
  {
    AppMethodBeat.i(119447);
    Sra.bMH();
    Sra = new ow();
    AppMethodBeat.o(119447);
  }
  
  public static om hyc()
  {
    return Srh;
  }
  
  public static void hyd()
  {
    AppMethodBeat.i(119450);
    if (TextUtils.isEmpty((CharSequence)Srh.irj))
    {
      AppMethodBeat.o(119450);
      return;
    }
    Srh.bMH();
    AppMethodBeat.o(119450);
  }
  
  public static op hye()
  {
    return Sri;
  }
  
  public static void hyf()
  {
    AppMethodBeat.i(119451);
    Sri.bMH();
    AppMethodBeat.o(119451);
  }
  
  public static on hyg()
  {
    return Srj;
  }
  
  public static void hyh()
  {
    AppMethodBeat.i(119452);
    Srj.bMH();
    Srj = new on();
    AppMethodBeat.o(119452);
  }
  
  public static ov hyi()
  {
    return Srl;
  }
  
  public static void hyj()
  {
    AppMethodBeat.i(119453);
    Srl.bMH();
    Srl = new ov();
    AppMethodBeat.o(119453);
  }
  
  public static oq hyk()
  {
    return Srm;
  }
  
  public static void hyl()
  {
    AppMethodBeat.i(119454);
    Srm.bMH();
    Srm = new oq();
    AppMethodBeat.o(119454);
  }
  
  public static pa hym()
  {
    return Sro;
  }
  
  public static void hyn()
  {
    AppMethodBeat.i(119457);
    if (Sro.iuE == 0L)
    {
      Sro = new pa();
      AppMethodBeat.o(119457);
      return;
    }
    Sro.bMH();
    Sro = new pa();
    AppMethodBeat.o(119457);
  }
  
  public static long hyo()
  {
    return Srt;
  }
  
  public static oy hyp()
  {
    return Srp;
  }
  
  public static void hyq()
  {
    AppMethodBeat.i(119458);
    if (Srp.jjE != 0L)
    {
      Srp.bMH();
      Srp.jjE = 0L;
      Srp.jkP = 0L;
      Srp.jkO = 0L;
      Srp.jkQ = 0L;
      Srp.jkR = Srq;
      Srp.jkS = Srr;
      Srp.jkT = Srs;
    }
    AppMethodBeat.o(119458);
  }
  
  public static int hyr()
  {
    return Sru;
  }
  
  public static os hys()
  {
    return Srv;
  }
  
  public static void hyt()
  {
    AppMethodBeat.i(119459);
    Srv.bMH();
    Srv = new os();
    AppMethodBeat.o(119459);
  }
  
  public static void vV(long paramLong)
  {
    Srq = paramLong;
  }
  
  public static void vW(long paramLong)
  {
    Srr = paramLong;
  }
  
  public static void vX(long paramLong)
  {
    Srs = paramLong;
  }
  
  public static void vY(long paramLong)
  {
    Srt = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.h
 * JD-Core Version:    0.7.0.1
 */