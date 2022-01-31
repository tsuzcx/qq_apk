import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.statistics.ReportController;

public class aeje
  implements DialogInterface.OnClickListener
{
  public aeje(AIOShareActionSheet paramAIOShareActionSheet) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.g()) {
      AIOShareActionSheet.a(this.a).a(false, null, false);
    }
    ReportController.b(this.a.a, "CliOper", "", "", AIOShareActionSheet.b, AIOShareActionSheet.b, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeje
 * JD-Core Version:    0.7.0.1
 */