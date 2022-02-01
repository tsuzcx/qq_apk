import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import com.tencent.widget.RoundRectImageView;

class ahuy
  implements Animation.AnimationListener
{
  ahuy(ahux paramahux) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, this.a.jdField_a_of_type_ComTencentWidgetRoundRectImageView.getWidth() / 2, this.a.jdField_a_of_type_ComTencentWidgetRoundRectImageView.getHeight() / 2);
    paramAnimation.addAnimation(this.a.b);
    paramAnimation.addAnimation(localScaleAnimation);
    paramAnimation.setDuration(200L);
    this.a.jdField_a_of_type_ComTencentWidgetRoundRectImageView.startAnimation(paramAnimation);
    paramAnimation.setAnimationListener(this.a.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuy
 * JD-Core Version:    0.7.0.1
 */