package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.ap;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class ak
{
  private static a AHm;
  
  static
  {
    AppMethodBeat.i(117790);
    AHm = new a();
    AppMethodBeat.o(117790);
  }
  
  public static void K(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(117775);
    e(paramInt1, paramInt2, paramString, false);
    AppMethodBeat.o(117775);
  }
  
  public static void L(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(117783);
    a(paramInt1, paramInt2, 0, 0, paramString);
    AppMethodBeat.o(117783);
  }
  
  public static void Si(int paramInt)
  {
    AppMethodBeat.i(117767);
    AHm.scene = paramInt;
    AHm.AGn = 1;
    AHm.AHn = System.currentTimeMillis();
    AHm.AHo = 0L;
    AHm.tOM = System.currentTimeMillis();
    AHm.cTt = 0L;
    AHm.qHI = false;
    ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "initReport %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    AppMethodBeat.o(117767);
  }
  
  public static void Sj(int paramInt)
  {
    AppMethodBeat.i(117772);
    ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchVisit %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.vIY.f(12041, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(aa.Sb(0)) });
    AppMethodBeat.o(117772);
  }
  
  public static final void Sk(int paramInt)
  {
    AppMethodBeat.i(117780);
    ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportIdKey649 %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(649L, paramInt, 1L, true);
    AppMethodBeat.o(117780);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(117785);
    if (paramInt1 == 21) {}
    for (int i = aa.Sb(1);; i = aa.Sb(0))
    {
      com.tencent.mm.plugin.report.e.vIY.f(14457, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
      AppMethodBeat.o(117785);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    AppMethodBeat.i(117773);
    ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    com.tencent.mm.plugin.report.e.vIY.f(12098, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(aa.Sb(0)), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    AppMethodBeat.o(117773);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(117779);
    com.tencent.mm.plugin.report.e.vIY.f(13810, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(paramInt4) });
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
      com.tencent.mm.plugin.report.e.vIY.f(12042, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(paramInt2), bt.by(paramString, "").replace(",", " ") });
      AppMethodBeat.o(117766);
      return;
      if (paramBoolean2) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  public static void a(dcv paramdcv, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString)
  {
    AppMethodBeat.i(117787);
    dcv localdcv = paramdcv;
    if (paramdcv == null)
    {
      localdcv = new dcv();
      localdcv.dvT = "";
      localdcv.Eul = 0L;
    }
    paramdcv = new StringBuffer();
    paramdcv.append("reddotreport=1");
    paramdcv.append("&reddotid=");
    paramdcv.append(bt.nullAsNil(localdcv.dvT));
    paramdcv.append("&reddotts=");
    paramdcv.append(localdcv.Eul);
    paramdcv.append("&nettype=");
    paramdcv.append(aa.cWN());
    paramdcv.append("&optype=");
    paramdcv.append(paramInt1);
    paramdcv.append("&reddottype=");
    paramdcv.append(paramInt2);
    paramdcv.append("&reddotcnt=");
    paramdcv.append(paramInt3);
    paramdcv.append("&reddotconsumets=");
    paramdcv.append(paramLong);
    paramdcv.append("&notshowreason=");
    paramdcv.append(paramString);
    paramdcv.append("&reddotseq=");
    paramdcv.append(localdcv.htk);
    if ((paramInt1 == 100) || (paramInt1 == 101) || (paramInt1 == 102) || (paramInt1 == 108)) {
      if (bt.isNullOrNil((String)g.afB().afk().get(68377, null))) {
        break label354;
      }
    }
    label354:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (o.wzI != null) {}
      for (paramInt2 = o.wzI.bIR();; paramInt2 = 0)
      {
        if (paramInt2 > 0) {
          paramdcv.append("&snsreddottype=2&snsreddotcnt=").append(paramInt2);
        }
        for (;;)
        {
          ad.i("MicroMsg.TopStory", "reportTopStoryRedDot 16399 %s", new Object[] { paramdcv.toString() });
          paramString = new ckd();
          paramString.Eff = paramdcv.toString();
          paramdcv = new w(paramString);
          g.aeS().a(paramdcv, 0);
          AppMethodBeat.o(117787);
          return;
          if (paramInt1 > 0) {
            paramdcv.append("&snsreddottype=1&snsreddotcnt=0");
          } else {
            paramdcv.append("&snsreddottype=0&snsreddotcnt=0");
          }
        }
      }
    }
  }
  
  public static void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    AppMethodBeat.i(117789);
    if (!bt.isNullOrNil((String)g.afB().afk().get(68377, null))) {}
    for (int j = 1;; j = 0)
    {
      if (o.wzI != null) {}
      for (int i = o.wzI.bIR();; i = 0)
      {
        if (i > 0) {
          j = 2;
        }
        for (;;)
        {
          paramString1 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramString1, Long.valueOf(paramLong), aa.cWN(), Integer.valueOf(201), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(0L), paramString2, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt3) });
          ad.i("MicroMsg.WebSearch.WebSearchReportLogic", "reportTopStoryRedDotKv 16654: ".concat(String.valueOf(paramString1)));
          com.tencent.mm.plugin.report.e.vIY.kvStat(16654, paramString1);
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
  
  public static void aF(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(117786);
    com.tencent.mm.plugin.report.e.vIY.f(14752, new Object[] { Integer.valueOf(1), paramString1, paramString2, paramString3 });
    AppMethodBeat.o(117786);
  }
  
  public static void ay(int paramInt1, int paramInt2, int paramInt3)
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
    paramString1 = localStringBuffer.append(paramInt1).append("|").append(paramInt2).append("|").append(bt.nullAsNil(paramString1)).append("|");
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.append(paramInt1);
      localStringBuffer.append("&searchid=");
      localStringBuffer.append(bt.nullAsNil(paramString2));
      ad.i("MicroMsg.TopStory", "reportTopStoryRedDot 14791 %s", new Object[] { localStringBuffer.toString() });
      paramString1 = new ckd();
      paramString1.Eff = localStringBuffer.toString();
      paramString1 = new w(paramString1);
      g.aeS().a(paramString1, 0);
      AppMethodBeat.o(117788);
      return;
    }
  }
  
  public static void cm(int paramInt, String paramString)
  {
    AppMethodBeat.i(117765);
    com.tencent.mm.plugin.report.e.vIY.kvStat(paramInt, paramString);
    AppMethodBeat.o(117765);
  }
  
  public static void cn(int paramInt, String paramString)
  {
    AppMethodBeat.i(117777);
    com.tencent.mm.plugin.report.e.vIY.f(12070, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(aa.Sb(0)), paramString, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0) });
    AppMethodBeat.o(117777);
  }
  
  public static void e(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(117776);
    com.tencent.mm.plugin.report.e locale = com.tencent.mm.plugin.report.e.vIY;
    if (paramBoolean) {}
    for (;;)
    {
      locale.f(12845, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      AppMethodBeat.o(117776);
      return;
      i = 0;
    }
  }
  
  public static void eif()
  {
    AppMethodBeat.i(117768);
    AHm.AHn = System.currentTimeMillis();
    ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "startH5Report %s", new Object[] { Long.valueOf(AHm.AHn) });
    AppMethodBeat.o(117768);
  }
  
  public static void eig()
  {
    AppMethodBeat.i(117769);
    a locala = AHm;
    locala.AHo += System.currentTimeMillis() - AHm.AHn;
    ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopH5Report %s", new Object[] { Long.valueOf(AHm.AHo) });
    AppMethodBeat.o(117769);
  }
  
  public static void eih()
  {
    AppMethodBeat.i(117770);
    a locala = AHm;
    locala.cTt += System.currentTimeMillis() - AHm.tOM;
    ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopTotalReport %s", new Object[] { Long.valueOf(AHm.cTt) });
    AppMethodBeat.o(117770);
  }
  
  public static void eii()
  {
    AppMethodBeat.i(117771);
    a locala = AHm;
    if (!locala.qHI)
    {
      com.tencent.mm.plugin.report.e.vIY.f(12044, new Object[] { Integer.valueOf(locala.scene), Integer.valueOf(locala.AGn), Long.valueOf(locala.AHo / 1000L), Long.valueOf(locala.cTt / 1000L) });
      locala.qHI = true;
    }
    ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportTime");
    AppMethodBeat.o(117771);
  }
  
  public static void g(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(117778);
    com.tencent.mm.plugin.report.e.vIY.f(13809, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(0), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(117778);
  }
  
  public static final void ip(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117781);
    if (paramInt1 == 21) {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(649L, paramInt2, 1L, true);
    }
    AppMethodBeat.o(117781);
  }
  
  public static void iq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117782);
    L(paramInt1, paramInt2, "");
    AppMethodBeat.o(117782);
  }
  
  public static void p(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117774);
    ap localap = new ap();
    localap.dMC = localap.t("Query", paramString, true);
    localap.dMD = paramInt1;
    localap.dJN = paramInt2;
    localap.dKe = paramInt3;
    localap.dME = 0L;
    localap.aBj();
    ad.i("MicroMsg.WebSearch.WebSearchReportLogic", "report12639 %s", new Object[] { localap.PW().replace("\r\n", " ") });
    AppMethodBeat.o(117774);
  }
  
  public static final class a
  {
    int AGn;
    long AHn;
    long AHo;
    long cTt;
    boolean qHI = true;
    int scene;
    long tOM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ak
 * JD-Core Version:    0.7.0.1
 */