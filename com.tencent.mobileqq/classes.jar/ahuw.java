import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class ahuw
  implements Animation.AnimationListener
{
  ahuw(ahuv paramahuv, float paramFloat) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    azjq.a("PhotoListPanel", "DragHandler", " flyOutAnimation End fAnimLayout:" + this.jdField_a_of_type_Ahuv.jdField_a_of_type_AndroidWidgetRelativeLayout + ",## dy = " + (this.jdField_a_of_type_Float - this.jdField_a_of_type_Ahuv.jdField_a_of_type_Ahuu.b));
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Ahuv.c.getLayoutParams();
    paramAnimation.topMargin = this.jdField_a_of_type_Ahuv.d.topMargin;
    this.jdField_a_of_type_Ahuv.c.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_Ahuv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramAnimation = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, this.jdField_a_of_type_Ahuv.c.getWidth() / 2, this.jdField_a_of_type_Ahuv.c.getHeight() / 2);
    paramAnimation.addAnimation(this.jdField_a_of_type_Ahuv.b);
    paramAnimation.addAnimation(localScaleAnimation);
    paramAnimation.setDuration(200L);
    this.jdField_a_of_type_Ahuv.c.startAnimation(paramAnimation);
    azjq.a("PhotoListPanel", "DragHandler", "startReemergeAnimation fAnimLayout:" + this.jdField_a_of_type_Ahuv.jdField_a_of_type_AndroidWidgetRelativeLayout);
    paramAnimation.setAnimationListener(this.jdField_a_of_type_Ahuv.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    azjq.a("PhotoListPanel", "DragHandler", "@#flyOutAnimation, onAnimationStart ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuw
 * JD-Core Version:    0.7.0.1
 */