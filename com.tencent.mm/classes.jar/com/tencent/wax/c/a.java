package com.tencent.wax.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a KuM;
  private static a KuY;
  
  static
  {
    AppMethodBeat.i(191714);
    a.1 local1 = new a.1();
    KuY = local1;
    KuM = local1;
    AppMethodBeat.o(191714);
  }
  
  public static void b(a parama)
  {
    KuM = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(191711);
    KuM.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(191711);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(191712);
    KuM.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(191712);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(191710);
    KuM.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(191710);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(191713);
    KuM.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(191713);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.c.a
 * JD-Core Version:    0.7.0.1
 */