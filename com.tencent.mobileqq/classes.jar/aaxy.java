import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.troopplugin.PluginJumpManager;

public class aaxy
  implements nmg
{
  public aaxy(PluginJumpManager paramPluginJumpManager) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      nmj.a("urlplugin.cfg", this.a.mContext, "1007", new aaxz(this));
    }
    while (!TextUtils.isEmpty(this.a.mPref.getString("config_file_version", ""))) {
      return;
    }
    this.a.loadConfigFromFile();
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaxy
 * JD-Core Version:    0.7.0.1
 */