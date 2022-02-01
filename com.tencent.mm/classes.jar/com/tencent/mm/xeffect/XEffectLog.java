package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectLog
{
  public static b LYH;
  
  static
  {
    AppMethodBeat.i(216806);
    LYH = new a((byte)0);
    AppMethodBeat.o(216806);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(216805);
    LYH = paramb;
    try
    {
      e.load("xeffect_xlog");
      WeEffectRender.nSetNativeLog(fWT());
      AppMethodBeat.o(216805);
      return;
    }
    catch (Throwable paramb)
    {
      e("XEffectLog", "init xlog error %s", new Object[] { paramb.getMessage() });
      AppMethodBeat.o(216805);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(216802);
    LYH.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(216802);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(216803);
    LYH.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(216803);
  }
  
  private static long fWT()
  {
    AppMethodBeat.i(216804);
    try
    {
      long l = nGetXLogImpl();
      AppMethodBeat.o(216804);
      return l;
    }
    catch (Throwable localThrowable)
    {
      e("XEffectLog", "get native log error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(216804);
    }
    return 0L;
  }
  
  private static native long nGetXLogImpl();
  
  static final class a
    implements XEffectLog.b
  {
    public final void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(216800);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(216800);
    }
    
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(216801);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(216801);
    }
  }
  
  public static abstract interface b
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.xeffect.XEffectLog
 * JD-Core Version:    0.7.0.1
 */