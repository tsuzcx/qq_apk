import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.richmedia.capture.view.QQSlidingTabView;

public class ahmt
  implements ValueAnimator.AnimatorUpdateListener
{
  public ahmt(QQSlidingTabView paramQQSlidingTabView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    QQSlidingTabView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahmt
 * JD-Core Version:    0.7.0.1
 */