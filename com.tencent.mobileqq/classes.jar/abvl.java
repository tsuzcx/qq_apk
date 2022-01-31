import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper.CameraHelperCallback;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class abvl
  implements Camera.PictureCallback
{
  public abvl(CameraHelper paramCameraHelper, File paramFile, Rect paramRect1, Rect paramRect2, CameraHelper.CameraHelperCallback paramCameraHelperCallback) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w(CameraHelper.a, 2, "onPictureTaken data is null");
      }
      return;
    }
    new abvo(this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper, paramArrayOfByte, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper$CameraHelperCallback).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvl
 * JD-Core Version:    0.7.0.1
 */