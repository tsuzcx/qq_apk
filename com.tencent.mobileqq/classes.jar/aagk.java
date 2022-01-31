import android.media.SoundPool;
import com.tencent.mobileqq.arcard.ARcardSound;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aagk
  implements Runnable
{
  public aagk(ARcardSound paramARcardSound) {}
  
  public void run()
  {
    try
    {
      if (ARcardSound.a(this.a) != null)
      {
        ARcardSound.a(this.a).stop();
        ARcardSound.a(this.a).release();
        ARcardSound.a(this.a, null);
      }
      Iterator localIterator = ARcardSound.a(this.a).entrySet().iterator();
      while (localIterator.hasNext())
      {
        aagl localaagl = (aagl)((Map.Entry)localIterator.next()).getValue();
        if (localaagl != null) {
          ARcardSound.a(this.a).stop(localaagl.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aagk
 * JD-Core Version:    0.7.0.1
 */