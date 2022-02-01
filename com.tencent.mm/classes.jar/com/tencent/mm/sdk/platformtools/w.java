package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class w
{
  public static Map<String, String> aQo(String paramString)
  {
    AppMethodBeat.i(157563);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(157563);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("\n");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramString[i];
      if ((localObject1 != null) && (localObject1.length() > 0))
      {
        Object localObject2 = localObject1.trim().split("=", 2);
        if ((localObject2 != null) && (localObject2.length >= 2))
        {
          localObject1 = localObject2[0];
          localObject2 = localObject2[1];
          if ((localObject1 != null) && (localObject1.length() > 0) && (localObject1.matches("^[a-zA-Z0-9_.]*"))) {
            localHashMap.put(localObject1, localObject2);
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(157563);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.w
 * JD-Core Version:    0.7.0.1
 */