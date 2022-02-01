package com.tencent.mm.plugin.websearch.api;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.eo;
import com.tencent.mm.g.b.a.er;
import com.tencent.mm.g.b.a.nm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class ar
{
  private static a IFr;
  
  static
  {
    AppMethodBeat.i(117790);
    IFr = new a();
    AppMethodBeat.o(117790);
  }
  
  public static void N(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(117775);
    com.tencent.mm.plugin.report.e.Cxv.a(12845, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(0) });
    AppMethodBeat.o(117775);
  }
  
  public static void O(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(117783);
    a(paramInt1, paramInt2, 0, 0, paramString);
    AppMethodBeat.o(117783);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(117785);
    if (paramInt1 == 21) {}
    for (int i = ai.aft(1);; i = ai.aft(0))
    {
      com.tencent.mm.plugin.report.e.Cxv.a(14457, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
      AppMethodBeat.o(117785);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    AppMethodBeat.i(117773);
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    com.tencent.mm.plugin.report.e.Cxv.a(12098, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(ai.aft(0)), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    AppMethodBeat.o(117773);
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(187864);
    eo localeo = new eo();
    localeo.ejA = paramInt1;
    localeo.eno = localeo.x("RequestId", paramString1, true);
    localeo.erW = paramInt2;
    localeo.eDQ = paramInt3;
    localeo.eDR = localeo.x("HitWordList", paramString2, true);
    localeo.eDS = localeo.x("HitWordVersion", paramString3, true);
    localeo.enr = localeo.x("MsgId", paramString4, true);
    localeo.ens = localeo.x("MsgFromUsername", "", true);
    localeo.eDT = paramInt4;
    localeo.enu = localeo.x("ChatRoomID", paramString5, true);
    localeo.eiR = paramLong1;
    localeo.eDU = paramLong2;
    localeo.bfK();
    a(localeo);
    AppMethodBeat.o(187864);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(117779);
    com.tencent.mm.plugin.report.e.Cxv.a(13810, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(paramInt4) });
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
      com.tencent.mm.plugin.report.e.Cxv.a(12042, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(paramInt2), Util.nullAs(paramString, "").replace(",", " ") });
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
    AppMethodBeat.i(187867);
    Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "report%s %s", new Object[] { Integer.valueOf(parama.getId()), parama.abW().replace("\r\n", " ") });
    AppMethodBeat.o(187867);
  }
  
  public static void a(eiq parameiq, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString)
  {
    AppMethodBeat.i(117787);
    eiq localeiq = parameiq;
    if (parameiq == null)
    {
      localeiq = new eiq();
      localeiq.msgId = "";
      localeiq.NhO = 0L;
    }
    parameiq = new StringBuffer();
    parameiq.append("reddotreport=1");
    parameiq.append("&reddotid=");
    parameiq.append(Util.nullAsNil(localeiq.msgId));
    parameiq.append("&reddotts=");
    parameiq.append(localeiq.NhO);
    parameiq.append("&nettype=");
    parameiq.append(ai.ait());
    parameiq.append("&optype=");
    parameiq.append(paramInt1);
    parameiq.append("&reddottype=");
    parameiq.append(paramInt2);
    parameiq.append("&reddotcnt=");
    parameiq.append(paramInt3);
    parameiq.append("&reddotconsumets=");
    parameiq.append(paramLong);
    parameiq.append("&notshowreason=");
    parameiq.append(paramString);
    parameiq.append("&reddotseq=");
    parameiq.append(localeiq.jlm);
    if ((paramInt1 == 100) || (paramInt1 == 101) || (paramInt1 == 102) || (paramInt1 == 108)) {
      if (Util.isNullOrNil((String)g.aAh().azQ().get(68377, null))) {
        break label357;
      }
    }
    label357:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (o.DCO != null) {}
      for (paramInt2 = o.DCO.ctM();; paramInt2 = 0)
      {
        if (paramInt2 > 0) {
          parameiq.append("&snsreddottype=2&snsreddotcnt=").append(paramInt2);
        }
        for (;;)
        {
          Log.i("MicroMsg.TopStory", "reportTopStoryRedDot 16399 %s", new Object[] { parameiq.toString() });
          paramString = new doc();
          paramString.MRe = parameiq.toString();
          parameiq = new ad(paramString);
          g.azz().a(parameiq, 0);
          AppMethodBeat.o(117787);
          return;
          if (paramInt1 > 0) {
            parameiq.append("&snsreddottype=1&snsreddotcnt=0");
          } else {
            parameiq.append("&snsreddottype=0&snsreddotcnt=0");
          }
        }
      }
    }
  }
  
  public static void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    AppMethodBeat.i(117789);
    if (!Util.isNullOrNil((String)g.aAh().azQ().get(68377, null))) {}
    for (int j = 1;; j = 0)
    {
      if (o.DCO != null) {}
      for (int i = o.DCO.ctM();; i = 0)
      {
        if (i > 0) {
          j = 2;
        }
        for (;;)
        {
          paramString1 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramString1, Long.valueOf(paramLong), ai.ait(), Integer.valueOf(201), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(0L), paramString2, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt3) });
          Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "reportTopStoryRedDotKv 16654: ".concat(String.valueOf(paramString1)));
          com.tencent.mm.plugin.report.e.Cxv.kvStat(16654, paramString1);
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
  
  public static void aK(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117784);
    a(paramInt1, 3, paramInt2, paramInt3, "");
    AppMethodBeat.o(117784);
  }
  
  public static void afA(int paramInt)
  {
    AppMethodBeat.i(117772);
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchVisit %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.Cxv.a(12041, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ai.aft(0)) });
    AppMethodBeat.o(117772);
  }
  
  public static final void afB(int paramInt)
  {
    AppMethodBeat.i(117780);
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportIdKey649 %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(649L, paramInt, 1L, true);
    AppMethodBeat.o(117780);
  }
  
  public static void afC(int paramInt)
  {
    AppMethodBeat.i(187866);
    h.RTc.b(new ar.1(paramInt), "WebSearchThread");
    AppMethodBeat.o(187866);
  }
  
  public static void afz(int paramInt)
  {
    AppMethodBeat.i(117767);
    IFr.scene = paramInt;
    IFr.IEj = 1;
    IFr.IFs = System.currentTimeMillis();
    IFr.IFt = 0L;
    IFr.zMI = System.currentTimeMillis();
    IFr.dtZ = 0L;
    IFr.vtY = false;
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "initReport %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    AppMethodBeat.o(117767);
  }
  
  public static void b(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
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
      paramString1 = new doc();
      paramString1.MRe = localStringBuffer.toString();
      paramString1 = new ad(paramString1);
      g.azz().a(paramString1, 0);
      AppMethodBeat.o(117788);
      return;
    }
  }
  
  public static void cN(int paramInt, String paramString)
  {
    AppMethodBeat.i(117765);
    com.tencent.mm.plugin.report.e.Cxv.kvStat(paramInt, paramString);
    AppMethodBeat.o(117765);
  }
  
  public static void cO(int paramInt, String paramString)
  {
    AppMethodBeat.i(117777);
    com.tencent.mm.plugin.report.e.Cxv.a(12070, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ai.aft(0)), paramString, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0) });
    AppMethodBeat.o(117777);
  }
  
  public static void fYm()
  {
    AppMethodBeat.i(117768);
    IFr.IFs = System.currentTimeMillis();
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "startH5Report %s", new Object[] { Long.valueOf(IFr.IFs) });
    AppMethodBeat.o(117768);
  }
  
  public static void fYn()
  {
    AppMethodBeat.i(117769);
    a locala = IFr;
    locala.IFt += System.currentTimeMillis() - IFr.IFs;
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopH5Report %s", new Object[] { Long.valueOf(IFr.IFt) });
    AppMethodBeat.o(117769);
  }
  
  public static void fYo()
  {
    AppMethodBeat.i(117770);
    a locala = IFr;
    locala.dtZ += System.currentTimeMillis() - IFr.zMI;
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopTotalReport %s", new Object[] { Long.valueOf(IFr.dtZ) });
    AppMethodBeat.o(117770);
  }
  
  public static void fYp()
  {
    AppMethodBeat.i(117771);
    a locala = IFr;
    if (!locala.vtY)
    {
      com.tencent.mm.plugin.report.e.Cxv.a(12044, new Object[] { Integer.valueOf(locala.scene), Integer.valueOf(locala.IEj), Long.valueOf(locala.IFt / 1000L), Long.valueOf(locala.dtZ / 1000L) });
      locala.vtY = true;
    }
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportTime");
    AppMethodBeat.o(117771);
  }
  
  public static void h(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(117778);
    com.tencent.mm.plugin.report.e.Cxv.a(13809, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(0), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(117778);
  }
  
  public static final void kb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117781);
    if (paramInt1 == 21) {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(649L, paramInt2, 1L, true);
    }
    AppMethodBeat.o(117781);
  }
  
  public static void kc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117782);
    O(paramInt1, paramInt2, "");
    AppMethodBeat.o(117782);
  }
  
  public static void o(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(187865);
    nm localnm = new nm();
    localnm.fgG = paramLong1;
    localnm.eiR = paramLong2;
    localnm.erY = paramLong3;
    localnm.bfK();
    a(localnm);
    AppMethodBeat.o(187865);
  }
  
  public static void q(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117774);
    er localer = new er();
    localer.eqv = localer.x("Query", paramString.replace(',', ' '), true);
    localer.eEp = paramInt1;
    localer.esI = paramInt2;
    localer.erW = paramInt3;
    localer.eEq = 0L;
    localer.bfK();
    Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "report12639 %s", new Object[] { localer.abW().replace("\r\n", " ") });
    AppMethodBeat.o(117774);
  }
  
  public static final class a
  {
    int IEj;
    long IFs;
    long IFt;
    long dtZ;
    int scene;
    boolean vtY = true;
    long zMI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ar
 * JD-Core Version:    0.7.0.1
 */