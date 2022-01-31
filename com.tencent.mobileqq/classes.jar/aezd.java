import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class aezd
  implements View.OnClickListener
{
  aezd(aezc paramaezc) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    String str;
    if (this.a.a())
    {
      asfb.a().a(aezc.a(this.a), aezc.a(this.a).a);
      aezc.a(this.a).a();
      localQQAppInterface = aezc.a(this.a);
      str = aezc.a(this.a).a;
      if (aezc.a(this.a).b(aezc.a(this.a).a) != 3) {
        break label112;
      }
    }
    label112:
    for (paramView = "1";; paramView = "0")
    {
      axqw.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_close", 0, 0, str, paramView, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezd
 * JD-Core Version:    0.7.0.1
 */