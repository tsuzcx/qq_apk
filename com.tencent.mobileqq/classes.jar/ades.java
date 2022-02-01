import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ades
  implements View.OnClickListener
{
  public ades(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!azit.a().a(this.a.app, this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.a.b == null) || (!this.a.b.isShowing())) {
        AccountManageActivity.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ades
 * JD-Core Version:    0.7.0.1
 */