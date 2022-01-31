import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditScrollerView;

public class acrp
  implements Animator.AnimatorListener
{
  public acrp(VoiceTextEditScrollerView paramVoiceTextEditScrollerView, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (VoiceTextEditScrollerView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView) != null)
    {
      if (this.jdField_a_of_type_Int == 0) {
        VoiceTextEditScrollerView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView).j();
      }
    }
    else {
      return;
    }
    VoiceTextEditScrollerView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView).k();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acrp
 * JD-Core Version:    0.7.0.1
 */