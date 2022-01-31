import android.media.MediaPlayer;
import android.media.SoundPool;
import com.tencent.mobileqq.armap.Sound;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class abeq
  implements Runnable
{
  public abeq(Sound paramSound) {}
  
  public void run()
  {
    try
    {
      Sound.a(this.a).stop();
      Iterator localIterator = Sound.a(this.a).entrySet().iterator();
      while (localIterator.hasNext())
      {
        aber localaber = (aber)((Map.Entry)localIterator.next()).getValue();
        if (localaber != null) {
          Sound.a(this.a).stop(localaber.a);
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
 * Qualified Name:     abeq
 * JD-Core Version:    0.7.0.1
 */