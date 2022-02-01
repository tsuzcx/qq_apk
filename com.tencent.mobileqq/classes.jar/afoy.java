import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.activity.SplashActivity;

public class afoy
  implements DialogInterface.OnClickListener
{
  public afoy(SplashActivity paramSplashActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent(this.a, GesturePWDSettingActivity.class);
    localIntent.putExtra("key_reset", true);
    this.a.startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     afoy
 * JD-Core Version:    0.7.0.1
 */