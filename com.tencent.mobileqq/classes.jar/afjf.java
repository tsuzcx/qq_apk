import QQService.SvcDevLoginInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class afjf
  implements View.OnClickListener
{
  public afjf(RecentLoginDevActivity paramRecentLoginDevActivity, RelativeLayout paramRelativeLayout, int paramInt) {}
  
  public void onClick(View paramView)
  {
    SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localSvcDevLoginInfo.stDeviceItemDes);
    RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity, localSvcDevLoginInfo.strDeviceName, localArrayList, RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity), this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjf
 * JD-Core Version:    0.7.0.1
 */