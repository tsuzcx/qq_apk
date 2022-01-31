import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.widget.NearbyFacePowerDialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class advy
  implements View.OnClickListener
{
  public advy(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131365271) {
      if (this.a.d == 2)
      {
        paramView = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, "是否下载now直播？", 0, 0, null, null);
        paramView.setPositiveButton("确定", new advz(this));
        paramView.setNegativeButton("取消", new adwa(this, paramView));
        paramView.show();
        NearbyUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "clk_pub", 1);
      }
    }
    while (i != 2131365272) {
      for (;;)
      {
        return;
        paramView = new NearbyFacePowerDialog(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
        paramView.a(new adwb(this, this.a.e));
        paramView.show();
      }
    }
    paramView = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
    paramView.putExtra("url", "https://nearby.qq.com/nearby-index/my_msg.html?_wv=1031&_bid=3027");
    this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(paramView);
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(38);
    this.a.b.setVisibility(8);
    NearbyUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "clk_msg", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advy
 * JD-Core Version:    0.7.0.1
 */