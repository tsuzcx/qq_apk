package com.tencent.thumbplayer.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.h.a;
import java.util.MissingFormatArgumentException;

public final class d
{
  private static h.a Mcn = null;
  private static int Mco = 50;
  private static boolean cFj = true;
  
  private static void Z(int paramInt, String paramString1, String paramVarArgs)
  {
    AppMethodBeat.i(192164);
    int i = paramInt;
    if (paramInt == 20) {
      i = 10;
    }
    try
    {
      if (Mcn != null)
      {
        if (i <= Mco)
        {
          aa(i, paramString1, paramVarArgs);
          AppMethodBeat.o(192164);
        }
      }
      else if ((cFj) && (i <= Mco)) {
        Log.println(ahx(i), paramString1, paramVarArgs);
      }
      AppMethodBeat.o(192164);
      return;
    }
    catch (MissingFormatArgumentException paramString1)
    {
      AppMethodBeat.o(192164);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(192164);
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      AppMethodBeat.o(192164);
    }
  }
  
  public static void a(h.a parama)
  {
    Mcn = parama;
  }
  
  private static void aa(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(192165);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192165);
      return;
      Mcn.v(paramString1, paramString2);
      AppMethodBeat.o(192165);
      return;
      Mcn.d(paramString1, paramString2);
      AppMethodBeat.o(192165);
      return;
      Mcn.i(paramString1, paramString2);
      AppMethodBeat.o(192165);
      return;
      Mcn.w(paramString1, paramString2);
      AppMethodBeat.o(192165);
      return;
      Mcn.e(paramString1, paramString2);
    }
  }
  
  private static int ahx(int paramInt)
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
    AppMethodBeat.i(192158);
    Z(50, paramString1, paramString2);
    AppMethodBeat.o(192158);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192161);
    Z(10, paramString1, paramString2);
    AppMethodBeat.o(192161);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(192162);
    e(paramString, paramThrowable, "");
    AppMethodBeat.o(192162);
  }
  
  public static void e(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(192163);
    String str = "";
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2 + "\n";
    }
    paramString2 = str;
    if (paramThrowable != null) {
      paramString2 = str + Log.getStackTraceString(paramThrowable);
    }
    Z(10, paramString1, paramString2);
    AppMethodBeat.o(192163);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192159);
    Z(40, paramString1, paramString2);
    AppMethodBeat.o(192159);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192157);
    Z(60, paramString1, paramString2);
    AppMethodBeat.o(192157);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192160);
    Z(20, paramString1, paramString2);
    AppMethodBeat.o(192160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.d
 * JD-Core Version:    0.7.0.1
 */