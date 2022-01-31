import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.webview.WebSecurityPlugin;
import mqq.observer.BusinessObserver;

public class ajyb
  implements BusinessObserver
{
  public ajyb(WebSecurityPlugin paramWebSecurityPlugin) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.a.a(paramBoolean, paramBundle);
      return;
    }
    this.a.a.post(new ajyc(this, paramBoolean, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajyb
 * JD-Core Version:    0.7.0.1
 */