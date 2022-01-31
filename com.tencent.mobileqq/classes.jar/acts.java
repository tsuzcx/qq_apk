import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.qphone.base.util.QLog;

public class acts
  implements DialogInterface.OnClickListener
{
  public acts(DialogActivity paramDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("qqBaseActivity", 1, "checkBackgroundRestricWhilteList conform to setting.");
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent("android.settings.IGNORE_BACKGROUND_DATA_RESTRICTIONS_SETTINGS", Uri.parse("package:" + this.a.getPackageName()));
    this.a.startActivity(paramDialogInterface);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acts
 * JD-Core Version:    0.7.0.1
 */