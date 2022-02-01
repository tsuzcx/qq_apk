import QQService.SvcDevLoginInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aehd
  implements View.OnClickListener
{
  public aehd(LoginInfoActivity paramLoginInfoActivity, Button paramButton, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity, this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getString(2131692125), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getTitleBarHeight());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app, "CliOper", "", "", "My_eq", "Kick_off_PC", 0, 0, "", "", "", "");
      SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)this.jdField_a_of_type_AndroidWidgetButton.getTag();
      if (localSvcDevLoginInfo != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app.getSubAccountKey(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app.getAccount(), new aehe(this, localSvcDevLoginInfo));
      } else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getString(2131694206), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehd
 * JD-Core Version:    0.7.0.1
 */