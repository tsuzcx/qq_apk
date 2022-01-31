import android.widget.EditText;
import com.tencent.mobileqq.ocr.OCRObserver;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
import com.tencent.mobileqq.widget.QQToast;

public class agbf
  extends OCRObserver
{
  public agbf(OCRRecognitionResultActivity paramOCRRecognitionResultActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    OCRRecognitionResultActivity.a(this.a, 0);
    if (paramBoolean)
    {
      OCRRecognitionResultActivity.c(this.a);
      OCRRecognitionResultActivity.a(this.a, false);
      OCRRecognitionResultActivity.b(this.a).setText(paramString);
      return;
    }
    QQToast.a(this.a, 1, "翻译失败，请稍候再试。", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agbf
 * JD-Core Version:    0.7.0.1
 */