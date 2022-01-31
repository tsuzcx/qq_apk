import android.os.HandlerThread;
import com.tencent.ark.ArkEnvironmentManager.ThreadCreater;
import com.tencent.mobileqq.app.ThreadManager;

final class alvt
  implements ArkEnvironmentManager.ThreadCreater
{
  public HandlerThread createHanderThread(String paramString)
  {
    return ThreadManager.newFreeHandlerThread(paramString, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alvt
 * JD-Core Version:    0.7.0.1
 */