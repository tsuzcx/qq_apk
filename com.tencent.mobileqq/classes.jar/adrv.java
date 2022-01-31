import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;
import com.tencent.qphone.base.util.QLog;

class adrv
  implements Runnable
{
  adrv(adru paramadru) {}
  
  public void run()
  {
    PresenceInterfaceImpl.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    PresenceInterfaceImpl.a(this.a.jdField_a_of_type_ComTencentMobileqqHotpicPresenceInterfaceImpl, true);
    this.a.jdField_a_of_type_ComTencentMobileqqHotpicPresenceInterfaceImpl.a(0, this.a.jdField_a_of_type_ComTencentMobileqqHotpicPresenceInterfaceImpl.a);
    QLog.d("PresenceInterfaceImpl", 2, "saveUserPermission true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrv
 * JD-Core Version:    0.7.0.1
 */