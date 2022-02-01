import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class afsd
  implements DialogInterface.OnClickListener
{
  public afsd(TroopDisbandActivity paramTroopDisbandActivity, bhpc parambhpc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bjbv == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bjbv = new bjbv(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity);
    }
    if (bhnv.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity))
    {
      paramDialogInterface = (aoip)this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app.a(20);
      if (paramDialogInterface != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.b & 0x1) == 0)
        {
          TroopDisbandActivity localTroopDisbandActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity;
          localTroopDisbandActivity.b |= 0x1;
          paramDialogInterface.l(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bjbv.b(0, 2131691903, 1000);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {
        this.jdField_a_of_type_Bhpc.cancel();
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bjbv.b(2, 2131691899, 1500);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bjbv.b(2, 2131694008, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsd
 * JD-Core Version:    0.7.0.1
 */