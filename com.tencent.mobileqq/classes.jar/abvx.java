import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.businessCard.views.BusinessCardViewScroller;

public class abvx
  implements ValueAnimator.AnimatorUpdateListener
{
  public abvx(BusinessCardViewScroller paramBusinessCardViewScroller) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvx
 * JD-Core Version:    0.7.0.1
 */