import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class aijh
  implements Animation.AnimationListener
{
  public aijh(SpecailCareListActivity paramSpecailCareListActivity, aijz paramaijz, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Aijz.a.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(10);
    paramAnimation.addRule(1, 2131367679);
    paramAnimation.setMargins(0, (int)(22.0F * SpecailCareListActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), (int)(23.0F * SpecailCareListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) + this.jdField_a_of_type_Int), 0);
    this.jdField_a_of_type_Aijz.a.setLayoutParams(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aijh
 * JD-Core Version:    0.7.0.1
 */