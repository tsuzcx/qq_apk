import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ailx
  implements View.OnClickListener
{
  ailx(ailw paramailw) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    String str2;
    if (this.a.a())
    {
      awtz.a().a(ailw.a(this.a), ailw.a(this.a).curFriendUin);
      ailw.a(this.a).a();
      localQQAppInterface = ailw.a(this.a);
      str2 = ailw.a(this.a).curFriendUin;
      if (ailw.a(this.a).getTroopMask(ailw.a(this.a).curFriendUin) != 3) {
        break label121;
      }
    }
    label121:
    for (String str1 = "1";; str1 = "0")
    {
      bdla.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_close", 0, 0, str2, str1, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailx
 * JD-Core Version:    0.7.0.1
 */