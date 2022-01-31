import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;

class ajbz
  implements View.OnClickListener
{
  ajbz(ajbm paramajbm) {}
  
  public void onClick(View paramView)
  {
    this.a.a(-1, null);
    if (amlp.a().a() == 4)
    {
      azmj.b(ajbm.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, amlo.b(), amlp.b(), amlp.a(), "1");
      amlp.a().a(ajbm.a(this.a));
      return;
    }
    azmj.b(ajbm.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, amlo.b(), amlp.b(), amlp.a(), "1");
    UpgradeDetailActivity.a(ajbm.a(this.a), amlp.a().a(), true, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbz
 * JD-Core Version:    0.7.0.1
 */