import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adwg
  implements View.OnClickListener
{
  public adwg(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    View localView = (View)paramView.getParent();
    if ((localView == null) || (localView.getTag() == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdll.b(this.a.app, "CliOper", "", "", "0X8007146", "0X8007146", 0, 0, "", "", "", "");
      if ((localView.getTag() instanceof SubAccountInfo)) {
        this.a.a((SubAccountInfo)localView.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwg
 * JD-Core Version:    0.7.0.1
 */