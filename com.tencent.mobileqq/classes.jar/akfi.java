import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class akfi
  implements Animation.AnimationListener
{
  public akfi(SpecailCareListActivity paramSpecailCareListActivity, akfw paramakfw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Akfw.a.getLayoutParams());
    paramAnimation.addRule(15);
    paramAnimation.setMargins((int)(12.0F * SpecailCareListActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
    this.jdField_a_of_type_Akfw.a.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_Akfw.a.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfi
 * JD-Core Version:    0.7.0.1
 */