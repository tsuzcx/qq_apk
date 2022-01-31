import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class acpg
  extends SosoInterface.OnLocationListener
{
  public acpg(EnterpriseQQManager paramEnterpriseQQManager, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo arg2)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("EnterpriseQQManager", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if (paramInt == 0) {
      paramInt = i;
    }
    acph localacph;
    label219:
    while (paramInt != 0)
    {
      ??? = ???.a;
      double d1 = ???.a;
      double d2 = ???.b;
      EnterpriseQQManager.a(this.a, d1);
      EnterpriseQQManager.b(this.a, d2);
      EnterpriseQQManager.a(this.a, System.currentTimeMillis());
      synchronized (EnterpriseQQManager.a())
      {
        if ((EnterpriseQQManager.a(this.a) == null) || (EnterpriseQQManager.a(this.a).size() <= 0)) {
          break label219;
        }
        Iterator localIterator1 = EnterpriseQQManager.a(this.a).iterator();
        do
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localacph = (acph)localIterator1.next();
        } while (localacph == null);
        this.a.a(EnterpriseQQManager.a(this.a), EnterpriseQQManager.a(this.a), localacph.a, localacph.b, true, d1, d2);
      }
      paramInt = 0;
      continue;
      EnterpriseQQManager.a(this.a).clear();
    }
    label362:
    for (;;)
    {
      EnterpriseQQManager.a(this.a, null);
      EnterpriseQQManager.a(this.a, null);
      return;
      synchronized (EnterpriseQQManager.a())
      {
        if ((EnterpriseQQManager.a(this.a) == null) || (EnterpriseQQManager.a(this.a).size() <= 0)) {
          break label362;
        }
        Iterator localIterator2 = EnterpriseQQManager.a(this.a).iterator();
        while (localIterator2.hasNext())
        {
          localacph = (acph)localIterator2.next();
          if (localacph != null) {
            this.a.a(EnterpriseQQManager.a(this.a), EnterpriseQQManager.a(this.a), localacph.a, localacph.b, false, 0.0D, 0.0D);
          }
        }
      }
      EnterpriseQQManager.a(this.a).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpg
 * JD-Core Version:    0.7.0.1
 */