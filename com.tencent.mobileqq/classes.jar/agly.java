import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

class agly
  implements Runnable
{
  agly(aglx paramaglx) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - ScanTorchActivity.a(this.a.a);
    if (l > 300L)
    {
      if (TextUtils.isEmpty(ScanTorchActivity.b(this.a.a)))
      {
        ScanTorchActivity.s(this.a.a);
        return;
      }
      ScanTorchActivity.c(this.a.a, ScanTorchActivity.b(this.a.a));
      return;
    }
    ScanTorchActivity.b(this.a.a).postDelayed(new aglz(this), 300L - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agly
 * JD-Core Version:    0.7.0.1
 */