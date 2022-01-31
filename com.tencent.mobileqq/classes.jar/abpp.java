import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import mqq.app.MobileQQ;

public class abpp
  implements CompoundButton.OnCheckedChangeListener
{
  public abpp(NotifyPushSettingActivity paramNotifyPushSettingActivity, ajti paramajti) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((bbfj.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.getApplicationContext())) && (NotifyPushSettingActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity)))
    {
      this.jdField_a_of_type_Ajti.e(paramBoolean);
      return;
    }
    NotifyPushSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, false);
    paramCompoundButton = NotifyPushSettingActivity.i(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity);
    if (!NotifyPushSettingActivity.i(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity).a()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramCompoundButton.setChecked(paramBoolean);
      NotifyPushSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, true);
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.app.getApplication().getString(2131694972), 0).b(5);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abpp
 * JD-Core Version:    0.7.0.1
 */