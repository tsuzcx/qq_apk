import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterChooseLoginActivity;

public class adpt
  implements DialogInterface.OnClickListener
{
  public adpt(RegisterChooseLoginActivity paramRegisterChooseLoginActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    RegisterChooseLoginActivity.a(this.a, true);
    RegisterChooseLoginActivity.a(this.a, true);
    azmj.a(this.a.app, "dc00898", "", "", "0X8007CC9", "0X8007CC9", 0, 0, "", "", "", "");
    azmj.a(this.a.app, "dc00898", "", "", "0X8007CC9", "0X8007CC9", 1, 0, "", "", "", "");
    azmj.a(this.a.app, "new_reg", "next_ask", "new_clk", "", 1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpt
 * JD-Core Version:    0.7.0.1
 */