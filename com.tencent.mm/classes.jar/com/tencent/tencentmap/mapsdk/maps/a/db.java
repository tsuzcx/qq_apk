package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class db
{
  private static boolean a = true;
  private static boolean b = true;
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    AppMethodBeat.i(147408);
    ag.a(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean, 1);
    AppMethodBeat.o(147408);
  }
  
  public static boolean a(String paramString, int paramInt, Map<String, String> paramMap)
  {
    AppMethodBeat.i(147410);
    boolean bool;
    if (paramInt == ac.c()) {
      if ((a) && (("HLReqRspEvent".equals(paramString)) || ("HLHttpAgent".equals(paramString))))
      {
        a = false;
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(147410);
      return bool;
      if ((b) && ("HLHttpDirect".equals(paramString)))
      {
        paramString = (String)paramMap.get("B15");
        if ((!dd.a(paramString)) && (paramString.equals("app")))
        {
          b = false;
          bool = true;
          continue;
        }
      }
      bool = false;
    }
  }
  
  public static void b(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    AppMethodBeat.i(147409);
    ag.a(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean);
    AppMethodBeat.o(147409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.db
 * JD-Core Version:    0.7.0.1
 */