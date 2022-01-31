import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.sveffects.SLog;
import java.util.ArrayList;

public class ahac
  implements Runnable
{
  public ahac(QmcfManager paramQmcfManager) {}
  
  public void run()
  {
    String str;
    synchronized (QmcfManager.a(this.a))
    {
      if (QmcfManager.a(this.a).size() > 0)
      {
        str = (String)QmcfManager.a(this.a).get(QmcfManager.a(this.a).size() - 1);
        QmcfManager.a(this.a).clear();
      }
    }
    try
    {
      QmcfManager.a(this.a, str);
      this.a.a();
      return;
      if (SLog.a()) {
        SLog.d("QMCF_MGR", "ignore the old switch!");
      }
      return;
      localObject = finally;
      throw localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        SLog.c("QMCF_MGR", "switchModel excep!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahac
 * JD-Core Version:    0.7.0.1
 */