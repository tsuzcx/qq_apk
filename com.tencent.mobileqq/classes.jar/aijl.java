import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class aijl
  implements Animation.AnimationListener
{
  public aijl(SpecailCareListActivity paramSpecailCareListActivity, aijx paramaijx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Aijx.a.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(1, 2131367679);
    paramAnimation.setMargins(0, (int)(36.0F * SpecailCareListActivity.i(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), (int)(30.0F * SpecailCareListActivity.j(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
    this.jdField_a_of_type_Aijx.a.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_Aijx.a.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aijl
 * JD-Core Version:    0.7.0.1
 */