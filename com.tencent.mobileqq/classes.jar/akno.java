import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.widget.AbsListView.LayoutParams;

class akno
  implements ValueAnimator.AnimatorUpdateListener
{
  akno(aknn paramaknn) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (aknn.a(this.a) == null) {
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue("alpha")).intValue();
    int j = ((Integer)paramValueAnimator.getAnimatedValue("height")).intValue();
    aknn.a(this.a).setAlpha(i / 100.0F);
    paramValueAnimator = aknn.a(this.a).a();
    ((AbsListView.LayoutParams)paramValueAnimator.getLayoutParams()).height = j;
    paramValueAnimator.requestLayout();
    aknn.a(this.a).scrollTo(0, j - aknn.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akno
 * JD-Core Version:    0.7.0.1
 */