import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class agdl
  implements Animation.AnimationListener
{
  agdl(agdj paramagdj, agdn paramagdn, CharSequence paramCharSequence) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Agdn.d.setText(this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_Agdn.d.startAnimation(this.jdField_a_of_type_Agdj.a);
    this.jdField_a_of_type_Agdn.a.requestLayout();
    this.jdField_a_of_type_Agdn.g = 0;
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Agdn.a.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.jdField_a_of_type_Agdn.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Agdn.g = 0;
    this.jdField_a_of_type_Agdn.d.startAnimation(this.jdField_a_of_type_Agdj.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdl
 * JD-Core Version:    0.7.0.1
 */