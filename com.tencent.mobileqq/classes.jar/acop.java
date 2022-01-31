import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;

public class acop
  implements DialogInterface.OnClickListener
{
  public acop(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeActivity.a(this.a, true);
    axqy.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, akuy.b(), String.valueOf(0), akuz.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acop
 * JD-Core Version:    0.7.0.1
 */