package com.tencent.stubs.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringTokenizer;

public final class Log
{
  public static final int ASSERT = 7;
  public static final int DEBUG = 3;
  public static final int ERROR = 6;
  public static final int INFO = 4;
  private static final long LOGGER_JAVA = 3L;
  private static final long LOGGER_LOGCAT = 2L;
  private static final long LOGGER_NOOP = 0L;
  private static final long LOGGER_STDOUT = 1L;
  public static final int VERBOSE = 2;
  public static final int WARN = 5;
  static volatile Logger sLogger;
  static volatile long sLoggerPtr;
  
  static
  {
    AppMethodBeat.i(73524);
    try
    {
      Class.forName("android.util.Log");
      localAndroidLogcat = new AndroidLogcat();
      l = 2L;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        AndroidLogcat localAndroidLogcat;
        Logger local1 = new Logger()
        {
          public final boolean isLoggable(String paramAnonymousString, int paramAnonymousInt)
          {
            return true;
          }
          
          public final void println(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(73525);
            System.out.println("[" + paramAnonymousString1 + "] " + paramAnonymousString2);
            AppMethodBeat.o(73525);
          }
        };
        long l = 1L;
      }
    }
    sLogger = localAndroidLogcat;
    sLoggerPtr = l;
    AppMethodBeat.o(73524);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73516);
    println(3, paramString1, paramString2);
    AppMethodBeat.o(73516);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73518);
    printFormat(3, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73518);
  }
  
  public static void d(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(73517);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      println(3, paramString1, paramString2);
    }
    if (paramThrowable != null) {
      printStack(3, paramString1, paramThrowable);
    }
    AppMethodBeat.o(73517);
  }
  
  public static void d(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73519);
    printFormat(3, paramString1, paramString2, paramVarArgs);
    if (paramThrowable != null) {
      printStack(3, paramString1, paramThrowable);
    }
    AppMethodBeat.o(73519);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73504);
    println(6, paramString1, paramString2);
    AppMethodBeat.o(73504);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73506);
    printFormat(6, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73506);
  }
  
  public static void e(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(73505);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      println(6, paramString1, paramString2);
    }
    if (paramThrowable != null) {
      printStack(6, paramString1, paramThrowable);
    }
    AppMethodBeat.o(73505);
  }
  
  public static void e(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73507);
    printFormat(6, paramString1, paramString2, paramVarArgs);
    if (paramThrowable != null) {
      printStack(6, paramString1, paramThrowable);
    }
    AppMethodBeat.o(73507);
  }
  
  public static void f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73500);
    println(7, paramString1, paramString2);
    AppMethodBeat.o(73500);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73502);
    printFormat(7, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73502);
  }
  
  public static void f(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(73501);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      println(7, paramString1, paramString2);
    }
    if (paramThrowable != null) {
      printStack(7, paramString1, paramThrowable);
    }
    AppMethodBeat.o(73501);
  }
  
  public static void f(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73503);
    printFormat(7, paramString1, paramString2, paramVarArgs);
    if (paramThrowable != null) {
      printStack(7, paramString1, paramThrowable);
    }
    AppMethodBeat.o(73503);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73512);
    println(4, paramString1, paramString2);
    AppMethodBeat.o(73512);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73514);
    printFormat(4, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73514);
  }
  
  public static void i(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(73513);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      println(4, paramString1, paramString2);
    }
    if (paramThrowable != null) {
      printStack(4, paramString1, paramThrowable);
    }
    AppMethodBeat.o(73513);
  }
  
  public static void i(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73515);
    printFormat(4, paramString1, paramString2, paramVarArgs);
    if (paramThrowable != null) {
      printStack(4, paramString1, paramThrowable);
    }
    AppMethodBeat.o(73515);
  }
  
  public static void printFormat(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73499);
    Logger localLogger = sLogger;
    if ((localLogger == null) || (!localLogger.isLoggable(paramString1, paramInt)))
    {
      AppMethodBeat.o(73499);
      return;
    }
    localLogger.println(paramInt, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(73499);
  }
  
  public static void printStack(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(73498);
    Logger localLogger = sLogger;
    if ((localLogger == null) || (!localLogger.isLoggable(paramString, paramInt)))
    {
      AppMethodBeat.o(73498);
      return;
    }
    StringWriter localStringWriter = new StringWriter(512);
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    paramThrowable = new StringTokenizer(localStringWriter.toString(), "\n");
    while (paramThrowable.hasMoreTokens()) {
      localLogger.println(paramInt, paramString, paramThrowable.nextToken());
    }
    AppMethodBeat.o(73498);
  }
  
  public static void println(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(73497);
    Logger localLogger = sLogger;
    if (localLogger == null)
    {
      AppMethodBeat.o(73497);
      return;
    }
    localLogger.println(paramInt, paramString1, paramString2);
    AppMethodBeat.o(73497);
  }
  
  public static void setLogger(Logger paramLogger)
  {
    sLogger = paramLogger;
    if (paramLogger == null) {}
    for (long l = 0L;; l = 3L)
    {
      sLoggerPtr = l;
      return;
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73520);
    println(2, paramString1, paramString2);
    AppMethodBeat.o(73520);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73522);
    printFormat(2, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73522);
  }
  
  public static void v(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(73521);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      println(2, paramString1, paramString2);
    }
    if (paramThrowable != null) {
      printStack(2, paramString1, paramThrowable);
    }
    AppMethodBeat.o(73521);
  }
  
  public static void v(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73523);
    printFormat(2, paramString1, paramString2, paramVarArgs);
    if (paramThrowable != null) {
      printStack(2, paramString1, paramThrowable);
    }
    AppMethodBeat.o(73523);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73508);
    println(5, paramString1, paramString2);
    AppMethodBeat.o(73508);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73510);
    printFormat(5, paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73510);
  }
  
  public static void w(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(73509);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      println(5, paramString1, paramString2);
    }
    if (paramThrowable != null) {
      printStack(5, paramString1, paramThrowable);
    }
    AppMethodBeat.o(73509);
  }
  
  public static void w(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73511);
    printFormat(5, paramString1, paramString2, paramVarArgs);
    if (paramThrowable != null) {
      printStack(7, paramString1, paramThrowable);
    }
    AppMethodBeat.o(73511);
  }
  
  public static abstract interface Logger
  {
    public abstract boolean isLoggable(String paramString, int paramInt);
    
    public abstract void println(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.stubs.logger.Log
 * JD-Core Version:    0.7.0.1
 */