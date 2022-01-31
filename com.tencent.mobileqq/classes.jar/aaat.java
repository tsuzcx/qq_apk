import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.mobileqq.data.SubAccountInfo;

public class aaat
  implements View.OnClickListener
{
  public aaat(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (View)paramView.getParent();
    if ((paramView == null) || (paramView.getTag() == null)) {}
    do
    {
      return;
      awqx.b(this.a.app, "CliOper", "", "", "0X8007146", "0X8007146", 0, 0, "", "", "", "");
    } while (!(paramView.getTag() instanceof SubAccountInfo));
    this.a.a((SubAccountInfo)paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaat
 * JD-Core Version:    0.7.0.1
 */