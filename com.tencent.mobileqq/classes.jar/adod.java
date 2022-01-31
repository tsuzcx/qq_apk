import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class adod
  implements Runnable
{
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("module_nearby");
    if ((localObject instanceof NearbyAppInterface))
    {
      localObject = (NearbyProcManager)((NearbyAppInterface)localObject).getManager(213);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NowLiveFragment", 2, "pre login now plugin!");
        }
        ((NearbyProcManager)localObject).d();
      }
    }
    while (!QLog.isColorLevel())
    {
      NowLiveFragment.a(true);
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("NowLiveFragment", 2, "pre login now plugin! err npb null;");
      return;
    }
    QLog.d("NowLiveFragment", 2, "pre login now plugin! err runtime null or wrong! app = " + localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adod
 * JD-Core Version:    0.7.0.1
 */