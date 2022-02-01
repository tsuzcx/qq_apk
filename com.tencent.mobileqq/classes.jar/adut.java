import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adut
  implements CompoundButton.OnCheckedChangeListener
{
  public adut(AssistantSettingActivity paramAssistantSettingActivity, anyw paramanyw) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_Anyw.a(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adut
 * JD-Core Version:    0.7.0.1
 */