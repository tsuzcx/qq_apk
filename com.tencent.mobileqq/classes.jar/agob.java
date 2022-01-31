import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import java.util.HashSet;

public class agob
  implements Animator.AnimatorListener
{
  public agob(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, agoe paramagoe, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a.remove(Long.valueOf(this.jdField_a_of_type_Agoe.a));
    paramAnimator = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimator.height = -2;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimator);
    this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(false));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a.remove(Long.valueOf(this.jdField_a_of_type_Agoe.a));
    paramAnimator = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimator.height = -2;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimator);
    this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(false));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agob
 * JD-Core Version:    0.7.0.1
 */