import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;

public class aege
  implements DialogInterface.OnClickListener
{
  public aege(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    azmj.b(this.a.app, "CliOper", "", "", "0X800417E", "0X800417E", 0, 0, "", "", "", "");
    if (UpgradeActivity.a(this.a)) {
      azmj.b(this.a.app, "CliOper", "", "", "0X800714C", "0X800714C", 0, 0, "", "", "", "");
    }
    UpgradeActivity.a(this.a, false);
    azmj.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, amlo.b(), String.valueOf(2), amlp.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aege
 * JD-Core Version:    0.7.0.1
 */