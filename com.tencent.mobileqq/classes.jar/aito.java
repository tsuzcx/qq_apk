import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class aito
  implements Runnable
{
  aito(aitn paramaitn, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    ChatBackgroundManager localChatBackgroundManager;
    SharedPreferences localSharedPreferences;
    String str;
    if ("202".equals(this.jdField_a_of_type_Aitn.a.c))
    {
      localChatBackgroundManager = (ChatBackgroundManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(62);
      localSharedPreferences = this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences("theme_background_path_" + this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), 0);
      if (!"1103".equals(this.jdField_a_of_type_Aitn.a.a)) {
        break label417;
      }
      str = localChatBackgroundManager.b(null);
      localSharedPreferences.edit().putString("theme_bg_record_for_night_mode", str).putString("series_id_record_for_night_mode", ThemeUtil.getUinThemePreferences(this.jdField_a_of_type_MqqAppAppRuntime).getString("seriesID", "")).commit();
      localChatBackgroundManager.a(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), null, "null");
    }
    for (;;)
    {
      if (!"200".equals(this.jdField_a_of_type_Aitn.a.c))
      {
        int i = ThemeUtil.getErrorThemeId(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), this.jdField_a_of_type_Aitn.a.a);
        if (i > 0)
        {
          QLog.d("ThemeSwitchManager", 1, "onPostExecute errTime > 0 errTime:" + i + ", change to themeId=" + this.jdField_a_of_type_Aitn.a.a + ", mVersion=" + this.jdField_a_of_type_Aitn.a.b + ", mFrom:" + this.jdField_a_of_type_Aitn.a.c);
          if (i / 100000 == Integer.parseInt("3")) {
            ThemeUtil.setErrorThemeId(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), this.jdField_a_of_type_Aitn.a.a, true);
          }
          ((ThemeHandler)((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).a(14)).a(this.jdField_a_of_type_Aitn.a.a, this.jdField_a_of_type_Aitn.a.b);
        }
      }
      if (!"1000".equals(this.jdField_a_of_type_Aitn.a.a)) {
        ThemeUtil.delOldThemeResDir(this.jdField_a_of_type_Aitn.a.a, this.jdField_a_of_type_Aitn.a.b, ThemeUtil.getThemeResourcePath(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), this.jdField_a_of_type_Aitn.a.a, this.jdField_a_of_type_Aitn.a.b), false);
      }
      return;
      label417:
      str = localSharedPreferences.getString("theme_bg_record_for_night_mode", "null");
      localChatBackgroundManager.a(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), null, str);
      ThemeUtil.getUinThemePreferences(this.jdField_a_of_type_MqqAppAppRuntime).edit().putString("seriesID", localSharedPreferences.getString("series_id_record_for_night_mode", "")).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aito
 * JD-Core Version:    0.7.0.1
 */