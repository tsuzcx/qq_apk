import QQService.SvcDevLoginInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class abcc
  implements View.OnClickListener
{
  public abcc(LoginInfoActivity paramLoginInfoActivity, Button paramButton, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!badq.d(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity))
    {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity, this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getString(2131626719), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getTitleBarHeight());
      return;
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app, "CliOper", "", "", "My_eq", "Kick_off_PC", 0, 0, "", "", "", "");
    paramView = (SvcDevLoginInfo)this.jdField_a_of_type_AndroidWidgetButton.getTag();
    if (paramView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app.getSubAccountKey(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app.getAccount(), new abcd(this, paramView));
      return;
    }
    bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getString(2131628828), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abcc
 * JD-Core Version:    0.7.0.1
 */