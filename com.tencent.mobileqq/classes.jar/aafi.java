import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.AccountManageActivity;

public class aafi
  implements View.OnClickListener
{
  public aafi(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (View)paramView.getParent().getParent();
    if ((paramView == null) || (paramView.getTag() == null)) {}
    int i;
    do
    {
      return;
      i = ((Integer)paramView.getTag()).intValue();
    } while ((i == 0) && (!aumi.a().a(this.a.app, this.a)));
    this.a.a(i);
    axqw.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_edit_delete", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aafi
 * JD-Core Version:    0.7.0.1
 */