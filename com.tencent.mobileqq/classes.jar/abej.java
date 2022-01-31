import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.armap.ShopScanActivity;
import com.tencent.mobileqq.scanfu.view.CameraDialog;

public class abej
  implements View.OnClickListener
{
  public abej(ShopScanActivity paramShopScanActivity, CameraDialog paramCameraDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqScanfuViewCameraDialog.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abej
 * JD-Core Version:    0.7.0.1
 */