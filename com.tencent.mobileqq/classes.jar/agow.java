import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.qphone.base.util.QLog;

public class agow
  implements Runnable
{
  public agow(QSlowTableManager paramQSlowTableManager) {}
  
  public void run()
  {
    if (!QSlowTableManager.a(this.a).verifyAuthentication()) {
      QLog.e("QSlowTableManager", 1, "db verifyAuthentication failed!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agow
 * JD-Core Version:    0.7.0.1
 */