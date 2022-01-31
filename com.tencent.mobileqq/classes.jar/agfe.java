import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
import com.tencent.mobileqq.ocr.OcrControl.OcrCallback;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.qphone.base.util.QLog;

public class agfe
  implements OcrControl.OcrCallback
{
  public agfe(OCRRecognitionResultActivity paramOCRRecognitionResultActivity) {}
  
  public void a() {}
  
  public void a(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(OCRRecognitionResultActivity.c(this.a))) || (!OCRRecognitionResultActivity.c(this.a).equals(paramString)))
    {
      QLog.d("OCRRecognitionResultActivity", 1, "OcrCallback onResult ignore, mRecogPicPath:" + OCRRecognitionResultActivity.c(this.a) + " ,imagePath:" + paramString);
      return;
    }
    OCRRecognitionResultActivity.a(this.a).removeMessages(2);
    OCRRecognitionResultActivity.a(this.a, 2);
    if ((paramInt == 0) && (paramOcrRecogResult != null) && (!paramOcrRecogResult.isEmpty()) && (!TextUtils.isEmpty(paramOcrRecogResult.ocrContent)) && (!TextUtils.isEmpty(paramOcrRecogResult.ocrContent.trim())))
    {
      OCRRecognitionResultActivity.a(this.a).post(new agff(this, paramOcrRecogResult));
      return;
    }
    OCRRecognitionResultActivity.a(this.a).post(new agfg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agfe
 * JD-Core Version:    0.7.0.1
 */