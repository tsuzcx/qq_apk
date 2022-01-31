import android.widget.ImageView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

class afua
  implements Runnable
{
  afua(aftz paramaftz) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - ScanTorchActivity.a(this.a.a);
    if (l > 500L)
    {
      ScanTorchActivity.c(this.a.a, ScanTorchActivity.c(this.a.a));
      return;
    }
    ScanTorchActivity.a(this.a.a).postDelayed(new afub(this), 500L - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afua
 * JD-Core Version:    0.7.0.1
 */