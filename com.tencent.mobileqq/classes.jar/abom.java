import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterChooseLoginActivity;

public class abom
  implements DialogInterface.OnClickListener
{
  public abom(RegisterChooseLoginActivity paramRegisterChooseLoginActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    RegisterChooseLoginActivity.a(this.a, false);
    RegisterChooseLoginActivity.a(this.a, false);
    awqx.a(this.a.app, "dc00898", "", "", "0X8007CC9", "0X8007CC9", 0, 0, "", "", "", "");
    awqx.a(this.a.app, "dc00898", "", "", "0X8007CC9", "0X8007CC9", 2, 0, "", "", "", "");
    awqx.a(this.a.app, "new_reg", "next_ask", "no_clk", "", 1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abom
 * JD-Core Version:    0.7.0.1
 */