import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class ahek
  implements DialogInterface.OnClickListener
{
  ahek(QQAppInterface paramQQAppInterface, int paramInt1, Activity paramActivity, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (true == aheh.a) {
      aheh.a = false;
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      QLog.d("vaspoke", 4, "dialogInterfaceOnClick mApp is null.");
    }
    while (((2 != this.jdField_a_of_type_Int) && (4 != this.jdField_a_of_type_Int)) || (paramInt != 1)) {
      return;
    }
    if (2 == this.jdField_a_of_type_Int)
    {
      bgzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, "mvip.g.a.poke_" + this.b, 3, "1450000515", "LTMCLUB", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694492), "");
      VasWebviewUtil.reportCommercialDrainage("", "poke", "vipTipClick", "", 0, 0, 0, "", String.valueOf(this.b), "vip", "", "", "", "", 0, 0, 0, 0);
      return;
    }
    bgzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, "mvip.g.a.poke_" + this.b, 3, "1450000516", "CJCLUBT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718361), "");
    VasWebviewUtil.reportCommercialDrainage("", "poke", "vipTipClick", "", 0, 0, 0, "", String.valueOf(this.b), "svip", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahek
 * JD-Core Version:    0.7.0.1
 */