import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim.AnimHolder;
import com.tencent.qphone.base.util.QLog;

public class ablc
  implements Animator.AnimatorListener
{
  public ablc(BubbleInterActiveAnim paramBubbleInterActiveAnim, BubbleInterActiveAnim.AnimHolder paramAnimHolder) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "onAnimationCancel " + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "onAnimationEnd " + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "onAnimationRepeat " + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_Long);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "onAnimationStart " + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ablc
 * JD-Core Version:    0.7.0.1
 */