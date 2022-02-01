import android.hardware.Camera;
import android.hardware.Camera.Face;
import android.hardware.Camera.FaceDetectionListener;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.qphone.base.util.QLog;

public class alut
  implements Camera.FaceDetectionListener
{
  public alut(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onFaceDetection(Camera.Face[] paramArrayOfFace, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alut
 * JD-Core Version:    0.7.0.1
 */