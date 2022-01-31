import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.widget.Switch;

public class aaxm
  implements CompoundButton.OnCheckedChangeListener
{
  public aaxm(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool1 = this.a.a.a().isChecked();
    boolean bool2 = ThemeUtil.isNowThemeIsNight(this.a.app, false, null);
    int j = awnu.c();
    int i;
    if ((bool1) && (bool2)) {
      i = awnu.b;
    }
    while (paramBoolean)
    {
      String str = awnp.b[i];
      if (!axkz.a(this.a, str, new aaxn(this, paramCompoundButton, bool1, i))) {
        GeneralSettingActivity.a(this.a, paramCompoundButton, true, bool1, i);
      }
      return;
      i = j;
      if (bool1)
      {
        i = j;
        if (ThemeUtil.isNowThemeIsNight(this.a.app, false, awnp.b[j])) {
          i = awnu.d();
        }
      }
    }
    GeneralSettingActivity.a(this.a, paramCompoundButton, false, bool1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaxm
 * JD-Core Version:    0.7.0.1
 */