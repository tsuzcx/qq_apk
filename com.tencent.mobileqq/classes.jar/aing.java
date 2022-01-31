import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class aing
  implements Runnable
{
  public aing(ConfigSetting paramConfigSetting) {}
  
  public void run()
  {
    Object localObject1 = this.a.a.getApp().getSharedPreferences(this.a.a.getCurrentAccountUin() + "_m_str_teamwork_tips_sp", 0);
    ConfigSetting.a(this.a, ((SharedPreferences)localObject1).getInt("file_str_key_max_count", 0));
    Object localObject2 = ConfigSetting.a(this.a, ((SharedPreferences)localObject1).getString("file_str_key_file_type", ""));
    ConfigSetting.a(this.a, "");
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      String str1 = localObject2[i];
      String str2 = ((SharedPreferences)localObject1).getString("fileType_" + str1, "");
      ConfigSetting.a(this.a, ConfigSetting.a(this.a) + str2 + "|");
      aini localaini = new aini(this.a, null);
      localaini.jdField_b_of_type_ArrayOfJavaLangString = ConfigSetting.a(this.a, str2);
      localaini.jdField_a_of_type_ArrayOfJavaLangString = ConfigSetting.a(this.a, ((SharedPreferences)localObject1).getString("key_str_key_words" + str1, ""));
      localaini.jdField_a_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("key_str_key_tips" + str1, "");
      localaini.jdField_b_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("key_str_key_link" + str1, "");
      ConfigSetting.a(this.a).put(str1, localaini);
      i += 1;
    }
    if (ConfigSetting.a(this.a).length() > 0) {
      ConfigSetting.a(this.a, ConfigSetting.a(this.a).substring(0, ConfigSetting.a(this.a).length() - 1));
    }
    ConfigSetting.e(this.a, ((SharedPreferences)localObject1).getInt("file_str_key_words_case", 0));
    ConfigSetting.b(this.a, ((SharedPreferences)localObject1).getInt("file_str_key_insert_dur", 0));
    ConfigSetting.c(this.a, ((SharedPreferences)localObject1).getInt("sim_str_key_dur_time", 0));
    ConfigSetting.d(this.a, ((SharedPreferences)localObject1).getInt("sim_str_key_max_query", 0));
    ConfigSetting.a(this.a, ((SharedPreferences)localObject1).getFloat("sim_str_key_percentage", 0.0F));
    ConfigSetting.b(this.a, ((SharedPreferences)localObject1).getString("sim_str_key_tips", ""));
    ConfigSetting.c(this.a, ((SharedPreferences)localObject1).getString("sim_str_key_link", ""));
    ConfigSetting.f(this.a, ((SharedPreferences)localObject1).getInt("file_str_key_max_count_local", 0));
    localObject2 = ((SharedPreferences)localObject1).getString("text_str_templates", "");
    ConfigSetting.a(this.a, ((SharedPreferences)localObject1).getBoolean("text_bool_switch", false));
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject1 = new JSONObject((String)localObject2);
      ConfigSetting.a(this.a, (JSONObject)localObject1, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ConfigSetting", 2, localJSONException.toString());
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aing
 * JD-Core Version:    0.7.0.1
 */