package com.tencent.recovery.log;

import java.util.ArrayList;
import java.util.List;

public class RecoveryCacheLog
  implements RecoveryLog.RecoveryLogImpl
{
  private static final int MAX_SIZE = 100;
  private List<LogItem> logCacheList = new ArrayList(100);
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.logCacheList.size() < 100)
    {
      LogItem localLogItem = new LogItem(null);
      localLogItem.level = 2;
      localLogItem.tag = paramString1;
      localLogItem.format = paramString2;
      localLogItem.args = paramVarArgs;
      this.logCacheList.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.logCacheList.size() < 100)
    {
      LogItem localLogItem = new LogItem(null);
      localLogItem.level = 5;
      localLogItem.tag = paramString1;
      localLogItem.format = paramString2;
      localLogItem.args = paramVarArgs;
      this.logCacheList.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.logCacheList.size() < 100)
    {
      LogItem localLogItem = new LogItem(null);
      localLogItem.level = 3;
      localLogItem.tag = paramString1;
      localLogItem.format = paramString2;
      localLogItem.args = paramVarArgs;
      this.logCacheList.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public void printAll(RecoveryLog.RecoveryLogImpl paramRecoveryLogImpl)
  {
    int j = this.logCacheList.size();
    int i = 0;
    if (i < j)
    {
      LogItem localLogItem = (LogItem)this.logCacheList.get(i);
      switch (localLogItem.level)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramRecoveryLogImpl.v(localLogItem.tag, localLogItem.format, localLogItem.args);
        continue;
        paramRecoveryLogImpl.d(localLogItem.tag, localLogItem.format, localLogItem.args);
        continue;
        paramRecoveryLogImpl.i(localLogItem.tag, localLogItem.format, localLogItem.args);
        continue;
        paramRecoveryLogImpl.w(localLogItem.tag, localLogItem.format, localLogItem.args);
        continue;
        if (localLogItem.e != null) {
          paramRecoveryLogImpl.printErrStackTrace(localLogItem.tag, localLogItem.e, localLogItem.format, localLogItem.args);
        } else {
          paramRecoveryLogImpl.e(localLogItem.tag, localLogItem.format, localLogItem.args);
        }
      }
    }
    this.logCacheList = new ArrayList();
  }
  
  public void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (this.logCacheList.size() < 100)
    {
      LogItem localLogItem = new LogItem(null);
      localLogItem.level = 5;
      localLogItem.tag = paramString1;
      localLogItem.format = paramString2;
      localLogItem.args = paramVarArgs;
      localLogItem.e = paramThrowable;
      this.logCacheList.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public void setDebugMode() {}
  
  public void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.logCacheList.size() < 100)
    {
      LogItem localLogItem = new LogItem(null);
      localLogItem.level = 1;
      localLogItem.tag = paramString1;
      localLogItem.format = paramString2;
      localLogItem.args = paramVarArgs;
      this.logCacheList.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.logCacheList.size() < 100)
    {
      LogItem localLogItem = new LogItem(null);
      localLogItem.level = 4;
      localLogItem.tag = paramString1;
      localLogItem.format = paramString2;
      localLogItem.args = paramVarArgs;
      this.logCacheList.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  class LogItem
  {
    Object[] args;
    Throwable e;
    String format;
    int level;
    String tag;
    
    private LogItem() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.log.RecoveryCacheLog
 * JD-Core Version:    0.7.0.1
 */