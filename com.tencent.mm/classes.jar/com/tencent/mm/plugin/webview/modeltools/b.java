package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class b
{
  public static String dcu()
  {
    AppMethodBeat.i(6916);
    Object localObject = new File(e.eQw.replace("/data/user/0", "/data/data"), "cityService/js");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new File(((File)localObject).getAbsoluteFile(), "analytics.js").getAbsolutePath();
    AppMethodBeat.o(6916);
    return localObject;
  }
  
  public static void o(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6917);
    Object localObject = null;
    try
    {
      paramString2 = URLEncoder.encode(bo.nullAsNil(paramString2), "UTF-8");
      h.qsU.e(15650, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(6917);
      return;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.CityServiceHelper", paramString2, "", new Object[0]);
        paramString2 = localObject;
      }
    }
  }
  
  public static void uB(int paramInt)
  {
    AppMethodBeat.i(6918);
    h.qsU.idkeyStat(894L, paramInt, 1L, false);
    AppMethodBeat.o(6918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.b
 * JD-Core Version:    0.7.0.1
 */