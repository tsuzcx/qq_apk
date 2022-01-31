import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;

public class aeqt
  implements Animation.AnimationListener
{
  public aeqt(ChooseInterestTagActivity paramChooseInterestTagActivity, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ChooseInterestTagActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity).postDelayed(new aequ(this), 100L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeqt
 * JD-Core Version:    0.7.0.1
 */