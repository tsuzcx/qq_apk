import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aimq
  implements View.OnClickListener
{
  aimq(aimo paramaimo) {}
  
  public void onClick(View paramView)
  {
    aimo.a(this.a).a(aimo.a(this.a).a, Integer.valueOf(4));
    aimo.a(this.a).a();
    awhv.a().c(aimo.a(this.a).a, aimo.a(this.a));
    awhv.a().c(aimo.a(this.a), aimo.a(this.a).a);
    bcst.b(aimo.a(this.a), "P_CliOper", "Grp_msg", "", "AIOchat", "Clk_setmsg", 0, 0, aimo.a(this.a).a, "", "", "");
    QQAppInterface localQQAppInterface = aimo.a(this.a);
    String str2 = aimo.a(this.a).a;
    if (aimo.a(this.a).b(aimo.a(this.a).a) == 3) {}
    for (String str1 = "1";; str1 = "0")
    {
      bcst.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_confirm", 0, 0, str2, str1, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimq
 * JD-Core Version:    0.7.0.1
 */