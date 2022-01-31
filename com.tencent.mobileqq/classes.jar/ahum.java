import android.hardware.Camera;
import android.hardware.Camera.Face;
import android.hardware.Camera.FaceDetectionListener;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.qphone.base.util.QLog;

public class ahum
  implements Camera.FaceDetectionListener
{
  public ahum(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onFaceDetection(Camera.Face[] paramArrayOfFace, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahum
 * JD-Core Version:    0.7.0.1
 */