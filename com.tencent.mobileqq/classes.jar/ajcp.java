import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class ajcp
  implements View.OnClickListener
{
  ajcp(ajbm paramajbm) {}
  
  public void onClick(View paramView)
  {
    ajbm.a(this.a).app.getPreferences();
    amlp.a().a();
    if (amlp.a().a() == 4)
    {
      amlp.a().a(ajbm.a(this.a));
      azmj.b(ajbm.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, amlo.b(), amlp.b(), amlp.a(), "1");
    }
    for (;;)
    {
      this.a.a(-1, null);
      return;
      UpgradeDetailActivity.a(ajbm.a(this.a), amlp.a().a(), true, true, true);
      azmj.b(ajbm.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, amlo.b(), amlp.b(), amlp.a(), "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcp
 * JD-Core Version:    0.7.0.1
 */