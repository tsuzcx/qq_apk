import android.media.AudioRecord;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture.AudioCaptureListener;
import com.tencent.qphone.base.util.QLog;

public class ahgz
  implements Runnable
{
  public ahgz(AudioCapture paramAudioCapture) {}
  
  public void run()
  {
    if (this.a.a == null) {
      return;
    }
    if (AudioCapture.a(this.a) != null)
    {
      AudioCapture.a(this.a).a = false;
      AudioCapture.a(this.a).b = true;
      AudioCapture.a(this.a).interrupt();
    }
    try
    {
      AudioCapture.a(this.a).join();
    }
    catch (InterruptedException localException1)
    {
      try
      {
        if (AudioCapture.a(this.a) != null) {
          AudioCapture.a(this.a).f();
        }
        this.a.a.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.a.a.release();
            this.a.a = null;
            return;
            localInterruptedException = localInterruptedException;
            localInterruptedException.printStackTrace();
            continue;
            localException1 = localException1;
            QLog.e("AudioCapture", 2, localException1, new Object[0]);
            if (AudioCapture.a(this.a) != null) {
              AudioCapture.a(this.a).b(-5);
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            QLog.e("AudioCapture", 2, localException2, new Object[0]);
            if (AudioCapture.a(this.a) != null) {
              AudioCapture.a(this.a).b(-5);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahgz
 * JD-Core Version:    0.7.0.1
 */