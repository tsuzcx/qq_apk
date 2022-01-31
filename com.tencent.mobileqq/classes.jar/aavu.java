import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;

public class aavu
  implements Animator.AnimatorListener
{
  public aavu(ConversationPullDownActiveBase paramConversationPullDownActiveBase, View paramView1, View paramView2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    paramAnimator.topMargin = (-this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.g);
    this.b.setLayoutParams(paramAnimator);
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.k)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    paramAnimator.topMargin = (-this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.g);
    this.b.setLayoutParams(paramAnimator);
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.k)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.k) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aavu
 * JD-Core Version:    0.7.0.1
 */