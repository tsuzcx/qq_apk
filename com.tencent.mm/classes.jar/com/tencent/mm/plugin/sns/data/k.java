package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;

public final class k
{
  public static void a(int paramInt, long paramLong, ADInfo paramADInfo, ADXml paramADXml)
  {
    int i = 4;
    AppMethodBeat.i(306369);
    switch (paramInt)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      String str1 = "";
      String str2 = "";
      if (paramADInfo != null) {}
      try
      {
        str1 = aXd(paramADInfo.uxInfo);
        paramADInfo = str2;
        if (paramADXml != null) {
          paramADInfo = Util.nullAsNil(paramADXml.adExtInfo);
        }
        Log.i("SnsAdReportAnalyseUtils", "reportAdDel: snsId = " + t.uA(paramLong) + ", uxInfo = " + str1 + ", adExtInfo = " + paramADInfo + ", reportType = " + i + ", extInfo = " + "");
        h.OAn.b(19553, new Object[] { Long.valueOf(paramLong), str1, paramADInfo, Integer.valueOf(i), "" });
        AppMethodBeat.o(306369);
        return;
      }
      finally
      {
        Log.e("SnsAdReportAnalyseUtils", paramADInfo.toString());
        AppMethodBeat.o(306369);
      }
      AppMethodBeat.o(306369);
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
    AppMethodBeat.i(306374);
    try
    {
      Log.i("SnsAdReportAnalyseUtils", "snsId = " + paramString1 + ", uxInfo = " + paramString3 + ", adExtInfo = " + paramString4 + ", appId = " + paramString2 + ", reportType = " + paramInt1 + ", reportScene = " + paramInt2 + ", reportOrigin = " + paramInt3);
      h.OAn.b(19693, new Object[] { Long.valueOf(System.currentTimeMillis()), paramString1, aXd(paramString3), paramString4, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      AppMethodBeat.o(306374);
      return;
    }
    finally
    {
      Log.e("SnsAdReportAnalyseUtils", paramString1.toString());
      AppMethodBeat.o(306374);
    }
  }
  
  public static String aXd(String paramString)
  {
    AppMethodBeat.i(306381);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(306381);
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
        Log.e("SnsAdReportAnalyseUtils", localException.toString());
      }
    }
    AppMethodBeat.o(306381);
    return paramString;
  }
  
  public static void g(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(306362);
    try
    {
      paramString1 = new ADInfo(paramString1);
      paramString2 = new ADXml(paramString2);
      paramString1 = aXd(paramString1.uxInfo);
      paramString2 = Util.nullAsNil(paramString2.adExtInfo);
      Log.i("SnsAdReportAnalyseUtils", "reportAdPull: snsId = " + paramLong + ", uxInfo = " + paramString1 + ", adExtInfo = " + paramString2 + ", reportType = 1, extInfo = " + "");
      h.OAn.b(19553, new Object[] { Long.valueOf(paramLong), paramString1, paramString2, Integer.valueOf(1), "" });
      AppMethodBeat.o(306362);
      return;
    }
    finally
    {
      Log.e("SnsAdReportAnalyseUtils", paramString1.toString());
      AppMethodBeat.o(306362);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.k
 * JD-Core Version:    0.7.0.1
 */