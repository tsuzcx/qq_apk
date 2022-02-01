import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeos
  implements View.OnClickListener
{
  public aeos(ForwardRecentActivity paramForwardRecentActivity, DeviceInfo paramDeviceInfo, ForwardRecentItemView paramForwardRecentItemView, ResultRecord paramResultRecord, Resources paramResources, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity)) {
      if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, String.valueOf(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din), 9501))
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a(false);
        ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, String.valueOf(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din), 9501);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ForwardRecentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord))
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a(true);
        continue;
        if (!bhnv.g(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, anzj.a(2131703673), 1000).b(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299011));
        }
        else
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("uin", String.valueOf(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din));
          localBundle.putInt("uintype", 9501);
          localBundle.putString("uinname", this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.a.a(auxr.j.intValue(), localBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeos
 * JD-Core Version:    0.7.0.1
 */