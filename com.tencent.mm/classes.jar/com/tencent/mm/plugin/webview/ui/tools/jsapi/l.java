package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class l
{
  public static void a(f paramf, String paramString, n paramn)
  {
    AppMethodBeat.i(217145);
    if (paramf == null)
    {
      AppMethodBeat.o(217145);
      return;
    }
    try
    {
      paramf = paramf.l(145, null);
      if (paramf == null)
      {
        AppMethodBeat.o(217145);
        return;
      }
    }
    catch (Exception paramf)
    {
      Log.e("kv_14993", String.valueOf(paramf));
      AppMethodBeat.o(217145);
      return;
    }
    String[] arrayOfString = paramf.getStringArray("key_webview_apbrand_jsapi_report_args");
    if ((arrayOfString == null) || (arrayOfString.length != 19))
    {
      AppMethodBeat.o(217145);
      return;
    }
    arrayOfString[10] = paramString;
    arrayOfString[11] = b(paramString, paramn);
    if ("true".equals(b(paramn, "isSuccess"))) {}
    for (paramf = "1";; paramf = "2")
    {
      arrayOfString[12] = paramf;
      arrayOfString[13] = b(paramn, "permissionValue");
      arrayOfString[14] = b(paramn, "jsapiErrorCode");
      h.IzE.a(14993, j(arrayOfString));
      AppMethodBeat.o(217145);
      return;
    }
  }
  
  private static String amF(String paramString)
  {
    AppMethodBeat.i(82064);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82064);
      return "";
    }
    try
    {
      paramString = Util.nullAsNil(q.aT(paramString));
      AppMethodBeat.o(82064);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(82064);
    }
    return "";
  }
  
  private static String b(n paramn, String paramString)
  {
    AppMethodBeat.i(217150);
    if ((paramn.POw == null) || (!paramn.POw.containsKey(paramString)))
    {
      AppMethodBeat.o(217150);
      return "";
    }
    paramn = String.valueOf(paramn.POw.get(paramString));
    AppMethodBeat.o(217150);
    return paramn;
  }
  
  private static String b(String paramString, n paramn)
  {
    AppMethodBeat.i(217149);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(217149);
        return "";
        if (paramString.equals("getBrandWCPayRequest")) {
          i = 0;
        }
        break;
      }
    }
    paramString = paramn.params.get("package").toString();
    AppMethodBeat.o(217149);
    return paramString;
  }
  
  private static Object[] j(Object[] paramArrayOfObject)
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
            localObject1 = amF((String)localObject2);
          }
        }
      }
    }
    AppMethodBeat.o(82065);
    return arrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.l
 * JD-Core Version:    0.7.0.1
 */