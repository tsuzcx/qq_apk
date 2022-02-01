package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class n
{
  public static void a(f paramf, String paramString, p paramp)
  {
    AppMethodBeat.i(297442);
    if (paramf == null)
    {
      AppMethodBeat.o(297442);
      return;
    }
    try
    {
      paramf = paramf.m(145, null);
      if (paramf == null)
      {
        AppMethodBeat.o(297442);
        return;
      }
    }
    catch (Exception paramf)
    {
      Log.e("kv_14993", String.valueOf(paramf));
      AppMethodBeat.o(297442);
      return;
    }
    String[] arrayOfString = paramf.getStringArray("key_webview_apbrand_jsapi_report_args");
    if ((arrayOfString == null) || (arrayOfString.length != 19))
    {
      AppMethodBeat.o(297442);
      return;
    }
    arrayOfString[10] = paramString;
    arrayOfString[11] = b(paramString, paramp);
    if ("true".equals(b(paramp, "isSuccess"))) {}
    for (paramf = "1";; paramf = "2")
    {
      arrayOfString[12] = paramf;
      arrayOfString[13] = b(paramp, "permissionValue");
      arrayOfString[14] = b(paramp, "jsapiErrorCode");
      h.OAn.b(14993, l(arrayOfString));
      AppMethodBeat.o(297442);
      return;
    }
  }
  
  public static String afS(String paramString)
  {
    AppMethodBeat.i(82064);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82064);
      return "";
    }
    try
    {
      paramString = Util.nullAsNil(r.cg(paramString));
      AppMethodBeat.o(82064);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(82064);
    }
    return "";
  }
  
  private static String b(p paramp, String paramString)
  {
    AppMethodBeat.i(297454);
    if ((paramp.WEJ == null) || (!paramp.WEJ.containsKey(paramString)))
    {
      AppMethodBeat.o(297454);
      return "";
    }
    paramp = String.valueOf(paramp.WEJ.get(paramString));
    AppMethodBeat.o(297454);
    return paramp;
  }
  
  private static String b(String paramString, p paramp)
  {
    AppMethodBeat.i(297449);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(297449);
        return "";
        if (paramString.equals("getBrandWCPayRequest")) {
          i = 0;
        }
        break;
      }
    }
    paramString = paramp.params.get("package").toString();
    AppMethodBeat.o(297449);
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
            localObject1 = afS((String)localObject2);
          }
        }
      }
    }
    AppMethodBeat.o(82065);
    return arrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.n
 * JD-Core Version:    0.7.0.1
 */