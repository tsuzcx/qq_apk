import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusMoveCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.AFMoveCallbackForward.1;

@TargetApi(16)
public class alqw
  implements Camera.AutoFocusMoveCallback
{
  private final alqn jdField_a_of_type_Alqn;
  private final alqs jdField_a_of_type_Alqs;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  public void onAutoFocusMoving(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.AFMoveCallbackForward.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alqw
 * JD-Core Version:    0.7.0.1
 */