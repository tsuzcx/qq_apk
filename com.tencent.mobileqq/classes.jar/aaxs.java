import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;

class aaxs
  implements DialogInterface.OnClickListener
{
  aaxs(aaxq paramaaxq, HotChatInfo paramHotChatInfo, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isWifiHotChat) {}
    for (paramInt = 1;; paramInt = 2)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D2C", "0X8004D2C", paramInt, 0, "", "", "", "");
      if (bbfj.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
        break;
      }
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), ajya.a(2131702608), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(aaxq.a(this.jdField_a_of_type_Aaxq));
    ((ajyg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL__ACTION_DELETE_SHELL);
    this.jdField_a_of_type_Aaxq.a = new bcqf(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    this.jdField_a_of_type_Aaxq.a.setContentView(2131562355);
    this.jdField_a_of_type_Aaxq.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692213));
    this.jdField_a_of_type_Aaxq.a.setCancelable(true);
    this.jdField_a_of_type_Aaxq.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaxs
 * JD-Core Version:    0.7.0.1
 */