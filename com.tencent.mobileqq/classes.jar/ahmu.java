import com.tencent.mobileqq.richmedia.capture.fragment.CameraCaptureFragment;
import com.tencent.qphone.base.util.QLog;

public class ahmu
  implements Runnable
{
  public ahmu(CameraCaptureFragment paramCameraCaptureFragment) {}
  
  public void run()
  {
    QLog.d("CameraCaptureFragment", 2, "onVideoCaptured. mDanceRestartToRecord = true  restart to record.");
    this.a.z_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahmu
 * JD-Core Version:    0.7.0.1
 */