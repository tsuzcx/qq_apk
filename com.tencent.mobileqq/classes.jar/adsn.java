import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adsn
  implements View.OnClickListener
{
  public adsn(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "setTroopUinTextViewClickListener onClick");
    }
    ChatSettingForTroop.p(this.a);
    bhbu.a("Grp_set_new", "grpData_admin", "search_upgrade_click", 0, 0, new String[] { this.a.a.troopUin });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsn
 * JD-Core Version:    0.7.0.1
 */