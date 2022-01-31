import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.qphone.base.util.QLog;

class aich
  implements Camera.AutoFocusCallback
{
  aich(aicg paramaicg) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "Request Focus onAutoFocus");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aich
 * JD-Core Version:    0.7.0.1
 */