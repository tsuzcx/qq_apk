import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

class aftx
  implements Runnable
{
  aftx(aftw paramaftw) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - ScanTorchActivity.a(this.a.a);
    if (l > 300L)
    {
      if (TextUtils.isEmpty(ScanTorchActivity.c(this.a.a)))
      {
        ScanTorchActivity.r(this.a.a);
        return;
      }
      ScanTorchActivity.b(this.a.a, ScanTorchActivity.c(this.a.a));
      return;
    }
    ScanTorchActivity.a(this.a.a).postDelayed(new afty(this), 300L - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aftx
 * JD-Core Version:    0.7.0.1
 */