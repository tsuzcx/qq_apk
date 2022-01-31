import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ShopScanActivity;
import com.tencent.mobileqq.armap.config.ShopScanCheckHandler.Info;
import com.tencent.mobileqq.armap.config.ShopScanCheckHandler.OnResCheckResultListener;
import com.tencent.qphone.base.util.QLog;

class aasw
  implements ShopScanCheckHandler.OnResCheckResultListener
{
  aasw(aasr paramaasr) {}
  
  public void a(boolean paramBoolean, ShopScanCheckHandler.Info paramInfo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, new Object[] { "onClickPoi, success = ", Boolean.valueOf(paramBoolean), ", taskType: ", Integer.valueOf(this.a.jdField_a_of_type_Int), ", taskId: ", Long.valueOf(this.a.jdField_a_of_type_Long), ", poiId: ", Long.valueOf(this.a.b), ", info = ", paramInfo });
    }
    this.a.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.a.obtainMessage(9).sendToTarget();
    if (paramBoolean)
    {
      Intent localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, ShopScanActivity.class);
      localIntent.putExtra("taskType", paramInfo.jdField_a_of_type_Int);
      localIntent.putExtra("taskId", paramInfo.b);
      localIntent.putExtra("poiId", paramInfo.jdField_a_of_type_Long);
      localIntent.putExtra("tips", paramInfo.i);
      localIntent.putExtra("logoUrl", paramInfo.f);
      localIntent.putExtra("imageUrl", paramInfo.c);
      localIntent.putExtra("logoPath", paramInfo.h);
      localIntent.putExtra("imagePath", paramInfo.e);
      localIntent.putExtra("shopName", paramInfo.j);
      localIntent.putExtra("shopLocation", paramInfo.k);
      localIntent.putExtra("xmlContent", paramInfo.l);
      this.a.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.startActivityForResult(localIntent, 106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aasw
 * JD-Core Version:    0.7.0.1
 */