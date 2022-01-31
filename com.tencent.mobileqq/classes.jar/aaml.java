import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.arcard.ARCardShareHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class aaml
  implements Runnable
{
  aaml(aamk paramaamk, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aamk.jdField_a_of_type_Aamf.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      QRUtils.a(1, 2131433135);
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QRUtils.a(1, 2131430004);
      return;
    }
    Bitmap localBitmap = ARCardShareHelper.a(this.jdField_a_of_type_Aamk.jdField_a_of_type_Aamf.a);
    if (this.jdField_a_of_type_Aamk.jdField_a_of_type_Int == 9)
    {
      if (this.jdField_a_of_type_Aamk.jdField_a_of_type_Aamf.a.jdField_a_of_type_Boolean) {
        ReportController.b(null, "dc00898", "", "", "0X8008F1B", "0X8008F1B", 2, 0, "", "", "", "");
      }
      for (;;)
      {
        WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, localBitmap, 0);
        return;
        ReportController.b(null, "dc00898", "", "", "0X8008F27", "0X8008F27", 2, 0, "", "", "", "");
      }
    }
    if (this.jdField_a_of_type_Aamk.jdField_a_of_type_Aamf.a.jdField_a_of_type_Boolean) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaml
 * JD-Core Version:    0.7.0.1
 */