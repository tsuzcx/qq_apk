import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adrs
  implements View.OnClickListener
{
  public adrs(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369231: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ChatSettingForTroop.g(this.a);
        this.a.finish();
      }
    }
    if (this.a.jdField_a_of_type_Bgua != null) {
      this.a.jdField_a_of_type_Bgua.e();
    }
    this.a.jdField_a_of_type_Bgua = TroopUtils.shareTroop(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.a.app);
    bhbu.a("Grp_set_new", "grpData_admin", "share_click", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
    String str1;
    label149:
    String str3;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
    {
      str1 = "grpData_admin";
      str3 = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label217;
      }
    }
    label217:
    for (String str2 = bhbu.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);; str2 = "0")
    {
      bhbu.a("Grp_set_new", str1, "clk_upright", 0, 0, new String[] { str3, str2 });
      break;
      str1 = "grpData_visitor";
      break label149;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrs
 * JD-Core Version:    0.7.0.1
 */