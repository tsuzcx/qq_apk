package com.tencent.recovery.log;

import android.os.Process;
import android.util.Log;
import com.tencent.recovery.storage.MMappedFileStorage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecoveryFileLog
  implements RecoveryLog.RecoveryLogImpl
{
  private MMappedFileStorage Bis;
  private SimpleDateFormat Bit;
  private boolean kEj;
  
  private String aJ(String paramString1, String paramString2, String paramString3)
  {
    String str = this.Bit.format(new Date());
    return String.format("%s​%s​[%d][%d][%s]: %s​​", new Object[] { paramString1, paramString2, Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()), str, paramString3 });
  }
  
  public final void ct(String paramString, boolean paramBoolean)
  {
    try
    {
      this.Bis.f(paramString.getBytes(), paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ct(aJ("D", paramString1, String.format(paramString2, paramVarArgs)), false);
    if (this.kEj) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ct(aJ("E", paramString1, String.format(paramString2, paramVarArgs)), false);
    if (this.kEj) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ct(aJ("I", paramString1, String.format(paramString2, paramVarArgs)), false);
    if (this.kEj) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    String str = String.format(paramString2, paramVarArgs);
    ct(aJ("E", paramString1, str + "  " + Log.getStackTraceString(paramThrowable)), false);
    if (this.kEj) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ct(aJ("V", paramString1, String.format(paramString2, paramVarArgs)), false);
    if (this.kEj) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ct(aJ("W", paramString1, String.format(paramString2, paramVarArgs)), false);
    if (this.kEj) {
      String.format(paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.log.RecoveryFileLog
 * JD-Core Version:    0.7.0.1
 */