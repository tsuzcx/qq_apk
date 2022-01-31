import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class adhl
  implements CompoundButton.OnCheckedChangeListener
{
  public adhl(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (NotifyPushSettingActivity.a())
    {
      NotifyPushSettingActivity.b(this.a).setChecked(false);
      NotifyPushSettingActivity.b(this.a).setVisibility(8);
      if (!paramBoolean) {
        break label113;
      }
    }
    label113:
    for (int i = 1;; i = 0)
    {
      azmj.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_hide_text", 0, i, String.valueOf(i), "", "", "");
      return;
      if (paramBoolean)
      {
        NotifyPushSettingActivity.b(this.a).setVisibility(0);
        NotifyPushSettingActivity.b(this.a).setVisibility(8);
        break;
      }
      NotifyPushSettingActivity.b(this.a).setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhl
 * JD-Core Version:    0.7.0.1
 */