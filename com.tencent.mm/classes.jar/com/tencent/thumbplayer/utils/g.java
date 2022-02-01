package com.tencent.thumbplayer.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener;
import java.util.MissingFormatArgumentException;

public final class g
{
  private static TPPlayerMgr.OnLogListener Sfk = null;
  private static int Sfl = 50;
  private static boolean cWq = true;
  
  private static void ac(int paramInt, String paramString1, String paramVarArgs)
  {
    AppMethodBeat.i(189643);
    int i = paramInt;
    if (paramInt == 20) {
      i = 10;
    }
    try
    {
      if (Sfk != null)
      {
        if (i <= Sfl)
        {
          ad(i, paramString1, paramVarArgs);
          AppMethodBeat.o(189643);
        }
      }
      else if ((cWq) && (i <= Sfl)) {
        Log.println(arG(i), paramString1, paramVarArgs);
      }
      AppMethodBeat.o(189643);
      return;
    }
    catch (MissingFormatArgumentException paramString1)
    {
      AppMethodBeat.o(189643);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(189643);
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      AppMethodBeat.o(189643);
    }
  }
  
  private static void ad(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(189644);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(189644);
      return;
      Sfk.v(paramString1, paramString2);
      AppMethodBeat.o(189644);
      return;
      Sfk.d(paramString1, paramString2);
      AppMethodBeat.o(189644);
      return;
      Sfk.i(paramString1, paramString2);
      AppMethodBeat.o(189644);
      return;
      Sfk.w(paramString1, paramString2);
      AppMethodBeat.o(189644);
      return;
      Sfk.e(paramString1, paramString2);
    }
  }
  
  private static int arG(int paramInt)
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
    AppMethodBeat.i(189637);
    ac(50, paramString1, paramString2);
    AppMethodBeat.o(189637);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189640);
    ac(10, paramString1, paramString2);
    AppMethodBeat.o(189640);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(189641);
    e(paramString, paramThrowable, "");
    AppMethodBeat.o(189641);
  }
  
  public static void e(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(189642);
    String str = "";
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2 + "\n";
    }
    paramString2 = str;
    if (paramThrowable != null) {
      paramString2 = str + Log.getStackTraceString(paramThrowable);
    }
    ac(10, paramString1, paramString2);
    AppMethodBeat.o(189642);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189638);
    ac(40, paramString1, paramString2);
    AppMethodBeat.o(189638);
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    cWq = paramBoolean;
  }
  
  public static void setOnLogListener(TPPlayerMgr.OnLogListener paramOnLogListener)
  {
    Sfk = paramOnLogListener;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189636);
    ac(60, paramString1, paramString2);
    AppMethodBeat.o(189636);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189639);
    ac(20, paramString1, paramString2);
    AppMethodBeat.o(189639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.g
 * JD-Core Version:    0.7.0.1
 */