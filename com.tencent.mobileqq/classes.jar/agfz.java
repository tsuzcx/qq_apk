import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;

public class agfz
  implements ValueAnimator.AnimatorUpdateListener
{
  public agfz(UnlimitedBladeWorks paramUnlimitedBladeWorks) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = (ViewGroup.MarginLayoutParams)UnlimitedBladeWorks.a(this.a).getLayoutParams();
    if (UnlimitedBladeWorks.a(this.a)) {
      paramValueAnimator.leftMargin = 0;
    }
    for (paramValueAnimator.rightMargin = i;; paramValueAnimator.rightMargin = 0)
    {
      UnlimitedBladeWorks.a(this.a).setLayoutParams(paramValueAnimator);
      return;
      paramValueAnimator.leftMargin = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfz
 * JD-Core Version:    0.7.0.1
 */