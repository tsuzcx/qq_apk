import android.os.Handler;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.OCRObserver;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
import com.tencent.mobileqq.ocr.OcrControl;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;

public class agfp
  extends OCRObserver
{
  public agfp(OCRRecognitionResultActivity paramOCRRecognitionResultActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    OCRRecognitionResultActivity.a(this.a).removeMessages(2);
    OCRRecognitionResultActivity.a(this.a, 0);
    if (paramBoolean)
    {
      OCRRecognitionResultActivity.c(this.a);
      OCRRecognitionResultActivity.a(this.a, false);
      OCRRecognitionResultActivity.b(this.a).setText(paramString);
      if (!TextUtils.isEmpty(OCRRecognitionResultActivity.a(this.a)))
      {
        OCRRecognitionResultActivity.a(this.a, OCRRecognitionResultActivity.a(this.a));
        OCRRecognitionResultActivity.b(this.a, null);
        if (OcrControl.b.containsKey(OCRRecognitionResultActivity.b(this.a))) {
          OCRRecognitionResultActivity.a(this.a).setText((CharSequence)OcrControl.b.get(OCRRecognitionResultActivity.b(this.a)));
        }
      }
      return;
    }
    QQToast.a(this.a, 1, "翻译失败，请稍候再试。", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agfp
 * JD-Core Version:    0.7.0.1
 */