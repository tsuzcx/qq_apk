import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class agqp
  implements Animation.AnimationListener
{
  agqp(agqn paramagqn, agqr paramagqr, CharSequence paramCharSequence) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Agqr.d.setText(this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_Agqr.d.startAnimation(this.jdField_a_of_type_Agqn.a);
    this.jdField_a_of_type_Agqr.a.requestLayout();
    this.jdField_a_of_type_Agqr.g = 0;
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Agqr.a.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.jdField_a_of_type_Agqr.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Agqr.g = 0;
    this.jdField_a_of_type_Agqr.d.startAnimation(this.jdField_a_of_type_Agqn.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqp
 * JD-Core Version:    0.7.0.1
 */