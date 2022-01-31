package com.tencent.mm.plugin.websearch.api;

import android.net.Uri;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class ao
{
  private static ao.a qUW = new ao.a();
  
  public static void BE(int paramInt)
  {
    qUW.scene = paramInt;
    qUW.qTU = 1;
    qUW.qUX = System.currentTimeMillis();
    qUW.qUY = 0L;
    qUW.mtJ = System.currentTimeMillis();
    qUW.mrN = 0L;
    qUW.nHq = false;
    y.v("MicroMsg.WebSearch.WebSearchReportLogic", "initReport %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
  }
  
  public static void BF(int paramInt)
  {
    y.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchVisit %d", new Object[] { Integer.valueOf(paramInt) });
    f.nEG.f(12041, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(aa.Bs(0)) });
  }
  
  public static final void BG(int paramInt)
  {
    y.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportIdKey649 %d", new Object[] { Integer.valueOf(paramInt) });
    f.nEG.a(649L, paramInt, 1L, true);
  }
  
  public static final void Ry(String paramString)
  {
    y.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportWebSuggestClick %s", new Object[] { paramString });
    f.nEG.aC(12721, paramString);
  }
  
  public static void Z(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, 3, paramInt2, paramInt3, "");
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if (paramInt1 == 21) {}
    for (int i = aa.Bs(1);; i = aa.Bs(0))
    {
      f.nEG.f(14457, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    y.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
    f.nEG.f(12098, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(aa.Bs(0)), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2, Integer.valueOf(paramInt5) });
  }
  
  public static void a(int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    int i;
    if (paramBoolean1) {
      i = 3;
    }
    for (;;)
    {
      f.nEG.f(12042, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(paramInt2), bk.aM(paramString, "").replace(",", " ") });
      return;
      if (paramBoolean2) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    y.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchLocalPageExposure:");
    f.nEG.f(14663, new Object[] { Uri.encode(paramString1), paramString2, Long.valueOf(paramLong), paramString3, Integer.valueOf(3) });
  }
  
  public static void aS(int paramInt, String paramString)
  {
    f.nEG.aC(paramInt, paramString);
  }
  
  public static void aT(int paramInt, String paramString)
  {
    f.nEG.f(12070, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(aa.Bs(0)), paramString, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0) });
  }
  
  public static void aU(int paramInt, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("recnondocreport=1");
    localStringBuffer.append("&type=");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("&content=");
    localStringBuffer.append(paramString);
    y.i("MicroMsg.TopStory", "reportTopStoryRedDot 14791 %s", new Object[] { localStringBuffer.toString() });
    paramString = new blf();
    paramString.tEQ = localStringBuffer.toString();
    paramString = new w(paramString);
    g.Dk().a(paramString, 0);
  }
  
  public static void ag(String paramString1, String paramString2, String paramString3)
  {
    f.nEG.f(14752, new Object[] { Integer.valueOf(1), paramString1, paramString2, paramString3 });
  }
  
  public static void b(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    f.nEG.f(13810, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0) });
  }
  
  public static void bZM()
  {
    qUW.qUX = System.currentTimeMillis();
    y.v("MicroMsg.WebSearch.WebSearchReportLogic", "startH5Report %s", new Object[] { Long.valueOf(qUW.qUX) });
  }
  
  public static void bZN()
  {
    ao.a locala = qUW;
    locala.qUY += System.currentTimeMillis() - qUW.qUX;
    y.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopH5Report %s", new Object[] { Long.valueOf(qUW.qUY) });
  }
  
  public static void bZO()
  {
    ao.a locala = qUW;
    locala.mrN += System.currentTimeMillis() - qUW.mtJ;
    y.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopTotalReport %s", new Object[] { Long.valueOf(qUW.mrN) });
  }
  
  public static void bZP()
  {
    ao.a locala = qUW;
    if (!locala.nHq)
    {
      f.nEG.f(12044, new Object[] { Integer.valueOf(locala.scene), Integer.valueOf(locala.qTU), Long.valueOf(locala.qUY / 1000L), Long.valueOf(locala.mrN / 1000L) });
      locala.nHq = true;
    }
    y.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportTime");
  }
  
  public static void eB(int paramInt1, int paramInt2)
  {
    v(paramInt1, paramInt2, "");
  }
  
  public static void f(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    int i = 1;
    f localf = f.nEG;
    if (paramBoolean) {}
    for (;;)
    {
      localf.f(12845, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      return;
      i = 0;
    }
  }
  
  public static void f(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    y.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchLocalPageClick %s %s %d %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), paramString3 });
    f.nEG.f(14657, new Object[] { Uri.encode(paramString1), paramString2, Integer.valueOf(paramInt), paramString3, Integer.valueOf(3) });
  }
  
  public static void i(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    f.nEG.f(12639, new Object[] { bk.aM(paramString, "").replace(",", " "), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(paramInt3) });
  }
  
  public static final void reportIdKey649ForLook(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 21) {
      f.nEG.a(649L, paramInt2, 1L, true);
    }
  }
  
  public static void u(int paramInt1, int paramInt2, String paramString)
  {
    f(paramInt1, paramInt2, paramString, false);
  }
  
  public static void v(int paramInt1, int paramInt2, String paramString)
  {
    a(paramInt1, paramInt2, 0, 0, paramString);
  }
  
  public static void v(int paramInt, String paramString1, String paramString2)
  {
    f.nEG.f(13809, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ao
 * JD-Core Version:    0.7.0.1
 */