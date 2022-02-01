package com.tencent.recovery.log;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.recovery.storage.MMappedFileStorage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecoveryFileLog
  implements RecoveryLog.RecoveryLogImpl
{
  public static final String LINE_SPLITTER = "​​";
  private static final int MAX_LOG_LENGTH = 5242880;
  public static final String SPLITTER = "​";
  private SimpleDateFormat formatter;
  private boolean isDebugMode;
  private MMappedFileStorage mmappedFileStorage;
  
  public RecoveryFileLog(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), "recovery");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    paramContext = new File(paramContext, "recovery.log");
    if (paramContext.length() > 5242880L) {
      paramContext.delete();
    }
    this.mmappedFileStorage = new MMappedFileStorage(paramContext.getAbsolutePath());
    this.formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
  }
  
  private String generateLog(String paramString1, String paramString2, String paramString3)
  {
    String str = this.formatter.format(new Date());
    return String.format("%s​%s​[%d][%d][%s]: %s​​", new Object[] { paramString1, paramString2, Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()), str, paramString3 });
  }
  
  protected void appendToBuffer(String paramString)
  {
    appendToBuffer(paramString, false);
  }
  
  public void appendToBuffer(String paramString, boolean paramBoolean)
  {
    try
    {
      this.mmappedFileStorage.appendToBuffer(paramString.getBytes(), paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    appendToBuffer(generateLog("D", paramString1, String.format(paramString2, paramVarArgs)));
    if (this.isDebugMode) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    appendToBuffer(generateLog("E", paramString1, String.format(paramString2, paramVarArgs)));
    if (this.isDebugMode) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    appendToBuffer(generateLog("I", paramString1, String.format(paramString2, paramVarArgs)));
    if (this.isDebugMode) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    String str = String.format(paramString2, paramVarArgs);
    appendToBuffer(generateLog("E", paramString1, str + "  " + Log.getStackTraceString(paramThrowable)));
    if (this.isDebugMode) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public void setDebugMode()
  {
    this.isDebugMode = true;
  }
  
  public void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    appendToBuffer(generateLog("V", paramString1, String.format(paramString2, paramVarArgs)));
    if (this.isDebugMode) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    appendToBuffer(generateLog("W", paramString1, String.format(paramString2, paramVarArgs)));
    if (this.isDebugMode) {
      String.format(paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.log.RecoveryFileLog
 * JD-Core Version:    0.7.0.1
 */