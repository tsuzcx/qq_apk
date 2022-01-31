import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.widget.AbsListView.LayoutParams;

class aknp
  implements ValueAnimator.AnimatorUpdateListener
{
  aknp(akno paramakno) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (akno.a(this.a) == null) {
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue("alpha")).intValue();
    int j = ((Integer)paramValueAnimator.getAnimatedValue("height")).intValue();
    akno.a(this.a).setAlpha(i / 100.0F);
    paramValueAnimator = akno.a(this.a).a();
    ((AbsListView.LayoutParams)paramValueAnimator.getLayoutParams()).height = j;
    paramValueAnimator.requestLayout();
    akno.a(this.a).scrollTo(0, j - akno.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aknp
 * JD-Core Version:    0.7.0.1
 */