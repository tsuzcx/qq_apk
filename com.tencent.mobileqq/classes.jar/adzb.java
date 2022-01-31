import com.tencent.mobileqq.leba.LebaFeedsVideoSdkInstaller;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class adzb
  implements Runnable
{
  public adzb(LebaFeedsVideoSdkInstaller paramLebaFeedsVideoSdkInstaller) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaFeedsVideoSdkInstaller", 2, "start install video sdk in subThread");
    }
    try
    {
      if (LebaFeedsVideoSdkInstaller.a(this.a) != null) {
        TVK_SDKMgr.installPlugin(LebaFeedsVideoSdkInstaller.a(this.a), new adzd(LebaFeedsVideoSdkInstaller.a(this.a)));
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LebaFeedsVideoSdkInstaller", 2, "TVK_SDKMgr.installPlugin ERROR e=" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzb
 * JD-Core Version:    0.7.0.1
 */