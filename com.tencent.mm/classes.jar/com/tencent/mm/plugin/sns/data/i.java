package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URLEncoder;

public final class i
{
  public static void a(int paramInt, long paramLong, a parama, b paramb)
  {
    int i = 4;
    AppMethodBeat.i(219235);
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
        str1 = azd(parama.dGD);
        parama = str2;
        if (paramb != null) {
          parama = bu.nullAsNil(paramb.zsJ);
        }
        ae.i("SnsAdReportAnalyseUtils", "reportAdDel: snsId = " + r.zV(paramLong) + ", uxInfo = " + str1 + ", adExtInfo = " + parama + ", reportType = " + i + ", extInfo = " + "");
        g.yxI.f(19553, new Object[] { Long.valueOf(paramLong), str1, parama, Integer.valueOf(i), "" });
        AppMethodBeat.o(219235);
        return;
      }
      catch (Throwable parama)
      {
        ae.e("SnsAdReportAnalyseUtils", parama.toString());
        AppMethodBeat.o(219235);
      }
      AppMethodBeat.o(219235);
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
    AppMethodBeat.i(219236);
    try
    {
      ae.i("SnsAdReportAnalyseUtils", "snsId = " + paramString1 + ", uxInfo = " + paramString3 + ", adExtInfo = " + paramString4 + ", appId = " + paramString2 + ", reportType = " + paramInt1 + ", reportScene = " + paramInt2 + ", reportOrigin = " + paramInt3);
      g.yxI.f(19693, new Object[] { Long.valueOf(System.currentTimeMillis()), paramString1, azd(paramString3), paramString4, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      AppMethodBeat.o(219236);
      return;
    }
    catch (Throwable paramString1)
    {
      ae.e("SnsAdReportAnalyseUtils", paramString1.toString());
      AppMethodBeat.o(219236);
    }
  }
  
  public static String azd(String paramString)
  {
    AppMethodBeat.i(219237);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(219237);
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
        ae.e("SnsAdReportAnalyseUtils", localException.toString());
      }
    }
    AppMethodBeat.o(219237);
    return paramString;
  }
  
  public static void d(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219234);
    try
    {
      paramString1 = new a(paramString1);
      paramString2 = new b(paramString2);
      paramString1 = azd(paramString1.dGD);
      paramString2 = bu.nullAsNil(paramString2.zsJ);
      ae.i("SnsAdReportAnalyseUtils", "reportAdPull: snsId = " + paramLong + ", uxInfo = " + paramString1 + ", adExtInfo = " + paramString2 + ", reportType = 1, extInfo = " + "");
      g.yxI.f(19553, new Object[] { Long.valueOf(paramLong), paramString1, paramString2, Integer.valueOf(1), "" });
      AppMethodBeat.o(219234);
      return;
    }
    catch (Throwable paramString1)
    {
      ae.e("SnsAdReportAnalyseUtils", paramString1.toString());
      AppMethodBeat.o(219234);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.i
 * JD-Core Version:    0.7.0.1
 */