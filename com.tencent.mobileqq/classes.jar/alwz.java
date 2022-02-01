import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;

public class alwz
  implements Animation.AnimationListener
{
  public alwz(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0.0F);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setAnimation(this.a.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    paramAnimation = (FrameLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramAnimation.setMargins(0, 0, 0, this.a.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight());
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramAnimation);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwz
 * JD-Core Version:    0.7.0.1
 */