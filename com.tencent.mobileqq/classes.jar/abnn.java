import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class abnn
  implements BusinessObserver
{
  protected void a() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 10000) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abnn
 * JD-Core Version:    0.7.0.1
 */