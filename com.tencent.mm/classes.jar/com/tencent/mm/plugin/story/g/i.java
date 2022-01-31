package com.tencent.mm.plugin.story.g;

import a.f.b.j;
import a.l;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.b.a.aq;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.g.b.a.at;
import com.tencent.mm.g.b.a.au;
import com.tencent.mm.g.b.a.aw;
import com.tencent.mm.g.b.a.ax;
import com.tencent.mm.g.b.a.ay;
import com.tencent.mm.g.b.a.az;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.g.b.a.bb;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.g.b.a.bd;
import com.tencent.mm.g.b.a.bg;
import com.tencent.mm.g.b.a.bh;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.story.h.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/report/StoryReporter;", "", "()V", "cameraDot", "", "getCameraDot", "()J", "setCameraDot", "(J)V", "currentEntranceExposeTime", "", "getCurrentEntranceExposeTime", "()I", "setCurrentEntranceExposeTime", "(I)V", "currentProfileTabVideoObjectId", "getCurrentProfileTabVideoObjectId", "setCurrentProfileTabVideoObjectId", "lastTrace", "getLastTrace", "setLastTrace", "moreTabDot", "getMoreTabDot", "setMoreTabDot", "nameSet", "", "", "kotlin.jvm.PlatformType", "", "storyChatTopBarEntranceExpose", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryChatTopBarEntranceExposeStruct;", "storyCommentDot", "getStoryCommentDot", "setStoryCommentDot", "storyDoPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoPublishStruct;", "storyDoubleTapHeadView", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoubleTapHeadViewStruct;", "storyDownloadReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDownloadReportStruct;", "storyEntranceExposeReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeReportStruct;", "storyFailTraceStruct", "Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "storyImageVideoRemux", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoRemuxStruct;", "storyImageVideoZip", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoZipStruct;", "storyPageExposeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPageExposeStruct;", "storyPreviewReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPreviewReportStruct;", "storyPreviewTraceStruct", "storyProfileTabExposeReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryProfileTabExposeStruct;", "storyQuitPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryQuitPublishStruct;", "storySinglePreviewReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StorySinglePreviewReportStruct;", "storyStatusChangeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "getStoryStatusChangeStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "setStoryStatusChangeStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;)V", "storyTraceStruct", "storyUploadMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryUploadReportStruct;", "storyVideoPublish", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryComposeReportStruct;", "tag", "videoIdSet", "addPreviewTrace", "", "aid", "addTrace", "checkRepeatUser", "", "name", "checkRepeatVideo", "doBehaviorReport", "doFailBehaviorReport", "doStoryChatTopBarEntranceExposeReport", "doStoryDoubleTapHeadViewReport", "doStoryDownloadReport", "doStoryEntranceReport", "doStoryImageVideoRemuxReport", "doStoryImageVideoZipReport", "doStoryPageReport", "doStoryPreviewReport", "doStoryProfileTabExposeReport", "doStorySinglePreviewReport", "doStoryStatusChangeReport", "doStoryUploadReport", "storyLocalId", "doStoryVideoPublishReport", "getBehaviorReporter", "getFailBehaviorReporter", "getLastStoryUploadReporter", "getStoryChatTopBarEntranceExposeReporter", "getStoryDoubleTapHeadViewReporter", "getStoryDownloadReporter", "getStoryEntranceReport", "getStoryImageVideoRemuxReporter", "getStoryImageVideoZipReporter", "getStoryPageExposeReporter", "getStoryPreviewReporter", "getStoryProfileTabExposeReport", "getStorySinglePreviewReporter", "getStoryVideoPublishReporter", "reportStoryStatusChange", "status", "storyId", "previewEnterScene", "profileSource", "isAlbumStarButton", "resetBehaviorReporter", "resetFailBehaviorReporter", "resetStoryPreviewReporter", "resetStoryPreviewTraceData", "resetStoryProfileTabExposeReport", "storyUploadReportCPMediaInfo", "path", "storyUploadReportOriMediaInfo", "isCaptureVideo", "plugin-story_release"})
public final class i
{
  private static as sEA;
  private static a sEB;
  private static az sEC;
  private static bc sED;
  private static a sEE;
  private static int sEF;
  private static ba sEG;
  private static a sEH;
  private static Set<String> sEI;
  private static Set<String> sEJ;
  private static aq sEK;
  private static at sEL;
  private static ar sEM;
  private static ax sEN;
  private static ay sEO;
  private static au sEP;
  private static final HashMap<Integer, bh> sEQ;
  private static bd sER;
  private static bb sES;
  private static long sET;
  private static long sEU;
  private static long sEV;
  private static long sEW;
  private static int sEX;
  private static aw sEY;
  private static bg sEZ;
  public static final i sFa;
  
  static
  {
    AppMethodBeat.i(109847);
    sFa = new i();
    sEA = new as();
    sEB = new a();
    sEC = new az();
    sED = new bc();
    sEE = new a();
    sEF = -1;
    sEG = new ba();
    sEH = new a();
    sEI = Collections.synchronizedSet((Set)new HashSet());
    sEJ = Collections.synchronizedSet((Set)new HashSet());
    sEK = new aq();
    sEL = new at();
    sEM = new ar();
    sEN = new ax();
    sEO = new ay();
    sEP = new au();
    sEQ = new HashMap();
    sER = new bd();
    sES = new bb();
    sEY = new aw();
    sEZ = new bg();
    AppMethodBeat.o(109847);
  }
  
  public static void FR(int paramInt)
  {
    AppMethodBeat.i(109824);
    if ((paramInt == 15) && ((sEF == 4) || (sEF == 10)))
    {
      sEF = paramInt;
      AppMethodBeat.o(109824);
      return;
    }
    sEF = paramInt;
    sEB.FR(paramInt);
    sEE.FR(paramInt);
    AppMethodBeat.o(109824);
  }
  
  public static void FU(int paramInt)
  {
    AppMethodBeat.i(109831);
    if ((sEF == -1) && (paramInt == 4))
    {
      sEF = paramInt;
      AppMethodBeat.o(109831);
      return;
    }
    if ((sEF == 10) && (paramInt == 11))
    {
      sEF = paramInt;
      AppMethodBeat.o(109831);
      return;
    }
    sEF = paramInt;
    sEH.FR(paramInt);
    AppMethodBeat.o(109831);
  }
  
  public static bh FV(int paramInt)
  {
    AppMethodBeat.i(109840);
    bh localbh2 = (bh)sEQ.get(Integer.valueOf(paramInt));
    bh localbh1 = localbh2;
    if (localbh2 == null)
    {
      localbh1 = new bh();
      ((Map)sEQ).put(Integer.valueOf(paramInt), localbh1);
    }
    AppMethodBeat.o(109840);
    return localbh1;
  }
  
  public static void FW(int paramInt)
  {
    AppMethodBeat.i(109843);
    bh localbh = (bh)sEQ.get(Integer.valueOf(paramInt));
    if (localbh != null)
    {
      ab.d("MicroMsg.StoryReporter", "basic:\n" + localbh.Gv() + ' ' + localbh.Gf() + ' ' + localbh.Gg() + ' ' + localbh.Gt() + ' ' + localbh.Ge() + ' ' + localbh.Gc() + ' ' + localbh.Gd());
      ab.d("MicroMsg.StoryReporter", "origin:\n" + localbh.Gj() + ' ' + localbh.Gh() + ' ' + localbh.Gu() + ' ' + localbh.Gm() + ' ' + localbh.Gl() + ' ' + localbh.Gk() + ' ' + localbh.Gi());
      ab.d("MicroMsg.StoryReporter", "cp:\n" + localbh.Gp() + ' ' + localbh.Gn() + ' ' + localbh.Gs() + ' ' + localbh.Gr() + ' ' + localbh.Gq() + ' ' + localbh.Go());
      localbh.ake();
      sEQ.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(109843);
  }
  
  public static void FX(int paramInt)
  {
    sEX = paramInt;
  }
  
  public static void a(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(138837);
    j.q(paramString, "storyId");
    sEZ.gA(paramString);
    sEZ.dl(paramLong1);
    sEZ.jdMethod_do(paramLong4);
    sEZ.dm(paramLong2);
    sEZ.dn(paramLong3);
    sEZ.ake();
    sEZ = new bg();
    AppMethodBeat.o(138837);
  }
  
  public static boolean adu(String paramString)
  {
    AppMethodBeat.i(109829);
    if (paramString == null)
    {
      AppMethodBeat.o(109829);
      return true;
    }
    if (sEI.contains(paramString))
    {
      AppMethodBeat.o(109829);
      return true;
    }
    sEI.add(paramString);
    AppMethodBeat.o(109829);
    return false;
  }
  
  public static boolean adv(String paramString)
  {
    AppMethodBeat.i(109830);
    if (paramString == null)
    {
      AppMethodBeat.o(109830);
      return true;
    }
    if (sEJ.contains(paramString))
    {
      AppMethodBeat.o(109830);
      return true;
    }
    sEJ.add(paramString);
    AppMethodBeat.o(109830);
    return false;
  }
  
  public static void bl(int paramInt, String paramString)
  {
    AppMethodBeat.i(109842);
    j.q(paramString, "path");
    com.tencent.mm.plugin.sight.base.a locala = d.Zo(paramString);
    FV(paramInt).dy(e.avI(paramString));
    FV(paramInt).gC(g.getMD5(paramString));
    if (locala != null)
    {
      FV(paramInt);
      FV(paramInt).dE(locala.height);
      FV(paramInt).dD(locala.width);
      FV(paramInt).dA(locala.videoBitrate);
      FV(paramInt).dB(locala.fzT);
      FV(paramInt).dz(locala.eVA);
      FV(paramInt).dC(locala.eRw);
      AppMethodBeat.o(109842);
      return;
    }
    AppMethodBeat.o(109842);
  }
  
  public static ax cDA()
  {
    return sEN;
  }
  
  public static void cDB()
  {
    AppMethodBeat.i(155320);
    sEN.ake();
    sEN = new ax();
    AppMethodBeat.o(155320);
  }
  
  public static ay cDC()
  {
    return sEO;
  }
  
  public static void cDD()
  {
    AppMethodBeat.i(155321);
    sEO.ake();
    sEO = new ay();
    AppMethodBeat.o(155321);
  }
  
  public static au cDE()
  {
    return sEP;
  }
  
  public static void cDF()
  {
    AppMethodBeat.i(109839);
    sEP.ake();
    sEP = new au();
    AppMethodBeat.o(109839);
  }
  
  public static bd cDG()
  {
    return sER;
  }
  
  public static void cDH()
  {
    AppMethodBeat.i(109844);
    if (sER.FH() == 0L)
    {
      sER = new bd();
      AppMethodBeat.o(109844);
      return;
    }
    sER.ake();
    sER = new bd();
    AppMethodBeat.o(109844);
  }
  
  public static long cDI()
  {
    return sEW;
  }
  
  public static bb cDJ()
  {
    return sES;
  }
  
  public static void cDK()
  {
    AppMethodBeat.i(109845);
    if (sES.FT() != 0L)
    {
      sES.ake();
      sES.FS();
      sES.FQ();
      sES.FP();
      sES.FR();
      sES.cR(sET);
      sES.cS(sEU);
      sES.cT(sEV);
    }
    AppMethodBeat.o(109845);
  }
  
  public static int cDL()
  {
    return sEX;
  }
  
  public static aw cDM()
  {
    return sEY;
  }
  
  public static void cDN()
  {
    AppMethodBeat.i(109846);
    sEY.ake();
    sEY = new aw();
    AppMethodBeat.o(109846);
  }
  
  public static void cDh()
  {
    sEF = 1;
  }
  
  public static as cDi()
  {
    return sEA;
  }
  
  public static void cDj()
  {
    AppMethodBeat.i(109825);
    sEA.gd(sEB.cgA());
    sEA.ake();
    cDk();
    sEF = -1;
    AppMethodBeat.o(109825);
  }
  
  public static void cDk()
  {
    AppMethodBeat.i(109826);
    sEA = new as();
    sEB = new a();
    AppMethodBeat.o(109826);
  }
  
  public static void cDl()
  {
    AppMethodBeat.i(109827);
    sED = new bc();
    sEE = new a();
    AppMethodBeat.o(109827);
  }
  
  public static bc cDm()
  {
    return sED;
  }
  
  public static void cDn()
  {
    AppMethodBeat.i(109828);
    sED.cX(System.currentTimeMillis());
    sED.gr(sEE.cgA());
    sED.ake();
    sED = new bc();
    sEE = new a();
    AppMethodBeat.o(109828);
  }
  
  public static ba cDo()
  {
    return sEG;
  }
  
  public static void cDp()
  {
    AppMethodBeat.i(109832);
    if (0L == sEG.FK())
    {
      cDr();
      AppMethodBeat.o(109832);
      return;
    }
    sEG.go(sEH.cgA());
    ba localba = sEG;
    localba.cO(localba.FO() + sEG.FM());
    sEG.ake();
    sEG.cI(0L);
    sEG.cM(0L);
    sEG.cL(0L);
    sEG.cJ(0L);
    sEG.cN(0L);
    sEG.cF(0L);
    sEG.cO(0L);
    sEG.cQ(0L);
    sEG.gp("");
    cDr();
    AppMethodBeat.o(109832);
  }
  
  public static void cDq()
  {
    AppMethodBeat.i(109833);
    sEG = new ba();
    cDr();
    AppMethodBeat.o(109833);
  }
  
  public static void cDr()
  {
    AppMethodBeat.i(109834);
    sEH = new a();
    sEF = -1;
    sEI.clear();
    sEJ.clear();
    AppMethodBeat.o(109834);
  }
  
  public static az cDs()
  {
    return sEC;
  }
  
  public static void cDt()
  {
    AppMethodBeat.i(109835);
    sEC.ake();
    sEC = new az();
    AppMethodBeat.o(109835);
  }
  
  public static aq cDu()
  {
    return sEK;
  }
  
  public static void cDv()
  {
    AppMethodBeat.i(109836);
    if (TextUtils.isEmpty((CharSequence)sEK.getUserName()))
    {
      AppMethodBeat.o(109836);
      return;
    }
    sEK.ake();
    AppMethodBeat.o(109836);
  }
  
  public static at cDw()
  {
    return sEL;
  }
  
  public static void cDx()
  {
    AppMethodBeat.i(109837);
    sEL.ake();
    AppMethodBeat.o(109837);
  }
  
  public static ar cDy()
  {
    return sEM;
  }
  
  public static void cDz()
  {
    AppMethodBeat.i(109838);
    sEM.ake();
    sEM = new ar();
    AppMethodBeat.o(109838);
  }
  
  public static void g(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109841);
    j.q(paramString, "path");
    com.tencent.mm.plugin.sight.base.a locala = d.Zo(paramString);
    FV(paramInt).dr(e.avI(paramString));
    paramString = FV(paramInt);
    a.a locala1;
    if (paramBoolean) {
      locala1 = com.tencent.mm.plugin.story.h.a.sFV;
    }
    for (long l = com.tencent.mm.plugin.story.h.a.cEo();; l = com.tencent.mm.plugin.story.h.a.cEn())
    {
      paramString.dF(l);
      if (locala == null) {
        break;
      }
      FV(paramInt).dw(locala.width);
      FV(paramInt).dx(locala.height);
      FV(paramInt).dt(locala.videoBitrate);
      FV(paramInt).du(locala.fzT);
      FV(paramInt).ds(locala.eVA);
      FV(paramInt).dv(locala.eRw);
      FV(paramInt).dG(locala.qSh);
      AppMethodBeat.o(109841);
      return;
      locala1 = com.tencent.mm.plugin.story.h.a.sFV;
    }
    AppMethodBeat.o(109841);
  }
  
  public static void mM(long paramLong)
  {
    sET = paramLong;
  }
  
  public static void mN(long paramLong)
  {
    sEV = paramLong;
  }
  
  public static void mO(long paramLong)
  {
    sEW = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.i
 * JD-Core Version:    0.7.0.1
 */