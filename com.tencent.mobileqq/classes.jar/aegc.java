import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;

public class aegc
  implements DialogInterface.OnClickListener
{
  public aegc(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeActivity.a(this.a, false);
    azmj.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, amlo.b(), String.valueOf(0), amlp.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegc
 * JD-Core Version:    0.7.0.1
 */