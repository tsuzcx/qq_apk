import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;

class ajgo
  implements View.OnClickListener
{
  ajgo(ajgb paramajgb) {}
  
  public void onClick(View paramView)
  {
    this.a.a(-1, null);
    if (amqe.a().a() == 4)
    {
      azqs.b(ajgb.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, amqd.b(), amqe.b(), amqe.a(), "1");
      amqe.a().a(ajgb.a(this.a));
      return;
    }
    azqs.b(ajgb.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, amqd.b(), amqe.b(), amqe.a(), "1");
    UpgradeDetailActivity.a(ajgb.a(this.a), amqe.a().a(), true, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgo
 * JD-Core Version:    0.7.0.1
 */