import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;

public class aaft
  implements View.OnClickListener
{
  public aaft(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    PublicFragmentActivity.a(this.a, paramView, AccountOnlineStateActivity.class, 0);
    aujh.a(this.a.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaft
 * JD-Core Version:    0.7.0.1
 */