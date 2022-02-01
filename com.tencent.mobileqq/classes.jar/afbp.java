import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afbp
  implements CompoundButton.OnCheckedChangeListener
{
  public afbp(NotifyPushSettingActivity paramNotifyPushSettingActivity, anum paramanum) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.getString(2131716143), "qqsetting_special_care_bar", paramBoolean);
    this.jdField_a_of_type_Anum.c(paramBoolean);
    blhw.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 2, "onCheckedChanged: invoked. care bar  isChecked: " + paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbp
 * JD-Core Version:    0.7.0.1
 */