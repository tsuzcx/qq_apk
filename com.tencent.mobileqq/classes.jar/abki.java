import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class abki
  implements Animation.AnimationListener
{
  abki(abkh paramabkh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (!this.a.jdField_a_of_type_Abjp.d()) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abki
 * JD-Core Version:    0.7.0.1
 */