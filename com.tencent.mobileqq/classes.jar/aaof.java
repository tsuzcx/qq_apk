import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;

class aaof
  implements DialogInterface.OnClickListener
{
  aaof(aaod paramaaod, HotChatInfo paramHotChatInfo, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isWifiHotChat) {}
    for (paramInt = 1;; paramInt = 2)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D2C", "0X8004D2C", paramInt, 0, "", "", "", "");
      if (badq.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
        break;
      }
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), ajjy.a(2131636813), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(aaod.a(this.jdField_a_of_type_Aaod));
    ((ajkc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL__ACTION_DELETE_SHELL);
    this.jdField_a_of_type_Aaod.a = new bbms(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    this.jdField_a_of_type_Aaod.a.setContentView(2131496755);
    this.jdField_a_of_type_Aaod.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131626627));
    this.jdField_a_of_type_Aaod.a.setCancelable(true);
    this.jdField_a_of_type_Aaod.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaof
 * JD-Core Version:    0.7.0.1
 */