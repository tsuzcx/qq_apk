import android.media.SoundPool;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class adqy
  extends TimerTask
{
  public adqy(SoundPoolUtil paramSoundPoolUtil, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a.play(this.jdField_a_of_type_Int, 1.0F, 1.0F, 0, 0, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adqy
 * JD-Core Version:    0.7.0.1
 */