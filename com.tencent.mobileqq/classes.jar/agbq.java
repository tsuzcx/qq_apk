import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.ocr.OcrControl;
import com.tencent.mobileqq.ocr.OcrControl.OcrCallback;
import java.util.HashMap;

public class agbq
  implements Runnable
{
  public agbq(OcrControl paramOcrControl, String paramString) {}
  
  public void run()
  {
    if (((ARCloudReqInfo)this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.a.get(this.jdField_a_of_type_JavaLangString) != null) && (OcrControl.a(this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl) != null)) {
      OcrControl.a(this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agbq
 * JD-Core Version:    0.7.0.1
 */