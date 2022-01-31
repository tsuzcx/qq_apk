import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView;

public class aeom
  implements ValueAnimator.AnimatorUpdateListener
{
  public aeom(IntimateTitleSwitchView paramIntimateTitleSwitchView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_AndroidViewViewGroup.setTranslationX(this.a.f - i);
      this.a.b.setTranslationX(-i);
      return;
    }
    this.a.jdField_a_of_type_AndroidViewViewGroup.setTranslationX(-i);
    this.a.b.setTranslationX(this.a.f - i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeom
 * JD-Core Version:    0.7.0.1
 */