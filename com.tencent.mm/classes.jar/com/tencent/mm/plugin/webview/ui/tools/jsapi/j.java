package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.c.l;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public final class j
{
  private static String UW(String paramString)
  {
    AppMethodBeat.i(82064);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82064);
      return "";
    }
    try
    {
      paramString = bu.nullAsNil(q.encode(paramString));
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
    AppMethodBeat.i(199108);
    if ((paraml.EfA == null) || (!paraml.EfA.containsKey(paramString)))
    {
      AppMethodBeat.o(199108);
      return "";
    }
    paraml = String.valueOf(paraml.EfA.get(paramString));
    AppMethodBeat.o(199108);
    return paraml;
  }
  
  public static void a(f paramf, String paramString, l paraml)
  {
    AppMethodBeat.i(199106);
    if (paramf == null)
    {
      AppMethodBeat.o(199106);
      return;
    }
    try
    {
      paramf = paramf.k(145, null);
      if (paramf == null)
      {
        AppMethodBeat.o(199106);
        return;
      }
    }
    catch (Exception paramf)
    {
      ae.e("kv_14993", String.valueOf(paramf));
      AppMethodBeat.o(199106);
      return;
    }
    String[] arrayOfString = paramf.getStringArray("key_webview_apbrand_jsapi_report_args");
    if ((arrayOfString == null) || (arrayOfString.length != 19))
    {
      AppMethodBeat.o(199106);
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
      g.yxI.f(14993, k(arrayOfString));
      AppMethodBeat.o(199106);
      return;
    }
  }
  
  private static String b(String paramString, l paraml)
  {
    AppMethodBeat.i(199107);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(199107);
        return "";
        if (paramString.equals("getBrandWCPayRequest")) {
          i = 0;
        }
        break;
      }
    }
    paramString = paraml.xqN.get("package").toString();
    AppMethodBeat.o(199107);
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
            localObject1 = UW((String)localObject2);
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