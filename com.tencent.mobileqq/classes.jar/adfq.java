import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;

public class adfq
  implements View.OnClickListener
{
  public adfq(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    if ((LbsBaseActivity.a(this.a) != null) && (LbsBaseActivity.a(this.a).isShowing())) {
      this.a.a(LbsBaseActivity.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfq
 * JD-Core Version:    0.7.0.1
 */