import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqMessageQueue;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

final class ajlq
  implements AbstractUnifiedMonitor.ThreadMonitorCallback
{
  public void onThreadMonitorEnd(int paramInt)
  {
    if (paramInt == 0)
    {
      Looper.getMainLooper().setMessageLogging(null);
      MqqMessageQueue.getSubMainThreadQueue().setMessageLogging(null);
    }
    do
    {
      Object localObject;
      do
      {
        return;
        if (paramInt == 4)
        {
          ThreadManager.getSubThreadLooper().setMessageLogging(null);
          return;
        }
        if (paramInt == 5)
        {
          ThreadManager.getFileThreadLooper().setMessageLogging(null);
          return;
        }
        if (paramInt == 14)
        {
          Looper.getMainLooper().setMessageLogging(null);
          return;
        }
        if (paramInt != 18) {
          break;
        }
        localObject = MsfCore.sCore;
        if (localObject == null)
        {
          QLog.e("AutoMonitor", 1, "msf core hasnot init");
          return;
        }
        localObject = ((MsfCore)localObject).getNetworkHandlerThread();
      } while ((localObject == null) || (((HandlerThread)localObject).getLooper() == null));
      ((HandlerThread)localObject).getLooper().setMessageLogging(null);
      return;
    } while (paramInt != 19);
    Looper.getMainLooper().setMessageLogging(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajlq
 * JD-Core Version:    0.7.0.1
 */