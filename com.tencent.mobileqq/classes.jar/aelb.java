import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class aelb
  implements CompoundButton.OnCheckedChangeListener
{
  public aelb(NotifyPushSettingActivity paramNotifyPushSettingActivity, anri paramanri) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.getApplicationContext())) && (NotifyPushSettingActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity)))
    {
      this.jdField_a_of_type_Anri.e(paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    NotifyPushSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, false);
    FormSwitchItem localFormSwitchItem = NotifyPushSettingActivity.i(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity);
    if (!NotifyPushSettingActivity.i(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity).a()) {}
    for (boolean bool = true;; bool = false)
    {
      localFormSwitchItem.setChecked(bool);
      NotifyPushSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, true);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.app.getApplication().getString(2131694512), 0).b(5);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aelb
 * JD-Core Version:    0.7.0.1
 */