import android.text.TextUtils;
import com.tencent.mobileqq.ocr.OcrControl.OcrCallback;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity.OcrResultCache;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class agme
  implements OcrControl.OcrCallback
{
  public agme(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "OcrControl.onExceed3s");
    }
  }
  
  public void a(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("OcrControl.onResult errCode=%s ocrResult=%s imagePath=%s costTime=%s", new Object[] { Integer.valueOf(paramInt), paramOcrRecogResult, paramString, Long.valueOf(paramLong) }));
    }
    if ((!ScanTorchActivity.k(this.a)) || (TextUtils.isEmpty(ScanTorchActivity.b(this.a))) || (!ScanTorchActivity.b(this.a).equals(paramString))) {
      return;
    }
    if (ScanTorchActivity.l(this.a))
    {
      this.a.runOnUiThread(new agmf(this, paramInt, paramOcrRecogResult, paramString, paramLong));
      return;
    }
    ScanTorchActivity.a(this.a, new ScanOcrActivity.OcrResultCache());
    ScanTorchActivity.a(this.a).jdField_a_of_type_Int = paramInt;
    ScanTorchActivity.a(this.a).jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult = paramOcrRecogResult;
    ScanTorchActivity.a(this.a).jdField_a_of_type_JavaLangString = paramString;
    ScanTorchActivity.a(this.a).jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agme
 * JD-Core Version:    0.7.0.1
 */