import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class aalh
  implements CompoundButton.OnCheckedChangeListener
{
  public aalh(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (((Boolean)paramCompoundButton.getTag()).booleanValue()) {
      paramCompoundButton.setTag(Boolean.FALSE);
    }
    label20:
    int i;
    do
    {
      do
      {
        break label20;
        do
        {
          return;
        } while (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null);
        i = this.a.app.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      } while (i == -1);
      if (!paramBoolean) {
        break;
      }
    } while (i != 1);
    ChatSettingForTroop.a(this.a, 4);
    label74:
    if (ChatSettingForTroop.a(this.a) != null) {
      ChatSettingForTroop.d(this.a);
    }
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean)
    {
      paramCompoundButton = "msg_open";
      label107:
      awqx.b(localQQAppInterface, "dc00899", "Grp_msg", "", "Grp_data", paramCompoundButton, 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      if (!paramBoolean) {
        break label209;
      }
    }
    label209:
    for (paramCompoundButton = "msg_open";; paramCompoundButton = "msg_close")
    {
      azzx.a("Grp_msg", "grpData_admin", paramCompoundButton, 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, azzx.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      if (i == 1) {
        break;
      }
      ChatSettingForTroop.a(this.a, 1);
      break label74;
      paramCompoundButton = "msg_close";
      break label107;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aalh
 * JD-Core Version:    0.7.0.1
 */