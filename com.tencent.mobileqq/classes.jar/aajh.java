import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;

public class aajh
  implements CompoundButton.OnCheckedChangeListener
{
  public aajh(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingActivity.a(this.a, this.a.f.a(), paramBoolean);
    AssistantSettingActivity.a(this.a).a(paramBoolean, true);
    if (paramBoolean)
    {
      axqy.b(this.a.app, "dc00898", "", "", "0X8009C0C", "0X8009C0C", 0, 0, "", "", "", "");
      return;
    }
    axqy.b(this.a.app, "dc00898", "", "", "0X8009C0D", "0X8009C0D", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aajh
 * JD-Core Version:    0.7.0.1
 */