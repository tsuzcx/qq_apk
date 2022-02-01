package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectLog
{
  public static b RxP;
  
  static
  {
    AppMethodBeat.i(236771);
    RxP = new XEffectLog.a((byte)0);
    AppMethodBeat.o(236771);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(236770);
    RxP = paramb;
    try
    {
      d.load("xeffect_xlog");
      WeEffectRender.nSetNativeLog(hit());
      AppMethodBeat.o(236770);
      return;
    }
    catch (Throwable paramb)
    {
      e("XEffectLog", "init xlog error %s", new Object[] { paramb.getMessage() });
      AppMethodBeat.o(236770);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(236766);
    RxP.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(236766);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(236768);
    RxP.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(236768);
  }
  
  private static long hit()
  {
    AppMethodBeat.i(236769);
    try
    {
      long l = nGetXLogImpl();
      AppMethodBeat.o(236769);
      return l;
    }
    catch (Throwable localThrowable)
    {
      e("XEffectLog", "get native log error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(236769);
    }
    return 0L;
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(236767);
    RxP.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(236767);
  }
  
  private static native long nGetXLogImpl();
  
  public static abstract interface b
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.XEffectLog
 * JD-Core Version:    0.7.0.1
 */