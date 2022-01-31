import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.NewRuntime;

public class aifl
  implements Runnable
{
  public aifl(NewRuntime paramNewRuntime) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_hack_dvm", 4);
    if (NewRuntime.b == 15) {
      localSharedPreferences.edit().putInt("key_continuous_crash_count", 0);
    }
    localSharedPreferences.edit().putLong("key_last_hack_verify_time", 0L).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aifl
 * JD-Core Version:    0.7.0.1
 */