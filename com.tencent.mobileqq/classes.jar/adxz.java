import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class adxz
  implements DialogInterface.OnClickListener
{
  public adxz(TroopDisbandActivity paramTroopDisbandActivity, bdfq parambdfq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Beps == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Beps = new beps(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity);
    }
    if (bdee.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity))
    {
      paramDialogInterface = (alzf)this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app.a(20);
      if (paramDialogInterface != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.b & 0x1) == 0)
        {
          TroopDisbandActivity localTroopDisbandActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity;
          localTroopDisbandActivity.b |= 0x1;
          paramDialogInterface.l(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Beps.b(0, 2131692292, 1000);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing())) {
        this.jdField_a_of_type_Bdfq.cancel();
      }
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Beps.b(2, 2131692288, 1500);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Beps.b(2, 2131694829, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxz
 * JD-Core Version:    0.7.0.1
 */