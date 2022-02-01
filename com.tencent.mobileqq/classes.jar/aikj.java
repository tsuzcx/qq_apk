import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aikj
  implements View.OnClickListener
{
  aikj(aiki paramaiki) {}
  
  public void onClick(View paramView)
  {
    bdla.b(aiki.a(this.a), "CliOper", "", "", "Free_call", "Clk_free_call_tips", 0, 0, "", "", "", "");
    aiki.c(aiki.a(this.a), aiki.a(this.a).curFriendUin);
    aiki.a(this.a).a();
    String str1 = null;
    String str2 = null;
    if (aiki.a(this.a).curType == 1006) {
      str2 = aiki.a(this.a).curFriendUin;
    }
    for (;;)
    {
      ChatActivityUtils.a(aiki.a(this.a), aiki.a(this.a), aiki.a(this.a).curType, str1, aiki.a(this.a).curFriendNick, str2, true, aiki.a(this.a).troopUin, true, true, null, "from_internal");
      bdla.b(aiki.a(this.a), "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "8", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str1 = aiki.a(this.a).curFriendUin;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikj
 * JD-Core Version:    0.7.0.1
 */