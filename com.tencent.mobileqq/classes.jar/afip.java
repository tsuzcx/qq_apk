import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class afip
  implements DialogInterface.OnClickListener
{
  public afip(TroopTransferActivity paramTroopTransferActivity, String paramString, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Biso == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Biso = new biso(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Biso.b(2, 2131692125, 1000);
      return;
    }
    paramDialogInterface = (aoep)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (paramDialogInterface != null) {}
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_JavaLangString);
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getCurrentAccountUin());
      long l3 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Boolean = true;
      paramDialogInterface.a(l1, l2, l3);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Biso == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Biso = new biso(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_Biso.b(0, 2131719457, 1000);
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
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, "CliOper", "", "", "Grp", "Transgrp_OK", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afip
 * JD-Core Version:    0.7.0.1
 */