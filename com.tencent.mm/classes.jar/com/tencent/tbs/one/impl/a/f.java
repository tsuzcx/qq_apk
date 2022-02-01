package com.tencent.tbs.one.impl.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class f
{
  private static b a;
  
  static
  {
    AppMethodBeat.i(173900);
    a = new a((byte)0);
    AppMethodBeat.o(173900);
  }
  
  private static String a(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(173896);
    if ((paramVarArgs != null) && (((paramThrowable == null) && (paramVarArgs.length > 0)) || (paramVarArgs.length > 1))) {
      paramString = String.format(Locale.US, paramString, paramVarArgs);
    }
    for (;;)
    {
      paramVarArgs = paramString;
      if (paramThrowable != null) {
        paramVarArgs = paramString + '\n' + Log.getStackTraceString(paramThrowable);
      }
      AppMethodBeat.o(173896);
      return paramVarArgs;
    }
  }
  
  private static Throwable a(Object[] paramArrayOfObject)
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
  
  public static void a(b paramb)
  {
    a = paramb;
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(173897);
    paramString = a(paramString, a(paramVarArgs), paramVarArgs);
    a.a(4, paramString);
    AppMethodBeat.o(173897);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(173898);
    paramString = a(paramString, a(paramVarArgs), paramVarArgs);
    a.a(5, paramString);
    AppMethodBeat.o(173898);
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(173899);
    paramString = a(paramString, a(paramVarArgs), paramVarArgs);
    a.a(6, paramString);
    AppMethodBeat.o(173899);
  }
  
  static final class a
    implements f.b
  {
    public final void a(int paramInt, String paramString)
    {
      AppMethodBeat.i(173920);
      Log.println(paramInt, "TBSOne", paramString);
      AppMethodBeat.o(173920);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.f
 * JD-Core Version:    0.7.0.1
 */