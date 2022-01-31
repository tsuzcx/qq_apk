import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;

public class abvv
  implements View.OnClickListener
{
  public abvv(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.b != null) && (this.a.b.isShowing())) {
      this.a.b.dismiss();
    }
    azmj.b(this.a.app, "CliOper", "", "", "0X800433B", "0X800433B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abvv
 * JD-Core Version:    0.7.0.1
 */