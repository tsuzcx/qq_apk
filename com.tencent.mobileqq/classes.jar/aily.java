import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aily
  implements View.OnClickListener
{
  aily(ailw paramailw) {}
  
  public void onClick(View paramView)
  {
    ailw.a(this.a).setTroopMsgFilterToServer(ailw.a(this.a).curFriendUin, Integer.valueOf(4));
    ailw.a(this.a).a();
    awtz.a().c(ailw.a(this.a).curFriendUin, ailw.a(this.a));
    awtz.a().c(ailw.a(this.a), ailw.a(this.a).curFriendUin);
    bdla.b(ailw.a(this.a), "P_CliOper", "Grp_msg", "", "AIOchat", "Clk_setmsg", 0, 0, ailw.a(this.a).curFriendUin, "", "", "");
    QQAppInterface localQQAppInterface = ailw.a(this.a);
    String str2 = ailw.a(this.a).curFriendUin;
    if (ailw.a(this.a).getTroopMask(ailw.a(this.a).curFriendUin) == 3) {}
    for (String str1 = "1";; str1 = "0")
    {
      bdla.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_confirm", 0, 0, str2, str1, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aily
 * JD-Core Version:    0.7.0.1
 */