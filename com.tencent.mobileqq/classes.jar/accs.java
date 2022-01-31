import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class accs
  implements CompoundButton.OnCheckedChangeListener
{
  public accs(SoundAndVibrateActivity paramSoundAndVibrateActivity, SharedPreferences paramSharedPreferences) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramCompoundButton.putBoolean("theme_voice_setting_" + this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.app.getCurrentAccountUin(), paramBoolean);
    paramCompoundButton.commit();
    paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      axqy.b(paramCompoundButton, "CliOper", "", "", "ThemeSound", "SwitchTabSound", 0, i, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     accs
 * JD-Core Version:    0.7.0.1
 */