import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.webview.WebSecurityPlugin;
import mqq.observer.BusinessObserver;

public class aktz
  implements BusinessObserver
{
  public aktz(WebSecurityPlugin paramWebSecurityPlugin) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.a.a(paramBoolean, paramBundle);
      return;
    }
    this.a.a.post(new akua(this, paramBoolean, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aktz
 * JD-Core Version:    0.7.0.1
 */