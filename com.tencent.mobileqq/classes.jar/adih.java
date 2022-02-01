import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adih
  implements CompoundButton.OnCheckedChangeListener
{
  public adih(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    aumk.a(this.a.app).a(paramBoolean, this.a.app);
    if (paramBoolean) {
      bdla.b(this.a.app, "CliOper", "", "", "0X8008C75", "0X8008C75", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bdla.b(this.a.app, "CliOper", "", "", "0X8008C74", "0X8008C74", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adih
 * JD-Core Version:    0.7.0.1
 */