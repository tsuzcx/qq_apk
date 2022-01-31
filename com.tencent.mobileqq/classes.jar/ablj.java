import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.armap.ShopScanActivity;
import com.tencent.mobileqq.scanfu.view.CameraDialog;

public class ablj
  implements View.OnClickListener
{
  public ablj(ShopScanActivity paramShopScanActivity, CameraDialog paramCameraDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqScanfuViewCameraDialog.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ablj
 * JD-Core Version:    0.7.0.1
 */