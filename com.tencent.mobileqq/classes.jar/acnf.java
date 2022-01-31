import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class acnf
  implements DialogInterface.OnClickListener
{
  public acnf(TroopTransferActivity paramTroopTransferActivity, String paramString, bbgg parambbgg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bbev.d(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Bcpt == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Bcpt = new bcpt(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Bcpt.b(2, 2131692321, 1000);
      return;
    }
    paramDialogInterface = (akhq)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.a(20);
    if (paramDialogInterface != null) {}
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_JavaLangString);
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getCurrentAccountUin());
      long l3 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Boolean = true;
      paramDialogInterface.a(l1, l2, l3);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Bcpt == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Bcpt = new bcpt(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Bcpt.b(0, 2131720384, 1000);
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.transfer", 2, paramDialogInterface.toString());
        }
      }
    }
    this.jdField_a_of_type_Bbgg.cancel();
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, "CliOper", "", "", "Grp", "Transgrp_OK", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acnf
 * JD-Core Version:    0.7.0.1
 */