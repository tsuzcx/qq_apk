package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URLEncoder;

public final class h
{
  public static void a(int paramInt, long paramLong, a parama, b paramb)
  {
    int i = 4;
    AppMethodBeat.i(197752);
    switch (paramInt)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      String str1 = "";
      String str2 = "";
      if (parama != null) {}
      try
      {
        str1 = axM(parama.dFy);
        parama = str2;
        if (paramb != null) {
          parama = bt.nullAsNil(paramb.zeg);
        }
        ad.i("SnsAdReportAnalyseUtils", "reportAdDel: snsId = " + paramLong + ", uxInfo = " + str1 + ", adExtInfo = " + parama + ", reportType = " + i + ", extInfo = " + "");
        g.yhR.f(19553, new Object[] { Long.valueOf(paramLong), str1, parama, Integer.valueOf(i), "" });
        AppMethodBeat.o(197752);
        return;
      }
      catch (Throwable parama)
      {
        ad.e("SnsAdReportAnalyseUtils", parama.toString());
        AppMethodBeat.o(197752);
      }
      AppMethodBeat.o(197752);
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 7;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(197753);
    try
    {
      ad.i("SnsAdReportAnalyseUtils", "snsId = " + paramString1 + ", uxInfo = " + paramString3 + ", adExtInfo = " + paramString4 + ", appId = " + paramString2 + ", reportType = " + paramInt1 + ", reportScene = " + paramInt2 + ", reportOrigin = " + paramInt3);
      g.yhR.f(19693, new Object[] { Long.valueOf(System.currentTimeMillis()), paramString1, axM(paramString3), paramString4, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      AppMethodBeat.o(197753);
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("SnsAdReportAnalyseUtils", paramString1.toString());
      AppMethodBeat.o(197753);
    }
  }
  
  public static String axM(String paramString)
  {
    AppMethodBeat.i(197754);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(197754);
      return "";
    }
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      paramString = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("SnsAdReportAnalyseUtils", localException.toString());
      }
    }
    AppMethodBeat.o(197754);
    return paramString;
  }
  
  public static void d(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(197751);
    try
    {
      paramString1 = new a(paramString1);
      paramString2 = new b(paramString2);
      paramString1 = axM(paramString1.dFy);
      paramString2 = bt.nullAsNil(paramString2.zeg);
      ad.i("SnsAdReportAnalyseUtils", "reportAdPull: snsId = " + paramLong + ", uxInfo = " + paramString1 + ", adExtInfo = " + paramString2 + ", reportType = 1, extInfo = " + "");
      g.yhR.f(19553, new Object[] { Long.valueOf(paramLong), paramString1, paramString2, Integer.valueOf(1), "" });
      AppMethodBeat.o(197751);
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("SnsAdReportAnalyseUtils", paramString1.toString());
      AppMethodBeat.o(197751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.h
 * JD-Core Version:    0.7.0.1
 */