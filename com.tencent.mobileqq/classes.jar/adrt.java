import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class adrt
  implements bkzq
{
  public adrt(ChatSettingForTroop paramChatSettingForTroop, bkzi parambkzi) {}
  
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
    paramView = (aoep)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if ((NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getApp().getApplicationContext())) && (paramView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Biso.b(0, 2131692036, 0);
      paramView.k(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Bkzi.cancel();
      return;
      if (paramView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Biso.b(2, 2131694305, 1500);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_Biso.b(2, 2131692035, 1500);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrt
 * JD-Core Version:    0.7.0.1
 */