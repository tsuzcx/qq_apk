import android.os.Handler;
import android.os.Looper;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.CheckListener;
import java.util.List;

public final class adtx
  implements Runnable
{
  public adtx(String paramString, GroupVideoManager.CheckListener paramCheckListener) {}
  
  public void run()
  {
    try
    {
      List localList = GroupVideoManager.a().getCachedLatestPlugin(this.jdField_a_of_type_JavaLangString);
      new Handler(Looper.getMainLooper()).post(new adty(this, localList));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtx
 * JD-Core Version:    0.7.0.1
 */