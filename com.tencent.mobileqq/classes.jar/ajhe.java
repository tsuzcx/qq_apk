import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class ajhe
  implements View.OnClickListener
{
  ajhe(ajgb paramajgb) {}
  
  public void onClick(View paramView)
  {
    ajgb.a(this.a).app.getPreferences();
    amqe.a().a();
    if (amqe.a().a() == 4)
    {
      amqe.a().a(ajgb.a(this.a));
      azqs.b(ajgb.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, amqd.b(), amqe.b(), amqe.a(), "1");
    }
    for (;;)
    {
      this.a.a(-1, null);
      return;
      UpgradeDetailActivity.a(ajgb.a(this.a), amqe.a().a(), true, true, true);
      azqs.b(ajgb.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, amqd.b(), amqe.b(), amqe.a(), "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhe
 * JD-Core Version:    0.7.0.1
 */