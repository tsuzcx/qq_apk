import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
import com.tencent.sharp.jni.TraeMediaPlayer.OnCompletionListener;
import java.util.TimerTask;

public class aljn
  extends TimerTask
{
  public aljn(TraeMediaPlayer paramTraeMediaPlayer, long paramLong) {}
  
  public void run()
  {
    if (TraeMediaPlayer.a(this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeMediaPlay", 1, "playRing, onCompletion, seq[" + this.jdField_a_of_type_Long + "]");
      }
      if (TraeMediaPlayer.a(this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer) != null) {
        TraeMediaPlayer.a(this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aljn
 * JD-Core Version:    0.7.0.1
 */