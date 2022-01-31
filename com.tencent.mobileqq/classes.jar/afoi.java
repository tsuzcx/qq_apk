import com.tencent.mobileqq.ocr.OcrCamera;
import com.tencent.mobileqq.ocr.OcrCamera.CameraCallback;
import com.tencent.mobileqq.ocr.OcrImageUtil;

public class afoi
  implements Runnable
{
  public afoi(OcrCamera paramOcrCamera, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback.a();
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = OcrImageUtil.a(this.jdField_a_of_type_ArrayOfByte, OcrCamera.a(this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera), OcrCamera.b(this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera), OcrCamera.c(this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera), this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.jdField_a_of_type_AndroidGraphicsRectF, true);; str = OcrImageUtil.a(this.jdField_a_of_type_ArrayOfByte, OcrCamera.d(this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera), OcrCamera.e(this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera), OcrCamera.c(this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera), this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.jdField_b_of_type_Int))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback.a(str);
      }
      OcrCamera.a(this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afoi
 * JD-Core Version:    0.7.0.1
 */