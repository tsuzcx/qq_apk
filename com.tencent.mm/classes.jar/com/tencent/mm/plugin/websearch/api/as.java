package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.he;
import com.tencent.mm.autogen.mmdata.rpt.hm;
import com.tencent.mm.autogen.mmdata.rpt.ub;
import com.tencent.mm.autogen.mmdata.rpt.ug;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.fob;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;

public final class as
{
  private static a WpR;
  
  static
  {
    AppMethodBeat.i(117790);
    WpR = new a();
    AppMethodBeat.o(117790);
  }
  
  public static void V(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(117775);
    b(paramInt1, paramInt2, paramString, "", "");
    AppMethodBeat.o(117775);
  }
  
  public static void W(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(117783);
    a(paramInt1, paramInt2, 0, 0, paramString);
    AppMethodBeat.o(117783);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(117785);
    if (paramInt1 == 21) {}
    for (int i = aj.asY(1);; i = aj.asY(0))
    {
      com.tencent.mm.plugin.report.f.Ozc.b(14457, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
      AppMethodBeat.o(117785);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    AppMethodBeat.i(117773);
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    com.tencent.mm.plugin.report.f.Ozc.b(12098, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(aj.asY(0)), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
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
      paramString1 = new eqy();
      paramString1.abuE = localStringBuffer.toString();
      paramString1 = new ae(paramString1);
      com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
      AppMethodBeat.o(117788);
      return;
    }
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, long paramLong1, long paramLong2, int paramInt5, String paramString6, String paramString7, int paramInt6)
  {
    AppMethodBeat.i(315439);
    he localhe = new he();
    localhe.ikE = paramInt1;
    localhe.ioY = localhe.F("RequestId", paramString1, true);
    localhe.iqr = paramInt2;
    localhe.iNi = paramInt3;
    localhe.iNj = localhe.F("HitWordList", paramString2, true);
    localhe.iNk = localhe.F("HitWordVersion", paramString3, true);
    localhe.ipa = localhe.F("MsgId", paramString4, true);
    localhe.ipb = localhe.F("MsgFromUsername", "", true);
    localhe.iNl = paramInt4;
    localhe.ipc = localhe.F("ChatRoomID", paramString5, true);
    localhe.ijA = paramLong1;
    localhe.iNm = paramLong2;
    localhe.iNn = paramInt5;
    localhe.iNo = localhe.F("ShowHitWord", paramString6, true);
    localhe.iNp = localhe.F("MatchTypeList", paramString7, true);
    localhe.iNq = paramInt6;
    localhe.bMH();
    a(localhe);
    AppMethodBeat.o(315439);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(117779);
    com.tencent.mm.plugin.report.f.Ozc.b(13810, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(paramInt4) });
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
      com.tencent.mm.plugin.report.f.Ozc.b(12042, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(paramInt2), Util.nullAs(paramString, "").replace(",", " ") });
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
    AppMethodBeat.i(315446);
    Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "report%s %s", new Object[] { Integer.valueOf(parama.getId()), parama.aIF().replace("\r\n", " ") });
    AppMethodBeat.o(315446);
  }
  
  public static void a(fob paramfob, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString)
  {
    AppMethodBeat.i(117787);
    fob localfob = paramfob;
    if (paramfob == null)
    {
      localfob = new fob();
      localfob.msgId = "";
      localfob.UGO = 0L;
    }
    paramfob = new StringBuffer();
    paramfob.append("reddotreport=1");
    paramfob.append("&reddotid=");
    paramfob.append(Util.nullAsNil(localfob.msgId));
    paramfob.append("&reddotts=");
    paramfob.append(localfob.UGO);
    paramfob.append("&nettype=");
    paramfob.append(aj.gtA());
    paramfob.append("&optype=");
    paramfob.append(paramInt1);
    paramfob.append("&reddottype=");
    paramfob.append(paramInt2);
    paramfob.append("&reddotcnt=");
    paramfob.append(paramInt3);
    paramfob.append("&reddotconsumets=");
    paramfob.append(paramLong);
    paramfob.append("&notshowreason=");
    paramfob.append(paramString);
    paramfob.append("&reddotseq=");
    paramfob.append(localfob.oUj);
    if ((paramInt1 == 100) || (paramInt1 == 101) || (paramInt1 == 102) || (paramInt1 == 108)) {
      if (Util.isNullOrNil((String)com.tencent.mm.kernel.h.baE().ban().d(68377, null))) {
        break label369;
      }
    }
    label369:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (q.Qkk != null) {}
      for (paramInt2 = q.Qkk.dkF();; paramInt2 = 0)
      {
        if (paramInt2 > 0) {
          paramfob.append("&snsreddottype=2&snsreddotcnt=").append(paramInt2);
        }
        for (;;)
        {
          Log.i("MicroMsg.TopStory", "reportTopStoryRedDot 16399 %s", new Object[] { paramfob.toString() });
          paramString = new eqy();
          paramString.abuE = paramfob.toString();
          paramfob = new ae(paramString);
          com.tencent.mm.kernel.h.aZW().a(paramfob, 0);
          AppMethodBeat.o(117787);
          return;
          if (paramInt1 > 0) {
            paramfob.append("&snsreddottype=1&snsreddotcnt=0");
          } else {
            paramfob.append("&snsreddottype=0&snsreddotcnt=0");
          }
        }
      }
    }
  }
  
  public static void a(String paramString1, final long paramLong, int paramInt1, final int paramInt2, final String paramString2, final int paramInt3)
  {
    AppMethodBeat.i(117789);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(315372);
        if (!Util.isNullOrNil((String)com.tencent.mm.kernel.h.baE().ban().d(68377, null))) {}
        for (int j = 1;; j = 0)
        {
          if (q.Qkk != null) {}
          for (int i = q.Qkk.dkF();; i = 0)
          {
            if (i > 0) {
              j = 2;
            }
            for (;;)
            {
              String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { as.this, Long.valueOf(paramLong), aj.gtA(), Integer.valueOf(this.NcG), Integer.valueOf(paramInt2), Integer.valueOf(paramString2), Long.valueOf(this.WpV), paramInt3, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.WpX) });
              Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "reportTopStoryRedDotKv 16654: ".concat(String.valueOf(str)));
              com.tencent.mm.plugin.report.f.Ozc.kvStat(16654, str);
              AppMethodBeat.o(315372);
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
    }, "ReportTopStoryRedDotKv");
    AppMethodBeat.o(117789);
  }
  
  public static void ate(int paramInt)
  {
    AppMethodBeat.i(117772);
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchVisit %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.f.Ozc.b(12041, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(aj.asY(0)) });
    AppMethodBeat.o(117772);
  }
  
  public static final void atf(int paramInt)
  {
    AppMethodBeat.i(117780);
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportIdKey649 %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(649L, paramInt, 1L, true);
    AppMethodBeat.o(117780);
  }
  
  public static void atg(int paramInt)
  {
    AppMethodBeat.i(315443);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        int j = 0;
        AppMethodBeat.i(315377);
        int[] arrayOfInt = new int[6];
        int[] tmp17_15 = arrayOfInt;
        tmp17_15[0] = 1;
        int[] tmp21_17 = tmp17_15;
        tmp21_17[1] = 0;
        int[] tmp25_21 = tmp21_17;
        tmp25_21[2] = 5;
        int[] tmp29_25 = tmp25_21;
        tmp29_25[3] = 6;
        int[] tmp34_29 = tmp29_25;
        tmp34_29[4] = 3;
        int[] tmp38_34 = tmp34_29;
        tmp38_34[5] = 9;
        tmp38_34;
        if (this.val$type == -1)
        {
          long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.acXw, 0L);
          if (cn.bDw() - l > 86400000L)
          {
            i = j;
            while (i < 6)
            {
              localub = new ub();
              localub.ixB = (i + 1);
              localub.jFz = aj.asY(arrayOfInt[i]);
              localub.bMH();
              as.a(localub);
              i += 1;
            }
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acXw, Long.valueOf(cn.bDw()));
          }
          AppMethodBeat.o(315377);
          return;
        }
        do
        {
          i += 1;
          if (i >= 6) {
            break;
          }
        } while (arrayOfInt[i] != this.val$type);
        ub localub = new ub();
        localub.ixB = (i + 1);
        localub.jFz = aj.asY(arrayOfInt[i]);
        localub.bMH();
        as.a(localub);
        AppMethodBeat.o(315377);
        return;
        AppMethodBeat.o(315377);
      }
    }, "WebSearchThread");
    AppMethodBeat.o(315443);
  }
  
  public static void b(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(315356);
    Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportGlobalTabClick type:%s, scene:%s, searchId:%s, isTabGuide:%s,sessionId:%s, redDotMsgId:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Boolean.FALSE, paramString2, paramString3 });
    com.tencent.mm.plugin.report.f.Ozc.b(12845, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(0), paramString2, paramString3 });
    AppMethodBeat.o(315356);
  }
  
  public static void bq(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117784);
    a(paramInt1, 3, paramInt2, paramInt3, "");
    AppMethodBeat.o(117784);
  }
  
  public static void dC(int paramInt, String paramString)
  {
    AppMethodBeat.i(117765);
    com.tencent.mm.plugin.report.f.Ozc.kvStat(paramInt, paramString);
    AppMethodBeat.o(117765);
  }
  
  public static void dD(int paramInt, String paramString)
  {
    AppMethodBeat.i(315334);
    WpR.scene = paramInt;
    WpR.WoG = 1;
    WpR.WpY = System.currentTimeMillis();
    WpR.WpZ = 0L;
    WpR.Lop = System.currentTimeMillis();
    WpR.hqS = 0L;
    WpR.lAr = false;
    WpR.sessionId = paramString;
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "initReport %d %d %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), paramString });
    AppMethodBeat.o(315334);
  }
  
  public static void dE(int paramInt, String paramString)
  {
    AppMethodBeat.i(117777);
    com.tencent.mm.plugin.report.f.Ozc.b(12070, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(aj.asY(0)), paramString, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0) });
    AppMethodBeat.o(117777);
  }
  
  public static void g(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(117778);
    com.tencent.mm.plugin.report.f.Ozc.b(13809, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(0), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(117778);
  }
  
  public static void iqj()
  {
    AppMethodBeat.i(117768);
    WpR.WpY = System.currentTimeMillis();
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "startH5Report %s", new Object[] { Long.valueOf(WpR.WpY) });
    AppMethodBeat.o(117768);
  }
  
  public static void iqk()
  {
    AppMethodBeat.i(117769);
    a locala = WpR;
    locala.WpZ += System.currentTimeMillis() - WpR.WpY;
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopH5Report %s", new Object[] { Long.valueOf(WpR.WpZ) });
    AppMethodBeat.o(117769);
  }
  
  public static void iql()
  {
    AppMethodBeat.i(117770);
    a locala = WpR;
    locala.hqS += System.currentTimeMillis() - WpR.Lop;
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopTotalReport %s", new Object[] { Long.valueOf(WpR.hqS) });
    AppMethodBeat.o(117770);
  }
  
  public static void iqm()
  {
    AppMethodBeat.i(117771);
    a locala = WpR;
    if (!locala.lAr)
    {
      com.tencent.mm.plugin.report.f.Ozc.b(12044, new Object[] { Integer.valueOf(locala.scene), Integer.valueOf(locala.WoG), Long.valueOf(locala.WpZ / 1000L), Long.valueOf(locala.hqS / 1000L) });
      locala.lAr = true;
    }
    Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportTime");
    AppMethodBeat.o(117771);
  }
  
  public static void nV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(315363);
    Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportFTSExpose sessionId:%s, exposeInfo:%s", new Object[] { paramString1, paramString2 });
    com.tencent.mm.plugin.report.f.Ozc.b(22369, new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(315363);
  }
  
  public static final void nb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117781);
    if (paramInt1 == 21) {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(649L, paramInt2, 1L, true);
    }
    AppMethodBeat.o(117781);
  }
  
  public static void nc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117782);
    W(paramInt1, paramInt2, "");
    AppMethodBeat.o(117782);
  }
  
  public static void s(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(315441);
    ug localug = new ug();
    localug.jFR = paramLong1;
    localug.ijA = paramLong2;
    localug.ixB = paramLong3;
    localug.bMH();
    a(localug);
    AppMethodBeat.o(315441);
  }
  
  public static void u(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117774);
    hm localhm = new hm();
    localhm.iuQ = localhm.F("Query", paramString.replace(',', ' '), true);
    localhm.iOF = paramInt1;
    localhm.iyq = paramInt2;
    localhm.iqr = paramInt3;
    localhm.iOG = 0L;
    localhm.bMH();
    Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "report12639 %s", new Object[] { localhm.aIF().replace("\r\n", " ") });
    AppMethodBeat.o(117774);
  }
  
  public static final class a
  {
    long Lop;
    int WoG;
    long WpY;
    long WpZ;
    long hqS;
    boolean lAr = true;
    int scene;
    String sessionId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.as
 * JD-Core Version:    0.7.0.1
 */