import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class akfj
  implements Animation.AnimationListener
{
  public akfj(SpecailCareListActivity paramSpecailCareListActivity, akfw paramakfw, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Akfw.a.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(1, 2131367819);
    paramAnimation.addRule(10);
    paramAnimation.setMargins(0, (int)(10.0F * SpecailCareListActivity.h(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), this.jdField_a_of_type_Int, 0);
    this.jdField_a_of_type_Akfw.a.setLayoutParams(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfj
 * JD-Core Version:    0.7.0.1
 */