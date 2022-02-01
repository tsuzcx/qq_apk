import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class advp
  implements CompoundButton.OnCheckedChangeListener
{
  public advp(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingActivity.a(this.a, this.a.f.a(), paramBoolean);
    AssistantSettingActivity.a(this.a).a(paramBoolean, true);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advp
 * JD-Core Version:    0.7.0.1
 */