import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
import com.tencent.mobileqq.ocr.view.TranslatePopupActionSheetMenuDialog.MenuItem;
import com.tencent.mobileqq.ocr.view.TranslatePopupActionSheetMenuDialog.OnClickActionListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class agfi
  implements TranslatePopupActionSheetMenuDialog.OnClickActionListener
{
  public agfi(OCRRecognitionResultActivity paramOCRRecognitionResultActivity) {}
  
  public void a(TranslatePopupActionSheetMenuDialog.MenuItem paramMenuItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OCRRecognitionResultActivity", 2, "popupActionSheet onClickAction item.language: " + paramMenuItem.a + " mLastTranslateLanguage: " + OCRRecognitionResultActivity.b(this.a));
    }
    if (TextUtils.equals(paramMenuItem.a, OCRRecognitionResultActivity.b(this.a))) {
      return;
    }
    if ((TextUtils.equals(paramMenuItem.a, "jp")) || (TextUtils.equals(paramMenuItem.a, "日语"))) {
      ReportController.b(null, "dc00898", "", "", "0X8009108", "0X8009108", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      OCRRecognitionResultActivity.b(this.a, paramMenuItem.a);
      paramMenuItem = OCRRecognitionResultActivity.a(this.a).obtainMessage(2, 0, 0, "正在翻译...");
      OCRRecognitionResultActivity.a(this.a).sendMessageDelayed(paramMenuItem, 500L);
      OCRRecognitionResultActivity.a(this.a, OCRRecognitionResultActivity.e(this.a), OCRRecognitionResultActivity.a(this.a));
      return;
      if ((TextUtils.equals(paramMenuItem.a, "kr")) || (TextUtils.equals(paramMenuItem.a, "韩语"))) {
        ReportController.b(null, "dc00898", "", "", "0X8009109", "0X8009109", 0, 0, "", "", "", "");
      } else if ((TextUtils.equals(paramMenuItem.a, "es")) || (TextUtils.equals(paramMenuItem.a, "西班牙语"))) {
        ReportController.b(null, "dc00898", "", "", "0X800910A", "0X800910A", 0, 0, "", "", "", "");
      } else if ((TextUtils.equals(paramMenuItem.a, "fr")) || (TextUtils.equals(paramMenuItem.a, "法语"))) {
        ReportController.b(null, "dc00898", "", "", "0X800910B", "0X800910B", 0, 0, "", "", "", "");
      } else if ((TextUtils.equals(paramMenuItem.a, "de")) || (TextUtils.equals(paramMenuItem.a, "德语"))) {
        ReportController.b(null, "dc00898", "", "", "0X800910C", "0X800910C", 0, 0, "", "", "", "");
      } else if ((TextUtils.equals(paramMenuItem.a, "pt")) || (TextUtils.equals(paramMenuItem.a, "葡萄牙语"))) {
        ReportController.b(null, "dc00898", "", "", "0X800910D", "0X800910D", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agfi
 * JD-Core Version:    0.7.0.1
 */