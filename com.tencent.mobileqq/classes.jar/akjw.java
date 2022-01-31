import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class akjw
  implements Animation.AnimationListener
{
  akjw(akjt paramakjt, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView.getTag() instanceof akjz))) {
      ((akjz)this.jdField_a_of_type_AndroidViewView.getTag()).a = true;
    }
    akjt.a(this.jdField_a_of_type_Akjt);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akjw
 * JD-Core Version:    0.7.0.1
 */