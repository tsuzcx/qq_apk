import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adyv
  implements View.OnClickListener
{
  public adyv(ForwardRecentActivity paramForwardRecentActivity, ResultRecord paramResultRecord) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity)) {
      if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, AppConstants.DATALINE_IPAD_UIN, 6003))
      {
        ForwardRecentActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity).a(false);
        ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, AppConstants.DATALINE_IPAD_UIN, 6003);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord))
      {
        ForwardRecentActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity).a(true);
        continue;
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", AppConstants.DATALINE_IPAD_UIN);
        localBundle.putInt("uintype", -1);
        localBundle.putString("caller_name", this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.c);
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.a.a(aupp.k.intValue(), localBundle);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.app, "CliOper", "", "", "friendchoose", "0X8009D90", ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity), 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adyv
 * JD-Core Version:    0.7.0.1
 */