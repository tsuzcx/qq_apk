import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class aeci
  implements Animation.AnimationListener
{
  aeci(aecg paramaecg, aeck paramaeck, CharSequence paramCharSequence) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Aeck.d.setText(this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_Aeck.d.startAnimation(this.jdField_a_of_type_Aecg.a);
    this.jdField_a_of_type_Aeck.a.requestLayout();
    this.jdField_a_of_type_Aeck.g = 0;
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Aeck.a.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.jdField_a_of_type_Aeck.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Aeck.g = 0;
    this.jdField_a_of_type_Aeck.d.startAnimation(this.jdField_a_of_type_Aecg.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeci
 * JD-Core Version:    0.7.0.1
 */