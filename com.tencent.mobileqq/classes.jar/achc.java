import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import java.util.ArrayList;
import java.util.Iterator;

public class achc
  implements Runnable
{
  public achc(EnterpriseQQManager paramEnterpriseQQManager) {}
  
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
        ache localache = (ache)localIterator.next();
        if (localache != null) {
          this.a.a(EnterpriseQQManager.a(this.a), EnterpriseQQManager.a(this.a), localache.a, localache.b, false, 0.0D, 0.0D);
        }
      }
    }
    EnterpriseQQManager.a(this.a).clear();
    label144:
    EnterpriseQQManager.a(this.a, null);
    EnterpriseQQManager.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achc
 * JD-Core Version:    0.7.0.1
 */