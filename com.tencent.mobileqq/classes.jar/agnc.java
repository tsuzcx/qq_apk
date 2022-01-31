import android.graphics.Bitmap;
import com.tencent.mobileqq.armap.ItemInfo;
import com.tencent.mobileqq.binhai.BinHaiOpenRedPackDialog;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.ItemInfo;

public class agnc
  implements Runnable
{
  public agnc(ScanTorchActivity paramScanTorchActivity, ArrayList paramArrayList, int paramInt, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap = null;
    Object localObject2;
    if (ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity) == null)
    {
      ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, new BinHaiOpenRedPackDialog(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.b));
      ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).a(new agnd(this));
      ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, false, 0);
      localObject1 = ItemInfo.a((oidb_0x98b.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      localObject2 = ((ItemInfo)localObject1).jdField_a_of_type_JavaLangString;
      String str = "http://sqimg.qq.com/qq_product_operations/mma/binhai_redpack_2017/rank.html?_wv=536929249&_wwv=5&actid=" + ScanTorchActivity.c(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
      ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).a((String)localObject2, "", "", "", (ItemInfo)localObject1, this.jdField_a_of_type_Int, str, this.jdField_a_of_type_JavaLangString);
      localObject2 = ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, "res/redpack/redpack_bg.png", true);
      if (this.jdField_a_of_type_Int <= 1) {
        break label247;
      }
    }
    label247:
    for (Object localObject1 = ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, "res/redpack/redpack_left.png", true);; localObject1 = null)
    {
      if (this.jdField_a_of_type_Int > 1) {
        localBitmap = ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, "res/redpack/redpack_right.png", true);
      }
      ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).a((Bitmap)localObject2, (Bitmap)localObject1, localBitmap);
      ScanTorchActivity.c(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, false);
      ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).show();
      return;
      if (!ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).isShowing()) {
        break;
      }
      ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).dismiss();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnc
 * JD-Core Version:    0.7.0.1
 */