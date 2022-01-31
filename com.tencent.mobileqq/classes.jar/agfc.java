import android.os.Handler;
import android.view.animation.Animation;
import com.tencent.mobileqq.ptt.LSRecordAnimations.LSRecordAnimationCallback;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.qphone.base.util.QLog;

public class agfc
  extends LSRecordAnimations.LSRecordAnimationCallback
{
  public agfc(LSRecordPanel paramLSRecordPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopRecordingBarAnimation onAnimationEnd");
    }
    LSRecordPanel.a(this.a).post(new agfd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agfc
 * JD-Core Version:    0.7.0.1
 */