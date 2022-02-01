import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

public class acea
  implements SDKInitListener
{
  public acea(GameCenterActivity paramGameCenterActivity) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterActivity", 1, "QQVideo Inited:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acea
 * JD-Core Version:    0.7.0.1
 */