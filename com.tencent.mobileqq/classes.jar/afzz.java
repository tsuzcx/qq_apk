import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import java.util.HashSet;

public class afzz
  implements Animator.AnimatorListener
{
  public afzz(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, agac paramagac, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a.remove(Long.valueOf(this.jdField_a_of_type_Agac.a));
    paramAnimator = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimator.height = -2;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimator);
    this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(false));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a.remove(Long.valueOf(this.jdField_a_of_type_Agac.a));
    paramAnimator = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimator.height = -2;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimator);
    this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(false));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afzz
 * JD-Core Version:    0.7.0.1
 */