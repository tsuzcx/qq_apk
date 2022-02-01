import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;

public class afoz
  implements DialogInterface.OnClickListener
{
  public afoz(SplashActivity paramSplashActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     afoz
 * JD-Core Version:    0.7.0.1
 */