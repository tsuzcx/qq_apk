import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRManager;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;

public class agfc
  implements Runnable
{
  public agfc(OCRManager paramOCRManager, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.manager", 2, "onGetOCRConfig ,excute runnable");
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqOcrOCRManager.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null)) {
      synchronized (OCRManager.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRManager))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqOcrOCRManager.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
          this.jdField_a_of_type_ComTencentMobileqqOcrOCRManager.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.saveToFile(this.jdField_a_of_type_ComTencentMobileqqOcrOCRManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agfc
 * JD-Core Version:    0.7.0.1
 */