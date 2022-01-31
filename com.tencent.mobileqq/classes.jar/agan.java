import com.tencent.mobileqq.now.enter.NowHongbaoPushManager;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager.Callback;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class agan
  implements Runnable
{
  public agan(NowHongbaoPushManager paramNowHongbaoPushManager, NowHongbaoPushManager.Entity paramEntity, int paramInt) {}
  
  public void run()
  {
    if (NowHongbaoPushManager.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager) != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.type != 2) {
        break label124;
      }
      NowHongbaoPushManager.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager).b();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.notifyClose();
      if (QLog.isColorLevel()) {
        QLog.i("NowHongbaoPushManager", 2, (String)NowHongbaoPushManager.a().get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.type)) + ",隐藏---type=" + this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.type + ", reason =" + (String)NowHongbaoPushManager.b().get(Integer.valueOf(this.jdField_a_of_type_Int)));
      }
      return;
      label124:
      if (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.type == 3) {
        NowHongbaoPushManager.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager).a();
      } else if (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.type == 1) {
        NowHongbaoPushManager.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager).c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agan
 * JD-Core Version:    0.7.0.1
 */