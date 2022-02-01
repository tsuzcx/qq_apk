package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.f.a.a;

final class PluginZero$4
  implements a.a
{
  PluginZero$4(PluginZero paramPluginZero) {}
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(133004);
    ac.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(133004);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(133001);
    ac.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(133001);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(133003);
    ac.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(133003);
  }
  
  public final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(133005);
    ac.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(133005);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(133002);
    ac.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(133002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero.4
 * JD-Core Version:    0.7.0.1
 */