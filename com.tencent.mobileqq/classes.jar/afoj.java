import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class afoj
  implements CompoundButton.OnCheckedChangeListener
{
  public afoj(SoundAndVibrateActivity paramSoundAndVibrateActivity, String paramString) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.getString(2131717380), "qqsetting_lock_screen_whenexit_key", paramBoolean);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.app;
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      bdll.b(localQQAppInterface, "CliOper", "", "", "0X80040D9", "0X80040D9", 0, 0, (String)localObject, "", "", "");
      if (QLog.isDevelopLevel()) {
        QLog.i("qqls", 4, "collectPerformance qqls setting isChecked=" + paramBoolean);
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("param_ls_setting", paramBoolean + "");
      bdmc.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.app.getCurrentAccountUin(), "qqlsSettingReprotTag", true, 0L, 0L, (HashMap)localObject, "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afoj
 * JD-Core Version:    0.7.0.1
 */