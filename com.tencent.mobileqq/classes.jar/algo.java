import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.statistics.ReportController;

public final class algo
  implements DialogInterface.OnClickListener
{
  public algo(String paramString1, int paramInt1, int paramInt2, QQMessageFacade paramQQMessageFacade, String paramString2, int paramInt3, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "P_CliOper", "Safe_SensMsg", this.jdField_a_of_type_JavaLangString, "Alert_Dialog", "Other", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
    ThreadManager.executeOnSubThread(new algp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     algo
 * JD-Core Version:    0.7.0.1
 */