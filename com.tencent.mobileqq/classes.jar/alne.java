import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;

public class alne
  implements DialogInterface.OnDismissListener
{
  public alne(LoginView paramLoginView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LoginView.g(this.a, false);
    LoginView.h(this.a, false);
    bdla.a(this.a.a, "new_reg_805", "log_page", "can_clk", "", 1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alne
 * JD-Core Version:    0.7.0.1
 */