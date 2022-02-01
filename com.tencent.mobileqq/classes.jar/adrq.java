import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adrq
  implements View.OnClickListener
{
  public adrq(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.h();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrq
 * JD-Core Version:    0.7.0.1
 */