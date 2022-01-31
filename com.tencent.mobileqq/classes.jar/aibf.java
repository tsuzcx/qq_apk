import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class aibf
  implements Animation.AnimationListener
{
  aibf(aibc paramaibc, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView.getTag() instanceof aibi))) {
      ((aibi)this.jdField_a_of_type_AndroidViewView.getTag()).a = true;
    }
    aibc.a(this.jdField_a_of_type_Aibc);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aibf
 * JD-Core Version:    0.7.0.1
 */