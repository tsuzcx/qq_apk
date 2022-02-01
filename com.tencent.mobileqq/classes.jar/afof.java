import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afof
  implements CompoundButton.OnCheckedChangeListener
{
  public afof(SoundAndVibrateActivity paramSoundAndVibrateActivity, SharedPreferences paramSharedPreferences) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putBoolean("theme_voice_setting_" + this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.app.getCurrentAccountUin(), paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      bdll.b((QQAppInterface)localObject, "CliOper", "", "", "ThemeSound", "SwitchTabSound", 0, i, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afof
 * JD-Core Version:    0.7.0.1
 */