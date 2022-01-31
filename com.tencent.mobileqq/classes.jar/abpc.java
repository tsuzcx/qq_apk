import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManager.CameraAFCallback;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;

public class abpc
  implements Camera.AutoFocusCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CameraManager.CameraAFCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraAFCallback;
  private final CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new abpd(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpc
 * JD-Core Version:    0.7.0.1
 */