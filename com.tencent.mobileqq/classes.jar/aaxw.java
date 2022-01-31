import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;

class aaxw
  implements DialogInterface.OnClickListener
{
  aaxw(aaxu paramaaxu, HotChatInfo paramHotChatInfo, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isWifiHotChat) {}
    for (paramInt = 1;; paramInt = 2)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D2C", "0X8004D2C", paramInt, 0, "", "", "", "");
      if (bbev.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
        break;
      }
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), ajyc.a(2131702597), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(aaxu.a(this.jdField_a_of_type_Aaxu));
    ((ajyi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL__ACTION_DELETE_SHELL);
    this.jdField_a_of_type_Aaxu.a = new bcpq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    this.jdField_a_of_type_Aaxu.a.setContentView(2131562356);
    this.jdField_a_of_type_Aaxu.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692213));
    this.jdField_a_of_type_Aaxu.a.setCancelable(true);
    this.jdField_a_of_type_Aaxu.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaxw
 * JD-Core Version:    0.7.0.1
 */