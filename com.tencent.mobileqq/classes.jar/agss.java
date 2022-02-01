import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ViewAnimation;

class agss
  extends AnimatorListenerAdapter
{
  agss(agsm paramagsm) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (this.a.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation.mImageLayer = null;
      paramAnimator = ((ViewGroup)((Activity)this.a.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362299);
      if (paramAnimator != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation.setDuration(this.a.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getDuration());
        paramAnimator.startAnimation(this.a.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agss
 * JD-Core Version:    0.7.0.1
 */