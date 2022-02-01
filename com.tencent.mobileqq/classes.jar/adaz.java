import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;

public class adaz
  implements bjoe
{
  public adaz(ChatSettingForTroop paramChatSettingForTroop, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Bhhw == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Bhhw = new bhhw(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop);
    }
    if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop))
    {
      paramView = (anca)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getBusinessHandler(20);
      if (paramView != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.k & 0x1) == 0)
        {
          ChatSettingForTroop localChatSettingForTroop = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop;
          localChatSettingForTroop.k |= 0x1;
          paramView.l(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Bhhw.b(0, 2131691949, 1000);
      }
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Bjnw.cancel();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Bhhw.b(2, 2131691945, 1500);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Bhhw.b(2, 2131694108, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adaz
 * JD-Core Version:    0.7.0.1
 */