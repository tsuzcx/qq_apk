import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;

public class aekr
  implements DialogInterface.OnClickListener
{
  public aekr(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeActivity.a(this.a, false);
    azqs.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, amqd.b(), String.valueOf(0), amqe.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekr
 * JD-Core Version:    0.7.0.1
 */