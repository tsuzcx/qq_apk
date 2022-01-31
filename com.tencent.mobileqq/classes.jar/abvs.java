import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class abvs
  implements View.OnClickListener
{
  public abvs(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null)
    {
      this.a.a = ((bfpc)bfpp.a(this.a, null));
      this.a.a.b(2131698143);
      this.a.a.b(2131692324);
      this.a.a.c(2131690596);
      this.a.a.a(new abvt(this));
    }
    if (!this.a.a.isShowing()) {
      this.a.a.show();
    }
    axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abvs
 * JD-Core Version:    0.7.0.1
 */