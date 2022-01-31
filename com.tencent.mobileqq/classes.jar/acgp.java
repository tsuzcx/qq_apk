import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class acgp
  implements DialogInterface.OnClickListener
{
  public acgp(TroopDisbandActivity paramTroopDisbandActivity, bbgu parambbgu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bcqi == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bcqi = new bcqi(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity);
    }
    if (bbfj.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity))
    {
      paramDialogInterface = (akhp)this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app.a(20);
      if (paramDialogInterface != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.b & 0x1) == 0)
        {
          TroopDisbandActivity localTroopDisbandActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity;
          localTroopDisbandActivity.b |= 0x1;
          paramDialogInterface.l(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bcqi.b(0, 2131692216, 1000);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing())) {
        this.jdField_a_of_type_Bbgu.cancel();
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bcqi.b(2, 2131692212, 1500);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_a_of_type_Bcqi.b(2, 2131694673, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acgp
 * JD-Core Version:    0.7.0.1
 */