import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextEditScrollerView;

public class ainm
  implements Animator.AnimatorListener
{
  public ainm(VoiceTextEditScrollerView paramVoiceTextEditScrollerView, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (VoiceTextEditScrollerView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView) != null)
    {
      if (this.jdField_a_of_type_Int == 0) {
        VoiceTextEditScrollerView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView).c();
      }
    }
    else {
      return;
    }
    VoiceTextEditScrollerView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView).b();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainm
 * JD-Core Version:    0.7.0.1
 */