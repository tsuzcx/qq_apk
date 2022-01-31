import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;

public class acou
  implements DialogInterface.OnClickListener
{
  public acou(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axqy.b(this.a.app, "CliOper", "", "", "0X800417E", "0X800417E", 0, 0, "", "", "", "");
    if (UpgradeActivity.a(this.a)) {
      axqy.b(this.a.app, "CliOper", "", "", "0X800714C", "0X800714C", 0, 0, "", "", "", "");
    }
    UpgradeActivity.a(this.a, false);
    axqy.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, akuy.b(), String.valueOf(2), akuz.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acou
 * JD-Core Version:    0.7.0.1
 */