import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class akfl
  implements Animation.AnimationListener
{
  public akfl(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.leftView.clearAnimation();
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
    this.a.leftView.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.a.rightViewText.setClickable(true);
    this.a.rightViewText.setText(SpecailCareListActivity.jdField_a_of_type_JavaLangString);
    this.a.rightViewText.setContentDescription(alud.a(2131714655));
    this.a.c = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfl
 * JD-Core Version:    0.7.0.1
 */