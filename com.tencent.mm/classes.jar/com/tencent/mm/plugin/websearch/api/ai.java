package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.bp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class ai
{
  private static a BZD;
  
  static
  {
    AppMethodBeat.i(117790);
    BZD = new a();
    AppMethodBeat.o(117790);
  }
  
  public static void J(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(117775);
    d(paramInt1, paramInt2, paramString, false);
    AppMethodBeat.o(117775);
  }
  
  public static void K(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(117783);
    a(paramInt1, paramInt2, 0, 0, paramString);
    AppMethodBeat.o(117783);
  }
  
  public static void Ur(int paramInt)
  {
    AppMethodBeat.i(117767);
    BZD.scene = paramInt;
    BZD.BYF = 1;
    BZD.BZE = System.currentTimeMillis();
    BZD.BZF = 0L;
    BZD.uXo = System.currentTimeMillis();
    BZD.cQQ = 0L;
    BZD.rAJ = false;
    ac.v("MicroMsg.WebSearch.WebSearchReportLogic", "initReport %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    AppMethodBeat.o(117767);
  }
  
  public static void Us(int paramInt)
  {
    AppMethodBeat.i(117772);
    ac.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchVisit %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.wTc.f(12041, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(z.Ul(0)) });
    AppMethodBeat.o(117772);
  }
  
  public static final void Ut(int paramInt)
  {
    AppMethodBeat.i(117780);
    ac.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportIdKey649 %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(649L, paramInt, 1L, true);
    AppMethodBeat.o(117780);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(117785);
    if (paramInt1 == 21) {}
    for (int i = z.Ul(1);; i = z.Ul(0))
    {
      com.tencent.mm.plugin.report.e.wTc.f(14457, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
      AppMethodBeat.o(117785);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    AppMethodBeat.i(117773);
    ac.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    com.tencent.mm.plugin.report.e.wTc.f(12098, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(z.Ul(0)), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    AppMethodBeat.o(117773);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(117779);
    com.tencent.mm.plugin.report.e.wTc.f(13810, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(paramInt4) });
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
      com.tencent.mm.plugin.report.e.wTc.f(12042, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(paramInt2), bs.bG(paramString, "").replace(",", " ") });
      AppMethodBeat.o(117766);
      return;
      if (paramBoolean2) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  public static void a(dii paramdii, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString)
  {
    AppMethodBeat.i(117787);
    dii localdii = paramdii;
    if (paramdii == null)
    {
      localdii = new dii();
      localdii.dtG = "";
      localdii.FRm = 0L;
    }
    paramdii = new StringBuffer();
    paramdii.append("reddotreport=1");
    paramdii.append("&reddotid=");
    paramdii.append(bs.nullAsNil(localdii.dtG));
    paramdii.append("&reddotts=");
    paramdii.append(localdii.FRm);
    paramdii.append("&nettype=");
    paramdii.append(z.dkv());
    paramdii.append("&optype=");
    paramdii.append(paramInt1);
    paramdii.append("&reddottype=");
    paramdii.append(paramInt2);
    paramdii.append("&reddotcnt=");
    paramdii.append(paramInt3);
    paramdii.append("&reddotconsumets=");
    paramdii.append(paramLong);
    paramdii.append("&notshowreason=");
    paramdii.append(paramString);
    paramdii.append("&reddotseq=");
    paramdii.append(localdii.hTM);
    if ((paramInt1 == 100) || (paramInt1 == 101) || (paramInt1 == 102) || (paramInt1 == 108)) {
      if (bs.isNullOrNil((String)g.agR().agA().get(68377, null))) {
        break label354;
      }
    }
    label354:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (o.xMc != null) {}
      for (paramInt2 = o.xMc.bQe();; paramInt2 = 0)
      {
        if (paramInt2 > 0) {
          paramdii.append("&snsreddottype=2&snsreddotcnt=").append(paramInt2);
        }
        for (;;)
        {
          ac.i("MicroMsg.TopStory", "reportTopStoryRedDot 16399 %s", new Object[] { paramdii.toString() });
          paramString = new cpk();
          paramString.FCf = paramdii.toString();
          paramdii = new v(paramString);
          g.agi().a(paramdii, 0);
          AppMethodBeat.o(117787);
          return;
          if (paramInt1 > 0) {
            paramdii.append("&snsreddottype=1&snsreddotcnt=0");
          } else {
            paramdii.append("&snsreddottype=0&snsreddotcnt=0");
          }
        }
      }
    }
  }
  
  public static void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    AppMethodBeat.i(117789);
    if (!bs.isNullOrNil((String)g.agR().agA().get(68377, null))) {}
    for (int j = 1;; j = 0)
    {
      if (o.xMc != null) {}
      for (int i = o.xMc.bQe();; i = 0)
      {
        if (i > 0) {
          j = 2;
        }
        for (;;)
        {
          paramString1 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramString1, Long.valueOf(paramLong), z.dkv(), Integer.valueOf(201), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(0L), paramString2, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt3) });
          ac.i("MicroMsg.WebSearch.WebSearchReportLogic", "reportTopStoryRedDotKv 16654: ".concat(String.valueOf(paramString1)));
          com.tencent.mm.plugin.report.e.wTc.kvStat(16654, paramString1);
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
  
  public static void aI(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(117786);
    com.tencent.mm.plugin.report.e.wTc.f(14752, new Object[] { Integer.valueOf(1), paramString1, paramString2, paramString3 });
    AppMethodBeat.o(117786);
  }
  
  public static void az(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117784);
    a(paramInt1, 3, paramInt2, paramInt3, "");
    AppMethodBeat.o(117784);
  }
  
  public static void b(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(117788);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("recnondocreport=1");
    localStringBuffer.append("&type=51");
    localStringBuffer.append("&content=");
    paramString1 = localStringBuffer.append(paramInt1).append("|").append(paramInt2).append("|").append(bs.nullAsNil(paramString1)).append("|");
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.append(paramInt1);
      localStringBuffer.append("&searchid=");
      localStringBuffer.append(bs.nullAsNil(paramString2));
      ac.i("MicroMsg.TopStory", "reportTopStoryRedDot 14791 %s", new Object[] { localStringBuffer.toString() });
      paramString1 = new cpk();
      paramString1.FCf = localStringBuffer.toString();
      paramString1 = new v(paramString1);
      g.agi().a(paramString1, 0);
      AppMethodBeat.o(117788);
      return;
    }
  }
  
  public static void cp(int paramInt, String paramString)
  {
    AppMethodBeat.i(117765);
    com.tencent.mm.plugin.report.e.wTc.kvStat(paramInt, paramString);
    AppMethodBeat.o(117765);
  }
  
  public static void cq(int paramInt, String paramString)
  {
    AppMethodBeat.i(117777);
    com.tencent.mm.plugin.report.e.wTc.f(12070, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(z.Ul(0)), paramString, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0) });
    AppMethodBeat.o(117777);
  }
  
  public static void d(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(117776);
    com.tencent.mm.plugin.report.e locale = com.tencent.mm.plugin.report.e.wTc;
    if (paramBoolean) {}
    for (;;)
    {
      locale.f(12845, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      AppMethodBeat.o(117776);
      return;
      i = 0;
    }
  }
  
  public static void exA()
  {
    AppMethodBeat.i(117769);
    a locala = BZD;
    locala.BZF += System.currentTimeMillis() - BZD.BZE;
    ac.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopH5Report %s", new Object[] { Long.valueOf(BZD.BZF) });
    AppMethodBeat.o(117769);
  }
  
  public static void exB()
  {
    AppMethodBeat.i(117770);
    a locala = BZD;
    locala.cQQ += System.currentTimeMillis() - BZD.uXo;
    ac.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopTotalReport %s", new Object[] { Long.valueOf(BZD.cQQ) });
    AppMethodBeat.o(117770);
  }
  
  public static void exC()
  {
    AppMethodBeat.i(117771);
    a locala = BZD;
    if (!locala.rAJ)
    {
      com.tencent.mm.plugin.report.e.wTc.f(12044, new Object[] { Integer.valueOf(locala.scene), Integer.valueOf(locala.BYF), Long.valueOf(locala.BZF / 1000L), Long.valueOf(locala.cQQ / 1000L) });
      locala.rAJ = true;
    }
    ac.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportTime");
    AppMethodBeat.o(117771);
  }
  
  public static void exz()
  {
    AppMethodBeat.i(117768);
    BZD.BZE = System.currentTimeMillis();
    ac.v("MicroMsg.WebSearch.WebSearchReportLogic", "startH5Report %s", new Object[] { Long.valueOf(BZD.BZE) });
    AppMethodBeat.o(117768);
  }
  
  public static void h(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(117778);
    com.tencent.mm.plugin.report.e.wTc.f(13809, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(0), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(117778);
  }
  
  public static final void iE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117781);
    if (paramInt1 == 21) {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(649L, paramInt2, 1L, true);
    }
    AppMethodBeat.o(117781);
  }
  
  public static void iF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117782);
    K(paramInt1, paramInt2, "");
    AppMethodBeat.o(117782);
  }
  
  public static void p(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117774);
    bp localbp = new bp();
    localbp.dNd = localbp.t("Query", paramString, true);
    localbp.dNe = paramInt1;
    localbp.dIi = paramInt2;
    localbp.dHY = paramInt3;
    localbp.dNf = 0L;
    localbp.aHZ();
    ac.i("MicroMsg.WebSearch.WebSearchReportLogic", "report12639 %s", new Object[] { localbp.PS().replace("\r\n", " ") });
    AppMethodBeat.o(117774);
  }
  
  public static final class a
  {
    int BYF;
    long BZE;
    long BZF;
    long cQQ;
    boolean rAJ = true;
    int scene;
    long uXo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ai
 * JD-Core Version:    0.7.0.1
 */