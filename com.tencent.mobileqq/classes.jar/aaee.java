import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.mobileqq.ar.ARMusicController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

public class aaee
  implements SoundPool.OnLoadCompleteListener
{
  public aaee(ARMusicController paramARMusicController) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {}
    try
    {
      QLog.e("ARMusicController", 2, "load fire music failed. id=" + paramInt1);
      return;
    }
    catch (Exception paramSoundPool)
    {
      paramSoundPool.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMusicController", 2, "load fire music success. id=" + paramInt1);
    }
    ARMusicController.a(this.a).add(Integer.valueOf(paramInt1));
    if (ARMusicController.b(this.a).contains(Integer.valueOf(paramInt1)))
    {
      paramSoundPool.play(paramInt1, 1.0F, 1.0F, 1, 0, 1.0F);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaee
 * JD-Core Version:    0.7.0.1
 */