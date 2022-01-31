import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.LbsBaseActivity;

public class abkg
  implements View.OnClickListener
{
  public abkg(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    atbg.a(this.a.getAppInterface().getAccount(), true);
    if ((LbsBaseActivity.a(this.a) != null) && (LbsBaseActivity.a(this.a).isShowing())) {
      this.a.a(LbsBaseActivity.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abkg
 * JD-Core Version:    0.7.0.1
 */