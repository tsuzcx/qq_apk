import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class ahwu
  implements Animation.AnimationListener
{
  public ahwu(SpecailCareListActivity paramSpecailCareListActivity, ahxh paramahxh, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Ahxh.a.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(1, 2131302061);
    paramAnimation.addRule(10);
    paramAnimation.setMargins(0, (int)(10.0F * SpecailCareListActivity.h(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), this.jdField_a_of_type_Int, 0);
    this.jdField_a_of_type_Ahxh.a.setLayoutParams(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahwu
 * JD-Core Version:    0.7.0.1
 */