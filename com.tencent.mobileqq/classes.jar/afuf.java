import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class afuf
  implements View.OnClickListener
{
  public afuf(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onClick(View paramView)
  {
    if (ScanTorchActivity.j(this.a)) {
      ScanTorchActivity.r(this.a);
    }
    while (!ScanTorchActivity.l(this.a)) {
      return;
    }
    ScanTorchActivity.s(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afuf
 * JD-Core Version:    0.7.0.1
 */