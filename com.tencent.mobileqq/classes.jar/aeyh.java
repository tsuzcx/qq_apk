import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.qphone.base.util.QLog;

public class aeyh
  implements Animation.AnimationListener
{
  public aeyh(PressToSpeakPanel paramPressToSpeakPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "startStartRecordAnim(),onAnimationEnd is called,time is:" + System.currentTimeMillis());
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "startStartRecordAnim(),onAnimationRepeat is called,time is:" + System.currentTimeMillis());
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "startStartRecordAnim(),onAnimationStart is called,time is:" + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyh
 * JD-Core Version:    0.7.0.1
 */