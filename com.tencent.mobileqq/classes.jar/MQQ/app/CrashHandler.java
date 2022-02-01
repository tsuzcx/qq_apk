package mqq.app;

import com.tencent.qphone.base.util.QLog;

public class CrashHandler
  implements Thread.UncaughtExceptionHandler
{
  private boolean isCrahing;
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      if (this.isCrahing) {
        return;
      }
      this.isCrahing = true;
      paramThread = MobileQQ.sMobileQQ;
      if (paramThread != null)
      {
        String str = paramThread.getQQProcessName();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" has crashed.");
        QLog.e("crash", 1, localStringBuilder.toString(), paramThrowable);
        paramThread.closeAllActivitys();
        QLog.flushLog();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.CrashHandler
 * JD-Core Version:    0.7.0.1
 */