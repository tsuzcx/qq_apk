import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsAnimation;
import com.tencent.mobileqq.utils.ViewUtils;

public class afwk
  implements afwo
{
  public afwk(BusinessEggsAnimation paramBusinessEggsAnimation) {}
  
  public Point a(Point paramPoint)
  {
    Point localPoint = new Point();
    localPoint.x = ((int)(bhhc.a(-1.0F, 1.0F) * ViewUtils.dip2px(50.0F) + paramPoint.x / 2));
    localPoint.y = 0;
    return localPoint;
  }
  
  public Point a(Point paramPoint1, Point paramPoint2, float paramFloat)
  {
    Point localPoint = new Point();
    if (paramPoint1.x % 2 == 0) {}
    for (int i = (int)(Math.sin(paramFloat * 6.283185307179586D) * ViewUtils.dip2px(60.0F));; i = (int)(Math.cos(paramFloat * 6.283185307179586D) * ViewUtils.dip2px(60.0F)))
    {
      localPoint.x = ((int)(i * 1.5F + paramPoint1.x));
      localPoint.y = ((int)(1.3F * paramPoint2.y * paramFloat));
      return localPoint;
    }
  }
  
  public void a(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator.setDuration(5500L);
    paramValueAnimator.setInterpolator(new AccelerateInterpolator());
    paramValueAnimator.addListener(new afwl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwk
 * JD-Core Version:    0.7.0.1
 */