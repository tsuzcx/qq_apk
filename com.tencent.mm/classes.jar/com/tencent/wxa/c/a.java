package com.tencent.wxa.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a aidC;
  private static a aidT;
  
  static
  {
    AppMethodBeat.i(210498);
    a.1 local1 = new a.1();
    aidT = local1;
    aidC = local1;
    AppMethodBeat.o(210498);
  }
  
  public static void a(a parama)
  {
    aidC = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(210479);
    aidC.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(210479);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(210493);
    aidC.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(210493);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(210481);
    aidC.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(210481);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(210474);
    aidC.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(210474);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(210485);
    aidC.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(210485);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.wxa.c.a
 * JD-Core Version:    0.7.0.1
 */