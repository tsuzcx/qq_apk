import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class akaq
  implements Animation.AnimationListener
{
  public akaq(SpecailCareListActivity paramSpecailCareListActivity, akbh paramakbh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Akbh.a.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(1, 2131367808);
    paramAnimation.setMargins(0, (int)(24.0F * SpecailCareListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, 0);
    this.jdField_a_of_type_Akbh.a.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_Akbh.a.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akaq
 * JD-Core Version:    0.7.0.1
 */