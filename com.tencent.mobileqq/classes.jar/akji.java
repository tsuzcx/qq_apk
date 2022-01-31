import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

public final class akji
  implements DialogInterface.OnClickListener
{
  public akji(String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "P_CliOper", "Safe_SensMsg", this.jdField_a_of_type_JavaLangString, "Alert_Dialog", "Cancel", this.jdField_a_of_type_Int, this.b, "", "", "", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akji
 * JD-Core Version:    0.7.0.1
 */