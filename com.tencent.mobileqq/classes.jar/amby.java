import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

class amby
  extends AnimatorListenerAdapter
{
  amby(ambv paramambv, ObjectAnimator paramObjectAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Ambv.c != null) {
      this.jdField_a_of_type_Ambv.c.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amby
 * JD-Core Version:    0.7.0.1
 */