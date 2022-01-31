import com.tencent.mobileqq.now.enter.NowHongbaoPushManager;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager.Callback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class afni
  implements Runnable
{
  public afni(NowHongbaoPushManager paramNowHongbaoPushManager, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (NowHongbaoPushManager.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager) != null)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label108;
      }
      NowHongbaoPushManager.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager).b();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NowHongbaoPushManager", 2, (String)NowHongbaoPushManager.a().get(Integer.valueOf(this.jdField_a_of_type_Int)) + ",隐藏---type=" + this.jdField_a_of_type_Int + ", reason = " + (String)NowHongbaoPushManager.b().get(Integer.valueOf(this.b)));
      }
      return;
      label108:
      if (this.jdField_a_of_type_Int == 3) {
        NowHongbaoPushManager.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager).a();
      } else if (this.jdField_a_of_type_Int == 1) {
        NowHongbaoPushManager.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager).c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     afni
 * JD-Core Version:    0.7.0.1
 */