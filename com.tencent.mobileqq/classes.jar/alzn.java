import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;

public class alzn
  extends AnimatorListenerAdapter
{
  public alzn(SelectCoverActivity paramSelectCoverActivity, View paramView1, View paramView2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.b.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.a = null;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.b.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alzn
 * JD-Core Version:    0.7.0.1
 */