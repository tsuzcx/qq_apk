package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.ILog;

final class Logger$1
  implements ILog
{
  public final void d(String paramString1, String paramString2) {}
  
  public final void e(String paramString1, String paramString2) {}
  
  public final void e(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(87747);
    String.format(paramString2, paramVarArgs);
    AppMethodBeat.o(87747);
  }
  
  public final void e(String paramString, Throwable paramThrowable) {}
  
  public final void i(String paramString1, String paramString2) {}
  
  public final void i(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public final void w(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.Logger.1
 * JD-Core Version:    0.7.0.1
 */