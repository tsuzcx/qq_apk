import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acoc
  implements View.OnClickListener
{
  public acoc(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.i();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acoc
 * JD-Core Version:    0.7.0.1
 */