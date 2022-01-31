import android.os.Bundle;
import android.os.Handler;
import mqq.observer.BusinessObserver;

class aesi
  implements BusinessObserver
{
  aesi(aerv paramaerv) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aesi
 * JD-Core Version:    0.7.0.1
 */