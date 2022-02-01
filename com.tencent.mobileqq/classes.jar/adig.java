import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adig
  implements CompoundButton.OnCheckedChangeListener
{
  public adig(AssistantSettingActivity paramAssistantSettingActivity, asaa paramasaa) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_Asaa.a(paramBoolean);
    if (!paramBoolean) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.app, "dc00898", "", "", "0X80081DD", "0X80081DD", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.app, "dc00898", "", "", "0X80081F1", "0X80081F1", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adig
 * JD-Core Version:    0.7.0.1
 */