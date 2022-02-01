import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;

public class adrw
  implements bkzq
{
  public adrw(ChatSettingForTroop paramChatSettingForTroop, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Biso == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Biso = new biso(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop);
    }
    if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop))
    {
      paramView = (aoep)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (paramView != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.k & 0x1) == 0)
        {
          ChatSettingForTroop localChatSettingForTroop = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop;
          localChatSettingForTroop.k |= 0x1;
          paramView.l(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Biso.b(0, 2131692039, 1000);
      }
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Bkzi.cancel();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Biso.b(2, 2131692035, 1500);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Biso.b(2, 2131694305, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrw
 * JD-Core Version:    0.7.0.1
 */