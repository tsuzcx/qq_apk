import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.PreviewCallbackForward.1;

public class alrb
  implements Camera.PreviewCallback
{
  private final alqr jdField_a_of_type_Alqr;
  private final alqs jdField_a_of_type_Alqs;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.PreviewCallbackForward.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alrb
 * JD-Core Version:    0.7.0.1
 */