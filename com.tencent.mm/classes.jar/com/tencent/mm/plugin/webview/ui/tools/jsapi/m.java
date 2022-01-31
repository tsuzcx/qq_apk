package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class m
{
  private static String EG(String paramString)
  {
    AppMethodBeat.i(9858);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(9858);
      return "";
    }
    try
    {
      paramString = bo.nullAsNil(q.encode(paramString));
      AppMethodBeat.o(9858);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(9858);
    }
    return "";
  }
  
  private static String a(i parami, String paramString)
  {
    AppMethodBeat.i(9857);
    if ((parami.vrP == null) || (!parami.vrP.containsKey(paramString)))
    {
      AppMethodBeat.o(9857);
      return "";
    }
    parami = String.valueOf(parami.vrP.get(paramString));
    AppMethodBeat.o(9857);
    return parami;
  }
  
  public static void a(e parame, String paramString, i parami)
  {
    AppMethodBeat.i(9855);
    if (parame == null)
    {
      AppMethodBeat.o(9855);
      return;
    }
    try
    {
      parame = parame.i(145, null);
      if (parame == null)
      {
        AppMethodBeat.o(9855);
        return;
      }
    }
    catch (Exception parame)
    {
      ab.e("kv_14993", String.valueOf(parame));
      AppMethodBeat.o(9855);
      return;
    }
    String[] arrayOfString = parame.getStringArray("key_webview_apbrand_jsapi_report_args");
    if ((arrayOfString == null) || (arrayOfString.length != 19))
    {
      AppMethodBeat.o(9855);
      return;
    }
    arrayOfString[10] = paramString;
    arrayOfString[11] = b(paramString, parami);
    if ("true".equals(a(parami, "isSuccess"))) {}
    for (parame = "1";; parame = "2")
    {
      arrayOfString[12] = parame;
      arrayOfString[13] = a(parami, "permissionValue");
      arrayOfString[14] = a(parami, "jsapiErrorCode");
      h.qsU.e(14993, k(arrayOfString));
      AppMethodBeat.o(9855);
      return;
    }
  }
  
  private static String b(String paramString, i parami)
  {
    AppMethodBeat.i(9856);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(9856);
        return "";
        if (paramString.equals("getBrandWCPayRequest")) {
          i = 0;
        }
        break;
      }
    }
    paramString = parami.pJb.get("package").toString();
    AppMethodBeat.o(9856);
    return paramString;
  }
  
  private static Object[] k(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(9859);
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0))
    {
      AppMethodBeat.o(9859);
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
            localObject1 = EG((String)localObject2);
          }
        }
      }
    }
    AppMethodBeat.o(9859);
    return arrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.m
 * JD-Core Version:    0.7.0.1
 */