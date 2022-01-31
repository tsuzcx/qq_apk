package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

public final class m
{
  static String a(i parami, String paramString)
  {
    if ((parami.rAN == null) || (!parami.rAN.containsKey(paramString))) {
      return "";
    }
    return String.valueOf(parami.rAN.get(paramString));
  }
  
  public static Object[] j(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0)) {
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
            localObject1 = wb((String)localObject2);
          }
        }
      }
    }
    return arrayOfObject;
  }
  
  private static String wb(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    try
    {
      paramString = bk.pm(q.encode(paramString));
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.m
 * JD-Core Version:    0.7.0.1
 */