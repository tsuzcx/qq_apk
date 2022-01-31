import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

public class ackw
  implements Animation.AnimationListener
{
  public ackw(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new AlphaAnimation(0.2F, 0.0F);
    paramAnimation.setDuration(500L);
    paramAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ackw
 * JD-Core Version:    0.7.0.1
 */