import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;

public class abcl
  implements View.OnClickListener
{
  public abcl(ForwardRecentActivity paramForwardRecentActivity, DeviceInfo paramDeviceInfo, ForwardRecentItemView paramForwardRecentItemView, ResultRecord paramResultRecord, Resources paramResources, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity))
    {
      if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, String.valueOf(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din), 9501))
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a(false);
        ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, String.valueOf(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din), 9501);
      }
      while (!ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a(true);
      return;
    }
    if (!bbfj.g(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity))
    {
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, ajya.a(2131704786), 1000).b(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298865));
      return;
    }
    paramView = new Bundle();
    paramView.putString("uin", String.valueOf(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din));
    paramView.putInt("uintype", 9501);
    paramView.putString("uinname", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.a.a(aqau.j.intValue(), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abcl
 * JD-Core Version:    0.7.0.1
 */