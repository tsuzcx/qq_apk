import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class acpf
  implements View.OnClickListener
{
  public acpf(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368624: 
      ChatSettingForTroop.f(this.a);
      this.a.finish();
      return;
    }
    ChatSettingForTroop.g(this.a);
    String str2;
    if (this.a.a.isMember)
    {
      paramView = "grpData_admin";
      str2 = this.a.a.troopUin;
      if (!this.a.a.isMember) {
        break label135;
      }
    }
    label135:
    for (String str1 = bdes.a(this.a.a);; str1 = "0")
    {
      bdes.a("Grp_set_new", paramView, "clk_upright", 0, 0, new String[] { str2, str1 });
      return;
      paramView = "grpData_visitor";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpf
 * JD-Core Version:    0.7.0.1
 */