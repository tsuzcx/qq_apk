import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.widget.Switch;

public class abhf
  implements CompoundButton.OnCheckedChangeListener
{
  public abhf(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool1 = this.a.a.a().isChecked();
    boolean bool2 = ThemeUtil.isNowThemeIsNight(this.a.app, false, null);
    int j = axmv.c();
    int i;
    if ((bool1) && (bool2)) {
      i = axmv.b;
    }
    while (paramBoolean)
    {
      String str = axmq.b[i];
      if (!aylh.a(this.a, str, new abhg(this, paramCompoundButton, bool1, i))) {
        GeneralSettingActivity.a(this.a, paramCompoundButton, true, bool1, i);
      }
      return;
      i = j;
      if (bool1)
      {
        i = j;
        if (ThemeUtil.isNowThemeIsNight(this.a.app, false, axmq.b[j])) {
          i = axmv.d();
        }
      }
    }
    GeneralSettingActivity.a(this.a, paramCompoundButton, false, bool1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abhf
 * JD-Core Version:    0.7.0.1
 */