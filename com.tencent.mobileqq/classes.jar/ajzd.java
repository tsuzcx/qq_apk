import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.widget.AbsListView.LayoutParams;

class ajzd
  implements ValueAnimator.AnimatorUpdateListener
{
  ajzd(ajzc paramajzc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (ajzc.a(this.a) == null) {
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue("alpha")).intValue();
    int j = ((Integer)paramValueAnimator.getAnimatedValue("height")).intValue();
    ajzc.a(this.a).setAlpha(i / 100.0F);
    paramValueAnimator = ajzc.a(this.a).a();
    ((AbsListView.LayoutParams)paramValueAnimator.getLayoutParams()).height = j;
    paramValueAnimator.requestLayout();
    ajzc.a(this.a).scrollTo(0, j - ajzc.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajzd
 * JD-Core Version:    0.7.0.1
 */