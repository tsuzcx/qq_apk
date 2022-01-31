package com.tencent.mm.ui;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ak
{
  private static a zfR;
  private static a zfS;
  
  static
  {
    AppMethodBeat.i(112481);
    a local1 = new a()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    zfR = local1;
    zfS = local1;
    AppMethodBeat.o(112481);
  }
  
  public static void a(a parama)
  {
    zfS = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(112476);
    if (zfS != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      zfS.d(paramString1, paramString2);
    }
    AppMethodBeat.o(112476);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(112479);
    if (zfS != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      zfS.e(paramString1, paramString2);
    }
    AppMethodBeat.o(112479);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(112477);
    if (zfS != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      zfS.i(paramString1, paramString2);
    }
    AppMethodBeat.o(112477);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(112480);
    if (zfS != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramThrowable = paramString2 + "  " + Log.getStackTraceString(paramThrowable);
      zfS.e(paramString1, paramThrowable);
    }
    AppMethodBeat.o(112480);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(112475);
    if (zfS != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      zfS.v(paramString1, paramString2);
    }
    AppMethodBeat.o(112475);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(112478);
    if (zfS != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      zfS.w(paramString1, paramString2);
    }
    AppMethodBeat.o(112478);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2);
    
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void i(String paramString1, String paramString2);
    
    public abstract void v(String paramString1, String paramString2);
    
    public abstract void w(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ak
 * JD-Core Version:    0.7.0.1
 */