import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;

public class abcb
  implements Runnable
{
  public abcb(DynamicAvatarDownloadManager paramDynamicAvatarDownloadManager, long paramLong) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Long).append("#").append(0);
    BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_avatar", 4).edit().putString("dynamic_load_count_one_day", localStringBuilder.toString()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abcb
 * JD-Core Version:    0.7.0.1
 */