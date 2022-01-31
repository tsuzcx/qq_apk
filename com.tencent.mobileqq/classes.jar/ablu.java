import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim;

public class ablu
  extends AnimatorListenerAdapter
{
  public ablu(BubbleNewAIOAnim paramBubbleNewAIOAnim, ObjectAnimator paramObjectAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.c != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim.c.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ablu
 * JD-Core Version:    0.7.0.1
 */