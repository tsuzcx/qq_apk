import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class aebt
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebt
 * JD-Core Version:    0.7.0.1
 */