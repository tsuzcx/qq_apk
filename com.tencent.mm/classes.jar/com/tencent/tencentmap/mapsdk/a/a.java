package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private static Boolean a;
  
  static
  {
    AppMethodBeat.i(181496);
    a = Boolean.FALSE;
    AppMethodBeat.o(181496);
  }
  
  public static void a(String paramString)
  {
    AppMethodBeat.i(186410);
    a(null, paramString, 'v');
    AppMethodBeat.o(186410);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186408);
    a(paramString1, paramString2, 'e');
    AppMethodBeat.o(186408);
  }
  
  private static void a(String paramString1, String paramString2, char paramChar)
  {
    AppMethodBeat.i(186411);
    if (!a.booleanValue())
    {
      AppMethodBeat.o(186411);
      return;
    }
    TextUtils.isEmpty(paramString1);
    AppMethodBeat.o(186411);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186409);
    a(paramString1, paramString2, 'v');
    AppMethodBeat.o(186409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.a
 * JD-Core Version:    0.7.0.1
 */