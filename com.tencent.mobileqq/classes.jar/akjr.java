import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class akjr
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, paramBundle.getInt("msgType", 0), paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akjr
 * JD-Core Version:    0.7.0.1
 */