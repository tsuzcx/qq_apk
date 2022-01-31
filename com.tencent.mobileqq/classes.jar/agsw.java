import android.media.AudioRecord;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture.AudioCaptureListener;
import com.tencent.qphone.base.util.QLog;

public class agsw
  implements Runnable
{
  public agsw(AudioCapture paramAudioCapture) {}
  
  public void run()
  {
    try
    {
      if (this.a.a != null) {
        return;
      }
      AudioCapture.a(this.a);
      this.a.a = new AudioRecord(AudioCapture.a(this.a), AudioCapture.b(this.a), AudioCapture.c(this.a), AudioCapture.d(this.a), this.a.e);
      try
      {
        this.a.a.startRecording();
        this.a.a(true);
        if (AudioCapture.a(this.a) != null) {
          AudioCapture.a(this.a).d();
        }
        if ((this.a.a.getState() == 0) && (AudioCapture.a(this.a) != null))
        {
          AudioCapture.a(this.a).b(-4);
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        QLog.e("AudioCapture", 2, localIllegalStateException, new Object[0]);
      }
      return;
    }
    catch (Exception localException1)
    {
      try
      {
        this.a.a.release();
        if (AudioCapture.a(this.a) != null)
        {
          AudioCapture.a(this.a).b(-4);
          return;
          localException1 = localException1;
          QLog.e("AudioCapture", 2, localException1, new Object[0]);
          if (AudioCapture.a(this.a) != null)
          {
            AudioCapture.a(this.a).b(-4);
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agsw
 * JD-Core Version:    0.7.0.1
 */