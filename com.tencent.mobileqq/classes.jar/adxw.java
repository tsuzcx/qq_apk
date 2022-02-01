import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adxw
  implements CompoundButton.OnCheckedChangeListener
{
  public adxw(ChatSettingForTroop paramChatSettingForTroop) {}
  
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
        } while (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null);
        i = this.a.app.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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
      bcst.b(localQQAppInterface, "dc00899", "Grp_msg", "", "Grp_data", str, 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      if (!paramBoolean) {
        break label224;
      }
    }
    label224:
    for (String str = "msg_open";; str = "msg_close")
    {
      bgjt.a("Grp_msg", "grpData_admin", str, 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bgjt.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
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
 * Qualified Name:     adxw
 * JD-Core Version:    0.7.0.1
 */