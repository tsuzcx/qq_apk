package com.tencent.recovery.log;

public class RecoveryLog
{
  private static RecoveryLogImpl logImpl = new RecoveryCacheLog();
  
  public static void appendLog()
  {
    if ((logImpl instanceof RecoveryFileLog)) {
      ((RecoveryFileLog)logImpl).appendToBuffer("", true);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (logImpl != null) {
      logImpl.d(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (logImpl != null) {
      logImpl.e(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static RecoveryLogImpl getLogImpl()
  {
    return logImpl;
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (logImpl != null) {
      logImpl.i(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (logImpl != null) {
      logImpl.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
  }
  
  public static void setDebugMode()
  {
    logImpl.setDebugMode();
  }
  
  public static void setLogImpl(RecoveryLogImpl paramRecoveryLogImpl)
  {
    if ((logImpl instanceof RecoveryCacheLog)) {
      ((RecoveryCacheLog)logImpl).printAll(paramRecoveryLogImpl);
    }
    logImpl = paramRecoveryLogImpl;
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (logImpl != null) {
      logImpl.v(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (logImpl != null) {
      logImpl.w(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static abstract interface RecoveryLogImpl
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void setDebugMode();
    
    public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.log.RecoveryLog
 * JD-Core Version:    0.7.0.1
 */