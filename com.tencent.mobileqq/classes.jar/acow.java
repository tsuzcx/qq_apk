import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;

public class acow
  implements DialogInterface.OnClickListener
{
  public acow(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeActivity.a(this.a, false);
    axqw.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, akuz.b(), String.valueOf(0), akva.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acow
 * JD-Core Version:    0.7.0.1
 */