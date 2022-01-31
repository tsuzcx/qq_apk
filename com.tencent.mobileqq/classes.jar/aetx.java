import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aetx
  implements Runnable
{
  public aetx(NearbyAppInterface paramNearbyAppInterface) {}
  
  public void run()
  {
    synchronized (this.a.a)
    {
      boolean bool = this.a.d;
      if (!bool) {}
      try
      {
        DeviceProfileManager.a(this.a, 214).a(this.a);
        this.a.d = true;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyAppInterface", 2, "onDestroy: ", localException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aetx
 * JD-Core Version:    0.7.0.1
 */