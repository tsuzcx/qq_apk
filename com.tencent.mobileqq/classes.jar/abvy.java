import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import com.tencent.mobileqq.businessCard.views.BusinessCardViewScroller;

public class abvy
  extends AnimatorListenerAdapter
{
  public abvy(BusinessCardViewScroller paramBusinessCardViewScroller, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a.removeAllListeners();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvy
 * JD-Core Version:    0.7.0.1
 */