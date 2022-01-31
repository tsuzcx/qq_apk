import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.qphone.base.util.QLog;

public class afwg
  implements Runnable
{
  public afwg(QSlowTableManager paramQSlowTableManager) {}
  
  public void run()
  {
    if (!QSlowTableManager.a(this.a).verifyAuthentication()) {
      QLog.e("QSlowTableManager", 1, "db verifyAuthentication failed!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     afwg
 * JD-Core Version:    0.7.0.1
 */