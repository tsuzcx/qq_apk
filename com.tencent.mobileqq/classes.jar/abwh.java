import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class abwh
  implements DialogInterface.OnClickListener
{
  public abwh(TroopDisbandActivity paramTroopDisbandActivity, bafb parambafb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bbmv == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bbmv = new bbmv(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity);
    }
    if (badq.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity))
    {
      paramDialogInterface = (ajtg)this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app.a(20);
      if (paramDialogInterface != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.b & 0x1) == 0)
        {
          TroopDisbandActivity localTroopDisbandActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity;
          localTroopDisbandActivity.b |= 0x1;
          paramDialogInterface.l(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bbmv.b(0, 2131626630, 1000);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
        this.jdField_a_of_type_Bafb.cancel();
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bbmv.b(2, 2131626626, 1500);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bbmv.b(2, 2131629008, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abwh
 * JD-Core Version:    0.7.0.1
 */