import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.qphone.base.util.QLog;

public class abfb
  implements Runnable
{
  public abfb(ARMapConfigManager paramARMapConfigManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "onGetARMapConfig ,excute runnable");
    }
    if (ARMapConfigManager.a(this.a) != null) {}
    synchronized (ARMapConfigManager.a(this.a))
    {
      if (ARMapConfigManager.a(this.a) != null) {
        ARMapConfigManager.a(this.a).saveToFile(ARMapConfigManager.a(this.a).getCurrentAccountUin());
      }
      ARMapConfigManager.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfb
 * JD-Core Version:    0.7.0.1
 */