import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.RedPacketConfig;
import com.tencent.qphone.base.util.QLog;

public class agrf
  implements Runnable
{
  public agrf(PortalManager paramPortalManager, PortalManager.RedPacketConfig paramRedPacketConfig) {}
  
  public void run()
  {
    try
    {
      PortalManager.a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PortalManager", 2, "report exception =" + localThrowable.getMessage());
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrf
 * JD-Core Version:    0.7.0.1
 */