import com.tencent.TMG.sdk.AVVideoCtrl.EnableCameraCompleteCallback;
import com.tencent.TMG.utils.QLog;

class akjb
  extends AVVideoCtrl.EnableCameraCompleteCallback
{
  akjb(akiy paramakiy) {}
  
  public void onComplete(boolean paramBoolean, int paramInt)
  {
    QLog.d("AVCameraCaptureModel", 0, "EnableCameraCompleteCallback.OnComplete. result = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akjb
 * JD-Core Version:    0.7.0.1
 */