package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.core.c.c;

public final class h
  implements c
{
  public final void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(59342);
    ab.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    AppMethodBeat.o(59342);
  }
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(59338);
    ab.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(59338);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(59341);
    ab.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(59341);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(59339);
    ab.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(59339);
  }
  
  public final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(59337);
    ab.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(59337);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(59340);
    ab.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(59340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.h
 * JD-Core Version:    0.7.0.1
 */