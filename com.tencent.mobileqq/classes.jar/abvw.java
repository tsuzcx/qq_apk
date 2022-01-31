import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class abvw
  implements View.OnClickListener
{
  public abvw(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null)
    {
      this.a.a = ((bfol)bfoy.a(this.a, null));
      this.a.a.b(2131698133);
      this.a.a.b(2131692324);
      this.a.a.c(2131690596);
      this.a.a.a(new abvx(this));
    }
    if (!this.a.a.isShowing()) {
      this.a.a.show();
    }
    axqw.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abvw
 * JD-Core Version:    0.7.0.1
 */