import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahqy
  implements View.OnClickListener
{
  ahqy(ahqx paramahqx) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    String str2;
    if (this.a.a())
    {
      avnu.a().a(ahqx.a(this.a), ahqx.a(this.a).curFriendUin);
      ahqx.a(this.a).a();
      localQQAppInterface = ahqx.a(this.a);
      str2 = ahqx.a(this.a).curFriendUin;
      if (ahqx.a(this.a).getTroopMask(ahqx.a(this.a).curFriendUin) != 3) {
        break label121;
      }
    }
    label121:
    for (String str1 = "1";; str1 = "0")
    {
      bcef.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_close", 0, 0, str2, str1, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqy
 * JD-Core Version:    0.7.0.1
 */