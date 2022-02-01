package com.tencent.mm.plugin.music.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qqmusic.mediaplayer.ILog;

final class a$1
  implements ILog
{
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137383);
    Log.d(paramString1, paramString2);
    AppMethodBeat.o(137383);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137385);
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(137385);
  }
  
  public final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(137389);
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    AppMethodBeat.o(137389);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(137390);
    Log.e(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(137390);
  }
  
  public final void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(137388);
    Log.printErrStackTrace(paramString, paramThrowable, " throwable", new Object[0]);
    AppMethodBeat.o(137388);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137386);
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(137386);
  }
  
  public final void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(137387);
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    AppMethodBeat.o(137387);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137384);
    Log.w(paramString1, paramString2);
    AppMethodBeat.o(137384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.a.a.1
 * JD-Core Version:    0.7.0.1
 */