import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class ainf
  implements Runnable
{
  public ainf(ConfigSetting paramConfigSetting, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get();
    int j = this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.a.getPreferences().getInt("teamwork_tips_version", 0);
    if (QLog.isColorLevel()) {
      QLog.i("ConfigSetting", 1, "updateConfig, new Ver[" + i + "], local Ver[" + j + "]");
    }
    if (i == j)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ConfigSetting", 1, "new Ver[" + i + "] == local Ver[" + j + "]");
      }
      return;
    }
    Object localObject1 = ConfigServlet.a(this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config);
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.a.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.a.getCurrentAccountUin() + "_m_str_teamwork_tips_sp", 0).edit();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      localEditor.clear().commit();
      return;
    }
    Object localObject3 = (String)((List)localObject1).get(0);
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      QLog.e("ConfigSetting", 1, "recv config content is empty!");
      return;
    }
    if (QLog.isDebugVersion())
    {
      if (localObject3 == null)
      {
        localObject1 = "";
        QLog.d("ConfigSetting", 2, new Object[] { "updateConfig json content: ", localObject1 });
      }
    }
    else {
      try
      {
        localObject1 = new JSONObject((String)localObject3);
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConfigSetting", 2, "updateConfig json parse faild");
          }
          localEditor.clear().commit();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ConfigSetting", 2, localException.toString());
        localException.printStackTrace();
      }
    }
    Object localObject2;
    do
    {
      localEditor.commit();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.a.getPreferences().edit().putInt("teamwork_tips_version", i).commit();
      return;
      localObject2 = localObject3;
      break;
      localObject3 = ((JSONObject)localObject2).optJSONObject("File");
      ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, ((JSONObject)localObject3).optInt("maxCount"));
      ConfigSetting.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, ((JSONObject)localObject3).optInt("insertDur"));
      localEditor.putInt("file_str_key_max_count", ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting));
      localEditor.putInt("file_str_key_insert_dur", ConfigSetting.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting));
      Object localObject4 = ((JSONObject)localObject3).optJSONObject("fileType");
      Object localObject5 = new StringBuilder();
      Object localObject6 = ((JSONObject)localObject4).keys();
      ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, "");
      Object localObject7;
      String str;
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (String)((Iterator)localObject6).next();
        ((StringBuilder)localObject5).append((String)localObject7).append("|");
        str = ((JSONObject)localObject4).getString((String)localObject7);
        localEditor.putString("fileType_" + (String)localObject7, str);
        ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting) + str + "|");
        aini localaini = new aini(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, null);
        localaini.jdField_b_of_type_ArrayOfJavaLangString = ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, str);
        ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting).put(localObject7, localaini);
      }
      if (ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting).length() > 0) {
        ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting).substring(0, ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting).length() - 1));
      }
      if (((StringBuilder)localObject5).length() > 0) {
        ((StringBuilder)localObject5).deleteCharAt(((StringBuilder)localObject5).length() - 1);
      }
      localEditor.putString("file_str_key_file_type", ((StringBuilder)localObject5).toString());
      localObject4 = ((JSONObject)localObject3).optJSONObject("Similarity");
      ConfigSetting.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, ((JSONObject)localObject4).optInt("durTime"));
      ConfigSetting.d(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, ((JSONObject)localObject4).optInt("maxQuery"));
      ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, ((JSONObject)localObject4).getDouble("Percentage"));
      ConfigSetting.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, ((JSONObject)localObject4).optString("Tips"));
      ConfigSetting.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, ((JSONObject)localObject4).optString("Link"));
      localEditor.putInt("sim_str_key_dur_time", ConfigSetting.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting));
      localEditor.putInt("sim_str_key_max_query", ConfigSetting.d(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting));
      localEditor.putFloat("sim_str_key_percentage", (float)ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting));
      localEditor.putString("sim_str_key_tips", ConfigSetting.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting));
      localEditor.putString("sim_str_key_link", ConfigSetting.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting));
      localObject3 = ((JSONObject)localObject3).optJSONObject("KeyWords");
      localObject4 = ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting).keySet().iterator();
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        localObject6 = ((JSONObject)localObject3).optJSONObject((String)localObject5);
        localObject7 = (aini)ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting).get(localObject5);
        str = ((JSONObject)localObject6).optString("key");
        ((aini)localObject7).jdField_a_of_type_ArrayOfJavaLangString = ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, str);
        if (ConfigSetting.e(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting) == 1) {
          ((aini)localObject7).jdField_a_of_type_JavaLangString = ((JSONObject)localObject6).optString("Tips1");
        }
        for (((aini)localObject7).jdField_b_of_type_JavaLangString = ((JSONObject)localObject6).optString("Link1");; ((aini)localObject7).jdField_b_of_type_JavaLangString = ((JSONObject)localObject6).optString("Link0"))
        {
          ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting).put(localObject5, localObject7);
          localEditor.putString("key_str_key_words" + (String)localObject5, str);
          localEditor.putString("key_str_key_tips" + (String)localObject5, ((aini)localObject7).jdField_a_of_type_JavaLangString);
          localEditor.putString("key_str_key_link" + (String)localObject5, ((aini)localObject7).jdField_b_of_type_JavaLangString);
          break;
          ((aini)localObject7).jdField_a_of_type_JavaLangString = ((JSONObject)localObject6).optString("Tips0");
        }
      }
      localObject2 = ((JSONObject)localObject2).optJSONObject("Text");
    } while (localObject2 == null);
    localEditor.putString("text_str_templates", ((JSONObject)localObject2).toString());
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting;
    if (((JSONObject)localObject2).optInt("textSwitch", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ConfigSetting.a((ConfigSetting)localObject3, bool);
      localEditor.putBoolean("text_bool_switch", ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting));
      ConfigSetting.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting, (JSONObject)localObject2, localEditor);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainf
 * JD-Core Version:    0.7.0.1
 */