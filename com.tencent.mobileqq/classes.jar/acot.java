import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;

public class acot
  implements DialogInterface.OnClickListener
{
  public acot(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axqy.b(this.a.app, "CliOper", "", "", "0X800417F", "0X800417F", 0, 0, "", "", "", "");
    if (UpgradeActivity.a(this.a)) {
      axqy.b(this.a.app, "CliOper", "", "", "0X800714D", "0X800714D", 0, 0, "", "", "", "");
    }
    axqy.b(this.a.app, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, akuy.b(), String.valueOf(2), akuz.a(), "0");
    akuz.a().a(this.a.app);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acot
 * JD-Core Version:    0.7.0.1
 */