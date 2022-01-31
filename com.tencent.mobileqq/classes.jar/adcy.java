import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class adcy
  implements Runnable
{
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = localAppRuntime;
    if (localAppRuntime != null) {
      localObject = localAppRuntime.getAppRuntime("module_nearby");
    }
    if ((localObject instanceof NearbyAppInterface))
    {
      localObject = (NearbyProcManager)((NearbyAppInterface)localObject).getManager(213);
      if (localObject != null)
      {
        com.tencent.mobileqq.fragment.NearbyHybridFragment.l = true;
        ((NearbyProcManager)localObject).c();
        if (QLog.isColorLevel()) {
          QLog.d("NearbyHybridFragment", 2, "pre load now plugin!");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("NearbyHybridFragment", 2, "pre load now plugin! err npb null;");
      return;
    }
    QLog.d("NearbyHybridFragment", 2, "pre load now plugin! err runtime null or wrong! app = " + localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adcy
 * JD-Core Version:    0.7.0.1
 */