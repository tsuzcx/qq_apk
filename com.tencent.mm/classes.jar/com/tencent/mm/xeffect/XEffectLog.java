package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectLog
{
  public static b YZv;
  
  static
  {
    AppMethodBeat.i(194616);
    YZv = new a((byte)0);
    AppMethodBeat.o(194616);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(194615);
    YZv = paramb;
    try
    {
      e.load("xeffect_xlog");
      WeEffectRender.nSetNativeLog(ijZ());
      AppMethodBeat.o(194615);
      return;
    }
    catch (Throwable paramb)
    {
      e("XEffectLog", "init xlog error %s", new Object[] { paramb.getMessage() });
      AppMethodBeat.o(194615);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(194604);
    YZv.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(194604);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(194609);
    YZv.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(194609);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(194605);
    YZv.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(194605);
  }
  
  private static long ijZ()
  {
    AppMethodBeat.i(194613);
    try
    {
      long l = nGetXLogImpl();
      AppMethodBeat.o(194613);
      return l;
    }
    catch (Throwable localThrowable)
    {
      e("XEffectLog", "get native log error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(194613);
    }
    return 0L;
  }
  
  private static native long nGetXLogImpl();
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(194607);
    YZv.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(194607);
  }
  
  static final class a
    implements XEffectLog.b
  {
    public final void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(194596);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(194596);
    }
    
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(194601);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(194601);
    }
    
    public final void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(194599);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(194599);
    }
    
    public final void w(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(194600);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(194600);
    }
  }
  
  public static abstract interface b
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.xeffect.XEffectLog
 * JD-Core Version:    0.7.0.1
 */