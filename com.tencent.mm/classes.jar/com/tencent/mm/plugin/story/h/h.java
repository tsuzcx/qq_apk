package com.tencent.mm.plugin.story.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jd;
import com.tencent.mm.g.b.a.je;
import com.tencent.mm.g.b.a.jg;
import com.tencent.mm.g.b.a.jh;
import com.tencent.mm.g.b.a.ji;
import com.tencent.mm.g.b.a.jj;
import com.tencent.mm.g.b.a.jk;
import com.tencent.mm.g.b.a.jl;
import com.tencent.mm.g.b.a.jm;
import com.tencent.mm.g.b.a.jn;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.g.b.a.jp;
import com.tencent.mm.g.b.a.jr;
import com.tencent.mm.g.b.a.ju;
import com.tencent.mm.g.b.a.jv;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/report/StoryReporter;", "", "()V", "cameraDot", "", "getCameraDot", "()J", "setCameraDot", "(J)V", "currentEntranceExposeTime", "", "getCurrentEntranceExposeTime", "()I", "setCurrentEntranceExposeTime", "(I)V", "currentProfileTabVideoObjectId", "getCurrentProfileTabVideoObjectId", "setCurrentProfileTabVideoObjectId", "lastTrace", "getLastTrace", "setLastTrace", "moreTabDot", "getMoreTabDot", "setMoreTabDot", "nameSet", "", "", "kotlin.jvm.PlatformType", "", "needCommentRpt", "", "getNeedCommentRpt", "()Z", "setNeedCommentRpt", "(Z)V", "needVisitorRpt", "getNeedVisitorRpt", "setNeedVisitorRpt", "storyChatTopBarEntranceExpose", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryChatTopBarEntranceExposeStruct;", "storyCommentDot", "getStoryCommentDot", "setStoryCommentDot", "storyDoubleTapHeadView", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoubleTapHeadViewStruct;", "storyDownloadReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDownloadReportStruct;", "storyEntranceExposeReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeReportStruct;", "storyImageVideoRemux", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoRemuxStruct;", "storyImageVideoZip", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoZipStruct;", "storyPageExposeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPageExposeStruct;", "storyPreviewReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPreviewReportStruct;", "storyPreviewTraceStruct", "Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "storyProfileTabExposeReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryProfileTabExposeStruct;", "storySinglePreviewReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StorySinglePreviewReportStruct;", "storyStatusChangeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "getStoryStatusChangeStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "setStoryStatusChangeStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;)V", "storyUploadMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryUploadReportStruct;", "storyVideoPublish", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryComposeReportStruct;", "tag", "videoIdSet", "addPreviewTrace", "", "aid", "checkRepeatUser", "name", "checkRepeatVideo", "doCommentPageExposeReport", "storyId", "doEntranceClearReport", "delete", "doStoryChatTopBarEntranceExposeReport", "doStoryDoubleTapHeadViewReport", "doStoryDownloadReport", "doStoryEntranceReport", "doStoryImageVideoRemuxReport", "doStoryImageVideoZipReport", "doStoryPageReport", "doStoryPreviewReport", "doStoryProfileTabExposeReport", "doStorySinglePreviewReport", "doStoryStatusChangeReport", "doStoryUploadReport", "storyLocalId", "doStoryVideoPublishReport", "doVisiteReport", "visitorCount", "commentCount", "doVisitorPageExposeReport", "getLastStoryUploadReporter", "getStoryChatTopBarEntranceExposeReporter", "getStoryDoubleTapHeadViewReporter", "getStoryDownloadReporter", "getStoryEntranceReport", "getStoryImageVideoRemuxReporter", "getStoryImageVideoZipReporter", "getStoryPageExposeReporter", "getStoryPreviewReporter", "getStoryProfileTabExposeReport", "getStorySinglePreviewReporter", "getStoryVideoPublishReporter", "reportStoryStatusChange", "status", "previewEnterScene", "profileSource", "isAlbumStarButton", "resetStoryPreviewReporter", "resetStoryPreviewTraceData", "resetStoryProfileTabExposeReport", "storyUploadReportCPMediaInfo", "path", "storyUploadReportOriMediaInfo", "isCaptureVideo", "plugin-story_release"})
public final class h
{
  private static int BXD;
  private static long FuA;
  private static long FuB;
  private static long FuC;
  private static long FuD;
  private static int FuE;
  private static jj FuF;
  private static ju FuG;
  public static final h FuH;
  private static jn Fuk;
  private static jo Ful;
  private static a Fum;
  private static Set<String> Fun;
  private static Set<String> Fuo;
  private static boolean Fup;
  private static boolean Fuq;
  private static jd Fur;
  private static jg Fus;
  private static je Fut;
  private static jl Fuu;
  private static jm Fuv;
  private static jh Fuw;
  private static final HashMap<Integer, jv> Fux;
  private static jr Fuy;
  private static jp Fuz;
  
  static
  {
    AppMethodBeat.i(119464);
    FuH = new h();
    Fuk = new jn();
    BXD = -1;
    Ful = new jo();
    Fum = new a();
    Fun = Collections.synchronizedSet((Set)new HashSet());
    Fuo = Collections.synchronizedSet((Set)new HashSet());
    Fup = true;
    Fuq = true;
    Fur = new jd();
    Fus = new jg();
    Fut = new je();
    Fuu = new jl();
    Fuv = new jm();
    Fuw = new jh();
    Fux = new HashMap();
    Fuy = new jr();
    Fuz = new jp();
    FuF = new jj();
    FuG = new ju();
    AppMethodBeat.o(119464);
  }
  
  public static void Ks(long paramLong)
  {
    FuA = paramLong;
  }
  
  public static void Kt(long paramLong)
  {
    FuB = paramLong;
  }
  
  public static void Ku(long paramLong)
  {
    FuC = paramLong;
  }
  
  public static void Kv(long paramLong)
  {
    FuD = paramLong;
  }
  
  public static void a(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(119460);
    p.h(paramString, "storyId");
    FuG.xf(paramString);
    FuG.sS(paramLong1);
    FuG.sV(paramLong4);
    FuG.sT(paramLong2);
    FuG.sU(paramLong3);
    FuG.bfK();
    FuG = new ju();
    AppMethodBeat.o(119460);
  }
  
  public static void aC(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119462);
    p.h(paramString, "storyId");
    jk localjk = new jk();
    localjk.wQ(paramString);
    localjk.se(paramInt1);
    localjk.sf(paramInt2);
    localjk.bfK();
    AppMethodBeat.o(119462);
  }
  
  public static boolean aSm(String paramString)
  {
    AppMethodBeat.i(119441);
    if (paramString == null)
    {
      AppMethodBeat.o(119441);
      return true;
    }
    if (Fun.contains(paramString))
    {
      AppMethodBeat.o(119441);
      return true;
    }
    Fun.add(paramString);
    AppMethodBeat.o(119441);
    return false;
  }
  
  public static boolean aSn(String paramString)
  {
    AppMethodBeat.i(119442);
    if (paramString == null)
    {
      AppMethodBeat.o(119442);
      return true;
    }
    if (Fuo.contains(paramString))
    {
      AppMethodBeat.o(119442);
      return true;
    }
    Fuo.add(paramString);
    AppMethodBeat.o(119442);
    return false;
  }
  
  public static void aSo(String paramString)
  {
    AppMethodBeat.i(119448);
    p.h(paramString, "storyId");
    if (Fup)
    {
      Fuk.sj(8L);
      Fuk.wR(paramString);
      fqn();
    }
    AppMethodBeat.o(119448);
  }
  
  public static void aSp(String paramString)
  {
    AppMethodBeat.i(119449);
    p.h(paramString, "storyId");
    if (Fuq)
    {
      Fuk.sj(5L);
      Fuk.wR(paramString);
      fqn();
    }
    AppMethodBeat.o(119449);
  }
  
  public static void aaT(int paramInt)
  {
    AppMethodBeat.i(119443);
    if ((BXD == -1) && (paramInt == 4))
    {
      BXD = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    if ((BXD == 10) && (paramInt == 11))
    {
      BXD = paramInt;
      AppMethodBeat.o(119443);
      return;
    }
    BXD = paramInt;
    a locala = Fum;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("aid", paramInt);
    localJSONObject.put("td", locala.BXw.length() + 1);
    if (locala.BXw.toString().length() + localJSONObject.toString().length() > 1000) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0) {}
      synchronized (locala.lock)
      {
        locala.BXw.put(localJSONObject);
        AppMethodBeat.o(119443);
        return;
        paramInt = 1;
      }
    }
  }
  
  public static jv aaU(int paramInt)
  {
    AppMethodBeat.i(119455);
    jv localjv2 = (jv)Fux.get(Integer.valueOf(paramInt));
    jv localjv1 = localjv2;
    if (localjv2 == null)
    {
      localjv1 = new jv();
      ((Map)Fux).put(Integer.valueOf(paramInt), localjv1);
    }
    AppMethodBeat.o(119455);
    return localjv1;
  }
  
  public static void aaV(int paramInt)
  {
    AppMethodBeat.i(119456);
    jv localjv = (jv)Fux.get(Integer.valueOf(paramInt));
    if (localjv != null)
    {
      Log.d("MicroMsg.StoryReporter", "basic:\n" + localjv.aim() + ' ' + localjv.ahW() + ' ' + localjv.ahX() + ' ' + localjv.aik() + ' ' + localjv.ahV() + ' ' + localjv.ahT() + ' ' + localjv.ahU());
      Log.d("MicroMsg.StoryReporter", "origin:\n" + localjv.aia() + ' ' + localjv.ahY() + ' ' + localjv.ail() + ' ' + localjv.aid() + ' ' + localjv.aic() + ' ' + localjv.aib() + ' ' + localjv.ahZ());
      Log.d("MicroMsg.StoryReporter", "cp:\n" + localjv.aig() + ' ' + localjv.aie() + ' ' + localjv.aij() + ' ' + localjv.aii() + ' ' + localjv.aih() + ' ' + localjv.aif());
      localjv.bfK();
      Fux.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(119456);
  }
  
  public static void aaW(int paramInt)
  {
    FuE = paramInt;
  }
  
  public static long fqA()
  {
    return FuD;
  }
  
  public static jp fqB()
  {
    return Fuz;
  }
  
  public static void fqC()
  {
    AppMethodBeat.i(119458);
    if (Fuz.ahK() != 0L)
    {
      Fuz.bfK();
      Fuz.ahJ();
      Fuz.ahH();
      Fuz.ahG();
      Fuz.ahI();
      Fuz.sy(FuA);
      Fuz.sz(FuB);
      Fuz.sA(FuC);
    }
    AppMethodBeat.o(119458);
  }
  
  public static int fqD()
  {
    return FuE;
  }
  
  public static jj fqE()
  {
    return FuF;
  }
  
  public static void fqF()
  {
    AppMethodBeat.i(119459);
    FuF.bfK();
    FuF = new jj();
    AppMethodBeat.o(119459);
  }
  
  public static void fqh()
  {
    BXD = 1;
  }
  
  public static jo fqi()
  {
    return Ful;
  }
  
  public static void fqj()
  {
    AppMethodBeat.i(119444);
    if (0L == Ful.ahB())
    {
      fql();
      AppMethodBeat.o(119444);
      return;
    }
    Ful.wT(Fum.eKV());
    jo localjo = Ful;
    localjo.sv(localjo.ahF() + Ful.ahD());
    Ful.bfK();
    Ful.sp(0L);
    Ful.st(0L);
    Ful.ss(0L);
    Ful.sq(0L);
    Ful.su(0L);
    Ful.sm(0L);
    Ful.sv(0L);
    Ful.sx(0L);
    Ful.wU("");
    fql();
    AppMethodBeat.o(119444);
  }
  
  public static void fqk()
  {
    AppMethodBeat.i(119445);
    Ful = new jo();
    fql();
    AppMethodBeat.o(119445);
  }
  
  public static void fql()
  {
    AppMethodBeat.i(119446);
    Fum = new a();
    BXD = -1;
    Fun.clear();
    Fuo.clear();
    AppMethodBeat.o(119446);
  }
  
  public static jn fqm()
  {
    return Fuk;
  }
  
  public static void fqn()
  {
    AppMethodBeat.i(119447);
    Fuk.bfK();
    Fuk = new jn();
    AppMethodBeat.o(119447);
  }
  
  public static jd fqo()
  {
    return Fur;
  }
  
  public static void fqp()
  {
    AppMethodBeat.i(119450);
    if (TextUtils.isEmpty((CharSequence)Fur.getUserName()))
    {
      AppMethodBeat.o(119450);
      return;
    }
    Fur.bfK();
    AppMethodBeat.o(119450);
  }
  
  public static jg fqq()
  {
    return Fus;
  }
  
  public static void fqr()
  {
    AppMethodBeat.i(119451);
    Fus.bfK();
    AppMethodBeat.o(119451);
  }
  
  public static je fqs()
  {
    return Fut;
  }
  
  public static void fqt()
  {
    AppMethodBeat.i(119452);
    Fut.bfK();
    Fut = new je();
    AppMethodBeat.o(119452);
  }
  
  public static jm fqu()
  {
    return Fuv;
  }
  
  public static void fqv()
  {
    AppMethodBeat.i(119453);
    Fuv.bfK();
    Fuv = new jm();
    AppMethodBeat.o(119453);
  }
  
  public static jh fqw()
  {
    return Fuw;
  }
  
  public static void fqx()
  {
    AppMethodBeat.i(119454);
    Fuw.bfK();
    Fuw = new jh();
    AppMethodBeat.o(119454);
  }
  
  public static jr fqy()
  {
    return Fuy;
  }
  
  public static void fqz()
  {
    AppMethodBeat.i(119457);
    if (Fuy.ahy() == 0L)
    {
      Fuy = new jr();
      AppMethodBeat.o(119457);
      return;
    }
    Fuy.bfK();
    Fuy = new jr();
    AppMethodBeat.o(119457);
  }
  
  public static void vU(boolean paramBoolean)
  {
    Fup = paramBoolean;
  }
  
  public static void vV(boolean paramBoolean)
  {
    Fuq = paramBoolean;
  }
  
  public static void vW(boolean paramBoolean)
  {
    long l = 1L;
    AppMethodBeat.i(119463);
    ji localji = new ji();
    localji.sa(1L);
    if (paramBoolean) {}
    for (;;)
    {
      localji.sc(l);
      localji.bfK();
      AppMethodBeat.o(119463);
      return;
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.h
 * JD-Core Version:    0.7.0.1
 */