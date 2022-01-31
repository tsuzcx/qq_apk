import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class adow
  implements Runnable
{
  adow(adov paramadov) {}
  
  public void run()
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("pic_light_reply_version_new", 0).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adow
 * JD-Core Version:    0.7.0.1
 */