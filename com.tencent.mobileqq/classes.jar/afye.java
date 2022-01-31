import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.ImageShakeAnimView;

public class afye
  implements ValueAnimator.AnimatorUpdateListener
{
  public afye(FormalView paramFormalView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {
      return;
    }
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    int i = -(int)(FormalView.a(this.a) * f);
    int j = -(int)((1.0F - f) * FormalView.b(this.a));
    ((RelativeLayout.LayoutParams)FormalView.a(this.a).getLayoutParams()).topMargin = j;
    paramValueAnimator = (RelativeLayout.LayoutParams)FormalView.a(this.a).getLayoutParams();
    paramValueAnimator.leftMargin = i;
    FormalView.a(this.a).setLayoutParams(paramValueAnimator);
    paramValueAnimator = (RelativeLayout.LayoutParams)FormalView.b(this.a).getLayoutParams();
    paramValueAnimator.rightMargin = i;
    FormalView.b(this.a).setLayoutParams(paramValueAnimator);
    paramValueAnimator = (RelativeLayout.LayoutParams)FormalView.a(this.a).getLayoutParams();
    paramValueAnimator.topMargin = ((int)((1.0F - f) * FormalView.c(this.a)));
    FormalView.a(this.a).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     afye
 * JD-Core Version:    0.7.0.1
 */