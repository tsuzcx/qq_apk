import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;

public class abav
  implements Runnable
{
  public abav(ARMapLoadingActivity paramARMapLoadingActivity) {}
  
  public void run()
  {
    if (ARMapLoadingActivity.a(this.a) >= 0L)
    {
      ARMapLoadingActivity.a(this.a).sendEmptyMessage(101);
      return;
    }
    Message localMessage = ARMapLoadingActivity.a(this.a).obtainMessage(104);
    localMessage.arg1 = 1;
    ARMapLoadingActivity.a(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abav
 * JD-Core Version:    0.7.0.1
 */