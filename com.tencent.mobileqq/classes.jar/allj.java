import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.widget.DynamicGridView;

public class allj
  implements ValueAnimator.AnimatorUpdateListener
{
  public allj(DynamicGridView paramDynamicGridView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     allj
 * JD-Core Version:    0.7.0.1
 */