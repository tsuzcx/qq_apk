import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adwp
  implements View.OnClickListener
{
  public adwp(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131368947: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ChatSettingForTroop.f(this.a);
        this.a.finish();
      }
    }
    ChatSettingForTroop.g(this.a);
    String str1;
    label80:
    String str3;
    if (this.a.a.isMember)
    {
      str1 = "grpData_admin";
      str3 = this.a.a.troopUin;
      if (!this.a.a.isMember) {
        break label148;
      }
    }
    label148:
    for (String str2 = bgjt.a(this.a.a);; str2 = "0")
    {
      bgjt.a("Grp_set_new", str1, "clk_upright", 0, 0, new String[] { str3, str2 });
      break;
      str1 = "grpData_visitor";
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwp
 * JD-Core Version:    0.7.0.1
 */