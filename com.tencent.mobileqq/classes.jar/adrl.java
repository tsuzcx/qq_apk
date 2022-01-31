import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class adrl
  implements Animation.AnimationListener
{
  adrl(adrj paramadrj, adrn paramadrn, CharSequence paramCharSequence) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Adrn.d.setText(this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_Adrn.d.startAnimation(this.jdField_a_of_type_Adrj.a);
    this.jdField_a_of_type_Adrn.a.requestLayout();
    this.jdField_a_of_type_Adrn.g = 0;
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Adrn.a.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.jdField_a_of_type_Adrn.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Adrn.g = 0;
    this.jdField_a_of_type_Adrn.d.startAnimation(this.jdField_a_of_type_Adrj.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adrl
 * JD-Core Version:    0.7.0.1
 */