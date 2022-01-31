import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.widget.TabDragAnimationView;

public final class akxe
  implements ValueAnimator.AnimatorUpdateListener
{
  private final TabDragAnimationView a;
  
  public akxe(TabDragAnimationView paramTabDragAnimationView)
  {
    this.a = paramTabDragAnimationView;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a(f, 0.0F, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akxe
 * JD-Core Version:    0.7.0.1
 */