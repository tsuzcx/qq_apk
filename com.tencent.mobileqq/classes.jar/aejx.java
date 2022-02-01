import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.widget.QQToast;

class aejx
  implements DialogInterface.OnClickListener
{
  aejx(aejv paramaejv, HotChatInfo paramHotChatInfo, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isWifiHotChat) {}
    for (paramInt = 1;; paramInt = 2)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D2C", "0X8004D2C", paramInt, 0, "", "", "", "");
      if (bhnv.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), anzj.a(2131701506), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(aejv.a(this.jdField_a_of_type_Aejv));
    ((anzp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL__ACTION_DELETE_SHELL);
    this.jdField_a_of_type_Aejv.a = new bjbs(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    this.jdField_a_of_type_Aejv.a.setContentView(2131562849);
    this.jdField_a_of_type_Aejv.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691900));
    this.jdField_a_of_type_Aejv.a.setCancelable(true);
    this.jdField_a_of_type_Aejv.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejx
 * JD-Core Version:    0.7.0.1
 */