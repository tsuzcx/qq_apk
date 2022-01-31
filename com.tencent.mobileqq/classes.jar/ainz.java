import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;

class ainz
  implements SoundPool.OnLoadCompleteListener
{
  ainz(ainx paramainx, float paramFloat, int paramInt, String paramString, aijf paramaijf, long paramLong) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (-1.0F == this.jdField_a_of_type_Float) {}
    for (float f = 1.0F;; f = this.jdField_a_of_type_Float)
    {
      paramInt1 = ainx.a(this.jdField_a_of_type_Ainx).play(paramInt1, f, f, 0, this.jdField_a_of_type_Int, 1.0F);
      if (paramInt1 != 0) {
        break;
      }
      QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "fail to play, musicPath:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    ainx.a(this.jdField_a_of_type_Ainx, this.jdField_a_of_type_Aijf, paramInt1, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ainz
 * JD-Core Version:    0.7.0.1
 */