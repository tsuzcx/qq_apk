import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.arcard.ARCardShareHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class aafk
  implements Runnable
{
  aafk(aafj paramaafj, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aafj.jdField_a_of_type_Aafe.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      QRUtils.a(1, 2131433118);
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QRUtils.a(1, 2131429987);
      return;
    }
    Bitmap localBitmap = ARCardShareHelper.a(this.jdField_a_of_type_Aafj.jdField_a_of_type_Aafe.a);
    if (this.jdField_a_of_type_Aafj.jdField_a_of_type_Int == 9)
    {
      if (this.jdField_a_of_type_Aafj.jdField_a_of_type_Aafe.a.jdField_a_of_type_Boolean) {
        ReportController.b(null, "dc00898", "", "", "0X8008F1B", "0X8008F1B", 2, 0, "", "", "", "");
      }
      for (;;)
      {
        WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, localBitmap, 0);
        return;
        ReportController.b(null, "dc00898", "", "", "0X8008F27", "0X8008F27", 2, 0, "", "", "", "");
      }
    }
    if (this.jdField_a_of_type_Aafj.jdField_a_of_type_Aafe.a.jdField_a_of_type_Boolean) {
      ReportController.b(null, "dc00898", "", "", "0X8008F1B", "0X8008F1B", 4, 0, "", "", "", "");
    }
    for (;;)
    {
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, localBitmap, 1);
      return;
      ReportController.b(null, "dc00898", "", "", "0X8008F27", "0X8008F27", 4, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aafk
 * JD-Core Version:    0.7.0.1
 */