import com.tencent.mobileqq.now.enter.NowEnterManager;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager.Callback;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aget
  implements Runnable
{
  public aget(NowHongbaoPushManager paramNowHongbaoPushManager, NowHongbaoPushManager.Entity paramEntity) {}
  
  public void run()
  {
    boolean bool;
    if (!this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.isThisStateNotified(1)) {
      if (NowHongbaoPushManager.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager) != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.type != 2) {
          break label152;
        }
        bool = NowHongbaoPushManager.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager).b(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager.a.c(), this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager.a.d());
      }
    }
    for (;;)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.notifyShow();
        label76:
        if (QLog.isColorLevel()) {
          QLog.i("NowHongbaoPushManager", 2, (String)NowHongbaoPushManager.a().get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.type)) + ", 显示---type= " + this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.type + ", success = " + bool);
        }
      }
      for (;;)
      {
        NowHongbaoPushManager.c(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager);
        return;
        label152:
        if (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.type == 3)
        {
          bool = NowHongbaoPushManager.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager).a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager.a.b(), this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager.a.a());
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.type != 1) {
          break label310;
        }
        String str = this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager.a.a();
        bool = NowHongbaoPushManager.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager).a(str);
        break;
        this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.resetNotifyState();
        break label76;
        if (QLog.isColorLevel()) {
          QLog.i("NowHongbaoPushManager", 2, (String)NowHongbaoPushManager.a().get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.type)) + ", 显示(已显示)---type=" + this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.type);
        }
      }
      label310:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aget
 * JD-Core Version:    0.7.0.1
 */