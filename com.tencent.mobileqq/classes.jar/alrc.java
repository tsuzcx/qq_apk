import android.hardware.Camera.ShutterCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.ShutterCallbackForward.1;

public class alrc
  implements Camera.ShutterCallback
{
  private final alqs jdField_a_of_type_Alqs;
  private final alqt jdField_a_of_type_Alqt;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  public void onShutter()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.ShutterCallbackForward.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alrc
 * JD-Core Version:    0.7.0.1
 */