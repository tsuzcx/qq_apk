import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class abfs
  implements Animation.AnimationListener
{
  public abfs(FriendProfileImageActivity paramFriendProfileImageActivity, TextView paramTextView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abfs
 * JD-Core Version:    0.7.0.1
 */