package com.tencent.thumbplayer.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.h.a;
import java.util.MissingFormatArgumentException;

public final class d
{
  private static h.a Mzi = null;
  private static int Mzj = 50;
  private static boolean cFS = true;
  
  private static void Z(int paramInt, String paramString1, String paramVarArgs)
  {
    AppMethodBeat.i(194842);
    int i = paramInt;
    if (paramInt == 20) {
      i = 10;
    }
    try
    {
      if (Mzi != null)
      {
        if (i <= Mzj)
        {
          aa(i, paramString1, paramVarArgs);
          AppMethodBeat.o(194842);
        }
      }
      else if ((cFS) && (i <= Mzj)) {
        Log.println(aig(i), paramString1, paramVarArgs);
      }
      AppMethodBeat.o(194842);
      return;
    }
    catch (MissingFormatArgumentException paramString1)
    {
      AppMethodBeat.o(194842);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(194842);
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      AppMethodBeat.o(194842);
    }
  }
  
  public static void a(h.a parama)
  {
    Mzi = parama;
  }
  
  private static void aa(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(194843);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(194843);
      return;
      Mzi.v(paramString1, paramString2);
      AppMethodBeat.o(194843);
      return;
      Mzi.d(paramString1, paramString2);
      AppMethodBeat.o(194843);
      return;
      Mzi.i(paramString1, paramString2);
      AppMethodBeat.o(194843);
      return;
      Mzi.w(paramString1, paramString2);
      AppMethodBeat.o(194843);
      return;
      Mzi.e(paramString1, paramString2);
    }
  }
  
  private static int aig(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 60: 
      return 2;
    case 50: 
      return 3;
    case 40: 
      return 4;
    case 20: 
      return 5;
    }
    return 6;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194836);
    Z(50, paramString1, paramString2);
    AppMethodBeat.o(194836);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194839);
    Z(10, paramString1, paramString2);
    AppMethodBeat.o(194839);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(194840);
    e(paramString, paramThrowable, "");
    AppMethodBeat.o(194840);
  }
  
  public static void e(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(194841);
    String str = "";
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2 + "\n";
    }
    paramString2 = str;
    if (paramThrowable != null) {
      paramString2 = str + Log.getStackTraceString(paramThrowable);
    }
    Z(10, paramString1, paramString2);
    AppMethodBeat.o(194841);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194837);
    Z(40, paramString1, paramString2);
    AppMethodBeat.o(194837);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194835);
    Z(60, paramString1, paramString2);
    AppMethodBeat.o(194835);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194838);
    Z(20, paramString1, paramString2);
    AppMethodBeat.o(194838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.d
 * JD-Core Version:    0.7.0.1
 */