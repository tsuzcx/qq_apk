import android.annotation.TargetApi;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;

class aljh
  implements AudioManager.OnAudioFocusChangeListener
{
  aljh(alje paramalje) {}
  
  @TargetApi(8)
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "focusChange:" + paramInt + " _focusSteamType:" + this.a.c + " currMode:" + this.a.b.jdField_a_of_type_AndroidMediaAudioManager.getMode() + " _activeMode:" + this.a.b.jdField_a_of_type_Int);
    }
    if (paramInt == -1) {}
    while ((paramInt == -2) || (paramInt == -3) || (paramInt != 1)) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aljh
 * JD-Core Version:    0.7.0.1
 */