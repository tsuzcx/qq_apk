import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;

public class ahrk
  implements DialogInterface.OnDismissListener
{
  public ahrk(LoginView paramLoginView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LoginView.f(this.a, false);
    LoginView.g(this.a, false);
    axqy.a(this.a.a, "new_reg_805", "log_page", "can_clk", "", 1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahrk
 * JD-Core Version:    0.7.0.1
 */