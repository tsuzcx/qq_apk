import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class acdc
  implements CompoundButton.OnCheckedChangeListener
{
  public acdc(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean)
    {
      SoundAndVibrateActivity.b(this.a, 0);
      SoundAndVibrateActivity.e(this.a).setBackgroundResource(2130839185);
      if (this.a.app.b() == 0)
      {
        this.a.b.setChecked(false);
        this.a.app.f(1);
        label61:
        paramCompoundButton = this.a.app;
        if (!paramBoolean) {
          break label147;
        }
      }
    }
    for (;;)
    {
      axqy.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_shake", 0, i, "", "", "", "");
      return;
      this.a.b.setChecked(true);
      break;
      SoundAndVibrateActivity.b(this.a, 8);
      SoundAndVibrateActivity.e(this.a).setBackgroundResource(2130839169);
      this.a.app.f(0);
      break label61;
      label147:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acdc
 * JD-Core Version:    0.7.0.1
 */