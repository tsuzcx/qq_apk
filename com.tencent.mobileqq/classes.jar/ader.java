import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ader
  implements View.OnClickListener
{
  public ader(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    PublicFragmentActivity.a(this.a, localIntent, AccountOnlineStateActivity.class, 0);
    azbq.a(this.a.app);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ader
 * JD-Core Version:    0.7.0.1
 */