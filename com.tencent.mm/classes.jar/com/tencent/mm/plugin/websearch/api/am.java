package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.cd;
import com.tencent.mm.g.b.a.cg;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class am
{
  private static a DUw;
  
  static
  {
    AppMethodBeat.i(117790);
    DUw = new a();
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
  
  public static void WR(int paramInt)
  {
    AppMethodBeat.i(117767);
    DUw.scene = paramInt;
    DUw.DTy = 1;
    DUw.DUx = System.currentTimeMillis();
    DUw.DUy = 0L;
    DUw.wqY = System.currentTimeMillis();
    DUw.ddi = 0L;
    DUw.sDg = false;
    ae.v("MicroMsg.WebSearch.WebSearchReportLogic", "initReport %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    AppMethodBeat.o(117767);
  }
  
  public static void WS(int paramInt)
  {
    AppMethodBeat.i(117772);
    ae.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchVisit %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.ywz.f(12041, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ad.WL(0)) });
    AppMethodBeat.o(117772);
  }
  
  public static final void WT(int paramInt)
  {
    AppMethodBeat.i(117780);
    ae.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportIdKey649 %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(649L, paramInt, 1L, true);
    AppMethodBeat.o(117780);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(117785);
    if (paramInt1 == 21) {}
    for (int i = ad.WL(1);; i = ad.WL(0))
    {
      com.tencent.mm.plugin.report.e.ywz.f(14457, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
      AppMethodBeat.o(117785);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    AppMethodBeat.i(117773);
    ae.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    com.tencent.mm.plugin.report.e.ywz.f(12098, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(ad.WL(0)), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    AppMethodBeat.o(117773);
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt4, String paramString6, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188479);
    cd localcd = new cd();
    localcd.dQB = paramInt1;
    localcd.dTu = localcd.t("RequestId", paramString1, true);
    localcd.dWt = paramInt2;
    localcd.edp = paramInt3;
    localcd.edq = localcd.t("HitWordList", paramString2, true);
    localcd.edr = localcd.t("HitWordVersion", paramString3, true);
    localcd.dTx = localcd.t("MsgId", paramString4, true);
    localcd.dTy = localcd.t("MsgFromUsername", paramString5, true);
    localcd.eds = paramInt4;
    localcd.dTA = localcd.t("ChatRoomID", paramString6, true);
    localcd.edt = paramLong1;
    localcd.edu = paramLong2;
    localcd.aLH();
    a(localcd);
    AppMethodBeat.o(188479);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(117779);
    com.tencent.mm.plugin.report.e.ywz.f(13810, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(paramInt4) });
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
      com.tencent.mm.plugin.report.e.ywz.f(12042, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(paramInt2), bu.bI(paramString, "").replace(",", " ") });
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
    AppMethodBeat.i(188481);
    ae.i("MicroMsg.WebSearch.WebSearchReportLogic", "report%s %s", new Object[] { Integer.valueOf(parama.getId()), parama.RD().replace("\r\n", " ") });
    AppMethodBeat.o(188481);
  }
  
  public static void a(dou paramdou, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString)
  {
    AppMethodBeat.i(117787);
    dou localdou = paramdou;
    if (paramdou == null)
    {
      localdou = new dou();
      localdou.msgId = "";
      localdou.HVF = 0L;
    }
    paramdou = new StringBuffer();
    paramdou.append("reddotreport=1");
    paramdou.append("&reddotid=");
    paramdou.append(bu.nullAsNil(localdou.msgId));
    paramdou.append("&reddotts=");
    paramdou.append(localdou.HVF);
    paramdou.append("&nettype=");
    paramdou.append(ad.UD());
    paramdou.append("&optype=");
    paramdou.append(paramInt1);
    paramdou.append("&reddottype=");
    paramdou.append(paramInt2);
    paramdou.append("&reddotcnt=");
    paramdou.append(paramInt3);
    paramdou.append("&reddotconsumets=");
    paramdou.append(paramLong);
    paramdou.append("&notshowreason=");
    paramdou.append(paramString);
    paramdou.append("&reddotseq=");
    paramdou.append(localdou.iqb);
    if ((paramInt1 == 100) || (paramInt1 == 101) || (paramInt1 == 102) || (paramInt1 == 108)) {
      if (bu.isNullOrNil((String)g.ajR().ajA().get(68377, null))) {
        break label366;
      }
    }
    label366:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (o.zsx != null) {}
      for (paramInt2 = o.zsx.bVY();; paramInt2 = 0)
      {
        if (paramInt2 > 0) {
          paramdou.append("&snsreddottype=2&snsreddotcnt=").append(paramInt2);
        }
        for (;;)
        {
          ae.i("MicroMsg.TopStory", "reportTopStoryRedDot 16399 %s", new Object[] { paramdou.toString() });
          paramString = new cvj();
          paramString.HFU = paramdou.toString();
          paramdou = new z(paramString);
          g.ajj().a(paramdou, 0);
          AppMethodBeat.o(117787);
          return;
          if (paramInt1 > 0) {
            paramdou.append("&snsreddottype=1&snsreddotcnt=0");
          } else {
            paramdou.append("&snsreddottype=0&snsreddotcnt=0");
          }
        }
      }
    }
  }
  
  public static void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    AppMethodBeat.i(117789);
    if (!bu.isNullOrNil((String)g.ajR().ajA().get(68377, null))) {}
    for (int j = 1;; j = 0)
    {
      if (o.zsx != null) {}
      for (int i = o.zsx.bVY();; i = 0)
      {
        if (i > 0) {
          j = 2;
        }
        for (;;)
        {
          paramString1 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramString1, Long.valueOf(paramLong), ad.UD(), Integer.valueOf(201), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(0L), paramString2, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt3) });
          ae.i("MicroMsg.WebSearch.WebSearchReportLogic", "reportTopStoryRedDotKv 16654: ".concat(String.valueOf(paramString1)));
          com.tencent.mm.plugin.report.e.ywz.kvStat(16654, paramString1);
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
  
  public static void aC(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117784);
    a(paramInt1, 3, paramInt2, paramInt3, "");
    AppMethodBeat.o(117784);
  }
  
  public static void aR(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(117786);
    com.tencent.mm.plugin.report.e.ywz.f(14752, new Object[] { Integer.valueOf(1), paramString1, paramString2, paramString3 });
    AppMethodBeat.o(117786);
  }
  
  public static void b(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(117788);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("recnondocreport=1");
    localStringBuffer.append("&type=51");
    localStringBuffer.append("&content=");
    paramString1 = localStringBuffer.append(paramInt1).append("|").append(paramInt2).append("|").append(bu.nullAsNil(paramString1)).append("|");
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.append(paramInt1);
      localStringBuffer.append("&searchid=");
      localStringBuffer.append(bu.nullAsNil(paramString2));
      ae.i("MicroMsg.TopStory", "reportTopStoryRedDot 14791 %s", new Object[] { localStringBuffer.toString() });
      paramString1 = new cvj();
      paramString1.HFU = localStringBuffer.toString();
      paramString1 = new z(paramString1);
      g.ajj().a(paramString1, 0);
      AppMethodBeat.o(117788);
      return;
    }
  }
  
  public static void cv(int paramInt, String paramString)
  {
    AppMethodBeat.i(117765);
    com.tencent.mm.plugin.report.e.ywz.kvStat(paramInt, paramString);
    AppMethodBeat.o(117765);
  }
  
  public static void cw(int paramInt, String paramString)
  {
    AppMethodBeat.i(117777);
    com.tencent.mm.plugin.report.e.ywz.f(12070, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ad.WL(0)), paramString, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0) });
    AppMethodBeat.o(117777);
  }
  
  public static void d(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(117776);
    com.tencent.mm.plugin.report.e locale = com.tencent.mm.plugin.report.e.ywz;
    if (paramBoolean) {}
    for (;;)
    {
      locale.f(12845, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      AppMethodBeat.o(117776);
      return;
      i = 0;
    }
  }
  
  public static void ePZ()
  {
    AppMethodBeat.i(117768);
    DUw.DUx = System.currentTimeMillis();
    ae.v("MicroMsg.WebSearch.WebSearchReportLogic", "startH5Report %s", new Object[] { Long.valueOf(DUw.DUx) });
    AppMethodBeat.o(117768);
  }
  
  public static void eQa()
  {
    AppMethodBeat.i(117769);
    a locala = DUw;
    locala.DUy += System.currentTimeMillis() - DUw.DUx;
    ae.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopH5Report %s", new Object[] { Long.valueOf(DUw.DUy) });
    AppMethodBeat.o(117769);
  }
  
  public static void eQb()
  {
    AppMethodBeat.i(117770);
    a locala = DUw;
    locala.ddi += System.currentTimeMillis() - DUw.wqY;
    ae.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopTotalReport %s", new Object[] { Long.valueOf(DUw.ddi) });
    AppMethodBeat.o(117770);
  }
  
  public static void eQc()
  {
    AppMethodBeat.i(117771);
    a locala = DUw;
    if (!locala.sDg)
    {
      com.tencent.mm.plugin.report.e.ywz.f(12044, new Object[] { Integer.valueOf(locala.scene), Integer.valueOf(locala.DTy), Long.valueOf(locala.DUy / 1000L), Long.valueOf(locala.ddi / 1000L) });
      locala.sDg = true;
    }
    ae.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportTime");
    AppMethodBeat.o(117771);
  }
  
  public static void h(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(117778);
    com.tencent.mm.plugin.report.e.ywz.f(13809, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(0), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(117778);
  }
  
  public static final void iV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117781);
    if (paramInt1 == 21) {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(649L, paramInt2, 1L, true);
    }
    AppMethodBeat.o(117781);
  }
  
  public static void iW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117782);
    M(paramInt1, paramInt2, "");
    AppMethodBeat.o(117782);
  }
  
  public static void o(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(188480);
    jo localjo = new jo();
    localjo.eCg = paramLong1;
    localjo.edt = paramLong2;
    localjo.dZW = paramLong3;
    localjo.aLH();
    a(localjo);
    AppMethodBeat.o(188480);
  }
  
  public static void p(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117774);
    cg localcg = new cg();
    localcg.edN = localcg.t("Query", paramString.replace(',', ' '), true);
    localcg.edO = paramInt1;
    localcg.dXf = paramInt2;
    localcg.dWt = paramInt3;
    localcg.edP = 0L;
    localcg.aLH();
    ae.i("MicroMsg.WebSearch.WebSearchReportLogic", "report12639 %s", new Object[] { localcg.RD().replace("\r\n", " ") });
    AppMethodBeat.o(117774);
  }
  
  public static final class a
  {
    int DTy;
    long DUx;
    long DUy;
    long ddi;
    boolean sDg = true;
    int scene;
    long wqY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.am
 * JD-Core Version:    0.7.0.1
 */