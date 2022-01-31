import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProxyObserver;
import com.tencent.qphone.base.util.QLog;

public class aemw
  extends NearbyProxyObserver
{
  public aemw(NearbyProxy paramNearbyProxy, int paramInt) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("realHasUnreadMsg", new Object[] { "onNearbyProcStart" });
    }
    NearbyProxy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyProxy, 4100, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aemw
 * JD-Core Version:    0.7.0.1
 */