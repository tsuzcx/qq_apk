import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.statistics.ArkAppReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aaqp
  implements DialogInterface.OnClickListener
{
  public aaqp(ArkRecommendController paramArkRecommendController, QQCustomDialog paramQQCustomDialog, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      ArkRecommendController.a(ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ArkAppReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "__global__", "ArkAlertDialogNotConfirm", 0L, 0L, 0L, 0L, 0L, "", "");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      ArkRecommendController.a(this.jdField_a_of_type_AndroidContentContext, "close", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ArkAppCenter.b("ArkDialog", String.format("NegativeButton click failed, err=%s", new Object[] { paramDialogInterface.getMessage() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqp
 * JD-Core Version:    0.7.0.1
 */