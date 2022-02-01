package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.cd;
import com.tencent.mm.g.b.a.cg;
import com.tencent.mm.g.b.a.jm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class am
{
  private static a DCz;
  
  static
  {
    AppMethodBeat.i(117790);
    DCz = new a();
    AppMethodBeat.o(117790);
  }
  
  public static void L(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(117775);
    d(paramInt1, paramInt2, paramString, false);
    AppMethodBeat.o(117775);
  }
  
  public static void M(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(117783);
    a(paramInt1, paramInt2, 0, 0, paramString);
    AppMethodBeat.o(117783);
  }
  
  public static void Wk(int paramInt)
  {
    AppMethodBeat.i(117767);
    DCz.scene = paramInt;
    DCz.DBB = 1;
    DCz.DCA = System.currentTimeMillis();
    DCz.DCB = 0L;
    DCz.wbz = System.currentTimeMillis();
    DCz.dcg = 0L;
    DCz.ssW = false;
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "initReport %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    AppMethodBeat.o(117767);
  }
  
  public static void Wl(int paramInt)
  {
    AppMethodBeat.i(117772);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchVisit %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.ygI.f(12041, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ad.We(0)) });
    AppMethodBeat.o(117772);
  }
  
  public static final void Wm(int paramInt)
  {
    AppMethodBeat.i(117780);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportIdKey649 %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(649L, paramInt, 1L, true);
    AppMethodBeat.o(117780);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(117785);
    if (paramInt1 == 21) {}
    for (int i = ad.We(1);; i = ad.We(0))
    {
      com.tencent.mm.plugin.report.e.ygI.f(14457, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
      AppMethodBeat.o(117785);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    AppMethodBeat.i(117773);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    com.tencent.mm.plugin.report.e.ygI.f(12098, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(ad.We(0)), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    AppMethodBeat.o(117773);
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt4, String paramString6, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(217649);
    cd localcd = new cd();
    localcd.dPl = paramInt1;
    localcd.dSe = localcd.t("RequestId", paramString1, true);
    localcd.dVd = paramInt2;
    localcd.ebU = paramInt3;
    localcd.ebV = localcd.t("HitWordList", paramString2, true);
    localcd.ebW = localcd.t("HitWordVersion", paramString3, true);
    localcd.dSh = localcd.t("MsgId", paramString4, true);
    localcd.dSi = localcd.t("MsgFromUsername", paramString5, true);
    localcd.ebX = paramInt4;
    localcd.dSk = localcd.t("ChatRoomID", paramString6, true);
    localcd.ebY = paramLong1;
    localcd.ebZ = paramLong2;
    localcd.aLk();
    a(localcd);
    AppMethodBeat.o(217649);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(117779);
    com.tencent.mm.plugin.report.e.ygI.f(13810, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(paramInt4) });
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
      com.tencent.mm.plugin.report.e.ygI.f(12042, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(paramInt2), bt.bI(paramString, "").replace(",", " ") });
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
    AppMethodBeat.i(217651);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchReportLogic", "report%s %s", new Object[] { Integer.valueOf(parama.getId()), parama.RE().replace("\r\n", " ") });
    AppMethodBeat.o(217651);
  }
  
  public static void a(dnx paramdnx, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString)
  {
    AppMethodBeat.i(117787);
    dnx localdnx = paramdnx;
    if (paramdnx == null)
    {
      localdnx = new dnx();
      localdnx.msgId = "";
      localdnx.HBS = 0L;
    }
    paramdnx = new StringBuffer();
    paramdnx.append("reddotreport=1");
    paramdnx.append("&reddotid=");
    paramdnx.append(bt.nullAsNil(localdnx.msgId));
    paramdnx.append("&reddotts=");
    paramdnx.append(localdnx.HBS);
    paramdnx.append("&nettype=");
    paramdnx.append(ad.Ux());
    paramdnx.append("&optype=");
    paramdnx.append(paramInt1);
    paramdnx.append("&reddottype=");
    paramdnx.append(paramInt2);
    paramdnx.append("&reddotcnt=");
    paramdnx.append(paramInt3);
    paramdnx.append("&reddotconsumets=");
    paramdnx.append(paramLong);
    paramdnx.append("&notshowreason=");
    paramdnx.append(paramString);
    paramdnx.append("&reddotseq=");
    paramdnx.append(localdnx.inh);
    if ((paramInt1 == 100) || (paramInt1 == 101) || (paramInt1 == 102) || (paramInt1 == 108)) {
      if (bt.isNullOrNil((String)g.ajC().ajl().get(68377, null))) {
        break label366;
      }
    }
    label366:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (o.zbU != null) {}
      for (paramInt2 = o.zbU.bUJ();; paramInt2 = 0)
      {
        if (paramInt2 > 0) {
          paramdnx.append("&snsreddottype=2&snsreddotcnt=").append(paramInt2);
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory", "reportTopStoryRedDot 16399 %s", new Object[] { paramdnx.toString() });
          paramString = new cup();
          paramString.Hmu = paramdnx.toString();
          paramdnx = new z(paramString);
          g.aiU().a(paramdnx, 0);
          AppMethodBeat.o(117787);
          return;
          if (paramInt1 > 0) {
            paramdnx.append("&snsreddottype=1&snsreddotcnt=0");
          } else {
            paramdnx.append("&snsreddottype=0&snsreddotcnt=0");
          }
        }
      }
    }
  }
  
  public static void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    AppMethodBeat.i(117789);
    if (!bt.isNullOrNil((String)g.ajC().ajl().get(68377, null))) {}
    for (int j = 1;; j = 0)
    {
      if (o.zbU != null) {}
      for (int i = o.zbU.bUJ();; i = 0)
      {
        if (i > 0) {
          j = 2;
        }
        for (;;)
        {
          paramString1 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramString1, Long.valueOf(paramLong), ad.Ux(), Integer.valueOf(201), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(0L), paramString2, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt3) });
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchReportLogic", "reportTopStoryRedDotKv 16654: ".concat(String.valueOf(paramString1)));
          com.tencent.mm.plugin.report.e.ygI.kvStat(16654, paramString1);
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
  
  public static void aB(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117784);
    a(paramInt1, 3, paramInt2, paramInt3, "");
    AppMethodBeat.o(117784);
  }
  
  public static void aQ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(117786);
    com.tencent.mm.plugin.report.e.ygI.f(14752, new Object[] { Integer.valueOf(1), paramString1, paramString2, paramString3 });
    AppMethodBeat.o(117786);
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory", "reportTopStoryRedDot 14791 %s", new Object[] { localStringBuffer.toString() });
      paramString1 = new cup();
      paramString1.Hmu = localStringBuffer.toString();
      paramString1 = new z(paramString1);
      g.aiU().a(paramString1, 0);
      AppMethodBeat.o(117788);
      return;
    }
  }
  
  public static void cv(int paramInt, String paramString)
  {
    AppMethodBeat.i(117765);
    com.tencent.mm.plugin.report.e.ygI.kvStat(paramInt, paramString);
    AppMethodBeat.o(117765);
  }
  
  public static void cw(int paramInt, String paramString)
  {
    AppMethodBeat.i(117777);
    com.tencent.mm.plugin.report.e.ygI.f(12070, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ad.We(0)), paramString, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0) });
    AppMethodBeat.o(117777);
  }
  
  public static void d(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(117776);
    com.tencent.mm.plugin.report.e locale = com.tencent.mm.plugin.report.e.ygI;
    if (paramBoolean) {}
    for (;;)
    {
      locale.f(12845, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      AppMethodBeat.o(117776);
      return;
      i = 0;
    }
  }
  
  public static void eMq()
  {
    AppMethodBeat.i(117768);
    DCz.DCA = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "startH5Report %s", new Object[] { Long.valueOf(DCz.DCA) });
    AppMethodBeat.o(117768);
  }
  
  public static void eMr()
  {
    AppMethodBeat.i(117769);
    a locala = DCz;
    locala.DCB += System.currentTimeMillis() - DCz.DCA;
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopH5Report %s", new Object[] { Long.valueOf(DCz.DCB) });
    AppMethodBeat.o(117769);
  }
  
  public static void eMs()
  {
    AppMethodBeat.i(117770);
    a locala = DCz;
    locala.dcg += System.currentTimeMillis() - DCz.wbz;
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopTotalReport %s", new Object[] { Long.valueOf(DCz.dcg) });
    AppMethodBeat.o(117770);
  }
  
  public static void eMt()
  {
    AppMethodBeat.i(117771);
    a locala = DCz;
    if (!locala.ssW)
    {
      com.tencent.mm.plugin.report.e.ygI.f(12044, new Object[] { Integer.valueOf(locala.scene), Integer.valueOf(locala.DBB), Long.valueOf(locala.DCB / 1000L), Long.valueOf(locala.dcg / 1000L) });
      locala.ssW = true;
    }
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportTime");
    AppMethodBeat.o(117771);
  }
  
  public static void h(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(117778);
    com.tencent.mm.plugin.report.e.ygI.f(13809, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(0), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(117778);
  }
  
  public static final void iR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117781);
    if (paramInt1 == 21) {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(649L, paramInt2, 1L, true);
    }
    AppMethodBeat.o(117781);
  }
  
  public static void iS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117782);
    M(paramInt1, paramInt2, "");
    AppMethodBeat.o(117782);
  }
  
  public static void o(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(217650);
    jm localjm = new jm();
    localjm.eAx = paramLong1;
    localjm.ebY = paramLong2;
    localjm.dYD = paramLong3;
    localjm.aLk();
    a(localjm);
    AppMethodBeat.o(217650);
  }
  
  public static void p(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117774);
    cg localcg = new cg();
    localcg.ecs = localcg.t("Query", paramString.replace(',', ' '), true);
    localcg.ect = paramInt1;
    localcg.dVP = paramInt2;
    localcg.dVd = paramInt3;
    localcg.ecu = 0L;
    localcg.aLk();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchReportLogic", "report12639 %s", new Object[] { localcg.RE().replace("\r\n", " ") });
    AppMethodBeat.o(117774);
  }
  
  public static final class a
  {
    int DBB;
    long DCA;
    long DCB;
    long dcg;
    int scene;
    boolean ssW = true;
    long wbz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.am
 * JD-Core Version:    0.7.0.1
 */