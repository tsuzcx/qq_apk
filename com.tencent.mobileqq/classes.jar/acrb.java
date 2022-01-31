import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.qphone.base.util.QLog;

public class acrb
  implements Animation.AnimationListener
{
  public acrb(PressToSpeakPanel paramPressToSpeakPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "startRecord(),onAnimationEnd is called,time is:" + System.currentTimeMillis());
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "startRecord(),onAnimationRepeat is called,time is:" + System.currentTimeMillis());
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "startRecord(),onAnimationStart is called,time is:" + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acrb
 * JD-Core Version:    0.7.0.1
 */