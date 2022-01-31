import android.text.TextUtils;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
import com.tencent.mobileqq.ocr.OcrImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class afnx
  implements Runnable
{
  public afnx(OCRRecognitionResultActivity paramOCRRecognitionResultActivity, String paramString) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (new File(this.jdField_a_of_type_JavaLangString).exists()))
    {
      String str = new File(this.jdField_a_of_type_JavaLangString).getParent();
      if (OcrImageUtil.b.equals(str))
      {
        FileUtils.d(this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("OCRRecognitionResultActivity", 2, "delete pic path:" + this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afnx
 * JD-Core Version:    0.7.0.1
 */