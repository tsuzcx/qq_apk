import android.os.Handler;
import android.os.Looper;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.CheckListener;
import java.util.List;

public final class adjy
  implements Runnable
{
  public adjy(String paramString, GroupVideoManager.CheckListener paramCheckListener) {}
  
  public void run()
  {
    try
    {
      List localList = GroupVideoManager.a().getCachedLatestPlugin(this.jdField_a_of_type_JavaLangString);
      new Handler(Looper.getMainLooper()).post(new adjz(this, localList));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adjy
 * JD-Core Version:    0.7.0.1
 */