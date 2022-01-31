package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class fr
{
  private static Boolean a = Boolean.FALSE;
  
  public static void a(String paramString)
  {
    AppMethodBeat.i(147959);
    a(null, paramString, 'e');
    AppMethodBeat.o(147959);
  }
  
  private static void a(String paramString1, String paramString2, char paramChar)
  {
    AppMethodBeat.i(147961);
    if (('e' != paramChar) && (!a.booleanValue()))
    {
      AppMethodBeat.o(147961);
      return;
    }
    TextUtils.isEmpty(paramString1);
    AppMethodBeat.o(147961);
  }
  
  public static void b(String paramString)
  {
    AppMethodBeat.i(147960);
    a(null, paramString, 'v');
    AppMethodBeat.o(147960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fr
 * JD-Core Version:    0.7.0.1
 */