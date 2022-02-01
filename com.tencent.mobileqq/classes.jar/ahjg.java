import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class ahjg
  implements Animation.AnimationListener
{
  private ahjf jdField_a_of_type_Ahjf;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private AlphaAnimation b;
  
  ahjg(CharSequence paramCharSequence, ahjf paramahjf, AlphaAnimation paramAlphaAnimation1, AlphaAnimation paramAlphaAnimation2)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_Ahjf = paramahjf;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = paramAlphaAnimation1;
    this.b = paramAlphaAnimation2;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Ahjf.d.setText(this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_Ahjf.d.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_Ahjf.a.requestLayout();
    this.jdField_a_of_type_Ahjf.g = 0;
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Ahjf.a.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.jdField_a_of_type_Ahjf.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Ahjf.g = 0;
    this.jdField_a_of_type_Ahjf.d.startAnimation(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjg
 * JD-Core Version:    0.7.0.1
 */