import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.now.enter.ConversationNowController;

public class agag
  implements Animator.AnimatorListener
{
  public agag(ConversationNowController paramConversationNowController, View paramView1, View paramView2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    paramAnimator.topMargin = (-ConversationNowController.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController));
    this.b.setLayoutParams(paramAnimator);
    if ((this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController.d) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    paramAnimator.topMargin = (-ConversationNowController.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController));
    this.b.setLayoutParams(paramAnimator);
    if ((this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController.d) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController.d) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agag
 * JD-Core Version:    0.7.0.1
 */