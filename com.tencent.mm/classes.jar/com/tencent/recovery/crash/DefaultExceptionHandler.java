package com.tencent.recovery.crash;

public class DefaultExceptionHandler
  extends RecoveryExceptionHandler
{
  private Thread.UncaughtExceptionHandler origin;
  
  public DefaultExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.origin = paramUncaughtExceptionHandler;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    super.uncaughtException(paramThread, paramThrowable);
    if (this.origin != null) {
      this.origin.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.recovery.crash.DefaultExceptionHandler
 * JD-Core Version:    0.7.0.1
 */