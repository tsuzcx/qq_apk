package com.tencent.mm.plugin.music.f.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqmusic.mediaplayer.ILog;

final class a$1
  implements ILog
{
  public final void d(String paramString1, String paramString2)
  {
    y.d(paramString1, paramString2);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    y.e(paramString1, paramString2);
  }
  
  public final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    y.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    y.e(paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public final void e(String paramString, Throwable paramThrowable)
  {
    y.printErrStackTrace(paramString, paramThrowable, " throwable", new Object[0]);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    y.i(paramString1, paramString2);
  }
  
  public final void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    y.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    y.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.a.1
 * JD-Core Version:    0.7.0.1
 */