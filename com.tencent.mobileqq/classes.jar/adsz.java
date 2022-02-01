import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adsz
  implements CompoundButton.OnCheckedChangeListener
{
  public adsz(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (((Boolean)paramCompoundButton.getTag()).booleanValue()) {
      paramCompoundButton.setTag(Boolean.FALSE);
    }
    int i;
    do
    {
      do
      {
        do
        {
          EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
          return;
        } while (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null);
        i = this.a.app.getTroopMask(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      } while (i == -1);
      if (!paramBoolean) {
        break;
      }
    } while (i != 1);
    ChatSettingForTroop.a(this.a, 4);
    label82:
    if (ChatSettingForTroop.a(this.a) != null) {
      ChatSettingForTroop.d(this.a);
    }
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean)
    {
      str = "msg_open";
      label116:
      bdla.b(localQQAppInterface, "dc00899", "Grp_msg", "", "Grp_data", str, 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      if (!paramBoolean) {
        break label224;
      }
    }
    label224:
    for (String str = "msg_open";; str = "msg_close")
    {
      bhbu.a("Grp_msg", "grpData_admin", str, 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      break;
      if (i == 1) {
        break;
      }
      ChatSettingForTroop.a(this.a, 1);
      break label82;
      str = "msg_close";
      break label116;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsz
 * JD-Core Version:    0.7.0.1
 */