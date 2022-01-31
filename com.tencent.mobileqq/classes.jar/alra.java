import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.PictureCallbackForward.1;

public class alra
  implements Camera.PictureCallback
{
  private final alqq jdField_a_of_type_Alqq;
  private final alqs jdField_a_of_type_Alqs;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.PictureCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alra
 * JD-Core Version:    0.7.0.1
 */