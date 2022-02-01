import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiwn
  implements View.OnClickListener
{
  aiwn(aiwm paramaiwm) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    String str2;
    if (this.a.a())
    {
      axan.a().a(aiwm.a(this.a), aiwm.a(this.a).a);
      aiwm.a(this.a).a();
      localQQAppInterface = aiwm.a(this.a);
      str2 = aiwm.a(this.a).a;
      if (aiwm.a(this.a).b(aiwm.a(this.a).a) != 3) {
        break label121;
      }
    }
    label121:
    for (String str1 = "1";; str1 = "0")
    {
      bdll.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_close", 0, 0, str2, str1, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwn
 * JD-Core Version:    0.7.0.1
 */