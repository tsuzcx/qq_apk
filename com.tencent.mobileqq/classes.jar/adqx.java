import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adqx
  implements View.OnClickListener
{
  public adqx(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    View localView = (View)paramView.getParent().getParent();
    if ((localView == null) || (localView.getTag() == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ((Integer)localView.getTag()).intValue();
      if ((i != 0) || (azoz.a().a(this.a.app, this.a)))
      {
        this.a.a(i);
        bdll.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_edit_delete", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqx
 * JD-Core Version:    0.7.0.1
 */