package com.tencent.mm.plugin.websearch.api;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class an
{
  private static an.a uKh;
  
  static
  {
    AppMethodBeat.i(124241);
    uKh = new an.a();
    AppMethodBeat.o(124241);
  }
  
  public static void A(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(124223);
    d(paramInt1, paramInt2, paramString, false);
    AppMethodBeat.o(124223);
  }
  
  public static void B(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(124234);
    a(paramInt1, paramInt2, 0, 0, paramString);
    AppMethodBeat.o(124234);
  }
  
  public static void Ju(int paramInt)
  {
    AppMethodBeat.i(124215);
    uKh.scene = paramInt;
    uKh.uJc = 1;
    uKh.uKi = System.currentTimeMillis();
    uKh.uKj = 0L;
    uKh.oTu = System.currentTimeMillis();
    uKh.cew = 0L;
    uKh.quM = false;
    ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "initReport %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    AppMethodBeat.o(124215);
  }
  
  public static void Jv(int paramInt)
  {
    AppMethodBeat.i(124220);
    ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchVisit %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.qrI.e(12041, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(aa.Jf(0)) });
    AppMethodBeat.o(124220);
  }
  
  public static final void Jw(int paramInt)
  {
    AppMethodBeat.i(124231);
    ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportIdKey649 %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(649L, paramInt, 1L, true);
    AppMethodBeat.o(124231);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(124236);
    if (paramInt1 == 21) {}
    for (int i = aa.Jf(1);; i = aa.Jf(0))
    {
      com.tencent.mm.plugin.report.e.qrI.e(14457, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
      AppMethodBeat.o(124236);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    AppMethodBeat.i(124221);
    ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    com.tencent.mm.plugin.report.e.qrI.e(12098, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(aa.Jf(0)), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    AppMethodBeat.o(124221);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(151924);
    com.tencent.mm.plugin.report.e.qrI.e(13810, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(151924);
  }
  
  public static void a(int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    AppMethodBeat.i(124214);
    int i;
    if (paramBoolean1) {
      i = 3;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.qrI.e(12042, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(paramInt2), bo.bf(paramString, "").replace(",", " ") });
      AppMethodBeat.o(124214);
      return;
      if (paramBoolean2) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  public static void a(cku paramcku, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString)
  {
    AppMethodBeat.i(124238);
    cku localcku = paramcku;
    if (paramcku == null)
    {
      localcku = new cku();
      localcku.cDC = "";
      localcku.xUH = 0L;
    }
    paramcku = new StringBuffer();
    paramcku.append("reddotreport=1");
    paramcku.append("&reddotid=");
    paramcku.append(bo.nullAsNil(localcku.cDC));
    paramcku.append("&reddotts=");
    paramcku.append(localcku.xUH);
    paramcku.append("&nettype=");
    paramcku.append(aa.bXn());
    paramcku.append("&optype=");
    paramcku.append(paramInt1);
    paramcku.append("&reddottype=");
    paramcku.append(paramInt2);
    paramcku.append("&reddotcnt=");
    paramcku.append(paramInt3);
    paramcku.append("&reddotconsumets=");
    paramcku.append(paramLong);
    paramcku.append("&notshowreason=");
    paramcku.append(paramString);
    paramcku.append("&reddotseq=");
    paramcku.append(localcku.fQD);
    if ((paramInt1 == 100) || (paramInt1 == 101) || (paramInt1 == 102) || (paramInt1 == 108)) {
      if (bo.isNullOrNil((String)g.RL().Ru().get(68377, null))) {
        break label354;
      }
    }
    label354:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (n.raS != null) {}
      for (paramInt2 = n.raS.bbZ();; paramInt2 = 0)
      {
        if (paramInt2 > 0) {
          paramcku.append("&snsreddottype=2&snsreddotcnt=").append(paramInt2);
        }
        for (;;)
        {
          ab.i("MicroMsg.TopStory", "reportTopStoryRedDot 16399 %s", new Object[] { paramcku.toString() });
          paramString = new buo();
          paramString.xHP = paramcku.toString();
          paramcku = new w(paramString);
          g.Rc().a(paramcku, 0);
          AppMethodBeat.o(124238);
          return;
          if (paramInt1 > 0) {
            paramcku.append("&snsreddottype=1&snsreddotcnt=0");
          } else {
            paramcku.append("&snsreddottype=0&snsreddotcnt=0");
          }
        }
      }
    }
  }
  
  public static void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    AppMethodBeat.i(124240);
    if (!bo.isNullOrNil((String)g.RL().Ru().get(68377, null))) {}
    for (int j = 1;; j = 0)
    {
      if (n.raS != null) {}
      for (int i = n.raS.bbZ();; i = 0)
      {
        if (i > 0) {
          j = 2;
        }
        for (;;)
        {
          paramString1 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramString1, Long.valueOf(paramLong), aa.bXn(), Integer.valueOf(201), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(0L), paramString2, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt3) });
          ab.i("MicroMsg.WebSearch.WebSearchReportLogic", "reportTopStoryRedDotKv 16654: ".concat(String.valueOf(paramString1)));
          com.tencent.mm.plugin.report.e.qrI.kvStat(16654, paramString1);
          AppMethodBeat.o(124240);
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
  
  public static void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(124228);
    ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchLocalPageExposure:");
    com.tencent.mm.plugin.report.e.qrI.e(14663, new Object[] { Uri.encode(paramString1), paramString2, Long.valueOf(paramLong), paramString3, Integer.valueOf(3) });
    AppMethodBeat.o(124228);
  }
  
  public static final void agz(String paramString)
  {
    AppMethodBeat.i(124230);
    ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportWebSuggestClick %s", new Object[] { paramString });
    com.tencent.mm.plugin.report.e.qrI.kvStat(12721, paramString);
    AppMethodBeat.o(124230);
  }
  
  public static void am(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(124235);
    a(paramInt1, 3, paramInt2, paramInt3, "");
    AppMethodBeat.o(124235);
  }
  
  public static void au(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(124237);
    com.tencent.mm.plugin.report.e.qrI.e(14752, new Object[] { Integer.valueOf(1), paramString1, paramString2, paramString3 });
    AppMethodBeat.o(124237);
  }
  
  public static void b(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(124239);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("recnondocreport=1");
    localStringBuffer.append("&type=51");
    localStringBuffer.append("&content=");
    paramString1 = localStringBuffer.append(paramInt1).append("|").append(paramInt2).append("|").append(bo.nullAsNil(paramString1)).append("|");
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.append(paramInt1);
      localStringBuffer.append("&searchid=");
      localStringBuffer.append(bo.nullAsNil(paramString2));
      ab.i("MicroMsg.TopStory", "reportTopStoryRedDot 14791 %s", new Object[] { localStringBuffer.toString() });
      paramString1 = new buo();
      paramString1.xHP = localStringBuffer.toString();
      paramString1 = new w(paramString1);
      g.Rc().a(paramString1, 0);
      AppMethodBeat.o(124239);
      return;
    }
  }
  
  public static void by(int paramInt, String paramString)
  {
    AppMethodBeat.i(124213);
    com.tencent.mm.plugin.report.e.qrI.kvStat(paramInt, paramString);
    AppMethodBeat.o(124213);
  }
  
  public static void bz(int paramInt, String paramString)
  {
    AppMethodBeat.i(124225);
    com.tencent.mm.plugin.report.e.qrI.e(12070, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(aa.Jf(0)), paramString, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0) });
    AppMethodBeat.o(124225);
  }
  
  public static void cZH()
  {
    AppMethodBeat.i(124216);
    uKh.uKi = System.currentTimeMillis();
    ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "startH5Report %s", new Object[] { Long.valueOf(uKh.uKi) });
    AppMethodBeat.o(124216);
  }
  
  public static void cZI()
  {
    AppMethodBeat.i(124217);
    an.a locala = uKh;
    locala.uKj += System.currentTimeMillis() - uKh.uKi;
    ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopH5Report %s", new Object[] { Long.valueOf(uKh.uKj) });
    AppMethodBeat.o(124217);
  }
  
  public static void cZJ()
  {
    AppMethodBeat.i(124218);
    an.a locala = uKh;
    locala.cew += System.currentTimeMillis() - uKh.oTu;
    ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopTotalReport %s", new Object[] { Long.valueOf(uKh.cew) });
    AppMethodBeat.o(124218);
  }
  
  public static void cZK()
  {
    AppMethodBeat.i(124219);
    an.a locala = uKh;
    if (!locala.quM)
    {
      com.tencent.mm.plugin.report.e.qrI.e(12044, new Object[] { Integer.valueOf(locala.scene), Integer.valueOf(locala.uJc), Long.valueOf(locala.uKj / 1000L), Long.valueOf(locala.cew / 1000L) });
      locala.quM = true;
    }
    ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportTime");
    AppMethodBeat.o(124219);
  }
  
  public static void d(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(124224);
    com.tencent.mm.plugin.report.e locale = com.tencent.mm.plugin.report.e.qrI;
    if (paramBoolean) {}
    for (;;)
    {
      locale.e(12845, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      AppMethodBeat.o(124224);
      return;
      i = 0;
    }
  }
  
  public static void e(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(151923);
    com.tencent.mm.plugin.report.e.qrI.e(13809, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(0), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(151923);
  }
  
  public static void f(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(124227);
    ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchLocalPageClick %s %s %d %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), paramString3 });
    com.tencent.mm.plugin.report.e.qrI.e(14657, new Object[] { Uri.encode(paramString1), paramString2, Integer.valueOf(paramInt), paramString3, Integer.valueOf(3) });
    AppMethodBeat.o(124227);
  }
  
  public static void gF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124233);
    B(paramInt1, paramInt2, "");
    AppMethodBeat.o(124233);
  }
  
  public static void m(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(124222);
    com.tencent.mm.plugin.report.e.qrI.e(12639, new Object[] { bo.bf(paramString, "").replace(",", " "), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(124222);
  }
  
  public static final void reportIdKey649ForLook(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124232);
    if (paramInt1 == 21) {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(649L, paramInt2, 1L, true);
    }
    AppMethodBeat.o(124232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.an
 * JD-Core Version:    0.7.0.1
 */