import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.qphone.base.util.QLog;

class ahof
  implements Camera.AutoFocusCallback
{
  ahof(ahoe paramahoe) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "Request Focus onAutoFocus");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahof
 * JD-Core Version:    0.7.0.1
 */