import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;

class akmr
  implements Animation.AnimationListener
{
  akmr(akmq paramakmq, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimation.leftMargin = this.jdField_a_of_type_Akmq.e;
    paramAnimation.topMargin = this.jdField_a_of_type_Akmq.f;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Akmq.a = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akmr
 * JD-Core Version:    0.7.0.1
 */