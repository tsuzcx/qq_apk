import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;

class aejh
  implements DialogInterface.OnClickListener
{
  aejh(aejb paramaejb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (ajtg)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if ((badq.d(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) && (paramDialogInterface != null)) {
      if (((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).isTroopOwner(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        paramDialogInterface.l(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
    for (;;)
    {
      new awrb(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_banned").c("Grp_AIO").d("clk_quitgrp").a(new String[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a }).a();
      return;
      paramDialogInterface.k(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      continue;
      if (paramDialogInterface != null) {
        bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131629008, 0).a();
      } else {
        bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131626626, 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aejh
 * JD-Core Version:    0.7.0.1
 */