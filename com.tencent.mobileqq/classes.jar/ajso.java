import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.3.1;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class ajso
  implements INetInfoHandler
{
  ajso(ajsn paramajsn) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    long l = Thread.currentThread().getId();
    if (ajsn.a(this.a) == l) {
      ajsn.a(this.a);
    }
    while (ajsn.a(this.a) == null) {
      return;
    }
    ajsn.a(this.a).post(new LbsFilterStatusManager.3.1(this));
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajso
 * JD-Core Version:    0.7.0.1
 */