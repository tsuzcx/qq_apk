import android.os.Handler;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.RedPackRainCloudView;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.text.SimpleDateFormat;

public class abhg
  implements Runnable
{
  public abhg(ARMapActivity paramARMapActivity, WealthGodInfo paramWealthGodInfo) {}
  
  public void run()
  {
    boolean bool = false;
    long l1;
    long l3;
    if (!this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.isFinishing())
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.c;
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      l3 = l1 - l2;
      if (ArMapUtil.a(l1, l2)) {
        break label74;
      }
      ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, 2);
      if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.setVisibility(4);
      }
    }
    return;
    label74:
    Object localObject2;
    String str1;
    Object localObject1;
    if ((l3 > 0L) && (l3 <= 60000L))
    {
      localObject2 = ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo, false) + "即将天降红包";
      String str2 = new SimpleDateFormat("mm:ss").format(Long.valueOf(l3));
      this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidOsHandler.removeCallbacks(ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity));
      this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity), 1000L);
      str1 = str2;
      localObject1 = localObject2;
      if (ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity) != 3)
      {
        ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, 3);
        ARMapActivity.i(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity);
        localObject1 = localObject2;
        str1 = str2;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.setVisibility(0);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView;
      if (ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity) == 3) {
        bool = true;
      }
      ((RedPackRainCloudView)localObject2).a((String)localObject1, str1, bool);
      return;
      localObject1 = ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo, false) + "天降红包时间";
      if ((l3 > 0L) && (l3 < this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.b))
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidOsHandler.removeCallbacks(ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity));
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity), l3 - 60000L);
      }
      str1 = new SimpleDateFormat("HH:mm").format(Long.valueOf(l1));
      ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abhg
 * JD-Core Version:    0.7.0.1
 */