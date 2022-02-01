package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XEffectLog
{
  public static b agXH;
  
  static
  {
    AppMethodBeat.i(234516);
    agXH = new XEffectLog.a((byte)0);
    AppMethodBeat.o(234516);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(234506);
    agXH = paramb;
    try
    {
      f.load("xeffect_xlog");
      WeEffectRender.nSetNativeLog(jQh());
      AppMethodBeat.o(234506);
      return;
    }
    finally
    {
      e("XEffectLog", "init xlog error %s", new Object[] { paramb.getMessage() });
      AppMethodBeat.o(234506);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(234482);
    agXH.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(234482);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(234496);
    agXH.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(234496);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(234487);
    agXH.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(234487);
  }
  
  public static long jQh()
  {
    AppMethodBeat.i(234499);
    try
    {
      long l = nGetXLogImpl();
      AppMethodBeat.o(234499);
      return l;
    }
    finally
    {
      e("XEffectLog", "get native log error %s", new Object[] { localObject.getMessage() });
      AppMethodBeat.o(234499);
    }
    return 0L;
  }
  
  private static native long nGetXLogImpl();
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(234492);
    agXH.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(234492);
  }
  
  public static abstract interface b
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.xeffect.XEffectLog
 * JD-Core Version:    0.7.0.1
 */