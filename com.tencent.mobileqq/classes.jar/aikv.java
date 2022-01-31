import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppActivity;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;

public class aikv
  implements Manager, BusinessObserver
{
  public static String a;
  private aikw jdField_a_of_type_Aikw;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  public aikv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = BaseApplicationImpl.getContext();
    jdField_a_of_type_JavaLangString = paramQQAppInterface.getFilesDir().getAbsoluteFile() + File.separator + "WeatherResource";
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("weather_resources", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
  }
  
  public long a()
  {
    long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_weather_res_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "getConfigVersion version=" + l);
    }
    return l;
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "updateResourceVersion version=" + paramLong);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_weather_res_version", paramLong).commit();
  }
  
  public void a(aikw paramaikw)
  {
    this.jdField_a_of_type_Aikw = paramaikw;
  }
  
  public void a(AppActivity paramAppActivity)
  {
    if ((ajzt.c()) && (!this.jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("weatherManager", 2, "updateWeatherInfo  from  LocaleManager.isLocaleUpdatedByUser()");
      }
      this.jdField_a_of_type_Boolean = true;
      aikx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAppActivity);
    }
    Long localLong;
    do
    {
      return;
      localLong = Long.valueOf(BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getLong("drawer_last_success_time", 0L));
      if (QLog.isColorLevel()) {
        QLog.d("weatherManager", 2, "updateWeatherInfo successTime:" + localLong + ",currentTime:" + System.currentTimeMillis());
      }
    } while (Math.abs(System.currentTimeMillis() - localLong.longValue()) <= 3600000L);
    aikx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAppActivity);
  }
  
  public boolean a(long paramLong, String paramString)
  {
    boolean bool = true;
    try
    {
      bbdx.a(jdField_a_of_type_JavaLangString, false);
      bbdx.a(paramString, jdField_a_of_type_JavaLangString, false);
      if (bool)
      {
        a(paramLong);
        return bool;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("weatherManager", 2, "pareseRulesFromZip : delete and uncompress Exception=>", paramString);
          }
          bool = false;
        }
      } while (!QLog.isColorLevel());
      QLog.d("weatherManager", 2, "pareseRulesFromZip : delete and uncompressZip failure, parse from Res");
    }
    return bool;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("weatherManager", 2, new Object[] { "WeatherManager onReceive type:" + paramInt, ",bundle:", paramBundle });
      }
    } while ((paramInt != 6666) && (paramInt != 8888));
    int j;
    SharedPreferences.Editor localEditor;
    if (paramBoolean)
    {
      String str1 = paramBundle.getString("KEY_TEMPER");
      String str2 = paramBundle.getString("area_info");
      int i = paramBundle.getInt("adcode");
      String str3 = paramBundle.getString("o_wea_code");
      j = paramBundle.getInt("show_flag");
      if (QLog.isColorLevel()) {
        QLog.d("WeatherSetting", 2, "onReceive show_flag:" + j + ",temp:" + str1 + ",area_name" + str2 + "adcode" + i + ",o_wea_code" + str3);
      }
      localEditor = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).edit();
      if (j != 1) {
        break label421;
      }
      if ((str1 != null) && (!str1.equals("")) && (!TextUtils.isEmpty(str2)))
      {
        Long localLong = Long.valueOf(System.currentTimeMillis());
        localEditor.putLong("pa_send_time", localLong.longValue());
        localEditor.putString("cur_temp", str1);
        localEditor.putString("cur_code", str3);
        localEditor.putString("cur_city", str2);
        localEditor.putInt("cur_adcode", i);
        localEditor.putBoolean("show_flag", true);
        localEditor.putLong("drawer_last_success_time", localLong.longValue());
        localEditor.putString("drawer_cur_city", str2);
        localEditor.putString("drawer_cur_temp", str1);
        localEditor.putInt("drawer_cur_adcode", i);
        localEditor.putString("drawer_cur_code", str3);
        localEditor.putBoolean("drawer_show_flag", true);
      }
    }
    for (;;)
    {
      localEditor.commit();
      if (this.jdField_a_of_type_Aikw == null) {
        break;
      }
      this.jdField_a_of_type_Aikw.a(paramInt, paramBoolean, paramBundle);
      return;
      label421:
      if (j == 0) {
        localEditor.putBoolean("show_flag", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aikv
 * JD-Core Version:    0.7.0.1
 */