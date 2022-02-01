package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.c.c;

public final class h
  implements c
{
  public final void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(130849);
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    AppMethodBeat.o(130849);
  }
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(130845);
    Log.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(130845);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(130848);
    Log.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(130848);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(130846);
    Log.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(130846);
  }
  
  public final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(130844);
    Log.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(130844);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(130847);
    Log.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(130847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.h
 * JD-Core Version:    0.7.0.1
 */