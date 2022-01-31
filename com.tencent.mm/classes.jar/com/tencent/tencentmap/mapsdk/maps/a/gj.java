package com.tencent.tencentmap.mapsdk.maps.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public class gj
{
  public static String a;
  public static boolean b;
  
  static
  {
    AppMethodBeat.i(147996);
    a = "Volley";
    b = Log.isLoggable("Volley", 2);
    AppMethodBeat.o(147996);
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(147992);
    c(paramString, paramVarArgs);
    AppMethodBeat.o(147992);
  }
  
  public static void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(147994);
    c(paramString, paramVarArgs);
    AppMethodBeat.o(147994);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(147993);
    c(paramString, paramVarArgs);
    AppMethodBeat.o(147993);
  }
  
  private static String c(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(147995);
    int i;
    label25:
    String str;
    if (paramVarArgs == null)
    {
      paramVarArgs = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      if (i >= paramVarArgs.length) {
        break label166;
      }
      if (paramVarArgs[i].getClass().equals(gj.class)) {
        break label159;
      }
      str = paramVarArgs[i].getClassName();
      str = str.substring(str.lastIndexOf('.') + 1);
      str = str.substring(str.lastIndexOf('$') + 1);
    }
    label159:
    label166:
    for (paramVarArgs = str + "." + paramVarArgs[i].getMethodName();; paramVarArgs = "<unknown>")
    {
      paramString = String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramVarArgs, paramString });
      AppMethodBeat.o(147995);
      return paramString;
      paramString = String.format(Locale.US, paramString, paramVarArgs);
      break;
      i += 1;
      break label25;
    }
  }
  
  static class a$a
  {
    public final String a;
    public final long b;
    public final long c;
    
    public a$a(String paramString, long paramLong1, long paramLong2)
    {
      this.a = paramString;
      this.b = paramLong1;
      this.c = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gj
 * JD-Core Version:    0.7.0.1
 */