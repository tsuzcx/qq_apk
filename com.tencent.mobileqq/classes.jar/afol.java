import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.ocr.OcrControl;
import com.tencent.mobileqq.ocr.OcrControl.OcrCallback;

public class afol
  implements Runnable
{
  public afol(OcrControl paramOcrControl, String paramString, ARCloudReqFileInfo paramARCloudReqFileInfo) {}
  
  public void run()
  {
    ARCloudReqInfo localARCloudReqInfo = OcrControl.a(this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl, this.jdField_a_of_type_JavaLangString);
    if ((localARCloudReqInfo != null) && (OcrControl.a(this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl) != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localARCloudReqInfo.c;
      OcrControl.a(this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl).a(4, null, this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.b, l1 - l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afol
 * JD-Core Version:    0.7.0.1
 */