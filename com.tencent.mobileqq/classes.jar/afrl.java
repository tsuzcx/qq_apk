import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;

public class afrl
  extends AnimatorListenerAdapter
{
  public afrl(ARTipsManager paramARTipsManager, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).removeView(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afrl
 * JD-Core Version:    0.7.0.1
 */