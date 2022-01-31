import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView;

public class akzi
  implements ValueAnimator.AnimatorUpdateListener
{
  public akzi(ARVideoRecordButtonView paramARVideoRecordButtonView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    ARVideoRecordButtonView.b(this.a, paramValueAnimator.floatValue());
    ARVideoRecordButtonView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akzi
 * JD-Core Version:    0.7.0.1
 */