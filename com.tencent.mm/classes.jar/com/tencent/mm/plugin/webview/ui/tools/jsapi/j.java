package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.l;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class j
{
  private static String Mw(String paramString)
  {
    AppMethodBeat.i(82064);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82064);
      return "";
    }
    try
    {
      paramString = bt.nullAsNil(p.encode(paramString));
      AppMethodBeat.o(82064);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(82064);
    }
    return "";
  }
  
  private static String a(l paraml, String paramString)
  {
    AppMethodBeat.i(188681);
    if ((paraml.ASj == null) || (!paraml.ASj.containsKey(paramString)))
    {
      AppMethodBeat.o(188681);
      return "";
    }
    paraml = String.valueOf(paraml.ASj.get(paramString));
    AppMethodBeat.o(188681);
    return paraml;
  }
  
  public static void a(f paramf, String paramString, l paraml)
  {
    AppMethodBeat.i(188679);
    if (paramf == null)
    {
      AppMethodBeat.o(188679);
      return;
    }
    try
    {
      paramf = paramf.j(145, null);
      if (paramf == null)
      {
        AppMethodBeat.o(188679);
        return;
      }
    }
    catch (Exception paramf)
    {
      ad.e("kv_14993", String.valueOf(paramf));
      AppMethodBeat.o(188679);
      return;
    }
    String[] arrayOfString = paramf.getStringArray("key_webview_apbrand_jsapi_report_args");
    if ((arrayOfString == null) || (arrayOfString.length != 19))
    {
      AppMethodBeat.o(188679);
      return;
    }
    arrayOfString[10] = paramString;
    arrayOfString[11] = b(paramString, paraml);
    if ("true".equals(a(paraml, "isSuccess"))) {}
    for (paramf = "1";; paramf = "2")
    {
      arrayOfString[12] = paramf;
      arrayOfString[13] = a(paraml, "permissionValue");
      arrayOfString[14] = a(paraml, "jsapiErrorCode");
      h.vKh.f(14993, k(arrayOfString));
      AppMethodBeat.o(188679);
      return;
    }
  }
  
  private static String b(String paramString, l paraml)
  {
    AppMethodBeat.i(188680);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(188680);
        return "";
        if (paramString.equals("getBrandWCPayRequest")) {
          i = 0;
        }
        break;
      }
    }
    paramString = paraml.uLu.get("package").toString();
    AppMethodBeat.o(188680);
    return paramString;
  }
  
  private static Object[] k(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(82065);
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0))
    {
      AppMethodBeat.o(82065);
      return new Object[0];
    }
    Object[] arrayOfObject = new Object[paramArrayOfObject.length];
    int k = paramArrayOfObject.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      Object localObject2 = paramArrayOfObject[j];
      Object localObject1;
      if (localObject2 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        arrayOfObject[i] = String.valueOf(localObject1);
        j += 1;
        i += 1;
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof String)) {
          if (!((String)localObject2).contains(","))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).contains("/")) {}
          }
          else
          {
            localObject1 = Mw((String)localObject2);
          }
        }
      }
    }
    AppMethodBeat.o(82065);
    return arrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.j
 * JD-Core Version:    0.7.0.1
 */