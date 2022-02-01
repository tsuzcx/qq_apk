import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adzx
  implements View.OnClickListener
{
  public adzx(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null)
    {
      this.a.a = ((bjnw)bjon.a(this.a, null));
      this.a.a.b(2131697561);
      this.a.a.b(2131692036);
      this.a.a.c(2131690620);
      this.a.a.a(new adzy(this));
    }
    if (!this.a.a.isShowing()) {
      this.a.a.show();
    }
    bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzx
 * JD-Core Version:    0.7.0.1
 */