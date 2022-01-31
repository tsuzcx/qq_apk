import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.qphone.base.util.QLog;

public class ahlj
  implements Camera.AutoFocusCallback
{
  public ahlj(CameraCaptureView paramCameraCaptureView) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "single tap focus " + paramBoolean);
    }
    if (paramBoolean)
    {
      CameraCaptureView.a(this.a, true);
      return;
    }
    CameraCaptureView.a().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahlj
 * JD-Core Version:    0.7.0.1
 */