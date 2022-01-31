import android.os.Handler;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.RedPackRainCloudView;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.text.SimpleDateFormat;

public class abae
  implements Runnable
{
  public abae(ARMapActivity paramARMapActivity) {}
  
  public void run()
  {
    if ((ARMapActivity.a(this.a) != null) && (!this.a.isFinishing()))
    {
      long l = ARMapActivity.a(this.a).c - NetConnInfoCenter.getServerTimeMillis();
      if (l < 0L) {
        break label195;
      }
      String str1 = ARMapActivity.a(this.a, ARMapActivity.a(this.a), false) + "即将天降红包";
      if (ARMapActivity.a(this.a) == null) {
        ARMapActivity.a(this.a, new SimpleDateFormat("mm:ss"));
      }
      String str2 = ARMapActivity.a(this.a).format(Long.valueOf(l));
      if (this.a.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.getVisibility() != 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.setVisibility(0);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.a(str1, str2, true);
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(ARMapActivity.a(this.a));
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(ARMapActivity.a(this.a), 1000L);
    }
    label195:
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new abaf(this));
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.getVisibility() == 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqArmapRedPackRainCloudView.setVisibility(4);
      }
    } while (!ARMapActivity.h(this.a));
    ARMapActivity.a(this.a, ARMapActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abae
 * JD-Core Version:    0.7.0.1
 */