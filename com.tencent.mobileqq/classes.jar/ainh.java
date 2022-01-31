import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting;
import com.tencent.qphone.base.util.BaseApplication;

public class ainh
  implements Runnable
{
  public ainh(ConfigSetting paramConfigSetting) {}
  
  public void run()
  {
    this.a.a.getApp().getSharedPreferences(this.a.a.getCurrentAccountUin() + "_m_str_teamwork_tips_sp", 0).edit().putInt("file_str_key_max_count_local", ConfigSetting.f(this.a)).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainh
 * JD-Core Version:    0.7.0.1
 */