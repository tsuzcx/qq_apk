import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class abpn
  implements SDKInitListener
{
  abpn(abpi paramabpi) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.i("VideoGdtGdtMvViewController", 1, "onSDKInited " + paramBoolean);
    if (paramBoolean) {
      abpi.a(this.a).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpn
 * JD-Core Version:    0.7.0.1
 */