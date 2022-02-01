import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class ahvs
  implements Animation.AnimationListener
{
  ahvs(ahvr paramahvr, float paramFloat) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ayxi.a("PhotoListPanel", "DragHandler", " flyOutAnimation End fAnimLayout:" + this.jdField_a_of_type_Ahvr.jdField_a_of_type_AndroidWidgetRelativeLayout + ",## dy = " + (this.jdField_a_of_type_Float - this.jdField_a_of_type_Ahvr.jdField_a_of_type_Ahvq.b));
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Ahvr.c.getLayoutParams();
    paramAnimation.topMargin = this.jdField_a_of_type_Ahvr.d.topMargin;
    this.jdField_a_of_type_Ahvr.c.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_Ahvr.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramAnimation = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, this.jdField_a_of_type_Ahvr.c.getWidth() / 2, this.jdField_a_of_type_Ahvr.c.getHeight() / 2);
    paramAnimation.addAnimation(this.jdField_a_of_type_Ahvr.b);
    paramAnimation.addAnimation(localScaleAnimation);
    paramAnimation.setDuration(200L);
    this.jdField_a_of_type_Ahvr.c.startAnimation(paramAnimation);
    ayxi.a("PhotoListPanel", "DragHandler", "startReemergeAnimation fAnimLayout:" + this.jdField_a_of_type_Ahvr.jdField_a_of_type_AndroidWidgetRelativeLayout);
    paramAnimation.setAnimationListener(this.jdField_a_of_type_Ahvr.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    ayxi.a("PhotoListPanel", "DragHandler", "@#flyOutAnimation, onAnimationStart ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvs
 * JD-Core Version:    0.7.0.1
 */