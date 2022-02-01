import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeoq
  implements View.OnClickListener
{
  public aeoq(ForwardRecentActivity paramForwardRecentActivity, ResultRecord paramResultRecord) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity)) {
      if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, antf.z, 6000))
      {
        ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity).a(false);
        ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, antf.z, 6000);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord))
      {
        ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity).a(true);
        continue;
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", String.valueOf(antf.z));
        localBundle.putInt("uintype", -1);
        localBundle.putBoolean("forward_report_confirm", true);
        localBundle.putString("forward_report_confirm_action_name", "0X8005A13");
        localBundle.putString("forward_report_confirm_reverse2", "0");
        localBundle.putString("caller_name", this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.c);
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_Auxu.a(auxr.f.intValue(), localBundle);
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_Auxu.D();
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.app, "CliOper", "", "", "friendchoose", "0X8009D90", ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity), 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_Boolean) {
          bjqh.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.app.getAccount(), "", this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.b, "1000", "34", "0", false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeoq
 * JD-Core Version:    0.7.0.1
 */