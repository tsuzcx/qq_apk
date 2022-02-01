import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class acte
  implements SDKInitListener
{
  acte(acsz paramacsz) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.i("VideoGdtGdtMvViewController", 1, "onSDKInited " + paramBoolean);
    if (paramBoolean) {
      acsz.a(this.a).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acte
 * JD-Core Version:    0.7.0.1
 */