import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class aeck
  implements Animation.AnimationListener
{
  aeck(aeci paramaeci, aecm paramaecm, CharSequence paramCharSequence) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Aecm.d.setText(this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_Aecm.d.startAnimation(this.jdField_a_of_type_Aeci.a);
    this.jdField_a_of_type_Aecm.a.requestLayout();
    this.jdField_a_of_type_Aecm.g = 0;
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Aecm.a.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.jdField_a_of_type_Aecm.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Aecm.g = 0;
    this.jdField_a_of_type_Aecm.d.startAnimation(this.jdField_a_of_type_Aeci.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeck
 * JD-Core Version:    0.7.0.1
 */