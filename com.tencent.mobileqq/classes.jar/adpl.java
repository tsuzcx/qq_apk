import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator.HeartAnimatorListener;
import java.util.concurrent.atomic.AtomicInteger;

public class adpl
  implements Animation.AnimationListener
{
  public adpl(HeartAnimator paramHeartAnimator, ViewGroup paramViewGroup, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.jdField_a_of_type_AndroidOsHandler.post(new adpm(this));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    if (HeartAnimator.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator) != null) {
      HeartAnimator.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator).b(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    if (HeartAnimator.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator) != null) {
      HeartAnimator.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator).a(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adpl
 * JD-Core Version:    0.7.0.1
 */