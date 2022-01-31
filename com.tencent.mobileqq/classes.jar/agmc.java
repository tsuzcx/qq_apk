import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.portal.ConversationHongBao;

public class agmc
  implements Animator.AnimatorListener
{
  public agmc(ConversationHongBao paramConversationHongBao, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.o();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.o();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.f) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmc
 * JD-Core Version:    0.7.0.1
 */