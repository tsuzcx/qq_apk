import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class afcs
  implements DialogInterface.OnClickListener
{
  public afcs(TroopInfoActivity paramTroopInfoActivity, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.finish();
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcs
 * JD-Core Version:    0.7.0.1
 */