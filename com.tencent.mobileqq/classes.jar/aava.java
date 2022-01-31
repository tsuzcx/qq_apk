import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class aava
  implements View.OnClickListener
{
  public aava(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    ChatSettingForTroop.e(this.a);
    bbbp.a("Grp_set_new", "grpData_admin", "clk_quitgrp", 0, 0, new String[] { this.a.a.troopUin, bbbp.a(this.a.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aava
 * JD-Core Version:    0.7.0.1
 */