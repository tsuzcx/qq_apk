import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class alkc
  implements Animation.AnimationListener
{
  alkc(aljz paramaljz, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView.getTag() instanceof alkf))) {
      ((alkf)this.jdField_a_of_type_AndroidViewView.getTag()).a = true;
    }
    aljz.a(this.jdField_a_of_type_Aljz);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkc
 * JD-Core Version:    0.7.0.1
 */