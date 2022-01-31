import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public final class akoe
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface;
    if ((BaseApplicationImpl.getApplication().waitAppRuntime(null) instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null);
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      return true;
      QQToast.a(localQQAppInterface.getApplication(), "个性化缓存清除完毕", 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), "个性化素材检查流程异常，请检查是否扫描正确二维码", 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), "配置文件下载失败", 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), "个性化缓存清除开始", 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akoe
 * JD-Core Version:    0.7.0.1
 */