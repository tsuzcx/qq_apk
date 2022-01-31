import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class ahwo
  implements Animation.AnimationListener
{
  public ahwo(SpecailCareListActivity paramSpecailCareListActivity, ahxh paramahxh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Ahxh.a.getLayoutParams());
    paramAnimation.addRule(15);
    paramAnimation.setMargins((int)(46.0F * SpecailCareListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
    this.jdField_a_of_type_Ahxh.a.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_Ahxh.a.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahwo
 * JD-Core Version:    0.7.0.1
 */