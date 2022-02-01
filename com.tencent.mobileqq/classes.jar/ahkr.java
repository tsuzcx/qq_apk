import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class ahkr
  implements Animation.AnimationListener
{
  ahkr(ahkp paramahkp, ahkt paramahkt, CharSequence paramCharSequence) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Ahkt.d.setText(this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_Ahkt.d.startAnimation(this.jdField_a_of_type_Ahkp.a);
    this.jdField_a_of_type_Ahkt.a.requestLayout();
    this.jdField_a_of_type_Ahkt.g = 0;
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Ahkt.a.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.jdField_a_of_type_Ahkt.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Ahkt.g = 0;
    this.jdField_a_of_type_Ahkt.d.startAnimation(this.jdField_a_of_type_Ahkp.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkr
 * JD-Core Version:    0.7.0.1
 */