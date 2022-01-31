import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.JobReporter;
import com.tencent.mobileqq.app.ThreadWrapContext;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class akhm
  implements ThreadWrapContext
{
  private static boolean a;
  private static volatile boolean b;
  
  public static void a(long paramLong)
  {
    if ((!a) && (BaseApplicationImpl.sProcessId == 1))
    {
      a = true;
      if (QLog.isColorLevel()) {
        QLog.d("ThreadManager.config", 2, "initShotChanceForPublicVersion|chance " + paramLong);
      }
      if (paramLong > 0L)
      {
        b = JobReporter.ramdomReport((int)paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("ThreadManager.config", 2, "initShotChanceForPublicVersion|sShotChanceForPublicVersion " + b);
        }
      }
    }
  }
  
  public void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public long getMainProccessThreadMonitorTime()
  {
    return bbjn.d();
  }
  
  public long getMainProccessThreadPeakCounts()
  {
    return bbjn.c();
  }
  
  public boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public boolean isShotReportRejectedError()
  {
    return b;
  }
  
  public void reportDengTaException(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2)
  {
    axrl.a(BaseApplicationImpl.getApplication()).a(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2);
  }
  
  public void reportRDMException(Throwable paramThrowable, String paramString1, String paramString2) {}
  
  public void setMainProccessThreadMonitorTime(long paramLong)
  {
    bbjn.b(paramLong);
  }
  
  public void setMainProccessThreadPeakCounts(long paramLong)
  {
    bbjn.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akhm
 * JD-Core Version:    0.7.0.1
 */