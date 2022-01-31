import android.os.Handler;
import com.tencent.mobileqq.widget.CircleProgressView;

public class akeq
  implements Runnable
{
  private akeq(CircleProgressView paramCircleProgressView) {}
  
  public void run()
  {
    if (CircleProgressView.a(this.a)) {
      CircleProgressView.a(this.a, CircleProgressView.a(this.a) + CircleProgressView.b(this.a));
    }
    for (;;)
    {
      CircleProgressView.a(this.a, CircleProgressView.a(this.a) % 360);
      CircleProgressView.a(this.a).postDelayed(this, 16L);
      this.a.invalidate();
      return;
      CircleProgressView.a(this.a, CircleProgressView.a(this.a) + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akeq
 * JD-Core Version:    0.7.0.1
 */