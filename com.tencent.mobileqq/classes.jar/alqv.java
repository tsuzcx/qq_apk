import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.AFCallbackForward.1;

public class alqv
  implements Camera.AutoFocusCallback
{
  private final alqm jdField_a_of_type_Alqm;
  private final alqs jdField_a_of_type_Alqs;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.AFCallbackForward.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alqv
 * JD-Core Version:    0.7.0.1
 */