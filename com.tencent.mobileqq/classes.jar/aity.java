import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;

public class aity
  implements Animation.AnimationListener
{
  public aity(AudioRecordFragment paramAudioRecordFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    this.a.jdField_b_of_type_AndroidViewView.setBackgroundColor(1291845632);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aity
 * JD-Core Version:    0.7.0.1
 */