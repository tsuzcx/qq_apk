import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper;

public class abvm
  implements Camera.AutoFocusCallback
{
  public abvm(CameraHelper paramCameraHelper) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    paramCamera = this.a.a();
    this.a.a(paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvm
 * JD-Core Version:    0.7.0.1
 */