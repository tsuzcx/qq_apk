package com.tencent.qqmusic.mediaplayer;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class NLog
{
  private static final int LEVEL_DEBUG = 1;
  private static final int LEVEL_ERROR = 4;
  private static final int LEVEL_INFO = 2;
  private static final int LEVEL_WARNING = 3;
  private static final String TAG = "NLog";
  private static volatile boolean mIsLoadSuccess = false;
  
  public static void D(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114382);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(114382);
      return;
    }
    try
    {
      d(paramString1, paramString2);
      AppMethodBeat.o(114382);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Logger.e("NLog", paramString1);
      AppMethodBeat.o(114382);
    }
  }
  
  public static void D(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(114386);
    d(paramString1, paramString2 + "\n" + Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(114386);
  }
  
  public static void E(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114385);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(114385);
      return;
    }
    try
    {
      e(paramString1, paramString2);
      AppMethodBeat.o(114385);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Logger.e("NLog", paramString1);
      AppMethodBeat.o(114385);
    }
  }
  
  public static void E(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(114389);
    e(paramString1, paramString2 + "\n" + Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(114389);
  }
  
  public static String GetLogPath()
  {
    AppMethodBeat.i(114381);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(114381);
      return "";
    }
    try
    {
      String str = getLogPath();
      AppMethodBeat.o(114381);
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Logger.e("NLog", localUnsatisfiedLinkError);
      AppMethodBeat.o(114381);
    }
    return "";
  }
  
  public static void I(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114383);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(114383);
      return;
    }
    try
    {
      i(paramString1, paramString2);
      AppMethodBeat.o(114383);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Logger.e("NLog", paramString1);
      AppMethodBeat.o(114383);
    }
  }
  
  public static void I(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(114387);
    i(paramString1, paramString2 + "\n" + Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(114387);
  }
  
  public static boolean Start(String paramString, int paramInt)
  {
    AppMethodBeat.i(114378);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(114378);
      return false;
    }
    try
    {
      boolean bool = start(paramString, paramInt);
      AppMethodBeat.o(114378);
      return bool;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      Logger.e("NLog", paramString);
      AppMethodBeat.o(114378);
    }
    return false;
  }
  
  public static void Stop()
  {
    AppMethodBeat.i(114379);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(114379);
      return;
    }
    try
    {
      stop();
      AppMethodBeat.o(114379);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Logger.e("NLog", localUnsatisfiedLinkError);
      AppMethodBeat.o(114379);
    }
  }
  
  public static void W(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114384);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(114384);
      return;
    }
    try
    {
      w(paramString1, paramString2);
      AppMethodBeat.o(114384);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Logger.e("NLog", paramString1);
      AppMethodBeat.o(114384);
    }
  }
  
  public static void W(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(114388);
    w(paramString1, paramString2 + "\n" + Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(114388);
  }
  
  private static void WriteLogCallback(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(114377);
    switch (paramInt)
    {
    default: 
      Logger.i(paramString1, paramString2);
      AppMethodBeat.o(114377);
      return;
    case 1: 
      Logger.d(paramString1, paramString2);
      AppMethodBeat.o(114377);
      return;
    case 2: 
      Logger.i(paramString1, paramString2);
      AppMethodBeat.o(114377);
      return;
    case 3: 
      Logger.w(paramString1, paramString2);
      AppMethodBeat.o(114377);
      return;
    }
    Logger.e(paramString1, paramString2);
    AppMethodBeat.o(114377);
  }
  
  private static native void d(String paramString1, String paramString2);
  
  private static native void e(String paramString1, String paramString2);
  
  private static native String getLogPath();
  
  private static native void i(String paramString1, String paramString2);
  
  public static boolean init(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(114390);
    if (AudioPlayerConfigure.getSoLibraryLoader().load(paramString1))
    {
      mIsLoadSuccess = true;
      Start(paramString2, paramInt);
      AppMethodBeat.o(114390);
      return true;
    }
    AppMethodBeat.o(114390);
    return false;
  }
  
  private static native void setLogWriteCallback(int paramInt);
  
  public static void setWriteCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(114380);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(114380);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      try
      {
        setLogWriteCallback(i);
        AppMethodBeat.o(114380);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        Logger.e("NLog", localUnsatisfiedLinkError);
        AppMethodBeat.o(114380);
      }
    }
  }
  
  private static native boolean start(String paramString, int paramInt);
  
  private static native void stop();
  
  private static native void w(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.NLog
 * JD-Core Version:    0.7.0.1
 */