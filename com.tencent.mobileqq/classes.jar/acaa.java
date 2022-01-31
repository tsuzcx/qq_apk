import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import java.util.ArrayList;
import java.util.Iterator;

public class acaa
  implements Runnable
{
  public acaa(EnterpriseQQManager paramEnterpriseQQManager) {}
  
  public void run()
  {
    if ((EnterpriseQQManager.a(this.a) != null) && (EnterpriseQQManager.a(this.a) != null))
    {
      SosoInterface.a(this.a.a);
      return;
    }
    synchronized (EnterpriseQQManager.a())
    {
      if ((EnterpriseQQManager.a(this.a) == null) || (EnterpriseQQManager.a(this.a).size() <= 0)) {
        break label144;
      }
      Iterator localIterator = EnterpriseQQManager.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        acac localacac = (acac)localIterator.next();
        if (localacac != null) {
          this.a.a(EnterpriseQQManager.a(this.a), EnterpriseQQManager.a(this.a), localacac.a, localacac.b, false, 0.0D, 0.0D);
        }
      }
    }
    EnterpriseQQManager.a(this.a).clear();
    label144:
    EnterpriseQQManager.a(this.a, null);
    EnterpriseQQManager.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     acaa
 * JD-Core Version:    0.7.0.1
 */