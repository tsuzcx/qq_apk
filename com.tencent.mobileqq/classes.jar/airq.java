import com.tencent.TMG.sdk.AVVideoCtrl.EnableCameraCompleteCallback;
import com.tencent.TMG.utils.QLog;

class airq
  extends AVVideoCtrl.EnableCameraCompleteCallback
{
  airq(airn paramairn) {}
  
  public void onComplete(boolean paramBoolean, int paramInt)
  {
    QLog.d("AVCameraCaptureModel", 0, "EnableCameraCompleteCallback.OnComplete. result = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     airq
 * JD-Core Version:    0.7.0.1
 */