package com.tencent.recovery.log;

import java.util.ArrayList;
import java.util.List;

public class RecoveryLog
{
  private static RecoveryLogImpl fMW = new RecoveryCacheLog();
  
  public static void a(RecoveryLogImpl paramRecoveryLogImpl)
  {
    if ((fMW instanceof RecoveryCacheLog))
    {
      RecoveryCacheLog localRecoveryCacheLog = (RecoveryCacheLog)fMW;
      int j = localRecoveryCacheLog.Bio.size();
      int i = 0;
      if (i < j)
      {
        RecoveryCacheLog.LogItem localLogItem = (RecoveryCacheLog.LogItem)localRecoveryCacheLog.Bio.get(i);
        switch (localLogItem.level)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          paramRecoveryLogImpl.v(localLogItem.tag, localLogItem.ifI, localLogItem.Bip);
          continue;
          paramRecoveryLogImpl.d(localLogItem.tag, localLogItem.ifI, localLogItem.Bip);
          continue;
          paramRecoveryLogImpl.i(localLogItem.tag, localLogItem.ifI, localLogItem.Bip);
          continue;
          paramRecoveryLogImpl.w(localLogItem.tag, localLogItem.ifI, localLogItem.Bip);
          continue;
          if (localLogItem.Biq != null) {
            paramRecoveryLogImpl.printErrStackTrace(localLogItem.tag, localLogItem.Biq, localLogItem.ifI, localLogItem.Bip);
          } else {
            paramRecoveryLogImpl.e(localLogItem.tag, localLogItem.ifI, localLogItem.Bip);
          }
        }
      }
      localRecoveryCacheLog.Bio = new ArrayList();
    }
    fMW = paramRecoveryLogImpl;
  }
  
  public static void dUp()
  {
    if ((fMW instanceof RecoveryFileLog)) {
      ((RecoveryFileLog)fMW).ct("", true);
    }
  }
  
  public static RecoveryLogImpl dUq()
  {
    return fMW;
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (fMW != null) {
      fMW.e(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (fMW != null) {
      fMW.i(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (fMW != null) {
      fMW.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
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