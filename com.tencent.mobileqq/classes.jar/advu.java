import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.statistics.ReportController;

public class advu
  implements DialogInterface.OnClickListener
{
  public advu(AIOShareActionSheet paramAIOShareActionSheet) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ReportController.b(this.a.a, "CliOper", "", "", "0X80067F7", "0X80067F7", 0, 0, "", "", "", "");
    if (this.a.c()) {
      AIOShareActionSheet.a(this.a).a(false, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     advu
 * JD-Core Version:    0.7.0.1
 */