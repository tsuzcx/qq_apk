import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vashealth.SportManager;
import mqq.observer.BusinessObserver;

public class ajvy
  implements BusinessObserver
{
  public ajvy(SportManager paramSportManager) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      ThreadManager.post(new ajvz(this, paramBundle.getString("StepInfoJSON")), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajvy
 * JD-Core Version:    0.7.0.1
 */