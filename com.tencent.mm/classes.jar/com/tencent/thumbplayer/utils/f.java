package com.tencent.thumbplayer.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.h.a;
import java.util.MissingFormatArgumentException;

public final class f
{
  private static h.a Kmo = null;
  private static int Kmp = 50;
  private static boolean cuo = true;
  
  private static void W(int paramInt, String paramString1, String paramVarArgs)
  {
    AppMethodBeat.i(188239);
    int i = paramInt;
    if (paramInt == 20) {
      i = 10;
    }
    try
    {
      if (Kmo != null)
      {
        if (i <= Kmp)
        {
          X(i, paramString1, paramVarArgs);
          AppMethodBeat.o(188239);
        }
      }
      else if ((cuo) && (i <= Kmp)) {
        Log.println(aeX(i), paramString1, paramVarArgs);
      }
      AppMethodBeat.o(188239);
      return;
    }
    catch (MissingFormatArgumentException paramString1)
    {
      AppMethodBeat.o(188239);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(188239);
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      AppMethodBeat.o(188239);
    }
  }
  
  private static void X(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(188240);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(188240);
      return;
      Kmo.v(paramString1, paramString2);
      AppMethodBeat.o(188240);
      return;
      Kmo.d(paramString1, paramString2);
      AppMethodBeat.o(188240);
      return;
      Kmo.i(paramString1, paramString2);
      AppMethodBeat.o(188240);
      return;
      Kmo.w(paramString1, paramString2);
      AppMethodBeat.o(188240);
      return;
      Kmo.e(paramString1, paramString2);
    }
  }
  
  public static void a(h.a parama)
  {
    Kmo = parama;
  }
  
  private static int aeX(int paramInt)
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
    AppMethodBeat.i(188233);
    W(50, paramString1, paramString2);
    AppMethodBeat.o(188233);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188236);
    W(10, paramString1, paramString2);
    AppMethodBeat.o(188236);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(188237);
    e(paramString, paramThrowable, "");
    AppMethodBeat.o(188237);
  }
  
  public static void e(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(188238);
    String str = "";
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2 + "\n";
    }
    paramString2 = str;
    if (paramThrowable != null) {
      paramString2 = str + Log.getStackTraceString(paramThrowable);
    }
    W(10, paramString1, paramString2);
    AppMethodBeat.o(188238);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188234);
    W(40, paramString1, paramString2);
    AppMethodBeat.o(188234);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188232);
    W(60, paramString1, paramString2);
    AppMethodBeat.o(188232);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188235);
    W(20, paramString1, paramString2);
    AppMethodBeat.o(188235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.f
 * JD-Core Version:    0.7.0.1
 */