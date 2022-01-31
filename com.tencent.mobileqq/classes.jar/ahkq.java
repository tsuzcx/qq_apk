import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;

class ahkq
  implements View.OnClickListener
{
  ahkq(ahkd paramahkd) {}
  
  public void onClick(View paramView)
  {
    this.a.a(-1, null);
    if (akuz.a().a() == 4)
    {
      axqy.b(ahkd.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, akuy.b(), akuz.b(), akuz.a(), "1");
      akuz.a().a(ahkd.a(this.a));
      return;
    }
    axqy.b(ahkd.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, akuy.b(), akuz.b(), akuz.a(), "1");
    UpgradeDetailActivity.a(ahkd.a(this.a), akuz.a().a(), true, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahkq
 * JD-Core Version:    0.7.0.1
 */