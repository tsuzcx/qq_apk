import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;

public class agiq
  implements DialogInterface.OnClickListener
{
  public agiq(BindNumberActivity paramBindNumberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BindNumberActivity.a(this.a);
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.getIntent();
    if (paramDialogInterface.getBooleanExtra("kFPhoneChange", false)) {
      this.a.a("CliOper", "0X8005DE9", 1);
    }
    if (paramDialogInterface.getBooleanExtra("kUnityOther", false)) {
      this.a.a("CliOper", "0X8005DE9", 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agiq
 * JD-Core Version:    0.7.0.1
 */