import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class aksg
  implements SoundPool.OnLoadCompleteListener
{
  aksg(aksf paramaksf, float paramFloat, int paramInt, String paramString, aksy paramaksy, JSONObject paramJSONObject) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    float f = 1.0F;
    if (aksf.a(this.jdField_a_of_type_Aksf) != null)
    {
      try
      {
        if (-1.0F == this.jdField_a_of_type_Float) {}
        for (;;)
        {
          paramInt1 = aksf.a(this.jdField_a_of_type_Aksf).play(paramInt1, f, f, 0, this.jdField_a_of_type_Int, 1.0F);
          if (paramInt1 != 0) {
            break;
          }
          QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "fail to play, musicPath:" + this.jdField_a_of_type_JavaLangString);
          return;
          f = this.jdField_a_of_type_Float;
        }
        paramSoundPool = this.jdField_a_of_type_Aksy;
        if (paramSoundPool == null) {
          break label159;
        }
        try
        {
          if (this.jdField_a_of_type_OrgJsonJSONObject != null)
          {
            this.jdField_a_of_type_OrgJsonJSONObject.put("id", paramInt1);
            this.jdField_a_of_type_Aksy.a(this.jdField_a_of_type_OrgJsonJSONObject);
            return;
          }
        }
        catch (Throwable paramSoundPool)
        {
          QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramSoundPool, new Object[0]);
          return;
        }
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, "result is null");
      }
      catch (Throwable paramSoundPool)
      {
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, "pool play failed", paramSoundPool);
        return;
      }
      return;
      label159:
      QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, "handler is null");
      return;
    }
    QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, "soundpool is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksg
 * JD-Core Version:    0.7.0.1
 */