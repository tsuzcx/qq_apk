import android.os.AsyncTask;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class abft
  implements Animation.AnimationListener
{
  public abft(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.execute(new Void[0]);
    this.a.f = false;
    if (this.a.d) {
      this.a.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    while (this.a.jdField_c_of_type_Boolean) {
      return;
    }
    this.a.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abft
 * JD-Core Version:    0.7.0.1
 */