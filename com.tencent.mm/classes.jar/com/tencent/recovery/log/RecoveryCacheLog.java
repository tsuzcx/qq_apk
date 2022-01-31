package com.tencent.recovery.log;

import java.util.ArrayList;
import java.util.List;

public class RecoveryCacheLog
  implements RecoveryLog.RecoveryLogImpl
{
  List<LogItem> wKN = new ArrayList(100);
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.wKN.size() < 100)
    {
      LogItem localLogItem = new LogItem((byte)0);
      localLogItem.level = 2;
      localLogItem.tag = paramString1;
      localLogItem.wKO = paramString2;
      localLogItem.wKP = paramVarArgs;
      this.wKN.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.wKN.size() < 100)
    {
      LogItem localLogItem = new LogItem((byte)0);
      localLogItem.level = 5;
      localLogItem.tag = paramString1;
      localLogItem.wKO = paramString2;
      localLogItem.wKP = paramVarArgs;
      this.wKN.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.wKN.size() < 100)
    {
      LogItem localLogItem = new LogItem((byte)0);
      localLogItem.level = 3;
      localLogItem.tag = paramString1;
      localLogItem.wKO = paramString2;
      localLogItem.wKP = paramVarArgs;
      this.wKN.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (this.wKN.size() < 100)
    {
      LogItem localLogItem = new LogItem((byte)0);
      localLogItem.level = 5;
      localLogItem.tag = paramString1;
      localLogItem.wKO = paramString2;
      localLogItem.wKP = paramVarArgs;
      localLogItem.wKQ = paramThrowable;
      this.wKN.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.wKN.size() < 100)
    {
      LogItem localLogItem = new LogItem((byte)0);
      localLogItem.level = 1;
      localLogItem.tag = paramString1;
      localLogItem.wKO = paramString2;
      localLogItem.wKP = paramVarArgs;
      this.wKN.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.wKN.size() < 100)
    {
      LogItem localLogItem = new LogItem((byte)0);
      localLogItem.level = 4;
      localLogItem.tag = paramString1;
      localLogItem.wKO = paramString2;
      localLogItem.wKP = paramVarArgs;
      this.wKN.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  private class LogItem
  {
    int level;
    String tag;
    String wKO;
    Object[] wKP;
    Throwable wKQ;
    
    private LogItem() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.log.RecoveryCacheLog
 * JD-Core Version:    0.7.0.1
 */