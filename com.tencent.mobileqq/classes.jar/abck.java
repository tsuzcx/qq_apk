import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;

public class abck
  implements View.OnClickListener
{
  public abck(ForwardRecentActivity paramForwardRecentActivity, ResultRecord paramResultRecord) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity))
    {
      if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, ajsd.A, 6003))
      {
        ForwardRecentActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity).a(false);
        ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, ajsd.A, 6003);
      }
      while (!ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord)) {
        return;
      }
      ForwardRecentActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity).a(true);
      return;
    }
    paramView = new Bundle();
    paramView.putString("uin", ajsd.A);
    paramView.putInt("uintype", -1);
    paramView.putString("caller_name", this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.a.a(aqau.k.intValue(), paramView);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.app, "CliOper", "", "", "friendchoose", "0X8009D90", ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abck
 * JD-Core Version:    0.7.0.1
 */