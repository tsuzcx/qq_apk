import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agns
  implements View.OnTouchListener
{
  public agns(ScanTorchActivity paramScanTorchActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      ScanTorchActivity.m(this.a).setAlpha(255);
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 0) {
        ScanTorchActivity.m(this.a).setAlpha(100);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agns
 * JD-Core Version:    0.7.0.1
 */