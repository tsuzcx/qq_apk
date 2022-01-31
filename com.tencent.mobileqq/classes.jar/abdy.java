import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NearbyActivity;

public class abdy
  extends Handler
{
  public abdy(NearbyActivity paramNearbyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.a.c)
    {
      this.a.g();
      this.a.b.removeMessages(this.a.i);
      sendEmptyMessageDelayed(this.a.i, this.a.n);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abdy
 * JD-Core Version:    0.7.0.1
 */