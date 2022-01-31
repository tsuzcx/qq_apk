import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.statistics.ReportController;

public class aejd
  implements DialogInterface.OnClickListener
{
  public aejd(AIOShareActionSheet paramAIOShareActionSheet) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ReportController.b(this.a.a, "CliOper", "", "", AIOShareActionSheet.b, AIOShareActionSheet.b, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejd
 * JD-Core Version:    0.7.0.1
 */