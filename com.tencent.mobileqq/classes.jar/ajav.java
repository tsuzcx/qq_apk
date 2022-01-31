import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.SoundPool;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

public class ajav
  implements ajay
{
  private int jdField_a_of_type_Int = 1;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LRULinkedHashMap(20));
  private int b;
  
  public ajav(int paramInt)
  {
    QLog.i("cmgame_process.CmGameSoudPoolPlayer", 1, "[CmGameSoudPoolPlayer]");
    this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(20, 3, 0);
    this.b = paramInt;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ajae.a();
    this.jdField_a_of_type_AndroidContentSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    d();
  }
  
  private void a(aivy paramaivy, int paramInt, long paramLong)
  {
    ApolloCmdChannel localApolloCmdChannel = ajae.a();
    if (localApolloCmdChannel != null) {
      localApolloCmdChannel.playMusicInner(paramaivy, paramInt, paramLong);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    while (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("apollo_game_music_switch" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_" + this.b, 1);
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public int a(aivy paramaivy, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, float paramFloat)
  {
    if ((this.b > 0) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) || (!ajae.d()) || (paramaivy == null)))
    {
      QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "[playMusic], DO NOT play. switch:" + this.jdField_a_of_type_Int);
      return -1;
    }
    label283:
    label330:
    for (Object localObject = null;; localObject = null)
    {
      try
      {
        if ((paramaivy instanceof ApolloSurfaceView)) {
          localObject = ((ApolloSurfaceView)paramaivy).getRender();
        }
        for (;;)
        {
          if (localObject == null) {
            break label330;
          }
          localObject = ((ApolloRender)localObject).getRscPath(paramString, "mp3");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "audioPath is null.");
          return -1;
          if ((paramaivy instanceof ApolloTextureView)) {
            localObject = ((ApolloTextureView)paramaivy).getRender();
          }
        }
        if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
          break label283;
        }
      }
      catch (Throwable paramaivy)
      {
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramaivy, new Object[0]);
        return -1;
      }
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new ajax(this, paramFloat, paramInt2, paramString, paramaivy, paramLong));
        paramString = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localObject);
        if (paramString != null) {
          if (-1.0F == paramFloat)
          {
            paramFloat = 1.0F;
            paramInt1 = this.jdField_a_of_type_AndroidMediaSoundPool.play(paramString.intValue(), paramFloat, paramFloat, 0, paramInt2, 1.0F);
            if (paramInt1 != 0) {
              a(paramaivy, paramInt1, paramLong);
            }
          }
        }
        for (;;)
        {
          return 0;
          break;
          paramInt1 = this.jdField_a_of_type_AndroidMediaSoundPool.load((String)localObject, 1);
          this.jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(paramInt1));
        }
      }
      paramaivy = new StringBuilder().append("pool or cache is null ");
      if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, bool);
        break;
      }
    }
  }
  
  public int a(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSoudPoolPlayer", 2, new Object[] { "[getMusicSwitch], gameId:", Integer.valueOf(this.b) });
    }
    d();
    return this.jdField_a_of_type_Int;
  }
  
  public JSONObject a(ajbo paramajbo, JSONObject paramJSONObject)
  {
    if ((this.b > 0) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) || (!ajae.d())))
    {
      QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "[playMusic], DO NOT play. switch:" + this.jdField_a_of_type_Int);
      return paramJSONObject;
    }
    JSONObject localJSONObject;
    int i;
    String str2;
    float f;
    String str1;
    if (paramJSONObject != null) {
      try
      {
        localJSONObject = new JSONObject(paramJSONObject.toString());
        paramJSONObject.optInt("type");
        i = paramJSONObject.optInt("loop");
        str2 = paramJSONObject.optString("src");
        f = (float)paramJSONObject.optDouble("volume");
        str1 = aiyg.a(str2, this.b, "", false);
        if (!TextUtils.isEmpty(str1)) {
          break label151;
        }
        QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "audioPath is null.");
        return paramJSONObject;
      }
      catch (Throwable paramajbo)
      {
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramajbo, new Object[0]);
      }
    } else {
      return null;
    }
    label151:
    if ((this.jdField_a_of_type_AndroidMediaSoundPool != null) && (this.jdField_a_of_type_JavaUtilMap != null))
    {
      this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new ajaw(this, f, i, str2, paramajbo, localJSONObject));
      paramJSONObject = (Integer)this.jdField_a_of_type_JavaUtilMap.get(str1);
      if (paramJSONObject != null)
      {
        if (-1.0F != f) {
          break label357;
        }
        f = 1.0F;
      }
    }
    label357:
    for (;;)
    {
      for (;;)
      {
        i = this.jdField_a_of_type_AndroidMediaSoundPool.play(paramJSONObject.intValue(), f, f, 0, i, 1.0F);
        if ((i == 0) || (paramajbo == null)) {
          break;
        }
        try
        {
          localJSONObject.put("id", i);
          paramajbo.a(localJSONObject);
        }
        catch (Throwable paramajbo)
        {
          QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramajbo, new Object[0]);
        }
      }
      break;
      i = this.jdField_a_of_type_AndroidMediaSoundPool.load(str1, 1);
      this.jdField_a_of_type_JavaUtilMap.put(str1, Integer.valueOf(i));
      break;
      paramajbo = new StringBuilder().append("pool or cache is null ");
      if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, bool);
        break;
      }
    }
  }
  
  public JSONObject a(JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_AndroidMediaSoundPool != null) && (paramJSONObject != null) && (paramJSONObject.has("id"))) {
      this.jdField_a_of_type_AndroidMediaSoundPool.unload(paramJSONObject.optInt("id"));
    }
    return paramJSONObject;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
      this.jdField_a_of_type_AndroidMediaSoundPool.autoPause();
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, AppInterface paramAppInterface)
  {
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences == null) || (paramAppInterface == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("apollo_game_music_switch" + paramAppInterface.getCurrentAccountUin() + "_" + this.b, paramInt).commit();
    if (paramInt == 0) {
      a();
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
      this.jdField_a_of_type_AndroidMediaSoundPool.pause(paramInt);
    }
  }
  
  public int b(int paramInt)
  {
    return 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
      this.jdField_a_of_type_AndroidMediaSoundPool.autoResume();
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
      this.jdField_a_of_type_AndroidMediaSoundPool.resume(paramInt);
    }
  }
  
  public void c()
  {
    QLog.i("cmgame_process.CmGameSoudPoolPlayer", 1, "[onDestroy]");
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      this.jdField_a_of_type_AndroidMediaSoundPool = null;
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
      this.jdField_a_of_type_AndroidMediaSoundPool.stop(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajav
 * JD-Core Version:    0.7.0.1
 */