import android.media.SoundPool;
import com.tencent.mobileqq.arcard.ARcardSound;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aauf
  implements Runnable
{
  public aauf(ARcardSound paramARcardSound) {}
  
  public void run()
  {
    try
    {
      if (ARcardSound.a(this.a) != null)
      {
        if (ARcardSound.a(this.a).isPlaying()) {
          ARcardSound.a(this.a).stop();
        }
        ARcardSound.a(this.a).release();
        ARcardSound.a(this.a, null);
      }
      Iterator localIterator = ARcardSound.a(this.a).entrySet().iterator();
      while (localIterator.hasNext())
      {
        aaug localaaug = (aaug)((Map.Entry)localIterator.next()).getValue();
        if (localaaug != null) {
          ARcardSound.a(this.a).stop(localaaug.a);
        }
      }
      ARcardSound.a(this.a).release();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Sound", 2, "release exception", localException);
      }
      return;
    }
    ARcardSound.a(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauf
 * JD-Core Version:    0.7.0.1
 */