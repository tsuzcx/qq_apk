import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;

public class abzz
  implements CompoundButton.OnCheckedChangeListener
{
  public abzz(AssistantSettingActivity paramAssistantSettingActivity, apfp paramapfp) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_Apfp.a(paramBoolean);
    if (!paramBoolean)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.app, "dc00898", "", "", "0X80081DD", "0X80081DD", 0, 0, "", "", "", "");
      return;
    }
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.app, "dc00898", "", "", "0X80081F1", "0X80081F1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzz
 * JD-Core Version:    0.7.0.1
 */