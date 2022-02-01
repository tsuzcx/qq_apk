import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adem
  implements View.OnClickListener
{
  public adem(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.i();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adem
 * JD-Core Version:    0.7.0.1
 */