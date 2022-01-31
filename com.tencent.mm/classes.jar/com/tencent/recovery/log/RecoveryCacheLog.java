package com.tencent.recovery.log;

import java.util.ArrayList;
import java.util.List;

public class RecoveryCacheLog
  implements RecoveryLog.RecoveryLogImpl
{
  List<LogItem> Bio = new ArrayList(100);
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.Bio.size() < 100)
    {
      LogItem localLogItem = new LogItem((byte)0);
      localLogItem.level = 2;
      localLogItem.tag = paramString1;
      localLogItem.ifI = paramString2;
      localLogItem.Bip = paramVarArgs;
      this.Bio.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.Bio.size() < 100)
    {
      LogItem localLogItem = new LogItem((byte)0);
      localLogItem.level = 5;
      localLogItem.tag = paramString1;
      localLogItem.ifI = paramString2;
      localLogItem.Bip = paramVarArgs;
      this.Bio.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.Bio.size() < 100)
    {
      LogItem localLogItem = new LogItem((byte)0);
      localLogItem.level = 3;
      localLogItem.tag = paramString1;
      localLogItem.ifI = paramString2;
      localLogItem.Bip = paramVarArgs;
      this.Bio.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (this.Bio.size() < 100)
    {
      LogItem localLogItem = new LogItem((byte)0);
      localLogItem.level = 5;
      localLogItem.tag = paramString1;
      localLogItem.ifI = paramString2;
      localLogItem.Bip = paramVarArgs;
      localLogItem.Biq = paramThrowable;
      this.Bio.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.Bio.size() < 100)
    {
      LogItem localLogItem = new LogItem((byte)0);
      localLogItem.level = 1;
      localLogItem.tag = paramString1;
      localLogItem.ifI = paramString2;
      localLogItem.Bip = paramVarArgs;
      this.Bio.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.Bio.size() < 100)
    {
      LogItem localLogItem = new LogItem((byte)0);
      localLogItem.level = 4;
      localLogItem.tag = paramString1;
      localLogItem.ifI = paramString2;
      localLogItem.Bip = paramVarArgs;
      this.Bio.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  class LogItem
  {
    Object[] Bip;
    Throwable Biq;
    String ifI;
    int level;
    String tag;
    
    private LogItem() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.log.RecoveryCacheLog
 * JD-Core Version:    0.7.0.1
 */