import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim.AnimHolder;

public class ablf
  extends AnimatorListenerAdapter
{
  public ablf(BubbleInterActiveAnim paramBubbleInterActiveAnim, BubbleInterActiveAnim.AnimHolder paramAnimHolder, ObjectAnimator paramObjectAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.a.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ablf
 * JD-Core Version:    0.7.0.1
 */