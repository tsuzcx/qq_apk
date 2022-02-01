import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiwo
  implements View.OnClickListener
{
  aiwo(aiwm paramaiwm) {}
  
  public void onClick(View paramView)
  {
    aiwm.a(this.a).a(aiwm.a(this.a).a, Integer.valueOf(4));
    aiwm.a(this.a).a();
    axan.a().c(aiwm.a(this.a).a, aiwm.a(this.a));
    axan.a().c(aiwm.a(this.a), aiwm.a(this.a).a);
    bdll.b(aiwm.a(this.a), "P_CliOper", "Grp_msg", "", "AIOchat", "Clk_setmsg", 0, 0, aiwm.a(this.a).a, "", "", "");
    QQAppInterface localQQAppInterface = aiwm.a(this.a);
    String str2 = aiwm.a(this.a).a;
    if (aiwm.a(this.a).b(aiwm.a(this.a).a) == 3) {}
    for (String str1 = "1";; str1 = "0")
    {
      bdll.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_confirm", 0, 0, str2, str1, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwo
 * JD-Core Version:    0.7.0.1
 */