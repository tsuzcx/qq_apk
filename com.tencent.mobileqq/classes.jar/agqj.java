import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.portal.ConversationHongBao;

public class agqj
  implements Animator.AnimatorListener
{
  public agqj(ConversationHongBao paramConversationHongBao, View paramView1, View paramView2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    paramAnimator.topMargin = (-ConversationHongBao.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao));
    this.b.setLayoutParams(paramAnimator);
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.f)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    paramAnimator.topMargin = (-ConversationHongBao.a(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao));
    this.b.setLayoutParams(paramAnimator);
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.f)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.f) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqj
 * JD-Core Version:    0.7.0.1
 */