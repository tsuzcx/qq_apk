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
    AppMethodBeat.i(128446);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(128446);
      return;
    }
    try
    {
      d(paramString1, paramString2);
      AppMethodBeat.o(128446);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Logger.e("NLog", paramString1);
      AppMethodBeat.o(128446);
    }
  }
  
  public static void D(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(128450);
    d(paramString1, paramString2 + "\n" + Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(128450);
  }
  
  public static void E(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128449);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(128449);
      return;
    }
    try
    {
      e(paramString1, paramString2);
      AppMethodBeat.o(128449);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Logger.e("NLog", paramString1);
      AppMethodBeat.o(128449);
    }
  }
  
  public static void E(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(128453);
    e(paramString1, paramString2 + "\n" + Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(128453);
  }
  
  public static String GetLogPath()
  {
    AppMethodBeat.i(128445);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(128445);
      return "";
    }
    try
    {
      String str = getLogPath();
      AppMethodBeat.o(128445);
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Logger.e("NLog", localUnsatisfiedLinkError);
      AppMethodBeat.o(128445);
    }
    return "";
  }
  
  public static void I(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128447);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(128447);
      return;
    }
    try
    {
      i(paramString1, paramString2);
      AppMethodBeat.o(128447);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Logger.e("NLog", paramString1);
      AppMethodBeat.o(128447);
    }
  }
  
  public static void I(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(128451);
    i(paramString1, paramString2 + "\n" + Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(128451);
  }
  
  public static boolean Start(String paramString, int paramInt)
  {
    AppMethodBeat.i(128442);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(128442);
      return false;
    }
    try
    {
      boolean bool = start(paramString, paramInt);
      AppMethodBeat.o(128442);
      return bool;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      Logger.e("NLog", paramString);
      AppMethodBeat.o(128442);
    }
    return false;
  }
  
  public static void Stop()
  {
    AppMethodBeat.i(128443);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(128443);
      return;
    }
    try
    {
      stop();
      AppMethodBeat.o(128443);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Logger.e("NLog", localUnsatisfiedLinkError);
      AppMethodBeat.o(128443);
    }
  }
  
  public static void W(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128448);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(128448);
      return;
    }
    try
    {
      w(paramString1, paramString2);
      AppMethodBeat.o(128448);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Logger.e("NLog", paramString1);
      AppMethodBeat.o(128448);
    }
  }
  
  public static void W(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(128452);
    w(paramString1, paramString2 + "\n" + Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(128452);
  }
  
  private static void WriteLogCallback(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(128441);
    switch (paramInt)
    {
    default: 
      Logger.i(paramString1, paramString2);
      AppMethodBeat.o(128441);
      return;
    case 1: 
      Logger.d(paramString1, paramString2);
      AppMethodBeat.o(128441);
      return;
    case 2: 
      Logger.i(paramString1, paramString2);
      AppMethodBeat.o(128441);
      return;
    case 3: 
      Logger.w(paramString1, paramString2);
      AppMethodBeat.o(128441);
      return;
    }
    Logger.e(paramString1, paramString2);
    AppMethodBeat.o(128441);
  }
  
  private static native void d(String paramString1, String paramString2);
  
  private static native void e(String paramString1, String paramString2);
  
  private static native String getLogPath();
  
  private static native void i(String paramString1, String paramString2);
  
  public static boolean init(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(128454);
    if (AudioPlayerConfigure.getSoLibraryLoader().load(paramString1))
    {
      mIsLoadSuccess = true;
      Start(paramString2, paramInt);
      AppMethodBeat.o(128454);
      return true;
    }
    AppMethodBeat.o(128454);
    return false;
  }
  
  private static native void setLogWriteCallback(int paramInt);
  
  public static void setWriteCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(128444);
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      AppMethodBeat.o(128444);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      try
      {
        setLogWriteCallback(i);
        AppMethodBeat.o(128444);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        Logger.e("NLog", localUnsatisfiedLinkError);
        AppMethodBeat.o(128444);
      }
    }
  }
  
  private static native boolean start(String paramString, int paramInt);
  
  private static native void stop();
  
  private static native void w(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.NLog
 * JD-Core Version:    0.7.0.1
 */