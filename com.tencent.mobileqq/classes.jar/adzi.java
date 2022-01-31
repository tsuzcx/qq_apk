import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class adzi
  extends ShieldListObserver
{
  public adzi(NearbyProxy paramNearbyProxy) {}
  
  protected void a(boolean paramBoolean, List paramList, int paramInt)
  {
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProxy", 2, "onAddShieldList from nearby");
      }
      NearbyProxy.a(this.a, 4113, new Object[] { Boolean.valueOf(paramBoolean), paramList });
    }
  }
  
  protected void b(boolean paramBoolean, List paramList, int paramInt)
  {
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProxy", 2, "onDeleteShieldList from nearby");
      }
      NearbyProxy.a(this.a, 4114, new Object[] { Boolean.valueOf(paramBoolean), paramList });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adzi
 * JD-Core Version:    0.7.0.1
 */