import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
import com.tencent.qphone.base.util.QLog;

public class agbe
  implements DialogInterface.OnDismissListener
{
  public agbe(OCRRecognitionResultActivity paramOCRRecognitionResultActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    OCRRecognitionResultActivity.a(this.a, -1);
    if (QLog.isColorLevel()) {
      QLog.d("OCRRecognitionResultActivity", 2, "mProgressDialog dismiss");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agbe
 * JD-Core Version:    0.7.0.1
 */