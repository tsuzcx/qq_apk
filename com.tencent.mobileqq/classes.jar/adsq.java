import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adsq
  implements View.OnClickListener
{
  public adsq(ChatSettingForTroop paramChatSettingForTroop, bkzi parambkzi) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bkzi.dismiss();
    bhbu.a("Grp_set_new", "grpData_admin", "search_upgrade_actionsheet_click cancel", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.troopUin });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsq
 * JD-Core Version:    0.7.0.1
 */