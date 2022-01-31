import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class aloj
  implements View.OnClickListener
{
  public aloj(FrameHelperActivity paramFrameHelperActivity, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity) {}
  
  public void onClick(View paramView)
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "2", "", "", "");
    if (SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_config", false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startPCActivePolling(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "logout");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity) != null) && (FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).isShowing())) {
      FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aloj
 * JD-Core Version:    0.7.0.1
 */