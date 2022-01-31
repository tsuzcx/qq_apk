import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;

class aksh
  implements SoundPool.OnLoadCompleteListener
{
  aksh(aksf paramaksf, float paramFloat, int paramInt, String paramString, akni paramakni, long paramLong) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (-1.0F == this.jdField_a_of_type_Float) {}
    for (float f = 1.0F;; f = this.jdField_a_of_type_Float)
    {
      paramInt1 = aksf.a(this.jdField_a_of_type_Aksf).play(paramInt1, f, f, 0, this.jdField_a_of_type_Int, 1.0F);
      if (paramInt1 != 0) {
        break;
      }
      QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "fail to play, musicPath:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    aksf.a(this.jdField_a_of_type_Aksf, this.jdField_a_of_type_Akni, paramInt1, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksh
 * JD-Core Version:    0.7.0.1
 */