import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aduf
  implements CompoundButton.OnCheckedChangeListener
{
  public aduf(SoundAndVibrateActivity paramSoundAndVibrateActivity, String paramString) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.getString(2131719109), "qqsetting_lock_screen_whenexit_key", paramBoolean);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.app;
    if (paramBoolean) {}
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      azmj.b(localQQAppInterface, "CliOper", "", "", "0X80040D9", "0X80040D9", 0, 0, paramCompoundButton, "", "", "");
      if (QLog.isDevelopLevel()) {
        QLog.i("qqls", 4, "collectPerformance qqls setting isChecked=" + paramBoolean);
      }
      paramCompoundButton = new HashMap();
      paramCompoundButton.put("param_ls_setting", paramBoolean + "");
      azmz.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.app.getCurrentAccountUin(), "qqlsSettingReprotTag", true, 0L, 0L, paramCompoundButton, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduf
 * JD-Core Version:    0.7.0.1
 */