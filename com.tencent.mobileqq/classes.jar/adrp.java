import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class adrp
  implements View.OnClickListener
{
  public adrp(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null)
    {
      this.a.a = ((bhuf)bhus.a(this.a, null));
      this.a.a.b(2131698445);
      this.a.a.b(2131692401);
      this.a.a.c(2131690648);
      this.a.a.a(new adrq(this));
    }
    if (!this.a.a.isShowing()) {
      this.a.a.show();
    }
    azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrp
 * JD-Core Version:    0.7.0.1
 */