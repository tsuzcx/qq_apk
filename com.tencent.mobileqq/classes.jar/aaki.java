import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.qphone.base.remote.SimpleAccount;

public class aaki
  implements View.OnClickListener
{
  public aaki(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getParent() == null) {}
    do
    {
      do
      {
        return;
        paramView = (View)paramView.getParent().getParent();
      } while ((paramView == null) || (paramView.getTag() == null));
      axqy.b(this.a.app, "CliOper", "", "", "0X8007147", "0X8007147", 0, 0, "", "", "", "");
    } while (!(paramView.getTag() instanceof SimpleAccount));
    this.a.a((SimpleAccount)paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaki
 * JD-Core Version:    0.7.0.1
 */