import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterChooseLoginActivity;

public class adui
  implements DialogInterface.OnClickListener
{
  public adui(RegisterChooseLoginActivity paramRegisterChooseLoginActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    RegisterChooseLoginActivity.a(this.a, true);
    RegisterChooseLoginActivity.a(this.a, true);
    azqs.a(this.a.app, "dc00898", "", "", "0X8007CC9", "0X8007CC9", 0, 0, "", "", "", "");
    azqs.a(this.a.app, "dc00898", "", "", "0X8007CC9", "0X8007CC9", 1, 0, "", "", "", "");
    azqs.a(this.a.app, "new_reg", "next_ask", "new_clk", "", 1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adui
 * JD-Core Version:    0.7.0.1
 */