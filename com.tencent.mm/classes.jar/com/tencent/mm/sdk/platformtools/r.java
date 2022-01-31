package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.Map;

public final class r
{
  public static Map<String, String> Zf(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0))
    {
      paramString = null;
      return paramString;
    }
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = paramString.split("\n");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = localHashMap;
      if (i >= j) {
        break;
      }
      paramString = arrayOfString[i];
      if ((paramString != null) && (paramString.length() > 0))
      {
        Object localObject = paramString.trim().split("=", 2);
        if ((localObject != null) && (localObject.length >= 2))
        {
          paramString = localObject[0];
          localObject = localObject[1];
          if ((paramString != null) && (paramString.length() > 0) && (paramString.matches("^[a-zA-Z0-9_.]*"))) {
            localHashMap.put(paramString, localObject);
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.r
 * JD-Core Version:    0.7.0.1
 */