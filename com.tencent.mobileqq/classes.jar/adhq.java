import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LoginInfoActivity;

public class adhq
  implements Animation.AnimationListener
{
  public adhq(LoginInfoActivity paramLoginInfoActivity, boolean paramBoolean, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    LoginInfoActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).setVisibility(4);
    LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).clearAnimation();
    LoginInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhq
 * JD-Core Version:    0.7.0.1
 */