import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class acff
  implements SDKInitListener
{
  acff(acey paramacey) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.i("VideoGdtGdtMvViewController", 1, "onSDKInited " + paramBoolean);
    if (paramBoolean) {
      acey.a(this.a).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acff
 * JD-Core Version:    0.7.0.1
 */