package com.tencent.smtt.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public class Log
{
  public static final int ASSERT = 7;
  public static final int DEBUG = 3;
  public static final int ERROR = 6;
  public static final int INFO = 4;
  public static final int VERBOSE = 2;
  public static final int WARN = 5;
  private static final String sDeprecatedTagPrefix = "cr.";
  private static final String sTagPrefix = "cr_";
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(53801);
    debug(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(53801);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(53802);
    debug(paramString1, paramString2, new Object[] { paramObject });
    AppMethodBeat.o(53802);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(53803);
    debug(paramString1, paramString2, new Object[] { paramObject1, paramObject2 });
    AppMethodBeat.o(53803);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(53804);
    debug(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3 });
    AppMethodBeat.o(53804);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(53805);
    debug(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
    AppMethodBeat.o(53805);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(53806);
    debug(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
    AppMethodBeat.o(53806);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    AppMethodBeat.i(53807);
    debug(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6 });
    AppMethodBeat.o(53807);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
  {
    AppMethodBeat.i(53808);
    debug(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7 });
    AppMethodBeat.o(53808);
  }
  
  private static void debug(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(53800);
    formatLogWithStack(paramString2, paramVarArgs);
    if (getThrowableToLog(paramVarArgs) != null)
    {
      normalizeTag(paramString1);
      AppMethodBeat.o(53800);
      return;
    }
    normalizeTag(paramString1);
    AppMethodBeat.o(53800);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(53811);
    formatLog(paramString2, paramVarArgs);
    if (getThrowableToLog(paramVarArgs) != null)
    {
      normalizeTag(paramString1);
      AppMethodBeat.o(53811);
      return;
    }
    normalizeTag(paramString1);
    AppMethodBeat.o(53811);
  }
  
  private static String formatLog(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(53787);
    String str = paramString;
    if (paramVarArgs != null)
    {
      str = paramString;
      if (paramVarArgs.length != 0) {
        str = String.format(Locale.US, paramString, paramVarArgs);
      }
    }
    AppMethodBeat.o(53787);
    return str;
  }
  
  private static String formatLogWithStack(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(53789);
    paramString = "[" + getCallOrigin() + "] " + formatLog(paramString, paramVarArgs);
    AppMethodBeat.o(53789);
    return paramString;
  }
  
  private static String getCallOrigin()
  {
    AppMethodBeat.i(53814);
    Object localObject = Thread.currentThread().getStackTrace();
    String str = Log.class.getName();
    int i = 0;
    for (;;)
    {
      int j = i;
      if (i < localObject.length)
      {
        if (localObject[i].getClassName().equals(str)) {
          j = i + 4;
        }
      }
      else
      {
        localObject = localObject[j].getFileName() + ":" + localObject[j].getLineNumber();
        AppMethodBeat.o(53814);
        return localObject;
      }
      i += 1;
    }
  }
  
  public static String getStackTraceString(Throwable paramThrowable)
  {
    AppMethodBeat.i(53813);
    paramThrowable = android.util.Log.getStackTraceString(paramThrowable);
    AppMethodBeat.o(53813);
    return paramThrowable;
  }
  
  private static Throwable getThrowableToLog(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      return null;
    }
    paramArrayOfObject = paramArrayOfObject[(paramArrayOfObject.length - 1)];
    if (!(paramArrayOfObject instanceof Throwable)) {
      return null;
    }
    return (Throwable)paramArrayOfObject;
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(53809);
    formatLog(paramString2, paramVarArgs);
    if (getThrowableToLog(paramVarArgs) != null)
    {
      normalizeTag(paramString1);
      AppMethodBeat.o(53809);
      return;
    }
    normalizeTag(paramString1);
    AppMethodBeat.o(53809);
  }
  
  public static boolean isLoggable(String paramString, int paramInt)
  {
    AppMethodBeat.i(53790);
    boolean bool = android.util.Log.isLoggable(paramString, paramInt);
    AppMethodBeat.o(53790);
    return bool;
  }
  
  public static String normalizeTag(String paramString)
  {
    AppMethodBeat.i(53788);
    if (paramString.startsWith("cr_"))
    {
      AppMethodBeat.o(53788);
      return paramString;
    }
    int i = 0;
    if (paramString.startsWith("cr.")) {
      i = 3;
    }
    paramString = "cr_" + paramString.substring(i, paramString.length());
    AppMethodBeat.o(53788);
    return paramString;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(53792);
    verbose(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(53792);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(53793);
    verbose(paramString1, paramString2, new Object[] { paramObject });
    AppMethodBeat.o(53793);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(53794);
    verbose(paramString1, paramString2, new Object[] { paramObject1, paramObject2 });
    AppMethodBeat.o(53794);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(53795);
    verbose(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3 });
    AppMethodBeat.o(53795);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(53796);
    verbose(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
    AppMethodBeat.o(53796);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(53797);
    verbose(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
    AppMethodBeat.o(53797);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    AppMethodBeat.i(53798);
    verbose(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6 });
    AppMethodBeat.o(53798);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
  {
    AppMethodBeat.i(53799);
    verbose(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7 });
    AppMethodBeat.o(53799);
  }
  
  private static void verbose(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(53791);
    formatLogWithStack(paramString2, paramVarArgs);
    if (getThrowableToLog(paramVarArgs) != null)
    {
      normalizeTag(paramString1);
      AppMethodBeat.o(53791);
      return;
    }
    normalizeTag(paramString1);
    AppMethodBeat.o(53791);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(53810);
    formatLog(paramString2, paramVarArgs);
    if (getThrowableToLog(paramVarArgs) != null)
    {
      normalizeTag(paramString1);
      AppMethodBeat.o(53810);
      return;
    }
    normalizeTag(paramString1);
    AppMethodBeat.o(53810);
  }
  
  public static void wtf(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(53812);
    paramString2 = formatLog(paramString2, paramVarArgs);
    paramVarArgs = getThrowableToLog(paramVarArgs);
    if (paramVarArgs != null)
    {
      android.util.Log.wtf(normalizeTag(paramString1), paramString2, paramVarArgs);
      AppMethodBeat.o(53812);
      return;
    }
    android.util.Log.wtf(normalizeTag(paramString1), paramString2);
    AppMethodBeat.o(53812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sandbox.Log
 * JD-Core Version:    0.7.0.1
 */