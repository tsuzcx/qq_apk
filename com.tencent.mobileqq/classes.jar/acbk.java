import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim;

public class acbk
  implements Animation.AnimationListener
{
  public acbk(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim, int paramInt, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.b;
    ((Face2FaceAddFriendActivity)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acbk
 * JD-Core Version:    0.7.0.1
 */