import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.QQAppInterface;

public class aasq
  implements View.OnClickListener
{
  public aasq(ForwardRecentActivity paramForwardRecentActivity, ResultRecord paramResultRecord) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity)) {
      if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, ajed.z, 6000))
      {
        ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity).a(false);
        ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, ajed.z, 6000);
      }
    }
    do
    {
      do
      {
        return;
      } while (!ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord));
      ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity).a(true);
      return;
      paramView = new Bundle();
      paramView.putString("uin", String.valueOf(ajed.z));
      paramView.putInt("uintype", -1);
      paramView.putBoolean("forward_report_confirm", true);
      paramView.putString("forward_report_confirm_action_name", "0X8005A13");
      paramView.putString("forward_report_confirm_reverse2", "0");
      paramView.putString("caller_name", this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.c);
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_Aphp.a(aphf.f.intValue(), paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_Aphp.B();
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.app, "CliOper", "", "", "friendchoose", "0X8009D90", ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity), 0, "", "", "", "");
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_Boolean);
    bcad.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.app.getAccount(), "", this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.b, "1000", "34", "0", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aasq
 * JD-Core Version:    0.7.0.1
 */