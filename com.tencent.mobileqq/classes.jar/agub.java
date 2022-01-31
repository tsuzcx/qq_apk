import com.tencent.mobileqq.richmedia.capture.fragment.CameraCaptureFragment;
import com.tencent.qphone.base.util.QLog;

public class agub
  implements Runnable
{
  public agub(CameraCaptureFragment paramCameraCaptureFragment) {}
  
  public void run()
  {
    QLog.d("CameraCaptureFragment", 2, "onVideoCaptured. mDanceRestartToRecord = true  restart to record.");
    this.a.K_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agub
 * JD-Core Version:    0.7.0.1
 */