import android.os.Handler;
import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.ItemInfo;
import com.tencent.mobileqq.armap.ShopScanActivity;
import com.tencent.qphone.base.util.QLog;

public class abky
  extends ArMapObserver
{
  public abky(ShopScanActivity paramShopScanActivity) {}
  
  public void onOpenPOI(boolean paramBoolean1, int paramInt1, ItemInfo paramItemInfo, boolean paramBoolean2, int paramInt2, int paramInt3, boolean paramBoolean3)
  {
    if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(299)) {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(299);
    }
    if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(297))
    {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(297);
      if (QLog.isColorLevel()) {
        QLog.i("ShopScanActivity", 2, "onOpenPoi isSuccess: " + paramBoolean1 + ", resultCode: " + paramInt1 + ", mode: " + paramInt3 + ", holder: " + paramBoolean2 + ", bussiType: " + paramInt2 + ", isServerSuccess: " + paramBoolean3 + ", itemInfo: " + paramItemInfo);
      }
      if (paramItemInfo != null) {
        QLog.i("ShopScanActivity", 1, "itemInfo is " + paramItemInfo.toString());
      }
      if (!paramBoolean1) {
        break label321;
      }
      ShopScanActivity.b(this.a, true);
      label192:
      ShopScanActivity.d(this.a, paramBoolean3);
      if ((paramBoolean1) && (paramInt1 == 0)) {
        break label409;
      }
      switch (paramInt1)
      {
      default: 
        paramItemInfo = "领奖失败，请稍候再试。";
        this.a.runOnUiThread(new abkz(this, paramItemInfo));
        ShopScanActivity.a(this.a, ShopScanActivity.a(this.a), false);
      }
    }
    label321:
    while ((paramItemInfo == null) || (paramItemInfo.e <= 0)) {
      for (;;)
      {
        return;
        ShopScanActivity.f(this.a);
        break;
        if (paramInt1 == 19) {
          break label192;
        }
        ShopScanActivity.c(this.a, true);
        break label192;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(298, 30000L);
        paramItemInfo = "领奖失败，请稍候再试。";
        continue;
        paramItemInfo = "你已经领过这里的奖品了。";
        continue;
        paramItemInfo = "请到达指定地点后再扫描领奖。";
        continue;
        paramItemInfo = "今天领奖次数已达到上限。";
        continue;
        paramItemInfo = "来晚了一步，奖品已经发完了。";
        continue;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(298, 30000L);
        paramItemInfo = "领奖失败，请稍候再试。";
      }
    }
    label409:
    paramItemInfo.h = ShopScanActivity.b(this.a);
    this.a.runOnUiThread(new abla(this, paramItemInfo));
    this.a.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b(true);
    ShopScanActivity.a(this.a, ShopScanActivity.a(this.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abky
 * JD-Core Version:    0.7.0.1
 */