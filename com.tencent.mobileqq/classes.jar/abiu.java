import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager.IAdapter;

public class abiu
  implements SharedPreferencesProxyManager.IAdapter
{
  public abiu(BaseApplicationImpl paramBaseApplicationImpl) {}
  
  public SharedPreferences getSystemSharedPreferences(String paramString, int paramInt)
  {
    return this.a.getSystemSharedPreferences(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abiu
 * JD-Core Version:    0.7.0.1
 */