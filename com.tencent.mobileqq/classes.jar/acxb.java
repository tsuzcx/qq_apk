import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView;

public class acxb
  implements Animator.AnimatorListener
{
  public acxb(IntimateTitleSwitchView paramIntimateTitleSwitchView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_AndroidViewViewGroup.setTranslationX(0.0F);
      this.a.b.setTranslationX(this.a.f);
      return;
    }
    this.a.jdField_a_of_type_AndroidViewViewGroup.setTranslationX(this.a.f);
    this.a.b.setTranslationX(0.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    onAnimationCancel(paramAnimator);
    IntimateTitleSwitchView.f(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acxb
 * JD-Core Version:    0.7.0.1
 */