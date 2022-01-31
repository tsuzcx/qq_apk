import android.widget.ImageView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

class aghp
  implements Runnable
{
  aghp(agho paramagho) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - ScanTorchActivity.a(this.a.a);
    if (l > 500L)
    {
      ScanTorchActivity.d(this.a.a, ScanTorchActivity.b(this.a.a));
      return;
    }
    ScanTorchActivity.b(this.a.a).postDelayed(new aghq(this), 500L - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghp
 * JD-Core Version:    0.7.0.1
 */