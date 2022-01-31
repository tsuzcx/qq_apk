package com.tencent.recovery.crash;

public class DefaultExceptionHandler
  extends RecoveryExceptionHandler
{
  private Thread.UncaughtExceptionHandler Bin;
  
  public DefaultExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.Bin = paramUncaughtExceptionHandler;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    super.uncaughtException(paramThread, paramThrowable);
    if (this.Bin != null) {
      this.Bin.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.crash.DefaultExceptionHandler
 * JD-Core Version:    0.7.0.1
 */