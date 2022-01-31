import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.statistics.ReportController;

public class advy
  implements DialogInterface.OnClickListener
{
  public advy(AIOShareActionSheet paramAIOShareActionSheet) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.g()) {
      AIOShareActionSheet.a(this.a).a(false, null, false);
    }
    ReportController.b(this.a.a, "CliOper", "", "", AIOShareActionSheet.b, AIOShareActionSheet.b, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     advy
 * JD-Core Version:    0.7.0.1
 */