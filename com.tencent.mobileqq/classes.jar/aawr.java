import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.armap.ShopScanActivity;
import com.tencent.qphone.base.util.QLog;

public class aawr
  implements Runnable
{
  public aawr(ShopScanActivity paramShopScanActivity, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, ArVideoResourceInfo paramArVideoResourceInfo) {}
  
  public void run()
  {
    ShopScanActivity.c(this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity);
    this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.a.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aaws(this));
    if (QLog.isColorLevel()) {
      QLog.i("ShopScanActivity", 2, "onMultiARAnimationInteraction 请点击屏幕进入下一动画片段！");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aawr
 * JD-Core Version:    0.7.0.1
 */