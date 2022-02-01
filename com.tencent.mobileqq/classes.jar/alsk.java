import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;

public class alsk
  implements DialogInterface.OnClickListener
{
  public alsk(LoginView paramLoginView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.a(this.a.a, "dc00898", "", "", "0X8006797", "0X8006797", 0, 0, "", "", "", "");
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alsk
 * JD-Core Version:    0.7.0.1
 */