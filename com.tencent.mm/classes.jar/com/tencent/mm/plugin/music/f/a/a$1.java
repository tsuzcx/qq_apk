package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.qqmusic.mediaplayer.ILog;

final class a$1
  implements ILog
{
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137631);
    ab.d(paramString1, paramString2);
    AppMethodBeat.o(137631);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137633);
    ab.e(paramString1, paramString2);
    AppMethodBeat.o(137633);
  }
  
  public final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(137637);
    ab.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    AppMethodBeat.o(137637);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(137638);
    ab.e(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(137638);
  }
  
  public final void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(137636);
    ab.printErrStackTrace(paramString, paramThrowable, " throwable", new Object[0]);
    AppMethodBeat.o(137636);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137634);
    ab.i(paramString1, paramString2);
    AppMethodBeat.o(137634);
  }
  
  public final void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(137635);
    ab.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    AppMethodBeat.o(137635);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137632);
    ab.w(paramString1, paramString2);
    AppMethodBeat.o(137632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.a.1
 * JD-Core Version:    0.7.0.1
 */