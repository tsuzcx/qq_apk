import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.qphone.base.util.QLog;

class ajak
  implements AudioManager.OnAudioFocusChangeListener
{
  ajak(ajai paramajai) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ajai.a, 2, new Object[] { "[onAudioFocusChange],focusChange:", Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajak
 * JD-Core Version:    0.7.0.1
 */