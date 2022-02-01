import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class ahub
  implements Animation.AnimationListener
{
  ahub(ahtz paramahtz, ahud paramahud, CharSequence paramCharSequence) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Ahud.d.setText(this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_Ahud.d.startAnimation(this.jdField_a_of_type_Ahtz.a);
    this.jdField_a_of_type_Ahud.a.requestLayout();
    this.jdField_a_of_type_Ahud.g = 0;
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Ahud.a.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.jdField_a_of_type_Ahud.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Ahud.g = 0;
    this.jdField_a_of_type_Ahud.d.startAnimation(this.jdField_a_of_type_Ahtz.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahub
 * JD-Core Version:    0.7.0.1
 */