package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class b
{
  public static void Ci(int paramInt)
  {
    h.nFQ.a(894L, paramInt, 1L, false);
  }
  
  public static String ccD()
  {
    File localFile = new File(e.dOQ.replace("/data/user/0", "/data/data"), "cityService/js");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getAbsoluteFile(), "analytics.js").getAbsolutePath();
  }
  
  public static void o(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    try
    {
      paramString2 = URLEncoder.encode(bk.pm(paramString2), "UTF-8");
      h.nFQ.f(15650, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.CityServiceHelper", paramString2, "", new Object[0]);
        paramString2 = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.b
 * JD-Core Version:    0.7.0.1
 */