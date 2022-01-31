package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.f.a.a;

final class PluginZero$4
  implements a.a
{
  PluginZero$4(PluginZero paramPluginZero) {}
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(58754);
    ab.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(58754);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(58751);
    ab.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(58751);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(58753);
    ab.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(58753);
  }
  
  public final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(58755);
    ab.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(58755);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(58752);
    ab.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(58752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero.4
 * JD-Core Version:    0.7.0.1
 */