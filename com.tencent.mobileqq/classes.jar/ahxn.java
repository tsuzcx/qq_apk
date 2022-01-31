import android.media.MediaPlayer;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

class ahxn
  implements Runnable
{
  ahxn(ahxm paramahxm) {}
  
  public void run()
  {
    try
    {
      if (this.a.a.a != null) {
        this.a.a.a.start();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoSprite", 2, "onCompletion: " + QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahxn
 * JD-Core Version:    0.7.0.1
 */