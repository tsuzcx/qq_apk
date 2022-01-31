import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;

public class acor
  implements DialogInterface.OnClickListener
{
  public acor(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axqy.b(this.a.app, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, akuy.b(), String.valueOf(0), akuz.a(), "0");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acor
 * JD-Core Version:    0.7.0.1
 */