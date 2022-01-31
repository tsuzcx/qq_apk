import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.armap.ShopScanActivity;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;

public class abdo
  implements Runnable
{
  public abdo(ShopScanActivity paramShopScanActivity, ARTarget paramARTarget, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 0)) {
      if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.b)
      {
        ShopScanActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity, true);
        this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_a_of_type_ComTencentMobileqqArARScanFragment.e(true);
        this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(1L);
          this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b();
        }
        this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.d();
      }
    }
    do
    {
      do
      {
        return;
        String str = this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.setResult(11);
        Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.a(str));
        this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.startActivity(localIntent);
        this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(true);
      } while ((ShopScanActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity) == null) || (ShopScanActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity).a.d()));
      this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.reportClickEvent("CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.getCurrentAccountUin(), ShopScanActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity).a.b, "2");
      return;
      ShopScanActivity.c(this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity);
    } while (!this.jdField_a_of_type_Boolean);
    ShopScanActivity.e(this.jdField_a_of_type_ComTencentMobileqqArmapShopScanActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abdo
 * JD-Core Version:    0.7.0.1
 */