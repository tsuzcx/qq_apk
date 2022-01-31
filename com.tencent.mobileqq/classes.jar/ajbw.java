import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.utils.FileUtils;
import mqq.app.AppRuntime;

public class ajbw
  implements Runnable
{
  public ajbw(TroopLinkManager paramTroopLinkManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!FileUtils.a(this.jdField_a_of_type_JavaLangString, this.b)) {
      BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("troop_link_config_version", 0).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajbw
 * JD-Core Version:    0.7.0.1
 */