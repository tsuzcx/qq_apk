import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahpn
  implements View.OnClickListener
{
  ahpn(ahpm paramahpm) {}
  
  public void onClick(View paramView)
  {
    bcef.b(ahpm.a(this.a), "CliOper", "", "", "Free_call", "Clk_free_call_tips", 0, 0, "", "", "", "");
    ahpm.c(ahpm.a(this.a), ahpm.a(this.a).curFriendUin);
    ahpm.a(this.a).a();
    String str1 = null;
    String str2 = null;
    if (ahpm.a(this.a).curType == 1006) {
      str2 = ahpm.a(this.a).curFriendUin;
    }
    for (;;)
    {
      ChatActivityUtils.a(ahpm.a(this.a), ahpm.a(this.a), ahpm.a(this.a).curType, str1, ahpm.a(this.a).curFriendNick, str2, true, ahpm.a(this.a).troopUin, true, true, null, "from_internal");
      bcef.b(ahpm.a(this.a), "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "8", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str1 = ahpm.a(this.a).curFriendUin;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpn
 * JD-Core Version:    0.7.0.1
 */