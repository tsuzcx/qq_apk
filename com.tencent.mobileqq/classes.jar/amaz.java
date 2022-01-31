import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.widget.DynamicGridView;

public class amaz
  implements ValueAnimator.AnimatorUpdateListener
{
  public amaz(DynamicGridView paramDynamicGridView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amaz
 * JD-Core Version:    0.7.0.1
 */