import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aimp
  implements View.OnClickListener
{
  aimp(aimo paramaimo) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    String str2;
    if (this.a.a())
    {
      awhv.a().a(aimo.a(this.a), aimo.a(this.a).a);
      aimo.a(this.a).a();
      localQQAppInterface = aimo.a(this.a);
      str2 = aimo.a(this.a).a;
      if (aimo.a(this.a).b(aimo.a(this.a).a) != 3) {
        break label121;
      }
    }
    label121:
    for (String str1 = "1";; str1 = "0")
    {
      bcst.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_close", 0, 0, str2, str1, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimp
 * JD-Core Version:    0.7.0.1
 */