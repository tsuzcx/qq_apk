import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.RedPacketConfig;
import com.tencent.qphone.base.util.QLog;

public class agre
  implements Runnable
{
  public agre(PortalManager paramPortalManager, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null)
    {
      if ((this.jdField_a_of_type_Long <= 0L) || (this.jdField_a_of_type_Long > 60000L) || (PortalManager.jdField_a_of_type_Long == this.jdField_a_of_type_Long)) {
        break label294;
      }
      PortalManager.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.grebInterval == PortalManager.jdField_a_of_type_Long) {
        break label294;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.grebInterval = PortalManager.jdField_a_of_type_Long;
    }
    label294:
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.b != -1L)
      {
        i = j;
        if (PortalManager.b != this.b)
        {
          PortalManager.b = this.b;
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.reportActiveInterval != PortalManager.b)
          {
            this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.reportActiveInterval = PortalManager.b;
            i = 1;
          }
        }
      }
      j = i;
      if (this.c != -1L)
      {
        j = i;
        if (PortalManager.c != this.c)
        {
          PortalManager.c = this.c;
          j = i;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.reportNormalInterval != PortalManager.c)
          {
            this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.reportNormalInterval = PortalManager.c;
            j = 1;
          }
        }
      }
      if (j != 0) {
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "sGrabInterval = " + PortalManager.jdField_a_of_type_Long + ",sReportActiveInterval = " + PortalManager.b + ",sReportNormalInterval = " + PortalManager.c);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agre
 * JD-Core Version:    0.7.0.1
 */