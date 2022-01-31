import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.qphone.base.util.QLog;

public class abis
  implements SoundPool.OnLoadCompleteListener
{
  public abis(H5MagicPlayerActivity paramH5MagicPlayerActivity, String paramString) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityH5MagicPlayerActivity.jdField_a_of_type_AndroidMediaSoundPool.play(paramInt1, 1.0F, 1.0F, 0, this.jdField_a_of_type_ComTencentMobileqqActivityH5MagicPlayerActivity.jdField_a_of_type_Int - 1, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abis
 * JD-Core Version:    0.7.0.1
 */