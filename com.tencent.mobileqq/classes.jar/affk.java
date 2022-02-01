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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class affk
  implements CompoundButton.OnCheckedChangeListener
{
  public affk(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int k = SettingCloneUtil.readValueForInt(this.a, this.a.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.b);
    Object localObject;
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      SoundAndVibrateActivity.a(this.a).setVisibility(0);
      VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentAccountUin(), "bell", "show", "", 1, 0, 0, "", "", "");
      SoundAndVibrateActivity.b(this.a).setBackgroundResource(2130839448);
      int j = 0;
      localObject = ThemeUtil.getUserCurrentThemeId(this.a.app);
      i = j;
      if (!((String)localObject).equals("1000"))
      {
        localObject = ThemeUtil.getThemeInfo(this.a, (String)localObject);
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((ThemeUtil.ThemeInfo)localObject).isVoiceTheme) {
            i = 1;
          }
        }
      }
      if (i != 0)
      {
        SoundAndVibrateActivity.c(this.a).setBackgroundResource(2130839432);
        SoundAndVibrateActivity.c(this.a).setVisibility(0);
      }
      if (k == 2131230720)
      {
        SoundAndVibrateActivity.b(this.a).setRightIcon(this.a.getResources().getDrawable(2130850678));
        SoundAndVibrateActivity.c(this.a).setRightIcon(null);
        SoundAndVibrateActivity.d(this.a).setRightIcon(null);
        SoundAndVibrateActivity.e(this.a).setRightIcon(null);
        SoundAndVibrateActivity.a(this.a, 0);
        if (AppSetting.c)
        {
          SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131718171) + this.a.getString(2131690708));
          SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131718172) + this.a.getString(2131718933));
          SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131718173) + this.a.getString(2131718933));
          SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131718174) + this.a.getString(2131718933));
        }
        if (this.a.app.a() != 0) {
          break label1304;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        label466:
        this.a.app.e(1);
        SoundAndVibrateActivity.d(this.a).setChecked(true);
        label488:
        localObject = this.a.app;
        if (!paramBoolean) {
          break label1404;
        }
      }
    }
    label1304:
    label1404:
    for (int i = 1;; i = 0)
    {
      bcst.b((QQAppInterface)localObject, "CliOper", "", "", "Setting_tab", "Clk_notice_sound", 0, i, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (k == 2131230721)
      {
        SoundAndVibrateActivity.b(this.a).setRightIcon(null);
        SoundAndVibrateActivity.c(this.a).setRightIcon(this.a.getResources().getDrawable(2130850678));
        SoundAndVibrateActivity.d(this.a).setRightIcon(null);
        SoundAndVibrateActivity.e(this.a).setRightIcon(null);
        SoundAndVibrateActivity.a(this.a, 1);
        if (!AppSetting.c) {
          break;
        }
        SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131718171) + this.a.getString(2131718933));
        SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131718172) + this.a.getString(2131690708));
        SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131718173) + this.a.getString(2131718933));
        SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131718174) + this.a.getString(2131718933));
        break;
      }
      if (k == SoundAndVibrateActivity.jdField_a_of_type_Int)
      {
        SoundAndVibrateActivity.b(this.a).setRightIcon(null);
        SoundAndVibrateActivity.c(this.a).setRightIcon(null);
        SoundAndVibrateActivity.d(this.a).setRightIcon(this.a.getResources().getDrawable(2130850678));
        SoundAndVibrateActivity.e(this.a).setRightIcon(null);
        SoundAndVibrateActivity.a(this.a, 2);
        if (!AppSetting.c) {
          break;
        }
        SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131718171) + this.a.getString(2131718933));
        SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131718172) + this.a.getString(2131718933));
        SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131718173) + this.a.getString(2131690708));
        SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131718174) + this.a.getString(2131718933));
        break;
      }
      if (k != SoundAndVibrateActivity.b) {
        break;
      }
      SoundAndVibrateActivity.b(this.a).setRightIcon(null);
      SoundAndVibrateActivity.c(this.a).setRightIcon(null);
      SoundAndVibrateActivity.d(this.a).setRightIcon(null);
      SoundAndVibrateActivity.e(this.a).setRightIcon(this.a.getResources().getDrawable(2130850678));
      SoundAndVibrateActivity.a(this.a, 3);
      if (!AppSetting.c) {
        break;
      }
      SoundAndVibrateActivity.b(this.a).setContentDescription(this.a.getString(2131718171) + this.a.getString(2131718933));
      SoundAndVibrateActivity.c(this.a).setContentDescription(this.a.getString(2131718172) + this.a.getString(2131718933));
      SoundAndVibrateActivity.d(this.a).setContentDescription(this.a.getString(2131718173) + this.a.getString(2131718933));
      SoundAndVibrateActivity.e(this.a).setContentDescription(this.a.getString(2131718174) + this.a.getString(2131690708));
      break;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      break label466;
      SoundAndVibrateActivity.b(this.a).setBackgroundResource(2130839432);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      SoundAndVibrateActivity.a(this.a).setVisibility(8);
      SoundAndVibrateActivity.c(this.a).setVisibility(8);
      SoundAndVibrateActivity.c(this.a).setBackgroundResource(2130839432);
      SoundAndVibrateActivity.c(this.a).setVisibility(8);
      this.a.app.e(0);
      break label488;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affk
 * JD-Core Version:    0.7.0.1
 */