import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aehb
  implements View.OnClickListener
{
  public aehb(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    ChatSettingForTroop.e(this.a);
    bhju.a("Grp_set_new", "grpData_admin", "clk_quitgrp", 0, 0, new String[] { this.a.a.troopUin, bhju.a(this.a.a) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehb
 * JD-Core Version:    0.7.0.1
 */