import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class abqq
  implements Runnable
{
  public abqq(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 2002) {
      str = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.getString(2131428347);
    }
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.a = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity, 230).setMessage(str).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.getString(2131428346), new abqr(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.a.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.a.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("DynamicAvatarRecordActivity", 2, "", localBadTokenException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqq
 * JD-Core Version:    0.7.0.1
 */