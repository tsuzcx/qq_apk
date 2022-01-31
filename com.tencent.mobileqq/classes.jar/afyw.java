import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class afyw
  implements Animation.AnimationListener
{
  afyw(afyu paramafyu, afyy paramafyy, CharSequence paramCharSequence) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Afyy.d.setText(this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_Afyy.d.startAnimation(this.jdField_a_of_type_Afyu.a);
    this.jdField_a_of_type_Afyy.a.requestLayout();
    this.jdField_a_of_type_Afyy.g = 0;
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Afyy.a.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.jdField_a_of_type_Afyy.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Afyy.g = 0;
    this.jdField_a_of_type_Afyy.d.startAnimation(this.jdField_a_of_type_Afyu.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyw
 * JD-Core Version:    0.7.0.1
 */