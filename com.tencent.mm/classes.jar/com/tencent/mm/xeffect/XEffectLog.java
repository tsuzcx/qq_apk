package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectLog
{
  public static e.b LBE;
  
  static
  {
    AppMethodBeat.i(220052);
    LBE = new e.a((byte)0);
    AppMethodBeat.o(220052);
  }
  
  public static void a(e.b paramb)
  {
    AppMethodBeat.i(221428);
    LBE = paramb;
    try
    {
      e.load("xeffect_xlog");
      WeEffectRender.nSetNativeLog(gAa());
      AppMethodBeat.o(221428);
      return;
    }
    catch (Throwable paramb)
    {
      e("XEffectLog", "init xlog error %s", new Object[] { paramb.getMessage() });
      AppMethodBeat.o(221428);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(221425);
    LBE.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(221425);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(221426);
    LBE.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(221426);
  }
  
  private static long gAa()
  {
    AppMethodBeat.i(221427);
    try
    {
      long l = nGetXLogImpl();
      AppMethodBeat.o(221427);
      return l;
    }
    catch (Throwable localThrowable)
    {
      e("XEffectLog", "get native log error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(221427);
    }
    return 0L;
  }
  
  private static native long nGetXLogImpl();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.xeffect.XEffectLog
 * JD-Core Version:    0.7.0.1
 */