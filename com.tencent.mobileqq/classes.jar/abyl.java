import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterChooseLoginActivity;

public class abyl
  implements DialogInterface.OnClickListener
{
  public abyl(RegisterChooseLoginActivity paramRegisterChooseLoginActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    RegisterChooseLoginActivity.a(this.a, true);
    RegisterChooseLoginActivity.a(this.a, true);
    axqy.a(this.a.app, "dc00898", "", "", "0X8007CC9", "0X8007CC9", 0, 0, "", "", "", "");
    axqy.a(this.a.app, "dc00898", "", "", "0X8007CC9", "0X8007CC9", 1, 0, "", "", "", "");
    axqy.a(this.a.app, "new_reg", "next_ask", "new_clk", "", 1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abyl
 * JD-Core Version:    0.7.0.1
 */