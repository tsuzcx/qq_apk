import android.content.Intent;
import android.net.Uri;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qphone.base.util.BaseApplication;

public final class agev
  implements Runnable
{
  public void run()
  {
    if (AppUtil.a("com.tencent.now"))
    {
      QLog.i("NowAnswerPreloadManager", 3, "openAnswerRoom----NOW APP is Exist, will preload It!");
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("preload://xxx/xx"));
      localIntent.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      return;
    }
    QLog.i("NowAnswerPreloadManager", 3, "openAnswerRoom----NOW APP is not Exist, will preload Plugin!");
    ((NowProxy)((QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null)).getManager(181)).a(BaseApplicationImpl.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agev
 * JD-Core Version:    0.7.0.1
 */