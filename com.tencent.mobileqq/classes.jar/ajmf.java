import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager.LoadResourceCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class ajmf
  extends DownloadListener
{
  public ajmf(RobotResourcesManager paramRobotResourcesManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.a().getString("resId");
    if (QLog.isColorLevel()) {
      QLog.d("Q.robot.RobotResourcesManager", 2, "onDown task; errCode = " + paramDownloadTask.a + " url = " + paramDownloadTask.c);
    }
    RobotResourcesManager.LoadResourceCallback localLoadResourceCallback = (RobotResourcesManager.LoadResourceCallback)this.a.b.get(str);
    if (paramDownloadTask.a == 0)
    {
      paramDownloadTask = new File(this.a.b(str));
      if (!paramDownloadTask.exists()) {
        break label234;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        FileUtils.a(paramDownloadTask.getAbsolutePath(), AppConstants.cd, false);
        i = 1;
        if (i != 0)
        {
          this.a.a.put(str, Integer.valueOf(3));
          if (localLoadResourceCallback != null) {
            localLoadResourceCallback.a(0);
          }
          this.a.b.remove(str);
          return;
        }
      }
      catch (Exception paramDownloadTask)
      {
        paramDownloadTask = paramDownloadTask;
        paramDownloadTask.printStackTrace();
        return;
      }
      finally {}
      this.a.a.put(str, Integer.valueOf(4));
      if (localLoadResourceCallback != null)
      {
        localLoadResourceCallback.a(-1);
        continue;
        this.a.a.put(str, Integer.valueOf(4));
        if (localLoadResourceCallback != null)
        {
          localLoadResourceCallback.a(-1);
          continue;
          label234:
          i = 0;
        }
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmf
 * JD-Core Version:    0.7.0.1
 */