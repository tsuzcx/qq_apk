import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.leba.LebaFeedsVideoSdkInstaller;
import com.tencent.mobileqq.leba.LebaFeedsVideoSdkInstaller.OnVideoPluginInstallListener;

public class aehm
  implements Handler.Callback
{
  public aehm(LebaFeedsVideoSdkInstaller paramLebaFeedsVideoSdkInstaller) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return true;
          LebaFeedsVideoSdkInstaller.a(this.a, false);
          LebaFeedsVideoSdkInstaller.a(this.a).removeMessages(0);
        } while (LebaFeedsVideoSdkInstaller.a(this.a) == null);
        LebaFeedsVideoSdkInstaller.a(this.a).c(true);
        return true;
        LebaFeedsVideoSdkInstaller.a(this.a, false);
        LebaFeedsVideoSdkInstaller.a(this.a).removeMessages(1);
      } while (LebaFeedsVideoSdkInstaller.a(this.a) == null);
      LebaFeedsVideoSdkInstaller.a(this.a).c(false);
      return true;
    }
    LebaFeedsVideoSdkInstaller.a(this.a, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehm
 * JD-Core Version:    0.7.0.1
 */