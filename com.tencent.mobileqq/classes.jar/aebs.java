import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.util.Log;
import android.view.View;

public class aebs
  implements ValueAnimator.AnimatorUpdateListener
{
  private View a;
  
  public aebs(View paramView)
  {
    this.a = paramView;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (PointF)paramValueAnimator.getAnimatedValue();
    this.a.setX(paramValueAnimator.x);
    this.a.setY(paramValueAnimator.y);
    Log.i("tag", "x:" + paramValueAnimator.x + ",y:" + paramValueAnimator.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebs
 * JD-Core Version:    0.7.0.1
 */