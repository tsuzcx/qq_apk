import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule;
import com.tencent.mobileqq.music.QQPlayerService;

public class aajl
  implements Runnable
{
  public aajl(ArkAppMusicModule paramArkAppMusicModule) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof FragmentActivity)) {
      QQPlayerService.b(localBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajl
 * JD-Core Version:    0.7.0.1
 */