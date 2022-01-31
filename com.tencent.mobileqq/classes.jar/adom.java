import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.util.Log;
import android.view.View;

public class adom
  implements ValueAnimator.AnimatorUpdateListener
{
  private View a;
  
  public adom(View paramView)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adom
 * JD-Core Version:    0.7.0.1
 */