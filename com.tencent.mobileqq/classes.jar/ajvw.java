import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vashealth.SportManager;

public class ajvw
  implements Runnable
{
  public ajvw(SportManager paramSportManager) {}
  
  public void run()
  {
    if (SportManager.a == null) {
      SportManager.a = (SensorManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("sensor");
    }
    SportManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajvw
 * JD-Core Version:    0.7.0.1
 */