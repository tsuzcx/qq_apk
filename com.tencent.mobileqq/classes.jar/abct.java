import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;

public class abct
  implements Animator.AnimatorListener
{
  public abct(ConversationPullDownActiveBase paramConversationPullDownActiveBase, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.p();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.p();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.k) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abct
 * JD-Core Version:    0.7.0.1
 */