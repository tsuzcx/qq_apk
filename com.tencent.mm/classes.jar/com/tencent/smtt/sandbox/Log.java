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
    AppMethodBeat.i(139007);
    debug(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(139007);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(139008);
    debug(paramString1, paramString2, new Object[] { paramObject });
    AppMethodBeat.o(139008);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(139009);
    debug(paramString1, paramString2, new Object[] { paramObject1, paramObject2 });
    AppMethodBeat.o(139009);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(139010);
    debug(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3 });
    AppMethodBeat.o(139010);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(139011);
    debug(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
    AppMethodBeat.o(139011);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(139012);
    debug(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
    AppMethodBeat.o(139012);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    AppMethodBeat.i(139013);
    debug(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6 });
    AppMethodBeat.o(139013);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
  {
    AppMethodBeat.i(139014);
    debug(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7 });
    AppMethodBeat.o(139014);
  }
  
  private static void debug(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(139006);
    formatLogWithStack(paramString2, paramVarArgs);
    if (getThrowableToLog(paramVarArgs) != null)
    {
      normalizeTag(paramString1);
      AppMethodBeat.o(139006);
      return;
    }
    normalizeTag(paramString1);
    AppMethodBeat.o(139006);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(139017);
    formatLog(paramString2, paramVarArgs);
    if (getThrowableToLog(paramVarArgs) != null)
    {
      normalizeTag(paramString1);
      AppMethodBeat.o(139017);
      return;
    }
    normalizeTag(paramString1);
    AppMethodBeat.o(139017);
  }
  
  private static String formatLog(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(138993);
    String str = paramString;
    if (paramVarArgs != null)
    {
      str = paramString;
      if (paramVarArgs.length != 0) {
        str = String.format(Locale.US, paramString, paramVarArgs);
      }
    }
    AppMethodBeat.o(138993);
    return str;
  }
  
  private static String formatLogWithStack(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(138995);
    paramString = "[" + getCallOrigin() + "] " + formatLog(paramString, paramVarArgs);
    AppMethodBeat.o(138995);
    return paramString;
  }
  
  private static String getCallOrigin()
  {
    AppMethodBeat.i(139020);
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
        AppMethodBeat.o(139020);
        return localObject;
      }
      i += 1;
    }
  }
  
  public static String getStackTraceString(Throwable paramThrowable)
  {
    AppMethodBeat.i(139019);
    paramThrowable = android.util.Log.getStackTraceString(paramThrowable);
    AppMethodBeat.o(139019);
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
    AppMethodBeat.i(139015);
    formatLog(paramString2, paramVarArgs);
    if (getThrowableToLog(paramVarArgs) != null)
    {
      normalizeTag(paramString1);
      AppMethodBeat.o(139015);
      return;
    }
    normalizeTag(paramString1);
    AppMethodBeat.o(139015);
  }
  
  public static boolean isLoggable(String paramString, int paramInt)
  {
    AppMethodBeat.i(138996);
    boolean bool = android.util.Log.isLoggable(paramString, paramInt);
    AppMethodBeat.o(138996);
    return bool;
  }
  
  public static String normalizeTag(String paramString)
  {
    AppMethodBeat.i(138994);
    if (paramString.startsWith("cr_"))
    {
      AppMethodBeat.o(138994);
      return paramString;
    }
    int i = 0;
    if (paramString.startsWith("cr.")) {
      i = 3;
    }
    paramString = "cr_" + paramString.substring(i, paramString.length());
    AppMethodBeat.o(138994);
    return paramString;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(138998);
    verbose(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(138998);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(138999);
    verbose(paramString1, paramString2, new Object[] { paramObject });
    AppMethodBeat.o(138999);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(139000);
    verbose(paramString1, paramString2, new Object[] { paramObject1, paramObject2 });
    AppMethodBeat.o(139000);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(139001);
    verbose(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3 });
    AppMethodBeat.o(139001);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(139002);
    verbose(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
    AppMethodBeat.o(139002);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(139003);
    verbose(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
    AppMethodBeat.o(139003);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    AppMethodBeat.i(139004);
    verbose(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6 });
    AppMethodBeat.o(139004);
  }
  
  public static void v(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
  {
    AppMethodBeat.i(139005);
    verbose(paramString1, paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7 });
    AppMethodBeat.o(139005);
  }
  
  private static void verbose(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(138997);
    formatLogWithStack(paramString2, paramVarArgs);
    if (getThrowableToLog(paramVarArgs) != null)
    {
      normalizeTag(paramString1);
      AppMethodBeat.o(138997);
      return;
    }
    normalizeTag(paramString1);
    AppMethodBeat.o(138997);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(139016);
    formatLog(paramString2, paramVarArgs);
    if (getThrowableToLog(paramVarArgs) != null)
    {
      normalizeTag(paramString1);
      AppMethodBeat.o(139016);
      return;
    }
    normalizeTag(paramString1);
    AppMethodBeat.o(139016);
  }
  
  public static void wtf(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(139018);
    paramString2 = formatLog(paramString2, paramVarArgs);
    paramVarArgs = getThrowableToLog(paramVarArgs);
    if (paramVarArgs != null)
    {
      android.util.Log.wtf(normalizeTag(paramString1), paramString2, paramVarArgs);
      AppMethodBeat.o(139018);
      return;
    }
    android.util.Log.wtf(normalizeTag(paramString1), paramString2);
    AppMethodBeat.o(139018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sandbox.Log
 * JD-Core Version:    0.7.0.1
 */