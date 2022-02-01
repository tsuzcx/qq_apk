import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adrk
  implements View.OnClickListener
{
  public adrk(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    TroopUtils.doReportTroop(this.a, this.a.a, this.a.app);
    bhbu.a("Grp_set_new", "grpData_admin", "tipoff_click", 0, 0, new String[] { this.a.a.troopUin });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrk
 * JD-Core Version:    0.7.0.1
 */