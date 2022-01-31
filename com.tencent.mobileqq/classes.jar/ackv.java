import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class ackv
  implements bhqd
{
  public ackv(ChatSettingForTroop paramChatSettingForTroop, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Beps == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Beps = new beps(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop);
    }
    if (bdee.d(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop))
    {
      paramView = (alzf)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.a(20);
      if (paramView != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.k & 0x1) == 0)
        {
          ChatSettingForTroop localChatSettingForTroop = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop;
          localChatSettingForTroop.k |= 0x1;
          paramView.l(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Beps.b(0, 2131692292, 1000);
      }
    }
    for (;;)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Bhpy.cancel();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Beps.b(2, 2131692288, 1500);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Beps.b(2, 2131694829, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackv
 * JD-Core Version:    0.7.0.1
 */