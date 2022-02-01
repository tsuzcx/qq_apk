import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

public class acem
  implements SDKInitListener
{
  public acem(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GCApi", 1, "QQVideo Inited:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acem
 * JD-Core Version:    0.7.0.1
 */