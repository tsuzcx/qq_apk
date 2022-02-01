import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class acpb
  implements SDKInitListener
{
  acpb(acow paramacow) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.i("VideoGdtGdtMvViewController", 1, "onSDKInited " + paramBoolean);
    if (paramBoolean) {
      acow.a(this.a).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpb
 * JD-Core Version:    0.7.0.1
 */