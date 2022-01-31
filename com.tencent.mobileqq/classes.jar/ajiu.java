import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;

public class ajiu
  implements DialogInterface.OnDismissListener
{
  public ajiu(LoginView paramLoginView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LoginView.g(this.a, false);
    LoginView.h(this.a, false);
    azmj.a(this.a.a, "new_reg_805", "log_page", "can_clk", "", 1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajiu
 * JD-Core Version:    0.7.0.1
 */