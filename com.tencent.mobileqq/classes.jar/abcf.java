import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.armap.ArMapInterface;

public class abcf
  implements Runnable
{
  public abcf(ArMapInterface paramArMapInterface) {}
  
  public void run()
  {
    synchronized (ArMapInterface.a(this.a))
    {
      boolean bool = ArMapInterface.a(this.a);
      if (!bool) {}
      try
      {
        DeviceProfileManager.a(this.a, 213).a(this.a);
        ArMapInterface.a(this.a, true);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abcf
 * JD-Core Version:    0.7.0.1
 */