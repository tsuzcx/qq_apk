import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.campuscircle.CampusCirclePublishActivity;

public class abpn
  implements ValueAnimator.AnimatorUpdateListener
{
  public abpn(CampusCirclePublishActivity paramCampusCirclePublishActivity) {}
  
  @TargetApi(14)
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ViewGroup.LayoutParams localLayoutParams = this.a.a.getLayoutParams();
    localLayoutParams.width = -1;
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f < 1.0F)
    {
      this.a.b.setAlpha(1.0F - f);
      this.a.c.setAlpha(0.0F);
    }
    for (int i = this.a.f;; i = (int)(this.a.f - (f - 1.0F) * this.a.e))
    {
      if (localLayoutParams.height != i)
      {
        localLayoutParams.height = i;
        this.a.a.setLayoutParams(localLayoutParams);
      }
      return;
      this.a.b.setAlpha(0.0F);
      this.a.c.setAlpha(f - 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpn
 * JD-Core Version:    0.7.0.1
 */