import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mobileqq.leba.LebaFeedsAdapter;

public class adyl
  implements View.OnTouchListener
{
  public adyl(LebaFeedsAdapter paramLebaFeedsAdapter) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (LebaFeedsAdapter.a(this.a) != 4) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      LebaFeedsAdapter.a(this.a).setAlpha(0.5F);
      return false;
    }
    LebaFeedsAdapter.a(this.a).setAlpha(1.0F);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyl
 * JD-Core Version:    0.7.0.1
 */