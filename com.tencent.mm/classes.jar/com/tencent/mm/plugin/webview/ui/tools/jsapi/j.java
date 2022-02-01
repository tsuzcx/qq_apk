package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.l;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public final class j
{
  private static String QF(String paramString)
  {
    AppMethodBeat.i(82064);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82064);
      return "";
    }
    try
    {
      paramString = bs.nullAsNil(p.encode(paramString));
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
    AppMethodBeat.i(189248);
    if ((paraml.Ckw == null) || (!paraml.Ckw.containsKey(paramString)))
    {
      AppMethodBeat.o(189248);
      return "";
    }
    paraml = String.valueOf(paraml.Ckw.get(paramString));
    AppMethodBeat.o(189248);
    return paraml;
  }
  
  public static void a(f paramf, String paramString, l paraml)
  {
    AppMethodBeat.i(189246);
    if (paramf == null)
    {
      AppMethodBeat.o(189246);
      return;
    }
    try
    {
      paramf = paramf.k(145, null);
      if (paramf == null)
      {
        AppMethodBeat.o(189246);
        return;
      }
    }
    catch (Exception paramf)
    {
      ac.e("kv_14993", String.valueOf(paramf));
      AppMethodBeat.o(189246);
      return;
    }
    String[] arrayOfString = paramf.getStringArray("key_webview_apbrand_jsapi_report_args");
    if ((arrayOfString == null) || (arrayOfString.length != 19))
    {
      AppMethodBeat.o(189246);
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
      h.wUl.f(14993, l(arrayOfString));
      AppMethodBeat.o(189246);
      return;
    }
  }
  
  private static String b(String paramString, l paraml)
  {
    AppMethodBeat.i(189247);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(189247);
        return "";
        if (paramString.equals("getBrandWCPayRequest")) {
          i = 0;
        }
        break;
      }
    }
    paramString = paraml.vUl.get("package").toString();
    AppMethodBeat.o(189247);
    return paramString;
  }
  
  private static Object[] l(Object[] paramArrayOfObject)
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
            localObject1 = QF((String)localObject2);
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