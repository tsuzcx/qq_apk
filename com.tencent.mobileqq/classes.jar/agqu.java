import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.profile.view.CircularProgressBar;

public class agqu
  extends Handler
{
  public agqu(CircularProgressBar paramCircularProgressBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    this.a.invalidate();
    if (CircularProgressBar.a(this.a))
    {
      CircularProgressBar.a(this.a, CircularProgressBar.a(this.a) + CircularProgressBar.b(this.a));
      if (CircularProgressBar.a(this.a) > 360) {
        CircularProgressBar.a(this.a, 0);
      }
      CircularProgressBar.a(this.a).sendEmptyMessageDelayed(0, CircularProgressBar.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agqu
 * JD-Core Version:    0.7.0.1
 */