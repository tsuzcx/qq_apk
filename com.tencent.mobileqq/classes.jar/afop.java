import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afop
  implements CompoundButton.OnCheckedChangeListener
{
  public afop(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    label61:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      SoundAndVibrateActivity.b(this.a, 0);
      SoundAndVibrateActivity.e(this.a).setBackgroundResource(2130839456);
      if (this.a.app.b() == 0)
      {
        this.a.b.setChecked(false);
        this.a.app.f(1);
        localQQAppInterface = this.a.app;
        if (!paramBoolean) {
          break label157;
        }
      }
    }
    for (;;)
    {
      bdll.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_notice_shake", 0, i, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      this.a.b.setChecked(true);
      break;
      SoundAndVibrateActivity.b(this.a, 8);
      SoundAndVibrateActivity.e(this.a).setBackgroundResource(2130839440);
      this.a.app.f(0);
      break label61;
      label157:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afop
 * JD-Core Version:    0.7.0.1
 */