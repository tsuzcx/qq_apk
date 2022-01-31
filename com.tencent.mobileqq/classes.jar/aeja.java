import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aeja
  implements DialogInterface.OnClickListener
{
  public aeja(TroopTransferActivity paramTroopTransferActivity, String paramString, bdjz parambdjz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bdin.d(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Beub == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Beub = new beub(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Beub.b(2, 2131692398, 1000);
      return;
    }
    paramDialogInterface = (amdu)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.a(20);
    if (paramDialogInterface != null) {}
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_JavaLangString);
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getCurrentAccountUin());
      long l3 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Boolean = true;
      paramDialogInterface.a(l1, l2, l3);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Beub == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Beub = new beub(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Beub.b(0, 2131720943, 1000);
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
    this.jdField_a_of_type_Bdjz.cancel();
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, "CliOper", "", "", "Grp", "Transgrp_OK", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeja
 * JD-Core Version:    0.7.0.1
 */