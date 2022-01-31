package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class h
{
  private static Boolean a;
  
  static
  {
    AppMethodBeat.i(101149);
    a = Boolean.FALSE;
    AppMethodBeat.o(101149);
  }
  
  public static void a(String paramString)
  {
    AppMethodBeat.i(150433);
    a(null, paramString, 'e');
    AppMethodBeat.o(150433);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150432);
    a(paramString1, paramString2, 'v');
    AppMethodBeat.o(150432);
  }
  
  private static void a(String paramString1, String paramString2, char paramChar)
  {
    AppMethodBeat.i(150434);
    if (!a.booleanValue())
    {
      AppMethodBeat.o(150434);
      return;
    }
    TextUtils.isEmpty(paramString1);
    AppMethodBeat.o(150434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.h
 * JD-Core Version:    0.7.0.1
 */