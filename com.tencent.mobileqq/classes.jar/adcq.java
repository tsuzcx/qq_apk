import QQService.SvcDevLoginInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class adcq
  implements View.OnClickListener
{
  public adcq(LoginInfoActivity paramLoginInfoActivity, Button paramButton, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!bdee.d(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity, this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getString(2131692397), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getTitleBarHeight());
      return;
    }
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app, "CliOper", "", "", "My_eq", "Kick_off_PC", 0, 0, "", "", "", "");
    paramView = (SvcDevLoginInfo)this.jdField_a_of_type_AndroidWidgetButton.getTag();
    if (paramView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app.getSubAccountKey(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app.getAccount(), new adcr(this, paramView));
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getString(2131694646), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcq
 * JD-Core Version:    0.7.0.1
 */