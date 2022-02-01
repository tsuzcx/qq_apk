package com.tencent.thumbplayer.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener;
import java.util.MissingFormatArgumentException;

public final class g
{
  private static TPPlayerMgr.OnLogListener ahMY = null;
  private static int ahMZ = 50;
  private static boolean eYL = true;
  
  private static int aIg(int paramInt)
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
  
  private static void aj(int paramInt, String paramString1, String paramVarArgs)
  {
    AppMethodBeat.i(227167);
    int i = paramInt;
    if (paramInt == 20) {
      i = 10;
    }
    try
    {
      if (ahMY != null)
      {
        if (i <= ahMZ)
        {
          ak(i, paramString1, paramVarArgs);
          AppMethodBeat.o(227167);
        }
      }
      else if ((eYL) && (i <= ahMZ)) {
        Log.println(aIg(i), paramString1, paramVarArgs);
      }
      AppMethodBeat.o(227167);
      return;
    }
    catch (MissingFormatArgumentException paramString1)
    {
      AppMethodBeat.o(227167);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(227167);
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      AppMethodBeat.o(227167);
    }
  }
  
  private static void ak(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(227191);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(227191);
      return;
      ahMY.v(paramString1, paramString2);
      AppMethodBeat.o(227191);
      return;
      ahMY.d(paramString1, paramString2);
      AppMethodBeat.o(227191);
      return;
      ahMY.i(paramString1, paramString2);
      AppMethodBeat.o(227191);
      return;
      ahMY.w(paramString1, paramString2);
      AppMethodBeat.o(227191);
      return;
      ahMY.e(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227066);
    aj(50, paramString1, paramString2);
    AppMethodBeat.o(227066);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227103);
    aj(10, paramString1, paramString2);
    AppMethodBeat.o(227103);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(227117);
    e(paramString, paramThrowable, "");
    AppMethodBeat.o(227117);
  }
  
  public static void e(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(227132);
    String str = "";
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2 + "\n";
    }
    paramString2 = str;
    if (paramThrowable != null) {
      paramString2 = str + Log.getStackTraceString(paramThrowable);
    }
    aj(10, paramString1, paramString2);
    AppMethodBeat.o(227132);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227080);
    aj(40, paramString1, paramString2);
    AppMethodBeat.o(227080);
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    eYL = paramBoolean;
  }
  
  public static void setOnLogListener(TPPlayerMgr.OnLogListener paramOnLogListener)
  {
    ahMY = paramOnLogListener;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227057);
    aj(60, paramString1, paramString2);
    AppMethodBeat.o(227057);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227093);
    aj(20, paramString1, paramString2);
    AppMethodBeat.o(227093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.g
 * JD-Core Version:    0.7.0.1
 */