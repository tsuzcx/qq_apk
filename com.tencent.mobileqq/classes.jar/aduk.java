import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class aduk
  implements CompoundButton.OnCheckedChangeListener
{
  public aduk(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int k = SettingCloneUtil.readValueForInt(this.a, this.a.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.b);
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      SoundAndVibrateActivity.a(this.a).setVisibility(0);
      VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentAccountUin(), "bell", "show", "", 1, 0, 0, "", "", "");
      SoundAndVibrateActivity.b(this.a).setBackgroundResource(2130839269);
      int j = 0;
      paramCompoundButton = ThemeUtil.getUserCurrentThemeId(this.a.app);
      i = j;
      if (!paramCompoundButton.equals("1000"))
      {
        paramCompoundButton = ThemeUtil.getThemeInfo(this.a, paramCompoundButton);
        i = j;
        if (paramCompoundButton != null)
        {
          i = j;
          if (paramCompoundButton.isVoiceTheme) {
            i = 1;
          }
        }
      }
      if (i != 0)
      {
        SoundAndVibrateActivity.c(this.a).setBackgroundResource(2130839253);
        SoundAndVibrateActivity.c(this.a).setVisibility(0);
      }
      if (k == 2131230720)
      {
        SoundAndVibrateActivity.b(this.a).setRightIcon(this.a.getResources().getDrawable(2130850012));
        SoundAndVibrateActivity.c(this.a).setRightIcon(null);
        SoundAndVibrateActivity.d(this.a).setRightIcon(null);
        SoundAndVibrateActivity.e(this.a).setRightIcon(null);
        SoundAndVibrateActivity.a(this.a, 0);
        if (AppSetting.c)
        {
          SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131720238) + this.a.getString(2131690851));
          SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131720239) + this.a.getString(2131721188));
          SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131720240) + this.a.getString(2131721188));
          SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131720241) + this.a.getString(2131721188));
        }
        if (this.a.app.a() != 0) {
          break label1288;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        label460:
        this.a.app.e(1);
        SoundAndVibrateActivity.d(this.a).setChecked(true);
        label482:
        paramCompoundButton = this.a.app;
        if (!paramBoolean) {
          break label1388;
        }
      }
    }
    label1288:
    label1388:
    for (int i = 1;; i = 0)
    {
      azmj.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_sound", 0, i, "", "", "", "");
      return;
      if (k == 2131230721)
      {
        SoundAndVibrateActivity.b(this.a).setRightIcon(null);
        SoundAndVibrateActivity.c(this.a).setRightIcon(this.a.getResources().getDrawable(2130850012));
        SoundAndVibrateActivity.d(this.a).setRightIcon(null);
        SoundAndVibrateActivity.e(this.a).setRightIcon(null);
        SoundAndVibrateActivity.a(this.a, 1);
        if (!AppSetting.c) {
          break;
        }
        SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131720238) + this.a.getString(2131721188));
        SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131720239) + this.a.getString(2131690851));
        SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131720240) + this.a.getString(2131721188));
        SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131720241) + this.a.getString(2131721188));
        break;
      }
      if (k == SoundAndVibrateActivity.jdField_a_of_type_Int)
      {
        SoundAndVibrateActivity.b(this.a).setRightIcon(null);
        SoundAndVibrateActivity.c(this.a).setRightIcon(null);
        SoundAndVibrateActivity.d(this.a).setRightIcon(this.a.getResources().getDrawable(2130850012));
        SoundAndVibrateActivity.e(this.a).setRightIcon(null);
        SoundAndVibrateActivity.a(this.a, 2);
        if (!AppSetting.c) {
          break;
        }
        SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131720238) + this.a.getString(2131721188));
        SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131720239) + this.a.getString(2131721188));
        SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131720240) + this.a.getString(2131690851));
        SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131720241) + this.a.getString(2131721188));
        break;
      }
      if (k != SoundAndVibrateActivity.b) {
        break;
      }
      SoundAndVibrateActivity.b(this.a).setRightIcon(null);
      SoundAndVibrateActivity.c(this.a).setRightIcon(null);
      SoundAndVibrateActivity.d(this.a).setRightIcon(null);
      SoundAndVibrateActivity.e(this.a).setRightIcon(this.a.getResources().getDrawable(2130850012));
      SoundAndVibrateActivity.a(this.a, 3);
      if (!AppSetting.c) {
        break;
      }
      SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131720238) + this.a.getString(2131721188));
      SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131720239) + this.a.getString(2131721188));
      SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131720240) + this.a.getString(2131721188));
      SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131720241) + this.a.getString(2131690851));
      break;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      break label460;
      SoundAndVibrateActivity.b(this.a).setBackgroundResource(2130839253);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      SoundAndVibrateActivity.a(this.a).setVisibility(8);
      SoundAndVibrateActivity.c(this.a).setVisibility(8);
      SoundAndVibrateActivity.c(this.a).setBackgroundResource(2130839253);
      SoundAndVibrateActivity.c(this.a).setVisibility(8);
      this.a.app.e(0);
      break label482;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduk
 * JD-Core Version:    0.7.0.1
 */