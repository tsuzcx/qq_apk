import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.RewardNoticeActivity;

class afkt
  implements Animation.AnimationListener
{
  afkt(afks paramafks) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.a.a.b.setVisibility(8);
    this.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.a.a.c();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afkt
 * JD-Core Version:    0.7.0.1
 */