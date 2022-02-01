import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adva
  implements CompoundButton.OnCheckedChangeListener
{
  public adva(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    auvv.a(this.a.app).a(paramBoolean, this.a.app);
    if (paramBoolean) {
      bdll.b(this.a.app, "CliOper", "", "", "0X8008C75", "0X8008C75", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bdll.b(this.a.app, "CliOper", "", "", "0X8008C74", "0X8008C74", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adva
 * JD-Core Version:    0.7.0.1
 */