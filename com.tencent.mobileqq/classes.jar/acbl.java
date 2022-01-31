import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim;

public class acbl
  implements Animation.AnimationListener
{
  public acbl(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ((Face2FaceAddFriendActivity)this.a.jdField_a_of_type_AndroidContentContext).i();
    this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation = null;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acbl
 * JD-Core Version:    0.7.0.1
 */