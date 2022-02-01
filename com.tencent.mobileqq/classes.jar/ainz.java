import android.os.Bundle;
import android.os.Handler;
import mqq.observer.BusinessObserver;

class ainz
  implements BusinessObserver
{
  ainz(ainh paramainh) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramInt = paramBundle.getInt("update_type");
      if (paramInt != 2) {}
    }
    else
    {
      return;
    }
    if (paramInt == 1) {}
    this.a.a.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainz
 * JD-Core Version:    0.7.0.1
 */