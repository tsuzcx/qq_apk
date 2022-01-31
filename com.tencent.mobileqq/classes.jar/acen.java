import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.ark.setting.ArkAppListActivity;
import java.util.ArrayList;

public class acen
  implements View.OnClickListener
{
  public acen(AssistantSettingActivity paramAssistantSettingActivity, ArrayList paramArrayList) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity, ArkAppListActivity.class);
    paramView.putExtra("intent_extra_authority_app_list", (String[])this.jdField_a_of_type_JavaUtilArrayList.toArray(new String[this.jdField_a_of_type_JavaUtilArrayList.size()]));
    this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acen
 * JD-Core Version:    0.7.0.1
 */