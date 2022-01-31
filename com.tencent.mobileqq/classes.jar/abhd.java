import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.RedPackRainCloudView;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;
import com.tencent.qphone.base.util.QLog;

public class abhd
  implements Runnable
{
  public abhd(ARMapActivity paramARMapActivity, WealthGodInfo paramWealthGodInfo) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.a + "_" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_c_of_type_Long;
    long l;
    if (TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_c_of_type_JavaLangString))
    {
      ARMapActivity localARMapActivity = this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_c_of_type_Long >= 0L)
      {
        l = Math.min(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_c_of_type_Long);
        localARMapActivity.jdField_c_of_type_Long = l;
        label92:
        if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_c_of_type_Long <= 0L) {
          this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_c_of_type_Long = 0L;
        }
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_c_of_type_JavaLangString = str;
        if (QLog.isColorLevel()) {
          QLog.i("ARMapActivity", 2, "updateLeftRedPackCount region=" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_b_of_type_JavaLangString + "  count=" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_b_of_type_Long + "  mLastRedPackCount:" + this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_c_of_type_Long);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_c_of_type_Long <= 0L) && (!ARMapActivity.d(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity))) {
          break label444;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.getVisibility() != 0) {
          this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidOsHandler.removeCallbacks(ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity));
        if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_c_of_type_Long <= 0L) {
          break label383;
        }
        str = ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo, true) + "天降红包还有";
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.a(str, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_c_of_type_Long);
        ARMapActivity.d(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, true);
        ARMapActivity.g(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity);
        if (ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity) != 4)
        {
          ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, 4);
          ARMapActivity.h(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity);
        }
      }
    }
    label383:
    while (this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.getVisibility() != 0) {
      for (;;)
      {
        return;
        l = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_b_of_type_Long;
        break;
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_b_of_type_Long;
        break label92;
        str = ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo, true) + "天降红包已结束…";
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.b(str);
        ARMapActivity.d(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, false);
        ARMapActivity.c(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity);
      }
    }
    label444:
    this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abhd
 * JD-Core Version:    0.7.0.1
 */