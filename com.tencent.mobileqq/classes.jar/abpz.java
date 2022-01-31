import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class abpz
  implements CompoundButton.OnCheckedChangeListener
{
  public abpz(NotifyPushSettingActivity paramNotifyPushSettingActivity, ajti paramajti) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.getString(2131717486), "qqsetting_special_care_bar", paramBoolean);
    this.jdField_a_of_type_Ajti.c(paramBoolean);
    bfoi.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 2, "onCheckedChanged: invoked. care bar  isChecked: " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abpz
 * JD-Core Version:    0.7.0.1
 */