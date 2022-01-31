import android.widget.TextView;
import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.armap.ShopScanActivity;

public class abdh
  implements Runnable
{
  public abdh(ShopScanActivity paramShopScanActivity, ARTarget paramARTarget) {}
  
  public void run()
  {
    ShopScanActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity, true);
    this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_a_of_type_ComTencentMobileqqArARScanFragment.e(true);
    this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    ShopScanActivity.c(this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity);
    this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(false);
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.g) && (this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.i))
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.d();
      return;
    }
    ShopScanActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.a.a);
    this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.h = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abdh
 * JD-Core Version:    0.7.0.1
 */