package com.tencent.mm.plugin.websearch.api;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.fm;
import com.tencent.mm.f.b.a.fr;
import com.tencent.mm.f.b.a.qm;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.ess;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class ar
{
  private static a PzJ;
  
  static
  {
    AppMethodBeat.i(117790);
    PzJ = new a();
    AppMethodBeat.o(117790);
  }
  
  public static void M(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(117775);
    b(paramInt1, paramInt2, paramString, "", "");
    AppMethodBeat.o(117775);
  }
  
  public static void N(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(117783);
    a(paramInt1, paramInt2, 0, 0, paramString);
    AppMethodBeat.o(117783);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(117785);
    if (paramInt1 == 21) {}
    for (int i = ai.anh(1);; i = ai.anh(0))
    {
      com.tencent.mm.plugin.report.f.Iyx.a(14457, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
      AppMethodBeat.o(117785);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    AppMethodBeat.i(117773);
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    com.tencent.mm.plugin.report.f.Iyx.a(12098, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(ai.anh(0)), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    AppMethodBeat.o(117773);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(117788);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("recnondocreport=1");
    localStringBuffer.append("&type=51");
    localStringBuffer.append("&content=");
    paramString1 = localStringBuffer.append(paramInt1).append("|").append(paramInt2).append("|").append(Util.nullAsNil(paramString1)).append("|");
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.append(paramInt1);
      localStringBuffer.append("&searchid=");
      localStringBuffer.append(Util.nullAsNil(paramString2));
      Log.i("MicroMsg.TopStory", "reportTopStoryRedDot 14791 %s", new Object[] { localStringBuffer.toString() });
      paramString1 = new dxu();
      paramString1.Udk = localStringBuffer.toString();
      paramString1 = new ad(paramString1);
      com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
      AppMethodBeat.o(117788);
      return;
    }
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, long paramLong1, long paramLong2, int paramInt5, String paramString6, String paramString7, int paramInt6)
  {
    AppMethodBeat.i(211646);
    fm localfm = new fm();
    localfm.gef = paramInt1;
    localfm.git = localfm.z("RequestId", paramString1, true);
    localfm.gnP = paramInt2;
    localfm.gAK = paramInt3;
    localfm.gAL = localfm.z("HitWordList", paramString2, true);
    localfm.gAM = localfm.z("HitWordVersion", paramString3, true);
    localfm.giv = localfm.z("MsgId", paramString4, true);
    localfm.giw = localfm.z("MsgFromUsername", "", true);
    localfm.gAN = paramInt4;
    localfm.giy = localfm.z("ChatRoomID", paramString5, true);
    localfm.gdk = paramLong1;
    localfm.gAO = paramLong2;
    localfm.gAP = paramInt5;
    localfm.gAQ = localfm.z("ShowHitWord", paramString6, true);
    localfm.gAR = localfm.z("MatchTypeList", paramString7, true);
    localfm.gAS = paramInt6;
    localfm.bpa();
    a(localfm);
    AppMethodBeat.o(211646);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(117779);
    com.tencent.mm.plugin.report.f.Iyx.a(13810, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(117779);
  }
  
  public static void a(int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    AppMethodBeat.i(117766);
    int i;
    if (paramBoolean1) {
      i = 3;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.f.Iyx.a(12042, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(paramInt2), Util.nullAs(paramString, "").replace(",", " ") });
      AppMethodBeat.o(117766);
      return;
      if (paramBoolean2) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(211650);
    Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "report%s %s", new Object[] { Integer.valueOf(parama.getId()), parama.agI().replace("\r\n", " ") });
    AppMethodBeat.o(211650);
  }
  
  public static void a(ess paramess, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString)
  {
    AppMethodBeat.i(117787);
    ess localess = paramess;
    if (paramess == null)
    {
      localess = new ess();
      localess.msgId = "";
      localess.Uuu = 0L;
    }
    paramess = new StringBuffer();
    paramess.append("reddotreport=1");
    paramess.append("&reddotid=");
    paramess.append(Util.nullAsNil(localess.msgId));
    paramess.append("&reddotts=");
    paramess.append(localess.Uuu);
    paramess.append("&nettype=");
    paramess.append(ai.anV());
    paramess.append("&optype=");
    paramess.append(paramInt1);
    paramess.append("&reddottype=");
    paramess.append(paramInt2);
    paramess.append("&reddotcnt=");
    paramess.append(paramInt3);
    paramess.append("&reddotconsumets=");
    paramess.append(paramLong);
    paramess.append("&notshowreason=");
    paramess.append(paramString);
    paramess.append("&reddotseq=");
    paramess.append(localess.mbp);
    if ((paramInt1 == 100) || (paramInt1 == 101) || (paramInt1 == 102) || (paramInt1 == 108)) {
      if (Util.isNullOrNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(68377, null))) {
        break label369;
      }
    }
    label369:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (p.JPe != null) {}
      for (paramInt2 = p.JPe.cHo();; paramInt2 = 0)
      {
        if (paramInt2 > 0) {
          paramess.append("&snsreddottype=2&snsreddotcnt=").append(paramInt2);
        }
        for (;;)
        {
          Log.i("MicroMsg.TopStory", "reportTopStoryRedDot 16399 %s", new Object[] { paramess.toString() });
          paramString = new dxu();
          paramString.Udk = paramess.toString();
          paramess = new ad(paramString);
          com.tencent.mm.kernel.h.aGY().a(paramess, 0);
          AppMethodBeat.o(117787);
          return;
          if (paramInt1 > 0) {
            paramess.append("&snsreddottype=1&snsreddotcnt=0");
          } else {
            paramess.append("&snsreddottype=0&snsreddotcnt=0");
          }
        }
      }
    }
  }
  
  public static void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    AppMethodBeat.i(117789);
    if (!Util.isNullOrNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(68377, null))) {}
    for (int j = 1;; j = 0)
    {
      if (p.JPe != null) {}
      for (int i = p.JPe.cHo();; i = 0)
      {
        if (i > 0) {
          j = 2;
        }
        for (;;)
        {
          paramString1 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramString1, Long.valueOf(paramLong), ai.anV(), Integer.valueOf(201), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(0L), paramString2, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt3) });
          Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "reportTopStoryRedDotKv 16654: ".concat(String.valueOf(paramString1)));
          com.tencent.mm.plugin.report.f.Iyx.kvStat(16654, paramString1);
          AppMethodBeat.o(117789);
          return;
          if (j > 0)
          {
            i = 0;
            j = 1;
          }
          else
          {
            i = 0;
            j = 0;
          }
        }
      }
    }
  }
  
  public static void aO(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117784);
    a(paramInt1, 3, paramInt2, paramInt3, "");
    AppMethodBeat.o(117784);
  }
  
  public static void ann(int paramInt)
  {
    AppMethodBeat.i(117767);
    PzJ.scene = paramInt;
    PzJ.Pyz = 1;
    PzJ.PzK = System.currentTimeMillis();
    PzJ.PzL = 0L;
    PzJ.Fsc = System.currentTimeMillis();
    PzJ.fmH = 0L;
    PzJ.Aaj = false;
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "initReport %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    AppMethodBeat.o(117767);
  }
  
  public static void ano(int paramInt)
  {
    AppMethodBeat.i(117772);
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchVisit %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.f.Iyx.a(12041, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ai.anh(0)) });
    AppMethodBeat.o(117772);
  }
  
  public static final void anp(int paramInt)
  {
    AppMethodBeat.i(117780);
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportIdKey649 %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(649L, paramInt, 1L, true);
    AppMethodBeat.o(117780);
  }
  
  public static void anq(int paramInt)
  {
    AppMethodBeat.i(211649);
    com.tencent.e.h.ZvG.d(new ar.1(paramInt), "WebSearchThread");
    AppMethodBeat.o(211649);
  }
  
  public static void b(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(211636);
    Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportGlobalTabClick type:%s, scene:%s, searchId:%s, isTabGuide:%s,sessionId:%s, redDotMsgId:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Boolean.FALSE, paramString2, paramString3 });
    com.tencent.mm.plugin.report.f.Iyx.a(12845, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(0), paramString2, paramString3 });
    AppMethodBeat.o(211636);
  }
  
  public static void cN(int paramInt, String paramString)
  {
    AppMethodBeat.i(117765);
    com.tencent.mm.plugin.report.f.Iyx.kvStat(paramInt, paramString);
    AppMethodBeat.o(117765);
  }
  
  public static void cO(int paramInt, String paramString)
  {
    AppMethodBeat.i(117777);
    com.tencent.mm.plugin.report.f.Iyx.a(12070, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ai.anh(0)), paramString, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0) });
    AppMethodBeat.o(117777);
  }
  
  public static void gQX()
  {
    AppMethodBeat.i(117768);
    PzJ.PzK = System.currentTimeMillis();
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "startH5Report %s", new Object[] { Long.valueOf(PzJ.PzK) });
    AppMethodBeat.o(117768);
  }
  
  public static void gQY()
  {
    AppMethodBeat.i(117769);
    a locala = PzJ;
    locala.PzL += System.currentTimeMillis() - PzJ.PzK;
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopH5Report %s", new Object[] { Long.valueOf(PzJ.PzL) });
    AppMethodBeat.o(117769);
  }
  
  public static void gQZ()
  {
    AppMethodBeat.i(117770);
    a locala = PzJ;
    locala.fmH += System.currentTimeMillis() - PzJ.Fsc;
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopTotalReport %s", new Object[] { Long.valueOf(PzJ.fmH) });
    AppMethodBeat.o(117770);
  }
  
  public static void gRa()
  {
    AppMethodBeat.i(117771);
    a locala = PzJ;
    if (!locala.Aaj)
    {
      com.tencent.mm.plugin.report.f.Iyx.a(12044, new Object[] { Integer.valueOf(locala.scene), Integer.valueOf(locala.Pyz), Long.valueOf(locala.PzL / 1000L), Long.valueOf(locala.fmH / 1000L) });
      locala.Aaj = true;
    }
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportTime");
    AppMethodBeat.o(117771);
  }
  
  public static void h(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(117778);
    com.tencent.mm.plugin.report.f.Iyx.a(13809, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(0), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(117778);
  }
  
  public static final void lr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117781);
    if (paramInt1 == 21) {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(649L, paramInt2, 1L, true);
    }
    AppMethodBeat.o(117781);
  }
  
  public static void ls(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117782);
    N(paramInt1, paramInt2, "");
    AppMethodBeat.o(117782);
  }
  
  public static void mj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(211637);
    Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportFTSExpose sessionId:%s, exposeInfo:%s", new Object[] { paramString1, paramString2 });
    com.tencent.mm.plugin.report.f.Iyx.a(22369, new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(211637);
  }
  
  public static void q(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(211647);
    qm localqm = new qm();
    localqm.hjS = paramLong1;
    localqm.gdk = paramLong2;
    localqm.goe = paramLong3;
    localqm.bpa();
    a(localqm);
    AppMethodBeat.o(211647);
  }
  
  public static void u(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117774);
    fr localfr = new fr();
    localfr.glM = localfr.z("Query", paramString.replace(',', ' '), true);
    localfr.gBF = paramInt1;
    localfr.goP = paramInt2;
    localfr.gnP = paramInt3;
    localfr.gBG = 0L;
    localfr.bpa();
    Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "report12639 %s", new Object[] { localfr.agI().replace("\r\n", " ") });
    AppMethodBeat.o(117774);
  }
  
  public static final class a
  {
    boolean Aaj = true;
    long Fsc;
    int Pyz;
    long PzK;
    long PzL;
    long fmH;
    int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ar
 * JD-Core Version:    0.7.0.1
 */