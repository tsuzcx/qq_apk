import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahqz
  implements View.OnClickListener
{
  ahqz(ahqx paramahqx) {}
  
  public void onClick(View paramView)
  {
    ahqx.a(this.a).setTroopMsgFilterToServer(ahqx.a(this.a).curFriendUin, Integer.valueOf(4));
    ahqx.a(this.a).a();
    avnu.a().c(ahqx.a(this.a).curFriendUin, ahqx.a(this.a));
    avnu.a().c(ahqx.a(this.a), ahqx.a(this.a).curFriendUin);
    bcef.b(ahqx.a(this.a), "P_CliOper", "Grp_msg", "", "AIOchat", "Clk_setmsg", 0, 0, ahqx.a(this.a).curFriendUin, "", "", "");
    QQAppInterface localQQAppInterface = ahqx.a(this.a);
    String str2 = ahqx.a(this.a).curFriendUin;
    if (ahqx.a(this.a).getTroopMask(ahqx.a(this.a).curFriendUin) == 3) {}
    for (String str1 = "1";; str1 = "0")
    {
      bcef.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_confirm", 0, 0, str2, str1, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqz
 * JD-Core Version:    0.7.0.1
 */