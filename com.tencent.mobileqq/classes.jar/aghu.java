import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class aghu
  implements View.OnClickListener
{
  public aghu(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onClick(View paramView)
  {
    if (ScanTorchActivity.k(this.a)) {
      ScanTorchActivity.s(this.a);
    }
    while (!ScanTorchActivity.m(this.a)) {
      return;
    }
    ScanTorchActivity.t(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghu
 * JD-Core Version:    0.7.0.1
 */