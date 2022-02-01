import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class adtx
  implements DialogInterface.OnClickListener
{
  adtx(adtv paramadtv, HotChatInfo paramHotChatInfo, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isWifiHotChat) {}
    for (paramInt = 1;; paramInt = 2)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D2C", "0X8004D2C", paramInt, 0, "", "", "", "");
      if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), anvx.a(2131702092), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(adtv.a(this.jdField_a_of_type_Adtv));
    ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL_ACTION_DELETE_SHELL);
    this.jdField_a_of_type_Adtv.a = new bisl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    this.jdField_a_of_type_Adtv.a.setContentView(2131562799);
    this.jdField_a_of_type_Adtv.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692036));
    this.jdField_a_of_type_Adtv.a.setCancelable(true);
    this.jdField_a_of_type_Adtv.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtx
 * JD-Core Version:    0.7.0.1
 */