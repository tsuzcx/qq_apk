package com.tencent.recovery.log;

import java.util.ArrayList;
import java.util.List;

public class RecoveryLog
{
  private static RecoveryLogImpl exg = new RecoveryCacheLog();
  
  public static void a(RecoveryLogImpl paramRecoveryLogImpl)
  {
    if ((exg instanceof RecoveryCacheLog))
    {
      RecoveryCacheLog localRecoveryCacheLog = (RecoveryCacheLog)exg;
      int j = localRecoveryCacheLog.wKN.size();
      int i = 0;
      if (i < j)
      {
        RecoveryCacheLog.LogItem localLogItem = (RecoveryCacheLog.LogItem)localRecoveryCacheLog.wKN.get(i);
        switch (localLogItem.level)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          paramRecoveryLogImpl.v(localLogItem.tag, localLogItem.wKO, localLogItem.wKP);
          continue;
          paramRecoveryLogImpl.d(localLogItem.tag, localLogItem.wKO, localLogItem.wKP);
          continue;
          paramRecoveryLogImpl.i(localLogItem.tag, localLogItem.wKO, localLogItem.wKP);
          continue;
          paramRecoveryLogImpl.w(localLogItem.tag, localLogItem.wKO, localLogItem.wKP);
          continue;
          if (localLogItem.wKQ != null) {
            paramRecoveryLogImpl.printErrStackTrace(localLogItem.tag, localLogItem.wKQ, localLogItem.wKO, localLogItem.wKP);
          } else {
            paramRecoveryLogImpl.e(localLogItem.tag, localLogItem.wKO, localLogItem.wKP);
          }
        }
      }
      localRecoveryCacheLog.wKN = new ArrayList();
    }
    exg = paramRecoveryLogImpl;
  }
  
  public static void cOA()
  {
    if ((exg instanceof RecoveryFileLog)) {
      ((RecoveryFileLog)exg).bQ("", true);
    }
  }
  
  public static RecoveryLogImpl cOB()
  {
    return exg;
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (exg != null) {
      exg.e(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (exg != null) {
      exg.i(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (exg != null) {
      exg.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
  }
  
  public static abstract interface RecoveryLogImpl
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.log.RecoveryLog
 * JD-Core Version:    0.7.0.1
 */