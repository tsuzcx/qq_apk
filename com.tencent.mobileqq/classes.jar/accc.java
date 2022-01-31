import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.floatscr.ColorScreenConfig;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.mobileqq.vas.VasMonitorHandler;

class accc
  implements VasManager.CompleteListener
{
  accc(acbg paramacbg, int paramInt, SVIPHandler paramSVIPHandler, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void a(ColorScreenConfig paramColorScreenConfig, Object paramObject)
  {
    paramObject = new Bundle();
    paramObject.putInt("id", this.jdField_a_of_type_Int);
    if ((paramColorScreenConfig != null) || (this.jdField_a_of_type_Int == 0))
    {
      paramObject.putInt("result", 0);
      this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramObject);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      VasMonitorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_colorscreen_set_fail", "0", "", Integer.toString(this.jdField_a_of_type_Int), null, null, 0.0F, 0.0F);
      paramObject.putInt("result", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     accc
 * JD-Core Version:    0.7.0.1
 */