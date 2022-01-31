import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.LbsBaseActivity;

public class abkc
  implements View.OnClickListener
{
  public abkc(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    atbi.a(this.a.getAppInterface().getAccount(), true);
    if ((LbsBaseActivity.a(this.a) != null) && (LbsBaseActivity.a(this.a).isShowing())) {
      this.a.a(LbsBaseActivity.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abkc
 * JD-Core Version:    0.7.0.1
 */