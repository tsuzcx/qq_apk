import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class adtx
  implements CompoundButton.OnCheckedChangeListener
{
  public adtx(SoundAndVibrateActivity paramSoundAndVibrateActivity, String paramString) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (NotifyPushSettingActivity.a())
    {
      SoundAndVibrateActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity).setChecked(false);
      SoundAndVibrateActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity).setVisibility(8);
      SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.getString(2131719346), "qqsetting_notify_showcontent_key", paramBoolean);
      if (!paramBoolean) {
        break label124;
      }
    }
    label124:
    for (int i = 1;; i = 0)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.app, "CliOper", "", "", "Setting_tab", "Clk_hide_text", 0, i, String.valueOf(i), "", "", "");
      return;
      if (paramBoolean)
      {
        SoundAndVibrateActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity).setVisibility(0);
        break;
      }
      SoundAndVibrateActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity).setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtx
 * JD-Core Version:    0.7.0.1
 */