package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class gm
{
  public static String a(Map<String, String> paramMap)
  {
    AppMethodBeat.i(148009);
    paramMap = a(paramMap, "ISO-8859-1");
    AppMethodBeat.o(148009);
    return paramMap;
  }
  
  public static String a(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(148008);
    paramMap = (String)paramMap.get("Content-Type");
    if (paramMap != null)
    {
      paramMap = paramMap.split(";");
      int i = 1;
      while (i < paramMap.length)
      {
        String[] arrayOfString = paramMap[i].trim().split("=");
        if ((arrayOfString.length == 2) && (arrayOfString[0].equals("charset")))
        {
          paramMap = arrayOfString[1];
          AppMethodBeat.o(148008);
          return paramMap;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(148008);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gm
 * JD-Core Version:    0.7.0.1
 */