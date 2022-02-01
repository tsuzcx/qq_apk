package com.tencent.thumbplayer.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener;
import java.util.MissingFormatArgumentException;

public final class g
{
  private static TPPlayerMgr.OnLogListener ZHV = null;
  private static int ZHW = 50;
  private static boolean dal = true;
  
  private static int aBu(int paramInt)
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
  
  private static void ag(int paramInt, String paramString1, String paramVarArgs)
  {
    AppMethodBeat.i(222243);
    int i = paramInt;
    if (paramInt == 20) {
      i = 10;
    }
    try
    {
      if (ZHV != null)
      {
        if (i <= ZHW)
        {
          ah(i, paramString1, paramVarArgs);
          AppMethodBeat.o(222243);
        }
      }
      else if ((dal) && (i <= ZHW)) {
        Log.println(aBu(i), paramString1, paramVarArgs);
      }
      AppMethodBeat.o(222243);
      return;
    }
    catch (MissingFormatArgumentException paramString1)
    {
      AppMethodBeat.o(222243);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(222243);
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      AppMethodBeat.o(222243);
    }
  }
  
  private static void ah(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(222246);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(222246);
      return;
      ZHV.v(paramString1, paramString2);
      AppMethodBeat.o(222246);
      return;
      ZHV.d(paramString1, paramString2);
      AppMethodBeat.o(222246);
      return;
      ZHV.i(paramString1, paramString2);
      AppMethodBeat.o(222246);
      return;
      ZHV.w(paramString1, paramString2);
      AppMethodBeat.o(222246);
      return;
      ZHV.e(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222233);
    ag(50, paramString1, paramString2);
    AppMethodBeat.o(222233);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222237);
    ag(10, paramString1, paramString2);
    AppMethodBeat.o(222237);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(222239);
    e(paramString, paramThrowable, "");
    AppMethodBeat.o(222239);
  }
  
  public static void e(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(222241);
    String str = "";
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2 + "\n";
    }
    paramString2 = str;
    if (paramThrowable != null) {
      paramString2 = str + Log.getStackTraceString(paramThrowable);
    }
    ag(10, paramString1, paramString2);
    AppMethodBeat.o(222241);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222234);
    ag(40, paramString1, paramString2);
    AppMethodBeat.o(222234);
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    dal = paramBoolean;
  }
  
  public static void setOnLogListener(TPPlayerMgr.OnLogListener paramOnLogListener)
  {
    ZHV = paramOnLogListener;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222231);
    ag(60, paramString1, paramString2);
    AppMethodBeat.o(222231);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222235);
    ag(20, paramString1, paramString2);
    AppMethodBeat.o(222235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.g
 * JD-Core Version:    0.7.0.1
 */