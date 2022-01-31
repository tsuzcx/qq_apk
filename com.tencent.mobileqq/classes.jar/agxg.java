import android.hardware.Camera;
import android.hardware.Camera.Face;
import android.hardware.Camera.FaceDetectionListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;

public final class agxg
  implements Camera.FaceDetectionListener
{
  public void onFaceDetection(Camera.Face[] paramArrayOfFace, Camera paramCamera)
  {
    if (CameraCaptureView.b() != paramArrayOfFace.length)
    {
      CameraCaptureView.b(paramArrayOfFace.length);
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "onFaceDetection, " + CameraCaptureView.b());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agxg
 * JD-Core Version:    0.7.0.1
 */