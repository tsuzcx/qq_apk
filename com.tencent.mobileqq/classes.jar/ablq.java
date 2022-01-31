import android.media.MediaPlayer;
import android.media.SoundPool;
import com.tencent.mobileqq.armap.Sound;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ablq
  implements Runnable
{
  public ablq(Sound paramSound) {}
  
  public void run()
  {
    try
    {
      Sound.a(this.a).stop();
      Iterator localIterator = Sound.a(this.a).entrySet().iterator();
      while (localIterator.hasNext())
      {
        ablr localablr = (ablr)((Map.Entry)localIterator.next()).getValue();
        if (localablr != null) {
          Sound.a(this.a).stop(localablr.a);
        }
      }
      Sound.a(this.a).release();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Sound", 2, "release exception", localException);
      }
      return;
    }
    Sound.a(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ablq
 * JD-Core Version:    0.7.0.1
 */