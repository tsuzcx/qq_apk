package com.tencent.tinker.loader.shareutil;

import android.util.Log;

final class ShareTinkerLog$1
  implements ShareTinkerLog.TinkerLogImp
{
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    for (paramString1 = paramString2;; paramString1 = String.format(paramString2, paramVarArgs))
    {
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      new StringBuilder().append(paramString2).append("  ").append(Log.getStackTraceString(paramThrowable));
      return;
    }
  }
  
  public final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    String.format(paramString2, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareTinkerLog.1
 * JD-Core Version:    0.7.0.1
 */