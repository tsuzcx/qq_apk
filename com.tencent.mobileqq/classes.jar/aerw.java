import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

public class aerw
  implements CompoundButton.OnCheckedChangeListener
{
  public aerw(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool1 = this.a.a.a().isChecked();
    boolean bool2 = ThemeUtil.isNowThemeIsNight(this.a.app, false, null);
    int j = bdgb.c();
    int i;
    if ((bool1) && (bool2))
    {
      i = bdgb.c;
      if (!paramBoolean) {
        break label140;
      }
      String str = bdgb.a(i);
      if (!behm.a(this.a, str, new aerx(this, paramCompoundButton, bool1, i))) {
        GeneralSettingActivity.a(this.a, paramCompoundButton, true, bool1, i);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = j;
      if (!bool1) {
        break;
      }
      i = j;
      if (!ThemeUtil.isNowThemeIsNight(this.a.app, false, bdgb.a(j))) {
        break;
      }
      i = bdgb.d();
      break;
      label140:
      GeneralSettingActivity.a(this.a, paramCompoundButton, false, bool1, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aerw
 * JD-Core Version:    0.7.0.1
 */