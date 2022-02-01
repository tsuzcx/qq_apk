import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adio
  implements CompoundButton.OnCheckedChangeListener
{
  public adio(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingActivity.a(this.a, this.a.g.a(), paramBoolean);
    AssistantSettingActivity.a(this.a).a(paramBoolean, true);
    if (paramBoolean) {
      bdla.b(this.a.app, "dc00898", "", "", "0X8009C0C", "0X8009C0C", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bdla.b(this.a.app, "dc00898", "", "", "0X8009C0D", "0X8009C0D", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adio
 * JD-Core Version:    0.7.0.1
 */